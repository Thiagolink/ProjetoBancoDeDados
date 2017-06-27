package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE STATUSPEDIDO SET ");
            buffer.append(returnFieldValuesBD(statusPedido));
            buffer.append(" WHERE IDSTATUSPEDIDO=");
            buffer.append(statusPedido.getIdStatusPedido());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no STATUSPEDIDO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(StatusPedido statusPedido) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO STATUSPEDIDO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(statusPedido));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no STATUSPEDIDO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public StatusPedido search(int idStatusPedido) {
		try{
			conectar();
			String sql = "SELECT * FROM STATUSPEDIDO WHERE IdStatusPedido=" + idStatusPedido; 
			ResultSet rs = comando.executeQuery(sql);
			StatusPedido statusPedido = new StatusPedido();
			if (rs.next()){
				
				statusPedido.setIdStatusPedido(rs.getInt("IdStatusPedido"));
				statusPedido.setPedido_idPedido(rs.getInt("pedido_IdPedido"));
				statusPedido.setSituacao(rs.getString("situacao"));
			}
			System.out.println(statusPedido.getIdStatusPedido());
			fechar();
			return statusPedido;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(StatusPedido statusPedido) {
		try {
        	conectar();
    		String sql ="DELETE FROM STATUSPEDIDO WHERE IdStatusPedido=" + statusPedido.getIdStatusPedido();
            System.out.println("SQL para REMOVER que fica no STATUSPEDIDO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<StatusPedido> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM STATUSPEDIDO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<StatusPedido> list = new ArrayList<StatusPedido>();
			if (rs.next()){
				
				StatusPedido statusPedido = new StatusPedido();
				
				statusPedido.setIdStatusPedido(rs.getInt("IdStatusPedido"));
				statusPedido.setPedido_idPedido(rs.getInt("pedido_IdPedido"));
				statusPedido.setSituacao(rs.getString("situacao"));
				list.add(statusPedido);
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
