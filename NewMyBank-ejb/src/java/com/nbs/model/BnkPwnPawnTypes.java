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
@Table(name = "bnk_Pwn_PawnTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnPawnTypes.findAll", query = "SELECT b FROM BnkPwnPawnTypes b")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNPawnTypeID", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nPawnTypeID = :nPawnTypeID")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByCPawnType", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.cPawnType = :cPawnType")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByCSysCode", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.cSysCode = :cSysCode")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNIntCalMethod", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nIntCalMethod = :nIntCalMethod")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNIntRoundMethodID", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nIntRoundMethodID = :nIntRoundMethodID")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNPwnMonthsDays", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nPwnMonthsDays = :nPwnMonthsDays")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNAcctLevelID5PawnCapital", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nAcctLevelID5PawnCapital = :nAcctLevelID5PawnCapital")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNAcctLevelID5PawnInterest", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nAcctLevelID5PawnInterest = :nAcctLevelID5PawnInterest")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNAcctLevelID5PawnPostage", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nAcctLevelID5PawnPostage = :nAcctLevelID5PawnPostage")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNAcctLevelID5PawnStationary", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nAcctLevelID5PawnStationary = :nAcctLevelID5PawnStationary")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNAcctLevelID5PawnAuction", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nAcctLevelID5PawnAuction = :nAcctLevelID5PawnAuction")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNAcctLevelID5InterestFree", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nAcctLevelID5InterestFree = :nAcctLevelID5InterestFree")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNIntRate", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nIntRate = :nIntRate")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByCAddBy", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.cAddBy = :cAddBy")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNPwnAcctLevelID3", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nPwnAcctLevelID3 = :nPwnAcctLevelID3")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNIntAcctLevelID3", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nIntAcctLevelID3 = :nIntAcctLevelID3")
    , @NamedQuery(name = "BnkPwnPawnTypes.findByNAuctionAcctLevelID3", query = "SELECT b FROM BnkPwnPawnTypes b WHERE b.nAuctionAcctLevelID3 = :nAuctionAcctLevelID3")})
public class BnkPwnPawnTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPawnTypeID")
    private Integer nPawnTypeID;
    @Size(max = 50)
    @Column(name = "cPawnType")
    private String cPawnType;
    @Size(max = 3)
    @Column(name = "cSysCode")
    private String cSysCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntCalMethod")
    private int nIntCalMethod;
    @Column(name = "nIntRoundMethodID")
    private Integer nIntRoundMethodID;
    @Column(name = "nPwnMonthsDays")
    private Integer nPwnMonthsDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID5_PawnCapital")
    private int nAcctLevelID5PawnCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID5_PawnInterest")
    private int nAcctLevelID5PawnInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID5_PawnPostage")
    private int nAcctLevelID5PawnPostage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID5_PawnStationary")
    private int nAcctLevelID5PawnStationary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID5_PawnAuction")
    private int nAcctLevelID5PawnAuction;
    @Column(name = "nAcctLevelID5_InterestFree")
    private Integer nAcctLevelID5InterestFree;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntRate")
    private BigDecimal nIntRate;
    @Size(max = 15)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnAcctLevelID3")
    private int nPwnAcctLevelID3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntAcctLevelID3")
    private int nIntAcctLevelID3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAuctionAcctLevelID3")
    private int nAuctionAcctLevelID3;

    public BnkPwnPawnTypes() {
    }

    public BnkPwnPawnTypes(Integer nPawnTypeID) {
        this.nPawnTypeID = nPawnTypeID;
    }

    public BnkPwnPawnTypes(Integer nPawnTypeID, int nIntCalMethod, int nAcctLevelID5PawnCapital, int nAcctLevelID5PawnInterest, int nAcctLevelID5PawnPostage, int nAcctLevelID5PawnStationary, int nAcctLevelID5PawnAuction, BigDecimal nIntRate, int nPwnAcctLevelID3, int nIntAcctLevelID3, int nAuctionAcctLevelID3) {
        this.nPawnTypeID = nPawnTypeID;
        this.nIntCalMethod = nIntCalMethod;
        this.nAcctLevelID5PawnCapital = nAcctLevelID5PawnCapital;
        this.nAcctLevelID5PawnInterest = nAcctLevelID5PawnInterest;
        this.nAcctLevelID5PawnPostage = nAcctLevelID5PawnPostage;
        this.nAcctLevelID5PawnStationary = nAcctLevelID5PawnStationary;
        this.nAcctLevelID5PawnAuction = nAcctLevelID5PawnAuction;
        this.nIntRate = nIntRate;
        this.nPwnAcctLevelID3 = nPwnAcctLevelID3;
        this.nIntAcctLevelID3 = nIntAcctLevelID3;
        this.nAuctionAcctLevelID3 = nAuctionAcctLevelID3;
    }

    public Integer getNPawnTypeID() {
        return nPawnTypeID;
    }

    public void setNPawnTypeID(Integer nPawnTypeID) {
        this.nPawnTypeID = nPawnTypeID;
    }

    public String getCPawnType() {
        return cPawnType;
    }

    public void setCPawnType(String cPawnType) {
        this.cPawnType = cPawnType;
    }

    public String getCSysCode() {
        return cSysCode;
    }

    public void setCSysCode(String cSysCode) {
        this.cSysCode = cSysCode;
    }

    public int getNIntCalMethod() {
        return nIntCalMethod;
    }

    public void setNIntCalMethod(int nIntCalMethod) {
        this.nIntCalMethod = nIntCalMethod;
    }

    public Integer getNIntRoundMethodID() {
        return nIntRoundMethodID;
    }

    public void setNIntRoundMethodID(Integer nIntRoundMethodID) {
        this.nIntRoundMethodID = nIntRoundMethodID;
    }

    public Integer getNPwnMonthsDays() {
        return nPwnMonthsDays;
    }

    public void setNPwnMonthsDays(Integer nPwnMonthsDays) {
        this.nPwnMonthsDays = nPwnMonthsDays;
    }

    public int getNAcctLevelID5PawnCapital() {
        return nAcctLevelID5PawnCapital;
    }

    public void setNAcctLevelID5PawnCapital(int nAcctLevelID5PawnCapital) {
        this.nAcctLevelID5PawnCapital = nAcctLevelID5PawnCapital;
    }

    public int getNAcctLevelID5PawnInterest() {
        return nAcctLevelID5PawnInterest;
    }

    public void setNAcctLevelID5PawnInterest(int nAcctLevelID5PawnInterest) {
        this.nAcctLevelID5PawnInterest = nAcctLevelID5PawnInterest;
    }

    public int getNAcctLevelID5PawnPostage() {
        return nAcctLevelID5PawnPostage;
    }

    public void setNAcctLevelID5PawnPostage(int nAcctLevelID5PawnPostage) {
        this.nAcctLevelID5PawnPostage = nAcctLevelID5PawnPostage;
    }

    public int getNAcctLevelID5PawnStationary() {
        return nAcctLevelID5PawnStationary;
    }

    public void setNAcctLevelID5PawnStationary(int nAcctLevelID5PawnStationary) {
        this.nAcctLevelID5PawnStationary = nAcctLevelID5PawnStationary;
    }

    public int getNAcctLevelID5PawnAuction() {
        return nAcctLevelID5PawnAuction;
    }

    public void setNAcctLevelID5PawnAuction(int nAcctLevelID5PawnAuction) {
        this.nAcctLevelID5PawnAuction = nAcctLevelID5PawnAuction;
    }

    public Integer getNAcctLevelID5InterestFree() {
        return nAcctLevelID5InterestFree;
    }

    public void setNAcctLevelID5InterestFree(Integer nAcctLevelID5InterestFree) {
        this.nAcctLevelID5InterestFree = nAcctLevelID5InterestFree;
    }

    public BigDecimal getNIntRate() {
        return nIntRate;
    }

    public void setNIntRate(BigDecimal nIntRate) {
        this.nIntRate = nIntRate;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public int getNPwnAcctLevelID3() {
        return nPwnAcctLevelID3;
    }

    public void setNPwnAcctLevelID3(int nPwnAcctLevelID3) {
        this.nPwnAcctLevelID3 = nPwnAcctLevelID3;
    }

    public int getNIntAcctLevelID3() {
        return nIntAcctLevelID3;
    }

    public void setNIntAcctLevelID3(int nIntAcctLevelID3) {
        this.nIntAcctLevelID3 = nIntAcctLevelID3;
    }

    public int getNAuctionAcctLevelID3() {
        return nAuctionAcctLevelID3;
    }

    public void setNAuctionAcctLevelID3(int nAuctionAcctLevelID3) {
        this.nAuctionAcctLevelID3 = nAuctionAcctLevelID3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPawnTypeID != null ? nPawnTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnPawnTypes)) {
            return false;
        }
        BnkPwnPawnTypes other = (BnkPwnPawnTypes) object;
        if ((this.nPawnTypeID == null && other.nPawnTypeID != null) || (this.nPawnTypeID != null && !this.nPawnTypeID.equals(other.nPawnTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.aaaa.BnkPwnPawnTypes[ nPawnTypeID=" + nPawnTypeID + " ]";
    }
    
}
