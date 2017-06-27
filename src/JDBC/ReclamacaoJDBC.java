package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE RECLAMACAO SET ");
            buffer.append(returnFieldValuesBD(reclamacao));
            buffer.append(" WHERE IDRECLAMACAO=");
            buffer.append(reclamacao.getIdReclamacao());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no RECLAMACAO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Reclamacao reclamacao) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO RECLAMACAO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(reclamacao));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no RECLAMACAO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Reclamacao search(int idReclamacao) {
		try{
			conectar();
			String sql = "SELECT * FROM RECLAMACAO WHERE IdReclamacao=" + idReclamacao; 
			ResultSet rs = comando.executeQuery(sql);
			Reclamacao reclamacao = new Reclamacao();
			if (rs.next()){
				
				reclamacao.setIdReclamacao(rs.getInt("IdReclamacao"));
				reclamacao.setCliente_idCliente(rs.getInt("cliente_IdCliente"));
				reclamacao.setDescricaoReclamacao(rs.getString("descricaoReclamacao"));
				reclamacao.setTipo(rs.getString("tipo"));
			}
			System.out.println(reclamacao.getIdReclamacao());
			fechar();
			return reclamacao;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Reclamacao reclamacao) {
		try {
        	conectar();
    		String sql ="DELETE FROM RECLAMACAO WHERE IdReclamacao=" + reclamacao.getIdReclamacao();
            System.out.println("SQL para REMOVER que fica no RECLAMACAO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Reclamacao> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM RECLAMACAO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Reclamacao> list = new ArrayList<Reclamacao>();
			if (rs.next()){
				
				Reclamacao reclamacao = new Reclamacao();
				
				reclamacao.setIdReclamacao(rs.getInt("IdReclamacao"));
				reclamacao.setCliente_idCliente(rs.getInt("cliente_IdCliente"));
				reclamacao.setDescricaoReclamacao(rs.getString("descricaoReclamacao"));
				reclamacao.setTipo(rs.getString("tipo"));
				list.add(reclamacao);
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
