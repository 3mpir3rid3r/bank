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
@Table(name = "bnk_Dep_Deposit_TrnOth_DT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findAll", query = "SELECT b FROM BnkDepDepositTrnOthDT b"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNDepOthTrnDTID", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nDepOthTrnDTID = :nDepOthTrnDTID"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNDepOthTrnHDID", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nDepOthTrnHDID = :nDepOthTrnHDID"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNGLTrnID", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNDepMFID", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nDepMFID = :nDepMFID"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByDTrnDate", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNTrnStatusID", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nTrnStatusID = :nTrnStatusID"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNJournalDTID", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNPaymentVal", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nPaymentVal = :nPaymentVal"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNDr", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByNCr", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByCReceiptNo", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.cReceiptNo = :cReceiptNo"),
    @NamedQuery(name = "BnkDepDepositTrnOthDT.findByCAddBy", query = "SELECT b FROM BnkDepDepositTrnOthDT b WHERE b.cAddBy = :cAddBy")})
public class BnkDepDepositTrnOthDT implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nDepOthTrn_DTID")
    private Long nDepOthTrnDTID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDepOthTrn_HDID")
    private long nDepOthTrnHDID;
    @Column(name = "nGLTrnID")
    private Integer nGLTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDepMFID")
    private long nDepMFID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.DATE)
    private Date dTrnDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnStatusID")
    private int nTrnStatusID;
    @Column(name = "nJournalDTID")
    private Integer nJournalDTID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaymentVal")
    private BigDecimal nPaymentVal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDr")
    private BigDecimal nDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCr")
    private BigDecimal nCr;
    @Size(max = 50)
    @Column(name = "cReceiptNo")
    private String cReceiptNo;
    @Size(max = 25)
    @Column(name = "cAddBy")
    private String cAddBy;

    public BnkDepDepositTrnOthDT() {
    }

    public BnkDepDepositTrnOthDT(Long nDepOthTrnDTID) {
        this.nDepOthTrnDTID = nDepOthTrnDTID;
    }

    public BnkDepDepositTrnOthDT(Long nDepOthTrnDTID, long nDepOthTrnHDID, long nDepMFID, Date dTrnDate, int nTrnStatusID, BigDecimal nPaymentVal, BigDecimal nDr, BigDecimal nCr) {
        this.nDepOthTrnDTID = nDepOthTrnDTID;
        this.nDepOthTrnHDID = nDepOthTrnHDID;
        this.nDepMFID = nDepMFID;
        this.dTrnDate = dTrnDate;
        this.nTrnStatusID = nTrnStatusID;
        this.nPaymentVal = nPaymentVal;
        this.nDr = nDr;
        this.nCr = nCr;
    }

    public Long getNDepOthTrnDTID() {
        return nDepOthTrnDTID;
    }

    public void setNDepOthTrnDTID(Long nDepOthTrnDTID) {
        this.nDepOthTrnDTID = nDepOthTrnDTID;
    }

    public long getNDepOthTrnHDID() {
        return nDepOthTrnHDID;
    }

    public void setNDepOthTrnHDID(long nDepOthTrnHDID) {
        this.nDepOthTrnHDID = nDepOthTrnHDID;
    }

    public Integer getNGLTrnID() {
        return nGLTrnID;
    }

    public void setNGLTrnID(Integer nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
    }

    public long getNDepMFID() {
        return nDepMFID;
    }

    public void setNDepMFID(long nDepMFID) {
        this.nDepMFID = nDepMFID;
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

    public Integer getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(Integer nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
    }

    public BigDecimal getNPaymentVal() {
        return nPaymentVal;
    }

    public void setNPaymentVal(BigDecimal nPaymentVal) {
        this.nPaymentVal = nPaymentVal;
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

    public String getCReceiptNo() {
        return cReceiptNo;
    }

    public void setCReceiptNo(String cReceiptNo) {
        this.cReceiptNo = cReceiptNo;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepOthTrnDTID != null ? nDepOthTrnDTID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositTrnOthDT)) {
            return false;
        }
        BnkDepDepositTrnOthDT other = (BnkDepDepositTrnOthDT) object;
        if ((this.nDepOthTrnDTID == null && other.nDepOthTrnDTID != null) || (this.nDepOthTrnDTID != null && !this.nDepOthTrnDTID.equals(other.nDepOthTrnDTID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepDepositTrnOthDT[ nDepOthTrnDTID=" + nDepOthTrnDTID + " ]";
    }
    
}
