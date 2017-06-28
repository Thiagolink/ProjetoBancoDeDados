package gerenciador;

import java.util.List;

import DAO.IListaDesejos;
import JDBC.ListaDesejosJDBC;
import conexao.ConFactory;
import entidade.ListaDesejos;

public class GerenciadorListaDesejos {
	
	private IListaDesejos daoListaDesejos;

	public GerenciadorListaDesejos() {
		daoListaDesejos= new ListaDesejosJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);
	}
	
	public void cadastrarListaDesejos(ListaDesejos listaDesejos){
		this.daoListaDesejos.insert(listaDesejos);
    }

    public void removerListaDesejos(ListaDesejos listaDesejos) {
        this.daoListaDesejos.remove(listaDesejos);
    }

    public void atualizarListaDesejos(ListaDesejos listaDesejos) {
        this.daoListaDesejos.update(listaDesejos);
    }

    public List<ListaDesejos> listarListaDesejos() {
        return this.daoListaDesejos.listar();
    }

    public ListaDesejos getListaDesejos(int idListaDesejos) {
        return this.daoListaDesejos.search(idListaDesejos);
    }

}
