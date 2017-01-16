package br.com.treinar.caixa.modelo.visao;

import java.util.Scanner;

public class MenuCaixa {
	
	public Scanner leitor = new Scanner(System.in);

	public void iniciarAtividade() {

		Integer opcao = null;

		do {
			System.out.println(recuperarMenu());
			//opcao = 
			
			
			
			
		} while (!opcao.equals(0));
		
	}
	
	
	public String recuperarMenu() {
		String menu = "1 - Criar Conta\n";
		return menu;
	}
	
	
}
