package entidade;

public class Endereco {
	
	private int idEndereco;
	private int pessoa_idPessoa;
	private String complemento;
	private String estado;
	private String pais;
	private String rua;
	private String bairro;
	private String cidade;
	
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Endereco(int idEndereco, int pessoa_idPessoa, String complemento, String estado, String pais, String rua,
			String bairro, String cidade) {
		super();
		this.idEndereco = idEndereco;
		this.pessoa_idPessoa = pessoa_idPessoa;
		this.complemento = complemento;
		this.estado = estado;
		this.pais = pais;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}


	public int getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}


	public int getPessoa_idPessoa() {
		return pessoa_idPessoa;
	}


	public void setPessoa_idPessoa(int pessoa_idPessoa) {
		this.pessoa_idPessoa = pessoa_idPessoa;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
	
}
