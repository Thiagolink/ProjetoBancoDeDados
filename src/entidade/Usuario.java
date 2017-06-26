package entidade;

public class Usuario {
	
	private int idUsuario;
	private int pessoa_idPessoa;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(int idUsuario, int pessoa_idPessoa) {
		super();
		this.idUsuario = idUsuario;
		this.pessoa_idPessoa = pessoa_idPessoa;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getPessoa_idPessoa() {
		return pessoa_idPessoa;
	}


	public void setPessoa_idPessoa(int pessoa_idPessoa) {
		this.pessoa_idPessoa = pessoa_idPessoa;
	}
	
	
	
}
