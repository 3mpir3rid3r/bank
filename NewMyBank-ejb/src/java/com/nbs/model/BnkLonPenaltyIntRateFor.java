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
@Table(name = "bnk_Lon_PenaltyIntRateFor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonPenaltyIntRateFor.findAll", query = "SELECT b FROM BnkLonPenaltyIntRateFor b"),
    @NamedQuery(name = "BnkLonPenaltyIntRateFor.findByNPIntRateForID", query = "SELECT b FROM BnkLonPenaltyIntRateFor b WHERE b.nPIntRateForID = :nPIntRateForID"),
    @NamedQuery(name = "BnkLonPenaltyIntRateFor.findByCPIntRateFor", query = "SELECT b FROM BnkLonPenaltyIntRateFor b WHERE b.cPIntRateFor = :cPIntRateFor")})
public class BnkLonPenaltyIntRateFor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPIntRateForID")
    private Short nPIntRateForID;
    @Size(max = 50)
    @Column(name = "cPIntRateFor")
    private String cPIntRateFor;

    public BnkLonPenaltyIntRateFor() {
    }

    public BnkLonPenaltyIntRateFor(Short nPIntRateForID) {
        this.nPIntRateForID = nPIntRateForID;
    }

    public Short getNPIntRateForID() {
        return nPIntRateForID;
    }

    public void setNPIntRateForID(Short nPIntRateForID) {
        this.nPIntRateForID = nPIntRateForID;
    }

    public String getCPIntRateFor() {
        return cPIntRateFor;
    }

    public void setCPIntRateFor(String cPIntRateFor) {
        this.cPIntRateFor = cPIntRateFor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPIntRateForID != null ? nPIntRateForID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonPenaltyIntRateFor)) {
            return false;
        }
        BnkLonPenaltyIntRateFor other = (BnkLonPenaltyIntRateFor) object;
        if ((this.nPIntRateForID == null && other.nPIntRateForID != null) || (this.nPIntRateForID != null && !this.nPIntRateForID.equals(other.nPIntRateForID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonPenaltyIntRateFor[ nPIntRateForID=" + nPIntRateForID + " ]";
    }
    
}
