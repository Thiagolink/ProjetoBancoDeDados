package DAO;

import java.util.List;

import entidade.Vendedor;

public interface IVendedor {

	public void update(Vendedor vendedor);
	public void insert(Vendedor vendedor);
	public Vendedor search(int idVendedor);
	public void remove(Vendedor vendedor);
	public List<Vendedor> listar();
}
