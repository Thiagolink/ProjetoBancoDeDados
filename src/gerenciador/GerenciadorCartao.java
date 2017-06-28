package gerenciador;

import java.util.List;

import DAO.ICartao;
import JDBC.CartaoJDBC;
import conexao.ConFactory;
import entidade.Cartao;

public class GerenciadorCartao {
	
private ICartao daoCartao;
	
	public GerenciadorCartao() {
		daoCartao= new CartaoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarCartao(Cartao cartao){
		this.daoCartao.insert(cartao);
    }

    public void removerCartao(Cartao cartao) {
        this.daoCartao.remove(cartao);
    }

    public void atualizarCartao(Cartao cartao) {
        this.daoCartao.update(cartao);
    }

    public List<Cartao> listarCartao() {
        return this.daoCartao.listar();
    }

    public Cartao getCartao(int idCartao) {
        return this.daoCartao.search(idCartao);
    }

}
