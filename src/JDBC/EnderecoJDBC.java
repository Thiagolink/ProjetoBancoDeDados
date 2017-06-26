package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IEndereco;
import conexao.ConFactory;
import entidade.Endereco;

public class EnderecoJDBC implements IEndereco{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public EnderecoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco search(int idEndereco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listar() {
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
    	return "idEndereco, pessoa_idPessoa, complemento, estado, pais, rua, bairro, cidade";
    }
    
    protected String returnFieldValuesBD(Endereco endereco) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idEndereco=");
        buffer.append(endereco.getIdEndereco());
        buffer.append(", pessoa_idPessoa=");
        buffer.append(endereco.getPessoa_idPessoa());
        buffer.append(", complemento=");
        buffer.append(retornarValorStringBD(endereco.getComplemento()));
        buffer.append(", estado=");
        buffer.append(retornarValorStringBD(endereco.getEstado()));
        buffer.append(", pais=");
        buffer.append(retornarValorStringBD(endereco.getPais()));
        buffer.append(", rua=");
        buffer.append(retornarValorStringBD(endereco.getRua()));
        buffer.append(", bairro=");
        buffer.append(retornarValorStringBD(endereco.getBairro()));
        buffer.append(", cidade=");
        buffer.append(retornarValorStringBD(endereco.getCidade()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Endereco endereco) {
    	return
    			endereco.getIdEndereco()
	        + ", "
	        + endereco.getPessoa_idPessoa()
	        + ", "
	        + retornarValorStringBD(endereco.getComplemento())
	        + ", "
	        + retornarValorStringBD(endereco.getEstado())
	        + ", "
	        + retornarValorStringBD(endereco.getPais())
	        + ", "
	        + retornarValorStringBD(endereco.getRua())
	        + ", "
	        + retornarValorStringBD(endereco.getBairro())
	        + ", "
	        + retornarValorStringBD(endereco.getCidade());
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
