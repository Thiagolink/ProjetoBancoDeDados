package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IPessoa;
import conexao.ConFactory;
import entidade.Administrador;
import entidade.Pessoa;
import entidade.Usuario;

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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE PESSOA SET ");
            buffer.append(returnFieldValuesBD(pessoa));
            buffer.append(" WHERE IDPESSOA=");
            buffer.append(pessoa.getIdPessoa());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no PESSOA : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Pessoa pessoa) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO PESSOA (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(pessoa));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no PESSOA : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Pessoa search(int idPessoa) {
		try{
			conectar();
			String sql = "SELECT * FROM PESSOA WHERE IdPessoa=" + idPessoa; 
			ResultSet rs = comando.executeQuery(sql);
			Pessoa pessoa = new Pessoa();
			if (rs.next()){
				
				pessoa.setIdPessoa(rs.getInt("IdPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				pessoa.setLogin(rs.getString("login"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setEmail(rs.getString("email"));
			}
			System.out.println(pessoa.getIdPessoa());
			fechar();
			return pessoa;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Pessoa pessoa) {
		try {
        	conectar();
    		String sql ="DELETE FROM PESSOA WHERE IdPessoa=" + pessoa.getIdPessoa();
            System.out.println("SQL para REMOVER que fica no PESSOA : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Pessoa> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM PESSOA"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Pessoa> list = new ArrayList<Pessoa>();
			if (rs.next()){
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setIdPessoa(rs.getInt("IdPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				pessoa.setLogin(rs.getString("login"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setEmail(rs.getString("email"));
				list.add(pessoa);
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
