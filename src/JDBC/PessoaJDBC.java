package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IPessoa;
import conexao.ConFactory;
import entidade.Pessoa;

public class PessoaJDBC implements IPessoa{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public PessoaJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa search(int idPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pessoa> listar() {
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
    	return "idPessoa, nome, dataNascimento, login, senha, email";
    }
    
    protected String returnFieldValuesBD(Pessoa pessoa) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idPessoa=");
        buffer.append(pessoa.getIdPessoa());
        buffer.append(", nome=");
        buffer.append(retornarValorStringBD(pessoa.getNome()));
        buffer.append(", dataNascimento=");
        buffer.append(retornarValorStringBD(pessoa.getDataNascimento().toString()));
        buffer.append(", login=");
        buffer.append(retornarValorStringBD(pessoa.getLogin()));
        buffer.append(", senha=");
        buffer.append(retornarValorStringBD(pessoa.getSenha()));
        buffer.append(", email=");
        buffer.append(retornarValorStringBD(pessoa.getEmail()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Pessoa pessoa) {
    	return
    			pessoa.getIdPessoa()
	        + ", "
	        + retornarValorStringBD(pessoa.getNome())
	        + ", "
	        + retornarValorStringBD(pessoa.getDataNascimento().toString())
	        + ", "
	        + retornarValorStringBD(pessoa.getLogin())
	        + ", "
	        + retornarValorStringBD(pessoa.getSenha())
	        + ", "
	        + retornarValorStringBD(pessoa.getEmail());
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
