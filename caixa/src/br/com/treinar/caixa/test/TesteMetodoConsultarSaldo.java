package br.com.treinar.caixa.test;

import br.com.treinar.caixa.modelo.Conta;

public class TesteMetodoConsultarSaldo {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.saldo = 0.0;
		conta.limiteCredito = 300d;
		
		System.out.println("Saldo antes do depósito: " + conta.saldo);
		conta.depositar(1000.0);
		System.out.println("Saldo após depósito: " + conta.consultarSaldo());
		
	}
	
}
