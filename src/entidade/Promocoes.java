package entidade;

public class Promocoes {
	private int idPromocoes;
	private String desconto;
	private String tempoAtiva;
	
	
	public Promocoes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Promocoes(int idPromocoes, String desconto, String tempoAtiva) {
		super();
		this.idPromocoes = idPromocoes;
		this.desconto = desconto;
		this.tempoAtiva = tempoAtiva;
	}


	public int getIdPromocoes() {
		return idPromocoes;
	}


	public void setIdPromocoes(int idPromocoes) {
		this.idPromocoes = idPromocoes;
	}


	public String getDesconto() {
		return desconto;
	}


	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}


	public String getTempoAtiva() {
		return tempoAtiva;
	}


	public void setTempoAtiva(String tempoAtiva) {
		this.tempoAtiva = tempoAtiva;
	}
	
	
	
}
