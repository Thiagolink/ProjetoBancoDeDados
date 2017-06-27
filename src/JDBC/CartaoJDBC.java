package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE CARTAO SET ");
            buffer.append(returnFieldValuesBD(cartao));
            buffer.append(" WHERE IDCARTAO=");
            buffer.append(cartao.getIdCartao());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no CARTAO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Cartao cartao) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO CARTAO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(cartao));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no CARTAO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Cartao search(int idCartao) {
		try{
			conectar();
			String sql = "SELECT * FROM CARTAO WHERE idCartao=" + idCartao; 
			ResultSet rs = comando.executeQuery(sql);
			Cartao cartao = new Cartao();
			if (rs.next()){
				
				cartao.setIdCartao(rs.getInt("idCartao"));
				cartao.setPagamento_idPagamento(rs.getInt("pagamento_idPagamento"));
				cartao.setNome(rs.getString("nome"));
				cartao.setCodigoSeguranca(rs.getInt("codigoSeguranca"));
				cartao.setNumeroCartao(rs.getInt("numeroCartao"));
				cartao.setDataVencimentoCartao(rs.getDate("dataVencimentoCartao"));
				cartao.setBandeira(rs.getString("bandeira"));
			}
			System.out.println(cartao.getIdCartao());
			fechar();
			return cartao;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Cartao cartao) {
		try {
        	conectar();
    		String sql ="DELETE FROM CARTAO WHERE idCartao=" + cartao.getIdCartao();
            System.out.println("SQL para REMOVER que fica no Cartao : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cartao> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM CARTAO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Cartao> list = new ArrayList<Cartao>();
			if (rs.next()){
				
				Cartao cartao = new Cartao();
				
				cartao.setIdCartao(rs.getInt("idCartao"));
				cartao.setPagamento_idPagamento(rs.getInt("pagamento_idPagamento"));
				cartao.setNome(rs.getString("nome"));
				cartao.setCodigoSeguranca(rs.getInt("codigoSeguranca"));
				cartao.setNumeroCartao(rs.getInt("numeroCartao"));
				cartao.setDataVencimentoCartao(rs.getDate("dataVencimentoCartao"));
				cartao.setBandeira(rs.getString("bandeira"));
				list.add(cartao);
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
