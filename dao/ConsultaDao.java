package dao;

import beans.Consulta;
import conexao.ConexaoBD;
import enums.DiaSemanaEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaDao {
    private Connection conexaoBD;
    private String query;

    public ConsultaDao() {
        this.conexaoBD = new ConexaoBD().getConnection();
    }

    public Consulta postConsulta(Consulta consulta) {
        DiaSemanaEnum diaSemana = diaDaSemana(consulta.getDiacon());

        query = "INSERT INTO Consulta (diacon, horainiccon, horafimcon, crm, idesp, idpac) VALUES (?::DiaSemanaEnum, ?, ?, ?, ?, ?);";
        Consulta consultaRetorno = new Consulta();
        try {
            PreparedStatement pst = this.conexaoBD.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, diaSemana.name());
            pst.setTime(2, consulta.getHorainiccon());
            pst.setTime(3, consulta.getHorafimcon());
            pst.setLong(4, consulta.getCrm());
            pst.setLong(5, consulta.getIdesp());
            pst.setLong(6, consulta.getIdpac());

            int respostaDoBD = pst.executeUpdate();

            if (respostaDoBD > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    consulta.setId(generatedKeys.getLong(1));
                    return consulta;
                }
                generatedKeys.close();
            }
            pst.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consulta;
    }

    private DiaSemanaEnum diaDaSemana(String diacon) {
        switch (diacon.toUpperCase()){
            case "SEGUNDA":
                return DiaSemanaEnum.SEGUNDA;
            case "TERCA":
                return DiaSemanaEnum.TERCA;
            case "QUARTA":
                return DiaSemanaEnum.QUARTA;
            case "QUINTA":
                return DiaSemanaEnum.QUINTA;
            case "SEXTA":
                return DiaSemanaEnum.SEXTA;
            case "SABADO":
                return DiaSemanaEnum.SABADO;
            case "DOMINGO":
                return DiaSemanaEnum.DOMINGO;
            default:
                throw new IllegalArgumentException("Dia da semana inválido: " + diacon);
        }
    }
}
