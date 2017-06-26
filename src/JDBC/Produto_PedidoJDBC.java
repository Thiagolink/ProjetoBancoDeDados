package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IProduto_Pedido;
import conexao.ConFactory;
import entidade.Produto_Pedido;

public class Produto_PedidoJDBC implements IProduto_Pedido{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public Produto_PedidoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Produto_Pedido produto_pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Produto_Pedido produto_pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto_Pedido search(int produto_pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Produto_Pedido produto_pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto_Pedido> listar() {
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
    	return "idProduto_Pedido, pedido_idPedido, produto_idProduto";
    }
    
    protected String returnFieldValuesBD(Produto_Pedido produto_Pedido) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idProduto_Pedido=");
        buffer.append(produto_Pedido.getIdProduto_Pedido());
        buffer.append(", pedido_idPedido=");
        buffer.append(produto_Pedido.getPedido_idPedido());
        buffer.append(", produto_idProduto=");
        buffer.append(produto_Pedido.getProduto_idProduto());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Produto_Pedido produto_Pedido) {
    	return
    			produto_Pedido.getIdProduto_Pedido()
	        + ", "
	        + produto_Pedido.getPedido_idPedido()
	        + ", "
	        + produto_Pedido.getProduto_idProduto();
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
