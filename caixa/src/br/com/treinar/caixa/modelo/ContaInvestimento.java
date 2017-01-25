package br.com.treinar.caixa.modelo;

import br.com.treinar.caixa.modelo.caixa.Conta;
import br.com.treinar.caixa.modelo.caixa.ICaptalizavel;
import br.com.treinar.caixa.modelo.caixa.IPagavel;

public class ContaInvestimento extends Conta implements IPagavel, ICaptalizavel {

	public Double taxaRendimento;
	public Double taxaManutencao;
	
	//sobreescreve o metodo depositar contido na classe pai
	//alterando o funcionamento para as especifica��es necessarias em uma conta investimento
	@Override
	public void depositar(Double valor) {
		// TODO Auto-generated method stub
		
	}
	public void sacar(Double valor) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void tarifar() {
		sacar(taxaManutencao - 5);
	}
	
	@Override
	public void captalizar() {
		depositar(30D);
	}
}
