package DAO;

import java.util.List;

import entidade.Pedido;

public interface IPedido {
	
	public void update(Pedido pedido);
	public void insert(Pedido pedido);
	public Pedido search(int idPedido);
	public void remove(Pedido pedido);
	public List<Pedido> listar();
}
