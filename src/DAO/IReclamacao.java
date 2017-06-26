package DAO;

import java.util.List;

import entidade.Reclamacao;

public interface IReclamacao {
	
	public void update(Reclamacao reclamacao);
	public void insert(Reclamacao reclamacao);
	public Reclamacao search(int idReclamacao);
	public void remove(Reclamacao reclamacao);
	public List<Reclamacao> listar();
}
