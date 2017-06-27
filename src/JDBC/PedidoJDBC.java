package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IPedido;
import conexao.ConFactory;
import entidade.Pedido;

public class PedidoJDBC implements IPedido{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public PedidoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Pedido pedido) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE PEDIDO SET ");
            buffer.append(returnFieldValuesBD(pedido));
            buffer.append(" WHERE IDPEDIDO=");
            buffer.append(pedido.getIdPedido());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no PEDIDO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Pedido pedido) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO PEDIDO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(pedido));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no PEDIDO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Pedido search(int idPedido) {
		try{
			conectar();
			String sql = "SELECT * FROM PEDIDO WHERE IdPedido=" + idPedido; 
			ResultSet rs = comando.executeQuery(sql);
			Pedido pedido = new Pedido();
			if (rs.next()){
				
				pedido.setIdPedido(rs.getInt("IdPedido"));
				pedido.setCliente_idCliente(rs.getInt("cliente_IdCliente"));
				pedido.setPagamento_idPagamento(rs.getInt("pagamento_IdPagamento"));
				pedido.setValorCompra(rs.getFloat("valorCompra"));
				pedido.setValorFrete(rs.getFloat("valorFrete"));
			}
			System.out.println(pedido.getIdPedido());
			fechar();
			return pedido;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Pedido pedido) {
		try {
        	conectar();
    		String sql ="DELETE FROM PEDIDO WHERE IdPedido=" + pedido.getIdPedido();
            System.out.println("SQL para REMOVER que fica no PEDIDO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Pedido> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM PEDIDO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Pedido> list = new ArrayList<Pedido>();
			if (rs.next()){
				
				Pedido pedido = new Pedido();
				
				pedido.setIdPedido(rs.getInt("IdPedido"));
				pedido.setCliente_idCliente(rs.getInt("cliente_IdCliente"));
				pedido.setPagamento_idPagamento(rs.getInt("pagamento_IdPagamento"));
				pedido.setValorCompra(rs.getFloat("valorCompra"));
				pedido.setValorFrete(rs.getFloat("valorFrete"));
				list.add(pedido);
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
    	return "idPedido, cliente_idCliente, pagamento_idPagamento, valorCompra, valorFrete";
    }
    
    protected String returnFieldValuesBD(Pedido pedido) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idPedido=");
        buffer.append(pedido.getIdPedido());
        buffer.append(", cliente_idCliente=");
        buffer.append(pedido.getCliente_idCliente());
        buffer.append(", pagamento_idPagamento=");
        buffer.append(pedido.getPagamento_idPagamento());
        buffer.append(", valorCompra=");
        buffer.append(pedido.getValorCompra());
        buffer.append(", valorFrete=");
        buffer.append(pedido.getValorFrete());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Pedido pedido) {
    	return
    			pedido.getIdPedido()
	        + ", "
	        + pedido.getCliente_idCliente()
	        + ", "
	        + pedido.getPagamento_idPagamento()
	        + ", "
	        + pedido.getValorCompra()
	        + ", "
	        + pedido.getValorFrete();
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
