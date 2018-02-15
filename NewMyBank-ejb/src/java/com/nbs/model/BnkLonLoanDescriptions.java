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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "bnk_Lon_LoanDescriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanDescriptions.findAll", query = "SELECT b FROM BnkLonLoanDescriptions b"),
    @NamedQuery(name = "BnkLonLoanDescriptions.findByNLonDescriptionID", query = "SELECT b FROM BnkLonLoanDescriptions b WHERE b.nLonDescriptionID = :nLonDescriptionID"),
    @NamedQuery(name = "BnkLonLoanDescriptions.findByCLonDescription", query = "SELECT b FROM BnkLonLoanDescriptions b WHERE b.cLonDescription = :cLonDescription"),
    @NamedQuery(name = "BnkLonLoanDescriptions.findByBActive", query = "SELECT b FROM BnkLonLoanDescriptions b WHERE b.bActive = :bActive"),
    @NamedQuery(name = "BnkLonLoanDescriptions.findByCLonDescription2", query = "SELECT b FROM BnkLonLoanDescriptions b WHERE b.cLonDescription2 = :cLonDescription2")})
public class BnkLonLoanDescriptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonDescriptionID")
    private Integer nLonDescriptionID;
    @Size(max = 50)
    @Column(name = "cLonDescription")
    private String cLonDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bActive")
    private boolean bActive;
    @Size(max = 50)
    @Column(name = "cLonDescription2")
    private String cLonDescription2;

    public BnkLonLoanDescriptions() {
    }

    public BnkLonLoanDescriptions(Integer nLonDescriptionID) {
        this.nLonDescriptionID = nLonDescriptionID;
    }

    public BnkLonLoanDescriptions(Integer nLonDescriptionID, boolean bActive) {
        this.nLonDescriptionID = nLonDescriptionID;
        this.bActive = bActive;
    }

    public Integer getNLonDescriptionID() {
        return nLonDescriptionID;
    }

    public void setNLonDescriptionID(Integer nLonDescriptionID) {
        this.nLonDescriptionID = nLonDescriptionID;
    }

    public String getCLonDescription() {
        return cLonDescription;
    }

    public void setCLonDescription(String cLonDescription) {
        this.cLonDescription = cLonDescription;
    }

    public boolean getBActive() {
        return bActive;
    }

    public void setBActive(boolean bActive) {
        this.bActive = bActive;
    }

    public String getCLonDescription2() {
        return cLonDescription2;
    }

    public void setCLonDescription2(String cLonDescription2) {
        this.cLonDescription2 = cLonDescription2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonDescriptionID != null ? nLonDescriptionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanDescriptions)) {
            return false;
        }
        BnkLonLoanDescriptions other = (BnkLonLoanDescriptions) object;
        if ((this.nLonDescriptionID == null && other.nLonDescriptionID != null) || (this.nLonDescriptionID != null && !this.nLonDescriptionID.equals(other.nLonDescriptionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanDescriptions[ nLonDescriptionID=" + nLonDescriptionID + " ]";
    }
    
}
