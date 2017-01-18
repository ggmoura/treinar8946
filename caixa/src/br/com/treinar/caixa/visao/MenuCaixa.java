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
			case 1: //caso opção seja 1, chama o metodo criarConta
				criarConta(); 
				break;
			case 2: //caso opção seja 2, chama o metodo exibirDadosConta
				exibirDadosConta(); 
				break;
			default:
				break;
			}
		} while (!opcao.equals(0)); //repete enquanto opcao for diferente de 0
		
	}
	
	private void exibirDadosConta() {
		System.out.println(c.cliente.nome);
		//System.out.println(c.pegarLimiteCredito());
	}

	private void criarConta() {
		//caso a opcao no primeiro menu seja 1
		//exibe o segundo menu com as opcoes do tipo de contas a serem criadas
		System.out.println("Digite\n1 - Conta Corrente\n2 - Conta Investimento\n3 - Conta PoupanÃ§a\n=> ");
		Integer opcao = leitor.nextInt();
		switch (opcao) {
		case 1: //caso seja 1, chama o metodo para criar uma conta corrente
			cadastrarContaCorrente();
			break;
		case 2: //caso seja 2, chama o metodo para criar uma conta investimento
			cadastrarContaInvestimento();
			break;
		case 3: //caso seja 3, chama o metodo para criar uma conta poupanca
			cadastrarContaPoupanca();
			break;
		default:
			System.out.println("OpÃ§Ã£o invÃ¡lida...");
			break;
		}
		
		
		//leitor.nextLine();//Elimina o enter
		
	}

	private void cadastrarContaInvestimento() {
		//aplica as funcionalidades dos metodos sobreescritos em ContaInvestimento(filho)
		//em um objeto do tipo conta(pai)
		c = new ContaInvestimento();
		//chama o metodo cadastrarConta passando o objeto da conta
		//a ser criada
		cadastrarConta(c);
		System.out.println("Informe a taxa de manutenÃ§Ã£o");
		//faz um cast do objeto c e o atribui a variavel do tipo ContaInvestimento
		//para poder utilizar os metodos e variaveis especificas da classe ContaInvestimento
		ContaInvestimento contaInvestimento = (ContaInvestimento)c;
		contaInvestimento.taxaManutencao = leitor.nextDouble(); //define a taxa de manutenção que é especifica de uma conta investimento
		System.out.println("Informe a taxa de rendimento");
		contaInvestimento.taxaRendimento = leitor.nextDouble(); //define uma taxa de rendimento
	}

	private void cadastrarContaPoupanca() {
		//aplica as funcionalidades dos metodos sobreescritos em ContaPoupanca(filho)
		//em um objeto do tipo conta(pai)
		c = new ContaPoupanca();
		//chama o metodo cadastrarConta passando o objeto da conta
		//a ser criada
		cadastrarConta(c);
		//faz um cast do objeto c e o atribui a variavel do tipo ContaPoupanca
		//para poder utilizar os metodos e variaveis especificas da classe ContaPoupanca
		ContaPoupanca contaPoupanca = (ContaPoupanca)c;
		contaPoupanca.taxaRendimento = 1f; //define uma taxa de rendimento
	}

	private void cadastrarContaCorrente() {
		//aplica as funcionalidades dos metodos sobreescritos em ContaCorrente(filho)
		//em um objeto do tipo conta(pai)
		c = new ContaCorrente();
		//chama o metodo cadastrarConta passando o objeto da conta
		//a ser criada
		cadastrarConta(c);
		System.out.print("Informe o limite de crÃ©dito: ");
		Double limiteCredito = leitor.nextDouble();
		//faz um cast do objeto c e o atribui a variavel do tipo ContaCorrente
		//para poder utilizar os metodos e variaveis especificas da classe ContaCorrente
		ContaCorrente contaCorrente = (ContaCorrente)c;
		contaCorrente.atribuirLimiteCredito(limiteCredito); //chama o metodo que atribui um limite de credito passando seu valor
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
		c.cliente = new Cliente(); //atribui um novo cliente, a variavel cliente dentro da conta recebida
		c.cliente.nome = leitor.nextLine(); //atribui o nome do cliente a variavel nome dentro do objeto cliente contido na conta recebida
		System.out.print("Informe o endereco do cliente: ");
		c.cliente.endereco = leitor.nextLine(); //atribui o endereço do cliente a variavel endereço dentro do objeto cliente contido na conta recebida
		System.out.print("Informe o documento do cliente: ");
		c.cliente.documento = leitor.nextInt(); //atribui o documento do cliente a variavel documento dentro do objeto cliente contido na conta recebida
		//desempilha este metodo e retorna de onde parou no metodo anterior
	}
	
}
