/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jesempi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tss
 */
public class JEsempi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] numeri = {20,5,2,8,11,90,90,11};
                List<Integer> listNumeri = Arrays.asList(numeri);
                Set<Integer> setNumeri= new HashSet(listNumeri);
                
                System.out.println("--for each");
                
                for (Integer numero : numeri){
                    System.out.println(numero);
                }
                
                System.out.println("--interator");

        Iterator<Integer> iterator = setNumeri.iterator();
        //Interato setNumeri.interator();
                        
    }
    
}
