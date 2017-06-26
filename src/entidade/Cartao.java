package entidade;

import java.sql.Date;

public class Cartao {
	
	private int idCartao;
	private int pagamento_idPagamento;
	private String nome;
	private int codigoSeguranca;
	private int numeroCartao;
	private Date dataVencimentoCartao;
	private String bandeira;
	
	
	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cartao(int idCartao, int pagamento_idPagamento, String nome, int codigoSeguranca, int numeroCartao,
			Date dataVencimentoCartao, String bandeira) {
		super();
		this.idCartao = idCartao;
		this.pagamento_idPagamento = pagamento_idPagamento;
		this.nome = nome;
		this.codigoSeguranca = codigoSeguranca;
		this.numeroCartao = numeroCartao;
		this.dataVencimentoCartao = dataVencimentoCartao;
		this.bandeira = bandeira;
	}


	public int getIdCartao() {
		return idCartao;
	}


	public void setIdCartao(int idCartao) {
		this.idCartao = idCartao;
	}


	public int getPagamento_idPagamento() {
		return pagamento_idPagamento;
	}


	public void setPagamento_idPagamento(int pagamento_idPagamento) {
		this.pagamento_idPagamento = pagamento_idPagamento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}


	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}


	public int getNumeroCartao() {
		return numeroCartao;
	}


	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}


	public Date getDataVencimentoCartao() {
		return dataVencimentoCartao;
	}


	public void setDataVencimentoCartao(Date dataVencimentoCartao) {
		this.dataVencimentoCartao = dataVencimentoCartao;
	}


	public String getBandeira() {
		return bandeira;
	}


	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	
	
	
}
