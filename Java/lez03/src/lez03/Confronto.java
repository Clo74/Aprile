 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez03;
//libreria di java va dichiarata
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Confronto {
    //leggere due numeri interi e stampare il più grande
    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        
        System.out.println("Inserisci primo numero");
        int intNum1 = scInput.nextInt();

        System.out.println("Inserisci secondo numero");
        int intNum2 = scInput.nextInt();
        
        if (intNum1 == intNum2) {
            System.out.println("I numeri sono uguali");
        } else {
            if (intNum1 < intNum2) {
                System.out.println("Il numero più grande è il secondo");
            } else {
                System.out.println("Il numero più grande è il primo");
            }
        }
    }
}
