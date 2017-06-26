package DAO;

import java.util.List;

import entidade.BoletoBancario;

public interface IBoletoBancario {

	public void update(BoletoBancario boletoBancario);
	public void insert(BoletoBancario boletoBancario);
	public BoletoBancario search(int idBoletobancario);
	public void remove(BoletoBancario boletoBancario);
	public List<BoletoBancario> listar();
}
