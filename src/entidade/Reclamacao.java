package entidade;

public class Reclamacao {
	
	private int idReclamacao;
	private int cliente_idCliente;
	private String descricaoReclamacao;
	private String tipo;
	
	public Reclamacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reclamacao(int idReclamacao, int cliente_idCliente, String descricaoReclamacao, String tipo) {
		super();
		this.idReclamacao = idReclamacao;
		this.cliente_idCliente = cliente_idCliente;
		this.descricaoReclamacao = descricaoReclamacao;
		this.tipo = tipo;
	}

	public int getIdReclamacao() {
		return idReclamacao;
	}

	public void setIdReclamacao(int idReclamacao) {
		this.idReclamacao = idReclamacao;
	}

	public int getCliente_idCliente() {
		return cliente_idCliente;
	}

	public void setCliente_idCliente(int cliente_idCliente) {
		this.cliente_idCliente = cliente_idCliente;
	}

	public String getDescricaoReclamacao() {
		return descricaoReclamacao;
	}

	public void setDescricaoReclamacao(String descricaoReclamacao) {
		this.descricaoReclamacao = descricaoReclamacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
