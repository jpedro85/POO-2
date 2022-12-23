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
        this.atributos = new LinkedHashMap<String, String>(numeroCampos);
    }

    public FormatedString(String str) throws RepresentacaoInvalidaDoTipo {
        
        this.atributos = new LinkedHashMap<String, String>();
        
        try{
            
            int end = str.lastIndexOf('(');
            this.tipo = str.substring(0, end);
               
            String campo = "",valor = "";
            
            boolean bool = true;
            while(bool){

                str = str.substring(end+1);
                end = str.indexOf(":");
                if(end < 0) break;

                campo = str.substring(0,end );
                str = str.substring(end+1);
                end = str.indexOf(";");
                if(end < 0){
                    end = str.indexOf(")");
                    bool = false;
                }   
                valor = str.substring(0,end);

                this.addAtributo(campo, valor);
            }
            
        } catch(Exception e ) {
            throw new RepresentacaoInvalidaDoTipo("A string " + str + " não está fromatada corretamente." );          
        }
        
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
            throw new RepresentacaoInvalidaDoTipo("FormatedString fsrt não representa um : " + className );
        else
            return temp;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public static <Tipo> String formatArray(ArrayList< ? extends Gravavel> array) {

        int count = 0;
        String temp = "[";
        for (Gravavel item : array) {

            if (count == array.size()) {
                temp += item.toFormatedString().toString() + ",";
            } else {
                temp += item.toFormatedString().toString() + "]";
            }

            count++;
        }

        return temp;
    }

    public static <Tipo> ArrayList<Tipo> converterFormatedArray(Class<Tipo> instaceClass, String strArray) throws RepresentacaoInvalidaDoTipo{

        ArrayList<Tipo> novoArray = new ArrayList<>();
        return convert(instaceClass, strArray, novoArray);
    }

    public static <Tipo> ArrayList<Tipo> converterFormatedArray(Class<Tipo> instaceClass, String strArray, int capadidaeinitial) throws RepresentacaoInvalidaDoTipo{

        ArrayList<Tipo> novoArray = new ArrayList<>(capadidaeinitial);
        return convert(instaceClass, strArray, novoArray);
    }
    
    @Override
    public String toString() {

        String temp = this.tipo + '(';

        int count = 1;
        
        for (Map.Entry<String, String> entry : this.atributos.entrySet() ) {

            if (count == this.atributos.size()) {
                temp += entry.getKey() + ":" + entry.getValue() + ")";
            } else {
                temp += entry.getKey() + ":" + entry.getValue() + ";";
            }

            count++;
           
        }

        return temp;

    }

    private static <Tipo> ArrayList<Tipo> convert(Class<Tipo> instaceClass, String strArray, ArrayList<Tipo> array) throws RepresentacaoInvalidaDoTipo{

        //format "[Object(campo:valor),Object(campo:valor),Object(campo:valor),Object(campo:valor),Object(campo:valor)]"
        int end = strArray.indexOf(',');//verificar
        FormatedString fstr = new FormatedString(strArray.substring(1, end));
        array.add((Tipo) novaInstancia(instaceClass.getSimpleName(), fstr));
        strArray = strArray.substring(end + 1);

        while (true) {

            end = strArray.indexOf(',');
            if (end < 0) {
                break;
            }

            fstr = new FormatedString(strArray.substring(1, end));
            array.add((Tipo) novaInstancia(instaceClass.getSimpleName(), fstr));
            strArray = strArray.substring(end + 1);

        }

        return array;

    }

    private static Object novaInstancia(String classname, FormatedString fstr) throws RepresentacaoInvalidaDoTipo{

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
