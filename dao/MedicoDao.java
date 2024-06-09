package dao;

import java.sql.*;
import java.util.*;

import beans.Medico;
import conexao.ConexaoBD;

public class MedicoDao {
    private Connection conexaoBD;
    private String query;

    public MedicoDao() {
        this.conexaoBD = new ConexaoBD().getConnection();
    }

    public List<Medico> getMedico(Long idEsp, String nomeM) {
        query = "SELECT m.crm, m.nomem FROM medico AS m JOIN exerceesp AS e ON m.crm = e.crm WHERE e.idesp = ? and m.nomem ILIKE ?;";
        try {
            List<Medico> medicos = new ArrayList<>();
            PreparedStatement pst = this.conexaoBD.prepareStatement(query);
            pst.setLong(1, idEsp);
            pst.setString(2, nomeM + "%");
            ResultSet rs = pst.executeQuery();
            Medico medico;
            while(rs.next()) {
                medico = new Medico();
                medico.setId(rs.getLong(1));
                medico.setNomem(rs.getString("nomem"));

                medicos.add(medico);
            }
            rs.close();
            pst.close();
            return medicos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
