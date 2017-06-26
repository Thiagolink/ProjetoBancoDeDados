package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IUsuario;
import conexao.ConFactory;
import entidade.Usuario;

public class UsuarioJDBC implements IUsuario{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public UsuarioJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario search(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() {
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
    	return "idUsuario, pessoa_idPessoa";
    }
    
    protected String returnFieldValuesBD(Usuario usuario) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idUsuario=");
        buffer.append(usuario.getIdUsuario());
        buffer.append(", pessoa_idPessoa=");
        buffer.append(usuario.getPessoa_idPessoa());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Usuario usuario) {
    	return
    			usuario.getIdUsuario()
	        + ", "
	        + usuario.getPessoa_idPessoa();
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
