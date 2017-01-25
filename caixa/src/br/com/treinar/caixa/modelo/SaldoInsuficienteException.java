package br.com.treinar.caixa.modelo;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 2386337865676362812L;
	//private static final long serialVersionUID = 1L;

	private Double saldoAtual;

	public Double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

}
