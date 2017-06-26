package DAO;

import java.util.List;

import entidade.Fornecedor;

public interface IFornecedor {
	
	public void update(Fornecedor fornecedor);
	public void insert(Fornecedor fornecedor);
	public Fornecedor search(int idFornecedor);
	public void remove(Fornecedor fornecedor);
	public List<Fornecedor> listar();
}
