package gerenciador;

import java.util.List;

import DAO.IVendedor;
import JDBC.VendedorJDBC;
import conexao.ConFactory;
import entidade.Vendedor;

public class GerenciadorVendedor {

	private IVendedor daoVendedor;

	public GerenciadorVendedor() {
		daoVendedor= new VendedorJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarVendedor(Vendedor vendedor){
		this.daoVendedor.insert(vendedor);
    }

    public void removerVendedor(Vendedor vendedor) {
        this.daoVendedor.remove(vendedor);
    }

    public void atualizarVendedor(Vendedor vendedor) {
        this.daoVendedor.update(vendedor);
    }

    public List<Vendedor> listarVendedor() {
        return this.daoVendedor.listar();
    }

    public Vendedor getVendedor(int idVendedor) {
        return this.daoVendedor.search(idVendedor);
    }
}
