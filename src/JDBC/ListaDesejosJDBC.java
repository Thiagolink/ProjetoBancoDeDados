package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE LISTADESEJO SET ");
            buffer.append(returnFieldValuesBD(listaDesejos));
            buffer.append(" WHERE IDLISTADESEJOS=");
            buffer.append(listaDesejos.getIdListaDesejos());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no LISTADESEJOS : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(ListaDesejos listaDesejos) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO LISTADESEJOS (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(listaDesejos));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no LISTADESEJOS : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ListaDesejos search(int idListaDesejos) {
		try{
			conectar();
			String sql = "SELECT * FROM LISTADESEJOS WHERE IdListaDesejos=" + idListaDesejos; 
			ResultSet rs = comando.executeQuery(sql);
			ListaDesejos listaDesejos = new ListaDesejos();
			if (rs.next()){
				
				listaDesejos.setIdListaDesejos(rs.getInt("IdListaDesejos"));
			}
			System.out.println(listaDesejos.getIdListaDesejos());
			fechar();
			return listaDesejos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(ListaDesejos listaDesejos) {
		try {
        	conectar();
    		String sql ="DELETE FROM LISTADESEJOS WHERE IdListaDesejos=" + listaDesejos.getIdListaDesejos();
            System.out.println("SQL para REMOVER que fica no LISTADESEJOS : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ListaDesejos> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM LISTADESEJOS"; 
			ResultSet rs = comando.executeQuery(sql);
			List<ListaDesejos> list = new ArrayList<ListaDesejos>();
			if (rs.next()){
				
				ListaDesejos listaDesejos = new ListaDesejos();
				
				listaDesejos.setIdListaDesejos(rs.getInt("IdListaDesejos"));
				list.add(listaDesejos);
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
