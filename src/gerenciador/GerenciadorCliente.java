package gerenciador;

import java.util.List;

import DAO.ICliente;
import JDBC.ClienteJDBC;
import conexao.ConFactory;
import entidade.Cliente;

public class GerenciadorCliente {

private ICliente daoCliente;
	
	public GerenciadorCliente() {
		daoCliente= new ClienteJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarCliente(Cliente cliente){
		this.daoCliente.insert(cliente);
    }

    public void removerCliente(Cliente cliente) {
        this.daoCliente.remove(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        this.daoCliente.update(cliente);
    }

    public List<Cliente> listarCliente() {
        return this.daoCliente.listar();
    }

    public Cliente getCliente(int idCliente) {
        return this.daoCliente.search(idCliente);
    }

}
