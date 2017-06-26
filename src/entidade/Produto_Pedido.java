package entidade;

public class Produto_Pedido {

	private int idProduto_Pedido;
	private int pedido_idPedido;
	private int produto_idProduto;
	
	public Produto_Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto_Pedido(int idProduto_Pedido, int pedido_idPedido, int produto_idProduto) {
		super();
		this.idProduto_Pedido = idProduto_Pedido;
		this.pedido_idPedido = pedido_idPedido;
		this.produto_idProduto = produto_idProduto;
	}

	public int getIdProduto_Pedido() {
		return idProduto_Pedido;
	}

	public void setIdProduto_Pedido(int idProduto_Pedido) {
		this.idProduto_Pedido = idProduto_Pedido;
	}

	public int getPedido_idPedido() {
		return pedido_idPedido;
	}

	public void setPedido_idPedido(int pedido_idPedido) {
		this.pedido_idPedido = pedido_idPedido;
	}

	public int getProduto_idProduto() {
		return produto_idProduto;
	}

	public void setProduto_idProduto(int produto_idProduto) {
		this.produto_idProduto = produto_idProduto;
	}
	
	
	
}
