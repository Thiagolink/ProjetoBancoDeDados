package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IDepartamentos;
import conexao.ConFactory;
import entidade.Departamentos;

public class DepartamentosJDBC implements IDepartamentos{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public DepartamentosJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Departamentos departamentos) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE DEPARTAMENTOS SET ");
            buffer.append(returnFieldValuesBD(departamentos));
            buffer.append(" WHERE IDCOMENTARIOS=");
            buffer.append(departamentos.getIdDepartamntos());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no DEPARTAMENTOS : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Departamentos departamentos) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO DEPARTAMENTOS (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(departamentos));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no DEPARTAMENTOS : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Departamentos search(int idDepartamentos) {
		try{
			conectar();
			String sql = "SELECT * FROM DEPARTAMENTOS WHERE IdDepartamentos=" + idDepartamentos; 
			ResultSet rs = comando.executeQuery(sql);
			Departamentos departamentos = new Departamentos();
			if (rs.next()){
				
				departamentos.setIdDepartamntos(rs.getInt("idDepartamentos"));
				departamentos.setNome(rs.getString("nome"));
			}
			System.out.println(departamentos.getIdDepartamntos());
			fechar();
			return departamentos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Departamentos departamentos) {
		try {
        	conectar();
    		String sql ="DELETE FROM DEPARTAMENTOS WHERE IdDepartamentos=" + departamentos.getIdDepartamntos();
            System.out.println("SQL para REMOVER que fica no DEPARTAMENTO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Departamentos> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM DEPARTAMENTOS"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Departamentos> list = new ArrayList<Departamentos>();
			if (rs.next()){
				
				Departamentos departamentos = new Departamentos();
				
				departamentos.setIdDepartamntos(rs.getInt("idDepartamentos"));
				departamentos.setNome(rs.getString("nome"));
				list.add(departamentos);
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
    	return "idDepartamentos, nome";
    }
    
    protected String returnFieldValuesBD(Departamentos departamentos) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idDepartamntos=");
        buffer.append(departamentos.getIdDepartamntos());
        buffer.append(", nome=");
        buffer.append(retornarValorStringBD(departamentos.getNome()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Departamentos departamentos) {
    	return
    			departamentos.getIdDepartamntos()
	        + ", "
	        + retornarValorStringBD(departamentos.getNome());
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
