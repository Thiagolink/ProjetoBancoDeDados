package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IBoletoBancario;
import conexao.ConFactory;
import entidade.BoletoBancario;

public class BoletoBancarioJDBC implements IBoletoBancario{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public BoletoBancarioJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(BoletoBancario boletoBancario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(BoletoBancario boletoBancario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoletoBancario search(int idBoletobancario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(BoletoBancario boletoBancario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoletoBancario> listar() {
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
    	return "idBoletoBancario, pagamento_idPagamento, codigoBarras, banco, dataVencimento";
    }
    
    protected String returnFieldValuesBD(BoletoBancario boletoBancario) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idBoletoBancario=");
        buffer.append(boletoBancario.getIdBoletoBancario());
        buffer.append(", pagamento_idPagamento=");
        buffer.append(boletoBancario.getPagamento_idPagamento());
        buffer.append(", codigoBarras=");
        buffer.append(boletoBancario.getCodigoBarras());
        buffer.append(", banco=");
        buffer.append(retornarValorStringBD(boletoBancario.getBanco()));
        buffer.append(", dataVencimento=");
        buffer.append(retornarValorStringBD(boletoBancario.getDataVencimento().toString()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(BoletoBancario boletoBancario) {
    	return
    		boletoBancario.getIdBoletoBancario()
	        + ", "
	        + boletoBancario.getPagamento_idPagamento()
	        + ", "
	        + boletoBancario.getCodigoBarras()
	        + ", "
	        + retornarValorStringBD(boletoBancario.getBanco())
	        + ", "
	        + retornarValorStringBD(boletoBancario.getDataVencimento().toString());
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
