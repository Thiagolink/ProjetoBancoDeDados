package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido search(int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> listar() {
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
