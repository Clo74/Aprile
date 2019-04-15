/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mavServ.model;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Offices {
 
    private String officeCode;
    private String city;
    private String phone;

    public Offices(String officeCode, String city, String phone) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.officeCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offices other = (Offices) obj;
        return Objects.equals(this.officeCode, other.officeCode);
    }
    
         
}

