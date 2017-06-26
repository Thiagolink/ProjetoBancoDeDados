package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto search(int idProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> listar() {
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
