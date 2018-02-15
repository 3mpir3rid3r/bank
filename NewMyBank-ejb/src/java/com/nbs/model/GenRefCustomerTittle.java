/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_RefCustomerTittle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenRefCustomerTittle.findAll", query = "SELECT g FROM GenRefCustomerTittle g"),
    @NamedQuery(name = "GenRefCustomerTittle.findByNTitleID", query = "SELECT g FROM GenRefCustomerTittle g WHERE g.nTitleID = :nTitleID"),
    @NamedQuery(name = "GenRefCustomerTittle.findByCTitle", query = "SELECT g FROM GenRefCustomerTittle g WHERE g.cTitle = :cTitle")})
public class GenRefCustomerTittle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nTitleID")
    private Short nTitleID;
    @Size(max = 5)
    @Column(name = "cTitle")
    private String cTitle;

    public GenRefCustomerTittle() {
    }

    public GenRefCustomerTittle(Short nTitleID) {
        this.nTitleID = nTitleID;
    }

    public Short getNTitleID() {
        return nTitleID;
    }

    public void setNTitleID(Short nTitleID) {
        this.nTitleID = nTitleID;
    }

    public String getCTitle() {
        return cTitle;
    }

    public void setCTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nTitleID != null ? nTitleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenRefCustomerTittle)) {
            return false;
        }
        GenRefCustomerTittle other = (GenRefCustomerTittle) object;
        if ((this.nTitleID == null && other.nTitleID != null) || (this.nTitleID != null && !this.nTitleID.equals(other.nTitleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenRefCustomerTittle[ nTitleID=" + nTitleID + " ]";
    }
    
}
