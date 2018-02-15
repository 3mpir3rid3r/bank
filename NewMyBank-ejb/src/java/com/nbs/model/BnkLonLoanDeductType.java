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
@Table(name = "bnk_Lon_LoanDeductType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanDeductType.findAll", query = "SELECT b FROM BnkLonLoanDeductType b"),
    @NamedQuery(name = "BnkLonLoanDeductType.findByNLonDeductTypeID", query = "SELECT b FROM BnkLonLoanDeductType b WHERE b.nLonDeductTypeID = :nLonDeductTypeID"),
    @NamedQuery(name = "BnkLonLoanDeductType.findByCLonDeductType", query = "SELECT b FROM BnkLonLoanDeductType b WHERE b.cLonDeductType = :cLonDeductType")})
public class BnkLonLoanDeductType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonDeductTypeID")
    private Integer nLonDeductTypeID;
    @Size(max = 50)
    @Column(name = "cLonDeductType")
    private String cLonDeductType;

    public BnkLonLoanDeductType() {
    }

    public BnkLonLoanDeductType(Integer nLonDeductTypeID) {
        this.nLonDeductTypeID = nLonDeductTypeID;
    }

    public Integer getNLonDeductTypeID() {
        return nLonDeductTypeID;
    }

    public void setNLonDeductTypeID(Integer nLonDeductTypeID) {
        this.nLonDeductTypeID = nLonDeductTypeID;
    }

    public String getCLonDeductType() {
        return cLonDeductType;
    }

    public void setCLonDeductType(String cLonDeductType) {
        this.cLonDeductType = cLonDeductType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonDeductTypeID != null ? nLonDeductTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanDeductType)) {
            return false;
        }
        BnkLonLoanDeductType other = (BnkLonLoanDeductType) object;
        if ((this.nLonDeductTypeID == null && other.nLonDeductTypeID != null) || (this.nLonDeductTypeID != null && !this.nLonDeductTypeID.equals(other.nLonDeductTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanDeductType[ nLonDeductTypeID=" + nLonDeductTypeID + " ]";
    }
    
}
