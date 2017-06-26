package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.ICliente;
import conexao.ConFactory;
import entidade.Cliente;

public class ClienteJDBC implements ICliente{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public ClienteJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Cliente ciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente search(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	private void conectar() throws ClassNotFoundException, SQLException  {
        con = ConFactory.conexao(URL, NOME, SENHA, BANCO);  
		comando = con.createStatement();  
        System.out.println("Conectado!");     
	}	  
	
	private void fechar() {  
		try {  
			comando.close();  
			con.close();  
			System.out.println("Conexão Fechada");  
		} catch (SQLException e) {  
		}  
	}

	protected String retornarCamposBD() {
    	return "idCliente, usuario_idUsuario, listaDesejos_idListaDesejos";
    }
    
    protected String returnFieldValuesBD(Cliente cliente) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idCliente=");
        buffer.append(cliente.getIdCliente());
        buffer.append(", usuario_idUsuario=");
        buffer.append(cliente.getUsuario_idUsuario());
        buffer.append(", listaDesejos_idListaDesejos=");
        buffer.append(cliente.getListaDesejos_idListaDesejos());


        return buffer.toString();
    }
    
    protected String retornarValoresBD(Cliente cliente) {
    	return
    		cliente.getIdCliente()
	        + ", "
	        + cliente.getUsuario_idUsuario()
	        + ", "
	        + cliente.getListaDesejos_idListaDesejos();
    }
    
    private String retornarValorStringBD(String valor) {
        if (valor != null && !"".equals(valor)) {
            valor = "'" + valor + "'";
        } else {
            valor = "'"+"'";
        }
        return valor;
    }
	
}
