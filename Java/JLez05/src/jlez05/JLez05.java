/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlez05;

import java.util.Iterator;

/**
 *
 * @author tss
 */
public class JLez05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] arNumeri = {33, 22, 55, 12, 54, 885, 142, 22, 454, 1};

        stampa(arNumeri);

        System.out.println("Numero Massimo");
        System.out.println(max(arNumeri));

        System.out.println("estrarre i nr pari e creare un nuovo array");
        stampa(pari(arNumeri));

        System.out.println("ricerca di un numero restituisce vero o falso");
        System.out.println(cerca(arNumeri, 12));

        System.out.println("ordina l'array");
        ordina(arNumeri);
        stampa(arNumeri);
    }
    

    public static void stampa(int[] arArray) {

        for (int intNumero : arArray) {
            System.out.println(intNumero);
        }
    }

    //trovare il numero massimo
    public static int max(int[] arArray) {
        int intMax = 0;

        for (int intApp : arArray) {
            if (intApp > intMax) {
                intMax = intApp;
            }
        }

        return intMax;
    }
    //estrarre i nr pari e creare un nuovo array

    public static int[] pari(int[] arArray) {
        int intLung = 0;

        for (int intApp : arArray) {
            int intResto = intApp % 2;
            if (intResto == 0) {
                intLung += 1;
            }

        }

        int[] arrApp = null;
        
        if (intLung > 0 ) {
            arrApp = new int[intLung];
            int i = 0;

            for (int intApp : arArray) {

                int intResto = intApp % 2;
                if (intResto == 0) {
                    arrApp[i] = intApp;
                    i++;
                }
            }
        }
        return arrApp;

    }
    //ricerca di un numero restituisce vero o falso

    public static boolean cerca(int[] arArray, int intNum) {
        boolean bolTrovato = false;

        for (int intApp : arArray) {
            if (intApp == intNum) {
                bolTrovato = true;

            }
        }
        return bolTrovato;
    }

    //ordina un array 
    public static void ordina(int[] arArray) {

        //int swap;
        //for (int i = 0; i < arArray.length - 1; i++) {
        //    for (int j = 0; j < arArray.length - 1 - i; j++) {
        //        if (arArray[j] > arArray[j + 1]) {
        //            swap = arArray[j];
        //            arArray[j] = arArray[j + 1];
        //            arArray[j + 1] = swap;
        //        }
        //    }
        //}
        int intApp;
        for (int i = 0;i < arArray.length;i++) {

                   for (int j = i+1; j < arArray.length; j++) {

                       if (arArray[i] > arArray[j]) {
                           intApp = arArray[i];
                           arArray[i]=arArray[j];
                           arArray[j] = intApp;
                       }

                   }        

            }
    }
}
