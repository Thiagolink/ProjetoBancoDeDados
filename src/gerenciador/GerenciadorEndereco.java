package gerenciador;

import java.util.List;

import DAO.IEndereco;
import JDBC.EnderecoJDBC;
import conexao.ConFactory;
import entidade.Endereco;

public class GerenciadorEndereco {

private IEndereco daoEndereco;

	
	public GerenciadorEndereco() {
		daoEndereco= new EnderecoJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarEndereco(Endereco endereco){
		this.daoEndereco.insert(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        this.daoEndereco.remove(endereco);
    }

    public void atualizarEndereco(Endereco endereco) {
        this.daoEndereco.update(endereco);
    }

    public List<Endereco> listarEndereco() {
        return this.daoEndereco.listar();
    }

    public Endereco getEndereco(int idEndereco) {
        return this.daoEndereco.search(idEndereco);
    }
}
