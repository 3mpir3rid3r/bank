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
@Table(name = "bnk_Lon_PenaltyIntCalFor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonPenaltyIntCalFor.findAll", query = "SELECT b FROM BnkLonPenaltyIntCalFor b"),
    @NamedQuery(name = "BnkLonPenaltyIntCalFor.findByNPIntCalForID", query = "SELECT b FROM BnkLonPenaltyIntCalFor b WHERE b.nPIntCalForID = :nPIntCalForID"),
    @NamedQuery(name = "BnkLonPenaltyIntCalFor.findByCPIntCalFor", query = "SELECT b FROM BnkLonPenaltyIntCalFor b WHERE b.cPIntCalFor = :cPIntCalFor")})
public class BnkLonPenaltyIntCalFor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPIntCalForID")
    private Short nPIntCalForID;
    @Size(max = 50)
    @Column(name = "cPIntCalFor")
    private String cPIntCalFor;

    public BnkLonPenaltyIntCalFor() {
    }

    public BnkLonPenaltyIntCalFor(Short nPIntCalForID) {
        this.nPIntCalForID = nPIntCalForID;
    }

    public Short getNPIntCalForID() {
        return nPIntCalForID;
    }

    public void setNPIntCalForID(Short nPIntCalForID) {
        this.nPIntCalForID = nPIntCalForID;
    }

    public String getCPIntCalFor() {
        return cPIntCalFor;
    }

    public void setCPIntCalFor(String cPIntCalFor) {
        this.cPIntCalFor = cPIntCalFor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPIntCalForID != null ? nPIntCalForID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonPenaltyIntCalFor)) {
            return false;
        }
        BnkLonPenaltyIntCalFor other = (BnkLonPenaltyIntCalFor) object;
        if ((this.nPIntCalForID == null && other.nPIntCalForID != null) || (this.nPIntCalForID != null && !this.nPIntCalForID.equals(other.nPIntCalForID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonPenaltyIntCalFor[ nPIntCalForID=" + nPIntCalForID + " ]";
    }
    
}
