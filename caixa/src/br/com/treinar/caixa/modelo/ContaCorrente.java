package br.com.treinar.caixa.modelo;

import br.com.treinar.caixa.modelo.caixa.Conta;

public class ContaCorrente extends Conta {//define heranca, reaproveitar codigo da classe herdada

	private Double limiteCredito;
	public Double taxaManutencao;
	
	//sobreescreve o metodo depositar contido na classe pai
	//alterando o funcionamento para as especificações necessarias em uma conta corrente
	@Override
	public void depositar(Double valor) { 
		saldo = saldo + (valor - 1);
	}
	
	//sobreescreve o metodo consultarSaldo contido na classe pai
	//alterando o funcionamento para as especificações necessarias em uma conta corrente
	@Override
	public Double consultarSaldo() {
		//O Operador super acessa recursos da classe pai
		Double saldoConta = super.consultarSaldo();
		return saldoConta + limiteCredito;
	}
	
	//adiciona o metodo que é peculiar a classe conta corrente
	//para definir um limite de credito
	public void atribuirLimiteCredito(Double limiteCredito) {
		if (limiteCredito != null && limiteCredito >= 300) {
			this.limiteCredito = limiteCredito;
		} else {
			limiteCredito = 300d;
		}
	}
	
	//adiciona o metodo que é peculiar a classe conta corrente
	//para retornar o limite de credito
	public Double pegarLimiteCredito() {
		return limiteCredito;
	}
	
	
}
