package br.com.curso.api.controller;

import java.util.Scanner;

public class AlgoritmoPostoGasolina {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int numeroOpcao = 0;
		String alcool = "1 - Alcool";
		String gasolina = "2 - Gasolina";
		String opcao = null;	

		do {

			System.out.println(alcool);
			System.out.println(gasolina);
			System.out.println("3 - Reiniciar Seleção");
			System.out.println("4 - Sair");
			
			numeroOpcao = scanner.nextInt();

			if (numeroOpcao == 1)
				opcao = alcool;
			else if (numeroOpcao == 2) {
				opcao = gasolina;
			}  else if (numeroOpcao == 4) {
				System.out.println("Saindo do sistema...");
			}

			if (numeroOpcao != 3 && numeroOpcao != 4) {
				System.out.println("Opção Selecionada: " + opcao);

				System.out.println("Digite o valor: ");

				Double valorCombustivel = scanner.nextDouble();

				System.out.println("Digite quantos litros será abastecido:");
				int quantidade = scanner.nextInt();

				System.out.println("Valor total de " + opcao + ":" + " R$" + (valorCombustivel * quantidade));
			}			
		} while (numeroOpcao != 4);

	}

}
