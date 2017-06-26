package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IFornecedor;
import conexao.ConFactory;
import entidade.Fornecedor;

public class FornecedorJDBC implements IFornecedor{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public FornecedorJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor search(int idFornecedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fornecedor> listar() {
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
    	return "idFornecedor, pessoa_idPessoa, nome, CNPJ";
    }
    
    protected String returnFieldValuesBD(Fornecedor fornecedor) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idFornecedor=");
        buffer.append(fornecedor.getIdFornecedor());
        buffer.append(", pessoa_idPessoa=");
        buffer.append(fornecedor.getPessoa_idPessoa());
        buffer.append(", nome=");
        buffer.append(retornarValorStringBD(fornecedor.getNome()));
        buffer.append(", CNPJ=");
        buffer.append(fornecedor.getCNPJ());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Fornecedor fornecedor) {
    	return
    			fornecedor.getIdFornecedor()
	        + ", "
	        + fornecedor.getPessoa_idPessoa()
	        + ", "
	        + retornarValorStringBD(fornecedor.getNome())
	        + ", "
	        + fornecedor.getCNPJ();
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
