package dao;

import beans.Paciente;

import java.sql.*;
import java.util.*;
import conexao.ConexaoBD;

public class PacienteDAO {

    private Connection conexaoBD;
    private String query;

    public PacienteDAO() {
        this.conexaoBD = new ConexaoBD().getConnection();
    }

    public List<Paciente> getPaciente(long CPF) {
        query = "SELECT * FROM Paciente where cpf = ?;";
        try {
            List<Paciente> pacientes = new ArrayList<>();
            PreparedStatement pst = this.conexaoBD.prepareStatement(query);
            pst.setLong(1, CPF);
            ResultSet rs = pst.executeQuery();
            Paciente paciente;
            while(rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getLong(1));
                paciente.setCPF(rs.getLong(2));
                paciente.setNomep(rs.getString("nomep"));
                paciente.setTelefonepac(rs.getString("telefonepac"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setIdade(rs.getInt(6));
                paciente.setSexo(rs.getString("sexo"));
                pacientes.add(paciente);
            }
            rs.close();
            pst.close();
            return pacientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Paciente postPaciente(Paciente paciente) {
        query = "INSERT INTO Paciente (nomep, telefonepac) VALUES (?, ?);";
        Paciente pacienteRetorno = new Paciente();
        try {
            PreparedStatement pst = this.conexaoBD.prepareStatement(query);
            pst.setString(1, paciente.getNomep());
            pst.setString(2, paciente.getTelefonepac());
            pst.execute();

            query = "SELECT idpac, nomep, telefonepac  FROM Paciente ORDER BY idpac DESC LIMIT 1;";
            pst = this.conexaoBD.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pacienteRetorno.setId(rs.getLong(1));
                pacienteRetorno.setNomep(rs.getString("nomep"));
                pacienteRetorno.setTelefonepac(rs.getString("telefonepac"));
            }
            rs.close();
            pst.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pacienteRetorno;
    }
}
