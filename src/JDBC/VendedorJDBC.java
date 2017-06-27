package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IVendedor;
import conexao.ConFactory;
import entidade.Administrador;
import entidade.Vendedor;

public class VendedorJDBC implements IVendedor{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public VendedorJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Vendedor vendedor) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE VENDEDOR SET ");
            buffer.append(returnFieldValuesBD(vendedor));
            buffer.append(" WHERE IDVENDEDOR=");
            buffer.append(vendedor.getIdVendedor());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no VENDEDOR : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Vendedor vendedor) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO VENDEDOR (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(vendedor));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no VENDEDOR : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Vendedor search(int idVendedor) {
		try{
			conectar();
			String sql = "SELECT * FROM VENDEDOR WHERE IdVendedor=" + idVendedor; 
			ResultSet rs = comando.executeQuery(sql);
			Vendedor vendedor = new Vendedor();
			if (rs.next()){
				
				vendedor.setIdVendedor(rs.getInt("IdVendedor"));
				vendedor.setUsuario_idUsuario(rs.getInt("Usuario_IdUsuario"));
				vendedor.setSalario(rs.getInt("salario"));
			}
			System.out.println(vendedor.getIdVendedor());
			fechar();
			return vendedor;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Vendedor vendedor) {
		try {
        	conectar();
    		String sql ="DELETE FROM VENDEDOR WHERE IdVendedor=" + vendedor.getIdVendedor();
            System.out.println("SQL para REMOVER que fica no VENDEDOR : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Vendedor> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM VENDEDOR"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Vendedor> list = new ArrayList<Vendedor>();
			if (rs.next()){
				
				Vendedor vendedor = new Vendedor();
				
				vendedor.setIdVendedor(rs.getInt("IdVendedor"));
				vendedor.setUsuario_idUsuario(rs.getInt("Usuario_IdUsuario"));
				vendedor.setSalario(rs.getInt("salario"));
				list.add(vendedor);
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
    	return "idVendedor, usuario_idUsuario, salario";
    }
    
    protected String returnFieldValuesBD(Vendedor vendedor) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idVendedor=");
        buffer.append(vendedor.getIdVendedor());
        buffer.append(", usuario_idUsuario=");
        buffer.append(vendedor.getUsuario_idUsuario());
        buffer.append(", salario=");
        buffer.append(vendedor.getSalario());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Vendedor vendedor) {
    	return
    			vendedor.getIdVendedor()
	        + ", "
	        + vendedor.getUsuario_idUsuario()
	        + ", "
	        + vendedor.getSalario();
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
