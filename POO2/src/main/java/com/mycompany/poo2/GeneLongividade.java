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
public class GeneLongividade extends GeneMutavel implements Registo<GeneLongividade>{

    private static ArrayList<GeneLongividade> allInstancesCreated = new ArrayList<>(200);
    private int anos;

    public GeneLongividade(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        super(fstr,"GeneLongividade");
        
        try{
            this.anos = Integer.parseInt( fstr.getAtributo("Anos","GeneLongividade") );
            
        }catch(NumberFormatException exp){
            throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr );
        }
    }

    public GeneLongividade(int anos, String nome , int geracao) {
        super(nome,geracao);
        this.anos = anos;
    }
    
    public GeneLongividade(int anos, String nome) {
        super(nome);
        this.anos = anos;
    }

    public int getAnos() {
        return anos;
    }
    
    public static ArrayList<GeneLongividade> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( GeneLongividade instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( GeneLongividade instance ){
        allInstancesCreated.remove(instance);   
    }
    
    @Override
    public void addInstanceAoResgisto(){  
        allInstancesCreated.add(this);
    }
   
    @Override
    public void removeInstanceDoResgisto(){
        allInstancesCreated.remove(this);   
    }
    
    @Override
    public void mutar() {
        
        if( Gerador.gerarProbabilidade() <= 10 ){
            
            if (Gerador.gerarProbabilidade() < 30) {
                this.anos += Gerador.gerarNumero(1,10 );
            }else{
                
                int temp = Gerador.gerarNumero(1, 5);
                if( this.anos - temp > 0){
                    this.anos -= temp;
                }else{
                    this.anos = 0;
                }
                
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
        fsrt.addAtributo("Mutado",  this.estaMutado());
        fsrt.addAtributo("Anos",  this.getAnos() );
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneLongividade(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ";Anos:"+ this.getAnos()+")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneLongividade gene = (GeneLongividade)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getGeracao() == gene.getGeracao()) && (this.estaMutado() == gene.estaMutado()) && (this.getAnos()== gene.getAnos()) ;
    }
    
    @Override
    public GeneLongividade clone(){
        
        return new GeneLongividade(this.getAnos(),this.getNome(),this.getGeracao());
    }
}
