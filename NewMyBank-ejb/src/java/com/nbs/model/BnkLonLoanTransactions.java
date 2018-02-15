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
@Table(name = "bnk_Lon_LoanTransactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanTransactions.findAll", query = "SELECT b FROM BnkLonLoanTransactions b"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNLonTrnID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nLonTrnID = :nLonTrnID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNLonMFID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nLonMFID = :nLonMFID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTellerID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTellerID = :nTellerID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNBankBranchID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNBankBranchIDTrn", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nBankBranchIDTrn = :nBankBranchIDTrn"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDTrnDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDDepositDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dDepositDate = :dDepositDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNGLTrnID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTrnStatusID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTrnStatusID = :nTrnStatusID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNJournalHDID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nJournalHDID = :nJournalHDID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNJournalDTID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCReceiptNo", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cReceiptNo = :cReceiptNo"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCReceiptNo2", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cReceiptNo2 = :cReceiptNo2"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaymentVal", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaymentVal = :nPaymentVal"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNDr", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNCr", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByBPrint", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.bPrint = :bPrint"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPassBookLineNo", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPassBookLineNo = :nPassBookLineNo"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPassBookPageNo", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPassBookPageNo = :nPassBookPageNo"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaymentType", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaymentType = :nPaymentType"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNLastLonTrnID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nLastLonTrnID = :nLastLonTrnID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTrnDepMFID", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTrnDepMFID = :nTrnDepMFID"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvCapitalOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvCapitalOld = :nTotRecvCapitalOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvInstallmentOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvInstallmentOld = :nTotRecvInstallmentOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvInterestOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvInterestOld = :nTotRecvInterestOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNShouldRecvCapitalOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nShouldRecvCapitalOld = :nShouldRecvCapitalOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNShouldRecvInstallmentOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nShouldRecvInstallmentOld = :nShouldRecvInstallmentOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNShouldRecvInterestOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nShouldRecvInterestOld = :nShouldRecvInterestOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvPenaltyInterestOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvPenaltyInterestOld = :nTotRecvPenaltyInterestOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvPostageOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvPostageOld = :nTotRecvPostageOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvStationaryOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvStationaryOld = :nTotRecvStationaryOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvOtherChargesOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvOtherChargesOld = :nTotRecvOtherChargesOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvArbitrationFeesOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvArbitrationFeesOld = :nTotRecvArbitrationFeesOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNTotRecvCaurtFeesOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nTotRecvCaurtFeesOld = :nTotRecvCaurtFeesOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNIssuedAmountOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nIssuedAmountOld = :nIssuedAmountOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNLonBalanceAmountOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nLonBalanceAmountOld = :nLonBalanceAmountOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNLonBalanceInstallmentOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nLonBalanceInstallmentOld = :nLonBalanceInstallmentOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDLastCapitalPayDateOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dLastCapitalPayDateOld = :dLastCapitalPayDateOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDLastIntPayDateOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dLastIntPayDateOld = :dLastIntPayDateOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDLastPenaltyIntPayDateOld", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dLastPenaltyIntPayDateOld = :dLastPenaltyIntPayDateOld"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateDueDays", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateDueDays = :nToDateDueDays"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateDueCapital", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateDueCapital = :nToDateDueCapital"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateDueInstallment", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateDueInstallment = :nToDateDueInstallment"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDToDateIntCalDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dToDateIntCalDate = :dToDateIntCalDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateIntRate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateIntRate = :nToDateIntRate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateIntSubjectAmount", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateIntSubjectAmount = :nToDateIntSubjectAmount"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateIntValue", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateIntValue = :nToDateIntValue"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateIntValueRound", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateIntValueRound = :nToDateIntValueRound"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDatePanaltyIntDays", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDatePanaltyIntDays = :nToDatePanaltyIntDays"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDatePanaltyIntSubjectAmount", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDatePanaltyIntSubjectAmount = :nToDatePanaltyIntSubjectAmount"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDatePanaltyIntRate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDatePanaltyIntRate = :nToDatePanaltyIntRate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDatePanaltyIntValue", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDatePanaltyIntValue = :nToDatePanaltyIntValue"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDatePanaltyIntValueRound", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDatePanaltyIntValueRound = :nToDatePanaltyIntValueRound"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateTotIntersest", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateTotIntersest = :nToDateTotIntersest"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateTotIntersestRound", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateTotIntersestRound = :nToDateTotIntersestRound"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDatePostage", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDatePostage = :nToDatePostage"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateStationary", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateStationary = :nToDateStationary"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateOherCharges", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateOherCharges = :nToDateOherCharges"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateArbitrationFees", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateArbitrationFees = :nToDateArbitrationFees"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNToDateCaurtFees", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nToDateCaurtFees = :nToDateCaurtFees"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDPaidCapitalDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dPaidCapitalDate = :dPaidCapitalDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDPaidIntDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dPaidIntDate = :dPaidIntDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDPaidPenaltyIntDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dPaidPenaltyIntDate = :dPaidPenaltyIntDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidIntDays", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidIntDays = :nPaidIntDays"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidPenaltyIntDays", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidPenaltyIntDays = :nPaidPenaltyIntDays"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidCapitalVal", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidCapitalVal = :nPaidCapitalVal"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidIntValue", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidIntValue = :nPaidIntValue"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidPenaltyValue", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidPenaltyValue = :nPaidPenaltyValue"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidTotalInt", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidTotalInt = :nPaidTotalInt"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidPostage", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidPostage = :nPaidPostage"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidStationary", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidStationary = :nPaidStationary"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidOherCharges", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidOherCharges = :nPaidOherCharges"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidArbitrationFees", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidArbitrationFees = :nPaidArbitrationFees"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByNPaidCaurtFees", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.nPaidCaurtFees = :nPaidCaurtFees"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCAuthOfficer", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cAuthOfficer = :cAuthOfficer"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCReason", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cReason = :cReason"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCAddBy", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCAddTime", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cAddTime = :cAddTime"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCAddDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cAddDate = :cAddDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCPostedBy", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cPostedBy = :cPostedBy"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByDPostedDate", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.dPostedDate = :dPostedDate"),
    @NamedQuery(name = "BnkLonLoanTransactions.findByCRemarks", query = "SELECT b FROM BnkLonLoanTransactions b WHERE b.cRemarks = :cRemarks")})
public class BnkLonLoanTransactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonTrnID")
    private Long nLonTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonMFID")
    private long nLonMFID;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "nGLTrnID")
    private int nGLTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnStatusID")
    private int nTrnStatusID;
    @Column(name = "nJournalHDID")
    private BigInteger nJournalHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalDTID")
    private long nJournalDTID;
    @Size(max = 50)
    @Column(name = "cReceiptNo")
    private String cReceiptNo;
    @Size(max = 50)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "bPrint")
    private boolean bPrint;
    @Column(name = "nPassBookLineNo")
    private Integer nPassBookLineNo;
    @Column(name = "nPassBookPageNo")
    private Integer nPassBookPageNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaymentType")
    private short nPaymentType;
    @Column(name = "nLastLonTrnID")
    private BigInteger nLastLonTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTrnDepMFID")
    private long nTrnDepMFID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Capital_Old")
    private BigDecimal nTotRecvCapitalOld;
    @Column(name = "nTotRecv_Installment_Old")
    private BigDecimal nTotRecvInstallmentOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Interest_Old")
    private BigDecimal nTotRecvInterestOld;
    @Column(name = "nShouldRecv_Capital_Old")
    private BigDecimal nShouldRecvCapitalOld;
    @Column(name = "nShouldRecv_Installment_Old")
    private BigDecimal nShouldRecvInstallmentOld;
    @Column(name = "nShouldRecv_Interest_Old")
    private BigDecimal nShouldRecvInterestOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_PenaltyInterest_Old")
    private BigDecimal nTotRecvPenaltyInterestOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Postage_Old")
    private BigDecimal nTotRecvPostageOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Stationary_Old")
    private BigDecimal nTotRecvStationaryOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_OtherCharges_Old")
    private BigDecimal nTotRecvOtherChargesOld;
    @Column(name = "nTotRecv_ArbitrationFees_Old")
    private BigDecimal nTotRecvArbitrationFeesOld;
    @Column(name = "nTotRecv_CaurtFees_Old")
    private BigDecimal nTotRecvCaurtFeesOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIssuedAmount_Old")
    private BigDecimal nIssuedAmountOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonBalance_Amount_Old")
    private BigDecimal nLonBalanceAmountOld;
    @Column(name = "nLonBalance_Installment_Old")
    private BigDecimal nLonBalanceInstallmentOld;
    @Column(name = "dLastCapitalPayDate_Old")
    @Temporal(TemporalType.DATE)
    private Date dLastCapitalPayDateOld;
    @Column(name = "dLastIntPayDate_Old")
    @Temporal(TemporalType.DATE)
    private Date dLastIntPayDateOld;
    @Column(name = "dLastPenaltyIntPayDate_Old")
    @Temporal(TemporalType.DATE)
    private Date dLastPenaltyIntPayDateOld;
    @Column(name = "nToDateDue_Days")
    private Integer nToDateDueDays;
    @Column(name = "nToDateDue_Capital")
    private BigDecimal nToDateDueCapital;
    @Column(name = "nToDateDue_Installment")
    private BigDecimal nToDateDueInstallment;
    @Column(name = "dToDateInt_CalDate")
    @Temporal(TemporalType.DATE)
    private Date dToDateIntCalDate;
    @Column(name = "nToDateInt_Rate")
    private BigDecimal nToDateIntRate;
    @Column(name = "nToDateInt_SubjectAmount")
    private BigDecimal nToDateIntSubjectAmount;
    @Column(name = "nToDateInt_Value")
    private BigDecimal nToDateIntValue;
    @Column(name = "nToDateInt_ValueRound")
    private BigDecimal nToDateIntValueRound;
    @Column(name = "nToDatePanaltyInt_Days")
    private Integer nToDatePanaltyIntDays;
    @Column(name = "nToDatePanaltyInt_SubjectAmount")
    private BigDecimal nToDatePanaltyIntSubjectAmount;
    @Column(name = "nToDatePanaltyInt_Rate")
    private BigDecimal nToDatePanaltyIntRate;
    @Column(name = "nToDatePanaltyInt_Value")
    private BigDecimal nToDatePanaltyIntValue;
    @Column(name = "nToDatePanaltyInt_ValueRound")
    private BigDecimal nToDatePanaltyIntValueRound;
    @Column(name = "nToDateTot_Intersest")
    private BigDecimal nToDateTotIntersest;
    @Column(name = "nToDateTot_IntersestRound")
    private BigDecimal nToDateTotIntersestRound;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_Postage")
    private BigDecimal nToDatePostage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_Stationary")
    private BigDecimal nToDateStationary;
    @Column(name = "nToDate_OherCharges")
    private BigDecimal nToDateOherCharges;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_ArbitrationFees")
    private BigDecimal nToDateArbitrationFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDate_CaurtFees")
    private BigDecimal nToDateCaurtFees;
    @Column(name = "dPaidCapitalDate")
    @Temporal(TemporalType.DATE)
    private Date dPaidCapitalDate;
    @Column(name = "dPaidIntDate")
    @Temporal(TemporalType.DATE)
    private Date dPaidIntDate;
    @Column(name = "dPaidPenaltyIntDate")
    @Temporal(TemporalType.DATE)
    private Date dPaidPenaltyIntDate;
    @Column(name = "nPaidIntDays")
    private Integer nPaidIntDays;
    @Column(name = "nPaidPenaltyIntDays")
    private Integer nPaidPenaltyIntDays;
    @Column(name = "nPaidCapitalVal")
    private BigDecimal nPaidCapitalVal;
    @Column(name = "nPaidIntValue")
    private BigDecimal nPaidIntValue;
    @Column(name = "nPaidPenaltyValue")
    private BigDecimal nPaidPenaltyValue;
    @Column(name = "nPaidTotalInt")
    private BigDecimal nPaidTotalInt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaidPostage")
    private BigDecimal nPaidPostage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaidStationary")
    private BigDecimal nPaidStationary;
    @Column(name = "nPaidOherCharges")
    private BigDecimal nPaidOherCharges;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaidArbitrationFees")
    private BigDecimal nPaidArbitrationFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaidCaurtFees")
    private BigDecimal nPaidCaurtFees;
    @Size(max = 25)
    @Column(name = "cAuthOfficer")
    private String cAuthOfficer;
    @Size(max = 150)
    @Column(name = "cReason")
    private String cReason;
    @Size(max = 10)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "cAddTime")
    @Temporal(TemporalType.TIME)
    private Date cAddTime;
    @Column(name = "cAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cAddDate;
    @Size(max = 10)
    @Column(name = "cPostedBy")
    private String cPostedBy;
    @Column(name = "dPostedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dPostedDate;
    @Size(max = 50)
    @Column(name = "cRemarks")
    private String cRemarks;

    public BnkLonLoanTransactions() {
    }

    public BnkLonLoanTransactions(Long nLonTrnID) {
        this.nLonTrnID = nLonTrnID;
    }

    public BnkLonLoanTransactions(Long nLonTrnID, long nLonMFID, Date dTrnDate, int nGLTrnID, int nTrnStatusID, long nJournalDTID, BigDecimal nPaymentVal, BigDecimal nDr, BigDecimal nCr, boolean bPrint, short nPaymentType, long nTrnDepMFID, BigDecimal nTotRecvCapitalOld, BigDecimal nTotRecvInterestOld, BigDecimal nTotRecvPenaltyInterestOld, BigDecimal nTotRecvPostageOld, BigDecimal nTotRecvStationaryOld, BigDecimal nTotRecvOtherChargesOld, BigDecimal nIssuedAmountOld, BigDecimal nLonBalanceAmountOld, BigDecimal nToDatePostage, BigDecimal nToDateStationary, BigDecimal nToDateArbitrationFees, BigDecimal nToDateCaurtFees, BigDecimal nPaidPostage, BigDecimal nPaidStationary, BigDecimal nPaidArbitrationFees, BigDecimal nPaidCaurtFees) {
        this.nLonTrnID = nLonTrnID;
        this.nLonMFID = nLonMFID;
        this.dTrnDate = dTrnDate;
        this.nGLTrnID = nGLTrnID;
        this.nTrnStatusID = nTrnStatusID;
        this.nJournalDTID = nJournalDTID;
        this.nPaymentVal = nPaymentVal;
        this.nDr = nDr;
        this.nCr = nCr;
        this.bPrint = bPrint;
        this.nPaymentType = nPaymentType;
        this.nTrnDepMFID = nTrnDepMFID;
        this.nTotRecvCapitalOld = nTotRecvCapitalOld;
        this.nTotRecvInterestOld = nTotRecvInterestOld;
        this.nTotRecvPenaltyInterestOld = nTotRecvPenaltyInterestOld;
        this.nTotRecvPostageOld = nTotRecvPostageOld;
        this.nTotRecvStationaryOld = nTotRecvStationaryOld;
        this.nTotRecvOtherChargesOld = nTotRecvOtherChargesOld;
        this.nIssuedAmountOld = nIssuedAmountOld;
        this.nLonBalanceAmountOld = nLonBalanceAmountOld;
        this.nToDatePostage = nToDatePostage;
        this.nToDateStationary = nToDateStationary;
        this.nToDateArbitrationFees = nToDateArbitrationFees;
        this.nToDateCaurtFees = nToDateCaurtFees;
        this.nPaidPostage = nPaidPostage;
        this.nPaidStationary = nPaidStationary;
        this.nPaidArbitrationFees = nPaidArbitrationFees;
        this.nPaidCaurtFees = nPaidCaurtFees;
    }

    public Long getNLonTrnID() {
        return nLonTrnID;
    }

    public void setNLonTrnID(Long nLonTrnID) {
        this.nLonTrnID = nLonTrnID;
    }

    public long getNLonMFID() {
        return nLonMFID;
    }

    public void setNLonMFID(long nLonMFID) {
        this.nLonMFID = nLonMFID;
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

    public boolean getBPrint() {
        return bPrint;
    }

    public void setBPrint(boolean bPrint) {
        this.bPrint = bPrint;
    }

    public Integer getNPassBookLineNo() {
        return nPassBookLineNo;
    }

    public void setNPassBookLineNo(Integer nPassBookLineNo) {
        this.nPassBookLineNo = nPassBookLineNo;
    }

    public Integer getNPassBookPageNo() {
        return nPassBookPageNo;
    }

    public void setNPassBookPageNo(Integer nPassBookPageNo) {
        this.nPassBookPageNo = nPassBookPageNo;
    }

    public short getNPaymentType() {
        return nPaymentType;
    }

    public void setNPaymentType(short nPaymentType) {
        this.nPaymentType = nPaymentType;
    }

    public BigInteger getNLastLonTrnID() {
        return nLastLonTrnID;
    }

    public void setNLastLonTrnID(BigInteger nLastLonTrnID) {
        this.nLastLonTrnID = nLastLonTrnID;
    }

    public long getNTrnDepMFID() {
        return nTrnDepMFID;
    }

    public void setNTrnDepMFID(long nTrnDepMFID) {
        this.nTrnDepMFID = nTrnDepMFID;
    }

    public BigDecimal getNTotRecvCapitalOld() {
        return nTotRecvCapitalOld;
    }

    public void setNTotRecvCapitalOld(BigDecimal nTotRecvCapitalOld) {
        this.nTotRecvCapitalOld = nTotRecvCapitalOld;
    }

    public BigDecimal getNTotRecvInstallmentOld() {
        return nTotRecvInstallmentOld;
    }

    public void setNTotRecvInstallmentOld(BigDecimal nTotRecvInstallmentOld) {
        this.nTotRecvInstallmentOld = nTotRecvInstallmentOld;
    }

    public BigDecimal getNTotRecvInterestOld() {
        return nTotRecvInterestOld;
    }

    public void setNTotRecvInterestOld(BigDecimal nTotRecvInterestOld) {
        this.nTotRecvInterestOld = nTotRecvInterestOld;
    }

    public BigDecimal getNShouldRecvCapitalOld() {
        return nShouldRecvCapitalOld;
    }

    public void setNShouldRecvCapitalOld(BigDecimal nShouldRecvCapitalOld) {
        this.nShouldRecvCapitalOld = nShouldRecvCapitalOld;
    }

    public BigDecimal getNShouldRecvInstallmentOld() {
        return nShouldRecvInstallmentOld;
    }

    public void setNShouldRecvInstallmentOld(BigDecimal nShouldRecvInstallmentOld) {
        this.nShouldRecvInstallmentOld = nShouldRecvInstallmentOld;
    }

    public BigDecimal getNShouldRecvInterestOld() {
        return nShouldRecvInterestOld;
    }

    public void setNShouldRecvInterestOld(BigDecimal nShouldRecvInterestOld) {
        this.nShouldRecvInterestOld = nShouldRecvInterestOld;
    }

    public BigDecimal getNTotRecvPenaltyInterestOld() {
        return nTotRecvPenaltyInterestOld;
    }

    public void setNTotRecvPenaltyInterestOld(BigDecimal nTotRecvPenaltyInterestOld) {
        this.nTotRecvPenaltyInterestOld = nTotRecvPenaltyInterestOld;
    }

    public BigDecimal getNTotRecvPostageOld() {
        return nTotRecvPostageOld;
    }

    public void setNTotRecvPostageOld(BigDecimal nTotRecvPostageOld) {
        this.nTotRecvPostageOld = nTotRecvPostageOld;
    }

    public BigDecimal getNTotRecvStationaryOld() {
        return nTotRecvStationaryOld;
    }

    public void setNTotRecvStationaryOld(BigDecimal nTotRecvStationaryOld) {
        this.nTotRecvStationaryOld = nTotRecvStationaryOld;
    }

    public BigDecimal getNTotRecvOtherChargesOld() {
        return nTotRecvOtherChargesOld;
    }

    public void setNTotRecvOtherChargesOld(BigDecimal nTotRecvOtherChargesOld) {
        this.nTotRecvOtherChargesOld = nTotRecvOtherChargesOld;
    }

    public BigDecimal getNTotRecvArbitrationFeesOld() {
        return nTotRecvArbitrationFeesOld;
    }

    public void setNTotRecvArbitrationFeesOld(BigDecimal nTotRecvArbitrationFeesOld) {
        this.nTotRecvArbitrationFeesOld = nTotRecvArbitrationFeesOld;
    }

    public BigDecimal getNTotRecvCaurtFeesOld() {
        return nTotRecvCaurtFeesOld;
    }

    public void setNTotRecvCaurtFeesOld(BigDecimal nTotRecvCaurtFeesOld) {
        this.nTotRecvCaurtFeesOld = nTotRecvCaurtFeesOld;
    }

    public BigDecimal getNIssuedAmountOld() {
        return nIssuedAmountOld;
    }

    public void setNIssuedAmountOld(BigDecimal nIssuedAmountOld) {
        this.nIssuedAmountOld = nIssuedAmountOld;
    }

    public BigDecimal getNLonBalanceAmountOld() {
        return nLonBalanceAmountOld;
    }

    public void setNLonBalanceAmountOld(BigDecimal nLonBalanceAmountOld) {
        this.nLonBalanceAmountOld = nLonBalanceAmountOld;
    }

    public BigDecimal getNLonBalanceInstallmentOld() {
        return nLonBalanceInstallmentOld;
    }

    public void setNLonBalanceInstallmentOld(BigDecimal nLonBalanceInstallmentOld) {
        this.nLonBalanceInstallmentOld = nLonBalanceInstallmentOld;
    }

    public Date getDLastCapitalPayDateOld() {
        return dLastCapitalPayDateOld;
    }

    public void setDLastCapitalPayDateOld(Date dLastCapitalPayDateOld) {
        this.dLastCapitalPayDateOld = dLastCapitalPayDateOld;
    }

    public Date getDLastIntPayDateOld() {
        return dLastIntPayDateOld;
    }

    public void setDLastIntPayDateOld(Date dLastIntPayDateOld) {
        this.dLastIntPayDateOld = dLastIntPayDateOld;
    }

    public Date getDLastPenaltyIntPayDateOld() {
        return dLastPenaltyIntPayDateOld;
    }

    public void setDLastPenaltyIntPayDateOld(Date dLastPenaltyIntPayDateOld) {
        this.dLastPenaltyIntPayDateOld = dLastPenaltyIntPayDateOld;
    }

    public Integer getNToDateDueDays() {
        return nToDateDueDays;
    }

    public void setNToDateDueDays(Integer nToDateDueDays) {
        this.nToDateDueDays = nToDateDueDays;
    }

    public BigDecimal getNToDateDueCapital() {
        return nToDateDueCapital;
    }

    public void setNToDateDueCapital(BigDecimal nToDateDueCapital) {
        this.nToDateDueCapital = nToDateDueCapital;
    }

    public BigDecimal getNToDateDueInstallment() {
        return nToDateDueInstallment;
    }

    public void setNToDateDueInstallment(BigDecimal nToDateDueInstallment) {
        this.nToDateDueInstallment = nToDateDueInstallment;
    }

    public Date getDToDateIntCalDate() {
        return dToDateIntCalDate;
    }

    public void setDToDateIntCalDate(Date dToDateIntCalDate) {
        this.dToDateIntCalDate = dToDateIntCalDate;
    }

    public BigDecimal getNToDateIntRate() {
        return nToDateIntRate;
    }

    public void setNToDateIntRate(BigDecimal nToDateIntRate) {
        this.nToDateIntRate = nToDateIntRate;
    }

    public BigDecimal getNToDateIntSubjectAmount() {
        return nToDateIntSubjectAmount;
    }

    public void setNToDateIntSubjectAmount(BigDecimal nToDateIntSubjectAmount) {
        this.nToDateIntSubjectAmount = nToDateIntSubjectAmount;
    }

    public BigDecimal getNToDateIntValue() {
        return nToDateIntValue;
    }

    public void setNToDateIntValue(BigDecimal nToDateIntValue) {
        this.nToDateIntValue = nToDateIntValue;
    }

    public BigDecimal getNToDateIntValueRound() {
        return nToDateIntValueRound;
    }

    public void setNToDateIntValueRound(BigDecimal nToDateIntValueRound) {
        this.nToDateIntValueRound = nToDateIntValueRound;
    }

    public Integer getNToDatePanaltyIntDays() {
        return nToDatePanaltyIntDays;
    }

    public void setNToDatePanaltyIntDays(Integer nToDatePanaltyIntDays) {
        this.nToDatePanaltyIntDays = nToDatePanaltyIntDays;
    }

    public BigDecimal getNToDatePanaltyIntSubjectAmount() {
        return nToDatePanaltyIntSubjectAmount;
    }

    public void setNToDatePanaltyIntSubjectAmount(BigDecimal nToDatePanaltyIntSubjectAmount) {
        this.nToDatePanaltyIntSubjectAmount = nToDatePanaltyIntSubjectAmount;
    }

    public BigDecimal getNToDatePanaltyIntRate() {
        return nToDatePanaltyIntRate;
    }

    public void setNToDatePanaltyIntRate(BigDecimal nToDatePanaltyIntRate) {
        this.nToDatePanaltyIntRate = nToDatePanaltyIntRate;
    }

    public BigDecimal getNToDatePanaltyIntValue() {
        return nToDatePanaltyIntValue;
    }

    public void setNToDatePanaltyIntValue(BigDecimal nToDatePanaltyIntValue) {
        this.nToDatePanaltyIntValue = nToDatePanaltyIntValue;
    }

    public BigDecimal getNToDatePanaltyIntValueRound() {
        return nToDatePanaltyIntValueRound;
    }

    public void setNToDatePanaltyIntValueRound(BigDecimal nToDatePanaltyIntValueRound) {
        this.nToDatePanaltyIntValueRound = nToDatePanaltyIntValueRound;
    }

    public BigDecimal getNToDateTotIntersest() {
        return nToDateTotIntersest;
    }

    public void setNToDateTotIntersest(BigDecimal nToDateTotIntersest) {
        this.nToDateTotIntersest = nToDateTotIntersest;
    }

    public BigDecimal getNToDateTotIntersestRound() {
        return nToDateTotIntersestRound;
    }

    public void setNToDateTotIntersestRound(BigDecimal nToDateTotIntersestRound) {
        this.nToDateTotIntersestRound = nToDateTotIntersestRound;
    }

    public BigDecimal getNToDatePostage() {
        return nToDatePostage;
    }

    public void setNToDatePostage(BigDecimal nToDatePostage) {
        this.nToDatePostage = nToDatePostage;
    }

    public BigDecimal getNToDateStationary() {
        return nToDateStationary;
    }

    public void setNToDateStationary(BigDecimal nToDateStationary) {
        this.nToDateStationary = nToDateStationary;
    }

    public BigDecimal getNToDateOherCharges() {
        return nToDateOherCharges;
    }

    public void setNToDateOherCharges(BigDecimal nToDateOherCharges) {
        this.nToDateOherCharges = nToDateOherCharges;
    }

    public BigDecimal getNToDateArbitrationFees() {
        return nToDateArbitrationFees;
    }

    public void setNToDateArbitrationFees(BigDecimal nToDateArbitrationFees) {
        this.nToDateArbitrationFees = nToDateArbitrationFees;
    }

    public BigDecimal getNToDateCaurtFees() {
        return nToDateCaurtFees;
    }

    public void setNToDateCaurtFees(BigDecimal nToDateCaurtFees) {
        this.nToDateCaurtFees = nToDateCaurtFees;
    }

    public Date getDPaidCapitalDate() {
        return dPaidCapitalDate;
    }

    public void setDPaidCapitalDate(Date dPaidCapitalDate) {
        this.dPaidCapitalDate = dPaidCapitalDate;
    }

    public Date getDPaidIntDate() {
        return dPaidIntDate;
    }

    public void setDPaidIntDate(Date dPaidIntDate) {
        this.dPaidIntDate = dPaidIntDate;
    }

    public Date getDPaidPenaltyIntDate() {
        return dPaidPenaltyIntDate;
    }

    public void setDPaidPenaltyIntDate(Date dPaidPenaltyIntDate) {
        this.dPaidPenaltyIntDate = dPaidPenaltyIntDate;
    }

    public Integer getNPaidIntDays() {
        return nPaidIntDays;
    }

    public void setNPaidIntDays(Integer nPaidIntDays) {
        this.nPaidIntDays = nPaidIntDays;
    }

    public Integer getNPaidPenaltyIntDays() {
        return nPaidPenaltyIntDays;
    }

    public void setNPaidPenaltyIntDays(Integer nPaidPenaltyIntDays) {
        this.nPaidPenaltyIntDays = nPaidPenaltyIntDays;
    }

    public BigDecimal getNPaidCapitalVal() {
        return nPaidCapitalVal;
    }

    public void setNPaidCapitalVal(BigDecimal nPaidCapitalVal) {
        this.nPaidCapitalVal = nPaidCapitalVal;
    }

    public BigDecimal getNPaidIntValue() {
        return nPaidIntValue;
    }

    public void setNPaidIntValue(BigDecimal nPaidIntValue) {
        this.nPaidIntValue = nPaidIntValue;
    }

    public BigDecimal getNPaidPenaltyValue() {
        return nPaidPenaltyValue;
    }

    public void setNPaidPenaltyValue(BigDecimal nPaidPenaltyValue) {
        this.nPaidPenaltyValue = nPaidPenaltyValue;
    }

    public BigDecimal getNPaidTotalInt() {
        return nPaidTotalInt;
    }

    public void setNPaidTotalInt(BigDecimal nPaidTotalInt) {
        this.nPaidTotalInt = nPaidTotalInt;
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

    public BigDecimal getNPaidOherCharges() {
        return nPaidOherCharges;
    }

    public void setNPaidOherCharges(BigDecimal nPaidOherCharges) {
        this.nPaidOherCharges = nPaidOherCharges;
    }

    public BigDecimal getNPaidArbitrationFees() {
        return nPaidArbitrationFees;
    }

    public void setNPaidArbitrationFees(BigDecimal nPaidArbitrationFees) {
        this.nPaidArbitrationFees = nPaidArbitrationFees;
    }

    public BigDecimal getNPaidCaurtFees() {
        return nPaidCaurtFees;
    }

    public void setNPaidCaurtFees(BigDecimal nPaidCaurtFees) {
        this.nPaidCaurtFees = nPaidCaurtFees;
    }

    public String getCAuthOfficer() {
        return cAuthOfficer;
    }

    public void setCAuthOfficer(String cAuthOfficer) {
        this.cAuthOfficer = cAuthOfficer;
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

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonTrnID != null ? nLonTrnID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanTransactions)) {
            return false;
        }
        BnkLonLoanTransactions other = (BnkLonLoanTransactions) object;
        if ((this.nLonTrnID == null && other.nLonTrnID != null) || (this.nLonTrnID != null && !this.nLonTrnID.equals(other.nLonTrnID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanTransactions[ nLonTrnID=" + nLonTrnID + " ]";
    }
    
}
