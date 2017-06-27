package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE USUARIO SET ");
            buffer.append(returnFieldValuesBD(usuario));
            buffer.append(" WHERE IDUSUARIO=");
            buffer.append(usuario.getIdUsuario());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no USUARIO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Usuario usuario) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO USUARIO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(usuario));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no USUARIO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Usuario search(int idUsuario) {
		try{
			conectar();
			String sql = "SELECT * FROM USUARIO WHERE IdUsuario=" + idUsuario; 
			ResultSet rs = comando.executeQuery(sql);
			Usuario usuario = new Usuario();
			if (rs.next()){
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setPessoa_idPessoa(rs.getInt("Pessoa_IdPessoa"));
			}
			System.out.println(usuario.getIdUsuario());
			fechar();
			return usuario;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Usuario usuario) {
		try {
        	conectar();
    		String sql ="DELETE FROM USUARIO WHERE IdUsuario=" + usuario.getIdUsuario();
            System.out.println("SQL para REMOVER que fica no USUARIO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Usuario> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM USUARIO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Usuario> list = new ArrayList<Usuario>();
			if (rs.next()){
				
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setPessoa_idPessoa(rs.getInt("Pessoa_IdPessoa"));
				list.add(usuario);
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
