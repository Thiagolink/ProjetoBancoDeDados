package entidade;

public class Produto_ListaDesejos {
	
	private int idProduto_ListaDesejos;
	private int produto_idProduto;
	private int listaDesejos_idListaDesejos;
	
	
	public Produto_ListaDesejos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Produto_ListaDesejos(int idProduto_ListaDesejos, int produto_idProduto, int listaDesejos_idListaDesejos) {
		super();
		this.idProduto_ListaDesejos = idProduto_ListaDesejos;
		this.produto_idProduto = produto_idProduto;
		this.listaDesejos_idListaDesejos = listaDesejos_idListaDesejos;
	}


	public int getIdProduto_ListaDesejos() {
		return idProduto_ListaDesejos;
	}


	public void setIdProduto_ListaDesejos(int idProduto_ListaDesejos) {
		this.idProduto_ListaDesejos = idProduto_ListaDesejos;
	}


	public int getProduto_idProduto() {
		return produto_idProduto;
	}


	public void setProduto_idProduto(int produto_idProduto) {
		this.produto_idProduto = produto_idProduto;
	}


	public int getListaDesejos_idListaDesejos() {
		return listaDesejos_idListaDesejos;
	}


	public void setListaDesejos_idListaDesejos(int listaDesejos_idListaDesejos) {
		this.listaDesejos_idListaDesejos = listaDesejos_idListaDesejos;
	}
	
	
	
}
