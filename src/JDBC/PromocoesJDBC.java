package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE PROMOCOES SET ");
            buffer.append(returnFieldValuesBD(promocoes));
            buffer.append(" WHERE IDPROMOCOES=");
            buffer.append(promocoes.getIdPromocoes());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no PROMOCOES : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Promocoes promocoes) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO PROMOCOES (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(promocoes));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no PROMOCOES : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Promocoes search(int idPromocoes) {
		try{
			conectar();
			String sql = "SELECT * FROM PROMOCOES WHERE IdPromocoes=" + idPromocoes; 
			ResultSet rs = comando.executeQuery(sql);
			Promocoes promocoes = new Promocoes();
			if (rs.next()){
				
				promocoes.setIdPromocoes(rs.getInt("IdPromocoes"));
				promocoes.setDesconto(rs.getString("desconto"));
				promocoes.setTempoAtiva(rs.getString("tempoAtiva"));
			}
			System.out.println(promocoes.getIdPromocoes());
			fechar();
			return promocoes;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Promocoes promocoes) {
		try {
        	conectar();
    		String sql ="DELETE FROM PROMOCOES WHERE IdPromocoes=" + promocoes.getIdPromocoes();
            System.out.println("SQL para REMOVER que fica no PROMOCOES : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Promocoes> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM PROMOCOES"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Promocoes> list = new ArrayList<Promocoes>();
			if (rs.next()){
				
				Promocoes promocoes = new Promocoes();
				
				promocoes.setIdPromocoes(rs.getInt("IdPromocoes"));
				promocoes.setDesconto(rs.getString("desconto"));
				promocoes.setTempoAtiva(rs.getString("tempoAtiva"));
				list.add(promocoes);
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
