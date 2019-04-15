/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez12.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        // codice sotto il controllo dell'errore
        try (Connection cn = DbManager.openConnection()) {
            // 1) PASSO: carica in memoria il driver
            // forName genera un eccezione OBBLIGATORIA, quindi da gestire
            // bisogna metterlo per forza in un blocco try catch

            System.out.println("Connessione effettuata con successo!!");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci le iniziali del cliente da cercare");
            String ricerca = scanner.nextLine();

            try (ResultSet risultato = DbManager.searchByName(cn, ricerca)) {
                System.out.println("----------- Clienti trovati ---------------------------");
                /*metodo next restituisce vero se ho ancora righe
                    all'inizio sono prima della prima riga, facendo subito next mi trovo sulla
                    prima*/
                while (risultato.next()) {
                    String name = risultato.getString("customerName");
                    System.out.println(name);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Scusa ma qualcosa è andato storto nell'esecuzione della query!!!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("tipo di errore -->" + ex.getClass());
            System.out.println("Si è verificato un errore");
        }

    }
}
