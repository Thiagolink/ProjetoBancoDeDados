package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE PAGAMENTO SET ");
            buffer.append(returnFieldValuesBD(pagamento));
            buffer.append(" WHERE IDPAGAMENTO=");
            buffer.append(pagamento.getIdPagamento());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no PAGAMENTO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Pagamento pagamento) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO PAGAMENTO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(pagamento));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no PAGAMENTO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Pagamento search(int idPagamento) {
		try{
			conectar();
			String sql = "SELECT * FROM PAGAMENTO WHERE IdPagamento=" + idPagamento; 
			ResultSet rs = comando.executeQuery(sql);
			Pagamento pagamento = new Pagamento();
			if (rs.next()){
				
				pagamento.setIdPagamento(rs.getInt("IdPagamento"));
				pagamento.setValorTotal(rs.getFloat("valorTotal"));
			}
			System.out.println(pagamento.getIdPagamento());
			fechar();
			return pagamento;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Pagamento pagamento) {
		try {
        	conectar();
    		String sql ="DELETE FROM PAGAMENTO WHERE IdPagamento=" + pagamento.getIdPagamento();
            System.out.println("SQL para REMOVER que fica no PAGAMENTO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Pagamento> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM PAGAMENTO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Pagamento> list = new ArrayList<Pagamento>();
			if (rs.next()){
				
				Pagamento pagamento = new Pagamento();
				
				pagamento.setIdPagamento(rs.getInt("IdPagamento"));
				pagamento.setValorTotal(rs.getFloat("valorTotal"));
				list.add(pagamento);
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
