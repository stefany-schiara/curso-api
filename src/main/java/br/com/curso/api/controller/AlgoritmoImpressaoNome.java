package br.com.curso.api.controller;

import java.util.Scanner;

import org.springframework.util.StringUtils;



public class AlgoritmoImpressaoNome {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um nome:");
		
		String nome = scanner.nextLine();
		
		System.out.println(conversor(nome));
	}
	
	public static String conversor(String nome) {
		nome = StringUtils.replace(nome.toUpperCase(), "A", "@");
		nome = StringUtils.replace(nome.toUpperCase(), "E", "&");
		nome = StringUtils.replace(nome.toUpperCase(), "I", "!");
		nome = StringUtils.replace(nome.toUpperCase(), "O", "#");
		nome = StringUtils.replace(nome.toUpperCase(), "U", "*");
		
		return nome;
	}
	
	

}
