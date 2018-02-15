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
@Table(name = "bnk_Dep_Int_PayBy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepIntPayBy.findAll", query = "SELECT b FROM BnkDepIntPayBy b"),
    @NamedQuery(name = "BnkDepIntPayBy.findByNIntPayID", query = "SELECT b FROM BnkDepIntPayBy b WHERE b.nIntPayID = :nIntPayID"),
    @NamedQuery(name = "BnkDepIntPayBy.findByCIntPay", query = "SELECT b FROM BnkDepIntPayBy b WHERE b.cIntPay = :cIntPay")})
public class BnkDepIntPayBy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nIntPayID")
    private Integer nIntPayID;
    @Size(max = 100)
    @Column(name = "cIntPay")
    private String cIntPay;

    public BnkDepIntPayBy() {
    }

    public BnkDepIntPayBy(Integer nIntPayID) {
        this.nIntPayID = nIntPayID;
    }

    public Integer getNIntPayID() {
        return nIntPayID;
    }

    public void setNIntPayID(Integer nIntPayID) {
        this.nIntPayID = nIntPayID;
    }

    public String getCIntPay() {
        return cIntPay;
    }

    public void setCIntPay(String cIntPay) {
        this.cIntPay = cIntPay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIntPayID != null ? nIntPayID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepIntPayBy)) {
            return false;
        }
        BnkDepIntPayBy other = (BnkDepIntPayBy) object;
        if ((this.nIntPayID == null && other.nIntPayID != null) || (this.nIntPayID != null && !this.nIntPayID.equals(other.nIntPayID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepIntPayBy[ nIntPayID=" + nIntPayID + " ]";
    }
    
}
