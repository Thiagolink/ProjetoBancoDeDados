package gerenciador;

import java.util.List;

import DAO.IPessoa;
import JDBC.PessoaJDBC;
import conexao.ConFactory;
import entidade.Pessoa;

public class GerenciadorPessoa {

	private IPessoa daoPessoa;

	public GerenciadorPessoa() {
		daoPessoa= new PessoaJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarPessoa(Pessoa pessoa){
		this.daoPessoa.insert(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        this.daoPessoa.remove(pessoa);
    }

    public void atualizarPessoa(Pessoa pessoa) {
        this.daoPessoa.update(pessoa);
    }

    public List<Pessoa> listarPessoa() {
        return this.daoPessoa.listar();
    }

    public Pessoa getPessoa(int idPessoa) {
        return this.daoPessoa.search(idPessoa);
    }
}
