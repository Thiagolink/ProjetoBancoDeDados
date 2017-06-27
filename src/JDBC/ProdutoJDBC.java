package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.IProduto;
import conexao.ConFactory;
import entidade.Produto;

public class ProdutoJDBC implements IProduto{

	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;

	public ProdutoJDBC(String server, String user, String password, int banco) {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}
	
	@Override
	public void update(Produto produto) {
		try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE PRODUTO SET ");
            buffer.append(returnFieldValuesBD(produto));
            buffer.append(" WHERE IDPRODUTO=");
            buffer.append(produto.getIdProduto());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no PRODUTO : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Produto produto) {
		try {
			
			conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO PRODUTO (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(produto));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR que fica no PRODUTO : " + sql);

	        comando.executeUpdate(sql);
	        fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Produto search(int idProduto) {
		try{
			conectar();
			String sql = "SELECT * FROM PRODUTO WHERE IdProduto=" + idProduto; 
			ResultSet rs = comando.executeQuery(sql);
			Produto produto = new Produto();
			if (rs.next()){
				
				produto.setIdProduto(rs.getInt("IdProduto"));
				produto.setPromocoes_idPromocoes(rs.getInt("promocoes_IdPromocoes"));
				produto.setDepartamentos_idDepartamentos(rs.getInt("departamentos_IdDepartamentos"));
				produto.setFornecedor_idFornecedor(rs.getInt("fornecedor_IdFornecedor"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setMarca(rs.getString("marca"));
				produto.setTamanho(rs.getString("tamanho"));
				produto.setEstoque(rs.getInt("estoque"));
			}
			System.out.println(produto.getIdProduto());
			fechar();
			return produto;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void remove(Produto produto) {
		try {
        	conectar();
    		String sql ="DELETE FROM PRODUTO WHERE IdProduto=" + produto.getIdProduto();
            System.out.println("SQL para REMOVER que fica no PRODUTO : "+sql);
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produto> listar() {
		try{
			conectar();
			String sql = "SELECT * FROM PRODUTO"; 
			ResultSet rs = comando.executeQuery(sql);
			List<Produto> list = new ArrayList<Produto>();
			if (rs.next()){
				
				Produto produto = new Produto();
				
				produto.setIdProduto(rs.getInt("IdProduto"));
				produto.setPromocoes_idPromocoes(rs.getInt("promocoes_IdPromocoes"));
				produto.setDepartamentos_idDepartamentos(rs.getInt("departamentos_IdDepartamentos"));
				produto.setFornecedor_idFornecedor(rs.getInt("fornecedor_IdFornecedor"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setMarca(rs.getString("marca"));
				produto.setTamanho(rs.getString("tamanho"));
				produto.setEstoque(rs.getInt("estoque"));
				list.add(produto);
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
    	return "idProduto, promocoes_idPromocoes, departamentos_idDepartamentos, fornecedor_idFornecedor, nome, descricao, preco, marca, tamanho, estoque";
    }
    
    protected String returnFieldValuesBD(Produto produto) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("idProduto=");
        buffer.append(produto.getIdProduto());
        buffer.append(", promocoes_idPromocoes=");
        buffer.append(produto.getPromocoes_idPromocoes());
        buffer.append(", departamentos_idDepartamentos=");
        buffer.append(produto.getDepartamentos_idDepartamentos());
        buffer.append(", fornecedor_idFornecedor=");
        buffer.append(produto.getFornecedor_idFornecedor());
        buffer.append(", nome=");
        buffer.append(retornarValorStringBD(produto.getNome()));
        buffer.append(", descricao=");
        buffer.append(retornarValorStringBD(produto.getDescricao()));
        buffer.append(", preco=");
        buffer.append(produto.getPreco());
        buffer.append(", marca=");
        buffer.append(retornarValorStringBD(produto.getMarca()));
        buffer.append(", tamanho=");
        buffer.append(retornarValorStringBD(produto.getTamanho()));
        buffer.append(", estoque=");
        buffer.append(produto.getEstoque());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Produto produto) {
    	return
    			produto.getIdProduto()
	        + ", "
	        + produto.getPromocoes_idPromocoes()
	        + ", "
	        + produto.getDepartamentos_idDepartamentos()
	        + ", "
	        + produto.getFornecedor_idFornecedor()
	        + ", "
	        + retornarValorStringBD(produto.getNome())
	        + ", "
	        + retornarValorStringBD(produto.getDescricao())
	        + ", "
	        + produto.getPreco()
	        + ", "
	        + retornarValorStringBD(produto.getMarca())
	        + ", "
	        + retornarValorStringBD(produto.getTamanho())
	        + ", "
	        + produto.getEstoque();
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
