/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 *  Main Class
 */
public class POO2 {


    public static void main(String[] args) {
        
      /* 
       try{
            
            String a  = "Animal(Id:14;NomeArtistico:Boi_animal_14;NomeArtisticoPai:Basha;NomeArtisticoMae:Grey;Genoma:Genoma(GeneSexo:GeneSexo(Id:198;Nome:Femea;Sexo:femea;);GeneDieta:GeneDieta(Id:199;Nome:Tudo;Dieta:omnivoro;);GeneAtratividade:GeneAtratividade(Id:200;Nome:ver1;Geracao:0;Mutado:false;Atratividade:0;);GeneLongividade:GeneLongividade(Id:201;Nome:NomrmalLongitividade2;Geracao:0;Mutado:false;Anos:57;);GeneRepoducao:GeneRepoducao(Id:202;Nome:BaixaReprodução2;Geracao:0;Mutado:false;Apetite:15;);GeneAmbiente:GeneAmbiente(Id:203;Nome:Ambiente2;Geracao:0;Mutado:false;Ambiente:taiga;);Especie:Especie(Nome:Boi;Genes:[GeneEspecie(Id:19;Nome:Dorminhoco;Valor:dorme muito;),GeneEspecie(Id:16;Nome:Silencioso;Valor:faz pouco barulho;),GeneEspecie(Id:10;Nome:Preguiçoso:Voador;Valor:tem preguiça;),];);Especificos:[GeneEspecifico(Id:37;Nome:TipoOlhos4;Valor:esbugalhados;Tipo:olhos;),];);Idade:0;AtratividadeBase:12;Doente:false;Tratado:true;UltimaTratacao:0;)";
            FormatedString b = new FormatedString(a);
            Animal c = new Animal(b);
            
        }catch(RepresentacaoInvalidaDoTipo a){
            
            System.out.println(a);
            
        }
        */
      
     /*   Instalacao a = new Instalacao("teste1",5,Ambiente.DESERTICO,120,200,6);
        
        System.out.println(a);
        System.out.println(a.toFormatedString());
        
        try{
            Instalacao b = new Instalacao(a.toFormatedString());
            System.out.println(b);
        }
        catch(RepresentacaoInvalidaDoTipo e){
            System.out.println(e);
        }*/
        
        Carregador.carregarFicheiros();
        
        MenuGeral menuMenuGeral = new MenuGeral();
        menuMenuGeral.mostrarOpcoes();
        menuMenuGeral.executarOpcaoPedida();
     
       // MenuSimulador m = new MenuSimulador(null);
       // m.mostrarOpcoes();
       // m.executarOpcaoPedida();
        
    }
    
}
