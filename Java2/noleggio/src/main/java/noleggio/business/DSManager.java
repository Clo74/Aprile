/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.business;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author tss
 */
public class DSManager {

    public static Connection connection() {
        try {
            InitialContext ctx = new InitialContext();

            DataSource ds = (DataSource) ctx.lookup("jdbc/noleggioDB");

            return ds.getConnection();

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DSManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Problemi nel recuperare la connessione a db");
        }
    }
}