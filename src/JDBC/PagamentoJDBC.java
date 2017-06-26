package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IPagamento;
import conexao.ConFactory;
import entidade.Pagamento;

public class PagamentoJDBC implements IPagamento{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public PagamentoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pagamento search(int idPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pagamento> listar() {
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
    	return "idPagamento, valorTotal";
    }
    
    protected String returnFieldValuesBD(Pagamento pagamento) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idPagamento=");
        buffer.append(pagamento.getIdPagamento());
        buffer.append(", valorTotal=");
        buffer.append(pagamento.getValorTotal());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Pagamento pagamento) {
    	return
    			pagamento.getIdPagamento()
	        + ", "
	        + pagamento.getValorTotal();
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
