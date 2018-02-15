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
@Table(name = "bnk_Lon_LoanFundSource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanFundSource.findAll", query = "SELECT b FROM BnkLonLoanFundSource b"),
    @NamedQuery(name = "BnkLonLoanFundSource.findByNLonFundSourceID", query = "SELECT b FROM BnkLonLoanFundSource b WHERE b.nLonFundSourceID = :nLonFundSourceID"),
    @NamedQuery(name = "BnkLonLoanFundSource.findByCLonFundSourceName", query = "SELECT b FROM BnkLonLoanFundSource b WHERE b.cLonFundSourceName = :cLonFundSourceName")})
public class BnkLonLoanFundSource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonFundSourceID")
    private Integer nLonFundSourceID;
    @Size(max = 50)
    @Column(name = "cLonFundSourceName")
    private String cLonFundSourceName;

    public BnkLonLoanFundSource() {
    }

    public BnkLonLoanFundSource(Integer nLonFundSourceID) {
        this.nLonFundSourceID = nLonFundSourceID;
    }

    public Integer getNLonFundSourceID() {
        return nLonFundSourceID;
    }

    public void setNLonFundSourceID(Integer nLonFundSourceID) {
        this.nLonFundSourceID = nLonFundSourceID;
    }

    public String getCLonFundSourceName() {
        return cLonFundSourceName;
    }

    public void setCLonFundSourceName(String cLonFundSourceName) {
        this.cLonFundSourceName = cLonFundSourceName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonFundSourceID != null ? nLonFundSourceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanFundSource)) {
            return false;
        }
        BnkLonLoanFundSource other = (BnkLonLoanFundSource) object;
        if ((this.nLonFundSourceID == null && other.nLonFundSourceID != null) || (this.nLonFundSourceID != null && !this.nLonFundSourceID.equals(other.nLonFundSourceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanFundSource[ nLonFundSourceID=" + nLonFundSourceID + " ]";
    }
    
}
