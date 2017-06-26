package DAO;

import java.util.List;

import entidade.Endereco;

public interface IEndereco {

	public void update(Endereco endereco);
	public void insert(Endereco endereco);
	public Endereco search(int idEndereco);
	public void remove(Endereco endereco);
	public List<Endereco> listar();
}
