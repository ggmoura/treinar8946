package br.com.treinar.caixa.visao;

import java.util.Scanner;

import br.com.treinar.caixa.modelo.Cliente;
import br.com.treinar.caixa.modelo.ContaCorrente;
import br.com.treinar.caixa.modelo.ContaInvestimento;
import br.com.treinar.caixa.modelo.ContaPoupanca;
import br.com.treinar.caixa.modelo.caixa.Conta;

public class MenuCaixa {
	
	public Scanner leitor;
	public Conta c;
	
	public MenuCaixa() {
		leitor = new Scanner(System.in);
	}

	public void iniciarAtividade() {

		Integer opcao = null;

		do {
			System.out.print(recuperarMenu());
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			switch (opcao) {
			case 1:
				criarConta();
				break;
			case 2:
				exibirDadosConta();
				break;
			default:
				break;
			}
		} while (!opcao.equals(0));
		
	}
	
	private void exibirDadosConta() {
		System.out.println(c.cliente.nome);
		//System.out.println(c.pegarLimiteCredito());
	}

	private void criarConta() {
		
		System.out.println("Digite\n1 - Conta Corrente\n2 - Conta Investimento\n3 - Conta Poupança\n=> ");
		Integer opcao = leitor.nextInt();
		switch (opcao) {
		case 1:
			cadastrarContaCorrente();
			break;
		case 2:
			cadastrarContaInvestimento();
			break;
		case 3:
			cadastrarContaPoupanca();
			break;
		default:
			System.out.println("Opção inválida...");
			break;
		}
		
		
		//leitor.nextLine();//Elimina o enter
		
	}

	private void cadastrarContaInvestimento() {
		c = new ContaInvestimento();
		cadastrarConta(c);
		System.out.println("Informe a taxa de manutenção");
		ContaInvestimento contaInvestimento = (ContaInvestimento)c;
		contaInvestimento.taxaManutencao = leitor.nextDouble();
		System.out.println("Informe a taxa de rendimento");
		contaInvestimento.taxaRendimento = leitor.nextDouble();
	}

	private void cadastrarContaPoupanca() {
		c = new ContaPoupanca();
		cadastrarConta(c);
		ContaPoupanca contaPoupanca = (ContaPoupanca)c;
		contaPoupanca.taxaRendimento = 1f;
	}

	private void cadastrarContaCorrente() {
		c = new ContaCorrente();
		cadastrarConta(c);
		System.out.print("Informe o limite de crédito: ");
		Double limiteCredito = leitor.nextDouble();
		ContaCorrente contaCorrente = (ContaCorrente)c;
		contaCorrente.atribuirLimiteCredito(limiteCredito);
	}

	public String recuperarMenu() {
		String menu =	"1 - Criar Conta\n" 
					  + "2 - Exibir dados da Conta\n"
					  + " => ";
		return menu;
	}
	
	
	public void cadastrarConta(Conta conta) {
		System.out.print("Informe o saldo da conta: ");
		c.saldo = leitor.nextDouble();
		System.out.print("Informe o nome do cliente: ");
		leitor.nextLine();
		c.cliente = new Cliente();
		c.cliente.nome = leitor.nextLine();
		System.out.print("Informe o endereco do cliente: ");
		c.cliente.endereco = leitor.nextLine();
		System.out.print("Informe o documento do cliente: ");
		c.cliente.documento = leitor.nextInt(); 
	}
	
}
