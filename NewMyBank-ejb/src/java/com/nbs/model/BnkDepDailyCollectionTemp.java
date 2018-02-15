/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bnk_Dep_DailyCollection_Temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findAll", query = "SELECT b FROM BnkDepDailyCollectionTemp b"),
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findByNTempDailyID", query = "SELECT b FROM BnkDepDailyCollectionTemp b WHERE b.nTempDailyID = :nTempDailyID"),
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findByDTrnDate", query = "SELECT b FROM BnkDepDailyCollectionTemp b WHERE b.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findByNTrnStatusID", query = "SELECT b FROM BnkDepDailyCollectionTemp b WHERE b.nTrnStatusID = :nTrnStatusID"),
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findByNDr", query = "SELECT b FROM BnkDepDailyCollectionTemp b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findByNCr", query = "SELECT b FROM BnkDepDailyCollectionTemp b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findByCAddBy", query = "SELECT b FROM BnkDepDailyCollectionTemp b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkDepDailyCollectionTemp.findByCReceiptNo", query = "SELECT b FROM BnkDepDailyCollectionTemp b WHERE b.cReceiptNo = :cReceiptNo")})
public class BnkDepDailyCollectionTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nTempDailyID")
    private Long nTempDailyID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dTrnDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnStatusID")
    private int nTrnStatusID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDr")
    private BigDecimal nDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCr")
    private BigDecimal nCr;
    @Size(max = 25)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Size(max = 50)
    @Column(name = "cReceiptNo")
    private String cReceiptNo;
    @JoinColumn(name = "nDepMFID", referencedColumnName = "nDepMFID")
    @ManyToOne(optional = false)
    private BnkDepDepositMaster nDepMFID;

    public BnkDepDailyCollectionTemp() {
    }

    public BnkDepDailyCollectionTemp(Long nTempDailyID) {
        this.nTempDailyID = nTempDailyID;
    }

    public BnkDepDailyCollectionTemp(Long nTempDailyID, Date dTrnDate, int nTrnStatusID, BigDecimal nDr, BigDecimal nCr) {
        this.nTempDailyID = nTempDailyID;
        this.dTrnDate = dTrnDate;
        this.nTrnStatusID = nTrnStatusID;
        this.nDr = nDr;
        this.nCr = nCr;
    }

    public Long getNTempDailyID() {
        return nTempDailyID;
    }

    public void setNTempDailyID(Long nTempDailyID) {
        this.nTempDailyID = nTempDailyID;
    }

    public Date getDTrnDate() {
        return dTrnDate;
    }

    public void setDTrnDate(Date dTrnDate) {
        this.dTrnDate = dTrnDate;
    }

    public int getNTrnStatusID() {
        return nTrnStatusID;
    }

    public void setNTrnStatusID(int nTrnStatusID) {
        this.nTrnStatusID = nTrnStatusID;
    }

    public BigDecimal getNDr() {
        return nDr;
    }

    public void setNDr(BigDecimal nDr) {
        this.nDr = nDr;
    }

    public BigDecimal getNCr() {
        return nCr;
    }

    public void setNCr(BigDecimal nCr) {
        this.nCr = nCr;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public String getCReceiptNo() {
        return cReceiptNo;
    }

    public void setCReceiptNo(String cReceiptNo) {
        this.cReceiptNo = cReceiptNo;
    }

    public BnkDepDepositMaster getNDepMFID() {
        return nDepMFID;
    }

    public void setNDepMFID(BnkDepDepositMaster nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nTempDailyID != null ? nTempDailyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDailyCollectionTemp)) {
            return false;
        }
        BnkDepDailyCollectionTemp other = (BnkDepDailyCollectionTemp) object;
        if ((this.nTempDailyID == null && other.nTempDailyID != null) || (this.nTempDailyID != null && !this.nTempDailyID.equals(other.nTempDailyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepDailyCollectionTemp[ nTempDailyID=" + nTempDailyID + " ]";
    }
    
}
