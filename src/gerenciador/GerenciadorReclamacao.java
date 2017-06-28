package gerenciador;

import java.util.List;

import DAO.IReclamacao;
import JDBC.ReclamacaoJDBC;
import conexao.ConFactory;
import entidade.Reclamacao;

public class GerenciadorReclamacao {

	private IReclamacao daoReclamacao;

	public GerenciadorReclamacao() {
		daoReclamacao= new ReclamacaoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarReclamacao(Reclamacao reclamacao){
		this.daoReclamacao.insert(reclamacao);
    }

    public void removerReclamacao(Reclamacao reclamacao) {
        this.daoReclamacao.remove(reclamacao);
    }

    public void atualizarReclamacao(Reclamacao reclamacao) {
        this.daoReclamacao.update(reclamacao);
    }

    public List<Reclamacao> listarReclamacao() {
        return this.daoReclamacao.listar();
    }

    public Reclamacao getReclamacao(int idReclamacao) {
        return this.daoReclamacao.search(idReclamacao);
    }
}
