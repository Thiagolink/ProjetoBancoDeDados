package DAO;

import java.util.List;

import entidade.Promocoes;

public interface IPromocoes {

	public void update(Promocoes promocoes);
	public void insert(Promocoes promoces);
	public Promocoes search(int idPromocoes);
	public void remove(Promocoes promocoes);
	public List<Promocoes> listar();
}
