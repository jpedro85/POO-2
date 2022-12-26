/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public class RepresentacaoInvalidaDoTipo extends Exception{
    
    private static RepresentacaoInvalidaDoTipo ultimaExecao;

    public RepresentacaoInvalidaDoTipo(String msg) {
        super(msg);
        ultimaExecao=this;
    }
    
    public static RepresentacaoInvalidaDoTipo getUltimaExcecao(){
        return ultimaExecao;
    }
    
    @Override
    public String toString(){
        
        String temp = this.getMessage() + "\n";
        
        for (StackTraceElement a : this.getStackTrace()) {
            temp += "\t" + a.toString() + "\n";
        }
        
        return temp;
    }
}
