package gui;

import entidade.Cliente;

public interface IGUIAdministrador {
	public void cadastrarCliente();
	public void cadastrarAdministrador();
    public void cadastrarProdutos();
    
    public void removerCliente();
    public void removerAdministrador();
    public void removerProdutos();
    
    public void listarCliente();
    public void listarAdministrador();
    public void listarPedidos();

    public void analisarPedido(Cliente cliente);
}
