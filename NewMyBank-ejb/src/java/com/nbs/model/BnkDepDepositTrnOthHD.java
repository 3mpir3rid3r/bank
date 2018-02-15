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
@Table(name = "bnk_Dep_Deposit_TrnOth_HD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findAll", query = "SELECT b FROM BnkDepDepositTrnOthHD b"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNDepOthTrnHDID", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nDepOthTrnHDID = :nDepOthTrnHDID"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNBankBranchID", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByDTrnDate", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNTellerID", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nTellerID = :nTellerID"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNGLTrnID", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNTrnAcctLevelID4", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nTrnAcctLevelID4 = :nTrnAcctLevelID4"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNOutsiderMFID", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nOutsiderMFID = :nOutsiderMFID"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNTrnStatusID", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nTrnStatusID = :nTrnStatusID"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNJournalDTID", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByCPlusSide", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.cPlusSide = :cPlusSide"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByCReceiptNo", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.cReceiptNo = :cReceiptNo"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByCCustomerName", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.cCustomerName = :cCustomerName"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNAmount", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nAmount = :nAmount"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNDr", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByNCr", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByCRemarks", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.cRemarks = :cRemarks"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByBSav", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.bSav = :bSav"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByCAddTime", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.cAddTime = :cAddTime"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByCAddBy", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByDAddDate", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.dAddDate = :dAddDate"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByCEditBy", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.cEditBy = :cEditBy"),
    @NamedQuery(name = "BnkDepDepositTrnOthHD.findByDEditDate", query = "SELECT b FROM BnkDepDepositTrnOthHD b WHERE b.dEditDate = :dEditDate")})
public class BnkDepDepositTrnOthHD implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nDepOthTrn_HDID")
    private Long nDepOthTrnHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nBankBranchID")
    private int nBankBranchID;
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.DATE)
    private Date dTrnDate;
    @Column(name = "nTellerID")
    private Integer nTellerID;
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
    @Column(name = "nJournalDTID")
    private Integer nJournalDTID;
    @Size(max = 2)
    @Column(name = "cPlusSide")
    private String cPlusSide;
    @Size(max = 50)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "bSav")
    private boolean bSav;
    @Column(name = "cAddTime")
    @Temporal(TemporalType.TIME)
    private Date cAddTime;
    @Size(max = 20)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "dAddDate")
    @Temporal(TemporalType.DATE)
    private Date dAddDate;
    @Size(max = 20)
    @Column(name = "cEditBy")
    private String cEditBy;
    @Column(name = "dEditDate")
    @Temporal(TemporalType.DATE)
    private Date dEditDate;

    public BnkDepDepositTrnOthHD() {
    }

    public BnkDepDepositTrnOthHD(Long nDepOthTrnHDID) {
        this.nDepOthTrnHDID = nDepOthTrnHDID;
    }

    public BnkDepDepositTrnOthHD(Long nDepOthTrnHDID, int nBankBranchID, int nGLTrnID, int nTrnAcctLevelID4, int nOutsiderMFID, int nTrnStatusID, BigDecimal nAmount, BigDecimal nDr, BigDecimal nCr, boolean bSav) {
        this.nDepOthTrnHDID = nDepOthTrnHDID;
        this.nBankBranchID = nBankBranchID;
        this.nGLTrnID = nGLTrnID;
        this.nTrnAcctLevelID4 = nTrnAcctLevelID4;
        this.nOutsiderMFID = nOutsiderMFID;
        this.nTrnStatusID = nTrnStatusID;
        this.nAmount = nAmount;
        this.nDr = nDr;
        this.nCr = nCr;
        this.bSav = bSav;
    }

    public Long getNDepOthTrnHDID() {
        return nDepOthTrnHDID;
    }

    public void setNDepOthTrnHDID(Long nDepOthTrnHDID) {
        this.nDepOthTrnHDID = nDepOthTrnHDID;
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

    public Integer getNTellerID() {
        return nTellerID;
    }

    public void setNTellerID(Integer nTellerID) {
        this.nTellerID = nTellerID;
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

    public Integer getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(Integer nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
    }

    public String getCPlusSide() {
        return cPlusSide;
    }

    public void setCPlusSide(String cPlusSide) {
        this.cPlusSide = cPlusSide;
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

    public boolean getBSav() {
        return bSav;
    }

    public void setBSav(boolean bSav) {
        this.bSav = bSav;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepOthTrnHDID != null ? nDepOthTrnHDID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositTrnOthHD)) {
            return false;
        }
        BnkDepDepositTrnOthHD other = (BnkDepDepositTrnOthHD) object;
        if ((this.nDepOthTrnHDID == null && other.nDepOthTrnHDID != null) || (this.nDepOthTrnHDID != null && !this.nDepOthTrnHDID.equals(other.nDepOthTrnHDID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepDepositTrnOthHD[ nDepOthTrnHDID=" + nDepOthTrnHDID + " ]";
    }
    
}
