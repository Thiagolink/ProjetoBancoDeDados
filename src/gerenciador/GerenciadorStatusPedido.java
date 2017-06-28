package gerenciador;

import java.util.List;

import DAO.IStatusPedido;
import JDBC.StatusPedidoJDBC;
import conexao.ConFactory;
import entidade.StatusPedido;

public class GerenciadorStatusPedido {

	private IStatusPedido daoStatusPedido;

	public GerenciadorStatusPedido() {
		daoStatusPedido= new StatusPedidoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarStatusPedido(StatusPedido statusPedido){
		this.daoStatusPedido.insert(statusPedido);
    }

    public void removerStatusPedido(StatusPedido statusPedido) {
        this.daoStatusPedido.remove(statusPedido);
    }

    public void atualizarStatusPedido(StatusPedido statusPedido) {
        this.daoStatusPedido.update(statusPedido);
    }

    public List<StatusPedido> listarStatusPedido() {
        return this.daoStatusPedido.listar();
    }

    public StatusPedido getStatusPedido(int idStatusPedido) {
        return this.daoStatusPedido.search(idStatusPedido);
    }
}
