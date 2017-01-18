package br.com.treinar.caixa.modelo.caixa;

import java.util.Date;

import br.com.treinar.caixa.modelo.Cliente;

//abstract define que nao eh possivel dar new na classe Conta so pode ser herdada
public abstract class Conta {

	public Double saldo;
	public Cliente cliente;
	
	public Conta() {
		//nao eh uma boa pratica inicializar variaveis no construtor
		//caso nao seja utilizada o espaco alocado serah perdido.
		//cliente = new Cliente();
	}
	public abstract void depositar(Double valor);
	
	public Double consultarSaldo() {
		//regra fuzzy...
		return saldo;
	}
	
	public Double consultarSaldo(int mes) {
		return saldo;
	}
	
	public Double consultarSaldo(int mes, Date data) {
		return saldo;
	}
	
}
