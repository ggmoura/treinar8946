package br.com.treinar.caixa.modelo;

import br.com.treinar.caixa.modelo.caixa.Conta;

public class ContaPoupanca extends Conta {

	public Float taxaRendimento;
	
	//sobreescreve o metodo depositar contido na classe pai
	//alterando o funcionamento para as especificações necessarias em uma conta poupança
	@Override
	public void depositar(Double valor) {
		saldo += valor;
	}
	
}
