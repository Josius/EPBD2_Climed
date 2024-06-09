package beans;

public class Medico {
    private Long id;
    private String nomem;
    private String telefonem;
    private Double percentual;

    public Medico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomem() {
        return nomem;
    }

    public void setNomem(String nomem) {
        this.nomem = nomem;
    }

    public String getTelefonem() {
        return telefonem;
    }

    public void setTelefonem(String telefonem) {
        this.telefonem = telefonem;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nomem='" + nomem + '\'' +
                ", telefonem='" + telefonem + '\'' +
                ", percentual=" + percentual +
                '}';
    }
}
