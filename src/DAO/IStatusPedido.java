package DAO;

import java.util.List;

import entidade.StatusPedido;

public interface IStatusPedido {
	
	public void update(StatusPedido statusPedido);
	public void insert(StatusPedido statusPedido);
	public StatusPedido search(int idStatusPedido);
	public void remove(StatusPedido statusPedido);
	public List<StatusPedido> listar();
}
