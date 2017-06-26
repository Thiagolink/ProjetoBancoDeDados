package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IStatusPedido;
import conexao.ConFactory;
import entidade.StatusPedido;

public class StatusPedidoJDBC implements IStatusPedido{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public StatusPedidoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(StatusPedido statusPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(StatusPedido statusPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StatusPedido search(int idStatusPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(StatusPedido statusPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StatusPedido> listar() {
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
    	return "idStatusPedido, pedido_idPedido, situacao";
    }
    
    protected String returnFieldValuesBD(StatusPedido statusPedido) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idStatusPedido=");
        buffer.append(statusPedido.getIdStatusPedido());
        buffer.append(", pedido_idPedido=");
        buffer.append(statusPedido.getPedido_idPedido());
        buffer.append(", situacao=");
        buffer.append(retornarValorStringBD(statusPedido.getSituacao()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(StatusPedido statusPedido) {
    	return
    			statusPedido.getIdStatusPedido()
	        + ", "
	        + statusPedido.getPedido_idPedido()
	        + ", "
	        + retornarValorStringBD(statusPedido.getSituacao());
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
