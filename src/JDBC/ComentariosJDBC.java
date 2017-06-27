package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IComentarios;
import conexao.ConFactory;
import entidade.Comentarios;

public class ComentariosJDBC implements IComentarios{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public ComentariosJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Comentarios comentarios) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE COMENTARIOS SET ");
            buffer.append(returnFieldValuesBD(comentarios));
            buffer.append(" WHERE IDCOMENTARIOS=");
            buffer.append(comentarios.getIdComentarios());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no COMENTARIOS : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Comentarios comentarios) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO COMENTARIOS (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(comentarios));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no COMENTARIOS : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Comentarios search(int idComentarios) {
		try{
			conectar();
			String sql = "SELECT * FROM COMENTARIOS WHERE idComentarios=" + idComentarios; 
			ResultSet rs = comando.executeQuery(sql);
			Comentarios comentarios = new Comentarios();
			if (rs.next()){
				
				comentarios.setIdComentarios(rs.getInt("idComentarios"));
				comentarios.setCliente_idCliente(rs.getInt("cliente_idCliente"));
				comentarios.setProduto_idProduto(rs.getInt("produto_idProduto"));
				comentarios.setDescricao(rs.getString("descricao"));
				comentarios.setPros(rs.getString("pros"));
				comentarios.setContras(rs.getString("contras"));
				comentarios.setOpiniaoGeral(rs.getString("opiniaoGeral"));
				comentarios.setNota(rs.getInt("nota"));
			}
			System.out.println(comentarios.getIdComentarios());
			fechar();
			return comentarios;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Comentarios comentarios) {
		try {
        	conectar();
    		String sql ="DELETE FROM COMENTARIOS WHERE idComentarios=" + comentarios.getIdComentarios();
            System.out.println("SQL para REMOVER que fica no COMENTARIOS : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Comentarios> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM COMENTARIOS"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Comentarios> list = new ArrayList<Comentarios>();
			if (rs.next()){
				
				Comentarios comentarios = new Comentarios();
				
				comentarios.setIdComentarios(rs.getInt("idComentarios"));
				comentarios.setCliente_idCliente(rs.getInt("cliente_idCliente"));
				comentarios.setProduto_idProduto(rs.getInt("produto_idProduto"));
				comentarios.setDescricao(rs.getString("descricao"));
				comentarios.setPros(rs.getString("pros"));
				comentarios.setContras(rs.getString("contras"));
				comentarios.setOpiniaoGeral(rs.getString("opiniaoGeral"));
				comentarios.setNota(rs.getInt("nota"));
				list.add(comentarios);
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
    	return "idComentarios, cliente_idCliente, prodto_idProduto, descricao, pros, contras, opiniaoGeral, nota";
    }
    
    protected String returnFieldValuesBD(Comentarios comentarios) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idComentarios=");
        buffer.append(comentarios.getIdComentarios());
        buffer.append(", cliente_idCliente=");
        buffer.append(comentarios.getCliente_idCliente());
        buffer.append(", prodto_idProduto=");
        buffer.append(comentarios.getProduto_idProduto());
        buffer.append(", descricao=");
        buffer.append(retornarValorStringBD(comentarios.getDescricao()));
        buffer.append(", pros=");
        buffer.append(retornarValorStringBD(comentarios.getPros()));
        buffer.append(", contras=");
        buffer.append(retornarValorStringBD(comentarios.getContras()));
        buffer.append(", opiniaoGeral=");
        buffer.append(retornarValorStringBD(comentarios.getOpiniaoGeral()));
        buffer.append(", nota=");
        buffer.append(comentarios.getNota());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Comentarios comentarios) {
    	return
    		comentarios.getIdComentarios()
	        + ", "
	        + comentarios.getCliente_idCliente()
	        + ", "
	        + comentarios.getProduto_idProduto()
	        + ", "
	        + retornarValorStringBD(comentarios.getDescricao())
	        + ", "
	        + retornarValorStringBD(comentarios.getPros())
	        + ", "
	        + retornarValorStringBD(comentarios.getContras())
	        + ", "
	        + retornarValorStringBD(comentarios.getOpiniaoGeral())
	        + ", "
	        + comentarios.getNota();
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
