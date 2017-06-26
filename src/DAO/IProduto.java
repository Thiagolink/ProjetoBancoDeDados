package DAO;

import java.util.List;

import entidade.Produto;

public interface IProduto {
	
	public void update(Produto produto);
	public void insert(Produto produto);
	public Produto search(int idProduto);
	public void remove(Produto produto);
	public List<Produto> listar();
}
