package gerenciador;

import java.util.List;

import DAO.IAdministrador;
import JDBC.AdministradorJDBC;
import conexao.ConFactory;
import entidade.Administrador;

public class GerenciadorAdministrador {

	private IAdministrador daoAdministrador;
	
	public GerenciadorAdministrador() {
		daoAdministrador= new AdministradorJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarAdministrador(Administrador administrador){
		this.daoAdministrador.insert(administrador);
    }

    public void removerAdministrador(Administrador administrador) {
        this.daoAdministrador.remove(administrador);
    }

    public void atualizarAdministrador(Administrador administrador) {
        this.daoAdministrador.update(administrador);
    }

    public List<Administrador> listarAdministrador() {
        return this.daoAdministrador.listar();
    }

    public Administrador getAdministrador(int idAdministrador) {
        return this.daoAdministrador.search(idAdministrador);
    }
}

