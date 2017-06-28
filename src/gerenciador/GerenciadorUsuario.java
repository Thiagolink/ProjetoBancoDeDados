package gerenciador;

import java.util.List;

import DAO.IUsuario;
import JDBC.UsuarioJDBC;
import conexao.ConFactory;
import entidade.Usuario;

public class GerenciadorUsuario {
	
	private IUsuario daoUsuario;

	public GerenciadorUsuario() {
		daoUsuario= new UsuarioJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarUsuario(Usuario usuario){
		this.daoUsuario.insert(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        this.daoUsuario.remove(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        this.daoUsuario.update(usuario);
    }

    public List<Usuario> listarUsuario() {
        return this.daoUsuario.listar();
    }

    public Usuario getUsuario(int idUsuario) {
        return this.daoUsuario.search(idUsuario);
    }

}
