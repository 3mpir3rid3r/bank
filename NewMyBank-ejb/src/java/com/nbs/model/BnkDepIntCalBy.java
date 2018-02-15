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
@Table(name = "bnk_Dep_Int_CalBy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepIntCalBy.findAll", query = "SELECT b FROM BnkDepIntCalBy b"),
    @NamedQuery(name = "BnkDepIntCalBy.findByNIntCalID", query = "SELECT b FROM BnkDepIntCalBy b WHERE b.nIntCalID = :nIntCalID"),
    @NamedQuery(name = "BnkDepIntCalBy.findByCIntCal", query = "SELECT b FROM BnkDepIntCalBy b WHERE b.cIntCal = :cIntCal")})
public class BnkDepIntCalBy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nIntCalID")
    private Integer nIntCalID;
    @Size(max = 100)
    @Column(name = "cIntCal")
    private String cIntCal;

    public BnkDepIntCalBy() {
    }

    public BnkDepIntCalBy(Integer nIntCalID) {
        this.nIntCalID = nIntCalID;
    }

    public Integer getNIntCalID() {
        return nIntCalID;
    }

    public void setNIntCalID(Integer nIntCalID) {
        this.nIntCalID = nIntCalID;
    }

    public String getCIntCal() {
        return cIntCal;
    }

    public void setCIntCal(String cIntCal) {
        this.cIntCal = cIntCal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIntCalID != null ? nIntCalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepIntCalBy)) {
            return false;
        }
        BnkDepIntCalBy other = (BnkDepIntCalBy) object;
        if ((this.nIntCalID == null && other.nIntCalID != null) || (this.nIntCalID != null && !this.nIntCalID.equals(other.nIntCalID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepIntCalBy[ nIntCalID=" + nIntCalID + " ]";
    }
    
}
