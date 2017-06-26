package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IPromocoes;
import conexao.ConFactory;
import entidade.Promocoes;

public class PromocoesJDBC implements IPromocoes{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public PromocoesJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Promocoes promocoes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Promocoes promoces) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Promocoes search(int idPromocoes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Promocoes promocoes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promocoes> listar() {
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
    	return "idPromocoes, desconto, tempoAtiva";
    }
    
    protected String returnFieldValuesBD(Promocoes promocoes) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idPromocoes=");
        buffer.append(promocoes.getIdPromocoes());
        buffer.append(", desconto=");
        buffer.append(retornarValorStringBD(promocoes.getDesconto()));
        buffer.append(", tempoAtiva=");
        buffer.append(retornarValorStringBD(promocoes.getTempoAtiva()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Promocoes promocoes) {
    	return
    			promocoes.getIdPromocoes()
	        + ", "
	        + retornarValorStringBD(promocoes.getDesconto())
	        + ", "
	        + retornarValorStringBD(promocoes.getTempoAtiva());
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
