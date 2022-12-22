/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */

public abstract class Gene implements Gravavel{ 
    
    private static int lastId = 0;
    private int id;
    private String nome;
    private int geracao;
    //private String sequencia;
        
    public Gene(String nome ) {
        
        this.nome = nome;
        this.geracao = 0;
        this.id = ++lastId;
        
    }
    
    public <T>Gene( FormatedString fstr , String className) throws RepresentacaoInvalidaDoTipo {
        
        if( fstr.getTipo().equals( className ) ) throw  new RepresentacaoInvalidaDoTipo("FormatedString fsrt não representa um :" + className );
        
        this.nome = fstr.getAtributo("Nome");
        this.geracao = Integer.parseInt( fstr.getAtributo("Geracao") );
        this.id = Integer.parseInt( fstr.getAtributo("Id") );
                
        if(this.id > lastId)
            lastId = this.id;

    }
                        
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getGeracao() {
        return this.geracao;
    }
    
    @Override
    public String toString(){

        return "Gene(Id:" + this.id + ";Nome:" + this.nome + ";Geracao:" + this.geracao + ")"  ;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        return this.id == ((Gene) obj).getId();
       
    }
      
}
