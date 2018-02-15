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
@Table(name = "bnk_Dep_DepositCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDepositCategory.findAll", query = "SELECT b FROM BnkDepDepositCategory b"),
    @NamedQuery(name = "BnkDepDepositCategory.findByNDepCatID", query = "SELECT b FROM BnkDepDepositCategory b WHERE b.nDepCatID = :nDepCatID"),
    @NamedQuery(name = "BnkDepDepositCategory.findByCDepCategory", query = "SELECT b FROM BnkDepDepositCategory b WHERE b.cDepCategory = :cDepCategory")})
public class BnkDepDepositCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nDepCatID")
    private Short nDepCatID;
    @Size(max = 50)
    @Column(name = "cDepCategory")
    private String cDepCategory;

    public BnkDepDepositCategory() {
    }

    public BnkDepDepositCategory(Short nDepCatID) {
        this.nDepCatID = nDepCatID;
    }

    public Short getNDepCatID() {
        return nDepCatID;
    }

    public void setNDepCatID(Short nDepCatID) {
        this.nDepCatID = nDepCatID;
    }

    public String getCDepCategory() {
        return cDepCategory;
    }

    public void setCDepCategory(String cDepCategory) {
        this.cDepCategory = cDepCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepCatID != null ? nDepCatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositCategory)) {
            return false;
        }
        BnkDepDepositCategory other = (BnkDepDepositCategory) object;
        if ((this.nDepCatID == null && other.nDepCatID != null) || (this.nDepCatID != null && !this.nDepCatID.equals(other.nDepCatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepDepositCategory[ nDepCatID=" + nDepCatID + " ]";
    }
    
}
