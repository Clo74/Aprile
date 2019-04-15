/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mavServ.business;

import mavServ.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */

//con @Named rendo accessibile la classe dalle pagine JSP con il nome che metto tra apici
//non si fa così
@Named("db")
@Stateless
public class CustomerStore {

//    private final static String DRIVER = "org.mariadb.jdbc.Driver";
//    //private final static String URL="jdbc:mariadb://localhost:3306/classicmodels";
//    // jdbc sempre fisso mysql tipo di db etc.. il formato dell'url lo trovo nella documentazione
//    //del driver
//    private final static String URL = "jdbc:mysql://localhost:3306/classicmodels";
//    private final static String USR = "root";
//    private final static String PWD = "ghiglieno";

    public List<Customer> searchCustormer(String search) {
  
            // 1) PASSO: carica in memoria il driver
            // forName genera un eccezione OBBLIGATORIA, quindi da gestire
            // bisogna metterlo per forza in un blocco try catch
        try (Connection cn = DSManager.connection();) {
            
            List<Customer> result = new ArrayList<>();
            try (Statement cmd = cn.createStatement(); 
                 ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                    + " from customers "
                    + " where customerName like '" + search + "%' order by customerName")) {
                while (query.next()) {
                    result.add(new Customer(
                            query.getString("customerName"),query.getInt("customerNumber")));
                }
            }

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
    }
    
    public List<Customer>  findAll() {
    try {
            Connection cn = DSManager.connection();
            List<Customer> result = new ArrayList<>();
            try (Statement cmd = cn.createStatement(); 
                 ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                    + " from customers order by customerName"
                    )) {
                while (query.next()) {
                    result.add(new Customer(
                            query.getString("customerName"),query.getInt("customerNumber")));
                }
            }

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
          
    }

    public Customer find(int id) {
    try {
            Connection cn = DSManager.connection();

            Customer result = null;
            try (Statement cmd = cn.createStatement(); 
                 ResultSet query = cmd.executeQuery("select customerNumber,customerName from customers "
                         + "where customerNumber=" + id + ";" 
                    )) {
                if (query.next()) {
                    result= new Customer(query.getString("customerName"),query.getInt("customerNumber"));
                }
            }

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
          
        
    }
}
