package gerenciador;

import java.util.List;

import DAO.IProduto;
import JDBC.ProdutoJDBC;
import conexao.ConFactory;
import entidade.Produto;

public class GerenciadorProduto {

	private IProduto daoProduto;
	
	public GerenciadorProduto() {
		daoProduto= new ProdutoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarProduto(Produto produto){
		this.daoProduto.insert(produto);
    }

    public void removerProduto(Produto produto) {
        this.daoProduto.remove(produto);
    }

    public void atualizarProduto(Produto produto) {
        this.daoProduto.update(produto);
    }

    public List<Produto> listarProduto() {
        return this.daoProduto.listar();
    }

    public Produto getProduto(int idProduto) {
        return this.daoProduto.search(idProduto);
    }
}
