package dao;

import java.sql.*;
import java.util.*;

import beans.Especialidade;
import beans.Paciente;
import conexao.ConexaoBD;

public class EspecialidadeDao {
    private Connection conexaoBD;
    private String query;

    public EspecialidadeDao() {
        this.conexaoBD = new ConexaoBD().getConnection();
    }

    public List<Especialidade> getEspecialidade(String nome) {
        query = "SELECT idesp, nomee FROM Especialidade where nomee ILIKE ?;";
        try {
            List<Especialidade> especialidades = new ArrayList<>();
            PreparedStatement pst = this.conexaoBD.prepareStatement(query);
            pst.setString(1, "%" + nome + "%");
            ResultSet rs = pst.executeQuery();
            Especialidade especialidade;
            while(rs.next()) {
                especialidade = new Especialidade();
                especialidade.setId(rs.getLong(1));
                especialidade.setNomee(rs.getString("nomee"));

                especialidades.add(especialidade);
            }
            rs.close();
            pst.close();
            return especialidades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
