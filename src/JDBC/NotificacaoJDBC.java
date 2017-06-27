package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.INotificacao;
import conexao.ConFactory;
import entidade.Notificacao;

public class NotificacaoJDBC implements INotificacao{
	
	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public NotificacaoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}

	@Override
	public void update(Notificacao notificacao) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE NOTIFICACAO SET ");
            buffer.append(returnFieldValuesBD(notificacao));
            buffer.append(" WHERE IDNOTIFICACAO=");
            buffer.append(notificacao.getIdNotificacao());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no NOTIFICACAO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Notificacao notificacao) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO NOTIFICACAO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(notificacao));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no NOTIFICACAO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Notificacao search(int idNotificacao) {
		try{
			conectar();
			String sql = "SELECT * FROM NOTIFICACAO WHERE IdNotificacao=" + idNotificacao; 
			ResultSet rs = comando.executeQuery(sql);
			Notificacao notificacao = new Notificacao();
			if (rs.next()){
				
				notificacao.setIdNotificacao(rs.getInt("IdNotificacao"));
				notificacao.setCliente_idCliente(rs.getInt("Cliente_IdCliente"));
				notificacao.setMensagem(rs.getString("mensagem"));
				notificacao.setDataEnvio(rs.getDate("DataEnvio"));
			}
			System.out.println(notificacao.getIdNotificacao());
			fechar();
			return notificacao;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Notificacao notificacao) {
		try {
        	conectar();
    		String sql ="DELETE FROM NOTIFICACAO WHERE IdNotificacao=" + notificacao.getIdNotificacao();
            System.out.println("SQL para REMOVER que fica no NOTIFICACAO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Notificacao> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM NOTIFICACAO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Notificacao> list = new ArrayList<Notificacao>();
			if (rs.next()){
				
				Notificacao notificacao = new Notificacao();
				
				notificacao.setIdNotificacao(rs.getInt("IdNotificacao"));
				notificacao.setCliente_idCliente(rs.getInt("Cliente_IdCliente"));
				notificacao.setMensagem(rs.getString("mensagem"));
				notificacao.setDataEnvio(rs.getDate("DataEnvio"));
				list.add(notificacao);
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
    	return "idNotificacao, cliente_idCliente, mensagem, dataEnvio";
    }
    
    protected String returnFieldValuesBD(Notificacao notificacao) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idNotificacao=");
        buffer.append(notificacao.getIdNotificacao());
        buffer.append(", cliente_idCliente=");
        buffer.append(notificacao.getCliente_idCliente());
        buffer.append(", mensagem=");
        buffer.append(retornarValorStringBD(notificacao.getMensagem()));
        buffer.append(", dataEnvio=");
        buffer.append(retornarValorStringBD(notificacao.getDataEnvio().toString()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Notificacao notificacao) {
    	return
    			notificacao.getIdNotificacao()
	        + ", "
	        + notificacao.getCliente_idCliente()
	        + ", "
	        + retornarValorStringBD(notificacao.getMensagem())
	        + ", "
	        + retornarValorStringBD(notificacao.getDataEnvio().toString());
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
