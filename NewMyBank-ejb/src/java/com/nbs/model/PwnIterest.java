/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "pwn_iterest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PwnIterest.findAll", query = "SELECT p FROM PwnIterest p"),
    @NamedQuery(name = "PwnIterest.findByNPwnIntCatID", query = "SELECT p FROM PwnIterest p WHERE p.nPwnIntCatID = :nPwnIntCatID"),
    @NamedQuery(name = "PwnIterest.findByNCustCatID", query = "SELECT p FROM PwnIterest p WHERE p.nCustCatID = :nCustCatID"),
    @NamedQuery(name = "PwnIterest.findByNMinAmount", query = "SELECT p FROM PwnIterest p WHERE p.nMinAmount = :nMinAmount"),
    @NamedQuery(name = "PwnIterest.findByNMaxAmount", query = "SELECT p FROM PwnIterest p WHERE p.nMaxAmount = :nMaxAmount"),
    @NamedQuery(name = "PwnIterest.findByNInterestRate", query = "SELECT p FROM PwnIterest p WHERE p.nInterestRate = :nInterestRate")})
public class PwnIterest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnIntCatID")
    private Integer nPwnIntCatID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCustCatID")
    private int nCustCatID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinAmount")
    private BigDecimal nMinAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMaxAmount")
    private BigDecimal nMaxAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nInterestRate")
    private BigDecimal nInterestRate;

    public PwnIterest() {
    }

    public PwnIterest(Integer nPwnIntCatID) {
        this.nPwnIntCatID = nPwnIntCatID;
    }

    public PwnIterest(Integer nPwnIntCatID, int nCustCatID, BigDecimal nMinAmount, BigDecimal nMaxAmount, BigDecimal nInterestRate) {
        this.nPwnIntCatID = nPwnIntCatID;
        this.nCustCatID = nCustCatID;
        this.nMinAmount = nMinAmount;
        this.nMaxAmount = nMaxAmount;
        this.nInterestRate = nInterestRate;
    }

    public Integer getNPwnIntCatID() {
        return nPwnIntCatID;
    }

    public void setNPwnIntCatID(Integer nPwnIntCatID) {
        this.nPwnIntCatID = nPwnIntCatID;
    }

    public int getNCustCatID() {
        return nCustCatID;
    }

    public void setNCustCatID(int nCustCatID) {
        this.nCustCatID = nCustCatID;
    }

    public BigDecimal getNMinAmount() {
        return nMinAmount;
    }

    public void setNMinAmount(BigDecimal nMinAmount) {
        this.nMinAmount = nMinAmount;
    }

    public BigDecimal getNMaxAmount() {
        return nMaxAmount;
    }

    public void setNMaxAmount(BigDecimal nMaxAmount) {
        this.nMaxAmount = nMaxAmount;
    }

    public BigDecimal getNInterestRate() {
        return nInterestRate;
    }

    public void setNInterestRate(BigDecimal nInterestRate) {
        this.nInterestRate = nInterestRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnIntCatID != null ? nPwnIntCatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PwnIterest)) {
            return false;
        }
        PwnIterest other = (PwnIterest) object;
        if ((this.nPwnIntCatID == null && other.nPwnIntCatID != null) || (this.nPwnIntCatID != null && !this.nPwnIntCatID.equals(other.nPwnIntCatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.PwnIterest[ nPwnIntCatID=" + nPwnIntCatID + " ]";
    }
    
}
