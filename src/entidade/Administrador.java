package entidade;

public class Administrador {
	
	private int idAdmistrador;
	private int usuario_idUsuario;
	private int salario;
	
	
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Administrador(int idAdmistrador, int usuario_idUsuario, int salario) {
		super();
		this.idAdmistrador = idAdmistrador;
		this.usuario_idUsuario = usuario_idUsuario;
		this.salario = salario;
	}


	public int getIdAdmistrador() {
		return idAdmistrador;
	}


	public void setIdAdmistrador(int idAdmistrador) {
		this.idAdmistrador = idAdmistrador;
	}


	public int getUsuario_idUsuario() {
		return usuario_idUsuario;
	}


	public void setUsuario_idUsuario(int usuario_idUsuario) {
		this.usuario_idUsuario = usuario_idUsuario;
	}


	public int getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
	
}
