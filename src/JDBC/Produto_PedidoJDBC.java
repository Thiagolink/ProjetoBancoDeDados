package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE PRODUTO_PEDIDO SET ");
            buffer.append(returnFieldValuesBD(produto_pedido));
            buffer.append(" WHERE IDPRODUTO_PEDIDO=");
            buffer.append(produto_pedido.getIdProduto_Pedido());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no PRODUTO_PEDIDO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Produto_Pedido produto_pedido) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO PRODUTO_PEDIDO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(produto_pedido));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no PRODUTO_PEDIDO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Produto_Pedido search(int idProduto_pedido) {
		try{
			conectar();
			String sql = "SELECT * FROM PRODUTO_PEDIDO WHERE IdProduto_Pedido=" + idProduto_pedido; 
			ResultSet rs = comando.executeQuery(sql);
			Produto_Pedido produto_pedido = new Produto_Pedido();
			if (rs.next()){
				
				produto_pedido.setIdProduto_Pedido(rs.getInt("idProduto_pedido"));
				produto_pedido.setPedido_idPedido(rs.getInt("pedido_IdPedido"));
				produto_pedido.setProduto_idProduto(rs.getInt("produto_IdProduto"));
			}
			System.out.println(produto_pedido.getIdProduto_Pedido());
			fechar();
			return produto_pedido;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Produto_Pedido produto_pedido) {
		try {
        	conectar();
    		String sql ="DELETE FROM PRODUTO_PEDIDO WHERE IdProduto_Pedido=" + produto_pedido.getIdProduto_Pedido();
            System.out.println("SQL para REMOVER que fica no PRODUTO_PEDIDO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produto_Pedido> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM PRODUTO_PEDIDO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Produto_Pedido> list = new ArrayList<Produto_Pedido>();
			if (rs.next()){
				
				Produto_Pedido produto_pedido = new Produto_Pedido();
				
				produto_pedido.setIdProduto_Pedido(rs.getInt("idProduto_pedido"));
				produto_pedido.setPedido_idPedido(rs.getInt("pedido_IdPedido"));
				produto_pedido.setProduto_idProduto(rs.getInt("produto_IdProduto"));
				list.add(produto_pedido);
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
