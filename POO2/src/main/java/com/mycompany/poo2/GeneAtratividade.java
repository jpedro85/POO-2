/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class GeneAtratividade extends GeneMutavel implements Registo<GeneAtratividade>{

    private int atratividade;
    private static ArrayList<GeneAtratividade> allInstancesCreated = new ArrayList<>(200);

    public GeneAtratividade(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr,"GeneAtratividade");
        this.atratividade = Integer.parseInt ( fstr.getAtributo("Atratividade","GeneAtratividade") );
    }
    
    public GeneAtratividade(int atratividade, String nome , int geracao) {
        super(nome,geracao);
        this.atratividade = atratividade;
    }
    
    public GeneAtratividade(int atratividade, String nome ) {
        super(nome);
        this.atratividade = atratividade;
    }

    public int getAtratividade() {
        return atratividade;
    }
    
    @Override
    public ArrayList<GeneAtratividade> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneAtratividade instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneAtratividade instance ){
        allInstancesCreated.remove(instance);   
    }
    
    @Override
    public void mutar() {
        
        if( Gerador.gerarProbabilidade() <= 40 ){
            
            if (Gerador.gerarProbabilidade() < 30) {
                this.atratividade += Gerador.gerarNumero(10, 50 );
            }else{
                int temp = Gerador.gerarNumero(1, 5);
                if( this.atratividade - temp > 0){
                    this.atratividade -= temp;
                }else
                    this.atratividade = 0;
                    
            }
            super.mutar();
        }
    }
    
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome());
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Atratividade",  this.getAtratividade());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneAtratividade(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Atratividade:"+ this.getAtratividade() +")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneAtratividade gene = (GeneAtratividade)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getGeracao() == gene.getGeracao()) && (this.isMutado() == gene.isMutado()) && (this.getAtratividade()== gene.getAtratividade()) ;
    }
    
    @Override
    public GeneAtratividade clone(){
        
        return new GeneAtratividade(this.getAtratividade(),this.getNome(),this.getGeracao());
    }
}
