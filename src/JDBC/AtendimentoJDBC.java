package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IAtendimento;
import conexao.ConFactory;
import entidade.Atendimento;

public class AtendimentoJDBC implements IAtendimento{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	
	
	
	public AtendimentoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	
	@Override
	public void update(Atendimento atendimento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Atendimento atendimento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atendimento search(int idAtendimento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Atendimento atendimento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Atendimento> listar() {
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
    	return "idAtendimento, reclamacao_idReclamacao, vendedor_idVendedor, dataAtendimento, descricaoAtendimento";
    }
    
    protected String returnFieldValuesBD(Atendimento atendimento) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idAtendimento=");
        buffer.append(atendimento.getIdAtendimento());
        buffer.append(", reclamacao_idReclamacao=");
        buffer.append(atendimento.getReclamacao_idReclamacao());
        buffer.append(", vendedor_idVendedor=");
        buffer.append(atendimento.getVendedor_idVendedor());
        buffer.append(", dataAtendimento=");
        buffer.append(retornarValorStringBD(atendimento.getDataAtendimento().toString()));
        buffer.append(", descricaoAtendimento=");
        buffer.append(retornarValorStringBD(atendimento.getDescricaoAtendimento()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Atendimento atendimento) {
    	return
    		atendimento.getIdAtendimento()
	        + ", "
	        + atendimento.getReclamacao_idReclamacao()
	        + ", "
	        + atendimento.getVendedor_idVendedor()
	        + ", "
	        + retornarValorStringBD(atendimento.getDataAtendimento().toString())
	        + ", "
	        + retornarValorStringBD(atendimento.getDescricaoAtendimento());
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
