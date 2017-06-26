package DAO;

import java.util.List;

import entidade.Cartao;

public interface ICartao {
	public void update(Cartao cartao);
	public void insert(Cartao cartao);
	public Cartao search(int idCartao);
	public void remove(Cartao cartao);
	public List<Cartao> listar();
}
