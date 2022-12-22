/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *
 * @author Francisco MSI
 * @param <T>
 */

public interface Registo<T> {
    
    ArrayList <T> getAllInstances();
    
    void addInstance( T instance );
    
    void removeInstance( T instance );
       
}
