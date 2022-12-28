/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.InputMismatchException;
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
    
    public String pedirNome(String message){
        System.out.println("-> " + message);
        System.out.print("<-:");
        
        String nome = "";
        while(nome == null || nome.equals("")){
            nome=this.getScanner().nextLine();
        }
        return nome;
    }
    
    public GeneEspecie pedirGeneEspecie(){
        for(GeneEspecie gene:GeneEspecie.getAllInstances()){
            System.out.println(gene);   
        }
        System.out.println("-> " + "Introduza um numero");
        System.out.print("<-:");
        
        int id = -1;
        GeneEspecie gene=null;
        while(gene==null){
            
            id = this.pedirNumero("Introduza o ID do Gene de Especie", 0, Gene.getLastId());
            for(GeneEspecie genes:GeneEspecie.getAllInstances()){
              if(id==genes.getId()){
                  gene=genes;
                  return gene;
              }
              else{
                  System.out.println("ID invalido, tente novamente:" );
                  id=-1;
              }
            }
        }
        return null;
    }
    
    public boolean pedirBooleano(String message){
        System.out.println(message+"\n<-:");
        while(true){
            try{
                return getScanner().nextBoolean();
            }catch(InputMismatchException e){
                System.out.println("Introduzio um valor não booleano. Tente de novo!!!");
                System.out.println("<-:");
            }
        }
    }
    public String pedirValorStringGeneEspecie(){
        String temp="";
        boolean valido=false;
        if(!Carregador.isZooCarregado()){
            Carregador.carrega(GeneEspecie.class, "SimuladorSaves/TodosGenesDeEspecie.txt");
        }
        while(valido==false){
            temp=pedirNome("Introduza um novo Valor para o GeneEspecie");
            valido=true;
            for (GeneEspecie gene : GeneEspecie.getAllInstances()) {
                if(gene.getValor().equals(temp)){
                    valido=false;
                    break;
                }
            }
        }
        return temp;
    }
    
    public String pedirValorStringGeneEspecifico(){
        String temp="";
        boolean valido=false;
        if(!Carregador.isZooCarregado()){
            Carregador.carrega(GeneEspecifico.class, "SimuladorSaves/TodosGenesDeEspecifico.txt");
        }
        while(valido==false){
            temp=pedirNome("Introduza um novo Valor para o GeneEspecifico");
            valido=true;
            for (GeneEspecifico gene : GeneEspecifico.getAllInstances()) {
                if(gene.getValor().equals(temp)){
                    valido=false;
                    break;
                }
            }
        }
        return temp;
    }
    
    public CararcteristicasEspecificas pedirTipoCaracteristica(){
        
        System.out.println("-> " + "Escolha um tipo dos seguintes:" );
        for(CararcteristicasEspecificas tipo:CararcteristicasEspecificas.values()){
            System.out.println(tipo);
        }
        System.out.print("<-:");
        CararcteristicasEspecificas tipo = null;
        while(tipo == null){
            
            for (CararcteristicasEspecificas cara: CararcteristicasEspecificas.values()) {
                if(getScanner().nextLine().equals(cara.toString() )){
                     tipo = cara;
                     break;
                }
            }
            
            System.out.println("Não introduzio um Tipo válido. Tente outra vês !");
            System.out.print("<-:");
            
        }
        return tipo;
    }
    
    public Sexo pedirSexo(){
        System.out.println("-> " + "Escolha um dos Sexos seguintes:" );
        for(Sexo s:Sexo.values()){
            System.out.println(s);
        }
        System.out.print("<-:");
        Sexo tipo=null;
        while(tipo==null){
            for(Sexo ss:Sexo.values()){
                if(getScanner().nextLine().equals(ss.toString() )){
                    tipo=ss;
                    break;
                }
            }
            System.out.println("Não introduzio um Sexo válido. Tente outra vês !");
            System.out.print("<-:");
        }
        return tipo;
    }
    
    public Dieta pedirDieta(){
        System.out.println("-> " + "Escolha um dos Sexos seguintes:" );
        for(Dieta s:Dieta.values()){
            System.out.println(s);
        }
        System.out.print("<-:");
        Dieta tipo=null;
        while(tipo==null){
            for(Dieta d:Dieta.values()){
                if(getScanner().nextLine().equals(d.toString() )){
                    tipo=d;
                    break;
                }
            }
            System.out.println("Não introduzio um Sexo válido. Tente outra vês !");
            System.out.print("<-:");
        }
        return tipo;
    }
    
    public Ambiente pedirAmbiente(){
        System.out.println("-> " + "Escolha um dos Ambientes seguintes:" );
        for(Ambiente s:Ambiente.values()){
            System.out.println(s);
        }
        System.out.print("<-:");
        Ambiente tipo=null;
        while(tipo==null){
            for(Ambiente a:Ambiente.values()){
                if(getScanner().nextLine().equals(a.toString() )){
                    tipo=a;
                    break;
                }
            }
            System.out.println("Não introduzio um Ambiente válido. Tente outra vês !");
            System.out.print("<-:");
        }
        return tipo;
    }
}
