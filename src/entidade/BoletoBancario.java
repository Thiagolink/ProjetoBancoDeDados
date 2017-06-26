package entidade;

import java.sql.Date;

public class BoletoBancario {

	private int idBoletoBancario;
	private int pagamento_idPagamento;
	private int codigoBarras;
	private String banco;
	private Date dataVencimento;
	
	
	public BoletoBancario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoletoBancario(int idBoletoBancario, int pagamento_idPagamento, int codigoBarras, String banco,
			Date dataVencimento) {
		super();
		this.idBoletoBancario = idBoletoBancario;
		this.pagamento_idPagamento = pagamento_idPagamento;
		this.codigoBarras = codigoBarras;
		this.banco = banco;
		this.dataVencimento = dataVencimento;
	}


	public int getIdBoletoBancario() {
		return idBoletoBancario;
	}


	public void setIdBoletoBancario(int idBoletoBancario) {
		this.idBoletoBancario = idBoletoBancario;
	}


	public int getPagamento_idPagamento() {
		return pagamento_idPagamento;
	}


	public void setPagamento_idPagamento(int pagamento_idPagamento) {
		this.pagamento_idPagamento = pagamento_idPagamento;
	}


	public int getCodigoBarras() {
		return codigoBarras;
	}


	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public Date getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	
}
