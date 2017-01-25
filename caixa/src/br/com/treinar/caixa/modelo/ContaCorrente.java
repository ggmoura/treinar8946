package br.com.treinar.caixa.modelo;

import br.com.treinar.caixa.modelo.caixa.Conta;
import br.com.treinar.caixa.modelo.caixa.IPagavel;

public class ContaCorrente extends Conta implements IPagavel {//define heranca, reaproveitar codigo da classe herdada

	private Double limiteCredito;
	public Double taxaManutencao;
	
	//sobreescreve o metodo depositar contido na classe pai
	//alterando o funcionamento para as especifica��es necessarias em uma conta corrente
	@Override
	public void depositar(Double valor) { 
		saldo = saldo + (valor - 1);
	}
	
	//sobreescreve o metodo consultarSaldo contido na classe pai
	//alterando o funcionamento para as especifica��es necessarias em uma conta corrente
	@Override
	public Double consultarSaldo() {
		//O Operador super acessa recursos da classe pai
		Double saldoConta = super.consultarSaldo();
		return saldoConta + limiteCredito;
	}
	
	//adiciona o metodo que � peculiar a classe conta corrente
	//para definir um limite de credito
	public void atribuirLimiteCredito(Double limiteCredito) {
		if (limiteCredito != null && limiteCredito >= 300) {
			this.limiteCredito = limiteCredito;
		} else {
			this.limiteCredito = 300d;
		}
	}
	
	//adiciona o metodo que � peculiar a classe conta corrente
	//para retornar o limite de credito
	public Double pegarLimiteCredito() {
		return limiteCredito;
	}
	
	/**
	 * Metodo para efetuar saque, diminui do saldo da conta
	 * o valor informado no parametro
	 * 
	 * @param valor - valor a ser sacado 
	 */
	@Override
	public void sacar(Double valor) throws SaldoInsuficienteException {
		if (saldo + limiteCredito >= valor) {
			saldo -= valor;
		} else {
			SaldoInsuficienteException excecao = new SaldoInsuficienteException();
			excecao.setSaldoAtual(consultarSaldo());
			throw excecao;
		}
	}

	@Override
	public void tarifar() {
		try {
			sacar(taxaManutencao);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Enviar email");
		}
	}
	
}
