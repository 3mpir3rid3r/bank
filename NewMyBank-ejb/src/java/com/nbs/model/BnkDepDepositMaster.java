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
@Table(name = "bnk_Dep_Deposit_Master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDepositMaster.findAll", query = "SELECT b FROM BnkDepDepositMaster b")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNDepMFID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nDepMFID = :nDepMFID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNBankBranchID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nBankBranchID = :nBankBranchID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNDepTypeID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nDepTypeID = :nDepTypeID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCOurAccountNo", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cOurAccountNo = :cOurAccountNo")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCOldAccountNo", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cOldAccountNo = :cOldAccountNo")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCSerialNo", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cSerialNo = :cSerialNo")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNLedgerBookNo", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nLedgerBookNo = :nLedgerBookNo")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNEffectiveInt", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nEffectiveInt = :nEffectiveInt")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBJoint", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bJoint = :bJoint")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNAcctStatusID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nAcctStatusID = :nAcctStatusID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDStartDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dStartDate = :dStartDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDSysStartDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dSysStartDate = :dSysStartDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNSysStartBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nSysStartBalance = :nSysStartBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNOpeningBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nOpeningBalance = :nOpeningBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNCurBookBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nCurBookBalance = :nCurBookBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNMinimumBookBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nMinimumBookBalance = :nMinimumBookBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNNotCreditIntBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nNotCreditIntBalance = :nNotCreditIntBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNActualBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nActualBalance = :nActualBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNAvailableBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nAvailableBalance = :nAvailableBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDIntialiDeposit", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDIntialiDeposit = :nFDIntialiDeposit")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDPeriod", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDPeriod = :nFDPeriod")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDPeriodTypeID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDPeriodTypeID = :nFDPeriodTypeID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDFDMaturityDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dFDMaturityDate = :dFDMaturityDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDMaturityValue", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDMaturityValue = :nFDMaturityValue")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCFDAgreementNo", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cFDAgreementNo = :cFDAgreementNo")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBFDComplete", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bFDComplete = :bFDComplete")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDFDCompleteDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dFDCompleteDate = :dFDCompleteDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDClosingMethodID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDClosingMethodID = :nFDClosingMethodID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDIntCalMethodID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDIntCalMethodID = :nFDIntCalMethodID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDIntCalMethodValue", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDIntCalMethodValue = :nFDIntCalMethodValue")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDIntCRMethodID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDIntCRMethodID = :nFDIntCRMethodID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNFDIntCRMethodValue", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nFDIntCRMethodValue = :nFDIntCRMethodValue")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBIntCreditingDiffAcc", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bIntCreditingDiffAcc = :bIntCreditingDiffAcc")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNIntCRnDepMFID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nIntCRnDepMFID = :nIntCRnDepMFID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDLastIntCalDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dLastIntCalDate = :dLastIntCalDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDLastUpdateDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dLastUpdateDate = :dLastUpdateDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNLastDepTrnID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nLastDepTrnID = :nLastDepTrnID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDNextFDIntCalDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dNextFDIntCalDate = :dNextFDIntCalDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBAmtHolded", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bAmtHolded = :bAmtHolded")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNHoldedAmount", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nHoldedAmount = :nHoldedAmount")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDHoldFromDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dHoldFromDate = :dHoldFromDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDHoldToDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dHoldToDate = :dHoldToDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBIntHolded", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bIntHolded = :bIntHolded")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNHoldedAmountInt", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nHoldedAmountInt = :nHoldedAmountInt")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDIntHoldFromDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dIntHoldFromDate = :dIntHoldFromDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDIntHoldToDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dIntHoldToDate = :dIntHoldToDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNInstDRnDepMFID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nInstDRnDepMFID = :nInstDRnDepMFID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNInstDRValue", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nInstDRValue = :nInstDRValue")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNTDDepositPeriod", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nTDDepositPeriod = :nTDDepositPeriod")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNTDAgreedAmount", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nTDAgreedAmount = :nTDAgreedAmount")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNTDPaymentDay", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nTDPaymentDay = :nTDPaymentDay")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDActCloseDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dActCloseDate = :dActCloseDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNNominatorRelationshipID", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nNominatorRelationshipID = :nNominatorRelationshipID")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCAddBy", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cAddBy = :cAddBy")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCRemarks", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cRemarks = :cRemarks")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCGarbageBy", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cGarbageBy = :cGarbageBy")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDAddDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dAddDate = :dAddDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCEditBy", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cEditBy = :cEditBy")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDEditDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dEditDate = :dEditDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBEditConfirm", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bEditConfirm = :bEditConfirm")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDConfirmDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dConfirmDate = :dConfirmDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCConfirmBy", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cConfirmBy = :cConfirmBy")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBInAudit", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bInAudit = :bInAudit")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBOutAudit", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bOutAudit = :bOutAudit")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDInAuditDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dInAuditDate = :dInAuditDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDOutAuditDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dOutAuditDate = :dOutAuditDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCInAuditBy", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cInAuditBy = :cInAuditBy")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCOutAuditBy", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cOutAuditBy = :cOutAuditBy")
    , @NamedQuery(name = "BnkDepDepositMaster.findByBGarbage", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.bGarbage = :bGarbage")
    , @NamedQuery(name = "BnkDepDepositMaster.findByCNominatorFullName", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.cNominatorFullName = :cNominatorFullName")
    , @NamedQuery(name = "BnkDepDepositMaster.findByDGarbageDate", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.dGarbageDate = :dGarbageDate")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNQ1MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nQ1MinBalance = :nQ1MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNQ2MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nQ2MinBalance = :nQ2MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNQ3MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nQ3MinBalance = :nQ3MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNQ4MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nQ4MinBalance = :nQ4MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM1MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM1MinBalance = :nM1MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM2MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM2MinBalance = :nM2MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM3MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM3MinBalance = :nM3MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM4MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM4MinBalance = :nM4MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM5MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM5MinBalance = :nM5MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM6MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM6MinBalance = :nM6MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM7MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM7MinBalance = :nM7MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM8MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM8MinBalance = :nM8MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM9MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM9MinBalance = :nM9MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM10MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM10MinBalance = :nM10MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM11MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM11MinBalance = :nM11MinBalance")
    , @NamedQuery(name = "BnkDepDepositMaster.findByNM12MinBalance", query = "SELECT b FROM BnkDepDepositMaster b WHERE b.nM12MinBalance = :nM12MinBalance")})
public class BnkDepDepositMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nDepMFID")
    private Long nDepMFID;
    @Column(name = "nBankBranchID")
    private Integer nBankBranchID;
    @Column(name = "nDepTypeID")
    private Integer nDepTypeID;
    @Size(max = 13)
    @Column(name = "cOurAccountNo")
    private String cOurAccountNo;
    @Size(max = 13)
    @Column(name = "cOldAccountNo")
    private String cOldAccountNo;
    @Size(max = 3)
    @Column(name = "cSerialNo")
    private String cSerialNo;
    @Column(name = "nLedgerBookNo")
    private Integer nLedgerBookNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nEffectiveInt")
    private BigDecimal nEffectiveInt;
    @Column(name = "bJoint")
    private Boolean bJoint;
    @Column(name = "nAcctStatusID")
    private Integer nAcctStatusID;
    @Column(name = "dStartDate")
    @Temporal(TemporalType.DATE)
    private Date dStartDate;
    @Column(name = "dSysStartDate")
    @Temporal(TemporalType.DATE)
    private Date dSysStartDate;
    @Column(name = "nSysStartBalance")
    private BigDecimal nSysStartBalance;
    @Column(name = "nOpeningBalance")
    private BigDecimal nOpeningBalance;
    @Column(name = "nCurBookBalance")
    private BigDecimal nCurBookBalance;
    @Column(name = "nMinimumBookBalance")
    private BigDecimal nMinimumBookBalance;
    @Column(name = "nNotCreditIntBalance")
    private BigDecimal nNotCreditIntBalance;
    @Column(name = "nActualBalance")
    private BigDecimal nActualBalance;
    @Column(name = "nAvailableBalance")
    private BigDecimal nAvailableBalance;
    @Column(name = "nFDIntialiDeposit")
    private BigDecimal nFDIntialiDeposit;
    @Column(name = "nFDPeriod")
    private Integer nFDPeriod;
    @Column(name = "nFDPeriodTypeID")
    private Short nFDPeriodTypeID;
    @Column(name = "dFDMaturityDate")
    @Temporal(TemporalType.DATE)
    private Date dFDMaturityDate;
    @Column(name = "nFDMaturityValue")
    private BigDecimal nFDMaturityValue;
    @Size(max = 50)
    @Column(name = "cFDAgreementNo")
    private String cFDAgreementNo;
    @Column(name = "bFDComplete")
    private Boolean bFDComplete;
    @Column(name = "dFDCompleteDate")
    @Temporal(TemporalType.DATE)
    private Date dFDCompleteDate;
    @Column(name = "nFDClosingMethodID")
    private Short nFDClosingMethodID;
    @Column(name = "nFDIntCalMethodID")
    private Short nFDIntCalMethodID;
    @Column(name = "nFDIntCalMethodValue")
    private Integer nFDIntCalMethodValue;
    @Column(name = "nFDIntCRMethodID")
    private Short nFDIntCRMethodID;
    @Column(name = "nFDIntCRMethodValue")
    private Integer nFDIntCRMethodValue;
    @Column(name = "bIntCrediting_DiffAcc")
    private Boolean bIntCreditingDiffAcc;
    @Column(name = "nIntCR_nDepMFID")
    private BigInteger nIntCRnDepMFID;
    @Column(name = "dLastIntCalDate")
    @Temporal(TemporalType.DATE)
    private Date dLastIntCalDate;
    @Column(name = "dLastUpdateDate")
    @Temporal(TemporalType.DATE)
    private Date dLastUpdateDate;
    @Column(name = "nLastDepTrnID")
    private BigInteger nLastDepTrnID;
    @Column(name = "dNextFDIntCalDate")
    @Temporal(TemporalType.DATE)
    private Date dNextFDIntCalDate;
    @Column(name = "bAmtHolded")
    private Boolean bAmtHolded;
    @Column(name = "nHoldedAmount")
    private BigDecimal nHoldedAmount;
    @Column(name = "dHoldFromDate")
    @Temporal(TemporalType.DATE)
    private Date dHoldFromDate;
    @Column(name = "dHoldToDate")
    @Temporal(TemporalType.DATE)
    private Date dHoldToDate;
    @Column(name = "bIntHolded")
    private Boolean bIntHolded;
    @Column(name = "nHoldedAmount_Int")
    private BigDecimal nHoldedAmountInt;
    @Column(name = "dIntHold_FromDate")
    @Temporal(TemporalType.DATE)
    private Date dIntHoldFromDate;
    @Column(name = "dIntHold_ToDate")
    @Temporal(TemporalType.DATE)
    private Date dIntHoldToDate;
    @Column(name = "nInstDR_nDepMFID")
    private BigInteger nInstDRnDepMFID;
    @Column(name = "nInstDR_Value")
    private BigDecimal nInstDRValue;
    @Column(name = "nTDDepositPeriod")
    private Integer nTDDepositPeriod;
    @Column(name = "nTDAgreedAmount")
    private BigDecimal nTDAgreedAmount;
    @Column(name = "nTDPaymentDay")
    private Integer nTDPaymentDay;
    @Column(name = "dActCloseDate")
    @Temporal(TemporalType.DATE)
    private Date dActCloseDate;
    @Column(name = "nNominatorRelationshipID")
    private Integer nNominatorRelationshipID;
    @Size(max = 20)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Size(max = 200)
    @Column(name = "cRemarks")
    private String cRemarks;
    @Size(max = 30)
    @Column(name = "cGarbageBy")
    private String cGarbageBy;
    @Column(name = "dAddDate")
    @Temporal(TemporalType.DATE)
    private Date dAddDate;
    @Size(max = 20)
    @Column(name = "cEditBy")
    private String cEditBy;
    @Column(name = "dEditDate")
    @Temporal(TemporalType.DATE)
    private Date dEditDate;
    @Column(name = "bEditConfirm")
    private Boolean bEditConfirm;
    @Column(name = "dConfirmDate")
    @Temporal(TemporalType.DATE)
    private Date dConfirmDate;
    @Size(max = 30)
    @Column(name = "cConfirmBy")
    private String cConfirmBy;
    @Column(name = "bInAudit")
    private Boolean bInAudit;
    @Column(name = "bOutAudit")
    private Boolean bOutAudit;
    @Column(name = "dInAuditDate")
    @Temporal(TemporalType.DATE)
    private Date dInAuditDate;
    @Column(name = "dOutAuditDate")
    @Temporal(TemporalType.DATE)
    private Date dOutAuditDate;
    @Size(max = 30)
    @Column(name = "cInAuditBy")
    private String cInAuditBy;
    @Size(max = 30)
    @Column(name = "cOutAuditBy")
    private String cOutAuditBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bGarbage")
    private short bGarbage;
    @Size(max = 50)
    @Column(name = "cNominatorFullName")
    private String cNominatorFullName;
    @Column(name = "dGarbageDate")
    @Temporal(TemporalType.DATE)
    private Date dGarbageDate;
    @Column(name = "nQ1_MinBalance")
    private BigDecimal nQ1MinBalance;
    @Column(name = "nQ2_MinBalance")
    private BigDecimal nQ2MinBalance;
    @Column(name = "nQ3_MinBalance")
    private BigDecimal nQ3MinBalance;
    @Column(name = "nQ4_MinBalance")
    private BigDecimal nQ4MinBalance;
    @Column(name = "nM1_MinBalance")
    private BigDecimal nM1MinBalance;
    @Column(name = "nM2_MinBalance")
    private BigDecimal nM2MinBalance;
    @Column(name = "nM3_MinBalance")
    private BigDecimal nM3MinBalance;
    @Column(name = "nM4_MinBalance")
    private BigDecimal nM4MinBalance;
    @Column(name = "nM5_MinBalance")
    private BigDecimal nM5MinBalance;
    @Column(name = "nM6_MinBalance")
    private BigDecimal nM6MinBalance;
    @Column(name = "nM7_MinBalance")
    private BigDecimal nM7MinBalance;
    @Column(name = "nM8_MinBalance")
    private BigDecimal nM8MinBalance;
    @Column(name = "nM9_MinBalance")
    private BigDecimal nM9MinBalance;
    @Column(name = "nM10_MinBalance")
    private BigDecimal nM10MinBalance;
    @Column(name = "nM11_MinBalance")
    private BigDecimal nM11MinBalance;
    @Column(name = "nM12_MinBalance")
    private BigDecimal nM12MinBalance;
    @JoinColumn(name = "nCustomerID", referencedColumnName = "nCustomerID")
    @ManyToOne
    private BnkCustomerMaster nCustomerID;

    public BnkDepDepositMaster() {
    }

    public BnkDepDepositMaster(Long nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    public BnkDepDepositMaster(Long nDepMFID, short bGarbage) {
        this.nDepMFID = nDepMFID;
        this.bGarbage = bGarbage;
    }

    public Long getNDepMFID() {
        return nDepMFID;
    }

    public void setNDepMFID(Long nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    public Integer getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(Integer nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public Integer getNDepTypeID() {
        return nDepTypeID;
    }

    public void setNDepTypeID(Integer nDepTypeID) {
        this.nDepTypeID = nDepTypeID;
    }

    public String getCOurAccountNo() {
        return cOurAccountNo;
    }

    public void setCOurAccountNo(String cOurAccountNo) {
        this.cOurAccountNo = cOurAccountNo;
    }

    public String getCOldAccountNo() {
        return cOldAccountNo;
    }

    public void setCOldAccountNo(String cOldAccountNo) {
        this.cOldAccountNo = cOldAccountNo;
    }

    public String getCSerialNo() {
        return cSerialNo;
    }

    public void setCSerialNo(String cSerialNo) {
        this.cSerialNo = cSerialNo;
    }

    public Integer getNLedgerBookNo() {
        return nLedgerBookNo;
    }

    public void setNLedgerBookNo(Integer nLedgerBookNo) {
        this.nLedgerBookNo = nLedgerBookNo;
    }

    public BigDecimal getNEffectiveInt() {
        return nEffectiveInt;
    }

    public void setNEffectiveInt(BigDecimal nEffectiveInt) {
        this.nEffectiveInt = nEffectiveInt;
    }

    public Boolean getBJoint() {
        return bJoint;
    }

    public void setBJoint(Boolean bJoint) {
        this.bJoint = bJoint;
    }

    public Integer getNAcctStatusID() {
        return nAcctStatusID;
    }

    public void setNAcctStatusID(Integer nAcctStatusID) {
        this.nAcctStatusID = nAcctStatusID;
    }

    public Date getDStartDate() {
        return dStartDate;
    }

    public void setDStartDate(Date dStartDate) {
        this.dStartDate = dStartDate;
    }

    public Date getDSysStartDate() {
        return dSysStartDate;
    }

    public void setDSysStartDate(Date dSysStartDate) {
        this.dSysStartDate = dSysStartDate;
    }

    public BigDecimal getNSysStartBalance() {
        return nSysStartBalance;
    }

    public void setNSysStartBalance(BigDecimal nSysStartBalance) {
        this.nSysStartBalance = nSysStartBalance;
    }

    public BigDecimal getNOpeningBalance() {
        return nOpeningBalance;
    }

    public void setNOpeningBalance(BigDecimal nOpeningBalance) {
        this.nOpeningBalance = nOpeningBalance;
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

    public BigDecimal getNNotCreditIntBalance() {
        return nNotCreditIntBalance;
    }

    public void setNNotCreditIntBalance(BigDecimal nNotCreditIntBalance) {
        this.nNotCreditIntBalance = nNotCreditIntBalance;
    }

    public BigDecimal getNActualBalance() {
        return nActualBalance;
    }

    public void setNActualBalance(BigDecimal nActualBalance) {
        this.nActualBalance = nActualBalance;
    }

    public BigDecimal getNAvailableBalance() {
        return nAvailableBalance;
    }

    public void setNAvailableBalance(BigDecimal nAvailableBalance) {
        this.nAvailableBalance = nAvailableBalance;
    }

    public BigDecimal getNFDIntialiDeposit() {
        return nFDIntialiDeposit;
    }

    public void setNFDIntialiDeposit(BigDecimal nFDIntialiDeposit) {
        this.nFDIntialiDeposit = nFDIntialiDeposit;
    }

    public Integer getNFDPeriod() {
        return nFDPeriod;
    }

    public void setNFDPeriod(Integer nFDPeriod) {
        this.nFDPeriod = nFDPeriod;
    }

    public Short getNFDPeriodTypeID() {
        return nFDPeriodTypeID;
    }

    public void setNFDPeriodTypeID(Short nFDPeriodTypeID) {
        this.nFDPeriodTypeID = nFDPeriodTypeID;
    }

    public Date getDFDMaturityDate() {
        return dFDMaturityDate;
    }

    public void setDFDMaturityDate(Date dFDMaturityDate) {
        this.dFDMaturityDate = dFDMaturityDate;
    }

    public BigDecimal getNFDMaturityValue() {
        return nFDMaturityValue;
    }

    public void setNFDMaturityValue(BigDecimal nFDMaturityValue) {
        this.nFDMaturityValue = nFDMaturityValue;
    }

    public String getCFDAgreementNo() {
        return cFDAgreementNo;
    }

    public void setCFDAgreementNo(String cFDAgreementNo) {
        this.cFDAgreementNo = cFDAgreementNo;
    }

    public Boolean getBFDComplete() {
        return bFDComplete;
    }

    public void setBFDComplete(Boolean bFDComplete) {
        this.bFDComplete = bFDComplete;
    }

    public Date getDFDCompleteDate() {
        return dFDCompleteDate;
    }

    public void setDFDCompleteDate(Date dFDCompleteDate) {
        this.dFDCompleteDate = dFDCompleteDate;
    }

    public Short getNFDClosingMethodID() {
        return nFDClosingMethodID;
    }

    public void setNFDClosingMethodID(Short nFDClosingMethodID) {
        this.nFDClosingMethodID = nFDClosingMethodID;
    }

    public Short getNFDIntCalMethodID() {
        return nFDIntCalMethodID;
    }

    public void setNFDIntCalMethodID(Short nFDIntCalMethodID) {
        this.nFDIntCalMethodID = nFDIntCalMethodID;
    }

    public Integer getNFDIntCalMethodValue() {
        return nFDIntCalMethodValue;
    }

    public void setNFDIntCalMethodValue(Integer nFDIntCalMethodValue) {
        this.nFDIntCalMethodValue = nFDIntCalMethodValue;
    }

    public Short getNFDIntCRMethodID() {
        return nFDIntCRMethodID;
    }

    public void setNFDIntCRMethodID(Short nFDIntCRMethodID) {
        this.nFDIntCRMethodID = nFDIntCRMethodID;
    }

    public Integer getNFDIntCRMethodValue() {
        return nFDIntCRMethodValue;
    }

    public void setNFDIntCRMethodValue(Integer nFDIntCRMethodValue) {
        this.nFDIntCRMethodValue = nFDIntCRMethodValue;
    }

    public Boolean getBIntCreditingDiffAcc() {
        return bIntCreditingDiffAcc;
    }

    public void setBIntCreditingDiffAcc(Boolean bIntCreditingDiffAcc) {
        this.bIntCreditingDiffAcc = bIntCreditingDiffAcc;
    }

    public BigInteger getNIntCRnDepMFID() {
        return nIntCRnDepMFID;
    }

    public void setNIntCRnDepMFID(BigInteger nIntCRnDepMFID) {
        this.nIntCRnDepMFID = nIntCRnDepMFID;
    }

    public Date getDLastIntCalDate() {
        return dLastIntCalDate;
    }

    public void setDLastIntCalDate(Date dLastIntCalDate) {
        this.dLastIntCalDate = dLastIntCalDate;
    }

    public Date getDLastUpdateDate() {
        return dLastUpdateDate;
    }

    public void setDLastUpdateDate(Date dLastUpdateDate) {
        this.dLastUpdateDate = dLastUpdateDate;
    }

    public BigInteger getNLastDepTrnID() {
        return nLastDepTrnID;
    }

    public void setNLastDepTrnID(BigInteger nLastDepTrnID) {
        this.nLastDepTrnID = nLastDepTrnID;
    }

    public Date getDNextFDIntCalDate() {
        return dNextFDIntCalDate;
    }

    public void setDNextFDIntCalDate(Date dNextFDIntCalDate) {
        this.dNextFDIntCalDate = dNextFDIntCalDate;
    }

    public Boolean getBAmtHolded() {
        return bAmtHolded;
    }

    public void setBAmtHolded(Boolean bAmtHolded) {
        this.bAmtHolded = bAmtHolded;
    }

    public BigDecimal getNHoldedAmount() {
        return nHoldedAmount;
    }

    public void setNHoldedAmount(BigDecimal nHoldedAmount) {
        this.nHoldedAmount = nHoldedAmount;
    }

    public Date getDHoldFromDate() {
        return dHoldFromDate;
    }

    public void setDHoldFromDate(Date dHoldFromDate) {
        this.dHoldFromDate = dHoldFromDate;
    }

    public Date getDHoldToDate() {
        return dHoldToDate;
    }

    public void setDHoldToDate(Date dHoldToDate) {
        this.dHoldToDate = dHoldToDate;
    }

    public Boolean getBIntHolded() {
        return bIntHolded;
    }

    public void setBIntHolded(Boolean bIntHolded) {
        this.bIntHolded = bIntHolded;
    }

    public BigDecimal getNHoldedAmountInt() {
        return nHoldedAmountInt;
    }

    public void setNHoldedAmountInt(BigDecimal nHoldedAmountInt) {
        this.nHoldedAmountInt = nHoldedAmountInt;
    }

    public Date getDIntHoldFromDate() {
        return dIntHoldFromDate;
    }

    public void setDIntHoldFromDate(Date dIntHoldFromDate) {
        this.dIntHoldFromDate = dIntHoldFromDate;
    }

    public Date getDIntHoldToDate() {
        return dIntHoldToDate;
    }

    public void setDIntHoldToDate(Date dIntHoldToDate) {
        this.dIntHoldToDate = dIntHoldToDate;
    }

    public BigInteger getNInstDRnDepMFID() {
        return nInstDRnDepMFID;
    }

    public void setNInstDRnDepMFID(BigInteger nInstDRnDepMFID) {
        this.nInstDRnDepMFID = nInstDRnDepMFID;
    }

    public BigDecimal getNInstDRValue() {
        return nInstDRValue;
    }

    public void setNInstDRValue(BigDecimal nInstDRValue) {
        this.nInstDRValue = nInstDRValue;
    }

    public Integer getNTDDepositPeriod() {
        return nTDDepositPeriod;
    }

    public void setNTDDepositPeriod(Integer nTDDepositPeriod) {
        this.nTDDepositPeriod = nTDDepositPeriod;
    }

    public BigDecimal getNTDAgreedAmount() {
        return nTDAgreedAmount;
    }

    public void setNTDAgreedAmount(BigDecimal nTDAgreedAmount) {
        this.nTDAgreedAmount = nTDAgreedAmount;
    }

    public Integer getNTDPaymentDay() {
        return nTDPaymentDay;
    }

    public void setNTDPaymentDay(Integer nTDPaymentDay) {
        this.nTDPaymentDay = nTDPaymentDay;
    }

    public Date getDActCloseDate() {
        return dActCloseDate;
    }

    public void setDActCloseDate(Date dActCloseDate) {
        this.dActCloseDate = dActCloseDate;
    }

    public Integer getNNominatorRelationshipID() {
        return nNominatorRelationshipID;
    }

    public void setNNominatorRelationshipID(Integer nNominatorRelationshipID) {
        this.nNominatorRelationshipID = nNominatorRelationshipID;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public String getCGarbageBy() {
        return cGarbageBy;
    }

    public void setCGarbageBy(String cGarbageBy) {
        this.cGarbageBy = cGarbageBy;
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

    public Boolean getBEditConfirm() {
        return bEditConfirm;
    }

    public void setBEditConfirm(Boolean bEditConfirm) {
        this.bEditConfirm = bEditConfirm;
    }

    public Date getDConfirmDate() {
        return dConfirmDate;
    }

    public void setDConfirmDate(Date dConfirmDate) {
        this.dConfirmDate = dConfirmDate;
    }

    public String getCConfirmBy() {
        return cConfirmBy;
    }

    public void setCConfirmBy(String cConfirmBy) {
        this.cConfirmBy = cConfirmBy;
    }

    public Boolean getBInAudit() {
        return bInAudit;
    }

    public void setBInAudit(Boolean bInAudit) {
        this.bInAudit = bInAudit;
    }

    public Boolean getBOutAudit() {
        return bOutAudit;
    }

    public void setBOutAudit(Boolean bOutAudit) {
        this.bOutAudit = bOutAudit;
    }

    public Date getDInAuditDate() {
        return dInAuditDate;
    }

    public void setDInAuditDate(Date dInAuditDate) {
        this.dInAuditDate = dInAuditDate;
    }

    public Date getDOutAuditDate() {
        return dOutAuditDate;
    }

    public void setDOutAuditDate(Date dOutAuditDate) {
        this.dOutAuditDate = dOutAuditDate;
    }

    public String getCInAuditBy() {
        return cInAuditBy;
    }

    public void setCInAuditBy(String cInAuditBy) {
        this.cInAuditBy = cInAuditBy;
    }

    public String getCOutAuditBy() {
        return cOutAuditBy;
    }

    public void setCOutAuditBy(String cOutAuditBy) {
        this.cOutAuditBy = cOutAuditBy;
    }

    public short getBGarbage() {
        return bGarbage;
    }

    public void setBGarbage(short bGarbage) {
        this.bGarbage = bGarbage;
    }

    public String getCNominatorFullName() {
        return cNominatorFullName;
    }

    public void setCNominatorFullName(String cNominatorFullName) {
        this.cNominatorFullName = cNominatorFullName;
    }

    public Date getDGarbageDate() {
        return dGarbageDate;
    }

    public void setDGarbageDate(Date dGarbageDate) {
        this.dGarbageDate = dGarbageDate;
    }

    public BigDecimal getNQ1MinBalance() {
        return nQ1MinBalance;
    }

    public void setNQ1MinBalance(BigDecimal nQ1MinBalance) {
        this.nQ1MinBalance = nQ1MinBalance;
    }

    public BigDecimal getNQ2MinBalance() {
        return nQ2MinBalance;
    }

    public void setNQ2MinBalance(BigDecimal nQ2MinBalance) {
        this.nQ2MinBalance = nQ2MinBalance;
    }

    public BigDecimal getNQ3MinBalance() {
        return nQ3MinBalance;
    }

    public void setNQ3MinBalance(BigDecimal nQ3MinBalance) {
        this.nQ3MinBalance = nQ3MinBalance;
    }

    public BigDecimal getNQ4MinBalance() {
        return nQ4MinBalance;
    }

    public void setNQ4MinBalance(BigDecimal nQ4MinBalance) {
        this.nQ4MinBalance = nQ4MinBalance;
    }

    public BigDecimal getNM1MinBalance() {
        return nM1MinBalance;
    }

    public void setNM1MinBalance(BigDecimal nM1MinBalance) {
        this.nM1MinBalance = nM1MinBalance;
    }

    public BigDecimal getNM2MinBalance() {
        return nM2MinBalance;
    }

    public void setNM2MinBalance(BigDecimal nM2MinBalance) {
        this.nM2MinBalance = nM2MinBalance;
    }

    public BigDecimal getNM3MinBalance() {
        return nM3MinBalance;
    }

    public void setNM3MinBalance(BigDecimal nM3MinBalance) {
        this.nM3MinBalance = nM3MinBalance;
    }

    public BigDecimal getNM4MinBalance() {
        return nM4MinBalance;
    }

    public void setNM4MinBalance(BigDecimal nM4MinBalance) {
        this.nM4MinBalance = nM4MinBalance;
    }

    public BigDecimal getNM5MinBalance() {
        return nM5MinBalance;
    }

    public void setNM5MinBalance(BigDecimal nM5MinBalance) {
        this.nM5MinBalance = nM5MinBalance;
    }

    public BigDecimal getNM6MinBalance() {
        return nM6MinBalance;
    }

    public void setNM6MinBalance(BigDecimal nM6MinBalance) {
        this.nM6MinBalance = nM6MinBalance;
    }

    public BigDecimal getNM7MinBalance() {
        return nM7MinBalance;
    }

    public void setNM7MinBalance(BigDecimal nM7MinBalance) {
        this.nM7MinBalance = nM7MinBalance;
    }

    public BigDecimal getNM8MinBalance() {
        return nM8MinBalance;
    }

    public void setNM8MinBalance(BigDecimal nM8MinBalance) {
        this.nM8MinBalance = nM8MinBalance;
    }

    public BigDecimal getNM9MinBalance() {
        return nM9MinBalance;
    }

    public void setNM9MinBalance(BigDecimal nM9MinBalance) {
        this.nM9MinBalance = nM9MinBalance;
    }

    public BigDecimal getNM10MinBalance() {
        return nM10MinBalance;
    }

    public void setNM10MinBalance(BigDecimal nM10MinBalance) {
        this.nM10MinBalance = nM10MinBalance;
    }

    public BigDecimal getNM11MinBalance() {
        return nM11MinBalance;
    }

    public void setNM11MinBalance(BigDecimal nM11MinBalance) {
        this.nM11MinBalance = nM11MinBalance;
    }

    public BigDecimal getNM12MinBalance() {
        return nM12MinBalance;
    }

    public void setNM12MinBalance(BigDecimal nM12MinBalance) {
        this.nM12MinBalance = nM12MinBalance;
    }

    public BnkCustomerMaster getNCustomerID() {
        return nCustomerID;
    }

    public void setNCustomerID(BnkCustomerMaster nCustomerID) {
        this.nCustomerID = nCustomerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepMFID != null ? nDepMFID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositMaster)) {
            return false;
        }
        BnkDepDepositMaster other = (BnkDepDepositMaster) object;
        if ((this.nDepMFID == null && other.nDepMFID != null) || (this.nDepMFID != null && !this.nDepMFID.equals(other.nDepMFID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.dao.hiuiuhiujk.BnkDepDepositMaster[ nDepMFID=" + nDepMFID + " ]";
    }
    
}
