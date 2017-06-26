package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Notificacao notificacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notificacao search(int notificacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Notificacao notificacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notificacao> listar() {
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
