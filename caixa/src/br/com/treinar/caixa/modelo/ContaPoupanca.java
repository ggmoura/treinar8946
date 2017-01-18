package br.com.treinar.caixa.modelo;

import br.com.treinar.caixa.modelo.caixa.Conta;

public class ContaPoupanca extends Conta {

	public Float taxaRendimento;
	
	@Override
	public void depositar(Double valor) {
		saldo += valor;
	}
	
}
