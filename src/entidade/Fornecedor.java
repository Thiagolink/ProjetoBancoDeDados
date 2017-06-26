package entidade;

public class Fornecedor {

	private int idFornecedor;
	private int pessoa_idPessoa;
	private String nome;
	private int CNPJ;
	
	
	public Fornecedor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Fornecedor(int idFornecedor, int pessoa_idPessoa, String nome, int cNPJ) {
		super();
		this.idFornecedor = idFornecedor;
		this.pessoa_idPessoa = pessoa_idPessoa;
		this.nome = nome;
		CNPJ = cNPJ;
	}


	public int getIdFornecedor() {
		return idFornecedor;
	}


	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}


	public int getPessoa_idPessoa() {
		return pessoa_idPessoa;
	}


	public void setPessoa_idPessoa(int pessoa_idPessoa) {
		this.pessoa_idPessoa = pessoa_idPessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCNPJ() {
		return CNPJ;
	}


	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
	
	
	
}
