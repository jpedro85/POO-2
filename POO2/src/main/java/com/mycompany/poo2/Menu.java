/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.Scanner;

/**
 *
 * @author Francisco MSI
 */
public abstract class Menu {

    private static Menu ultimoMeno;
    private static Scanner scanner = new Scanner(System.in);

    public void mostrarOpcoes(String optn) {

        System.out.println(" Opções:");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(optn);
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public int pedirOpcao(int maxOptn) {

        System.out.println("-> " + "Escolha uma opção !");
        System.out.print("<-:");
        int optn = -1;

        while (optn < 0) {
            String linha = scanner.nextLine();
            optn = this.validarOptn(linha, maxOptn);
        }

        return optn;
    }

    public int validarOptn(String number, int maxOptn) {

        try {

            int optn = Integer.parseInt(number);

            if (optn >= 0 && optn <= maxOptn) {
                return optn;
            } else {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException expNumber) {

            System.out.println("Opção inválidae tem de ser um numero entre 0 e " + maxOptn + " !");
            System.out.println("Tente de novo.");
            return -1;
        }

    }

    public abstract void executarOpcao(int optn);

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Menu.scanner = scanner;
    }

    public static Menu getUltimoMeno() {
        return ultimoMeno;
    }

    public static void setUltimoMeno(Menu ultimoMeno) {
        Menu.ultimoMeno = ultimoMeno;
    }

}
