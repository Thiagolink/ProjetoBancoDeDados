package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Departamentos departamentos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamentos search(int idDepartamentos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Departamentos departamentos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Departamentos> listar() {
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
    	return "idDepartamntos, nome";
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
