package gerenciador;

import java.util.List;

import DAO.IComentarios;
import JDBC.ComentariosJDBC;
import conexao.ConFactory;
import entidade.Comentarios;

public class GerenciadorComentarios {
	
	private IComentarios daoComentarios;

	
	public GerenciadorComentarios() {
		daoComentarios= new ComentariosJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarComentarios(Comentarios comentarios){
		this.daoComentarios.insert(comentarios);
    }

    public void removerComentarios(Comentarios comentarios) {
        this.daoComentarios.remove(comentarios);
    }

    public void atualizarComentarios(Comentarios comentarios) {
        this.daoComentarios.update(comentarios);
    }

    public List<Comentarios> listarComentarios() {
        return this.daoComentarios.listar();
    }

    public Comentarios getComentarios(int idComentarios) {
        return this.daoComentarios.search(idComentarios);
    }

}
