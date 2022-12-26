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

    public RepresentacaoInvalidaDoTipo(String msg) {
        super(msg);
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
