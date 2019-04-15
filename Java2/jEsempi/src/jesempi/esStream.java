/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jesempi;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tss
 */
public class esStream {

    public static void main(String[] args) {
        Integer[] numeri = {20, 5, 2, 8, 11, 90, 90, 11};
        
        List<Integer> listNumeri = Arrays.asList(numeri);
        //filter crea lista sono di quelli che rispondono a vero alla condizione che metto
        //map restituisce un nuovo flusso di elaborazione
        listNumeri
                .stream()
                .distinct()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(n -> System.out.println(n));
    }
}
