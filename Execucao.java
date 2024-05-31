import beans.Consulta;
import beans.Especialidade;
import beans.Paciente;
import dao.EspecialidadeDao;
import dao.PacienteDAO;
import java.util.*;

import java.util.Scanner;

public class Execucao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "UTF-8");
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
                consulta.setIdesp(buscarEspecialidade("Clínico Geral", lista));
                lista.setLength(0);
                break;
            default:
                System.exit(0);
                break;
        }

        System.out.println("\n"+consulta);
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

    private static long buscarPaciente(long CPF, StringBuffer lista){
        PacienteDAO pacienteDAO = new PacienteDAO();
        List<Paciente> pacienteList = pacienteDAO.getPaciente(CPF);
        for (Paciente paciente : pacienteList) {
            lista.append("\n\tPaciente Id: " + paciente.getId())
                    .append("\n\tNome Paciente: " + paciente.getNomep())
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
                .append("\n\tPaciente Id: " + paciente.getId())
                .append("\n\tNome Paciente: " + paciente.getNomep())
                .append("\n\tTelefone: " + paciente.getTelefonepac())
                .append("\n\t-------------------");
        System.out.println(lista.toString());

        return paciente.getId();
    }

    private static Long buscarEspecialidade(String next, StringBuffer lista) {
        EspecialidadeDao especialidadeDao = new EspecialidadeDao();
        List<Especialidade> especialidadeList = especialidadeDao.getEspecialidade(next);
        for (Especialidade especialidade : especialidadeList) {
            lista.append("\n\tEspecialidade Id: " + especialidade.getId())
                    .append("\n\tNome Especialidade: " + especialidade.getNomee())
                    .append("\n\t-------------------");
        }
        System.out.println(lista.toString());
        return especialidadeList.get(0).getId();
    }
}
