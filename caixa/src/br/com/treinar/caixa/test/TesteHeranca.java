package br.com.treinar.caixa.test;

import br.com.treinar.caixa.modelo.Cliente;
import br.com.treinar.caixa.modelo.ContaCorrente;
import br.com.treinar.caixa.modelo.ContaPoupanca;
import br.com.treinar.caixa.modelo.caixa.Conta;

public class TesteHeranca {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
		cc.atribuirLimiteCredito(400d);
		cc.saldo = 1000.0;
		
		System.out.println(cc.consultarSaldo());
		
		ContaPoupanca cp = new ContaPoupanca();
		cp.saldo = 10000D;
		System.out.println(cp.consultarSaldo());
		
		Conta c = new ContaCorrente();
		c.saldo = 100.0;
		c.cliente = new Cliente();
		
		//Casting (convertendo a variavel conta para contacorrente)
		((ContaCorrente)c).atribuirLimiteCredito(100.0);
		
		c = new ContaPoupanca();
		
		
	}
	
}
