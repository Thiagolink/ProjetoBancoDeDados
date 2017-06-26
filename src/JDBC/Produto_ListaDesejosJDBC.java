package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Produto_ListaDesejos produto_ListaDesejos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto_ListaDesejos search(int idProduto_ListaDesejos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Produto_ListaDesejos produto_ListaDesejos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto_ListaDesejos> listar() {
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
