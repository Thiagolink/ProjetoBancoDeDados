package gerenciador;

import java.util.List;

import DAO.IPromocoes;
import JDBC.PromocoesJDBC;
import conexao.ConFactory;
import entidade.Promocoes;

public class GerenciadorPromocoes {

	private IPromocoes daoPromocoes;

	public GerenciadorPromocoes() {
		daoPromocoes= new PromocoesJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarPromocoes(Promocoes promocoes){
		this.daoPromocoes.insert(promocoes);
    }

    public void removerPromocoes(Promocoes promocoes) {
        this.daoPromocoes.remove(promocoes);
    }

    public void atualizarPromocoes(Promocoes promocoes) {
        this.daoPromocoes.update(promocoes);
    }

    public List<Promocoes> listarPromocoes() {
        return this.daoPromocoes.listar();
    }

    public Promocoes getPromocoes(int idPromocoes) {
        return this.daoPromocoes.search(idPromocoes);
    }
}
