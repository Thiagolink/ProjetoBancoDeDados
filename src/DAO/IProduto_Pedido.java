package DAO;

import java.util.List;

import entidade.Produto_Pedido;

public interface IProduto_Pedido {

	public void update(Produto_Pedido produto_pedido);
	public void insert(Produto_Pedido produto_pedido);
	public Produto_Pedido search(int produto_pedido);
	public void remove(Produto_Pedido produto_pedido);
	public List<Produto_Pedido> listar();
}
