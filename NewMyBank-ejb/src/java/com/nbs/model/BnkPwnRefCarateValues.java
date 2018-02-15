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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "bnk_Pwn_RefCarate_Values")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnRefCarateValues.findAll", query = "SELECT b FROM BnkPwnRefCarateValues b"),
    @NamedQuery(name = "BnkPwnRefCarateValues.findByNPwnCaratValID", query = "SELECT b FROM BnkPwnRefCarateValues b WHERE b.nPwnCaratValID = :nPwnCaratValID"),
    @NamedQuery(name = "BnkPwnRefCarateValues.findByCCaratType", query = "SELECT b FROM BnkPwnRefCarateValues b WHERE b.cCaratType = :cCaratType"),
    @NamedQuery(name = "BnkPwnRefCarateValues.findByNBankAmount", query = "SELECT b FROM BnkPwnRefCarateValues b WHERE b.nBankAmount = :nBankAmount"),
    @NamedQuery(name = "BnkPwnRefCarateValues.findByNMrktAmount", query = "SELECT b FROM BnkPwnRefCarateValues b WHERE b.nMrktAmount = :nMrktAmount"),
    @NamedQuery(name = "BnkPwnRefCarateValues.findByNGoldWgt", query = "SELECT b FROM BnkPwnRefCarateValues b WHERE b.nGoldWgt = :nGoldWgt")})
public class BnkPwnRefCarateValues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnCaratValID")
    private Integer nPwnCaratValID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cCaratType")
    private String cCaratType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nBankAmount")
    private BigDecimal nBankAmount;
    @Column(name = "nMrktAmount")
    private BigDecimal nMrktAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nGoldWgt")
    private BigDecimal nGoldWgt;

    public BnkPwnRefCarateValues() {
    }

    public BnkPwnRefCarateValues(Integer nPwnCaratValID) {
        this.nPwnCaratValID = nPwnCaratValID;
    }

    public BnkPwnRefCarateValues(Integer nPwnCaratValID, String cCaratType, BigDecimal nGoldWgt) {
        this.nPwnCaratValID = nPwnCaratValID;
        this.cCaratType = cCaratType;
        this.nGoldWgt = nGoldWgt;
    }

    public Integer getNPwnCaratValID() {
        return nPwnCaratValID;
    }

    public void setNPwnCaratValID(Integer nPwnCaratValID) {
        this.nPwnCaratValID = nPwnCaratValID;
    }

    public String getCCaratType() {
        return cCaratType;
    }

    public void setCCaratType(String cCaratType) {
        this.cCaratType = cCaratType;
    }

    public BigDecimal getNBankAmount() {
        return nBankAmount;
    }

    public void setNBankAmount(BigDecimal nBankAmount) {
        this.nBankAmount = nBankAmount;
    }

    public BigDecimal getNMrktAmount() {
        return nMrktAmount;
    }

    public void setNMrktAmount(BigDecimal nMrktAmount) {
        this.nMrktAmount = nMrktAmount;
    }

    public BigDecimal getNGoldWgt() {
        return nGoldWgt;
    }

    public void setNGoldWgt(BigDecimal nGoldWgt) {
        this.nGoldWgt = nGoldWgt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnCaratValID != null ? nPwnCaratValID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnRefCarateValues)) {
            return false;
        }
        BnkPwnRefCarateValues other = (BnkPwnRefCarateValues) object;
        if ((this.nPwnCaratValID == null && other.nPwnCaratValID != null) || (this.nPwnCaratValID != null && !this.nPwnCaratValID.equals(other.nPwnCaratValID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkPwnRefCarateValues[ nPwnCaratValID=" + nPwnCaratValID + " ]";
    }
    
}
