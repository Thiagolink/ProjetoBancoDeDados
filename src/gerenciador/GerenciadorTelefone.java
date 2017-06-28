package gerenciador;

import java.util.List;

import DAO.ITelefone;
import JDBC.TelefoneJDBC;
import conexao.ConFactory;
import entidade.Telefone;

public class GerenciadorTelefone {

	private ITelefone daoTelefone;

	public GerenciadorTelefone() {
		daoTelefone= new TelefoneJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarTelefone(Telefone telefone){
		this.daoTelefone.insert(telefone);
    }

    public void removerTelefone(Telefone telefone) {
        this.daoTelefone.remove(telefone);
    }

    public void atualizarTelefone(Telefone telefone) {
        this.daoTelefone.update(telefone);
    }

    public List<Telefone> listarTelefone() {
        return this.daoTelefone.listar();
    }

    public Telefone getTelefone(int idTelefone) {
        return this.daoTelefone.search(idTelefone);
    }
}
