package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IFornecedor;
import conexao.ConFactory;
import entidade.Fornecedor;

public class FornecedorJDBC implements IFornecedor{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public FornecedorJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Fornecedor fornecedor) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE FORNECEDOR SET ");
            buffer.append(returnFieldValuesBD(fornecedor));
            buffer.append(" WHERE IDFORNECEDOR=");
            buffer.append(fornecedor.getIdFornecedor());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no FORNECEDOR : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Fornecedor fornecedor) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO FORNECEDOR (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(fornecedor));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no FORNECEDOR : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Fornecedor search(int idFornecedor) {
		try{
			conectar();
			String sql = "SELECT * FROM FORNECEDOR WHERE IdFornecedor=" + idFornecedor; 
			ResultSet rs = comando.executeQuery(sql);
			Fornecedor fornecedor = new Fornecedor();
			if (rs.next()){
				
				fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
				fornecedor.setPessoa_idPessoa(rs.getInt("pessoa_IdPessoa"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCNPJ(rs.getInt("CNPJ"));
			}
			System.out.println(fornecedor.getIdFornecedor());
			fechar();
			return fornecedor;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		try {
        	conectar();
    		String sql ="DELETE FROM FORNECEDOR WHERE IdFornecedor=" + fornecedor.getIdFornecedor();
            System.out.println("SQL para REMOVER que fica no FORNECEDOR : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Fornecedor> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM FORNECEDOR"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Fornecedor> list = new ArrayList<Fornecedor>();
			if (rs.next()){
				
				Fornecedor fornecedor = new Fornecedor();
				
				fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
				fornecedor.setPessoa_idPessoa(rs.getInt("pessoa_IdPessoa"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCNPJ(rs.getInt("CNPJ"));
				list.add(fornecedor);
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
    	return "idFornecedor, pessoa_idPessoa, nome, CNPJ";
    }
    
    protected String returnFieldValuesBD(Fornecedor fornecedor) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idFornecedor=");
        buffer.append(fornecedor.getIdFornecedor());
        buffer.append(", pessoa_idPessoa=");
        buffer.append(fornecedor.getPessoa_idPessoa());
        buffer.append(", nome=");
        buffer.append(retornarValorStringBD(fornecedor.getNome()));
        buffer.append(", CNPJ=");
        buffer.append(fornecedor.getCNPJ());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Fornecedor fornecedor) {
    	return
    			fornecedor.getIdFornecedor()
	        + ", "
	        + fornecedor.getPessoa_idPessoa()
	        + ", "
	        + retornarValorStringBD(fornecedor.getNome())
	        + ", "
	        + fornecedor.getCNPJ();
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
