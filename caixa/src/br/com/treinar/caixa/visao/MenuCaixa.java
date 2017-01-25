package br.com.treinar.caixa.visao;

import java.util.Scanner;

import br.com.treinar.caixa.modelo.Cliente;
import br.com.treinar.caixa.modelo.ContaCorrente;
import br.com.treinar.caixa.modelo.ContaInvestimento;
import br.com.treinar.caixa.modelo.ContaPoupanca;
import br.com.treinar.caixa.modelo.SaldoInsuficienteException;
import br.com.treinar.caixa.modelo.caixa.Conta;
import br.com.treinar.caixa.modelo.caixa.ICaptalizavel;
import br.com.treinar.caixa.modelo.caixa.IPagavel;

public class MenuCaixa {
	
	public Scanner leitor;
	public Conta[] contas;
	private Integer indice;

	
	public MenuCaixa() {
		leitor = new Scanner(System.in);
		contas = new Conta[5];
		indice = 0;
	}

	public void iniciarAtividade() {

		Integer opcao = null;
		
		do {
			System.out.print(recuperarMenu());
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			switch (opcao) {
			case 1: //caso op��o seja 1, chama o metodo criarConta
				criarConta(); 
				break;
			case 2: //caso op��o seja 2, chama o metodo exibirDadosConta
				exibirDadosConta(); 
				break;
			case 3: //caso opcao seja 2, chama o metodo exibirDadosConta
				tarifarConta(); 
				break;
			case 4: 
				captalizar(); 
				break;
			case 5: 
				depositar(); 
				break;
			case 6: 
				sacar(); 
				break;
			case 7: 
				atualizarTaxaRendimento();
				break;
			default:
				System.out.println("Opção inválida...");
				break;
			}
		} while (!opcao.equals(0)); //repete enquanto opcao for diferente de 0
		
	}

	private void atualizarTaxaRendimento() {
		//faz um cast do objeto c e o atribui a variavel do tipo ContaPoupanca
		//para poder utilizar os metodos e variaveis especificas da classe ContaPoupanca
		System.out.print("Informe a nova taxa de rendimento: ");
		ContaPoupanca.taxaRendimento = 1f; //define uma taxa de rendimento
	}
	
	private void sacar() {
		System.out.print("Informe o valor a ser sacado: ");
		//Polimorfismo: capacidade que um objeto tem de comportar de maneiras diferentes em tempo de execucao
		try {
			recuperarConta().sacar(leitor.nextDouble());
			System.out.println("Sacou belezinha...");
		} catch (SaldoInsuficienteException e) {
			System.out.println("Digite 1 - Para tentar novamente e \n2 - Para Finalizar");
			if (leitor.nextInt() == 1) {
				sacar();				
			}
		}
	}

	private void depositar() {
		Conta c = selecionarConta();
		leitor.nextLine();
		System.out.print("Valor: ");
		c.depositar(leitor.nextDouble());;
	}

	private Conta selecionarConta() {
		System.out.println("Digite a posição da conta: ");
		for (int i = 0; i < contas.length; i++) {
			//if ternario executa apos a "interrogacao" caso seja verdadeiro e apos os "dois pontos" : se for falso
			System.out.println(contas[i] != null ? i + " - " + contas[i].cliente.getNome() : "");
//			if (contas[i] != null) {
//				System.out.println(" - " + contas[i].cliente.getNome());
//			}
		}
		Integer indice = leitor.nextInt();
		
		return contas[indice];
	}

	private void tarifarConta() {
		for (int i = 0; i < contas.length; i++) {//length identifica o tamanho do array
			if (contas[i] != null && contas[i] instanceof IPagavel) {//verifica se o objeto eh uma instancia de uma determinada classe ou interface
				((IPagavel) contas[i]).tarifar();
			}			
		}
		
	}

	private void captalizar() {
		//foreach mais performatico do que o for convensional
		//passa de 1 em 1 em todos os elementos do array
		for (Conta conta : contas) {
			if (conta != null && conta instanceof ICaptalizavel) {
				ICaptalizavel iCaptalizavel = (ICaptalizavel) conta;
				iCaptalizavel.captalizar();
			}			
		}
		
	}
	
	private void exibirDadosConta() {
		Conta c = recuperarConta();
		if (c != null) {
			System.out.println("\tCliente:\t" + c.cliente.getNome());
			System.out.println("\tEndereço:\t" + c.cliente.getEndereco());
			System.out.println("\t:Documento:\t" + c.cliente.getDocumento());
			System.out.println("\t:Saldo\t" + c.consultarSaldo());
			if (c instanceof ContaCorrente) {
				exibirDadosConta((ContaCorrente)c);
			} else if (c instanceof ContaInvestimento) {
				exibirDadosConta((ContaInvestimento)c);
			} else if (c instanceof ContaPoupanca) {
				exibirDadosConta((ContaPoupanca)c);	
			}
		}
	}

	private void exibirDadosConta(ContaPoupanca c) {
		// TODO Auto-generated method stub
	}

	private void exibirDadosConta(ContaInvestimento c) {
		System.out.println("\t:Taxa Manutenção:\t" + ((ContaInvestimento) c).taxaManutencao);
		System.out.println("\t:Taxa de Rendimento:\t" + ((ContaInvestimento) c).taxaRendimento);		
	}

	private void exibirDadosConta(ContaCorrente c) {
		System.out.println("\t:Taxa Manutenção:\t" + ((ContaCorrente) c).taxaManutencao);
		System.out.println("\t:Limite de Crédito:\t" + ((ContaCorrente) c).pegarLimiteCredito());
	}

	private Conta recuperarConta() {
		Conta conta = null;
		System.out.print("Informe o indice da conta: ");
		Integer indice = leitor.nextInt();
		if (indice < contas.length && indice >= 0) {
			conta = contas[indice];
		}
		return conta;
	}

	private void criarConta() {
		
		if (indice < contas.length) {
			//caso a opcao no primeiro menu seja 1
			//exibe o segundo menu com as opcoes do tipo de contas a serem criadas
			System.out.println("Digite\n1 - Conta Corrente\n2 - Conta Investimento\n3 - Conta Poupança\n=> ");
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
				System.out.println("Opção inválida...");
				break;
			}
		} else {
			System.out.println("Limite de contas excedido!");
		}
		
		//leitor.nextLine();//Elimina o enter
		
	}

	private void cadastrarContaInvestimento() {
		//aplica as funcionalidades dos metodos sobreescritos em ContaInvestimento(filho)
		//em um objeto do tipo conta(pai)
		ContaInvestimento contaInvestimento = new ContaInvestimento();
		//chama o metodo cadastrarConta passando o objeto da conta
		//a ser criada
		cadastrarConta(contaInvestimento);
		System.out.println("Informe a taxa de manutenção");
		//faz um cast do objeto c e o atribui a variavel do tipo ContaInvestimento
		//para poder utilizar os metodos e variaveis especificas da classe ContaInvestimento
		contaInvestimento.taxaManutencao = leitor.nextDouble(); //define a taxa de manuten��o que � especifica de uma conta investimento
		System.out.println("Informe a taxa de rendimento");
		contaInvestimento.taxaRendimento = leitor.nextDouble(); //define uma taxa de rendimento
		contas[indice++] = contaInvestimento;
	}

	private void cadastrarContaPoupanca() {
		//aplica as funcionalidades dos metodos sobreescritos em ContaPoupanca(filho)
		//em um objeto do tipo conta(pai)
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		//chama o metodo cadastrarConta passando o objeto da conta
		//a ser criada
		cadastrarConta(contaPoupanca);
	}

	private void cadastrarContaCorrente() {
		//aplica as funcionalidades dos metodos sobreescritos em ContaCorrente(filho)
		//em um objeto do tipo conta(pai)
		ContaCorrente contaCorrente = new ContaCorrente();
		//chama o metodo cadastrarConta passando o objeto da conta
		//a ser criada
		cadastrarConta(contaCorrente);
		System.out.print("Informe o limite de crédito: ");
		Double limiteCredito = leitor.nextDouble();
		//faz um cast do objeto c e o atribui a variavel do tipo ContaCorrente
		//para poder utilizar os metodos e variaveis especificas da classe ContaCorrente
		contaCorrente.atribuirLimiteCredito(limiteCredito); //chama o metodo que atribui um limite de credito passando seu valor
		contas[indice++] = contaCorrente;
	}

	public String recuperarMenu() {
		String menu =	"1 - Criar Conta\n" 
					  + "2 - Exibir dados da Conta\n"
					  + "3 - Tarifar Conta\n"
					  + "4 - Captalizar Conta\n"
					  + "5 - Depositar\n"
					  + "6 - Sacar\n"
					  + "6 - Atualizar Taxa Rendimento\n"
					  + " => ";
		return menu;
	}
	
	
	public void cadastrarConta(Conta conta) {
		System.out.print("Informe o saldo da conta: ");
		conta.depositar(leitor.nextDouble());
		System.out.print("Informe o nome do cliente: ");
		leitor.nextLine();
		conta.cliente = new Cliente(); //atribui um novo cliente, a variavel cliente dentro da conta recebida
		conta.cliente.setNome(leitor.nextLine()); //atribui o nome do cliente a variavel nome dentro do objeto cliente contido na conta recebida
		System.out.print("Informe o endereco do cliente: ");
		conta.cliente.setEndereco(leitor.nextLine()); //atribui o endere�o do cliente a variavel endere�o dentro do objeto cliente contido na conta recebida
		System.out.print("Informe o documento do cliente: ");
		conta.cliente.setDocumento(leitor.nextInt()); //atribui o documento do cliente a variavel documento dentro do objeto cliente contido na conta recebida
		//desempilha este metodo e retorna de onde parou no metodo anterior
	}
	
}
