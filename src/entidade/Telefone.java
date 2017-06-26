package entidade;

public class Telefone {

	private int idTelefone;
	private int pessoa_idPessoa;
	private int numero;
	
	public Telefone() {
		super();
	}

	public Telefone(int idTelefone, int pessoa_idPessoa, int numero) {
		super();
		this.idTelefone = idTelefone;
		this.pessoa_idPessoa = pessoa_idPessoa;
		this.numero = numero;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getPessoa_idPessoa() {
		return pessoa_idPessoa;
	}

	public void setPessoa_idPessoa(int pessoa_idPessoa) {
		this.pessoa_idPessoa = pessoa_idPessoa;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
