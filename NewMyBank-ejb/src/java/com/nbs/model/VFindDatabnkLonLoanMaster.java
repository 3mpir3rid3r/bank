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
@Table(name = "v_FindData_bnk_Lon_Loan_Master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findAll", query = "SELECT v FROM VFindDatabnkLonLoanMaster v"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNLonMFID", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nLonMFID = :nLonMFID"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCLonAccountNo", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cLonAccountNo = :cLonAccountNo"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCOldLonAccountNo", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cOldLonAccountNo = :cOldLonAccountNo"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByBJoint", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.bJoint = :bJoint"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCSysCode", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cSysCode = :cSysCode"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCLonName", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cLonName = :cLonName"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByDLoanDate", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.dLoanDate = :dLoanDate"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByDApprovedDate", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.dApprovedDate = :dApprovedDate"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNApprovedAmount", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nApprovedAmount = :nApprovedAmount"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNEffectiveInt", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nEffectiveInt = :nEffectiveInt"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNToDatePanaltyIntValue", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nToDatePanaltyIntValue = :nToDatePanaltyIntValue"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNToDatePanaltyIntSubjectAmount", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nToDatePanaltyIntSubjectAmount = :nToDatePanaltyIntSubjectAmount"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNInstallmentAmountAdj", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nInstallmentAmountAdj = :nInstallmentAmountAdj"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNLonBalanceAmount", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nLonBalanceAmount = :nLonBalanceAmount"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNCustomerID", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nCustomerID = :nCustomerID"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCNICNo", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cNICNo = :cNICNo"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCCIFNo", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cCIFNo = :cCIFNo"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCMemberShipNo", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cMemberShipNo = :cMemberShipNo"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNBankBranchID", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCFullName", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cFullName = :cFullName"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCUseName", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cUseName = :cUseName"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCPAddLine1", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cPAddLine1 = :cPAddLine1"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCPTelNo1", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cPTelNo1 = :cPTelNo1"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCFullNameAma", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cFullNameAma = :cFullNameAma"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNLonDescriptionID", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nLonDescriptionID = :nLonDescriptionID"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCLonDescription", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cLonDescription = :cLonDescription"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByCLonDescription2", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.cLonDescription2 = :cLonDescription2"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNToDateDueDays", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nToDateDueDays = :nToDateDueDays"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNToDateDueCapital", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nToDateDueCapital = :nToDateDueCapital"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNToDateIntValueRound", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nToDateIntValueRound = :nToDateIntValueRound"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNIssuedAmount", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nIssuedAmount = :nIssuedAmount"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNBalanceToIssue", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nBalanceToIssue = :nBalanceToIssue"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvCapital", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvCapital = :nTotRecvCapital"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvInstallment", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvInstallment = :nTotRecvInstallment"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNShouldRecvCapital", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nShouldRecvCapital = :nShouldRecvCapital"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNShouldRecvInstallment", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nShouldRecvInstallment = :nShouldRecvInstallment"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvInterest", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvInterest = :nTotRecvInterest"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNShouldRecvInterest", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nShouldRecvInterest = :nShouldRecvInterest"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNLonBalanceInstallment", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nLonBalanceInstallment = :nLonBalanceInstallment"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByDLastCapitalPayDate", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.dLastCapitalPayDate = :dLastCapitalPayDate"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByDLastIntPayDate", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.dLastIntPayDate = :dLastIntPayDate"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNToDateDueInstallment", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nToDateDueInstallment = :nToDateDueInstallment"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNToDateTotIntersest", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nToDateTotIntersest = :nToDateTotIntersest"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvOtherCharges", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvOtherCharges = :nTotRecvOtherCharges"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvPostage", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvPostage = :nTotRecvPostage"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvStationary", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvStationary = :nTotRecvStationary"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvArbitrationFees", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvArbitrationFees = :nTotRecvArbitrationFees"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNTotRecvCaurtFees", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nTotRecvCaurtFees = :nTotRecvCaurtFees"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNIssueToDepMFID", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nIssueToDepMFID = :nIssueToDepMFID"),
    @NamedQuery(name = "VFindDatabnkLonLoanMaster.findByNRecoverByDepMFID", query = "SELECT v FROM VFindDatabnkLonLoanMaster v WHERE v.nRecoverByDepMFID = :nRecoverByDepMFID")})
public class VFindDatabnkLonLoanMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonMFID")
    @Id
    private long nLonMFID;
    @Size(max = 13)
    @Column(name = "cLonAccountNo")
    private String cLonAccountNo;
    @Size(max = 13)
    @Column(name = "cOldLonAccountNo")
    private String cOldLonAccountNo;
    @Column(name = "bJoint")
    private Boolean bJoint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cSysCode")
    private String cSysCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cLonName")
    private String cLonName;
    @Column(name = "dLoanDate")
    @Temporal(TemporalType.DATE)
    private Date dLoanDate;
    @Column(name = "dApprovedDate")
    @Temporal(TemporalType.DATE)
    private Date dApprovedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nApprovedAmount")
    private BigDecimal nApprovedAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nEffectiveInt")
    private BigDecimal nEffectiveInt;
    @Column(name = "nToDatePanaltyInt_Value")
    private BigDecimal nToDatePanaltyIntValue;
    @Column(name = "nToDatePanaltyInt_SubjectAmount")
    private BigDecimal nToDatePanaltyIntSubjectAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nInstallmentAmount_Adj")
    private BigDecimal nInstallmentAmountAdj;
    @Column(name = "nLonBalance_Amount")
    private BigDecimal nLonBalanceAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCustomerID")
    private long nCustomerID;
    @Size(max = 20)
    @Column(name = "cNICNo")
    private String cNICNo;
    @Size(max = 8)
    @Column(name = "cCIFNo")
    private String cCIFNo;
    @Size(max = 10)
    @Column(name = "cMemberShipNo")
    private String cMemberShipNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nBankBranchID")
    private int nBankBranchID;
    @Size(max = 200)
    @Column(name = "cFullName")
    private String cFullName;
    @Size(max = 50)
    @Column(name = "cUseName")
    private String cUseName;
    @Size(max = 75)
    @Column(name = "cPAddLine1")
    private String cPAddLine1;
    @Size(max = 50)
    @Column(name = "cPTelNo1")
    private String cPTelNo1;
    @Size(max = 200)
    @Column(name = "cFullName_Ama")
    private String cFullNameAma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonDescriptionID")
    private int nLonDescriptionID;
    @Size(max = 50)
    @Column(name = "cLonDescription")
    private String cLonDescription;
    @Size(max = 50)
    @Column(name = "cLonDescription2")
    private String cLonDescription2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateDue_Days")
    private int nToDateDueDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateDue_Capital")
    private BigDecimal nToDateDueCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateInt_ValueRound")
    private BigDecimal nToDateIntValueRound;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIssuedAmount")
    private BigDecimal nIssuedAmount;
    @Column(name = "nBalanceToIssue")
    private BigDecimal nBalanceToIssue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Capital")
    private BigDecimal nTotRecvCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Installment")
    private BigDecimal nTotRecvInstallment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nShouldRecv_Capital")
    private BigDecimal nShouldRecvCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nShouldRecv_Installment")
    private BigDecimal nShouldRecvInstallment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Interest")
    private BigDecimal nTotRecvInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nShouldRecv_Interest")
    private BigDecimal nShouldRecvInterest;
    @Column(name = "nLonBalance_Installment")
    private BigDecimal nLonBalanceInstallment;
    @Column(name = "dLastCapitalPayDate")
    @Temporal(TemporalType.DATE)
    private Date dLastCapitalPayDate;
    @Column(name = "dLastIntPayDate")
    @Temporal(TemporalType.DATE)
    private Date dLastIntPayDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateDue_Installment")
    private BigDecimal nToDateDueInstallment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateTot_Intersest")
    private BigDecimal nToDateTotIntersest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_OtherCharges")
    private BigDecimal nTotRecvOtherCharges;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Postage")
    private BigDecimal nTotRecvPostage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Stationary")
    private BigDecimal nTotRecvStationary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_ArbitrationFees")
    private BigDecimal nTotRecvArbitrationFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_CaurtFees")
    private BigDecimal nTotRecvCaurtFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIssueTo_DepMFID")
    private long nIssueToDepMFID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nRecoverBy_DepMFID")
    private long nRecoverByDepMFID;

    public VFindDatabnkLonLoanMaster() {
    }

    public long getNLonMFID() {
        return nLonMFID;
    }

    public void setNLonMFID(long nLonMFID) {
        this.nLonMFID = nLonMFID;
    }

    public String getCLonAccountNo() {
        return cLonAccountNo;
    }

    public void setCLonAccountNo(String cLonAccountNo) {
        this.cLonAccountNo = cLonAccountNo;
    }

    public String getCOldLonAccountNo() {
        return cOldLonAccountNo;
    }

    public void setCOldLonAccountNo(String cOldLonAccountNo) {
        this.cOldLonAccountNo = cOldLonAccountNo;
    }

    public Boolean getBJoint() {
        return bJoint;
    }

    public void setBJoint(Boolean bJoint) {
        this.bJoint = bJoint;
    }

    public String getCSysCode() {
        return cSysCode;
    }

    public void setCSysCode(String cSysCode) {
        this.cSysCode = cSysCode;
    }

    public String getCLonName() {
        return cLonName;
    }

    public void setCLonName(String cLonName) {
        this.cLonName = cLonName;
    }

    public Date getDLoanDate() {
        return dLoanDate;
    }

    public void setDLoanDate(Date dLoanDate) {
        this.dLoanDate = dLoanDate;
    }

    public Date getDApprovedDate() {
        return dApprovedDate;
    }

    public void setDApprovedDate(Date dApprovedDate) {
        this.dApprovedDate = dApprovedDate;
    }

    public BigDecimal getNApprovedAmount() {
        return nApprovedAmount;
    }

    public void setNApprovedAmount(BigDecimal nApprovedAmount) {
        this.nApprovedAmount = nApprovedAmount;
    }

    public BigDecimal getNEffectiveInt() {
        return nEffectiveInt;
    }

    public void setNEffectiveInt(BigDecimal nEffectiveInt) {
        this.nEffectiveInt = nEffectiveInt;
    }

    public BigDecimal getNToDatePanaltyIntValue() {
        return nToDatePanaltyIntValue;
    }

    public void setNToDatePanaltyIntValue(BigDecimal nToDatePanaltyIntValue) {
        this.nToDatePanaltyIntValue = nToDatePanaltyIntValue;
    }

    public BigDecimal getNToDatePanaltyIntSubjectAmount() {
        return nToDatePanaltyIntSubjectAmount;
    }

    public void setNToDatePanaltyIntSubjectAmount(BigDecimal nToDatePanaltyIntSubjectAmount) {
        this.nToDatePanaltyIntSubjectAmount = nToDatePanaltyIntSubjectAmount;
    }

    public BigDecimal getNInstallmentAmountAdj() {
        return nInstallmentAmountAdj;
    }

    public void setNInstallmentAmountAdj(BigDecimal nInstallmentAmountAdj) {
        this.nInstallmentAmountAdj = nInstallmentAmountAdj;
    }

    public BigDecimal getNLonBalanceAmount() {
        return nLonBalanceAmount;
    }

    public void setNLonBalanceAmount(BigDecimal nLonBalanceAmount) {
        this.nLonBalanceAmount = nLonBalanceAmount;
    }

    public long getNCustomerID() {
        return nCustomerID;
    }

    public void setNCustomerID(long nCustomerID) {
        this.nCustomerID = nCustomerID;
    }

    public String getCNICNo() {
        return cNICNo;
    }

    public void setCNICNo(String cNICNo) {
        this.cNICNo = cNICNo;
    }

    public String getCCIFNo() {
        return cCIFNo;
    }

    public void setCCIFNo(String cCIFNo) {
        this.cCIFNo = cCIFNo;
    }

    public String getCMemberShipNo() {
        return cMemberShipNo;
    }

    public void setCMemberShipNo(String cMemberShipNo) {
        this.cMemberShipNo = cMemberShipNo;
    }

    public int getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(int nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public String getCFullName() {
        return cFullName;
    }

    public void setCFullName(String cFullName) {
        this.cFullName = cFullName;
    }

    public String getCUseName() {
        return cUseName;
    }

    public void setCUseName(String cUseName) {
        this.cUseName = cUseName;
    }

    public String getCPAddLine1() {
        return cPAddLine1;
    }

    public void setCPAddLine1(String cPAddLine1) {
        this.cPAddLine1 = cPAddLine1;
    }

    public String getCPTelNo1() {
        return cPTelNo1;
    }

    public void setCPTelNo1(String cPTelNo1) {
        this.cPTelNo1 = cPTelNo1;
    }

    public String getCFullNameAma() {
        return cFullNameAma;
    }

    public void setCFullNameAma(String cFullNameAma) {
        this.cFullNameAma = cFullNameAma;
    }

    public int getNLonDescriptionID() {
        return nLonDescriptionID;
    }

    public void setNLonDescriptionID(int nLonDescriptionID) {
        this.nLonDescriptionID = nLonDescriptionID;
    }

    public String getCLonDescription() {
        return cLonDescription;
    }

    public void setCLonDescription(String cLonDescription) {
        this.cLonDescription = cLonDescription;
    }

    public String getCLonDescription2() {
        return cLonDescription2;
    }

    public void setCLonDescription2(String cLonDescription2) {
        this.cLonDescription2 = cLonDescription2;
    }

    public int getNToDateDueDays() {
        return nToDateDueDays;
    }

    public void setNToDateDueDays(int nToDateDueDays) {
        this.nToDateDueDays = nToDateDueDays;
    }

    public BigDecimal getNToDateDueCapital() {
        return nToDateDueCapital;
    }

    public void setNToDateDueCapital(BigDecimal nToDateDueCapital) {
        this.nToDateDueCapital = nToDateDueCapital;
    }

    public BigDecimal getNToDateIntValueRound() {
        return nToDateIntValueRound;
    }

    public void setNToDateIntValueRound(BigDecimal nToDateIntValueRound) {
        this.nToDateIntValueRound = nToDateIntValueRound;
    }

    public BigDecimal getNIssuedAmount() {
        return nIssuedAmount;
    }

    public void setNIssuedAmount(BigDecimal nIssuedAmount) {
        this.nIssuedAmount = nIssuedAmount;
    }

    public BigDecimal getNBalanceToIssue() {
        return nBalanceToIssue;
    }

    public void setNBalanceToIssue(BigDecimal nBalanceToIssue) {
        this.nBalanceToIssue = nBalanceToIssue;
    }

    public BigDecimal getNTotRecvCapital() {
        return nTotRecvCapital;
    }

    public void setNTotRecvCapital(BigDecimal nTotRecvCapital) {
        this.nTotRecvCapital = nTotRecvCapital;
    }

    public BigDecimal getNTotRecvInstallment() {
        return nTotRecvInstallment;
    }

    public void setNTotRecvInstallment(BigDecimal nTotRecvInstallment) {
        this.nTotRecvInstallment = nTotRecvInstallment;
    }

    public BigDecimal getNShouldRecvCapital() {
        return nShouldRecvCapital;
    }

    public void setNShouldRecvCapital(BigDecimal nShouldRecvCapital) {
        this.nShouldRecvCapital = nShouldRecvCapital;
    }

    public BigDecimal getNShouldRecvInstallment() {
        return nShouldRecvInstallment;
    }

    public void setNShouldRecvInstallment(BigDecimal nShouldRecvInstallment) {
        this.nShouldRecvInstallment = nShouldRecvInstallment;
    }

    public BigDecimal getNTotRecvInterest() {
        return nTotRecvInterest;
    }

    public void setNTotRecvInterest(BigDecimal nTotRecvInterest) {
        this.nTotRecvInterest = nTotRecvInterest;
    }

    public BigDecimal getNShouldRecvInterest() {
        return nShouldRecvInterest;
    }

    public void setNShouldRecvInterest(BigDecimal nShouldRecvInterest) {
        this.nShouldRecvInterest = nShouldRecvInterest;
    }

    public BigDecimal getNLonBalanceInstallment() {
        return nLonBalanceInstallment;
    }

    public void setNLonBalanceInstallment(BigDecimal nLonBalanceInstallment) {
        this.nLonBalanceInstallment = nLonBalanceInstallment;
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

    public BigDecimal getNToDateDueInstallment() {
        return nToDateDueInstallment;
    }

    public void setNToDateDueInstallment(BigDecimal nToDateDueInstallment) {
        this.nToDateDueInstallment = nToDateDueInstallment;
    }

    public BigDecimal getNToDateTotIntersest() {
        return nToDateTotIntersest;
    }

    public void setNToDateTotIntersest(BigDecimal nToDateTotIntersest) {
        this.nToDateTotIntersest = nToDateTotIntersest;
    }

    public BigDecimal getNTotRecvOtherCharges() {
        return nTotRecvOtherCharges;
    }

    public void setNTotRecvOtherCharges(BigDecimal nTotRecvOtherCharges) {
        this.nTotRecvOtherCharges = nTotRecvOtherCharges;
    }

    public BigDecimal getNTotRecvPostage() {
        return nTotRecvPostage;
    }

    public void setNTotRecvPostage(BigDecimal nTotRecvPostage) {
        this.nTotRecvPostage = nTotRecvPostage;
    }

    public BigDecimal getNTotRecvStationary() {
        return nTotRecvStationary;
    }

    public void setNTotRecvStationary(BigDecimal nTotRecvStationary) {
        this.nTotRecvStationary = nTotRecvStationary;
    }

    public BigDecimal getNTotRecvArbitrationFees() {
        return nTotRecvArbitrationFees;
    }

    public void setNTotRecvArbitrationFees(BigDecimal nTotRecvArbitrationFees) {
        this.nTotRecvArbitrationFees = nTotRecvArbitrationFees;
    }

    public BigDecimal getNTotRecvCaurtFees() {
        return nTotRecvCaurtFees;
    }

    public void setNTotRecvCaurtFees(BigDecimal nTotRecvCaurtFees) {
        this.nTotRecvCaurtFees = nTotRecvCaurtFees;
    }

    public long getNIssueToDepMFID() {
        return nIssueToDepMFID;
    }

    public void setNIssueToDepMFID(long nIssueToDepMFID) {
        this.nIssueToDepMFID = nIssueToDepMFID;
    }

    public long getNRecoverByDepMFID() {
        return nRecoverByDepMFID;
    }

    public void setNRecoverByDepMFID(long nRecoverByDepMFID) {
        this.nRecoverByDepMFID = nRecoverByDepMFID;
    }
    
}
