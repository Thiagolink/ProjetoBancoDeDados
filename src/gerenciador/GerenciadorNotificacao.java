package gerenciador;

import java.util.List;

import DAO.INotificacao;
import JDBC.NotificacaoJDBC;
import conexao.ConFactory;
import entidade.Notificacao;

public class GerenciadorNotificacao {

	private INotificacao daoNotificacao;

	public GerenciadorNotificacao() {
		daoNotificacao= new NotificacaoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarNotificacao(Notificacao notificacao){
		this.daoNotificacao.insert(notificacao);
    }

    public void removerNotificacao(Notificacao notificacao) {
        this.daoNotificacao.remove(notificacao);
    }

    public void atualizarNotificacao(Notificacao notificacao) {
        this.daoNotificacao.update(notificacao);
    }

    public List<Notificacao> listarNotificacao() {
        return this.daoNotificacao.listar();
    }

    public Notificacao getNotificacao(int idNotificacao) {
        return this.daoNotificacao.search(idNotificacao);
    }
}
