package DAO;

import java.util.List;

import entidade.Notificacao;

public interface INotificacao {
	public void update(Notificacao notificacao);
	public void insert(Notificacao notificacao);
	public Notificacao search(int notificacao);
	public void remove(Notificacao notificacao);
	public List<Notificacao> listar();
}
