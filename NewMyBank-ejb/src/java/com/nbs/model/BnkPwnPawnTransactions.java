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
@Table(name = "bnk_Pwn_PawnTransactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnPawnTransactions.findAll", query = "SELECT b FROM BnkPwnPawnTransactions b"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPwnTrnHDID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPwnTrnHDID = :nPwnTrnHDID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByDTrnDate", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPwnMasterID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPwnMasterID = :nPwnMasterID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNBankBranchID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNBankBranchIDTrn", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nBankBranchIDTrn = :nBankBranchIDTrn"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNTellerID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nTellerID = :nTellerID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNGLTrnID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNTrnStatusID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nTrnStatusID = :nTrnStatusID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByCReceiptNo", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.cReceiptNo = :cReceiptNo"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNJournalHDID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nJournalHDID = :nJournalHDID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNJournalDTID", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPaymentVal", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPaymentVal = :nPaymentVal"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNDr", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNCr", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNToDateCapital", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nToDateCapital = :nToDateCapital"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNToDateIntValue", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nToDateIntValue = :nToDateIntValue"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNToDateStationary", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nToDateStationary = :nToDateStationary"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNToDatePostage", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nToDatePostage = :nToDatePostage"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNToDateAuctionFee", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nToDateAuctionFee = :nToDateAuctionFee"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPaidCapital", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPaidCapital = :nPaidCapital"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPaidIntValue", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPaidIntValue = :nPaidIntValue"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPaidPostage", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPaidPostage = :nPaidPostage"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPaidStationary", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPaidStationary = :nPaidStationary"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNPaidAuction", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nPaidAuction = :nPaidAuction"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNTotRecvCapitalOld", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nTotRecvCapitalOld = :nTotRecvCapitalOld"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNTotRecvInterestOld", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nTotRecvInterestOld = :nTotRecvInterestOld"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNTotRecvStationaryOld", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nTotRecvStationaryOld = :nTotRecvStationaryOld"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNTotRecvPostageOld", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nTotRecvPostageOld = :nTotRecvPostageOld"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByNTotRecvAuctionFeeOld", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.nTotRecvAuctionFeeOld = :nTotRecvAuctionFeeOld"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByCAuthOfficer", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.cAuthOfficer = :cAuthOfficer"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByBPrint", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.bPrint = :bPrint"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByBPosted", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.bPosted = :bPosted"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByCReason", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.cReason = :cReason"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByCAddBy", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByCAddDate", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.cAddDate = :cAddDate"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByCPostedBy", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.cPostedBy = :cPostedBy"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByDPostedDate", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.dPostedDate = :dPostedDate"),
    @NamedQuery(name = "BnkPwnPawnTransactions.findByCAddTime", query = "SELECT b FROM BnkPwnPawnTransactions b WHERE b.cAddTime = :cAddTime")})
public class BnkPwnPawnTransactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnTrnHDID")
    private Long nPwnTrnHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.DATE)
    private Date dTrnDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnMasterID")
    private long nPwnMasterID;
    @Column(name = "nBankBranchID")
    private Integer nBankBranchID;
    @Column(name = "nBankBranchID_Trn")
    private Integer nBankBranchIDTrn;
    @Column(name = "nTellerID")
    private Integer nTellerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nGLTrnID")
    private int nGLTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnStatusID")
    private int nTrnStatusID;
    @Size(max = 50)
    @Column(name = "cReceiptNo")
    private String cReceiptNo;
    @Column(name = "nJournalHDID")
    private BigInteger nJournalHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalDTID")
    private long nJournalDTID;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_Capital")
    private BigDecimal nToDateCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateInt_Value")
    private BigDecimal nToDateIntValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_Stationary")
    private BigDecimal nToDateStationary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_Postage")
    private BigDecimal nToDatePostage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_AuctionFee")
    private BigDecimal nToDateAuctionFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaid_Capital")
    private BigDecimal nPaidCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaid_IntValue")
    private BigDecimal nPaidIntValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaid_Postage")
    private BigDecimal nPaidPostage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaid_Stationary")
    private BigDecimal nPaidStationary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaid_Auction")
    private BigDecimal nPaidAuction;
    @Column(name = "nTotRecv_Capital_Old")
    private BigDecimal nTotRecvCapitalOld;
    @Column(name = "nTotRecv_Interest_Old")
    private BigDecimal nTotRecvInterestOld;
    @Column(name = "nTotRecv_Stationary_Old")
    private BigDecimal nTotRecvStationaryOld;
    @Column(name = "nTotRecv_Postage_Old")
    private BigDecimal nTotRecvPostageOld;
    @Column(name = "nTotRecv_AuctionFee_Old")
    private BigDecimal nTotRecvAuctionFeeOld;
    @Size(max = 25)
    @Column(name = "cAuthOfficer")
    private String cAuthOfficer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bPrint")
    private boolean bPrint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bPosted")
    private boolean bPosted;
    @Size(max = 150)
    @Column(name = "cReason")
    private String cReason;
    @Size(max = 10)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "cAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cAddDate;
    @Size(max = 10)
    @Column(name = "cPostedBy")
    private String cPostedBy;
    @Column(name = "dPostedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dPostedDate;
    @Column(name = "cAddTime")
    @Temporal(TemporalType.TIME)
    private Date cAddTime;

    public BnkPwnPawnTransactions() {
    }

    public BnkPwnPawnTransactions(Long nPwnTrnHDID) {
        this.nPwnTrnHDID = nPwnTrnHDID;
    }

    public BnkPwnPawnTransactions(Long nPwnTrnHDID, Date dTrnDate, long nPwnMasterID, int nGLTrnID, int nTrnStatusID, long nJournalDTID, BigDecimal nPaymentVal, BigDecimal nDr, BigDecimal nCr, BigDecimal nToDateCapital, BigDecimal nToDateIntValue, BigDecimal nToDateStationary, BigDecimal nToDatePostage, BigDecimal nToDateAuctionFee, BigDecimal nPaidCapital, BigDecimal nPaidIntValue, BigDecimal nPaidPostage, BigDecimal nPaidStationary, BigDecimal nPaidAuction, boolean bPrint, boolean bPosted) {
        this.nPwnTrnHDID = nPwnTrnHDID;
        this.dTrnDate = dTrnDate;
        this.nPwnMasterID = nPwnMasterID;
        this.nGLTrnID = nGLTrnID;
        this.nTrnStatusID = nTrnStatusID;
        this.nJournalDTID = nJournalDTID;
        this.nPaymentVal = nPaymentVal;
        this.nDr = nDr;
        this.nCr = nCr;
        this.nToDateCapital = nToDateCapital;
        this.nToDateIntValue = nToDateIntValue;
        this.nToDateStationary = nToDateStationary;
        this.nToDatePostage = nToDatePostage;
        this.nToDateAuctionFee = nToDateAuctionFee;
        this.nPaidCapital = nPaidCapital;
        this.nPaidIntValue = nPaidIntValue;
        this.nPaidPostage = nPaidPostage;
        this.nPaidStationary = nPaidStationary;
        this.nPaidAuction = nPaidAuction;
        this.bPrint = bPrint;
        this.bPosted = bPosted;
    }

    public Long getNPwnTrnHDID() {
        return nPwnTrnHDID;
    }

    public void setNPwnTrnHDID(Long nPwnTrnHDID) {
        this.nPwnTrnHDID = nPwnTrnHDID;
    }

    public Date getDTrnDate() {
        return dTrnDate;
    }

    public void setDTrnDate(Date dTrnDate) {
        this.dTrnDate = dTrnDate;
    }

    public long getNPwnMasterID() {
        return nPwnMasterID;
    }

    public void setNPwnMasterID(long nPwnMasterID) {
        this.nPwnMasterID = nPwnMasterID;
    }

    public Integer getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(Integer nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public Integer getNBankBranchIDTrn() {
        return nBankBranchIDTrn;
    }

    public void setNBankBranchIDTrn(Integer nBankBranchIDTrn) {
        this.nBankBranchIDTrn = nBankBranchIDTrn;
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

    public BigInteger getNJournalHDID() {
        return nJournalHDID;
    }

    public void setNJournalHDID(BigInteger nJournalHDID) {
        this.nJournalHDID = nJournalHDID;
    }

    public long getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(long nJournalDTID) {
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

    public BigDecimal getNToDateCapital() {
        return nToDateCapital;
    }

    public void setNToDateCapital(BigDecimal nToDateCapital) {
        this.nToDateCapital = nToDateCapital;
    }

    public BigDecimal getNToDateIntValue() {
        return nToDateIntValue;
    }

    public void setNToDateIntValue(BigDecimal nToDateIntValue) {
        this.nToDateIntValue = nToDateIntValue;
    }

    public BigDecimal getNToDateStationary() {
        return nToDateStationary;
    }

    public void setNToDateStationary(BigDecimal nToDateStationary) {
        this.nToDateStationary = nToDateStationary;
    }

    public BigDecimal getNToDatePostage() {
        return nToDatePostage;
    }

    public void setNToDatePostage(BigDecimal nToDatePostage) {
        this.nToDatePostage = nToDatePostage;
    }

    public BigDecimal getNToDateAuctionFee() {
        return nToDateAuctionFee;
    }

    public void setNToDateAuctionFee(BigDecimal nToDateAuctionFee) {
        this.nToDateAuctionFee = nToDateAuctionFee;
    }

    public BigDecimal getNPaidCapital() {
        return nPaidCapital;
    }

    public void setNPaidCapital(BigDecimal nPaidCapital) {
        this.nPaidCapital = nPaidCapital;
    }

    public BigDecimal getNPaidIntValue() {
        return nPaidIntValue;
    }

    public void setNPaidIntValue(BigDecimal nPaidIntValue) {
        this.nPaidIntValue = nPaidIntValue;
    }

    public BigDecimal getNPaidPostage() {
        return nPaidPostage;
    }

    public void setNPaidPostage(BigDecimal nPaidPostage) {
        this.nPaidPostage = nPaidPostage;
    }

    public BigDecimal getNPaidStationary() {
        return nPaidStationary;
    }

    public void setNPaidStationary(BigDecimal nPaidStationary) {
        this.nPaidStationary = nPaidStationary;
    }

    public BigDecimal getNPaidAuction() {
        return nPaidAuction;
    }

    public void setNPaidAuction(BigDecimal nPaidAuction) {
        this.nPaidAuction = nPaidAuction;
    }

    public BigDecimal getNTotRecvCapitalOld() {
        return nTotRecvCapitalOld;
    }

    public void setNTotRecvCapitalOld(BigDecimal nTotRecvCapitalOld) {
        this.nTotRecvCapitalOld = nTotRecvCapitalOld;
    }

    public BigDecimal getNTotRecvInterestOld() {
        return nTotRecvInterestOld;
    }

    public void setNTotRecvInterestOld(BigDecimal nTotRecvInterestOld) {
        this.nTotRecvInterestOld = nTotRecvInterestOld;
    }

    public BigDecimal getNTotRecvStationaryOld() {
        return nTotRecvStationaryOld;
    }

    public void setNTotRecvStationaryOld(BigDecimal nTotRecvStationaryOld) {
        this.nTotRecvStationaryOld = nTotRecvStationaryOld;
    }

    public BigDecimal getNTotRecvPostageOld() {
        return nTotRecvPostageOld;
    }

    public void setNTotRecvPostageOld(BigDecimal nTotRecvPostageOld) {
        this.nTotRecvPostageOld = nTotRecvPostageOld;
    }

    public BigDecimal getNTotRecvAuctionFeeOld() {
        return nTotRecvAuctionFeeOld;
    }

    public void setNTotRecvAuctionFeeOld(BigDecimal nTotRecvAuctionFeeOld) {
        this.nTotRecvAuctionFeeOld = nTotRecvAuctionFeeOld;
    }

    public String getCAuthOfficer() {
        return cAuthOfficer;
    }

    public void setCAuthOfficer(String cAuthOfficer) {
        this.cAuthOfficer = cAuthOfficer;
    }

    public boolean getBPrint() {
        return bPrint;
    }

    public void setBPrint(boolean bPrint) {
        this.bPrint = bPrint;
    }

    public boolean getBPosted() {
        return bPosted;
    }

    public void setBPosted(boolean bPosted) {
        this.bPosted = bPosted;
    }

    public String getCReason() {
        return cReason;
    }

    public void setCReason(String cReason) {
        this.cReason = cReason;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public Date getCAddDate() {
        return cAddDate;
    }

    public void setCAddDate(Date cAddDate) {
        this.cAddDate = cAddDate;
    }

    public String getCPostedBy() {
        return cPostedBy;
    }

    public void setCPostedBy(String cPostedBy) {
        this.cPostedBy = cPostedBy;
    }

    public Date getDPostedDate() {
        return dPostedDate;
    }

    public void setDPostedDate(Date dPostedDate) {
        this.dPostedDate = dPostedDate;
    }

    public Date getCAddTime() {
        return cAddTime;
    }

    public void setCAddTime(Date cAddTime) {
        this.cAddTime = cAddTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnTrnHDID != null ? nPwnTrnHDID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnPawnTransactions)) {
            return false;
        }
        BnkPwnPawnTransactions other = (BnkPwnPawnTransactions) object;
        if ((this.nPwnTrnHDID == null && other.nPwnTrnHDID != null) || (this.nPwnTrnHDID != null && !this.nPwnTrnHDID.equals(other.nPwnTrnHDID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkPwnPawnTransactions[ nPwnTrnHDID=" + nPwnTrnHDID + " ]";
    }
    
}
