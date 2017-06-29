package gui_control;

import java.io.Console;
import java.util.Scanner;

import entidade.Administrador;
import entidade.Pessoa;
import gui.IGUIAdministrador;
import gui.IGUICliente;
import gui.IGUIInicial;

public class GUIInicial implements IGUIInicial{
	private Scanner in = new Scanner(System.in);

    private IGUIAdministrador guiAdministrador = new GUIAdministrador();
    private IGUICliente guiCliente = new GUICliente();

    public void acessarInterface(Pessoa pessoa) {
        
        int option;

        do {
        	
        	if(pessoa.isAdministrador){
        		option = 1;
        	}else if(pessoa.isCliente){
        		option = 2;
        	}else{
        		option = 3;
        	}
           switch (option) {
               case 1:
                   showMenuGUIUsuarioAdministrador(pessoa);
                   break;
               case 2:
                   showMenuGUIUsuarioCliente(pessoa);
                   break;
               case 3:
                   showMenuGUIUsuarioFornecedor(pessoa);
                   break;
               default:
                   break;
           }
           
        } while (option > 0);
    }

    public void showMenuGUIUsuarioAdministrador(Pessoa pessoa) {
        int option;

        do {
            System.out.println("---------- Área do Administrador ----------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Administrador");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Remover Cliente");
            System.out.println("5 - Remover Administrador");
            System.out.println("6 - Remover Produto");
            System.out.println("7 - Listar Clientes");
            System.out.println("8 - Listar Administradores");
            System.out.println("9 - Listar Pedidos");
            System.out.println("10 - Analisar Pedido");

            System.out.println("\n0 - Sair");

            System.out.print("\n\nOpcao desejada: ");
            option = in.nextInt();

			//clearConsole();
            switch (option) {
                case 1:
                    guiAdministrador.cadastrarCliente();
                    break;
                case 2:
                    guiAdministrador.cadastrarAdministrador();
                    break;
                case 3:
                	guiAdministrador.cadastrarProdutos();
                    break;
                case 4:
                    guiAdministrador.removerCliente();
                    break;
                case 5:
                	guiAdministrador.removerAdministrador();
                    //showMenuGUIInformacoes();
                    break;
                case 6:
                	guiAdministrador.removerProdutos();
                    break;
                case 7:
                    guiAdministrador.listarCliente();
                    break;
                case 8:
                    guiAdministrador.listarAdministrador();
                    break;
                case 9:
                    guiAdministrador.listarPedidos();
                    break;
                case 10:
                    guiAdministrador.analisarPedido(pessoa);
                    break;

                default:
                   System.exit(0);
                    break;
            }
        } while (option > 0);
    }

    public void showMenuGUIUsuarioCliente(Pessoa pessoa) {
        int option;

        do {
            System.out.println("---------- Area do Cliente ----------");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Listar Meus Pedidos");

            System.out.println("0 - Sair");

            System.out.print("Opcao desejada: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    guiCliente.cadastrarPedido(usuario);
                    break;
                case 2:
                    guiCliente.listarPedidos(usuario);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (option > 0);
    }
    
    public void showMenuGUIUsuarioFornecedor(Pessoa pessoa) {
        int option;

        do {
            System.out.println("---------- Area do Fornecedor ----------");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Listar Meus Pedidos");

            System.out.println("0 - Sair");

            System.out.print("Opcao desejada: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    guiCliente.cadastrarPedido(usuario);
                    break;
                case 2:
                    guiCliente.listarPedidos(usuario);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (option > 0);
    }
}
