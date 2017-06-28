package gerenciador;

import java.util.List;

import DAO.IDepartamentos;
import JDBC.DepartamentosJDBC;
import conexao.ConFactory;
import entidade.Departamentos;

public class GerenciadorDepartamentos {

private IDepartamentos daoDepartamentos;

	
	public GerenciadorDepartamentos() {
		daoDepartamentos= new DepartamentosJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarDepartamentos(Departamentos departamentos){
		this.daoDepartamentos.insert(departamentos);
    }

    public void removerDepartamentos(Departamentos departamentos) {
        this.daoDepartamentos.remove(departamentos);
    }

    public void atualizarDepartamentos(Departamentos departamentos) {
        this.daoDepartamentos.update(departamentos);
    }

    public List<Departamentos> listarDepartamentos() {
        return this.daoDepartamentos.listar();
    }

    public Departamentos getDepartamentos(int idDepartamentos) {
        return this.daoDepartamentos.search(idDepartamentos);
    }
}
