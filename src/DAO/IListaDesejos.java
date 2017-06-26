package DAO;

import java.util.List;

import entidade.ListaDesejos;

public interface IListaDesejos {
	public void update(ListaDesejos listaDesejos);
	public void insert(ListaDesejos listaDesejos);
	public ListaDesejos search(int idListaDesejos);
	public void remove(ListaDesejos listaDesejos);
	public List<ListaDesejos> listar();
}
