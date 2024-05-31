package beans;

import java.util.*;

public class Consulta {
    private Long idcon;
    private String diacon;
    private Date horainiccon;
    private Date horafimcon;
    private boolean pagou;
    private int valorpago;
    private String formapagamento;
    private Long crm;
    private Long idesp;
    private Long idpac;

    public Consulta() {
    }

    public Long getIdcon() {
        return idcon;
    }

    public void setIdcon(Long idcon) {
        this.idcon = idcon;
    }

    public String getDiacon() {
        return diacon;
    }

    public void setDiacon(String diacon) {
        this.diacon = diacon;
    }

    public Date getHorainiccon() {
        return horainiccon;
    }

    public void setHorainiccon(Date horainiccon) {
        this.horainiccon = horainiccon;
    }

    public Date getHorafimcon() {
        return horafimcon;
    }

    public void setHorafimcon(Date horafimcon) {
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
                "idcon=" + idcon +
                ", diacon='" + diacon + '\'' +
                ", horainiccon=" + horainiccon +
                ", horafimcon=" + horafimcon +
                ", pagou=" + pagou +
                ", valorpago=" + valorpago +
                ", formapagamento='" + formapagamento + '\'' +
                ", crm=" + crm +
                ", idesp=" + idesp +
                ", idpac=" + idpac +
                '}';
    }
}

