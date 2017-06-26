package DAO;

import java.util.List;

import entidade.Produto_ListaDesejos;

public interface IProduto_ListaDesejos {

	public void update(Produto_ListaDesejos produto_ListaDesejos);
	public void insert(Produto_ListaDesejos produto_ListaDesejos);
	public Produto_ListaDesejos search(int idProduto_ListaDesejos);
	public void remove(Produto_ListaDesejos produto_ListaDesejos);
	public List<Produto_ListaDesejos> listar();
}
