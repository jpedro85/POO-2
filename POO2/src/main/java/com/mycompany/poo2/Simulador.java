/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class Simulador {

    public static void main(String[] args) {
        Tratador t = new Tratador("maneul caralho", 123456789, 20, 2520, 10, 20, 20, 30);
        Zelador z = new Zelador("zezinho esquerdo", 123456789, 25, 2100, 15, 25, 15, 25);
        Veterinario v = new Veterinario("Carlos manuel", 123456789, 63, 25, 10, 30, 15, 60);
        Cliente cl= new Cliente("Colhaoteral", 123456, 20, 1500, 25, 26);
        
        FormatedString a = t.toFormatedString();
        FormatedString b = z.toFormatedString();
        FormatedString c = v.toFormatedString();
        FormatedString d = cl.toFormatedString();
        
        System.out.println(a.getString());
        System.out.println(b.getString());
        System.out.println(c.getString());
        System.out.println(d.getString());
        
        try {
            Tratador t1= new Tratador(a);
            System.out.println("===============");
            System.out.println(t1);
            System.out.println(t);
            Zelador z1= new Zelador(b);
            System.out.println("===============");
            System.out.println(z1);
            System.out.println(z);
            Veterinario v1= new Veterinario(c);
            System.out.println("===============");
            System.out.println(v1);
            System.out.println(v);
            Cliente cl1= new Cliente(d);
            System.out.println("===============");
            System.out.println(cl1);
            System.out.println(cl);
        } catch (RepresentacaoInvalidaDoTipo exc) {
            System.out.println("===============");
            System.out.println("C");
            System.out.println("O");
            System.out.println("N");
            System.out.println("A");
            System.out.println(exc.getMessage());

        }
    }
}
