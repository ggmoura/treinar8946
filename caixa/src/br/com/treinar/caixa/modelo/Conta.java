package br.com.treinar.caixa.modelo;

import java.util.Date;

public class Conta {

	public Double saldo;
	public Cliente cliente;
	private Double limiteCredito;
	
	public Conta() {
		//nao eh uma boa pratica inicializar variaveis no construtor
		//caso nao seja utilizada o espaco alocado serah perdido.
		//cliente = new Cliente();
	}
	public void depositar(Double valor) {
		saldo = saldo + valor;
	}
	
	public Double consultarSaldo() {
		Double saldoDisponivel = saldo + limiteCredito;
		return saldoDisponivel;
	}
	
	public Double consultarSaldo(int mes) {
		Double saldoDisponivel = saldo + limiteCredito * mes;
		return saldoDisponivel;
	}
	
	public Double consultarSaldo(int mes, Date data) {
		Double saldoDisponivel = saldo + limiteCredito * mes;
		return saldoDisponivel;
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
