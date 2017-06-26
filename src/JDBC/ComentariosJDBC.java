package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Comentarios comentarios) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comentarios search(int idComentarios) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Comentarios comentarios) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comentarios> listar() {
		// TODO Auto-generated method stub
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
