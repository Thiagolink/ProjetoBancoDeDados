package gui_control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidade.Cliente;
import entidade.Pagamento;
import entidade.Pedido;
import gui.IGUICliente;

public class GUICliente implements IGUICliente {
	private static Scanner in = new Scanner(System.in);

	// declaracao de gerenciadores

	public void cadastrarPedido(Cliente cliente) {

		try {

			System.out.println("---------- Cadastrar Pedido----------");
			long idCliente = cliente.getId();

			System.out.println("Quantos itens deseja adicionar?");
			int produtos = in.nextInt();
			Item item;
			for (; produtos > 0; produtos--) {
				listarDemandas();
				System.out.println("Digite o ID do produto escolhido: ");
				long id = in.nextLong();
				System.out.println("Digite a quantidade: ");
				int quantidade = in.nextInt();
				item = (Item) gerenciadorDemanda.getDemanda(id);
				if (item.getQuantidadeEmEstoque() < quantidade) {
					System.out.println("Quantidade indisponivel!");
				} else {
					item.setQuantidadeEmEstoque(quantidade);
					listaProdutos.add(item);
				}

			}
			System.out.println("Descricao: ");
			String descricao = in.nextLine();
			Pedido pedido = new Pedido(idCliente, new Date(), descricao, 'P', listaProdutos);
			Pagamento pagamento = new BoletoBancario(new Date(), pedido.getIdServico(), "Cartao de Debito");
			pagamento.calcularPagamento(listaProdutos);

			gerenciadorPedidos.cadastrarPedidos(pedido, pagamento, usuario, "Estoque");

		} catch (Exception e) {

		}

	}

	@Override
	public void listarDemandas() {
		try {
			List<Demanda> listDemanda = gerenciadorDemanda.listarDemandas();
			Item item;
			for (Demanda produto : listDemanda) {

				item = (Item) produto;
				System.out.println("----------------------------------");
				System.out.println("Nome:" + item.getNome());
				System.out.println("ID do Produto: " + item.getIdDemanda());
				System.out.println("Quantidade: " + item.getQuantidadeEmEstoque());
				System.out.println("Preco: " + item.getPreco());
				System.out.println("Descricao: " + item.getDescricao());
				System.out.println("Prazo: " + item.getPrazo());
				System.out.println("----------------------------------");
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void listarPedidos(Cliente cliente) {
		List<Pedido> listPedido = gerenciadorPedidos.getListarPedidoUsuario(cliente.getId());

		for (Pedido pedido : listPedido) {

			System.out.println("----------------------------------");
			System.out.println("IdUsuarioSolicitante: " + pedido.getIdUsuarioSolicitante());
			System.out.println("IdDemanda: " + pedido.getIdServico());
			System.out.println("Data: " + pedido.getDataAbertura());
			System.out.println("IdUsuarioDemandando: " + pedido.getIdUsuarioDemandando());
			System.out.println("Descricao: " + pedido.getDescricao());
			System.out.println("Status: " + pedido.getStatus());

			System.out.println("----------------------------------");
		}
	}

	@Override
	public void cadastrarEndereco(Cliente cliente) {
		System.out.println("Rua: ");
		String rua = in.nextLine();
		System.out.println("Bairro: ");
		String bairro = in.nextLine();
		System.out.println("Complemento: ");
		String complemento = in.nextLine();
		System.out.println("Cidade: ");
		String cidade = in.nextLine();
		System.out.println("Estado: ");
		String estado = in.nextLine();
		System.out.println("Pais: ");
		String pais = in.nextLine();

		// gerenciadores

	}

	@Override
	public void cadastrarCartao(Cliente cliente) {
		System.out.println("Banco: ");
		String banco = in.nextLine();
		System.out.println("Numero do cartao: ");
		String numero = in.nextLine();
		System.out.println("Codigo de seguranca: ");
		String codigo = in.nextLine();
		System.out.println("Data de vencimento: ");
		String vencimento = in.nextLine();
		System.out.println("Nome no cartao: ");
		String nome = in.nextLine();

		// gerenciadores

	}

	@Override
	public void informarBoleto(Cliente cliente) {
		System.out.println("Banco: ");
		String banco = in.nextLine();
		System.out.println("Codigo de barras: ");
		String codigo = in.nextLine();
		System.out.println("Data de vencimento: ");
		String vencimento = in.nextLine();

		// gerenciadores

	}
}
