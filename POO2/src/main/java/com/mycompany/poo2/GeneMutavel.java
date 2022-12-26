/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public abstract class GeneMutavel extends Gene{
    
    private int geracao;
    private boolean mutado;
    
    public GeneMutavel(FormatedString fstr , String classname) throws RepresentacaoInvalidaDoTipo {
        super(fstr ,classname);
        
        try{
            this.geracao = Integer.parseInt( fstr.getAtributo("Geracao") );
            this.mutado = Boolean.parseBoolean(fstr.getAtributo("Mutado"));
            
        }catch(NumberFormatException exp){
            throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr );
        }
        
    }

    public GeneMutavel(String nome , int geracao) {
        super(nome);
        this.geracao = geracao;
        this.mutado = false;
    }
    
    public GeneMutavel(String nome) {
        super(nome);
        this.geracao = 0;
        this.mutado = false;
    }
    
    public int getGeracao() {
        return this.geracao;
    }
    
    public void evoluir() {
        this.geracao++;
    }
    
    public boolean estaMutado(){
        return this.mutado;
    }
    
    public void mutar(){
        this.geracao++;
        this.mutado = true;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneMutavel gene = (GeneMutavel)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getGeracao() == gene.getGeracao()) && (this.estaMutado() == gene.estaMutado()) ;
    }
       
}
