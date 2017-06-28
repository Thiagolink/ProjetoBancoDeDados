package gerenciador;

import java.util.List;

import DAO.IFornecedor;
import JDBC.FornecedorJDBC;
import conexao.ConFactory;
import entidade.Fornecedor;

public class GerenciadorFornecedor {
	
	private IFornecedor daoFornecedor;

	public GerenciadorFornecedor() {
		daoFornecedor= new FornecedorJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarFornecedor(Fornecedor fornecedor){
		this.daoFornecedor.insert(fornecedor);
    }

    public void removerFornecedor(Fornecedor fornecedor) {
        this.daoFornecedor.remove(fornecedor);
    }

    public void atualizarFornecedor(Fornecedor fornecedor) {
        this.daoFornecedor.update(fornecedor);
    }

    public List<Fornecedor> listarFornecedor() {
        return this.daoFornecedor.listar();
    }

    public Fornecedor getFornecedor(int idFornecedor) {
        return this.daoFornecedor.search(idFornecedor);
    }
}
