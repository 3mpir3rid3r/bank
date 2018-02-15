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
@Table(name = "bnk_Dep_Deposit_Transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDepositTransaction.findAll", query = "SELECT b FROM BnkDepDepositTransaction b"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNDepTrnID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nDepTrnID = :nDepTrnID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNDepMFID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nDepMFID = :nDepMFID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNTellerID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nTellerID = :nTellerID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNBankBranchID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNBankBranchIDTrn", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nBankBranchIDTrn = :nBankBranchIDTrn"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDTrnDate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDDepositDate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dDepositDate = :dDepositDate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDTrnTime", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dTrnTime = :dTrnTime"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNGLTrnID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNTrnStatusID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nTrnStatusID = :nTrnStatusID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNJournalDTID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCReceiptNo", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cReceiptNo = :cReceiptNo"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCReceiptNo2", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cReceiptNo2 = :cReceiptNo2"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNPaymentVal", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nPaymentVal = :nPaymentVal"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNDr", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNCr", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNCurBookBalance", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nCurBookBalance = :nCurBookBalance"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNMinimumBookBalance", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nMinimumBookBalance = :nMinimumBookBalance"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByBPrint", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.bPrint = :bPrint"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNPassBookLineNo", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nPassBookLineNo = :nPassBookLineNo"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNPassBookPageNo", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nPassBookPageNo = :nPassBookPageNo"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNOpeningBalanceOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nOpeningBalanceOld = :nOpeningBalanceOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNCurBookBalanceOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nCurBookBalanceOld = :nCurBookBalanceOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNMinimumBookBalanceOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nMinimumBookBalanceOld = :nMinimumBookBalanceOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNNotCreditIntBalanceold", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nNotCreditIntBalanceold = :nNotCreditIntBalanceold"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNActualBalanceOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nActualBalanceOld = :nActualBalanceOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNAvailableBalanceOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nAvailableBalanceOld = :nAvailableBalanceOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNHoldedAmountOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nHoldedAmountOld = :nHoldedAmountOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNIntCalAmountOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nIntCalAmountOld = :nIntCalAmountOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNEffectiveIntOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nEffectiveIntOld = :nEffectiveIntOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDLastIntCalDateOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dLastIntCalDateOld = :dLastIntCalDateOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDLastUpdateDateOld", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dLastUpdateDateOld = :dLastUpdateDateOld"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNLastDepTrnID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nLastDepTrnID = :nLastDepTrnID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNIntTrnFromDepID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nIntTrnFromDepID = :nIntTrnFromDepID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDMaturityDate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dMaturityDate = :dMaturityDate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNIntRate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nIntRate = :nIntRate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNBookValue", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nBookValue = :nBookValue"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCAddBy", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCAddTime", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cAddTime = :cAddTime"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCAddDate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cAddDate = :cAddDate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCAppRejBy", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cAppRejBy = :cAppRejBy"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDAppRejDate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dAppRejDate = :dAppRejDate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCPostedBy", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cPostedBy = :cPostedBy"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDPostedDate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dPostedDate = :dPostedDate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCReason", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cReason = :cReason"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCRemarks", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cRemarks = :cRemarks"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNDailyCollectionHDID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nDailyCollectionHDID = :nDailyCollectionHDID"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByCChequeNo", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.cChequeNo = :cChequeNo"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByDChequeDate", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.dChequeDate = :dChequeDate"),
    @NamedQuery(name = "BnkDepDepositTransaction.findByNChequeIssueID", query = "SELECT b FROM BnkDepDepositTransaction b WHERE b.nChequeIssueID = :nChequeIssueID")})
public class BnkDepDepositTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nDepTrnID")
    private Long nDepTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDepMFID")
    private long nDepMFID;
    @Column(name = "nTellerID")
    private Integer nTellerID;
    @Column(name = "nBankBranchID")
    private Integer nBankBranchID;
    @Column(name = "nBankBranchID_Trn")
    private Integer nBankBranchIDTrn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.DATE)
    private Date dTrnDate;
    @Column(name = "dDepositDate")
    @Temporal(TemporalType.DATE)
    private Date dDepositDate;
    @Column(name = "dTrnTime")
    @Temporal(TemporalType.TIME)
    private Date dTrnTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nGLTrnID")
    private int nGLTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnStatusID")
    private int nTrnStatusID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalDTID")
    private long nJournalDTID;
    @Size(max = 50)
    @Column(name = "cReceiptNo")
    private String cReceiptNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cReceiptNo2")
    private String cReceiptNo2;
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
    @Column(name = "nCurBookBalance")
    private BigDecimal nCurBookBalance;
    @Column(name = "nMinimumBookBalance")
    private BigDecimal nMinimumBookBalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bPrint")
    private boolean bPrint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPassBookLineNo")
    private int nPassBookLineNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPassBookPageNo")
    private int nPassBookPageNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nOpeningBalance_Old")
    private BigDecimal nOpeningBalanceOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCurBookBalance_Old")
    private BigDecimal nCurBookBalanceOld;
    @Column(name = "nMinimumBookBalance_Old")
    private BigDecimal nMinimumBookBalanceOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nNotCreditIntBalance_old")
    private BigDecimal nNotCreditIntBalanceold;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nActualBalance_Old")
    private BigDecimal nActualBalanceOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAvailableBalance_Old")
    private BigDecimal nAvailableBalanceOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nHoldedAmount_Old")
    private BigDecimal nHoldedAmountOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntCalAmount_Old")
    private BigDecimal nIntCalAmountOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nEffectiveInt_Old")
    private BigDecimal nEffectiveIntOld;
    @Column(name = "dLastIntCalDate_Old")
    @Temporal(TemporalType.DATE)
    private Date dLastIntCalDateOld;
    @Column(name = "dLastUpdateDate_Old")
    @Temporal(TemporalType.DATE)
    private Date dLastUpdateDateOld;
    @Column(name = "nLastDepTrnID")
    private BigInteger nLastDepTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntTrnFromDepID")
    private long nIntTrnFromDepID;
    @Column(name = "dMaturityDate")
    @Temporal(TemporalType.DATE)
    private Date dMaturityDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntRate")
    private BigDecimal nIntRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nBookValue")
    private BigDecimal nBookValue;
    @Size(max = 15)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "cAddTime")
    @Temporal(TemporalType.TIME)
    private Date cAddTime;
    @Column(name = "cAddDate")
    @Temporal(TemporalType.DATE)
    private Date cAddDate;
    @Size(max = 50)
    @Column(name = "cAppRejBy")
    private String cAppRejBy;
    @Column(name = "dAppRejDate")
    @Temporal(TemporalType.DATE)
    private Date dAppRejDate;
    @Size(max = 10)
    @Column(name = "cPostedBy")
    private String cPostedBy;
    @Column(name = "dPostedDate")
    @Temporal(TemporalType.DATE)
    private Date dPostedDate;
    @Size(max = 150)
    @Column(name = "cReason")
    private String cReason;
    @Size(max = 50)
    @Column(name = "cRemarks")
    private String cRemarks;
    @Column(name = "nDailyCollectionHDID")
    private Integer nDailyCollectionHDID;
    @Size(max = 20)
    @Column(name = "cChequeNo")
    private String cChequeNo;
    @Column(name = "dChequeDate")
    @Temporal(TemporalType.DATE)
    private Date dChequeDate;
    @Column(name = "nChequeIssueID")
    private Integer nChequeIssueID;

    public BnkDepDepositTransaction() {
    }

    public BnkDepDepositTransaction(Long nDepTrnID) {
        this.nDepTrnID = nDepTrnID;
    }

    public BnkDepDepositTransaction(Long nDepTrnID, long nDepMFID, Date dTrnDate, int nGLTrnID, int nTrnStatusID, long nJournalDTID, String cReceiptNo2, BigDecimal nPaymentVal, BigDecimal nDr, BigDecimal nCr, boolean bPrint, int nPassBookLineNo, int nPassBookPageNo, BigDecimal nOpeningBalanceOld, BigDecimal nCurBookBalanceOld, BigDecimal nNotCreditIntBalanceold, BigDecimal nActualBalanceOld, BigDecimal nAvailableBalanceOld, BigDecimal nHoldedAmountOld, BigDecimal nIntCalAmountOld, BigDecimal nEffectiveIntOld, long nIntTrnFromDepID, BigDecimal nIntRate, BigDecimal nBookValue) {
        this.nDepTrnID = nDepTrnID;
        this.nDepMFID = nDepMFID;
        this.dTrnDate = dTrnDate;
        this.nGLTrnID = nGLTrnID;
        this.nTrnStatusID = nTrnStatusID;
        this.nJournalDTID = nJournalDTID;
        this.cReceiptNo2 = cReceiptNo2;
        this.nPaymentVal = nPaymentVal;
        this.nDr = nDr;
        this.nCr = nCr;
        this.bPrint = bPrint;
        this.nPassBookLineNo = nPassBookLineNo;
        this.nPassBookPageNo = nPassBookPageNo;
        this.nOpeningBalanceOld = nOpeningBalanceOld;
        this.nCurBookBalanceOld = nCurBookBalanceOld;
        this.nNotCreditIntBalanceold = nNotCreditIntBalanceold;
        this.nActualBalanceOld = nActualBalanceOld;
        this.nAvailableBalanceOld = nAvailableBalanceOld;
        this.nHoldedAmountOld = nHoldedAmountOld;
        this.nIntCalAmountOld = nIntCalAmountOld;
        this.nEffectiveIntOld = nEffectiveIntOld;
        this.nIntTrnFromDepID = nIntTrnFromDepID;
        this.nIntRate = nIntRate;
        this.nBookValue = nBookValue;
    }

    public Long getNDepTrnID() {
        return nDepTrnID;
    }

    public void setNDepTrnID(Long nDepTrnID) {
        this.nDepTrnID = nDepTrnID;
    }

    public long getNDepMFID() {
        return nDepMFID;
    }

    public void setNDepMFID(long nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    public Integer getNTellerID() {
        return nTellerID;
    }

    public void setNTellerID(Integer nTellerID) {
        this.nTellerID = nTellerID;
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

    public Date getDTrnTime() {
        return dTrnTime;
    }

    public void setDTrnTime(Date dTrnTime) {
        this.dTrnTime = dTrnTime;
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

    public long getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(long nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
    }

    public String getCReceiptNo() {
        return cReceiptNo;
    }

    public void setCReceiptNo(String cReceiptNo) {
        this.cReceiptNo = cReceiptNo;
    }

    public String getCReceiptNo2() {
        return cReceiptNo2;
    }

    public void setCReceiptNo2(String cReceiptNo2) {
        this.cReceiptNo2 = cReceiptNo2;
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

    public BigDecimal getNCurBookBalance() {
        return nCurBookBalance;
    }

    public void setNCurBookBalance(BigDecimal nCurBookBalance) {
        this.nCurBookBalance = nCurBookBalance;
    }

    public BigDecimal getNMinimumBookBalance() {
        return nMinimumBookBalance;
    }

    public void setNMinimumBookBalance(BigDecimal nMinimumBookBalance) {
        this.nMinimumBookBalance = nMinimumBookBalance;
    }

    public boolean getBPrint() {
        return bPrint;
    }

    public void setBPrint(boolean bPrint) {
        this.bPrint = bPrint;
    }

    public int getNPassBookLineNo() {
        return nPassBookLineNo;
    }

    public void setNPassBookLineNo(int nPassBookLineNo) {
        this.nPassBookLineNo = nPassBookLineNo;
    }

    public int getNPassBookPageNo() {
        return nPassBookPageNo;
    }

    public void setNPassBookPageNo(int nPassBookPageNo) {
        this.nPassBookPageNo = nPassBookPageNo;
    }

    public BigDecimal getNOpeningBalanceOld() {
        return nOpeningBalanceOld;
    }

    public void setNOpeningBalanceOld(BigDecimal nOpeningBalanceOld) {
        this.nOpeningBalanceOld = nOpeningBalanceOld;
    }

    public BigDecimal getNCurBookBalanceOld() {
        return nCurBookBalanceOld;
    }

    public void setNCurBookBalanceOld(BigDecimal nCurBookBalanceOld) {
        this.nCurBookBalanceOld = nCurBookBalanceOld;
    }

    public BigDecimal getNMinimumBookBalanceOld() {
        return nMinimumBookBalanceOld;
    }

    public void setNMinimumBookBalanceOld(BigDecimal nMinimumBookBalanceOld) {
        this.nMinimumBookBalanceOld = nMinimumBookBalanceOld;
    }

    public BigDecimal getNNotCreditIntBalanceold() {
        return nNotCreditIntBalanceold;
    }

    public void setNNotCreditIntBalanceold(BigDecimal nNotCreditIntBalanceold) {
        this.nNotCreditIntBalanceold = nNotCreditIntBalanceold;
    }

    public BigDecimal getNActualBalanceOld() {
        return nActualBalanceOld;
    }

    public void setNActualBalanceOld(BigDecimal nActualBalanceOld) {
        this.nActualBalanceOld = nActualBalanceOld;
    }

    public BigDecimal getNAvailableBalanceOld() {
        return nAvailableBalanceOld;
    }

    public void setNAvailableBalanceOld(BigDecimal nAvailableBalanceOld) {
        this.nAvailableBalanceOld = nAvailableBalanceOld;
    }

    public BigDecimal getNHoldedAmountOld() {
        return nHoldedAmountOld;
    }

    public void setNHoldedAmountOld(BigDecimal nHoldedAmountOld) {
        this.nHoldedAmountOld = nHoldedAmountOld;
    }

    public BigDecimal getNIntCalAmountOld() {
        return nIntCalAmountOld;
    }

    public void setNIntCalAmountOld(BigDecimal nIntCalAmountOld) {
        this.nIntCalAmountOld = nIntCalAmountOld;
    }

    public BigDecimal getNEffectiveIntOld() {
        return nEffectiveIntOld;
    }

    public void setNEffectiveIntOld(BigDecimal nEffectiveIntOld) {
        this.nEffectiveIntOld = nEffectiveIntOld;
    }

    public Date getDLastIntCalDateOld() {
        return dLastIntCalDateOld;
    }

    public void setDLastIntCalDateOld(Date dLastIntCalDateOld) {
        this.dLastIntCalDateOld = dLastIntCalDateOld;
    }

    public Date getDLastUpdateDateOld() {
        return dLastUpdateDateOld;
    }

    public void setDLastUpdateDateOld(Date dLastUpdateDateOld) {
        this.dLastUpdateDateOld = dLastUpdateDateOld;
    }

    public BigInteger getNLastDepTrnID() {
        return nLastDepTrnID;
    }

    public void setNLastDepTrnID(BigInteger nLastDepTrnID) {
        this.nLastDepTrnID = nLastDepTrnID;
    }

    public long getNIntTrnFromDepID() {
        return nIntTrnFromDepID;
    }

    public void setNIntTrnFromDepID(long nIntTrnFromDepID) {
        this.nIntTrnFromDepID = nIntTrnFromDepID;
    }

    public Date getDMaturityDate() {
        return dMaturityDate;
    }

    public void setDMaturityDate(Date dMaturityDate) {
        this.dMaturityDate = dMaturityDate;
    }

    public BigDecimal getNIntRate() {
        return nIntRate;
    }

    public void setNIntRate(BigDecimal nIntRate) {
        this.nIntRate = nIntRate;
    }

    public BigDecimal getNBookValue() {
        return nBookValue;
    }

    public void setNBookValue(BigDecimal nBookValue) {
        this.nBookValue = nBookValue;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public Date getCAddTime() {
        return cAddTime;
    }

    public void setCAddTime(Date cAddTime) {
        this.cAddTime = cAddTime;
    }

    public Date getCAddDate() {
        return cAddDate;
    }

    public void setCAddDate(Date cAddDate) {
        this.cAddDate = cAddDate;
    }

    public String getCAppRejBy() {
        return cAppRejBy;
    }

    public void setCAppRejBy(String cAppRejBy) {
        this.cAppRejBy = cAppRejBy;
    }

    public Date getDAppRejDate() {
        return dAppRejDate;
    }

    public void setDAppRejDate(Date dAppRejDate) {
        this.dAppRejDate = dAppRejDate;
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

    public String getCReason() {
        return cReason;
    }

    public void setCReason(String cReason) {
        this.cReason = cReason;
    }

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public Integer getNDailyCollectionHDID() {
        return nDailyCollectionHDID;
    }

    public void setNDailyCollectionHDID(Integer nDailyCollectionHDID) {
        this.nDailyCollectionHDID = nDailyCollectionHDID;
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

    public Integer getNChequeIssueID() {
        return nChequeIssueID;
    }

    public void setNChequeIssueID(Integer nChequeIssueID) {
        this.nChequeIssueID = nChequeIssueID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepTrnID != null ? nDepTrnID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositTransaction)) {
            return false;
        }
        BnkDepDepositTransaction other = (BnkDepDepositTransaction) object;
        if ((this.nDepTrnID == null && other.nDepTrnID != null) || (this.nDepTrnID != null && !this.nDepTrnID.equals(other.nDepTrnID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepDepositTransaction[ nDepTrnID=" + nDepTrnID + " ]";
    }
    
}
