package br.com.curso.api.config;

import java.util.ArrayList;
import java.util.List;


public class Teste {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        //binario 101101

        int numeroDigitado = 10;
        int guardarNumeroDigitado = numeroDigitado;
        Integer resto;
        List<String> list = new ArrayList<>();


        while (numeroDigitado > 0){

            resto = numeroDigitado % 2;
            numeroDigitado = numeroDigitado / 2;

            //System.out.println(resto);


            list.add(resto.toString());
        }
        System.out.println(list);
        System.out.println("O numero digitado foi:" +guardarNumeroDigitado);
    }

}
