package DAO;

import java.util.List;

import entidade.Pagamento;

public interface IPagamento {
	public void update(Pagamento pagamento);
	public void insert(Pagamento pagamento);
	public Pagamento search(int idPagamento);
	public void remove(Pagamento pagamento);
	public List<Pagamento> listar();
}
