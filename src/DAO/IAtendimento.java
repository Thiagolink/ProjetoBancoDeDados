package DAO;

import java.util.List;

import entidade.Atendimento;

public interface IAtendimento {
	
	public void update(Atendimento atendimento);
	public void insert(Atendimento atendimento);
	public Atendimento search(int idAtendimento);
	public void remove(Atendimento atendimento);
	public List<Atendimento> listar();
}
