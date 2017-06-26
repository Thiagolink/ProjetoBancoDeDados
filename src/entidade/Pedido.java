package entidade;

public class Pedido {
	
	private int idPedido;
	private int cliente_idCliente;
	private int pagamento_idPagamento;
	private float valorCompra;
	private float valorFrete;
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedido(int idPedido, int cliente_idCliente, int pagamento_idPagamento, float valorCompra, float valorFrete) {
		super();
		this.idPedido = idPedido;
		this.cliente_idCliente = cliente_idCliente;
		this.pagamento_idPagamento = pagamento_idPagamento;
		this.valorCompra = valorCompra;
		this.valorFrete = valorFrete;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public int getCliente_idCliente() {
		return cliente_idCliente;
	}


	public void setCliente_idCliente(int cliente_idCliente) {
		this.cliente_idCliente = cliente_idCliente;
	}


	public int getPagamento_idPagamento() {
		return pagamento_idPagamento;
	}


	public void setPagamento_idPagamento(int pagamento_idPagamento) {
		this.pagamento_idPagamento = pagamento_idPagamento;
	}


	public float getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}


	public float getValorFrete() {
		return valorFrete;
	}


	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}
	
	
	
}
