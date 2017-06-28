package gerenciador;

import java.util.List;

import DAO.IAtendimento;
import JDBC.AtendimentoJDBC;
import conexao.ConFactory;
import entidade.Atendimento;

public class GerenciadorAtendimento {

private IAtendimento daoAtendimento;
	
	public GerenciadorAtendimento() {
		daoAtendimento= new AtendimentoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarAtendimento(Atendimento atendimento){
		this.daoAtendimento.insert(atendimento);
    }

    public void removerAtendimento(Atendimento atendimento) {
        this.daoAtendimento.remove(atendimento);
    }

    public void atualizarAtendimento(Atendimento atendimento) {
        this.daoAtendimento.update(atendimento);
    }

    public List<Atendimento> listarAtendimento() {
        return this.daoAtendimento.listar();
    }

    public Atendimento getAtendimento(int idAtendimento) {
        return this.daoAtendimento.search(idAtendimento);
    }
}
