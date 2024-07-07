package beans;

import java.sql.Time;

public class Agenda {
    private Long id;
    private String diasemana;
    private Time horainicio;
    private Time horafim;
    private Long crm;

    public Agenda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(String diasemana) {
        this.diasemana = diasemana;
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafim() {
        return horafim;
    }

    public void setHorafim(Time horafim) {
        this.horafim = horafim;
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "idagenda=" + id +
                ", diasemana='" + diasemana + '\'' +
                ", horainicio=" + horainicio +
                ", horafim=" + horafim +
                ", crm=" + crm +
                '}';
    }
}
