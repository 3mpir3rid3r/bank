/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "bnk_Dep_Deposit_Holders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDepositHolders.findAll", query = "SELECT b FROM BnkDepDepositHolders b"),
    @NamedQuery(name = "BnkDepDepositHolders.findByNDepHldID", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.nDepHldID = :nDepHldID"),
    @NamedQuery(name = "BnkDepDepositHolders.findByNDepMFID", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.nDepMFID = :nDepMFID"),
    @NamedQuery(name = "BnkDepDepositHolders.findByNCustomerID", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.nCustomerID = :nCustomerID"),
    @NamedQuery(name = "BnkDepDepositHolders.findByNRelationShipID", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.nRelationShipID = :nRelationShipID"),
    @NamedQuery(name = "BnkDepDepositHolders.findByBSignature", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.bSignature = :bSignature"),
    @NamedQuery(name = "BnkDepDepositHolders.findByCRemarks", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.cRemarks = :cRemarks"),
    @NamedQuery(name = "BnkDepDepositHolders.findByCAddUser", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.cAddUser = :cAddUser"),
    @NamedQuery(name = "BnkDepDepositHolders.findByDAddDate", query = "SELECT b FROM BnkDepDepositHolders b WHERE b.dAddDate = :dAddDate")})
public class BnkDepDepositHolders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nDepHldID")
    private Long nDepHldID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDepMFID")
    private long nDepMFID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCustomerID")
    private int nCustomerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nRelationShipID")
    private int nRelationShipID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bSignature")
    private boolean bSignature;
    @Size(max = 150)
    @Column(name = "cRemarks")
    private String cRemarks;
    @Size(max = 50)
    @Column(name = "cAddUser")
    private String cAddUser;
    @Column(name = "dAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dAddDate;

    public BnkDepDepositHolders() {
    }

    public BnkDepDepositHolders(Long nDepHldID) {
        this.nDepHldID = nDepHldID;
    }

    public BnkDepDepositHolders(Long nDepHldID, long nDepMFID, int nCustomerID, int nRelationShipID, boolean bSignature) {
        this.nDepHldID = nDepHldID;
        this.nDepMFID = nDepMFID;
        this.nCustomerID = nCustomerID;
        this.nRelationShipID = nRelationShipID;
        this.bSignature = bSignature;
    }

    public Long getNDepHldID() {
        return nDepHldID;
    }

    public void setNDepHldID(Long nDepHldID) {
        this.nDepHldID = nDepHldID;
    }

    public long getNDepMFID() {
        return nDepMFID;
    }

    public void setNDepMFID(long nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    public int getNCustomerID() {
        return nCustomerID;
    }

    public void setNCustomerID(int nCustomerID) {
        this.nCustomerID = nCustomerID;
    }

    public int getNRelationShipID() {
        return nRelationShipID;
    }

    public void setNRelationShipID(int nRelationShipID) {
        this.nRelationShipID = nRelationShipID;
    }

    public boolean getBSignature() {
        return bSignature;
    }

    public void setBSignature(boolean bSignature) {
        this.bSignature = bSignature;
    }

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public String getCAddUser() {
        return cAddUser;
    }

    public void setCAddUser(String cAddUser) {
        this.cAddUser = cAddUser;
    }

    public Date getDAddDate() {
        return dAddDate;
    }

    public void setDAddDate(Date dAddDate) {
        this.dAddDate = dAddDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepHldID != null ? nDepHldID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositHolders)) {
            return false;
        }
        BnkDepDepositHolders other = (BnkDepDepositHolders) object;
        if ((this.nDepHldID == null && other.nDepHldID != null) || (this.nDepHldID != null && !this.nDepHldID.equals(other.nDepHldID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepDepositHolders[ nDepHldID=" + nDepHldID + " ]";
    }
    
}
