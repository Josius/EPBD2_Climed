package beans;

public class Especialidade {

    private Long id;
    private String nomee;
    private Long indice;

    public Especialidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomee() {
        return nomee;
    }

    public void setNomee(String nomee) {
        this.nomee = nomee;
    }

    public Long getIndice() {
        return indice;
    }

    public void setIndice(Long indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "Especialidade{" +
                "id=" + id +
                ", nomee='" + nomee + '\'' +
                ", indice=" + indice +
                '}';
    }
}
