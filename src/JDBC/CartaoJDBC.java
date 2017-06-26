package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.ICartao;
import conexao.ConFactory;
import entidade.Cartao;

public class CartaoJDBC implements ICartao{
	
	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public CartaoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Cartao cartao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Cartao cartao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cartao search(int idCartao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Cartao cartao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cartao> listar() {
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
    	return "idCartao, pagamento_idPagamento, nome, codigoSeguranca, numeroCartao, dataVencimentoCartao, bandeira";
    }
    
    protected String returnFieldValuesBD(Cartao cartao) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idCartao=");
        buffer.append(cartao.getIdCartao());
        buffer.append(", pagamento_idPagamento=");
        buffer.append(cartao.getPagamento_idPagamento());
        buffer.append(", nome=");
        buffer.append(retornarValorStringBD(cartao.getNome()));
        buffer.append(", codigoSeguranca=");
        buffer.append(cartao.getCodigoSeguranca());
        buffer.append(", numeroCartao=");
        buffer.append(cartao.getNumeroCartao());
        buffer.append(", dataVencimentoCartao=");
        buffer.append(retornarValorStringBD(cartao.getDataVencimentoCartao().toString()));
        buffer.append(", bandeira=");
        buffer.append(retornarValorStringBD(cartao.getBandeira()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Cartao cartao) {
    	return
    			cartao.getIdCartao()
	        + ", "
	        + cartao.getPagamento_idPagamento()
	        + ", "
	        + retornarValorStringBD(cartao.getNome())
	        + ", "
	        + cartao.getCodigoSeguranca()
	        + ", "
	        + cartao.getNumeroCartao()
	        + ", "
	        + retornarValorStringBD(cartao.getDataVencimentoCartao().toString())
	        + ", "
	        + retornarValorStringBD(cartao.getBandeira());
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
