package entidade;

public class Produto {
	private int idProduto;
	private int promocoes_idPromocoes;
	private int departamentos_idDepartamentos;
	private int fornecedor_idFornecedor;
	private String nome;
	private String descricao;
	private float preco;
	private String marca;
	private String tamanho;
	private int estoque;
	
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Produto(int idProduto, int promocoes_idPromocoes, int departamentos_idDepartamentos,
			int fornecedor_idFornecedor, String nome, String descricao, float preco, String marca, String tamanho,
			int estoque) {
		super();
		this.idProduto = idProduto;
		this.promocoes_idPromocoes = promocoes_idPromocoes;
		this.departamentos_idDepartamentos = departamentos_idDepartamentos;
		this.fornecedor_idFornecedor = fornecedor_idFornecedor;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.marca = marca;
		this.tamanho = tamanho;
		this.estoque = estoque;
	}


	public int getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}


	public int getPromocoes_idPromocoes() {
		return promocoes_idPromocoes;
	}


	public void setPromocoes_idPromocoes(int promocoes_idPromocoes) {
		this.promocoes_idPromocoes = promocoes_idPromocoes;
	}


	public int getDepartamentos_idDepartamentos() {
		return departamentos_idDepartamentos;
	}


	public void setDepartamentos_idDepartamentos(int departamentos_idDepartamentos) {
		this.departamentos_idDepartamentos = departamentos_idDepartamentos;
	}


	public int getFornecedor_idFornecedor() {
		return fornecedor_idFornecedor;
	}


	public void setFornecedor_idFornecedor(int fornecedor_idFornecedor) {
		this.fornecedor_idFornecedor = fornecedor_idFornecedor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
	
}
