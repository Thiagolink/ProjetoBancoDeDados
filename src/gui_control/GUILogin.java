package gui_control;

import java.util.Scanner;

import entidade.Pessoa;
import gui.IGUIInicial;
import gui.IGUILogin;

public class GUILogin implements IGUILogin{
	
	private Scanner in = new Scanner(System.in);
    //GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    //GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();
    private IGUIInicial guiInicial = new GUIInicial();
    private Pessoa pessoa;

    @Override
    public boolean autenticar(String login, String senha) {
        //Usuario usuarioPadrao = gerenciadorUsuarios.getUsuario(login);
        //Usuario usuarioCliente = gerenciadorCliente.getCliente(login);

        if (gerenciadorUsuarios.getUsuario(login) == null && gerenciadorCliente.getCliente(login) == null) {
            System.out.println("Usuario nao cadastrado.");
            return false;
        } else if (gerenciadorUsuarios.getUsuario(login) != null && usuarioPadrao.getSenha().equals(senha)) {
            usuario = gerenciadorUsuarios.getUsuario(login);
            return true;
        } else if (gerenciadorCliente.getCliente(login) != null && usuarioCliente.getSenha().equals(senha)) {
            usuario = gerenciadorCliente.getCliente(login);
            return true;
        } else {
            System.out.println("Senha incorreta.");
            return false;
        }
    }

    @Override
    public void logar() {
        do {
            System.out.println("#############     SisECOM - Sistema E-Commerce     #############");
            System.out.println("----------------------        LOGIN        ---------------------");
            System.out.println("Usuario: ");
            String login = in.next();
            System.out.println("Senha: ");
            String senha = in.next();
            if (autenticar(login, senha)) {
                guiInicial.acessarInterface(pessoa);
            }
        } while (true);
    }
}
