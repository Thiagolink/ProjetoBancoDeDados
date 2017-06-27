package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IProduto_ListaDesejos;
import conexao.ConFactory;
import entidade.Produto_ListaDesejos;

public class Produto_ListaDesejosJDBC implements IProduto_ListaDesejos{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public Produto_ListaDesejosJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Produto_ListaDesejos produto_ListaDesejos) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE PRODUTO_LISTADESEJOS SET ");
            buffer.append(returnFieldValuesBD(produto_ListaDesejos));
            buffer.append(" WHERE IDPRODUTO_LISTADESEJOS=");
            buffer.append(produto_ListaDesejos.getIdProduto_ListaDesejos());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no PRODUTO_LISTADESEJOS : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Produto_ListaDesejos produto_ListaDesejos) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO PRODUTO_LISTADESEJOS (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(produto_ListaDesejos));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no PRODUTO_LISTADESEJOS : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Produto_ListaDesejos search(int idProduto_ListaDesejos) {
		try{
			conectar();
			String sql = "SELECT * FROM PRODUTO_LISTADESEJOS WHERE IdProduto_ListaDesejos=" + idProduto_ListaDesejos; 
			ResultSet rs = comando.executeQuery(sql);
			Produto_ListaDesejos produto_ListaDesejos = new Produto_ListaDesejos();
			if (rs.next()){
				
				produto_ListaDesejos.setIdProduto_ListaDesejos(rs.getInt("idProduto_ListaDesejos"));
				produto_ListaDesejos.setProduto_idProduto(rs.getInt("IdProduto"));
				produto_ListaDesejos.setListaDesejos_idListaDesejos(rs.getInt("listaDesejos_idListaDesejos"));
			}
			System.out.println(produto_ListaDesejos.getIdProduto_ListaDesejos());
			fechar();
			return produto_ListaDesejos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Produto_ListaDesejos produto_ListaDesejos) {
		try {
        	conectar();
    		String sql ="DELETE FROM PRODUTO_LISTADESEJOS WHERE IdProduto_ListaDesejos=" + produto_ListaDesejos.getIdProduto_ListaDesejos();
            System.out.println("SQL para REMOVER que fica no PRODUTO_LISTADESEJOS : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produto_ListaDesejos> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM PRODUTO_LISTADESEJOS"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Produto_ListaDesejos> list = new ArrayList<Produto_ListaDesejos>();
			if (rs.next()){
				
				Produto_ListaDesejos produto_ListaDesejos = new Produto_ListaDesejos();
				
				produto_ListaDesejos.setIdProduto_ListaDesejos(rs.getInt("idProduto_ListaDesejos"));
				produto_ListaDesejos.setProduto_idProduto(rs.getInt("IdProduto"));
				produto_ListaDesejos.setListaDesejos_idListaDesejos(rs.getInt("listaDesejos_idListaDesejos"));
				list.add(produto_ListaDesejos);
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
    	return "idProduto_ListaDesejos, produto_idProduto, listaDesejos_idListaDesejos";
    }
    
    protected String returnFieldValuesBD(Produto_ListaDesejos produto_ListaDesejos) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idProduto_ListaDesejos=");
        buffer.append(produto_ListaDesejos.getIdProduto_ListaDesejos());
        buffer.append(", produto_idProduto=");
        buffer.append(produto_ListaDesejos.getProduto_idProduto());
        buffer.append(", listaDesejos_idListaDesejos=");
        buffer.append(produto_ListaDesejos.getListaDesejos_idListaDesejos());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Produto_ListaDesejos produto_ListaDesejos) {
    	return
    			produto_ListaDesejos.getIdProduto_ListaDesejos()
	        + ", "
	        + produto_ListaDesejos.getProduto_idProduto()
	        + ", "
	        + produto_ListaDesejos.getListaDesejos_idListaDesejos();
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
