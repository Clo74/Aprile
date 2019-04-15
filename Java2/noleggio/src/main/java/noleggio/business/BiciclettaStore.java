/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import noleggio.entity.Bicicletta;

/**
 *
 * @author tss
 */
@Stateless
public class BiciclettaStore {

    public List<Bicicletta> all() {
        List<Bicicletta> result = new ArrayList<>();
        try (Connection cn = DSManager.connection();
                Statement stat = cn.createStatement();
                    ResultSet res = stat.executeQuery("SELECT id_prodotto, nr_telaio, categoria_prodotto "
                            + "FROM Noleggio.t_prodotti Order by categoria_prodotto, nr_telaio");) {

                while (res.next()) {
                    result.add(new Bicicletta(res.getInt("id_prodotto"), res.getString("nr_telaio"), res.getString("categoria_prodotto")));
                }

            return result;
        } catch (SQLException ex) {
            Logger.getLogger(BiciclettaStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Errore di connessione al db");
        }
    }
}
