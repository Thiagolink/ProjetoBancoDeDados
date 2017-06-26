package DAO;

import java.util.List;

import entidade.Departamentos;

public interface IDepartamentos {
	
	public void update(Departamentos departamentos);
	public void insert(Departamentos departamentos);
	public Departamentos search(int idDepartamentos);
	public void remove(Departamentos departamentos);
	public List<Departamentos> listar();
}
