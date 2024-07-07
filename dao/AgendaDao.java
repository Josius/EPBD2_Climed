package dao;

import beans.Agenda;
import beans.Paciente;
import conexao.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDao {

    private Connection conexaoBD;
    private String query;

    public AgendaDao() {
        this.conexaoBD = new ConexaoBD().getConnection();
    }

    public List<Agenda> getAgenda(long CRM) {
        query = "SELECT * FROM agenda WHERE CRM = ?;";
        try {
            List<Agenda> agendas = new ArrayList<>();
            PreparedStatement pst = this.conexaoBD.prepareStatement(query);
            pst.setLong(1, CRM);
            ResultSet rs = pst.executeQuery();
            Agenda agenda;
            while(rs.next()) {
                agenda = new Agenda();
                agenda.setId(rs.getLong(1));
                agenda.setDiasemana(rs.getString(2));
                agenda.setHorainicio(rs.getTime(3));
                agenda.setHorafim(rs.getTime(4));
                agenda.setCrm(rs.getLong(5));
                agendas.add(agenda);
            }
            rs.close();
            pst.close();
            return agendas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
