package beans;

import java.sql.Time;
import java.util.*;

public class Consulta {
    private Long id;
    private String diacon;
    private Time horainiccon;
    private Time horafimcon;
    private boolean pagou;
    private int valorpago;
    private String formapagamento;
    private Long crm;
    private Long idesp;
    private Long idpac;


    public Consulta() {
    }

    public Long getIdn() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiacon() {
        return diacon;
    }

    public void setDiacon(String diacon) {
        this.diacon = diacon;
    }

    public Time getHorainiccon() {
        return horainiccon;
    }

    public void setHorainiccon(Time horainiccon) {
        this.horainiccon = horainiccon;
    }

    public Time getHorafimcon() {
        return horafimcon;
    }

    public void setHorafimcon(Time horafimcon) {
        this.horafimcon = horafimcon;
    }

    public boolean isPagou() {
        return pagou;
    }

    public void setPagou(boolean pagou) {
        this.pagou = pagou;
    }

    public int getValorpago() {
        return valorpago;
    }

    public void setValorpago(int valorpago) {
        this.valorpago = valorpago;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public Long getIdesp() {
        return idesp;
    }

    public void setIdesp(Long idesp) {
        this.idesp = idesp;
    }

    public Long getIdpac() {
        return idpac;
    }

    public void setIdpac(Long idpac) {
        this.idpac = idpac;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "\nidcon=" + id +
                ", diacon='" + diacon + '\'' +
                ", horainiccon=" + horainiccon +
                ", horafimcon=" + horafimcon +
                ", pagou=" + pagou +
                "\nvalorpago=" + valorpago +
                ", formapagamento='" + formapagamento + '\'' +
                ", crm=" + crm +
                ", idesp=" + idesp +
                ", idpac=" + idpac +
                '}';
    }
}

