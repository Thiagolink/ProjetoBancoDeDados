package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IVendedor;
import conexao.ConFactory;
import entidade.Vendedor;

public class VendedorJDBC implements IVendedor{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public VendedorJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor search(int idVendedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vendedor> listar() {
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
    	return "idVendedor, usuario_idUsuario, salario";
    }
    
    protected String returnFieldValuesBD(Vendedor vendedor) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idVendedor=");
        buffer.append(vendedor.getIdVendedor());
        buffer.append(", usuario_idUsuario=");
        buffer.append(vendedor.getUsuario_idUsuario());
        buffer.append(", salario=");
        buffer.append(vendedor.getSalario());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Vendedor vendedor) {
    	return
    			vendedor.getIdVendedor()
	        + ", "
	        + vendedor.getUsuario_idUsuario()
	        + ", "
	        + vendedor.getSalario();
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
