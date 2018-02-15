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
@Table(name = "v_FindData_bnk_Dep_Deposit_Master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findAll", query = "SELECT v FROM VFindDatabnkDepDepositMaster v"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNDepMFID", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nDepMFID = :nDepMFID"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNNotCreditIntBalance", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nNotCreditIntBalance = :nNotCreditIntBalance"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNAvailableBalance", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nAvailableBalance = :nAvailableBalance"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCOurAccountNo", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cOurAccountNo = :cOurAccountNo"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCOldAccountNo", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cOldAccountNo = :cOldAccountNo"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByBJoint", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.bJoint = :bJoint"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByDStartDate", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.dStartDate = :dStartDate"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNCurBookBalance", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nCurBookBalance = :nCurBookBalance"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByBIntHolded", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.bIntHolded = :bIntHolded"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNHoldedAmount", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nHoldedAmount = :nHoldedAmount"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCSysCode", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cSysCode = :cSysCode"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCDepName", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cDepName = :cDepName"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNCustomerID", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nCustomerID = :nCustomerID"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCNICNo", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cNICNo = :cNICNo"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCCIFNo", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cCIFNo = :cCIFNo"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCMemberShipNo", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cMemberShipNo = :cMemberShipNo"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNBankBranchID", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCFullName", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cFullName = :cFullName"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCUseName", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cUseName = :cUseName"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCPAddLine1", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cPAddLine1 = :cPAddLine1"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCFullNameAma", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cFullNameAma = :cFullNameAma"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCInitials", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cInitials = :cInitials"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByCLastName", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.cLastName = :cLastName"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNActualBalance", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nActualBalance = :nActualBalance"),
    @NamedQuery(name = "VFindDatabnkDepDepositMaster.findByNHoldedAmountInt", query = "SELECT v FROM VFindDatabnkDepDepositMaster v WHERE v.nHoldedAmountInt = :nHoldedAmountInt")})
public class VFindDatabnkDepDepositMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDepMFID")
    @Id
    private long nDepMFID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nNotCreditIntBalance")
    private BigDecimal nNotCreditIntBalance;
    @Column(name = "nAvailableBalance")
    private BigDecimal nAvailableBalance;
    @Size(max = 13)
    @Column(name = "cOurAccountNo")
    private String cOurAccountNo;
    @Size(max = 13)
    @Column(name = "cOldAccountNo")
    private String cOldAccountNo;
    @Column(name = "bJoint")
    private Boolean bJoint;
    @Column(name = "dStartDate")
    @Temporal(TemporalType.DATE)
    private Date dStartDate;
    @Column(name = "nCurBookBalance")
    private BigDecimal nCurBookBalance;
    @Column(name = "bIntHolded")
    private Boolean bIntHolded;
    @Column(name = "nHoldedAmount")
    private BigDecimal nHoldedAmount;
    @Size(max = 3)
    @Column(name = "cSysCode")
    private String cSysCode;
    @Size(max = 50)
    @Column(name = "cDepName")
    private String cDepName;
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
    @Size(max = 200)
    @Column(name = "cFullName_Ama")
    private String cFullNameAma;
    @Size(max = 50)
    @Column(name = "cInitials")
    private String cInitials;
    @Size(max = 150)
    @Column(name = "cLastName")
    private String cLastName;
    @Column(name = "nActualBalance")
    private BigDecimal nActualBalance;
    @Column(name = "nHoldedAmount_Int")
    private BigDecimal nHoldedAmountInt;

    public VFindDatabnkDepDepositMaster() {
    }

    public long getNDepMFID() {
        return nDepMFID;
    }

    public void setNDepMFID(long nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    public BigDecimal getNNotCreditIntBalance() {
        return nNotCreditIntBalance;
    }

    public void setNNotCreditIntBalance(BigDecimal nNotCreditIntBalance) {
        this.nNotCreditIntBalance = nNotCreditIntBalance;
    }

    public BigDecimal getNAvailableBalance() {
        return nAvailableBalance;
    }

    public void setNAvailableBalance(BigDecimal nAvailableBalance) {
        this.nAvailableBalance = nAvailableBalance;
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

    public Boolean getBJoint() {
        return bJoint;
    }

    public void setBJoint(Boolean bJoint) {
        this.bJoint = bJoint;
    }

    public Date getDStartDate() {
        return dStartDate;
    }

    public void setDStartDate(Date dStartDate) {
        this.dStartDate = dStartDate;
    }

    public BigDecimal getNCurBookBalance() {
        return nCurBookBalance;
    }

    public void setNCurBookBalance(BigDecimal nCurBookBalance) {
        this.nCurBookBalance = nCurBookBalance;
    }

    public Boolean getBIntHolded() {
        return bIntHolded;
    }

    public void setBIntHolded(Boolean bIntHolded) {
        this.bIntHolded = bIntHolded;
    }

    public BigDecimal getNHoldedAmount() {
        return nHoldedAmount;
    }

    public void setNHoldedAmount(BigDecimal nHoldedAmount) {
        this.nHoldedAmount = nHoldedAmount;
    }

    public String getCSysCode() {
        return cSysCode;
    }

    public void setCSysCode(String cSysCode) {
        this.cSysCode = cSysCode;
    }

    public String getCDepName() {
        return cDepName;
    }

    public void setCDepName(String cDepName) {
        this.cDepName = cDepName;
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

    public String getCFullNameAma() {
        return cFullNameAma;
    }

    public void setCFullNameAma(String cFullNameAma) {
        this.cFullNameAma = cFullNameAma;
    }

    public String getCInitials() {
        return cInitials;
    }

    public void setCInitials(String cInitials) {
        this.cInitials = cInitials;
    }

    public String getCLastName() {
        return cLastName;
    }

    public void setCLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public BigDecimal getNActualBalance() {
        return nActualBalance;
    }

    public void setNActualBalance(BigDecimal nActualBalance) {
        this.nActualBalance = nActualBalance;
    }

    public BigDecimal getNHoldedAmountInt() {
        return nHoldedAmountInt;
    }

    public void setNHoldedAmountInt(BigDecimal nHoldedAmountInt) {
        this.nHoldedAmountInt = nHoldedAmountInt;
    }
    
}
