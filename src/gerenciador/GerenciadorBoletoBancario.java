package gerenciador;

import java.util.List;

import DAO.IBoletoBancario;
import JDBC.BoletoBancarioJDBC;
import conexao.ConFactory;
import entidade.BoletoBancario;

public class GerenciadorBoletoBancario {
	
private IBoletoBancario daoBoletoBancario;
	
	public GerenciadorBoletoBancario() {
		daoBoletoBancario= new BoletoBancarioJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarBoletoBancario(BoletoBancario boletoBancario){
		this.daoBoletoBancario.insert(boletoBancario);
    }

    public void removerBoletoBancario(BoletoBancario boletoBancario) {
        this.daoBoletoBancario.remove(boletoBancario);
    }

    public void atualizarBoletoBancario(BoletoBancario boletoBancario) {
        this.daoBoletoBancario.update(boletoBancario);
    }

    public List<BoletoBancario> listarBoletoBancario() {
        return this.daoBoletoBancario.listar();
    }

    public BoletoBancario getBoletoBancario(int idBoletoBancario) {
        return this.daoBoletoBancario.search(idBoletoBancario);
    }
}
