package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.ITelefone;
import conexao.ConFactory;
import entidade.Telefone;

public class TelefoneJDBC implements ITelefone{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public TelefoneJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Telefone telefone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Telefone telefone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Telefone search(int idTelefone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Telefone telefone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Telefone> listar() {
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
    	return "idTelefone, pessoa_idPessoa, numero";
    }
    
    protected String returnFieldValuesBD(Telefone telefone) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idTelefone=");
        buffer.append(telefone.getIdTelefone());
        buffer.append(", pessoa_idPessoa=");
        buffer.append(telefone.getPessoa_idPessoa());
        buffer.append(", numero=");
        buffer.append(telefone.getNumero());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Telefone telefone) {
    	return
    			telefone.getIdTelefone()
	        + ", "
	        + telefone.getPessoa_idPessoa()
	        + ", "
	        + telefone.getNumero();
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
