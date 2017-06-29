package gui_control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import entidade.Administrador;
import entidade.Cliente;
import entidade.Pedido;
import gui.IGUIAdministrador;

public class GUIAdministrador implements IGUIAdministrador {
	private static Scanner in = new Scanner(System.in);
	
    //declaracao de gerenciadores

	@Override
    public void cadastrarCliente() {
        try {

            System.out.println("---------- Cadastrar Cliente----------");
            System.out.println("Nome: ");
            String nome = in.next();
            System.out.println("Endereço: ");
            String setor = in.next();
            System.out.println("Telefone: ");
            String telefone = in.next();
            System.out.println("Login: ");
            String login = in.next();
            System.out.println("Senha: ");
            String senha = in.next();

            //gerenciadorCliente.cadastrarCliente(new UsuarioCliente(nome, setor, telefone, login, senha));
        } catch (Exception e) {

        }
    }
	
	@Override
    public void cadastrarAdministrador() {
        try {

            System.out.println("---------- Cadastrar Cliente----------");
            System.out.println("Nome: ");
            String nome = in.next();
            System.out.println("Endereço: ");
            String setor = in.next();
            System.out.println("Telefone: ");
            String telefone = in.next();
            System.out.println("Login: ");
            String login = in.next();
            System.out.println("Senha: ");
            String senha = in.next();

            //gerenciadorCliente.cadastrarCliente(new UsuarioCliente(nome, setor, telefone, login, senha));
        } catch (Exception e) {

        }
    }

    @Override
    public void cadastrarProdutos() {
        System.out.println("Nome do Produto: ");
        String nome = in.nextLine();
        System.out.println("Quantidade em Estoque: ");
        int quantidadeEmEstoque = in.nextInt();
        System.out.println("Preco: ");
        double preco = Double.parseDouble(in.nextLine());
        System.out.println("Descricao: ");
        String descricao = in.nextLine();

        //try {
            //gerenciadorDemanda.cadastrarDemanda(new Item(quantidadeEmEstoque, nome, preco, descricao, new Date()));
        //} catch (PedidoInvalidoException ex) {
            //Logger.getLogger(GUIAdministradorEstoque.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (DemandaInvalidoException ex) {
            //Logger.getLogger(GUIAdministradorEstoque.class.getName()).log(Level.SEVERE, null, ex);
        //}

    }

    @Override
    public void removerCliente() {
        try {
            System.out.println("---------- Remover Cliente----------");
            System.out.print("Id: ");
            long id = Long.parseLong(in.nextLine());
            gerenciadorCliente.removerCliente(gerenciadorCliente.getCliente(id));
        } catch (Exception e) {

        }
    }
    
    @Override
    public void removerAdministrador() {
        try {
            System.out.println("---------- Remover Cliente----------");
            System.out.print("Id: ");
            long id = Long.parseLong(in.nextLine());
            gerenciadorCliente.removerCliente(gerenciadorCliente.getCliente(id));
        } catch (Exception e) {

        }
    }

    @Override
    public void removerProdutos() {
        System.out.println("Digite o id do Produto: ");
        long id = in.nextLong();
        gerenciadorDemanda.removerDemanda(gerenciadorDemanda.getDemanda(id));
    }

    @Override
    public void listarCliente() {
        ArrayList<Cliente> listCliente = gerenciadorCliente.listarClientes();
        Iterator<Cliente> it = listCliente.iterator();

        while (it.hasNext()) {
            Cliente usuarioCliente = it.next();
            System.out.println("---------------------------------------");
            System.out.println("ID:" + usuarioCliente.getId());
            System.out.println("Nome: " + usuarioCliente.getNome());
            System.out.println("Endereco: " + usuarioCliente.getEndereco());
            System.out.println("Telefone: " + usuarioCliente.getTelefone());
            System.out.println("Login: " + usuarioCliente.getLogin());
            System.out.println("Senha: " + usuarioCliente.getSenha());
        }
    }
    
    @Override
    public void listarAdministrador() {
        ArrayList<Administrador> listAdministrador = gerenciadorCliente.listarClientes();
        Iterator<Administrador> it = listAdministrador.iterator();

        while (it.hasNext()) {
            Cliente usuarioAdministrador = it.next();
            System.out.println("---------------------------------------");
            System.out.println("ID:" + usuarioAdministrador.getId());
            System.out.println("Nome: " + usuarioAdministrador.getNome());
            System.out.println("Endereco: " + usuarioAdministrador.getEndereco());
            System.out.println("Telefone: " + usuarioAdministrador.getTelefone());
            System.out.println("Login: " + usuarioAdministrador.getLogin());
            System.out.println("Senha: " + usuarioAdministrador.getSenha());
        }
    }
    
    @Override
    public void listarPedidos() {

        List<Pedido> listPedido = gerenciadorPedidos.listarPedidos();

        for (Pedido demanda : listPedido) {
            System.out.println("---------------------------------------");

            System.out.println("IdUsuarioSolicitante: " + demanda.getIdUsuarioSolicitante());
            System.out.println("IdDemanda: " + demanda.getIdServico());
            System.out.println("Data: " + demanda.getDataAbertura());
            System.out.println("IdUsuarioDemandando: " + demanda.getIdUsuarioDemandando());
            System.out.println("Descricao: " + demanda.getDescricao());
            System.out.println("Status: " + demanda.getStatus());
        }
    }

    @Override
    public void analisarPedido(Cliente cliente) {
        listarPedidos();
        System.out.println("Digite o Id do Pedido: ");
        long idDemanda = Long.parseLong(in.next());
        Pedido pedido = gerenciadorPedidos.getPedido(idDemanda);
        pedido.setIdUsuarioDemandando(cliente.getId());
        in.nextLine();

        System.out.println("Descreva o historico: ");
        String descricao = in.nextLine();
        System.out.println("Status: ");
        char status = in.next().charAt(0);
        try {
            pedido.setStatus(status);
        } catch (Exception ex) {
           
        }

        //try {
        //    gerenciadorHistoricos.adicionarHistorico(new Historico(idDemanda, pedido.getIdUsuarioDemandando(), new Date(), descricao, usuario));
        //    gerenciadorNotificacao.NotificarAtualizacao(new Historico(idDemanda, pedido.getIdUsuarioDemandando(), new Date(), descricao, usuario));
        //} catch (HistoricoInvalidoException ex) {
        //    Logger.getLogger(GUIUsuarioEstoque.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
}

