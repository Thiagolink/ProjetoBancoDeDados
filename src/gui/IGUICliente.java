package gui;

import entidade.Cliente;

public interface IGUICliente {
	public void cadastrarPedido(Cliente cliente);
	public void removerPedido(Cliente cliente);
    public void listarPedidos(Cliente cliente);
    public void cadastrarEndereco(Cliente cliente);
    public void cadastrarCartao(Cliente cliente);
    public void informarBoleto(Cliente cliente);
}
