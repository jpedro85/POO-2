/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */

import java.util.ArrayList;

public class Horario<T> {
    
    private ArrayList<T> tarefas;
    private int maxtarefas;

    public Horario(int maxTarefas) {
        
        this.maxtarefas = maxTarefas;
        this.tarefas = new ArrayList<>(this.maxtarefas);
        
    }

    public int getMaxtarefas() {
        return maxtarefas;
    }
     
    public void addTarefa( T tarefa ){
        
        if( this.tarefas.size() <  this.maxtarefas)
            this.tarefas.add(tarefa);
    }
    
    public void removeTarefa( int indice ){
        
        if(indice > 0 && indice < this.tarefas.size() )
            this.tarefas.remove( indice );
            
    }
    
    public int getIndice( T tarefa ){
        
        return this.tarefas.indexOf(tarefa);
        
    }
    
    public boolean temTarefa( T tarefa) {
        
        return this.tarefas.contains(tarefa);
        
    }
    
    public boolean temTarefas(){
        
        return this.tarefas.isEmpty();
    }

}
    
   
    
   
