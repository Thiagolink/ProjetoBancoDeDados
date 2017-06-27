package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IEndereco;
import conexao.ConFactory;
import entidade.Endereco;

public class EnderecoJDBC implements IEndereco{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public EnderecoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Endereco endereco) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE ENDERECO SET ");
            buffer.append(returnFieldValuesBD(endereco));
            buffer.append(" WHERE IDENDERECO=");
            buffer.append(endereco.getIdEndereco());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no ENDERECO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Endereco endereco) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO ENDERECO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(endereco));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no ENDERECO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Endereco search(int idEndereco) {
		try{
			conectar();
			String sql = "SELECT * FROM ENDERECO WHERE IdEndereco=" + idEndereco; 
			ResultSet rs = comando.executeQuery(sql);
			Endereco endereco = new Endereco();
			if (rs.next()){
				
				endereco.setIdEndereco(rs.getInt("IdEndereco"));
				endereco.setPessoa_idPessoa(rs.getInt("pessoa_IdPessoa"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setPais(rs.getString("pais"));
				endereco.setRua(rs.getString("rua"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
			}
			System.out.println(endereco.getIdEndereco());
			fechar();
			return endereco;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Endereco endereco) {
		try {
        	conectar();
    		String sql ="DELETE FROM ENDERECO WHERE IdEndereco=" + endereco.getIdEndereco();
            System.out.println("SQL para REMOVER que fica no ENDERECO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Endereco> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM ENDERECO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Endereco> list = new ArrayList<Endereco>();
			if (rs.next()){
				
				Endereco endereco = new Endereco();
				
				endereco.setIdEndereco(rs.getInt("IdEndereco"));
				endereco.setPessoa_idPessoa(rs.getInt("pessoa_IdPessoa"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setPais(rs.getString("pais"));
				endereco.setRua(rs.getString("rua"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				list.add(endereco);
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
    	return "idEndereco, pessoa_idPessoa, complemento, estado, pais, rua, bairro, cidade";
    }
    
    protected String returnFieldValuesBD(Endereco endereco) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idEndereco=");
        buffer.append(endereco.getIdEndereco());
        buffer.append(", pessoa_idPessoa=");
        buffer.append(endereco.getPessoa_idPessoa());
        buffer.append(", complemento=");
        buffer.append(retornarValorStringBD(endereco.getComplemento()));
        buffer.append(", estado=");
        buffer.append(retornarValorStringBD(endereco.getEstado()));
        buffer.append(", pais=");
        buffer.append(retornarValorStringBD(endereco.getPais()));
        buffer.append(", rua=");
        buffer.append(retornarValorStringBD(endereco.getRua()));
        buffer.append(", bairro=");
        buffer.append(retornarValorStringBD(endereco.getBairro()));
        buffer.append(", cidade=");
        buffer.append(retornarValorStringBD(endereco.getCidade()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Endereco endereco) {
    	return
    			endereco.getIdEndereco()
	        + ", "
	        + endereco.getPessoa_idPessoa()
	        + ", "
	        + retornarValorStringBD(endereco.getComplemento())
	        + ", "
	        + retornarValorStringBD(endereco.getEstado())
	        + ", "
	        + retornarValorStringBD(endereco.getPais())
	        + ", "
	        + retornarValorStringBD(endereco.getRua())
	        + ", "
	        + retornarValorStringBD(endereco.getBairro())
	        + ", "
	        + retornarValorStringBD(endereco.getCidade());
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
