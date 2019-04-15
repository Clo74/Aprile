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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class DbManager {

    private final static String DRIVER = "org.mariadb.jdbc.Driver";
    //private final static String URL="jdbc:mariadb://localhost:3306/classicmodels";
    // jdbc sempre fisso mysql tipo di db etc.. il formato dell'url lo trovo nella documentazione
    //del driver
    private final static String URL = "jdbc:mysql://localhost:3306/classicmodels";
    private final static String USR = "root";
    private final static String PWD = "ghiglieno";

    private DbManager() {
        /*metodi statici non li posso istanziare*/
    }

    public static Connection openConnection() {
        Connection cn;
        try {
            Class.forName(DRIVER);

            // 2) PASSO: aprire una connessione
            cn = DriverManager.getConnection(URL, USR, PWD);
            return cn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("---si è verificato un errore di connessione---" + ex.getMessage());
            /*per getire meglio gli errori genero un mio errore
            in questo modo l'esecuzione del metodo si tronca e quindi va bene che non ci sia un return*/
            throw new RuntimeException("Connessione al DB fallita");

        }
    }

    public static ResultSet executeQuery(Connection cn, String sql) {
        /*gli oggetti che sono autoclosable posso metterli in questo modo
        così si autochiude dentro al try*/
        try (Statement cmd = cn.createStatement()) {

            return cmd.executeQuery(sql);

        } catch (SQLException ex) {
            throw new RuntimeException("errore nell'esecuzione della query");
            /*dalla finally passa SEMPRE*/
        } finally {
            System.out.println("-------passato da finally---------");

        }
    }

    public static ResultSet searchByName(Connection cn, String ricerca) {
        return executeQuery(cn, "select * from customers "
                + " where customerName like '" + ricerca + "%' order by customername");
        

    }
}
