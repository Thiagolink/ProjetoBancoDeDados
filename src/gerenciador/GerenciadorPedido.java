package gerenciador;

import java.util.ArrayList;
import java.util.List;

import DAO.IPedido;
import JDBC.PedidoJDBC;
import conexao.ConFactory;
import entidade.Pedido;
import entidade.Produto;
import entidade.Produto_Pedido;


public class GerenciadorPedido {
	
	private IPedido daoPedido;
	private GerenciadorProduto_Pedido produto_pedido;
	private GerenciadorProduto produto;
	
	public GerenciadorPedido() {
		this.daoPedido = new PedidoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
		this.produto_pedido = new GerenciadorProduto_Pedido();
		this.produto = new GerenciadorProduto();
	}
	
	public void cadastrarPedido(Pedido pedido){
		this.daoPedido.insert(pedido);
    }

    public void removerPedido(Pedido pedido) {
        this.daoPedido.remove(pedido);
    }

    public void atualizarPedido(Pedido pedido) {
        this.daoPedido.update(pedido);
    }

    public List<Pedido> listarPedido() {
        return this.daoPedido.listar();
    }

    public Pedido getPedido(int idPedido) {
        return this.daoPedido.search(idPedido);
    }
    
    public void atribuiValor(Pedido pedido){
    	List<Integer> listIds = new ArrayList<Integer>();
    	List<Produto_Pedido> listProduto_Pedido = new ArrayList<Produto_Pedido>();
    	Produto produto = new Produto();
    	listProduto_Pedido = this.produto_pedido.listarProduto_Pedido();
    	
		for(int i = 0; i < listProduto_Pedido.size(); i++){
			if(pedido.getIdPedido() == listProduto_Pedido.get(i).getPedido_idPedido()){
				listIds.add(listProduto_Pedido.get(i).getProduto_idProduto());
			}	
		}
		
		for(int i = 0; i < listIds.size(); i++){
			produto = this.produto.getProduto(listIds.get(i));
			pedido.setValorCompra(pedido.getValorCompra() + produto.getPreco());
		}
    }
}
    
    