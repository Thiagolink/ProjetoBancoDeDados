package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IListaDesejos;
import conexao.ConFactory;
import entidade.ListaDesejos;

public class ListaDesejosJDBC implements IListaDesejos{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public ListaDesejosJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(ListaDesejos listaDesejos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(ListaDesejos listaDesejos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListaDesejos search(int idListaDesejos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ListaDesejos listaDesejos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ListaDesejos> listar() {
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
    	return "idListaDesejos";
    }
    
    protected String returnFieldValuesBD(ListaDesejos listaDesejos) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idListaDesejos=");
        buffer.append(listaDesejos.getIdListaDesejos());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(ListaDesejos listaDesejos) {
    	return
    			listaDesejos.getIdListaDesejos()
	        + " ";
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
