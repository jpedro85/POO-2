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
public class GeneRepoducao extends GeneMutavel implements Registo<GeneRepoducao>{

    private int apetite;
    private static ArrayList<GeneRepoducao> allInstancesCreated = new ArrayList<>(200);

    public GeneRepoducao(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr , "GeneRepoducao");
        this.apetite = Integer.parseInt(fstr.getAtributo("Apetite","GeneRepoducao") );
    }

    public GeneRepoducao(int apetite, String nome , int geracao) {
        super(nome,geracao);
        this.apetite = apetite;
    }
    
    public GeneRepoducao(int apetite, String nome ) {
        super(nome);
        this.apetite = apetite;
    }

    public int getApetite() {
        return apetite;
    }
    
    @Override
    public ArrayList<GeneRepoducao> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneRepoducao instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneRepoducao instance ){
        allInstancesCreated.remove(instance);   
    }

    @Override
    public void mutar() {
        
        if( Gerador.gerarProbabilidade() <= 10 ){
            
            if (Gerador.gerarProbabilidade() < 50) {
                this.apetite += Gerador.gerarNumero(1,10 );
            }else{
                
                int temp = Gerador.gerarNumero(1, 10);
                if( this.apetite - temp > 0){
                    this.apetite -= temp;
                }else
                    this.apetite = 1;
            } 
                
            super.mutar();  
        }
    }

    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome() );
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Apetite",  this.getApetite());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneRepoducao(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ";Apetite:"+ this.getApetite() +")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneRepoducao gene = (GeneRepoducao)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getGeracao() == gene.getGeracao()) && (this.isMutado() == gene.isMutado()) && (this.getApetite() == gene.getApetite()) ;
    }
    
    @Override
    public GeneRepoducao clone(){
             
        return new GeneRepoducao(this.getApetite(),this.getNome(),this.getGeracao());
    }
}
