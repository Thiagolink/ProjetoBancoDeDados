package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE CLIENTE SET ");
            buffer.append(returnFieldValuesBD(cliente));
            buffer.append(" WHERE IDCLIENTE=");
            buffer.append(cliente.getIdCliente());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no CLIENTE : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Cliente cliente) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO CLIENTE (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(cliente));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no CLIENTE : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente search(int idCliente) {
		try{
			conectar();
			String sql = "SELECT * FROM CLIENTE WHERE idCliente=" + idCliente; 
			ResultSet rs = comando.executeQuery(sql);
			Cliente cliente = new Cliente();
			if (rs.next()){
				
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setUsuario_idUsuario(rs.getInt("usuario_idUsuario"));
				cliente.setListaDesejos_idListaDesejos(rs.getInt("listaDesejos_idListaDesejos"));
			}
			System.out.println(cliente.getIdCliente());
			fechar();
			return cliente;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Cliente cliente) {
		try {
        	conectar();
    		String sql ="DELETE FROM CLIENTE WHERE idCliente=" + cliente.getIdCliente();
            System.out.println("SQL para REMOVER que fica no CLIENTE : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cliente> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM CLIENTE"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Cliente> list = new ArrayList<Cliente>();
			if (rs.next()){
				
				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setUsuario_idUsuario(rs.getInt("usuario_idUsuario"));
				cliente.setListaDesejos_idListaDesejos(rs.getInt("listaDesejos_idListaDesejos"));
				list.add(cliente);
			}
			fechar();
			return list;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
