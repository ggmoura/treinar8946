package br.com.treinar.caixa.modelo;

import java.util.Date;

public class Conta {

	public Double saldo;
	public Cliente cliente;
	public Double limiteCredito;
	
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
	
	
	
}
