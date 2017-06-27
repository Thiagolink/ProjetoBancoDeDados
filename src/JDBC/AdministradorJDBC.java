package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE ADMINISTRADOR SET ");
            buffer.append(returnFieldValuesBD(administrador));
            buffer.append(" WHERE IDADMINISTRADOR=");
            buffer.append(administrador.getIdAdmistrador());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no ADMINISTRADOR : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Administrador administrador) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO ADMINISTRADOR (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(administrador));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no ADMINISTRADOR : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public Administrador search(int idAdministrador) {
		try{
			conectar();
			String sql = "SELECT * FROM ADMINISTRADOR WHERE IdAdministrador=" + idAdministrador; 
			ResultSet rs = comando.executeQuery(sql);
			Administrador administrador = new Administrador();
			if (rs.next()){
				
				administrador.setIdAdmistrador(rs.getInt("IdAdministrador"));
				administrador.setUsuario_idUsuario(rs.getInt("usuario_idUsuario"));
				administrador.setSalario(rs.getInt("salario"));
			}
			System.out.println(administrador.getIdAdmistrador());
			fechar();
			return administrador;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Administrador administrador) {
		try {
        	conectar();
    		String sql ="DELETE FROM ADMINISTRADOR WHERE IdAdministrador=" + administrador.getIdAdmistrador();
            System.out.println("SQL para REMOVER que fica no ADMINISTRADOR : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Administrador> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM ADMINISTRADOR"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Administrador> list = new ArrayList<Administrador>();
			if (rs.next()){
				
				Administrador administrador = new Administrador();
				
				administrador.setIdAdmistrador(rs.getInt("IdAdministrador"));
				administrador.setUsuario_idUsuario(rs.getInt("usuario_idUsuario"));
				administrador.setSalario(rs.getInt("salario"));
				list.add(administrador);
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
