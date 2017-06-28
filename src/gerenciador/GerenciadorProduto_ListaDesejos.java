package gerenciador;

import java.util.List;

import DAO.IProduto_ListaDesejos;
import JDBC.Produto_ListaDesejosJDBC;
import conexao.ConFactory;
import entidade.Produto_ListaDesejos;

public class GerenciadorProduto_ListaDesejos {

	private IProduto_ListaDesejos daoProduto_ListaDesejos;

	public GerenciadorProduto_ListaDesejos() {
		daoProduto_ListaDesejos= new Produto_ListaDesejosJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarProduto_ListaDesejos(Produto_ListaDesejos produto_ListaDesejos){
		this.daoProduto_ListaDesejos.insert(produto_ListaDesejos);
    }

    public void removerProduto_ListaDesejos(Produto_ListaDesejos produto_ListaDesejos) {
        this.daoProduto_ListaDesejos.remove(produto_ListaDesejos);
    }

    public void atualizarProduto_ListaDesejos(Produto_ListaDesejos produto_ListaDesejos) {
        this.daoProduto_ListaDesejos.update(produto_ListaDesejos);
    }

    public List<Produto_ListaDesejos> listarProduto_ListaDesejos() {
        return this.daoProduto_ListaDesejos.listar();
    }

    public Produto_ListaDesejos getProduto_ListaDesejos(int idProduto_ListaDesejos) {
        return this.daoProduto_ListaDesejos.search(idProduto_ListaDesejos);
    }
}
