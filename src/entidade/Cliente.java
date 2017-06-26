package entidade;

public class Cliente {
	
	private int idCliente;
	private int usuario_idUsuario;
	private int listaDesejos_idListaDesejos;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(int idCliente, int usuario_idUsuario, int listaDesejos_idListaDesejos) {
		super();
		this.idCliente = idCliente;
		this.usuario_idUsuario = usuario_idUsuario;
		this.listaDesejos_idListaDesejos = listaDesejos_idListaDesejos;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public int getUsuario_idUsuario() {
		return usuario_idUsuario;
	}


	public void setUsuario_idUsuario(int uuario_idUsuario) {
		this.usuario_idUsuario = uuario_idUsuario;
	}


	public int getListaDesejos_idListaDesejos() {
		return listaDesejos_idListaDesejos;
	}


	public void setListaDesejos_idListaDesejos(int listaDesejos_idListaDesejos) {
		this.listaDesejos_idListaDesejos = listaDesejos_idListaDesejos;
	}
	
	
	
}
