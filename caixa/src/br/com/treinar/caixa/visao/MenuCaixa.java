package br.com.treinar.caixa.visao;

import java.util.Scanner;

import br.com.treinar.caixa.modelo.Cliente;
import br.com.treinar.caixa.modelo.Conta;

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
		System.out.println(c.pegarLimiteCredito());
	}

	private void criarConta() {
		c = new Conta();
		System.out.print("Informe o limite de crédito: ");
		Double limiteCredito = leitor.nextDouble();
		c.atribuirLimiteCredito(limiteCredito);
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
		//leitor.nextLine();//Elimina o enter
		
	}

	public String recuperarMenu() {
		String menu =	"1 - Criar Conta\n" 
					  + "2 - Exibir dados da Conta\n"
					  + " => ";
		return menu;
	}
	
	
}
