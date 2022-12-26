/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.LinkedHashSet;

/**
 *
 * @author Pedro
 */
public final class Historico {
    
    private static LinkedHashSet<String> acontecimentos = new LinkedHashSet<>(200);

    private Historico() {}

    public void adicionarAcontecimento(String acontecimento) {
        acontecimentos.add(acontecimento);
    }

    @Override
    public String toString() {
        String text = "Historico:\n";
        for (String string : acontecimentos) {
            text += string + "\n";
        }
        return text;
    }

}
