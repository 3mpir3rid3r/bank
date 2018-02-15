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
@Table(name = "bnk_Lon_LoanStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanStatus.findAll", query = "SELECT b FROM BnkLonLoanStatus b"),
    @NamedQuery(name = "BnkLonLoanStatus.findByNLonStatusID", query = "SELECT b FROM BnkLonLoanStatus b WHERE b.nLonStatusID = :nLonStatusID"),
    @NamedQuery(name = "BnkLonLoanStatus.findByCLonStatus", query = "SELECT b FROM BnkLonLoanStatus b WHERE b.cLonStatus = :cLonStatus")})
public class BnkLonLoanStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonStatusID")
    private Integer nLonStatusID;
    @Size(max = 50)
    @Column(name = "cLonStatus")
    private String cLonStatus;

    public BnkLonLoanStatus() {
    }

    public BnkLonLoanStatus(Integer nLonStatusID) {
        this.nLonStatusID = nLonStatusID;
    }

    public Integer getNLonStatusID() {
        return nLonStatusID;
    }

    public void setNLonStatusID(Integer nLonStatusID) {
        this.nLonStatusID = nLonStatusID;
    }

    public String getCLonStatus() {
        return cLonStatus;
    }

    public void setCLonStatus(String cLonStatus) {
        this.cLonStatus = cLonStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonStatusID != null ? nLonStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanStatus)) {
            return false;
        }
        BnkLonLoanStatus other = (BnkLonLoanStatus) object;
        if ((this.nLonStatusID == null && other.nLonStatusID != null) || (this.nLonStatusID != null && !this.nLonStatusID.equals(other.nLonStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanStatus[ nLonStatusID=" + nLonStatusID + " ]";
    }
    
}
