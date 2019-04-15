/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlez04;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Pari {
    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        
        System.out.println("Inserisci il numero");
        int intNum = scInput.nextInt();

        //int intNum = intNum / 2;
        
        //System.out.println(String.format("Il risultato è %s", intNum));
        
        // % mi restituisce il resto della divisione per un numero
        int intResto = intNum % 2;
        
        if (intResto == 0) {
            System.out.println("In numero è pari");
        } else {
            System.out.println("Il numero è dispari");
        }
        
    }
}
