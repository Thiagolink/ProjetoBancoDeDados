package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ITelefone;
import conexao.ConFactory;
import entidade.Telefone;

public class TelefoneJDBC implements ITelefone{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public TelefoneJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Telefone telefone) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE TELEFONE SET ");
            buffer.append(returnFieldValuesBD(telefone));
            buffer.append(" WHERE IDTELEFONE=");
            buffer.append(telefone.getIdTelefone());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no TELEFONE : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Telefone telefone) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO TELEFONE (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(telefone));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no TELEFONE : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Telefone search(int idTelefone) {
		try{
			conectar();
			String sql = "SELECT * FROM TELEFONE WHERE IdTelefone=" + idTelefone; 
			ResultSet rs = comando.executeQuery(sql);
			Telefone telefone = new Telefone();
			if (rs.next()){
				
				telefone.setIdTelefone(rs.getInt("IdTelefone"));
				telefone.setPessoa_idPessoa(rs.getInt("pessoa_IdPessoa"));
				telefone.setNumero(rs.getInt("numero"));
			}
			System.out.println(telefone.getIdTelefone());
			fechar();
			return telefone;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Telefone telefone) {
		try {
        	conectar();
    		String sql ="DELETE FROM TELEFONE WHERE IdTelefone=" + telefone.getIdTelefone();
            System.out.println("SQL para REMOVER que fica no TELEFONE : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Telefone> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM TELEFONE"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Telefone> list = new ArrayList<Telefone>();
			if (rs.next()){
				
				Telefone telefone = new Telefone();
				
				telefone.setIdTelefone(rs.getInt("IdTelefone"));
				telefone.setPessoa_idPessoa(rs.getInt("pessoa_IdPessoa"));
				telefone.setNumero(rs.getInt("numero"));
				list.add(telefone);
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
    	return "idTelefone, pessoa_idPessoa, numero";
    }
    
    protected String returnFieldValuesBD(Telefone telefone) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idTelefone=");
        buffer.append(telefone.getIdTelefone());
        buffer.append(", pessoa_idPessoa=");
        buffer.append(telefone.getPessoa_idPessoa());
        buffer.append(", numero=");
        buffer.append(telefone.getNumero());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Telefone telefone) {
    	return
    			telefone.getIdTelefone()
	        + ", "
	        + telefone.getPessoa_idPessoa()
	        + ", "
	        + telefone.getNumero();
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
