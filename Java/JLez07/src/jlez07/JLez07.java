/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlez07;

/**
 *
 * @author tss
 */
public class JLez07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        int inQuanteVocali= 0;
        
        String strProva = "Claudia";
        
        System.out.println(strProva);
        
        inQuanteVocali= contaVocali(strProva);
        
        System.out.println(inQuanteVocali);
        
        System.out.println("la frase è palindroma? " + palindroma(strProva));

    }

    public static int contaVocali (String strCaratteri) {
        int inNrVocali = 0;
        //char[] chArray = new char[strCaratteri.length()];
        
        char[] chVocali = {'a','e','i','o','u','A','E','I','O','U'};
        
        //String strVocali = "aeiou";
       
        //chArray = stringa.toCharArray();
        
        for (int i = 0; i < strCaratteri.length(); i++) {
            char lettera = strCaratteri.charAt(i);
            for (int j = 0; j < 10; j++) {
                if (lettera == chVocali[j]) {
                    inNrVocali++;
                }
            }
        }
        
        return inNrVocali;
    }    

    public static int contaVocali2(String strCaratteri) {
        int inNrVocali = 0;
        String vocali = "aeiou";
        
        strCaratteri = strCaratteri.toLowerCase();
        
        for (int i = 0; i < strCaratteri.length(); i++) {
            char lettera = strCaratteri.charAt(i);
            if (vocali.indexOf(lettera) != -1) {
                inNrVocali++;
            }
                
        }
        
        return inNrVocali;
    }
    
    public static boolean palindroma(String strCaratteri) {
        
        boolean bolRitorno = false;
        
        String strReverse = "";
        
        for (int i = strCaratteri.length()-1; i>=0; i--) {
            strReverse += strCaratteri.charAt(i);
        }
        
        //System.out.println(strReverse);
        
        bolRitorno = strReverse.equalsIgnoreCase(strCaratteri);
        
        return bolRitorno;
    }
}

