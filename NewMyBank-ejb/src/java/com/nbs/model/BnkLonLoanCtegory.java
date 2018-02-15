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
@Table(name = "bnk_Lon_LoanCtegory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanCtegory.findAll", query = "SELECT b FROM BnkLonLoanCtegory b"),
    @NamedQuery(name = "BnkLonLoanCtegory.findByNLonCatID", query = "SELECT b FROM BnkLonLoanCtegory b WHERE b.nLonCatID = :nLonCatID"),
    @NamedQuery(name = "BnkLonLoanCtegory.findByCLonCategory", query = "SELECT b FROM BnkLonLoanCtegory b WHERE b.cLonCategory = :cLonCategory")})
public class BnkLonLoanCtegory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonCatID")
    private Integer nLonCatID;
    @Size(max = 50)
    @Column(name = "cLonCategory")
    private String cLonCategory;

    public BnkLonLoanCtegory() {
    }

    public BnkLonLoanCtegory(Integer nLonCatID) {
        this.nLonCatID = nLonCatID;
    }

    public Integer getNLonCatID() {
        return nLonCatID;
    }

    public void setNLonCatID(Integer nLonCatID) {
        this.nLonCatID = nLonCatID;
    }

    public String getCLonCategory() {
        return cLonCategory;
    }

    public void setCLonCategory(String cLonCategory) {
        this.cLonCategory = cLonCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonCatID != null ? nLonCatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanCtegory)) {
            return false;
        }
        BnkLonLoanCtegory other = (BnkLonLoanCtegory) object;
        if ((this.nLonCatID == null && other.nLonCatID != null) || (this.nLonCatID != null && !this.nLonCatID.equals(other.nLonCatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanCtegory[ nLonCatID=" + nLonCatID + " ]";
    }
    
}
