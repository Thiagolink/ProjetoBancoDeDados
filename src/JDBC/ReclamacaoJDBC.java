package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IReclamacao;
import conexao.ConFactory;
import entidade.Reclamacao;

public class ReclamacaoJDBC implements IReclamacao{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public ReclamacaoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Reclamacao reclamacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Reclamacao reclamacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reclamacao search(int idReclamacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Reclamacao reclamacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reclamacao> listar() {
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
    	return "idReclamacao, cliente_idCliente, descricaoReclamacao, tipo";
    }
    
    protected String returnFieldValuesBD(Reclamacao reclamacao) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idReclamacao=");
        buffer.append(reclamacao.getIdReclamacao());
        buffer.append(", cliente_idCliente=");
        buffer.append(reclamacao.getCliente_idCliente());
        buffer.append(", descricaoReclamacao=");
        buffer.append(retornarValorStringBD(reclamacao.getDescricaoReclamacao()));
        buffer.append(", tipo=");
        buffer.append(retornarValorStringBD(reclamacao.getTipo()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Reclamacao reclamacao) {
    	return
    			reclamacao.getIdReclamacao()
	        + ", "
	        + reclamacao.getCliente_idCliente()
	        + ", "
	        + retornarValorStringBD(reclamacao.getDescricaoReclamacao())
	        + ", "
	        + retornarValorStringBD(reclamacao.getTipo());
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
