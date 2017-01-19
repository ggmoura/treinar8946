package br.com.treinar.caixa.test;

import br.com.treinar.caixa.modelo.ContaCorrente;

public class TesteConta {

	public static void main(String[] args) {
		ContaCorrente c = new ContaCorrente();
		c.depositar(100.0);
		c.atribuirLimiteCredito(10d);
		System.out.println(c.sacar(250d));
		System.out.println(c.sacar(20d));
		System.out.println(c.sacar(12000d));
		//c.saldo = 100000d;
		System.out.println(c.sacar(12000d));
	}
	
}
