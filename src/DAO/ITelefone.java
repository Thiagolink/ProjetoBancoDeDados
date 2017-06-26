package DAO;

import java.util.List;

import entidade.Telefone;

public interface ITelefone {
	
	public void update(Telefone telefone);
	public void insert(Telefone telefone);
	public Telefone search(int idTelefone);
	public void remove(Telefone telefone);
	public List<Telefone> listar();
}
