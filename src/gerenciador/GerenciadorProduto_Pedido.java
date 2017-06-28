package gerenciador;

import java.util.List;

import DAO.IProduto_Pedido;
import JDBC.Produto_PedidoJDBC;
import conexao.ConFactory;
import entidade.Produto_Pedido;

public class GerenciadorProduto_Pedido {
	
	private IProduto_Pedido daoProduto_Pedido;
	
	public GerenciadorProduto_Pedido() {
		daoProduto_Pedido= new Produto_PedidoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarProduto_Pedido(Produto_Pedido prod_ped){
		this.daoProduto_Pedido.insert(prod_ped);
    }

    public void removerProduto_Pedido(Produto_Pedido prod_ped) {
        this.daoProduto_Pedido.remove(prod_ped);
    }

    public void atualizarProduto_Pedido(Produto_Pedido prod_ped) {
        this.daoProduto_Pedido.update(prod_ped);
    }

    public List<Produto_Pedido> listarProduto_Pedido() {
        return this.daoProduto_Pedido.listar();
    }

    public Produto_Pedido getProduto_Pedido(int idProduto_Pedido) {
        return this.daoProduto_Pedido.search(idProduto_Pedido);
    }
	

}
