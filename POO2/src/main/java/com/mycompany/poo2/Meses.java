/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public enum Meses {
    JANEIRO("janeiro",31),
    FEVEREIRO("fevereiro",28),
    MARCO("marco",31),
    ABRIL("abril",30),
    MAIO("maio",31),
    JUNHO("junho",30),
    JULHO("julho",31),
    AGOSTO("agosto",31),
    SETEMBRO("setembro",30),
    OUTUBRO("outubro",31),
    NOVEMBRO("novembro",30),
    DEZEMBRO("dezembro",31);
    
    private String nome;
    private int dias;


    private Meses(String mes, int dias) {
        this.nome = mes;
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public boolean isLastDay(int dia){
        return dias==dia;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    /**
     * Retorn o Mes representado numa String
     * @param str
     * @return null se str não representa um mes
     */
    public static Meses representa(String str){
        
        for (Meses mes : Meses.values()) {
            
            if( str.equals(mes.toString()) )
                return mes;
        }

        return null;
    }
    
}
