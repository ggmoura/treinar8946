package br.com.treinar.caixa.modelo;

import br.com.treinar.caixa.modelo.caixa.Conta;

public class ContaCorrente extends Conta {//define heranca, reaproveitar codigo da classe herdada

	private Double limiteCredito;
	public Double taxaManutencao;
	
	
	@Override
	public void depositar(Double valor) {
		saldo = saldo + (valor - 1);
	}
	
	@Override
	public Double consultarSaldo() {
		//O Operador super acessa recursos da classe pai
		Double saldoConta = super.consultarSaldo();
		return saldoConta + limiteCredito;
	}
	
	public void atribuirLimiteCredito(Double limiteCredito) {
		if (limiteCredito != null && limiteCredito >= 300) {
			this.limiteCredito = limiteCredito;
		} else {
			limiteCredito = 300d;
		}
	}
	
	public Double pegarLimiteCredito() {
		return limiteCredito;
	}
	
	
}
