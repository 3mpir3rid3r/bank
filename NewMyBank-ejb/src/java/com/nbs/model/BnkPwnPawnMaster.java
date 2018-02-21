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
@Table(name = "bnk_Pwn_PawnMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnPawnMaster.findAll", query = "SELECT b FROM BnkPwnPawnMaster b")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnMasterID", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnMasterID = :nPwnMasterID")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnTypeID", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnTypeID = :nPwnTypeID")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNBankBranchID", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nBankBranchID = :nBankBranchID")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByBOldPawn", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.bOldPawn = :bOldPawn")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDPwnDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dPwnDate = :dPwnDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByTPwnTime", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.tPwnTime = :tPwnTime")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPwnTicketNo", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPwnTicketNo = :cPwnTicketNo")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCReceiptNo", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cReceiptNo = :cReceiptNo")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCSerialNo", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cSerialNo = :cSerialNo")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNLedgerBookNo", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nLedgerBookNo = :nLedgerBookNo")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCInitials", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cInitials = :cInitials")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCFullName", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cFullName = :cFullName")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCLastName", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cLastName = :cLastName")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNIDType", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nIDType = :nIDType")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCIDNo", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cIDNo = :cIDNo")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDIssueDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dIssueDate = :dIssueDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDExpDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dExpDate = :dExpDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPAddLine1", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPAddLine1 = :cPAddLine1")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPAddLine2", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPAddLine2 = :cPAddLine2")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPAddLine3", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPAddLine3 = :cPAddLine3")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPAddLine4", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPAddLine4 = :cPAddLine4")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPTelNo1", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPTelNo1 = :cPTelNo1")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPTelNo2", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPTelNo2 = :cPTelNo2")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnDescriptionID", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnDescriptionID = :nPwnDescriptionID")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotWgtArt", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotWgtArt = :nTotWgtArt")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotWgtGold", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotWgtGold = :nTotWgtGold")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotMkrtValue", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotMkrtValue = :nTotMkrtValue")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNOneGramAssessedValue", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nOneGramAssessedValue = :nOneGramAssessedValue")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotAssessedValue", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotAssessedValue = :nTotAssessedValue")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnIntCatID", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnIntCatID = :nPwnIntCatID")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNActualInt", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nActualInt = :nActualInt")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNEffectiveInt", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nEffectiveInt = :nEffectiveInt")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnPeriodTypeID", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnPeriodTypeID = :nPwnPeriodTypeID")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnPeriod", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnPeriod = :nPwnPeriod")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDMaturityDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dMaturityDate = :dMaturityDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnAdvancedIssued", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnAdvancedIssued = :nPwnAdvancedIssued")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNInsuredAmount", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nInsuredAmount = :nInsuredAmount")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNExpectingInterest", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nExpectingInterest = :nExpectingInterest")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNOpeningBalance", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nOpeningBalance = :nOpeningBalance")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDSysOpenDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dSysOpenDate = :dSysOpenDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNSysOpenBalance", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nSysOpenBalance = :nSysOpenBalance")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNSysOpenPaidInt", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nSysOpenPaidInt = :nSysOpenPaidInt")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDLastCapitalPayDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dLastCapitalPayDate = :dLastCapitalPayDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDLastIntPayDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dLastIntPayDate = :dLastIntPayDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDNextRecoveryDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dNextRecoveryDate = :dNextRecoveryDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNPwnBalanceAmount", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nPwnBalanceAmount = :nPwnBalanceAmount")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotRecvCapital", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotRecvCapital = :nTotRecvCapital")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotRecvInterest", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotRecvInterest = :nTotRecvInterest")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotRecvStationary", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotRecvStationary = :nTotRecvStationary")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotRecvPostage", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotRecvPostage = :nTotRecvPostage")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNTotRecvAuctionFee", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nTotRecvAuctionFee = :nTotRecvAuctionFee")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNToDateDueDays", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nToDateDueDays = :nToDateDueDays")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNToDateCapital", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nToDateCapital = :nToDateCapital")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNToDateIntValue", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nToDateIntValue = :nToDateIntValue")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNToDateStationary", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nToDateStationary = :nToDateStationary")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNToDatePostage", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nToDatePostage = :nToDatePostage")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNToDateAuctionFee", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nToDateAuctionFee = :nToDateAuctionFee")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCRemrks", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cRemrks = :cRemrks")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCPurpose", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cPurpose = :cPurpose")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCValuer", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cValuer = :cValuer")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCAuthOfficer", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cAuthOfficer = :cAuthOfficer")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCInputBy", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cInputBy = :cInputBy")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDInputDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dInputDate = :dInputDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCEditBy", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cEditBy = :cEditBy")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDEditDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dEditDate = :dEditDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByBComplete", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.bComplete = :bComplete")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDComDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dComDate = :dComDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByBAuctionSelect", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.bAuctionSelect = :bAuctionSelect")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDAuctionSelectDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dAuctionSelectDate = :dAuctionSelectDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDAuctionDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dAuctionDate = :dAuctionDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCAuctionBuyerName", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cAuctionBuyerName = :cAuctionBuyerName")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNAuctionInterest", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nAuctionInterest = :nAuctionInterest")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNAuctionPost", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nAuctionPost = :nAuctionPost")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNAuctionSta", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nAuctionSta = :nAuctionSta")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNAuctionAuctCharges", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nAuctionAuctCharges = :nAuctionAuctCharges")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNAuctionReceivedAmount", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nAuctionReceivedAmount = :nAuctionReceivedAmount")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByNAuctionBalance", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.nAuctionBalance = :nAuctionBalance")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByBAuctionComplete", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.bAuctionComplete = :bAuctionComplete")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDAuctionCompleteDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dAuctionCompleteDate = :dAuctionCompleteDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCAuctionCompleteUsre", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cAuctionCompleteUsre = :cAuctionCompleteUsre")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByBGarbage", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.bGarbage = :bGarbage")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCReason", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cReason = :cReason")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByBInAudit", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.bInAudit = :bInAudit")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByBOutAudit", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.bOutAudit = :bOutAudit")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDInAuditDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dInAuditDate = :dInAuditDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByDOutAuditDate", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.dOutAuditDate = :dOutAuditDate")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCInAuditBy", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cInAuditBy = :cInAuditBy")
    , @NamedQuery(name = "BnkPwnPawnMaster.findByCOutAuditBy", query = "SELECT b FROM BnkPwnPawnMaster b WHERE b.cOutAuditBy = :cOutAuditBy")})
public class BnkPwnPawnMaster implements Serializable {

    @Size(max = 100)
    @Column(name = "cPictureFileName")
    private String cPictureFileName;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnMasterID")
    private Long nPwnMasterID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnTypeID")
    private int nPwnTypeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nBankBranchID")
    private int nBankBranchID;
    @Column(name = "bOldPawn")
    private Boolean bOldPawn;
    @Column(name = "dPwnDate")
    @Temporal(TemporalType.DATE)
    private Date dPwnDate;
    @Column(name = "tPwnTime")
    @Temporal(TemporalType.TIME)
    private Date tPwnTime;
    @Size(max = 10)
    @Column(name = "cPwnTicketNo")
    private String cPwnTicketNo;
    @Size(max = 50)
    @Column(name = "cReceiptNo")
    private String cReceiptNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cSerialNo")
    private String cSerialNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLedgerBookNo")
    private short nLedgerBookNo;
    @Size(max = 50)
    @Column(name = "cInitials")
    private String cInitials;
    @Size(max = 200)
    @Column(name = "cFullName")
    private String cFullName;
    @Size(max = 100)
    @Column(name = "cLastName")
    private String cLastName;
    @Column(name = "nIDType")
    private Integer nIDType;
    @Size(max = 10)
    @Column(name = "cIDNo")
    private String cIDNo;
    @Column(name = "dIssueDate")
    @Temporal(TemporalType.DATE)
    private Date dIssueDate;
    @Column(name = "dExpDate")
    @Temporal(TemporalType.DATE)
    private Date dExpDate;
    @Size(max = 100)
    @Column(name = "cPAddLine1")
    private String cPAddLine1;
    @Size(max = 100)
    @Column(name = "cPAddLine2")
    private String cPAddLine2;
    @Size(max = 100)
    @Column(name = "cPAddLine3")
    private String cPAddLine3;
    @Size(max = 100)
    @Column(name = "cPAddLine4")
    private String cPAddLine4;
    @Size(max = 50)
    @Column(name = "cPTelNo1")
    private String cPTelNo1;
    @Size(max = 50)
    @Column(name = "cPTelNo2")
    private String cPTelNo2;
    @Column(name = "nPwnDescriptionID")
    private Integer nPwnDescriptionID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotWgtArt")
    private BigDecimal nTotWgtArt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotWgtGold")
    private BigDecimal nTotWgtGold;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotMkrtValue")
    private BigDecimal nTotMkrtValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nOneGramAssessedValue")
    private BigDecimal nOneGramAssessedValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotAssessedValue")
    private BigDecimal nTotAssessedValue;
    @Column(name = "nPwnIntCatID")
    private Integer nPwnIntCatID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nActualInt")
    private BigDecimal nActualInt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nEffectiveInt")
    private BigDecimal nEffectiveInt;
    @Column(name = "nPwnPeriodTypeID")
    private Short nPwnPeriodTypeID;
    @Column(name = "nPwnPeriod")
    private Integer nPwnPeriod;
    @Column(name = "dMaturityDate")
    @Temporal(TemporalType.DATE)
    private Date dMaturityDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnAdvancedIssued")
    private BigDecimal nPwnAdvancedIssued;
    @Column(name = "nInsuredAmount")
    private BigDecimal nInsuredAmount;
    @Column(name = "nExpectingInterest")
    private BigDecimal nExpectingInterest;
    @Column(name = "nOpeningBalance")
    private BigDecimal nOpeningBalance;
    @Column(name = "dSysOpenDate")
    @Temporal(TemporalType.DATE)
    private Date dSysOpenDate;
    @Column(name = "nSysOpenBalance")
    private BigDecimal nSysOpenBalance;
    @Column(name = "nSysOpenPaidInt")
    private BigDecimal nSysOpenPaidInt;
    @Column(name = "dLastCapitalPayDate")
    @Temporal(TemporalType.DATE)
    private Date dLastCapitalPayDate;
    @Column(name = "dLastIntPayDate")
    @Temporal(TemporalType.DATE)
    private Date dLastIntPayDate;
    @Column(name = "dNextRecoveryDate")
    @Temporal(TemporalType.DATE)
    private Date dNextRecoveryDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnBalance_Amount")
    private BigDecimal nPwnBalanceAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Capital")
    private BigDecimal nTotRecvCapital;
    @Column(name = "nTotRecv_Interest")
    private BigDecimal nTotRecvInterest;
    @Column(name = "nTotRecv_Stationary")
    private BigDecimal nTotRecvStationary;
    @Column(name = "nTotRecv_Postage")
    private BigDecimal nTotRecvPostage;
    @Column(name = "nTotRecv_AuctionFee")
    private BigDecimal nTotRecvAuctionFee;
    @Column(name = "nToDateDue_Days")
    private Integer nToDateDueDays;
    @Column(name = "nToDate_Capital")
    private BigDecimal nToDateCapital;
    @Column(name = "nToDateInt_Value")
    private BigDecimal nToDateIntValue;
    @Column(name = "nToDate_Stationary")
    private BigDecimal nToDateStationary;
    @Column(name = "nToDate_Postage")
    private BigDecimal nToDatePostage;
    @Column(name = "nToDate_AuctionFee")
    private BigDecimal nToDateAuctionFee;
    @Size(max = 150)
    @Column(name = "cRemrks")
    private String cRemrks;
    @Size(max = 150)
    @Column(name = "cPurpose")
    private String cPurpose;
    @Size(max = 25)
    @Column(name = "cValuer")
    private String cValuer;
    @Size(max = 25)
    @Column(name = "cAuthOfficer")
    private String cAuthOfficer;
    @Size(max = 25)
    @Column(name = "cInputBy")
    private String cInputBy;
    @Column(name = "dInputDate")
    @Temporal(TemporalType.DATE)
    private Date dInputDate;
    @Size(max = 25)
    @Column(name = "cEditBy")
    private String cEditBy;
    @Column(name = "dEditDate")
    @Temporal(TemporalType.DATE)
    private Date dEditDate;
    @Column(name = "bComplete")
    private Boolean bComplete;
    @Column(name = "dComDate")
    @Temporal(TemporalType.DATE)
    private Date dComDate;
    @Column(name = "bAuctionSelect")
    private Boolean bAuctionSelect;
    @Column(name = "dAuctionSelect_Date")
    @Temporal(TemporalType.DATE)
    private Date dAuctionSelectDate;
    @Column(name = "dAuction_Date")
    @Temporal(TemporalType.DATE)
    private Date dAuctionDate;
    @Size(max = 50)
    @Column(name = "cAuction_BuyerName")
    private String cAuctionBuyerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAuction_Interest")
    private BigDecimal nAuctionInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAuction_Post")
    private BigDecimal nAuctionPost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAuction_Sta")
    private BigDecimal nAuctionSta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAuction_AuctCharges")
    private BigDecimal nAuctionAuctCharges;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAuction_ReceivedAmount")
    private BigDecimal nAuctionReceivedAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAuction_Balance")
    private BigDecimal nAuctionBalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bAuctionComplete")
    private boolean bAuctionComplete;
    @Column(name = "dAuctionComplete_Date")
    @Temporal(TemporalType.DATE)
    private Date dAuctionCompleteDate;
    @Size(max = 50)
    @Column(name = "cAuctionComplete_Usre")
    private String cAuctionCompleteUsre;
    @Column(name = "bGarbage")
    private Boolean bGarbage;
    @Size(max = 50)
    @Column(name = "cReason")
    private String cReason;
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

    public BnkPwnPawnMaster() {
    }

    public BnkPwnPawnMaster(Long nPwnMasterID) {
        this.nPwnMasterID = nPwnMasterID;
    }

    public BnkPwnPawnMaster(Long nPwnMasterID, int nPwnTypeID, int nBankBranchID, String cSerialNo, short nLedgerBookNo, BigDecimal nTotWgtArt, BigDecimal nTotWgtGold, BigDecimal nTotMkrtValue, BigDecimal nOneGramAssessedValue, BigDecimal nTotAssessedValue, BigDecimal nActualInt, BigDecimal nEffectiveInt, BigDecimal nPwnAdvancedIssued, BigDecimal nPwnBalanceAmount, BigDecimal nTotRecvCapital, BigDecimal nAuctionInterest, BigDecimal nAuctionPost, BigDecimal nAuctionSta, BigDecimal nAuctionAuctCharges, BigDecimal nAuctionReceivedAmount, BigDecimal nAuctionBalance, boolean bAuctionComplete) {
        this.nPwnMasterID = nPwnMasterID;
        this.nPwnTypeID = nPwnTypeID;
        this.nBankBranchID = nBankBranchID;
        this.cSerialNo = cSerialNo;
        this.nLedgerBookNo = nLedgerBookNo;
        this.nTotWgtArt = nTotWgtArt;
        this.nTotWgtGold = nTotWgtGold;
        this.nTotMkrtValue = nTotMkrtValue;
        this.nOneGramAssessedValue = nOneGramAssessedValue;
        this.nTotAssessedValue = nTotAssessedValue;
        this.nActualInt = nActualInt;
        this.nEffectiveInt = nEffectiveInt;
        this.nPwnAdvancedIssued = nPwnAdvancedIssued;
        this.nPwnBalanceAmount = nPwnBalanceAmount;
        this.nTotRecvCapital = nTotRecvCapital;
        this.nAuctionInterest = nAuctionInterest;
        this.nAuctionPost = nAuctionPost;
        this.nAuctionSta = nAuctionSta;
        this.nAuctionAuctCharges = nAuctionAuctCharges;
        this.nAuctionReceivedAmount = nAuctionReceivedAmount;
        this.nAuctionBalance = nAuctionBalance;
        this.bAuctionComplete = bAuctionComplete;
    }

    public Long getNPwnMasterID() {
        return nPwnMasterID;
    }

    public void setNPwnMasterID(Long nPwnMasterID) {
        this.nPwnMasterID = nPwnMasterID;
    }

    public int getNPwnTypeID() {
        return nPwnTypeID;
    }

    public void setNPwnTypeID(int nPwnTypeID) {
        this.nPwnTypeID = nPwnTypeID;
    }

    public int getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(int nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public Boolean getBOldPawn() {
        return bOldPawn;
    }

    public void setBOldPawn(Boolean bOldPawn) {
        this.bOldPawn = bOldPawn;
    }

    public Date getDPwnDate() {
        return dPwnDate;
    }

    public void setDPwnDate(Date dPwnDate) {
        this.dPwnDate = dPwnDate;
    }

    public Date getTPwnTime() {
        return tPwnTime;
    }

    public void setTPwnTime(Date tPwnTime) {
        this.tPwnTime = tPwnTime;
    }

    public String getCPwnTicketNo() {
        return cPwnTicketNo;
    }

    public void setCPwnTicketNo(String cPwnTicketNo) {
        this.cPwnTicketNo = cPwnTicketNo;
    }

    public String getCReceiptNo() {
        return cReceiptNo;
    }

    public void setCReceiptNo(String cReceiptNo) {
        this.cReceiptNo = cReceiptNo;
    }

    public String getCSerialNo() {
        return cSerialNo;
    }

    public void setCSerialNo(String cSerialNo) {
        this.cSerialNo = cSerialNo;
    }

    public short getNLedgerBookNo() {
        return nLedgerBookNo;
    }

    public void setNLedgerBookNo(short nLedgerBookNo) {
        this.nLedgerBookNo = nLedgerBookNo;
    }

    public String getCInitials() {
        return cInitials;
    }

    public void setCInitials(String cInitials) {
        this.cInitials = cInitials;
    }

    public String getCFullName() {
        return cFullName;
    }

    public void setCFullName(String cFullName) {
        this.cFullName = cFullName;
    }

    public String getCLastName() {
        return cLastName;
    }

    public void setCLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public Integer getNIDType() {
        return nIDType;
    }

    public void setNIDType(Integer nIDType) {
        this.nIDType = nIDType;
    }

    public String getCIDNo() {
        return cIDNo;
    }

    public void setCIDNo(String cIDNo) {
        this.cIDNo = cIDNo;
    }

    public Date getDIssueDate() {
        return dIssueDate;
    }

    public void setDIssueDate(Date dIssueDate) {
        this.dIssueDate = dIssueDate;
    }

    public Date getDExpDate() {
        return dExpDate;
    }

    public void setDExpDate(Date dExpDate) {
        this.dExpDate = dExpDate;
    }

    public String getCPAddLine1() {
        return cPAddLine1;
    }

    public void setCPAddLine1(String cPAddLine1) {
        this.cPAddLine1 = cPAddLine1;
    }

    public String getCPAddLine2() {
        return cPAddLine2;
    }

    public void setCPAddLine2(String cPAddLine2) {
        this.cPAddLine2 = cPAddLine2;
    }

    public String getCPAddLine3() {
        return cPAddLine3;
    }

    public void setCPAddLine3(String cPAddLine3) {
        this.cPAddLine3 = cPAddLine3;
    }

    public String getCPAddLine4() {
        return cPAddLine4;
    }

    public void setCPAddLine4(String cPAddLine4) {
        this.cPAddLine4 = cPAddLine4;
    }

    public String getCPTelNo1() {
        return cPTelNo1;
    }

    public void setCPTelNo1(String cPTelNo1) {
        this.cPTelNo1 = cPTelNo1;
    }

    public String getCPTelNo2() {
        return cPTelNo2;
    }

    public void setCPTelNo2(String cPTelNo2) {
        this.cPTelNo2 = cPTelNo2;
    }

    public Integer getNPwnDescriptionID() {
        return nPwnDescriptionID;
    }

    public void setNPwnDescriptionID(Integer nPwnDescriptionID) {
        this.nPwnDescriptionID = nPwnDescriptionID;
    }

    public BigDecimal getNTotWgtArt() {
        return nTotWgtArt;
    }

    public void setNTotWgtArt(BigDecimal nTotWgtArt) {
        this.nTotWgtArt = nTotWgtArt;
    }

    public BigDecimal getNTotWgtGold() {
        return nTotWgtGold;
    }

    public void setNTotWgtGold(BigDecimal nTotWgtGold) {
        this.nTotWgtGold = nTotWgtGold;
    }

    public BigDecimal getNTotMkrtValue() {
        return nTotMkrtValue;
    }

    public void setNTotMkrtValue(BigDecimal nTotMkrtValue) {
        this.nTotMkrtValue = nTotMkrtValue;
    }

    public BigDecimal getNOneGramAssessedValue() {
        return nOneGramAssessedValue;
    }

    public void setNOneGramAssessedValue(BigDecimal nOneGramAssessedValue) {
        this.nOneGramAssessedValue = nOneGramAssessedValue;
    }

    public BigDecimal getNTotAssessedValue() {
        return nTotAssessedValue;
    }

    public void setNTotAssessedValue(BigDecimal nTotAssessedValue) {
        this.nTotAssessedValue = nTotAssessedValue;
    }

    public Integer getNPwnIntCatID() {
        return nPwnIntCatID;
    }

    public void setNPwnIntCatID(Integer nPwnIntCatID) {
        this.nPwnIntCatID = nPwnIntCatID;
    }

    public BigDecimal getNActualInt() {
        return nActualInt;
    }

    public void setNActualInt(BigDecimal nActualInt) {
        this.nActualInt = nActualInt;
    }

    public BigDecimal getNEffectiveInt() {
        return nEffectiveInt;
    }

    public void setNEffectiveInt(BigDecimal nEffectiveInt) {
        this.nEffectiveInt = nEffectiveInt;
    }

    public Short getNPwnPeriodTypeID() {
        return nPwnPeriodTypeID;
    }

    public void setNPwnPeriodTypeID(Short nPwnPeriodTypeID) {
        this.nPwnPeriodTypeID = nPwnPeriodTypeID;
    }

    public Integer getNPwnPeriod() {
        return nPwnPeriod;
    }

    public void setNPwnPeriod(Integer nPwnPeriod) {
        this.nPwnPeriod = nPwnPeriod;
    }

    public Date getDMaturityDate() {
        return dMaturityDate;
    }

    public void setDMaturityDate(Date dMaturityDate) {
        this.dMaturityDate = dMaturityDate;
    }

    public BigDecimal getNPwnAdvancedIssued() {
        return nPwnAdvancedIssued;
    }

    public void setNPwnAdvancedIssued(BigDecimal nPwnAdvancedIssued) {
        this.nPwnAdvancedIssued = nPwnAdvancedIssued;
    }

    public BigDecimal getNInsuredAmount() {
        return nInsuredAmount;
    }

    public void setNInsuredAmount(BigDecimal nInsuredAmount) {
        this.nInsuredAmount = nInsuredAmount;
    }

    public BigDecimal getNExpectingInterest() {
        return nExpectingInterest;
    }

    public void setNExpectingInterest(BigDecimal nExpectingInterest) {
        this.nExpectingInterest = nExpectingInterest;
    }

    public BigDecimal getNOpeningBalance() {
        return nOpeningBalance;
    }

    public void setNOpeningBalance(BigDecimal nOpeningBalance) {
        this.nOpeningBalance = nOpeningBalance;
    }

    public Date getDSysOpenDate() {
        return dSysOpenDate;
    }

    public void setDSysOpenDate(Date dSysOpenDate) {
        this.dSysOpenDate = dSysOpenDate;
    }

    public BigDecimal getNSysOpenBalance() {
        return nSysOpenBalance;
    }

    public void setNSysOpenBalance(BigDecimal nSysOpenBalance) {
        this.nSysOpenBalance = nSysOpenBalance;
    }

    public BigDecimal getNSysOpenPaidInt() {
        return nSysOpenPaidInt;
    }

    public void setNSysOpenPaidInt(BigDecimal nSysOpenPaidInt) {
        this.nSysOpenPaidInt = nSysOpenPaidInt;
    }

    public Date getDLastCapitalPayDate() {
        return dLastCapitalPayDate;
    }

    public void setDLastCapitalPayDate(Date dLastCapitalPayDate) {
        this.dLastCapitalPayDate = dLastCapitalPayDate;
    }

    public Date getDLastIntPayDate() {
        return dLastIntPayDate;
    }

    public void setDLastIntPayDate(Date dLastIntPayDate) {
        this.dLastIntPayDate = dLastIntPayDate;
    }

    public Date getDNextRecoveryDate() {
        return dNextRecoveryDate;
    }

    public void setDNextRecoveryDate(Date dNextRecoveryDate) {
        this.dNextRecoveryDate = dNextRecoveryDate;
    }

    public BigDecimal getNPwnBalanceAmount() {
        return nPwnBalanceAmount;
    }

    public void setNPwnBalanceAmount(BigDecimal nPwnBalanceAmount) {
        this.nPwnBalanceAmount = nPwnBalanceAmount;
    }

    public BigDecimal getNTotRecvCapital() {
        return nTotRecvCapital;
    }

    public void setNTotRecvCapital(BigDecimal nTotRecvCapital) {
        this.nTotRecvCapital = nTotRecvCapital;
    }

    public BigDecimal getNTotRecvInterest() {
        return nTotRecvInterest;
    }

    public void setNTotRecvInterest(BigDecimal nTotRecvInterest) {
        this.nTotRecvInterest = nTotRecvInterest;
    }

    public BigDecimal getNTotRecvStationary() {
        return nTotRecvStationary;
    }

    public void setNTotRecvStationary(BigDecimal nTotRecvStationary) {
        this.nTotRecvStationary = nTotRecvStationary;
    }

    public BigDecimal getNTotRecvPostage() {
        return nTotRecvPostage;
    }

    public void setNTotRecvPostage(BigDecimal nTotRecvPostage) {
        this.nTotRecvPostage = nTotRecvPostage;
    }

    public BigDecimal getNTotRecvAuctionFee() {
        return nTotRecvAuctionFee;
    }

    public void setNTotRecvAuctionFee(BigDecimal nTotRecvAuctionFee) {
        this.nTotRecvAuctionFee = nTotRecvAuctionFee;
    }

    public Integer getNToDateDueDays() {
        return nToDateDueDays;
    }

    public void setNToDateDueDays(Integer nToDateDueDays) {
        this.nToDateDueDays = nToDateDueDays;
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

    public String getCRemrks() {
        return cRemrks;
    }

    public void setCRemrks(String cRemrks) {
        this.cRemrks = cRemrks;
    }

    public String getCPurpose() {
        return cPurpose;
    }

    public void setCPurpose(String cPurpose) {
        this.cPurpose = cPurpose;
    }

    public String getCValuer() {
        return cValuer;
    }

    public void setCValuer(String cValuer) {
        this.cValuer = cValuer;
    }

    public String getCAuthOfficer() {
        return cAuthOfficer;
    }

    public void setCAuthOfficer(String cAuthOfficer) {
        this.cAuthOfficer = cAuthOfficer;
    }

    public String getCInputBy() {
        return cInputBy;
    }

    public void setCInputBy(String cInputBy) {
        this.cInputBy = cInputBy;
    }

    public Date getDInputDate() {
        return dInputDate;
    }

    public void setDInputDate(Date dInputDate) {
        this.dInputDate = dInputDate;
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

    public Boolean getBComplete() {
        return bComplete;
    }

    public void setBComplete(Boolean bComplete) {
        this.bComplete = bComplete;
    }

    public Date getDComDate() {
        return dComDate;
    }

    public void setDComDate(Date dComDate) {
        this.dComDate = dComDate;
    }

    public Boolean getBAuctionSelect() {
        return bAuctionSelect;
    }

    public void setBAuctionSelect(Boolean bAuctionSelect) {
        this.bAuctionSelect = bAuctionSelect;
    }

    public Date getDAuctionSelectDate() {
        return dAuctionSelectDate;
    }

    public void setDAuctionSelectDate(Date dAuctionSelectDate) {
        this.dAuctionSelectDate = dAuctionSelectDate;
    }

    public Date getDAuctionDate() {
        return dAuctionDate;
    }

    public void setDAuctionDate(Date dAuctionDate) {
        this.dAuctionDate = dAuctionDate;
    }

    public String getCAuctionBuyerName() {
        return cAuctionBuyerName;
    }

    public void setCAuctionBuyerName(String cAuctionBuyerName) {
        this.cAuctionBuyerName = cAuctionBuyerName;
    }

    public BigDecimal getNAuctionInterest() {
        return nAuctionInterest;
    }

    public void setNAuctionInterest(BigDecimal nAuctionInterest) {
        this.nAuctionInterest = nAuctionInterest;
    }

    public BigDecimal getNAuctionPost() {
        return nAuctionPost;
    }

    public void setNAuctionPost(BigDecimal nAuctionPost) {
        this.nAuctionPost = nAuctionPost;
    }

    public BigDecimal getNAuctionSta() {
        return nAuctionSta;
    }

    public void setNAuctionSta(BigDecimal nAuctionSta) {
        this.nAuctionSta = nAuctionSta;
    }

    public BigDecimal getNAuctionAuctCharges() {
        return nAuctionAuctCharges;
    }

    public void setNAuctionAuctCharges(BigDecimal nAuctionAuctCharges) {
        this.nAuctionAuctCharges = nAuctionAuctCharges;
    }

    public BigDecimal getNAuctionReceivedAmount() {
        return nAuctionReceivedAmount;
    }

    public void setNAuctionReceivedAmount(BigDecimal nAuctionReceivedAmount) {
        this.nAuctionReceivedAmount = nAuctionReceivedAmount;
    }

    public BigDecimal getNAuctionBalance() {
        return nAuctionBalance;
    }

    public void setNAuctionBalance(BigDecimal nAuctionBalance) {
        this.nAuctionBalance = nAuctionBalance;
    }

    public boolean getBAuctionComplete() {
        return bAuctionComplete;
    }

    public void setBAuctionComplete(boolean bAuctionComplete) {
        this.bAuctionComplete = bAuctionComplete;
    }

    public Date getDAuctionCompleteDate() {
        return dAuctionCompleteDate;
    }

    public void setDAuctionCompleteDate(Date dAuctionCompleteDate) {
        this.dAuctionCompleteDate = dAuctionCompleteDate;
    }

    public String getCAuctionCompleteUsre() {
        return cAuctionCompleteUsre;
    }

    public void setCAuctionCompleteUsre(String cAuctionCompleteUsre) {
        this.cAuctionCompleteUsre = cAuctionCompleteUsre;
    }

    public Boolean getBGarbage() {
        return bGarbage;
    }

    public void setBGarbage(Boolean bGarbage) {
        this.bGarbage = bGarbage;
    }

    public String getCReason() {
        return cReason;
    }

    public void setCReason(String cReason) {
        this.cReason = cReason;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnMasterID != null ? nPwnMasterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnPawnMaster)) {
            return false;
        }
        BnkPwnPawnMaster other = (BnkPwnPawnMaster) object;
        if ((this.nPwnMasterID == null && other.nPwnMasterID != null) || (this.nPwnMasterID != null && !this.nPwnMasterID.equals(other.nPwnMasterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.common.BnkPwnPawnMaster[ nPwnMasterID=" + nPwnMasterID + " ]";
    }

    public String getCPictureFileName() {
        return cPictureFileName;
    }

    public void setCPictureFileName(String cPictureFileName) {
        this.cPictureFileName = cPictureFileName;
    }
    
}
