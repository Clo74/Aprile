/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mavServ.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mavServ.model.Offices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import mavServ.model.Customer;

/**
 *
 * @author tss
 */
@Stateless
public class OfficesStore {

    public List<Offices> findAll() {

        try (Connection con = DSManager.connection();) {

            List<Offices> result = new ArrayList<>();

            try (
                    Statement cmd = con.createStatement();
                    ResultSet res = cmd.executeQuery("select officeCode, city, phone from offices order by city");) {
                while (res.next()) {
                    result.add(new Offices(res.getString("officeCode"), res.getString("city"), res.getString("phone")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(OfficesStore.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
    }

    public List<Offices> findCity(String city) {

        try (Connection con = DSManager.connection();) {

            List<Offices> result = new ArrayList<>();

            try (
                    Statement cmd = con.createStatement();
                    ResultSet res = cmd.executeQuery("select officeCode, city, phone "
                            + "from offices where city like '" + city + "%' "
                                    + "order by city ");) {
                //System.out.println("select officeCode, city, phone from offices where city like '" + city + "%'  ");
                while (res.next()) {
                    result.add(new Offices(res.getString("officeCode"), res.getString("city"), res.getString("phone")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(OfficesStore.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }

    }

}
