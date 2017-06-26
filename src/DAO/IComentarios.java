package DAO;

import java.util.List;

import entidade.Comentarios;

public interface IComentarios {
	
	public void update(Comentarios comentarios);
	public void insert(Comentarios comentarios);
	public Comentarios search(int idComentarios);
	public void remove(Comentarios comentarios);
	public List<Comentarios> listar();
}
