/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlez04;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Scambio {

    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);

        System.out.println("Inserisci primo numero");
        int intNum1 = scInput.nextInt();
        
        System.out.println("Inserisci secondo numero");
        int intNum2 = scInput.nextInt();

        int intNumApp = intNum1;
        intNum1 = intNum2;
        intNum2 = intNumApp;

        System.out.println("Il numero 1 :" + intNum1);
        System.out.println("Il numero 2 :" + intNum2);
        //altro modo posso concatenare le stringhe con argomenti che specifico in ordine dopo
        System.out.println(String.format("N1 vale %s , N2 vale %s", intNum1,intNum2));

    }

}
