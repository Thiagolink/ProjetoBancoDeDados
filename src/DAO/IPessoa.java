package DAO;

import java.util.List;

import entidade.Pessoa;

public interface IPessoa {
	
	public void update(Pessoa pessoa);
	public void insert(Pessoa pessoa);
	public Pessoa search(int idPessoa);
	public void remove(Pessoa pessoa);
	public List<Pessoa> listar();
}
