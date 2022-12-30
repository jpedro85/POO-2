/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 * Oferece os tipos de acontecimentos que podem ser guardados no historico.
 */
public enum Acontecimentos {
    
    LIBERTADO("Libertação"),
    OBITO("Óbito"),
    NASCIMENTO("Nascimento"),
    ANIMALDOETE("Animal doente"),
    ANIMCURADO("Animal curado"),
    CONSTUCAO("Construção"),
    DESTRUICAO("Destruição"),
    CONTRATACAO("Contratação"),
    DESPEDIMENTO("Despedimento"),
    DESPESA("Despesa"),
    LUCRO("Lucro"),
    INFO("Informação"),
    FUGAANIMAL("Fuga"),
    ENCONTRADO("Encontrado");
    
    private String name;
    
    private Acontecimentos(String name){
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    /**
     * Devolve True se str representa um Acontecimentos (se é igual ao toString de um Acontecimentos).
     */
    public static boolean estaRepresentado(String str){
        
        for (Acontecimentos acont : Acontecimentos.values()) {
            
            if( str.equals(acont.toString()) )
                return true;
        }

        return false;
    }
    
    /**
     * Retorn um Acontecimento representado numa String
     * @param str
     * @return 
     */
    public static Acontecimentos representa(String str){
        
        for (Acontecimentos acont : Acontecimentos.values()) {
            
            if( str.equals(acont.toString()) )
                return acont;
        }

        return null;
    }
}
