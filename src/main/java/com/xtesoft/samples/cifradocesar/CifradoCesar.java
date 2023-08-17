/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtesoft.samples.cifradocesar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xtecuan
 */
public class CifradoCesar {

    private static final List<String> ALFABETO
            = Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" "));

    public static void main(String[] args) {
//        System.out.println("Texto plano: " + "HELLO");
//        String cifrado = cifrarMetodoCesar("HELLO", 3);
//        System.out.println("Texto cifrado: " + cifrado);
//        String descifrado = descifrarMetodoCesar(cifrado, 3);
//        System.out.println("Texto descifrado: " + descifrado);
        if (args != null && args.length == 3) {
            if (args[0].equals("cifrar")) {
                System.out.println(cifrarMetodoCesar(args[1], Integer.valueOf(args[2])));
            } else if (args[0].equals("descifrar")) {
                System.out.println(descifrarMetodoCesar(args[1], Integer.valueOf(args[2])));
            } else {
                System.out.println("No se ha encontrado la operacion: " + args[0]);
            }
        } else {
            System.out.println("Forma de uso: java -jar cifrado-cesar.jar cifrar|descifrar palabra desplazamiento");
        }
    }

    public static String cifrarMetodoCesar(String texto, int desplazamiento) {
        List<String> alfades = desplazarAlfabeto(desplazamiento);

        char[] textoPlano = texto.toUpperCase().toCharArray();
        List<String> palabra = new ArrayList<>(textoPlano.length);
        for (int i = 0; i < textoPlano.length; i++) {
            palabra.add(String.valueOf(textoPlano[i]));
        }
        StringBuilder sb = new StringBuilder();
        palabra.forEach(letra -> {
            sb.append(alfades.get(ALFABETO.indexOf(letra)));
        });
        return sb.toString();
    }

    public static String descifrarMetodoCesar(String texto, int desplazamiento) {

        List<String> alfades = desplazarAlfabeto(desplazamiento);

        char[] textoPlano = texto.toUpperCase().toCharArray();
        List<String> palabra = new ArrayList<>(textoPlano.length);
        for (int i = 0; i < textoPlano.length; i++) {
            palabra.add(String.valueOf(textoPlano[i]));
        }
        StringBuilder sb = new StringBuilder();
        palabra.forEach(letra -> {
            sb.append(ALFABETO.get(alfades.indexOf(letra)));
        });
        return sb.toString();

    }

    public static List<String> desplazarAlfabeto(int pos) {

        List<String> desplazado = new ArrayList<>(ALFABETO.size());
        desplazado.addAll(ALFABETO.subList(pos, ALFABETO.size()));
        desplazado.addAll(ALFABETO.subList(0, pos));
        return desplazado;

    }

}
