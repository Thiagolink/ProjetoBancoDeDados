package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE BOLETOBANCARIO SET ");
            buffer.append(returnFieldValuesBD(boletoBancario));
            buffer.append(" WHERE IDBOLETOBANCARIO=");
            buffer.append(boletoBancario.getIdBoletoBancario());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no BOLETOBANCARIO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(BoletoBancario boletoBancario) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO BOLETOBANCARIO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(boletoBancario));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no BOLETOBANCARIO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public BoletoBancario search(int idBoletobancario) {
		try{
			conectar();
			String sql = "SELECT * FROM BOLETOBANCARIO WHERE idBoletoBancario=" + idBoletobancario; 
			ResultSet rs = comando.executeQuery(sql);
			BoletoBancario boletoBancario = new BoletoBancario();
			if (rs.next()){
				
				boletoBancario.setIdBoletoBancario(rs.getInt("idBoletoBancario"));
				boletoBancario.setPagamento_idPagamento(rs.getInt("pagamento_idPagamento"));
				boletoBancario.setCodigoBarras(rs.getInt("codigoBarras"));
				boletoBancario.setBanco(rs.getString("banco"));
				boletoBancario.setDataVencimento(rs.getDate("dataVencimento"));
			}
			System.out.println(boletoBancario.getIdBoletoBancario());
			fechar();
			return boletoBancario;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(BoletoBancario boletoBancario) {
		try {
        	conectar();
    		String sql ="DELETE FROM BOLETOBANCARIO WHERE idBoletoBancario=" + boletoBancario.getIdBoletoBancario();
            System.out.println("SQL para REMOVER que fica no BOLETOBANCARIO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BoletoBancario> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM BOLETOBANCARIO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<BoletoBancario> list = new ArrayList<BoletoBancario>();
			if (rs.next()){
				
				BoletoBancario boletoBancario = new BoletoBancario();
				
				boletoBancario.setIdBoletoBancario(rs.getInt("idBoletoBancario"));
				boletoBancario.setPagamento_idPagamento(rs.getInt("pagamento_idPagamento"));
				boletoBancario.setCodigoBarras(rs.getInt("codigoBarras"));
				boletoBancario.setBanco(rs.getString("banco"));
				boletoBancario.setDataVencimento(rs.getDate("dataVencimento"));
				list.add(boletoBancario);
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
