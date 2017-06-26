package DAO;

import java.util.List;

import entidade.Cliente;

public interface ICliente {
	
	public void update(Cliente cliente);
	public void insert(Cliente ciente);
	public Cliente search(int idCliente);
	public void remove(Cliente cliente);
	public List<Cliente> listar();
}
