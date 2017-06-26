package entidade;

public class Pagamento {
	
	private int idPagamento;
	private float valorTotal;
	
	
	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pagamento(int idPagamento, float valorTotal) {
		super();
		this.idPagamento = idPagamento;
		this.valorTotal = valorTotal;
	}


	public int getIdPagamento() {
		return idPagamento;
	}


	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}


	public float getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	
}
