import beans.*;
import dao.*;

import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.*;

import java.util.Scanner;

public class MarcarConsulta {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, StandardCharsets.UTF_8);
        StringBuffer lista = new StringBuffer();
        Consulta consulta = new Consulta();

        System.out.println("\nIniciando cadastro da consulta");

        switch (menuPaciente(lista, entrada)) {
            case "1":
                System.out.println("Digite o CPF:");
                consulta.setIdpac(buscarPaciente(entrada.nextLong(), lista));
                lista.setLength(0);
                break;
            case "2":
                System.out.println("Digite dados do paciente");
                Paciente paciente = new Paciente();
                System.out.println("Nome do paciente");
                paciente.setNomep(entrada.nextLine());
                System.out.println("Telefone do paciente");
                paciente.setTelefonepac(entrada.nextLine());
                consulta.setIdpac(cadastrarPaciente(paciente, lista));
                lista.setLength(0);
                break;
            default:
                System.exit(0);
                break;
        }

        switch (menuEspecialidade(lista, entrada)) {
            case "1":
                System.out.println("Digite o nome da especialidade");
                consulta.setIdesp(buscarEspecialidade(entrada.next(), lista));
                lista.setLength(0);
                break;
            case "2":
                System.out.println("Clínico Geral.");
                consulta.setIdesp(buscarEspecialidade("Clinico Geral", lista));
                lista.setLength(0);
                break;
            default:
                System.exit(0);
                break;
        }

        switch (menuMedico(lista, entrada)) {
            case "1":
                System.out.println("Digite o nome COMPLETO do médico");
                consulta.setCrm(buscarCrmMedicoPorNomeEComEspecialidade(entrada.next(), consulta.getIdesp(), lista));
                lista.setLength(0);
                break;
            case "2":
                System.out.println("Escolher médico da lista.");
                consulta.setCrm(buscarCrmMedicoPorNomeEComEspecialidade("", consulta.getIdesp(), lista));
                //consulta.setIdesp(buscarEspecialidade("Clínico Geral", lista));
                lista.setLength(0);
                break;
            default:
                System.exit(0);
                break;
        }

        lista.setLength(0);
        menuAgenda(lista, consulta.getCrm());
        System.out.println(agendarConsulta(consulta, entrada, lista));
        entrada.close();
    }

    private static String menuPaciente(StringBuffer lista, Scanner entrada) {
        lista.append("\nEscolha uma opcao: ")
                .append("\n\t(1) Paciente com cadastro.")
                .append("\n\t(2) Cadastrar paciente.")
                .append("\n\t(S)air")
                .append("\nOpcao: ");

        System.out.print(lista.toString());
        lista.setLength(0);
        return entrada.next();
    }

    private static String menuEspecialidade(StringBuffer lista, Scanner entrada) {
        lista.append("\nEscolha uma opcao: ")
                .append("\n\t(1) Paciente sabe a especialidade.")
                .append("\n\t(2) Clínico Geral.")
                .append("\n\t(S)air")
                .append("\nOpcao: ");

        System.out.print(lista.toString());
        lista.setLength(0);
        return entrada.next();
    }

    private static String menuMedico(StringBuffer lista, Scanner entrada) {
        lista.append("\nEscolha uma opcao: ")
                .append("\n\t(1) Médico de preferência do paciente.")
                .append("\n\t(2) Escolher médico que atende a especialidade da lista.")
                .append("\n\t(S)air")
                .append("\nOpcao: ");

        System.out.print(lista.toString());
        lista.setLength(0);
        return entrada.next();
    }

    private static void menuAgenda(StringBuffer lista, Long CRM) {
        AgendaDao agendaDao = new AgendaDao();
        List<Agenda> list = agendaDao.getAgenda(CRM.longValue());
        for (Agenda agenda : list) {
            lista.append("\n\tAGENDA DO MÉDICO SELECIONADO")
                    .append("\n\tDia da semana: " + agenda.getDiasemana())
                    .append("\n\tInício: " + agenda.getHorainicio(), 0, 15)
                    .append("\n\tFim: " + agenda.getHorafim(), 0, 12)
                    .append("\n\tCRM: " + agenda.getCrm()).append("\n\t-------------------");
        }
        System.out.println(lista);
        lista.setLength(0);
    }

    private static long buscarPaciente(long CPF, StringBuffer lista){
        PacienteDAO pacienteDAO = new PacienteDAO();
        List<Paciente> pacienteList = pacienteDAO.getPaciente(CPF);
        for (Paciente paciente : pacienteList) {
            lista.append("\n\tNúmero Identificador: " + paciente.getId())
                    .append("\n\tNome: " + paciente.getNomep())
                    .append("\n\tTelefone: " + paciente.getTelefonepac())
                    .append("\n\tEndereço: " + paciente.getEndereco())
                    .append("\n\tIdade: " + paciente.getIdade())
                    .append("\n\tSexo: " + paciente.getSexo())
                    .append("\n\t-------------------");
        }
        System.out.println(lista.toString());
        return pacienteList.get(0).getId();
    }

    private static long cadastrarPaciente(Paciente paciente, StringBuffer lista) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        paciente = pacienteDAO.postPaciente(paciente);

        lista.append("\n\tPaciente cadastrado com sucesso")
                .append("\n\tNúmero Identificador: " + paciente.getId())
                .append("\n\tNome: " + paciente.getNomep())
                .append("\n\tTelefone: " + paciente.getTelefonepac())
                .append("\n\t-------------------");
        System.out.println(lista.toString());

        return paciente.getId();
    }

    private static Long buscarEspecialidade(String next, StringBuffer lista) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        EspecialidadeDao especialidadeDao = new EspecialidadeDao();
        List<Especialidade> especialidadeList = especialidadeDao.getEspecialidade(next);
        for (Especialidade especialidade : especialidadeList) {
            lista.append("\n\tNúmero Identificador: " + especialidade.getId()).append("\n\tEspecialidade: " + especialidade.getNomee()).append("\n\t-------------------");
        }
        System.out.println(lista.toString());
        if (especialidadeList.size() > 1) {
            System.out.println("Digite corretamente o Número Identificador da especialidade desejada:");
            return scanner.nextLong();
        }
        return especialidadeList.get(0).getId();
    }

    private static Long buscarCrmMedicoPorNomeEComEspecialidade(String nomeM, Long idEsp, StringBuffer lista) {
        Scanner entrada = new Scanner(System.in, StandardCharsets.UTF_8);
        MedicoDao medicoDao = new MedicoDao();
        List<Medico> medicoList = medicoDao.getMedico(idEsp, nomeM);
        for (Medico medico : medicoList) {
            lista.append("\n\tCRM: " + medico.getId())
                    .append("\n\tNome: " + medico.getNomem())
                    .append("\n\t-------------------");
        }
        System.out.println(lista.toString());

        if(medicoList.size() > 1){
            System.out.println("Digite corretamente o CRM do médico desejado:");
            return entrada.nextLong();
        }else {
            return medicoList.get(0).getId();
        }
    }
    private static Time verificaFormatoEntradaHora(String string) {
        if (string.matches("\\d{2}:\\d{2}")) {
            try {
                Time time = Time.valueOf(string + ":00");
                return time;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("Formato de hora inválido. " + illegalArgumentException.getMessage());
            }
        } else {
            System.out.println("Formato de hora inválido. Por favor, use o formato HH:MM");
        }
        return null;
    }
    private static Consulta agendarConsulta(Consulta consulta, Scanner entrada, StringBuffer lista) {
        lista.append("\n\t(1) Domingo.")
                .append("\n\t(2) Segunda.")
                .append("\n\t(3) Terça.")
                .append("\n\t(4) Quarta.")
                .append("\n\t(5) Quinta.")
                .append("\n\t(6) Sexta.")
                .append("\n\t(7) Sábado.")
                .append("\nDigite número do dia da consulta: ");
        System.out.println(lista);
        lista.setLength(0);

        consulta.setDiacon(MarcarConsulta.retornaDiaSemanaEnum(entrada.next()));
        System.out.print("Digite hora de início da consulta (formato HH:MM): ");
        String hora = entrada.next();
        consulta.setHorainiccon(MarcarConsulta.verificaFormatoEntradaHora(hora));
        System.out.print("Digite hora do fim da consulta (formato HH:MM): ");
        hora = entrada.next();
        consulta.setHorafimcon(MarcarConsulta.verificaFormatoEntradaHora(hora));
        ConsultaDao consultaDao = new ConsultaDao();
        return consultaDao.postConsulta(consulta);
    }

    private static String retornaDiaSemanaEnum(String string) {
        switch (string) {
            case "1": {
                return "SEGUNDA";
            }
            case "2": {
                return "TERCA";
            }
            case "3": {
                return "QUARTA";
            }
            case "4": {
                return "QUINTA";
            }
            case "5": {
                return "SEXTA";
            }
            case "6": {
                return "SABADO";
            }
            case "7": {
                return "DOMINGO";
            }
        }
        System.exit(0);
        return null;
    }
}
