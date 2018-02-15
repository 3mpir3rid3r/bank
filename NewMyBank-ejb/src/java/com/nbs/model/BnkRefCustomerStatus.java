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
@Table(name = "bnk_RefCustomerStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkRefCustomerStatus.findAll", query = "SELECT b FROM BnkRefCustomerStatus b"),
    @NamedQuery(name = "BnkRefCustomerStatus.findByNCustomerStatusID", query = "SELECT b FROM BnkRefCustomerStatus b WHERE b.nCustomerStatusID = :nCustomerStatusID"),
    @NamedQuery(name = "BnkRefCustomerStatus.findByCCustomerStatus", query = "SELECT b FROM BnkRefCustomerStatus b WHERE b.cCustomerStatus = :cCustomerStatus")})
public class BnkRefCustomerStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nCustomerStatusID")
    private Integer nCustomerStatusID;
    @Size(max = 45)
    @Column(name = "cCustomerStatus")
    private String cCustomerStatus;

    public BnkRefCustomerStatus() {
    }

    public BnkRefCustomerStatus(Integer nCustomerStatusID) {
        this.nCustomerStatusID = nCustomerStatusID;
    }

    public Integer getNCustomerStatusID() {
        return nCustomerStatusID;
    }

    public void setNCustomerStatusID(Integer nCustomerStatusID) {
        this.nCustomerStatusID = nCustomerStatusID;
    }

    public String getCCustomerStatus() {
        return cCustomerStatus;
    }

    public void setCCustomerStatus(String cCustomerStatus) {
        this.cCustomerStatus = cCustomerStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nCustomerStatusID != null ? nCustomerStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkRefCustomerStatus)) {
            return false;
        }
        BnkRefCustomerStatus other = (BnkRefCustomerStatus) object;
        if ((this.nCustomerStatusID == null && other.nCustomerStatusID != null) || (this.nCustomerStatusID != null && !this.nCustomerStatusID.equals(other.nCustomerStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkRefCustomerStatus[ nCustomerStatusID=" + nCustomerStatusID + " ]";
    }
    
}
