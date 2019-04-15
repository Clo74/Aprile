/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mavServ.web;

import mavServ.model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mavServ.business.CustomerStore;

/**
 *
 * @author tss
 */
@WebServlet("/customer-search")
public class CustomerSearch extends HttpServlet {

    private final static String DRIVER = "org.mariadb.jdbc.Driver";
    //private final static String URL="jdbc:mariadb://localhost:3306/classicmodels";
    // jdbc sempre fisso mysql tipo di db etc.. il formato dell'url lo trovo nella documentazione
    //del driver
    private final static String URL = "jdbc:mysql://localhost:3306/classicmodels";
    private final static String USR = "root";
    private final static String PWD = "ghiglieno";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        String scr = req.getParameter("search");
//        System.out.println("Ricerca: " + scr);
//        
//        PrintWriter wr = resp.getWriter();
//        DbManager manager = new DbManager();
//        
//        List<Customer> customer = manager.searchCustormer(scr);
//        +
        System.out.println("start ricerca clienti...");

        String search = req.getParameter("search");

        System.out.println("ricerca di: " + search);

        PrintWriter wr = resp.getWriter();
        
        CustomerStore manager = new CustomerStore();
    
        List<Customer> customer = manager.searchCustormer(search);
        
        wr.println("<h1>Risultato ricerca</h1>");
        wr.println("<ul>");
        customer.forEach(c -> wr.println("<li>" + c.getName() + "</li>"));
        wr.println(("</ul"));
        
    }

}
