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
@Table(name = "bnk_Lon_InterestMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonInterestMethod.findAll", query = "SELECT b FROM BnkLonInterestMethod b"),
    @NamedQuery(name = "BnkLonInterestMethod.findByNLonInterestMethodID", query = "SELECT b FROM BnkLonInterestMethod b WHERE b.nLonInterestMethodID = :nLonInterestMethodID"),
    @NamedQuery(name = "BnkLonInterestMethod.findByCLoanInterstMethod", query = "SELECT b FROM BnkLonInterestMethod b WHERE b.cLoanInterstMethod = :cLoanInterstMethod")})
public class BnkLonInterestMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonInterestMethodID")
    private Short nLonInterestMethodID;
    @Size(max = 100)
    @Column(name = "cLoanInterstMethod")
    private String cLoanInterstMethod;

    public BnkLonInterestMethod() {
    }

    public BnkLonInterestMethod(Short nLonInterestMethodID) {
        this.nLonInterestMethodID = nLonInterestMethodID;
    }

    public Short getNLonInterestMethodID() {
        return nLonInterestMethodID;
    }

    public void setNLonInterestMethodID(Short nLonInterestMethodID) {
        this.nLonInterestMethodID = nLonInterestMethodID;
    }

    public String getCLoanInterstMethod() {
        return cLoanInterstMethod;
    }

    public void setCLoanInterstMethod(String cLoanInterstMethod) {
        this.cLoanInterstMethod = cLoanInterstMethod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonInterestMethodID != null ? nLonInterestMethodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonInterestMethod)) {
            return false;
        }
        BnkLonInterestMethod other = (BnkLonInterestMethod) object;
        if ((this.nLonInterestMethodID == null && other.nLonInterestMethodID != null) || (this.nLonInterestMethodID != null && !this.nLonInterestMethodID.equals(other.nLonInterestMethodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonInterestMethod[ nLonInterestMethodID=" + nLonInterestMethodID + " ]";
    }
    
}
