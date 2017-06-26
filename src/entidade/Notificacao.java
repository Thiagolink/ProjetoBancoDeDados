package entidade;

import java.sql.Date;

public class Notificacao {
	
	private int idNotificacao;
	private int cliente_idCliente;
	private String mensagem;
	private Date dataEnvio;
	
	
	public Notificacao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Notificacao(int idNotificacao, int cliente_idCliente, String mensagem, Date dataEnvio) {
		super();
		this.idNotificacao = idNotificacao;
		this.cliente_idCliente = cliente_idCliente;
		this.mensagem = mensagem;
		this.dataEnvio = dataEnvio;
	}


	public int getIdNotificacao() {
		return idNotificacao;
	}


	public void setIdNotificacao(int idNotificacao) {
		this.idNotificacao = idNotificacao;
	}


	public int getCliente_idCliente() {
		return cliente_idCliente;
	}


	public void setCliente_idCliente(int cliente_idCliente) {
		this.cliente_idCliente = cliente_idCliente;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Date getDataEnvio() {
		return dataEnvio;
	}


	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	
	
}
