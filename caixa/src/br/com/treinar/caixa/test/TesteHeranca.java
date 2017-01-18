package br.com.treinar.caixa.test;

import br.com.treinar.caixa.modelo.Cliente;
import br.com.treinar.caixa.modelo.ContaCorrente;
import br.com.treinar.caixa.modelo.ContaPoupanca;
import br.com.treinar.caixa.modelo.caixa.Conta;

public class TesteHeranca {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(); //instancia um obj do tipo ContaCorrente
		cc.atribuirLimiteCredito(400d); //atribui um limite de credito ao objeto
		cc.saldo = 1000.0; //define o saldo do objeto conta corrente
		
		System.out.println(cc.consultarSaldo());
		
		ContaPoupanca cp = new ContaPoupanca(); //instancia um obj do tipo ContaPoupança
		cp.saldo = 10000D; //define o saldo do objeto conta poupança
		System.out.println(cp.consultarSaldo());
		
		//instancia um objeto do tipo conta que tem seus metodos limitados
		//apenas a aqueles contidos na classe conta, cuja funcionalidade especifica
		//foi redefinida na classe conta corrente
		Conta c = new ContaCorrente();
		c.saldo = 100.0; //define um saldo para o objeto Conta
		c.cliente = new Cliente(); //atribui um cliente a conta
		
		//Casting (convertendo a variavel conta para contacorrente)
		((ContaCorrente)c).atribuirLimiteCredito(100.0);
		//reutiliza o objeto c do tipo conta para criar um novo objeto com as funcionalidades
		//especificas de uma conta poupança, cujas funcionalidades especificas
		//foram definidas na classe conta poupança e tem seu metodos limitados apenas a aqueles
		//contidos na classe pai
		//ou seja, os metodos ADICIONADOS a classe especifica, não são visiveis para o programa
		//a menos que se faça cast
		c = new ContaPoupanca();
		
		
	}
	
}
