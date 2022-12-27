/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.Scanner;

/**
 *
 * @author Francisco MSI
 */
public abstract class Menu {
    
    private static Menu ultimoMeno;
    private static Scanner scanner = new Scanner(System.in);
    
    public void mostrarOpcoes(String title , String optn){
        
        System.out.println(title);
        System.out.println(" Opções:" );
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(optn);
        System.out.println("------------------------------------------------------------------------------------------");
    }
    
    public int pedirOpcao(int maxOptn){
        
        System.out.println("-> " + "Escolha uma opção !");
        System.out.print("<-:");
        
        int optn = -1;
        while(optn == -1){
            optn = validarNumero( 0, maxOptn,getScanner().nextLine());
        }
        return optn;
    }
    
    public int pedirNumero(String menssagem,int min,int max){
        
        System.out.println("-> " + menssagem );
        System.out.print("<-:");
        
        int optn = -1;
        while(optn == -1){
            optn = validarNumero( min, max,getScanner().nextLine());
        }
        return optn;
        
    }
    
    public Meses pedirMes(){
        
        System.out.println("-> " + "Introduza um Mes" );
        System.out.print("<-:");
        
        Meses mes = null;
        while(mes == null){
            
            for (Meses m : Meses.values() ) {
                if(getScanner().nextLine().equals(m.toString() )){
                     mes = m;
                     break;
                }
            }
            
            System.out.println("Não introduzio um mês válido. Tente outra vês !");
            System.out.print("<-:");
            
        }
        return mes;
        
    }
            
    private int validarNumero(int limitInf ,int limitSup ,String str_number){
    
        try {

            int valor = Integer.parseInt(str_number);
            
            if (valor >= limitInf && valor <= limitSup) {
                return valor;
            } else {
                throw new NumberFormatException("Numero fora dos limites permitidos !");
            }
            
            
        } catch (NumberFormatException expNumber) {

            System.out.println(expNumber.getMessage());
            System.out.println("Tente de novo.");
            System.out.print("<-:");
            return -1;
        }

    }   
    
    public abstract void mostrarOpcoes();
    public abstract void excutarOpcaoPedida();
    public abstract void executarOpcao(int optn); 
    
    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Menu.scanner = scanner;
    }
    
    public static Menu getUltimoMeno() {
        return ultimoMeno;
    }

    public static void setUltimoMeno(Menu ultimoMeno) {
        Menu.ultimoMeno = ultimoMeno;
    }
        
    public void voltarAtraz(){
        getUltimoMeno().excutarOpcaoPedida();
    }
    
    public String pedirNome(){
        System.out.println("-> " + "Introduza um Nome");
        System.out.print("<-:");
        
        String nome = "";
        while(nome == null || nome.equals("")){
            nome=this.getScanner().nextLine();
        }
        return nome;
    }
    
    public int pedirGeneEspecie(){
        for(GeneEspecie gene:GeneEspecie.getAllInstances()){
            System.out.println(gene);   
        }
        System.out.println("-> " + "Introduza um numero");
        System.out.print("<-:");
        
        int id = -1;
        while(id == -1){
            id = this.pedirNumero("Introduza o ID do Gene de Especie", 0, Gene.getLastId());
            for(GeneEspecie gene:GeneEspecie.getAllInstances()){
              if(id==gene.getId()){
                  return id;
              }
              else{
                  System.out.println("ID invalido, tente novamente:" );
                  id=-1;
              }
            }
        }
        return id;
    }
}
