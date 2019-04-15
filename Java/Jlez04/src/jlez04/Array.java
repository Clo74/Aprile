/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlez04;

/**
 *
 * @author tss
 */
public class Array {
    public static void main(String[] args) {
        //dichiaro un array di numeri interi
        int[] arrNum;
        
        //creo l'array
        arrNum = new int[100];
        
        //posso dichiararlo e inizializzarlo anche:
        int[] intNum2 = new int[100];

                //altro modo
        int[] arrNum3 = {10,20,50,30};
        
        
        stampa(arrNum);

        for (int i = 0; i < 100; i++) {
            arrNum[i] = i+1;
            
        }
        
        stampa(arrNum);
        
        
    }

    //function in java
    public static void stampa(int[] arrArray){

        for (int i = 0; i < arrArray.length; i++) {
            int intElemento = arrArray[i];
            System.out.println(String.format("Elemento[%s] = %s", i,intElemento));
            
        }
        
    }
    
}


