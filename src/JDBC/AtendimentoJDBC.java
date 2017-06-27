package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IAtendimento;
import conexao.ConFactory;
import entidade.Atendimento;

public class AtendimentoJDBC implements IAtendimento{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;	
	
	public AtendimentoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Atendimento atendimento) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE ATENDIMENTO SET ");
            buffer.append(returnFieldValuesBD(atendimento));
            buffer.append(" WHERE IDATENDIMENTO=");
            buffer.append(atendimento.getIdAtendimento());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no ATENDIMENTO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Atendimento atendimento) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO ATENDIMENTO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(atendimento));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no ATENDIMENTO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Atendimento search(int idAtendimento) {
		try{
			conectar();
			String sql = "SELECT * FROM ATENDIMENTO WHERE idAtendimento=" + idAtendimento; 
			ResultSet rs = comando.executeQuery(sql);
			Atendimento atendimento = new Atendimento();
			if (rs.next()){
				
				atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
				atendimento.setReclamacao_idReclamacao(rs.getInt("reclamacao_idReclamacao"));
				atendimento.setVendedor_idVendedor(rs.getInt("vendedor_idVendedor"));
				atendimento.setDataAtendimento(rs.getDate("dataAtendimento"));
				atendimento.setDescricaoAtendimento(rs.getString("descricaoAtendimento"));
			}
			System.out.println(atendimento.getIdAtendimento());
			fechar();
			return atendimento;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Atendimento atendimento) {
		try {
        	conectar();
    		String sql ="DELETE FROM ATENDIMENTO WHERE idAtendimento=" + atendimento.getIdAtendimento();
            System.out.println("SQL para REMOVER que fica no ATENDIMENTO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Atendimento> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM ATENDIMENTO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Atendimento> list = new ArrayList<Atendimento>();
			if (rs.next()){
				
				Atendimento atendimento = new Atendimento();
				
				atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
				atendimento.setReclamacao_idReclamacao(rs.getInt("reclamacao_idReclamacao"));
				atendimento.setVendedor_idVendedor(rs.getInt("vendedor_idVendedor"));
				atendimento.setDataAtendimento(rs.getDate("dataAtendimento"));
				atendimento.setDescricaoAtendimento(rs.getString("descricaoAtendimento"));
				list.add(atendimento);
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
    	return "idAtendimento, reclamacao_idReclamacao, vendedor_idVendedor, dataAtendimento, descricaoAtendimento";
    }
    
    protected String returnFieldValuesBD(Atendimento atendimento) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idAtendimento=");
        buffer.append(atendimento.getIdAtendimento());
        buffer.append(", reclamacao_idReclamacao=");
        buffer.append(atendimento.getReclamacao_idReclamacao());
        buffer.append(", vendedor_idVendedor=");
        buffer.append(atendimento.getVendedor_idVendedor());
        buffer.append(", dataAtendimento=");
        buffer.append(retornarValorStringBD(atendimento.getDataAtendimento().toString()));
        buffer.append(", descricaoAtendimento=");
        buffer.append(retornarValorStringBD(atendimento.getDescricaoAtendimento()));

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Atendimento atendimento) {
    	return
    		atendimento.getIdAtendimento()
	        + ", "
	        + atendimento.getReclamacao_idReclamacao()
	        + ", "
	        + atendimento.getVendedor_idVendedor()
	        + ", "
	        + retornarValorStringBD(atendimento.getDataAtendimento().toString())
	        + ", "
	        + retornarValorStringBD(atendimento.getDescricaoAtendimento());
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
