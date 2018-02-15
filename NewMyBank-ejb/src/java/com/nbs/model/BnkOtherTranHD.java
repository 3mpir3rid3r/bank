/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "bnk_Other_Tran_HD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkOtherTranHD.findAll", query = "SELECT b FROM BnkOtherTranHD b"),
    @NamedQuery(name = "BnkOtherTranHD.findByNOthTrnHDID", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nOthTrnHDID = :nOthTrnHDID"),
    @NamedQuery(name = "BnkOtherTranHD.findByNBankBranchID", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "BnkOtherTranHD.findByDTrnDate", query = "SELECT b FROM BnkOtherTranHD b WHERE b.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "BnkOtherTranHD.findByDDepositDate", query = "SELECT b FROM BnkOtherTranHD b WHERE b.dDepositDate = :dDepositDate"),
    @NamedQuery(name = "BnkOtherTranHD.findByNGLTrnID", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "BnkOtherTranHD.findByNTrnAcctLevelID4", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nTrnAcctLevelID4 = :nTrnAcctLevelID4"),
    @NamedQuery(name = "BnkOtherTranHD.findByNOutsiderMFID", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nOutsiderMFID = :nOutsiderMFID"),
    @NamedQuery(name = "BnkOtherTranHD.findByNTrnStatusID", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nTrnStatusID = :nTrnStatusID"),
    @NamedQuery(name = "BnkOtherTranHD.findByCReceiptNo", query = "SELECT b FROM BnkOtherTranHD b WHERE b.cReceiptNo = :cReceiptNo"),
    @NamedQuery(name = "BnkOtherTranHD.findByCCustomerName", query = "SELECT b FROM BnkOtherTranHD b WHERE b.cCustomerName = :cCustomerName"),
    @NamedQuery(name = "BnkOtherTranHD.findByNAmount", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nAmount = :nAmount"),
    @NamedQuery(name = "BnkOtherTranHD.findByNDr", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkOtherTranHD.findByNCr", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkOtherTranHD.findByCRemarks", query = "SELECT b FROM BnkOtherTranHD b WHERE b.cRemarks = :cRemarks"),
    @NamedQuery(name = "BnkOtherTranHD.findByCAddTime", query = "SELECT b FROM BnkOtherTranHD b WHERE b.cAddTime = :cAddTime"),
    @NamedQuery(name = "BnkOtherTranHD.findByCAddBy", query = "SELECT b FROM BnkOtherTranHD b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkOtherTranHD.findByDAddDate", query = "SELECT b FROM BnkOtherTranHD b WHERE b.dAddDate = :dAddDate"),
    @NamedQuery(name = "BnkOtherTranHD.findByCEditBy", query = "SELECT b FROM BnkOtherTranHD b WHERE b.cEditBy = :cEditBy"),
    @NamedQuery(name = "BnkOtherTranHD.findByDEditDate", query = "SELECT b FROM BnkOtherTranHD b WHERE b.dEditDate = :dEditDate"),
    @NamedQuery(name = "BnkOtherTranHD.findByCChequeNo", query = "SELECT b FROM BnkOtherTranHD b WHERE b.cChequeNo = :cChequeNo"),
    @NamedQuery(name = "BnkOtherTranHD.findByDChequeDate", query = "SELECT b FROM BnkOtherTranHD b WHERE b.dChequeDate = :dChequeDate"),
    @NamedQuery(name = "BnkOtherTranHD.findByNJournalHDID", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nJournalHDID = :nJournalHDID"),
    @NamedQuery(name = "BnkOtherTranHD.findByNTellerID", query = "SELECT b FROM BnkOtherTranHD b WHERE b.nTellerID = :nTellerID")})
public class BnkOtherTranHD implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nOthTrnHDID")
    private Long nOthTrnHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nBankBranchID")
    private int nBankBranchID;
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.DATE)
    private Date dTrnDate;
    @Column(name = "dDepositDate")
    @Temporal(TemporalType.DATE)
    private Date dDepositDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nGLTrnID")
    private int nGLTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnAcctLevelID4")
    private int nTrnAcctLevelID4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nOutsiderMFID")
    private int nOutsiderMFID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnStatusID")
    private int nTrnStatusID;
    @Size(max = 100)
    @Column(name = "cReceiptNo")
    private String cReceiptNo;
    @Size(max = 100)
    @Column(name = "cCustomerName")
    private String cCustomerName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAmount")
    private BigDecimal nAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDr")
    private BigDecimal nDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCr")
    private BigDecimal nCr;
    @Size(max = 200)
    @Column(name = "cRemarks")
    private String cRemarks;
    @Column(name = "cAddTime")
    @Temporal(TemporalType.TIME)
    private Date cAddTime;
    @Size(max = 20)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "dAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dAddDate;
    @Size(max = 20)
    @Column(name = "cEditBy")
    private String cEditBy;
    @Column(name = "dEditDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dEditDate;
    @Size(max = 20)
    @Column(name = "cChequeNo")
    private String cChequeNo;
    @Column(name = "dChequeDate")
    @Temporal(TemporalType.DATE)
    private Date dChequeDate;
    @Column(name = "nJournalHDID")
    private BigInteger nJournalHDID;
    @Column(name = "nTellerID")
    private Integer nTellerID;

    public BnkOtherTranHD() {
    }

    public BnkOtherTranHD(Long nOthTrnHDID) {
        this.nOthTrnHDID = nOthTrnHDID;
    }

    public BnkOtherTranHD(Long nOthTrnHDID, int nBankBranchID, int nGLTrnID, int nTrnAcctLevelID4, int nOutsiderMFID, int nTrnStatusID, BigDecimal nAmount, BigDecimal nDr, BigDecimal nCr) {
        this.nOthTrnHDID = nOthTrnHDID;
        this.nBankBranchID = nBankBranchID;
        this.nGLTrnID = nGLTrnID;
        this.nTrnAcctLevelID4 = nTrnAcctLevelID4;
        this.nOutsiderMFID = nOutsiderMFID;
        this.nTrnStatusID = nTrnStatusID;
        this.nAmount = nAmount;
        this.nDr = nDr;
        this.nCr = nCr;
    }

    public Long getNOthTrnHDID() {
        return nOthTrnHDID;
    }

    public void setNOthTrnHDID(Long nOthTrnHDID) {
        this.nOthTrnHDID = nOthTrnHDID;
    }

    public int getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(int nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public Date getDTrnDate() {
        return dTrnDate;
    }

    public void setDTrnDate(Date dTrnDate) {
        this.dTrnDate = dTrnDate;
    }

    public Date getDDepositDate() {
        return dDepositDate;
    }

    public void setDDepositDate(Date dDepositDate) {
        this.dDepositDate = dDepositDate;
    }

    public int getNGLTrnID() {
        return nGLTrnID;
    }

    public void setNGLTrnID(int nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
    }

    public int getNTrnAcctLevelID4() {
        return nTrnAcctLevelID4;
    }

    public void setNTrnAcctLevelID4(int nTrnAcctLevelID4) {
        this.nTrnAcctLevelID4 = nTrnAcctLevelID4;
    }

    public int getNOutsiderMFID() {
        return nOutsiderMFID;
    }

    public void setNOutsiderMFID(int nOutsiderMFID) {
        this.nOutsiderMFID = nOutsiderMFID;
    }

    public int getNTrnStatusID() {
        return nTrnStatusID;
    }

    public void setNTrnStatusID(int nTrnStatusID) {
        this.nTrnStatusID = nTrnStatusID;
    }

    public String getCReceiptNo() {
        return cReceiptNo;
    }

    public void setCReceiptNo(String cReceiptNo) {
        this.cReceiptNo = cReceiptNo;
    }

    public String getCCustomerName() {
        return cCustomerName;
    }

    public void setCCustomerName(String cCustomerName) {
        this.cCustomerName = cCustomerName;
    }

    public BigDecimal getNAmount() {
        return nAmount;
    }

    public void setNAmount(BigDecimal nAmount) {
        this.nAmount = nAmount;
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

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public Date getCAddTime() {
        return cAddTime;
    }

    public void setCAddTime(Date cAddTime) {
        this.cAddTime = cAddTime;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public Date getDAddDate() {
        return dAddDate;
    }

    public void setDAddDate(Date dAddDate) {
        this.dAddDate = dAddDate;
    }

    public String getCEditBy() {
        return cEditBy;
    }

    public void setCEditBy(String cEditBy) {
        this.cEditBy = cEditBy;
    }

    public Date getDEditDate() {
        return dEditDate;
    }

    public void setDEditDate(Date dEditDate) {
        this.dEditDate = dEditDate;
    }

    public String getCChequeNo() {
        return cChequeNo;
    }

    public void setCChequeNo(String cChequeNo) {
        this.cChequeNo = cChequeNo;
    }

    public Date getDChequeDate() {
        return dChequeDate;
    }

    public void setDChequeDate(Date dChequeDate) {
        this.dChequeDate = dChequeDate;
    }

    public BigInteger getNJournalHDID() {
        return nJournalHDID;
    }

    public void setNJournalHDID(BigInteger nJournalHDID) {
        this.nJournalHDID = nJournalHDID;
    }

    public Integer getNTellerID() {
        return nTellerID;
    }

    public void setNTellerID(Integer nTellerID) {
        this.nTellerID = nTellerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nOthTrnHDID != null ? nOthTrnHDID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkOtherTranHD)) {
            return false;
        }
        BnkOtherTranHD other = (BnkOtherTranHD) object;
        if ((this.nOthTrnHDID == null && other.nOthTrnHDID != null) || (this.nOthTrnHDID != null && !this.nOthTrnHDID.equals(other.nOthTrnHDID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkOtherTranHD[ nOthTrnHDID=" + nOthTrnHDID + " ]";
    }
    
}
