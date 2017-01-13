package br.com.treinar.caixa.modelo;

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
	
}
