package entidade;

public class StatusPedido {

	private int idStatusPedido;
	private int pedido_idPedido;
	private String situacao;
	
	
	public StatusPedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StatusPedido(int idStatusPedido, int pedido_idPedido, String situacao) {
		super();
		this.idStatusPedido = idStatusPedido;
		this.pedido_idPedido = pedido_idPedido;
		this.situacao = situacao;
	}


	public int getIdStatusPedido() {
		return idStatusPedido;
	}


	public void setIdStatusPedido(int idStatusPedido) {
		this.idStatusPedido = idStatusPedido;
	}


	public int getPedido_idPedido() {
		return pedido_idPedido;
	}


	public void setPedido_idPedido(int pedido_idPedido) {
		this.pedido_idPedido = pedido_idPedido;
	}


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
}
