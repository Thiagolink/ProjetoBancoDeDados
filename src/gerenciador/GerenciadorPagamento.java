package gerenciador;

import java.util.List;

import DAO.IPagamento;
import JDBC.PagamentoJDBC;
import conexao.ConFactory;
import entidade.Pagamento;

public class GerenciadorPagamento {

	private IPagamento daoPagamento;

	public GerenciadorPagamento() {
		daoPagamento= new PagamentoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarPagamento(Pagamento pagamento){
		this.daoPagamento.insert(pagamento);
    }

    public void removerPagamento(Pagamento pagamento) {
        this.daoPagamento.remove(pagamento);
    }

    public void atualizarPagamento(Pagamento pagamento) {
        this.daoPagamento.update(pagamento);
    }

    public List<Pagamento> listarPagamento() {
        return this.daoPagamento.listar();
    }

    public Pagamento getPagamento(int idPagamento) {
        return this.daoPagamento.search(idPagamento);
    }
}
