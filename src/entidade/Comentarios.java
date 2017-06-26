package entidade;

public class Comentarios {

	private int idComentarios;
	private int cliente_idCliente;
	private int produto_idProduto;
	private String descricao;
	private String pros;
	private String contras;
	private String opiniaoGeral;
	private int nota;
	
	
	public Comentarios() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comentarios(int idComentarios, int cliente_idCliente, int produto_idProduto, String descricao, String pros,
			String contras, String opiniaoGeral, int nota) {
		super();
		this.idComentarios = idComentarios;
		this.cliente_idCliente = cliente_idCliente;
		this.produto_idProduto = produto_idProduto;
		this.descricao = descricao;
		this.pros = pros;
		this.contras = contras;
		this.opiniaoGeral = opiniaoGeral;
		this.nota = nota;
	}


	public int getIdComentarios() {
		return idComentarios;
	}


	public void setIdComentarios(int idComentarios) {
		this.idComentarios = idComentarios;
	}


	public int getCliente_idCliente() {
		return cliente_idCliente;
	}


	public void setCliente_idCliente(int cliente_idCliente) {
		this.cliente_idCliente = cliente_idCliente;
	}


	public int getProduto_idProduto() {
		return produto_idProduto;
	}


	public void setProduto_idProduto(int prodto_idProduto) {
		this.produto_idProduto = prodto_idProduto;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getPros() {
		return pros;
	}


	public void setPros(String pros) {
		this.pros = pros;
	}


	public String getContras() {
		return contras;
	}


	public void setContras(String contras) {
		this.contras = contras;
	}


	public String getOpiniaoGeral() {
		return opiniaoGeral;
	}


	public void setOpiniaoGeral(String opiniaoGeral) {
		this.opiniaoGeral = opiniaoGeral;
	}


	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
	
}
