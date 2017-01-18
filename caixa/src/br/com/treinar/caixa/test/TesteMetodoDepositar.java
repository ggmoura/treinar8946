package br.com.treinar.caixa.test;

import br.com.treinar.caixa.modelo.ContaCorrente;
import br.com.treinar.caixa.modelo.caixa.Conta;

public class TesteMetodoDepositar {

	public static void main(String[] args) {
		Conta conta = new ContaCorrente();
		conta.saldo = 0.0;
		//conta.atribuirLimiteCredito(300d);
		
		System.out.println("Saldo antes do depósito: " + conta.saldo);
		conta.depositar(1000.0);
		System.out.println("Saldo após depósito: " + conta.saldo);
		
	}
	
}
