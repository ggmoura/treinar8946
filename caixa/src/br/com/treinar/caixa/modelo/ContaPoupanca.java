package br.com.treinar.caixa.modelo;

import br.com.treinar.caixa.modelo.caixa.Conta;
import br.com.treinar.caixa.modelo.caixa.ICaptalizavel;

public class ContaPoupanca extends Conta implements ICaptalizavel {

	public static Float taxaRendimento;
	
	static {
		taxaRendimento = 10f;
	}
	
	static {
		taxaRendimento = 0f;
	}
	
	//sobreescreve o metodo depositar contido na classe pai
	//alterando o funcionamento para as especifica��es necessarias em uma conta poupan�a
	@Override
	public void depositar(Double valor) {
		saldo += valor;
	}
	
	public void sacar(Double valor) {
		Boolean sacou = Boolean.FALSE;
		if (saldo >= valor) {
			saldo -= valor;
			sacou = Boolean.TRUE;
		}
	}
	
	@Override
	public void captalizar() {
		depositar(saldo * taxaRendimento);
	}
	
	public static Float recuperarTaxaRendimento() {
		
		return taxaRendimento;
	}
	
}
