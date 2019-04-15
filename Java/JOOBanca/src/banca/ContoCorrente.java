/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class ContoCorrente {

    //una variabile final è una costante quindi una volta assegnata non la posso cambiare
    private final int numero;
    private final String intestatario;
    private double saldo;
    private List<Double> movimenti = new ArrayList<>();
    private static float interesse = 0.04f;
    
    public ContoCorrente(int numero, String intestatario) {
        this.numero = numero;
        this.intestatario = intestatario;
        this.saldo = 0;
    }

    public void prelievo(double somma) {
        if (this.saldo < somma || somma <= 0) {
            throw new IllegalArgumentException("La somma non è disponibile");
        }
        saldo -= somma;
        movimenti.add(0, -somma);
    }

    public void deposito(double somma) {
        if (somma <= 0) {
            throw new IllegalArgumentException("Somma non valida");
        }
        saldo += somma;
        movimenti.add(0, somma);
    }

    public int getNumero() {
        return numero;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Double> estrattoConto(int num) {
        return movimenti.stream().limit(num).collect(Collectors.toList());
    }
    public List<Double> depositi(int num) {
        return movimenti.stream()
                .filter(movimento -> movimento>0) //filtra quelli che sono > 0
                .limit(num) //ne prende solo i primi n
                .collect(Collectors.toList()); //restituisce una lista
    }
    public static void modificaInteresse (float valore) {
        if (valore <0) {
            throw new IllegalArgumentException("Ineresse negativo non valido");
        }
        interesse = valore;
    }

}
