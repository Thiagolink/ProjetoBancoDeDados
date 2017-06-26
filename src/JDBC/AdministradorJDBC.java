package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IAdministrador;
import conexao.ConFactory;
import entidade.Administrador;

public class AdministradorJDBC implements IAdministrador{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public AdministradorJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}

	@Override
	public void update(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador search(int idAdministrador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Administrador> listar() {
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
    	return "idAdministrador, usuario_idUsuario, salario";
    }
	
	protected String returnFieldValuesBD(Administrador administrador) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idAdministrador=");
        buffer.append(administrador.getIdAdmistrador());
        buffer.append(", usuario_idUsuario=");
        buffer.append(administrador.getUsuario_idUsuario());
        buffer.append(", salario=");
        buffer.append(administrador.getSalario());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Administrador administrador) {
    	return
	        administrador.getIdAdmistrador()
	        + ", "
	        + administrador.getUsuario_idUsuario()
	        + ", "
	        + administrador.getSalario();
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
