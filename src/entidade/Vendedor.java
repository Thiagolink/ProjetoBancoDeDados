package entidade;

public class Vendedor {

	private int idVendedor;
	private int usuario_idUsuario;
	private int salario;
	
	
	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Vendedor(int idVendedor, int usuario_idUsuario, int salario) {
		super();
		this.idVendedor = idVendedor;
		this.usuario_idUsuario = usuario_idUsuario;
		this.salario = salario;
	}


	public int getIdVendedor() {
		return idVendedor;
	}


	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
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
