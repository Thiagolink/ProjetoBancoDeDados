package entidade;

import java.sql.Date;

public class Atendimento {

	private int idAtendimento;
	private int reclamacao_idReclamacao;
	private int vendedor_idVendedor;
	private Date dataAtendimento;
	private String descricaoAtendimento;
	
	
	public Atendimento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Atendimento(int idAtendimento, int reclamacao_idReclamacao, int vendedor_idVendedor, Date dataAtendimento,
			String descricaoAtendimento) {
		super();
		this.idAtendimento = idAtendimento;
		this.reclamacao_idReclamacao = reclamacao_idReclamacao;
		this.vendedor_idVendedor = vendedor_idVendedor;
		this.dataAtendimento = dataAtendimento;
		this.descricaoAtendimento = descricaoAtendimento;
	}


	public int getIdAtendimento() {
		return idAtendimento;
	}


	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}


	public int getReclamacao_idReclamacao() {
		return reclamacao_idReclamacao;
	}


	public void setReclamacao_idReclamacao(int reclamacao_idReclamacao) {
		this.reclamacao_idReclamacao = reclamacao_idReclamacao;
	}


	public int getVendedor_idVendedor() {
		return vendedor_idVendedor;
	}


	public void setVendedor_idVendedor(int vendedor_idVendedor) {
		this.vendedor_idVendedor = vendedor_idVendedor;
	}


	public Date getDataAtendimento() {
		return dataAtendimento;
	}


	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}


	public String getDescricaoAtendimento() {
		return descricaoAtendimento;
	}


	public void setDescricaoAtendimento(String descricaoAtendimento) {
		this.descricaoAtendimento = descricaoAtendimento;
	}
	
	
	
}
