/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Francisco MSI
 */
public class FormatedString {

    private String tipo;
    private LinkedHashMap<String, String> atributos;

    public FormatedString(String tipo, int numeroCampos) {
        this.tipo = tipo;
        this.atributos = new LinkedHashMap<>(numeroCampos);
    }

    public FormatedString(String str) throws RepresentacaoInvalidaDoTipo {
        
        this.atributos = new LinkedHashMap<>();
        
        try{
            
            int contador = 0;
            int end = str.indexOf('(');
            this.tipo = str.substring(0, end);
            
            String campo = "",valor = "",temp="";
            while(true){
                
                str = str.substring( end+1 );
                end = str.indexOf(":");
                if(end < 0) break;
                
                campo = str.substring(0,end );
                str = str.substring( end+1 );
                
                if ( str.charAt(0) == '[' ){ //se um array
                
                    end = encontratIndiceDoFecho(str,'[',']');
                    valor = str.substring(0, end+1 );
                    
                } else if( str.indexOf("(") > 0 && ( str.indexOf("(") < str.indexOf(";") ) ){//se um tipo
                
                    end = encontratIndiceDoFecho(str,'(',')');
                    valor = str.substring(0, end+1 );
                    end++;
                     
                } else { //ser for valor simples
                    
                    end = str.indexOf(";");
                    valor = str.substring(0,end);
                }
                
                addAtributo(campo, valor);
                
            }
            
        } catch(Exception e ) {
            throw new RepresentacaoInvalidaDoTipo("A string " + str + " não está fromatada corretamente." );          
        }
        
    }
    
    private int encontratIndiceDoFecho(String str , char abertura ,char fecho ){
        
        char[] ch_str = str.toCharArray();
        int indice = 0;
        int contador = 0; // conta abertos
        int indice_divisor = 0;
       
        for (int i = 0; i < str.length() ; i++) {
            
            if ( ch_str[i] == abertura  ) {
                
                contador++;
                
            }else if( ch_str[i] == fecho  ){
                
                contador--;
                indice = i;
                
            }else
                continue;

            if (i!= 0 && contador == 0 ) {
                return str.indexOf(fecho,i);
            }
            
        }
        
        return -1;
        
    }
   

    public <T> void addAtributo(String nomeCampo, T value) {

        this.atributos.put(nomeCampo, value.toString());
       
    }

    public void removeAtributo(String nomeCampo) {
        this.atributos.remove(nomeCampo);
    }

    public String getAtributo(String nomeCampo) {
        return this.atributos.get(nomeCampo);
    }
    
    public String getAtributo(String nomeCampo,String className) throws RepresentacaoInvalidaDoTipo {
        
        String temp = this.atributos.get(nomeCampo);
        if(temp == null)
            throw new RepresentacaoInvalidaDoTipo("O atributo \"" + nomeCampo + "\" não está representado na FormaatedString. Não representa um : " + className );
        else
            return temp;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public static <Tipo> String formatArray(ArrayList< ? extends Gravavel> array) {

        int count = 1;
        String temp = "[";
        for (Gravavel item : array) {

            if (count == array.size()) {
                temp += item.toFormatedString().toString() + ",]";
            } else {
                temp += item.toFormatedString().toString() + ",";
            }

            count++;
        }

        return temp;
    }

    public static <Tipo> ArrayList<Tipo> converterFormatedArray(Class<Tipo> cclass, String strArray) throws RepresentacaoInvalidaDoTipo{

        ArrayList<Tipo> novoArray = new ArrayList<>();
        return convert(cclass, strArray, novoArray);
    }

    public static <Tipo> ArrayList<Tipo> converterFormatedArray(Class<Tipo> cclass, String strArray, int capadidaeInicial) throws RepresentacaoInvalidaDoTipo{

        ArrayList<Tipo> novoArray = new ArrayList<>(capadidaeInicial);
        return convert(cclass, strArray, novoArray);
        
    }
    
    @Override
    public String toString() {

        String temp = this.tipo + '(';

        int count = 1;
        
        for (Map.Entry<String, String> entry : this.atributos.entrySet() ) {

            if (count == this.atributos.size()) {
                temp += entry.getKey() + ":" + entry.getValue() + ";)";
            } else {
                temp += entry.getKey() + ":" + entry.getValue() + ";";
            }

            count++;
           
        }

        return temp;

    }

    private static <Tipo> ArrayList<Tipo> convert(Class<Tipo> cclass, String strArray, ArrayList<Tipo> array) throws RepresentacaoInvalidaDoTipo{

        int end = 0;
        FormatedString fstr;
        strArray = strArray.substring(1);
        while (true) {

            end = strArray.indexOf(',');
            if (end < 0) {
                break;
            }

            fstr = new FormatedString(strArray.substring(0, end));
            array.add((Tipo) novaInstancia(cclass, fstr));
            strArray = strArray.substring(end + 1);

        }

        return array;

    }

    private static <Tipo> Object novaInstancia(Class<Tipo> cclass , FormatedString fstr) throws RepresentacaoInvalidaDoTipo{

        switch (cclass.getSimpleName()) {

            case "GeneAtratividade":
                return new GeneAtratividade(fstr);
            case "GeneAmbiente":
                return new GeneAmbiente(fstr);
            case "GeneRepoducao" :
                return new GeneRepoducao(fstr);
            case "GeneLongividade":
                return new GeneLongividade(fstr);
            case "GeneEspecie" :
                return new GeneEspecie(fstr);
            case "GeneEspecifico":  
                return new GeneEspecifico(fstr);
            case "GeneDieta":
                return new GeneDieta(fstr);
            case "GeneSexo":
                return new GeneSexo(fstr);
                
            default:
                throw new AssertionError();
        }

    }
    
}
