package DAO;

import java.util.List;

import entidade.Administrador;


public interface IAdministrador {

	public void update(Administrador administrador);
	public void insert(Administrador administrador);
	public Administrador search(int idAdministrador);
	public void remove(Administrador administrador);
	public List<Administrador> listar();
	
}
