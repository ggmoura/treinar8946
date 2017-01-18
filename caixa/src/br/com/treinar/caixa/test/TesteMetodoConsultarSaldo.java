package br.com.treinar.caixa.test;

import br.com.treinar.caixa.modelo.ContaCorrente;
import br.com.treinar.caixa.modelo.caixa.Conta;

public class TesteMetodoConsultarSaldo {

	public static void main(String[] args) {
		//instancia um novo objeto do tipo conta
		//que utiliza as funcionalidades herdadas de Conta, com o funcionamento implementado
		//na classe conta corrente
		Conta conta = new ContaCorrente();
		conta.saldo = 0.0; //define um saldo
		//conta.atribuirLimiteCredito(300d);
		
		System.out.println("Saldo antes do depósito: " + conta.saldo);
		conta.depositar(1000.0); //chama o metodo de deposito com o valor 1000.0
		System.out.println("Saldo após depósito: " + conta.consultarSaldo());
		
	}
	
}
