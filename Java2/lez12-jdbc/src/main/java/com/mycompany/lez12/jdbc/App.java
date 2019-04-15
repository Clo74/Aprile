/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App {
    
    private final static String DRIVER="org.mariadb.jdbc.Driver";
    //private final static String URL="jdbc:mariadb://localhost:3306/classicmodels";
    // jdbc sempre fisso mysql tipo di db etc.. il formato dell'url lo trovo nella documentazione
    //del driver
    private final static String URL="jdbc:mysql://localhost:3306/classicmodels";
    private final static String USR="root";
    private final static String PWD="ghiglieno";
    
    public static void main(String[] args)  {
        
        // codice sotto il controllo dell'errore
        try {
            // 1) PASSO: carica in memoria il driver
            // forName genera un eccezione OBBLIGATORIA, quindi da gestire
            // bisogna metterlo per forza in un blocco try catch
            Class.forName(DRIVER);
            
            // 2) PASSO: aprire una connessione
            Connection cn = DriverManager.getConnection(URL, USR, PWD);
            
            System.out.println("Connessione effettuata con successo!!");
            
            // 3) PASSO: Creare comandi
            Statement cmd = cn.createStatement();
            
            
            Scanner scanner= new Scanner(System.in);
            System.out.println("Inserisci le iniziali del cliente da cercare");
            String ricerca = scanner.nextLine();
            
            ResultSet risultato = cmd.executeQuery("select * from customers " 
                    + " where customerName like '" + ricerca + "%' order by customername");
            System.out.println("----------- Clienti trovati ---------------------------");
            /*metodo next restituisce vero se ho ancora righe
            all'inizio sono prima della prima riga, facendo subito next mi trovo sulla
            prima*/
            while (risultato.next()) {
                String name = risultato.getString("customerName");
                System.out.println(name);
                
            }
            risultato.close();
            cmd.close();
            cn.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Scusa ma qualcosa è andato storto nel caricamento del driver.!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Scusa ma qualcosa è andato storto nel caricamento del db.!!!");
        }
        
    }
}
