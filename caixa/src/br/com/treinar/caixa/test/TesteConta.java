package br.com.treinar.caixa.test;

import br.com.treinar.caixa.modelo.ContaCorrente;
import br.com.treinar.caixa.modelo.SaldoInsuficienteException;

public class TesteConta {

	public static void main(String[] args) throws SaldoInsuficienteException {
		ContaCorrente c = new ContaCorrente();
		c.depositar(100.0);
		c.atribuirLimiteCredito(10d);
		c.sacar(250d);
		System.out.println();
		c.sacar(20d);
		System.out.println();
		c.sacar(12000d);
		System.out.println();
		//c.saldo = 100000d;
		c.sacar(12000d);
		System.out.println();
	}
	
}
