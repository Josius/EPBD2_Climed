package beans;

public class Paciente {
	
	private Long id;
	private Long CPF;
	private String nomep;
	private String telefonepac;
	private String endereco;
	private int idade;
	private String sexo;

	public Paciente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long CPF) {
		this.CPF = CPF;
	}

	public String getNomep() {
		return nomep;
	}

	public void setNomep(String nomep) {
		this.nomep = nomep;
	}

	public String getTelefonepac() {
		return telefonepac;
	}

	public void setTelefonepac(String telefonepac) {
		this.telefonepac = telefonepac;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Paciente{" +
				"id=" + id +
				", CPF=" + CPF +
				", nomep='" + nomep + '\'' +
				", telefonepac='" + telefonepac + '\'' +
				", endereco='" + endereco + '\'' +
				", idade=" + idade +
				", sexo='" + sexo + '\'' +
				'}';
	}
}
