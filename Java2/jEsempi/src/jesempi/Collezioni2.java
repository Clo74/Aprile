/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jesempi;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tss
 */
public class Collezioni2 {

    public static void main(String[] args) {
        Integer[] numeri = {20, 5, 2, 8, 11, 90, 90, 11, 1, 7};

        //Collection<Integer>  soloDispari =  rimuoviPari(Arrays.asList(numeri));
        Collezioni2 istanza = new Collezioni2();
        Collection<Integer> soloDispari = istanza.rimuoviPari(Arrays.asList(numeri));

        /*oppure faccio
        new Collezioni2().rimuoviPari(Arrays.asList(numeri));
         */
        for (Integer numero : soloDispari) {
            System.out.println(numero);
        }
    }

    /*
    Ritorna una nuova collection senza i numeri pari e senza i doppi dato che uso HashSet
     */
    public Collection<Integer> rimuoviPari(Collection<Integer> numeri) {

        Collection<Integer> result = new HashSet(numeri);
        /*    non si può modificare una lista mentre la ciclo !!!!!
        for  (Integer numero : result){
            if (numero % 2 == 0){
                result.remove(numero);
            }
        }
         */
 /*la soluzione è o aggiungere su uno nuovo
        oppure usare iterator
         */
        Iterator<Integer> iterator = result.iterator();

        while (iterator.hasNext()) {
            Integer numero = iterator.next();
            if (numero % 2 == 0) {
                iterator.remove();
            }
        }
        return result;
    }
}
