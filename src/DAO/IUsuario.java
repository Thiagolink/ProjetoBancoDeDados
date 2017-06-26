package DAO;

import java.util.List;

import entidade.Usuario;

public interface IUsuario {
	public void update(Usuario usuario);
	public void insert(Usuario usuario);
	public Usuario search(int idUsuario);
	public void remove(Usuario usuario);
	public List<Usuario> listar();
}
