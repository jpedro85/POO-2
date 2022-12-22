/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Francisco MSI
 */
public class FormatedString {
    
    private String tipo;
    private HashMap<String,String> atributos;
        
    public FormatedString(String tipo,int numeroCampos){
        this.tipo = tipo;
        this.atributos = new HashMap<>(numeroCampos);
    }
    
    public FormatedString(String str) throws Exception {
        
           
           int begin = str.lastIndexOf( this.getClass().getSimpleName());
           
           if ( begin < 0)
               throw new Exception();
           else {
               
           /*    str = str.substring( str.indexOf(':' ) + 1 );
                this.setId( Integer.parseInt(str.substring(0, str.indexOf(';')) ) );
                str = str.substring( str.indexOf(':' ) + 1 );
                this.setNome( str.substring(0, str.indexOf(';')) );
                str = str.substring( str.indexOf(':' ) + 1 );
                this.setGeracao(Integer.parseInt(str.substring(0, str.indexOf(';')) ));
                str = str.substring( str.indexOf(':' ) + 1 );
                this.valor = str.substring(0, str.indexOf(')')) ;*/
               
           }
           
    }
    
    public <T> void addAtributo(String nomeCampo, T value){
        this.atributos.put(nomeCampo,value.toString());
    }
    
    public void removeAtributo(String nomeCampo){
        this.atributos.remove(nomeCampo);
    }
    
    public String getAtributo(String nomeCampo ){
        return this.atributos.get(nomeCampo);
    }
    
    public String getString(){
        
        String temp = this.tipo + '(';
         
        int count = 1;
        for ( Map.Entry<String,String> entry : this.atributos.entrySet() ) {
           
            if( count == this.atributos.size())
                temp += entry.getKey() + ":" + entry.getValue() + ";";
            else
                temp += entry.getKey() + ":" + entry.getValue() + ")";
            
            count++;
            
        } 
        
        return temp;
        
    }
    
    public static <Tipo> ArrayList<Tipo> converterFormatedArray(Class<Tipo> instaceClass, String strArray ) {
        
        ArrayList<Tipo> novoArray = new ArrayList<>();
        return convert(instaceClass,strArray,novoArray);     
    }
    
    public static <Tipo> ArrayList<Tipo> converterFormatedArray(Class<Tipo> instaceClass, String strArray, int capadidaeinitial ) {
        
        ArrayList<Tipo> novoArray = new ArrayList<>(capadidaeinitial );
        return convert(instaceClass,strArray,novoArray); 
    }
    
    private static <Tipo> ArrayList<Tipo> convert(Class<Tipo> instaceClass, String strArray,ArrayList<Tipo> array ){
        
        //format "[Object(campo:valor),Object(campo:valor),Object(campo:valor),Object(campo:valor),Object(campo:valor)]"
        
        try{
            
            int indiceFim = strArray.indexOf(',');//verificar
            FormatedString fstr = new FormatedString( strArray.substring(1,indiceFim) );
            array.add( (Tipo)novaInstancia( instaceClass.getSimpleName(),fstr) );
            strArray = strArray.substring(indiceFim + 1);
                
            while( true ){
            
                indiceFim = strArray.indexOf(',');
                if(indiceFim < 0)
                    break;
                    
                fstr = new FormatedString( strArray.substring(1,indiceFim) );
                array.add( (Tipo)novaInstancia( instaceClass.getSimpleName(),fstr) );
                strArray = strArray.substring(indiceFim + 1);
           
            }
            
            return array;
            
        }catch(Exception e){
            
            return null;
        }
        
    }
    
    private static Object novaInstancia( String  classname , FormatedString fstr ){
        
        switch (classname) {
            case "GeneEspecie":
                return new GeneEspecie(fstr);
            case "G":
                return new GeneEspecie(fstr);
            case "H":
                return new GeneEspecie(fstr);
            default:
                throw new AssertionError();
        }
            
    }
}    
   
    
  
