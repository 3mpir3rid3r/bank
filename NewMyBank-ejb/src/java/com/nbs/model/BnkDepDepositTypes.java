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
@Table(name = "bnk_Dep_DepositTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkDepDepositTypes.findAll", query = "SELECT b FROM BnkDepDepositTypes b"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNDepTypeID", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nDepTypeID = :nDepTypeID"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNDepCatID", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nDepCatID = :nDepCatID"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCSysCode", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cSysCode = :cSysCode"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCDepName", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cDepName = :cDepName"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCDepNameSin", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cDepNameSin = :cDepNameSin"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCDepNameTamil", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cDepNameTamil = :cDepNameTamil"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinParticipant", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinParticipant = :nMinParticipant"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMaxParticipant", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMaxParticipant = :nMaxParticipant"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinAge", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinAge = :nMinAge"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMaxAge", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMaxAge = :nMaxAge"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNOperatingGenderType", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nOperatingGenderType = :nOperatingGenderType"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinAmtStart", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinAmtStart = :nMinAmtStart"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinAmtContinue", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinAmtContinue = :nMinAmtContinue"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBInitialDepCash", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bInitialDepCash = :bInitialDepCash"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBInitialDepChque", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bInitialDepChque = :bInitialDepChque"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBInitialDepFTrnans", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bInitialDepFTrnans = :bInitialDepFTrnans"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBMultipleAcct", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bMultipleAcct = :bMultipleAcct"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinMonths", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinMonths = :nMinMonths"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMaxMonths", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMaxMonths = :nMaxMonths"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBWithdrawlsAllowed", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bWithdrawlsAllowed = :bWithdrawlsAllowed"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNNoOfDays", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nNoOfDays = :nNoOfDays"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNNoOfTimesPerMonth", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nNoOfTimesPerMonth = :nNoOfTimesPerMonth"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinAgeLimitWithdrawls", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinAgeLimitWithdrawls = :nMinAgeLimitWithdrawls"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNCurrentIntRate", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nCurrentIntRate = :nCurrentIntRate"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNIntCalMethodID", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nIntCalMethodID = :nIntCalMethodID"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNIntCalID", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nIntCalID = :nIntCalID"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNIntPayID", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nIntPayID = :nIntPayID"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinAmtIntCal", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinAmtIntCal = :nMinAmtIntCal"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNMinAmtIntCR", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nMinAmtIntCR = :nMinAmtIntCR"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNInterestRoundMethod", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nInterestRoundMethod = :nInterestRoundMethod"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNBonusIntRate", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nBonusIntRate = :nBonusIntRate"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNLoanAmount", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nLoanAmount = :nLoanAmount"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNAcctLevelID5Capital", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nAcctLevelID5Capital = :nAcctLevelID5Capital"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNAcctLevelID5Interest", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nAcctLevelID5Interest = :nAcctLevelID5Interest"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBChangeToInactive", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bChangeToInactive = :bChangeToInactive"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNInacPeriod", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nInacPeriod = :nInacPeriod"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCInacPeriodType", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cInacPeriodType = :cInacPeriodType"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBChangeToHimiNopa", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bChangeToHimiNopa = :bChangeToHimiNopa"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNHimiPeriod", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nHimiPeriod = :nHimiPeriod"),
    @NamedQuery(name = "BnkDepDepositTypes.findByNHimiPeriodType", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.nHimiPeriodType = :nHimiPeriodType"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCRemarks", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cRemarks = :cRemarks"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBActive", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bActive = :bActive"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCAddBy", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkDepDepositTypes.findByDAddDate", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.dAddDate = :dAddDate"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCEditBy", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cEditBy = :cEditBy"),
    @NamedQuery(name = "BnkDepDepositTypes.findByDEditDate", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.dEditDate = :dEditDate"),
    @NamedQuery(name = "BnkDepDepositTypes.findByBConfirmed", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.bConfirmed = :bConfirmed"),
    @NamedQuery(name = "BnkDepDepositTypes.findByCConfirmedBy", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.cConfirmedBy = :cConfirmedBy"),
    @NamedQuery(name = "BnkDepDepositTypes.findByDConfirmedDate", query = "SELECT b FROM BnkDepDepositTypes b WHERE b.dConfirmedDate = :dConfirmedDate")})
public class BnkDepDepositTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nDepTypeID")
    private Integer nDepTypeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDepCatID")
    private int nDepCatID;
    @Size(max = 3)
    @Column(name = "cSysCode")
    private String cSysCode;
    @Size(max = 50)
    @Column(name = "cDepName")
    private String cDepName;
    @Size(max = 50)
    @Column(name = "cDepNameSin")
    private String cDepNameSin;
    @Size(max = 50)
    @Column(name = "cDepNameTamil")
    private String cDepNameTamil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinParticipant")
    private int nMinParticipant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMaxParticipant")
    private int nMaxParticipant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinAge")
    private int nMinAge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMaxAge")
    private int nMaxAge;
    @Column(name = "nOperatingGenderType")
    private Short nOperatingGenderType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinAmtStart")
    private BigDecimal nMinAmtStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinAmtContinue")
    private BigDecimal nMinAmtContinue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bInitialDepCash")
    private boolean bInitialDepCash;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bInitialDepChque")
    private boolean bInitialDepChque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bInitialDepFTrnans")
    private boolean bInitialDepFTrnans;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bMultipleAcct")
    private boolean bMultipleAcct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinMonths")
    private int nMinMonths;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMaxMonths")
    private int nMaxMonths;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bWithdrawlsAllowed")
    private boolean bWithdrawlsAllowed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nNoOfDays")
    private BigDecimal nNoOfDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nNoOfTimesPerMonth")
    private int nNoOfTimesPerMonth;
    @Column(name = "nMinAgeLimit_Withdrawls")
    private Short nMinAgeLimitWithdrawls;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCurrentIntRate")
    private BigDecimal nCurrentIntRate;
    @Column(name = "nIntCalMethodID")
    private Short nIntCalMethodID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntCalID")
    private int nIntCalID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIntPayID")
    private int nIntPayID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinAmtIntCal")
    private BigDecimal nMinAmtIntCal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinAmtIntCR")
    private BigDecimal nMinAmtIntCR;
    @Column(name = "nInterestRoundMethod")
    private Short nInterestRoundMethod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nBonusIntRate")
    private BigDecimal nBonusIntRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLoanAmount")
    private BigDecimal nLoanAmount;
    @Column(name = "nAcctLevelID5_Capital")
    private Integer nAcctLevelID5Capital;
    @Column(name = "nAcctLevelID5_Interest")
    private Integer nAcctLevelID5Interest;
    @Column(name = "bChangeToInactive")
    private Boolean bChangeToInactive;
    @Column(name = "nInacPeriod")
    private Integer nInacPeriod;
    @Size(max = 15)
    @Column(name = "cInacPeriodType")
    private String cInacPeriodType;
    @Column(name = "bChangeToHimiNopa")
    private Boolean bChangeToHimiNopa;
    @Column(name = "nHimiPeriod")
    private Integer nHimiPeriod;
    @Size(max = 15)
    @Column(name = "nHimiPeriodType")
    private String nHimiPeriodType;
    @Size(max = 200)
    @Column(name = "cRemarks")
    private String cRemarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bActive")
    private boolean bActive;
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
    @Column(name = "bConfirmed")
    private Short bConfirmed;
    @Size(max = 20)
    @Column(name = "cConfirmedBy")
    private String cConfirmedBy;
    @Column(name = "dConfirmedDate")
    @Temporal(TemporalType.DATE)
    private Date dConfirmedDate;

    public BnkDepDepositTypes() {
    }

    public BnkDepDepositTypes(Integer nDepTypeID) {
        this.nDepTypeID = nDepTypeID;
    }

    public BnkDepDepositTypes(
            
            Integer nDepTypeID,
            int nDepCatID, 
            String cSysCode, 
            String cDepName, 
            String cDepNameSin, 
            String cDepNameTamil, 
            int nMinParticipant, 
            int nMaxParticipant, 
            int nMinAge, 
            int nMaxAge, 
            Short nOperatingGenderType, 
            BigDecimal nMinAmtStart, 
            BigDecimal nMinAmtContinue, 
            boolean bInitialDepCash, 
            boolean bInitialDepChque, 
            boolean bInitialDepFTrnans, 
            boolean bMultipleAcct, 
            int nMinMonths, 
            int nMaxMonths, 
            boolean bWithdrawlsAllowed, 
            BigDecimal nNoOfDays, 
            int nNoOfTimesPerMonth, 
            Short nMinAgeLimitWithdrawls, 
            BigDecimal nCurrentIntRate, 
            Short nIntCalMethodID, 
            int nIntCalID, 
            int nIntPayID, 
            BigDecimal nMinAmtIntCal, 
            BigDecimal nMinAmtIntCR, 
            Short nInterestRoundMethod, 
            BigDecimal nBonusIntRate, 
            BigDecimal nLoanAmount, 
            Integer nAcctLevelID5Capital, 
            Integer nAcctLevelID5Interest, 
            Boolean bChangeToInactive,
            Integer nInacPeriod,
            
            Date dAddDate,
            Boolean bChangeToHimiNopa,
            Integer nHimiPeriod,
            String nHimiPeriodType,
            String cRemarks,//41
            boolean bActive,
            String cAddBy,
            String cEditBy,
            Date dEditDate,//45
            Short bConfirmed,
            String cConfirmedBy,
            Date dConfirmedDate,
            String cInacPeriodType         ) {
        
        
        this.nDepTypeID = nDepTypeID;
        this.nDepCatID = nDepCatID;
        this.cSysCode = cSysCode;
        this.cDepName = cDepName;
        this.cDepNameSin = cDepNameSin;
        this.cDepNameTamil = cDepNameTamil;
        this.nMinParticipant = nMinParticipant;
        this.nMaxParticipant = nMaxParticipant;
        this.nMinAge = nMinAge;
        this.nMaxAge = nMaxAge;
        this.nOperatingGenderType = nOperatingGenderType;
        this.nMinAmtStart = nMinAmtStart;
        this.nMinAmtContinue = nMinAmtContinue;
        this.bInitialDepCash = bInitialDepCash;
        this.bInitialDepChque = bInitialDepChque;
        this.bInitialDepFTrnans = bInitialDepFTrnans;
        this.bMultipleAcct = bMultipleAcct;
        this.nMinMonths = nMinMonths;
        this.nMaxMonths = nMaxMonths;
        this.bWithdrawlsAllowed = bWithdrawlsAllowed;
        this.nNoOfDays = nNoOfDays;
        this.nNoOfTimesPerMonth = nNoOfTimesPerMonth;
        this.nMinAgeLimitWithdrawls = nMinAgeLimitWithdrawls;
        this.nCurrentIntRate = nCurrentIntRate;
        this.nIntCalMethodID = nIntCalMethodID;
        this.nIntCalID = nIntCalID;
        this.nIntPayID = nIntPayID;
        this.nMinAmtIntCal = nMinAmtIntCal;
        this.nMinAmtIntCR = nMinAmtIntCR;
        this.nInterestRoundMethod = nInterestRoundMethod;
        this.nBonusIntRate = nBonusIntRate;
        this.nLoanAmount = nLoanAmount;
        
        
        this.nAcctLevelID5Capital = nAcctLevelID5Capital;
        this.nAcctLevelID5Interest = nAcctLevelID5Interest;
        this.bChangeToInactive = bChangeToInactive;
        this.nInacPeriod = nInacPeriod;
        
        this.cInacPeriodType = cInacPeriodType;
        this.bChangeToHimiNopa = bChangeToHimiNopa;
        this.nHimiPeriod = nHimiPeriod;
        this.nHimiPeriodType = nHimiPeriodType;
        this.cRemarks = cRemarks;
        this.bActive = bActive;
        this.cAddBy = cAddBy;
        this.dAddDate = dAddDate;
        this.cEditBy = cEditBy;
        this.dEditDate = dEditDate;
        this.bConfirmed = bConfirmed;
        this.cConfirmedBy = cConfirmedBy;
        this.dConfirmedDate = dConfirmedDate;
    }

    public BnkDepDepositTypes(Integer nDepTypeID, int nDepCatID, int nMinParticipant, int nMaxParticipant, int nMinAge, int nMaxAge, BigDecimal nMinAmtStart, BigDecimal nMinAmtContinue, boolean bInitialDepCash, boolean bInitialDepChque, boolean bInitialDepFTrnans, boolean bMultipleAcct, int nMinMonths, int nMaxMonths, boolean bWithdrawlsAllowed, BigDecimal nNoOfDays, int nNoOfTimesPerMonth, BigDecimal nCurrentIntRate, int nIntCalID, int nIntPayID, BigDecimal nMinAmtIntCal, BigDecimal nMinAmtIntCR, BigDecimal nBonusIntRate, BigDecimal nLoanAmount, boolean bActive) {
        this.nDepTypeID = nDepTypeID;
        this.nDepCatID = nDepCatID;
        this.nMinParticipant = nMinParticipant;
        this.nMaxParticipant = nMaxParticipant;
        this.nMinAge = nMinAge;
        this.nMaxAge = nMaxAge;
        this.nMinAmtStart = nMinAmtStart;
        this.nMinAmtContinue = nMinAmtContinue;
        this.bInitialDepCash = bInitialDepCash;
        this.bInitialDepChque = bInitialDepChque;
        this.bInitialDepFTrnans = bInitialDepFTrnans;
        this.bMultipleAcct = bMultipleAcct;
        this.nMinMonths = nMinMonths;
        this.nMaxMonths = nMaxMonths;
        this.bWithdrawlsAllowed = bWithdrawlsAllowed;
        this.nNoOfDays = nNoOfDays;
        this.nNoOfTimesPerMonth = nNoOfTimesPerMonth;
        this.nCurrentIntRate = nCurrentIntRate;
        this.nIntCalID = nIntCalID;
        this.nIntPayID = nIntPayID;
        this.nMinAmtIntCal = nMinAmtIntCal;
        this.nMinAmtIntCR = nMinAmtIntCR;
        this.nBonusIntRate = nBonusIntRate;
        this.nLoanAmount = nLoanAmount;
        this.bActive = bActive;
    }

    public Integer getNDepTypeID() {
        return nDepTypeID;
    }

    public void setNDepTypeID(Integer nDepTypeID) {
        this.nDepTypeID = nDepTypeID;
    }

    public int getNDepCatID() {
        return nDepCatID;
    }

    public void setNDepCatID(int nDepCatID) {
        this.nDepCatID = nDepCatID;
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

    public String getCDepNameSin() {
        return cDepNameSin;
    }

    public void setCDepNameSin(String cDepNameSin) {
        this.cDepNameSin = cDepNameSin;
    }

    public String getCDepNameTamil() {
        return cDepNameTamil;
    }

    public void setCDepNameTamil(String cDepNameTamil) {
        this.cDepNameTamil = cDepNameTamil;
    }

    public int getNMinParticipant() {
        return nMinParticipant;
    }

    public void setNMinParticipant(int nMinParticipant) {
        this.nMinParticipant = nMinParticipant;
    }

    public int getNMaxParticipant() {
        return nMaxParticipant;
    }

    public void setNMaxParticipant(int nMaxParticipant) {
        this.nMaxParticipant = nMaxParticipant;
    }

    public int getNMinAge() {
        return nMinAge;
    }

    public void setNMinAge(int nMinAge) {
        this.nMinAge = nMinAge;
    }

    public int getNMaxAge() {
        return nMaxAge;
    }

    public void setNMaxAge(int nMaxAge) {
        this.nMaxAge = nMaxAge;
    }

    public Short getNOperatingGenderType() {
        return nOperatingGenderType;
    }

    public void setNOperatingGenderType(Short nOperatingGenderType) {
        this.nOperatingGenderType = nOperatingGenderType;
    }

    public BigDecimal getNMinAmtStart() {
        return nMinAmtStart;
    }

    public void setNMinAmtStart(BigDecimal nMinAmtStart) {
        this.nMinAmtStart = nMinAmtStart;
    }

    public BigDecimal getNMinAmtContinue() {
        return nMinAmtContinue;
    }

    public void setNMinAmtContinue(BigDecimal nMinAmtContinue) {
        this.nMinAmtContinue = nMinAmtContinue;
    }

    public boolean getBInitialDepCash() {
        return bInitialDepCash;
    }

    public void setBInitialDepCash(boolean bInitialDepCash) {
        this.bInitialDepCash = bInitialDepCash;
    }

    public boolean getBInitialDepChque() {
        return bInitialDepChque;
    }

    public void setBInitialDepChque(boolean bInitialDepChque) {
        this.bInitialDepChque = bInitialDepChque;
    }

    public boolean getBInitialDepFTrnans() {
        return bInitialDepFTrnans;
    }

    public void setBInitialDepFTrnans(boolean bInitialDepFTrnans) {
        this.bInitialDepFTrnans = bInitialDepFTrnans;
    }

    public boolean getBMultipleAcct() {
        return bMultipleAcct;
    }

    public void setBMultipleAcct(boolean bMultipleAcct) {
        this.bMultipleAcct = bMultipleAcct;
    }

    public int getNMinMonths() {
        return nMinMonths;
    }

    public void setNMinMonths(int nMinMonths) {
        this.nMinMonths = nMinMonths;
    }

    public int getNMaxMonths() {
        return nMaxMonths;
    }

    public void setNMaxMonths(int nMaxMonths) {
        this.nMaxMonths = nMaxMonths;
    }

    public boolean getBWithdrawlsAllowed() {
        return bWithdrawlsAllowed;
    }

    public void setBWithdrawlsAllowed(boolean bWithdrawlsAllowed) {
        this.bWithdrawlsAllowed = bWithdrawlsAllowed;
    }

    public BigDecimal getNNoOfDays() {
        return nNoOfDays;
    }

    public void setNNoOfDays(BigDecimal nNoOfDays) {
        this.nNoOfDays = nNoOfDays;
    }

    public int getNNoOfTimesPerMonth() {
        return nNoOfTimesPerMonth;
    }

    public void setNNoOfTimesPerMonth(int nNoOfTimesPerMonth) {
        this.nNoOfTimesPerMonth = nNoOfTimesPerMonth;
    }

    public Short getNMinAgeLimitWithdrawls() {
        return nMinAgeLimitWithdrawls;
    }

    public void setNMinAgeLimitWithdrawls(Short nMinAgeLimitWithdrawls) {
        this.nMinAgeLimitWithdrawls = nMinAgeLimitWithdrawls;
    }

    public BigDecimal getNCurrentIntRate() {
        return nCurrentIntRate;
    }

    public void setNCurrentIntRate(BigDecimal nCurrentIntRate) {
        this.nCurrentIntRate = nCurrentIntRate;
    }

    public Short getNIntCalMethodID() {
        return nIntCalMethodID;
    }

    public void setNIntCalMethodID(Short nIntCalMethodID) {
        this.nIntCalMethodID = nIntCalMethodID;
    }

    public int getNIntCalID() {
        return nIntCalID;
    }

    public void setNIntCalID(int nIntCalID) {
        this.nIntCalID = nIntCalID;
    }

    public int getNIntPayID() {
        return nIntPayID;
    }

    public void setNIntPayID(int nIntPayID) {
        this.nIntPayID = nIntPayID;
    }

    public BigDecimal getNMinAmtIntCal() {
        return nMinAmtIntCal;
    }

    public void setNMinAmtIntCal(BigDecimal nMinAmtIntCal) {
        this.nMinAmtIntCal = nMinAmtIntCal;
    }

    public BigDecimal getNMinAmtIntCR() {
        return nMinAmtIntCR;
    }

    public void setNMinAmtIntCR(BigDecimal nMinAmtIntCR) {
        this.nMinAmtIntCR = nMinAmtIntCR;
    }

    public Short getNInterestRoundMethod() {
        return nInterestRoundMethod;
    }

    public void setNInterestRoundMethod(Short nInterestRoundMethod) {
        this.nInterestRoundMethod = nInterestRoundMethod;
    }

    public BigDecimal getNBonusIntRate() {
        return nBonusIntRate;
    }

    public void setNBonusIntRate(BigDecimal nBonusIntRate) {
        this.nBonusIntRate = nBonusIntRate;
    }

    public BigDecimal getNLoanAmount() {
        return nLoanAmount;
    }

    public void setNLoanAmount(BigDecimal nLoanAmount) {
        this.nLoanAmount = nLoanAmount;
    }

    public Integer getNAcctLevelID5Capital() {
        return nAcctLevelID5Capital;
    }

    public void setNAcctLevelID5Capital(Integer nAcctLevelID5Capital) {
        this.nAcctLevelID5Capital = nAcctLevelID5Capital;
    }

    public Integer getNAcctLevelID5Interest() {
        return nAcctLevelID5Interest;
    }

    public void setNAcctLevelID5Interest(Integer nAcctLevelID5Interest) {
        this.nAcctLevelID5Interest = nAcctLevelID5Interest;
    }

    public Boolean getBChangeToInactive() {
        return bChangeToInactive;
    }

    public void setBChangeToInactive(Boolean bChangeToInactive) {
        this.bChangeToInactive = bChangeToInactive;
    }

    public Integer getNInacPeriod() {
        return nInacPeriod;
    }

    public void setNInacPeriod(Integer nInacPeriod) {
        this.nInacPeriod = nInacPeriod;
    }

    public String getCInacPeriodType() {
        return cInacPeriodType;
    }

    public void setCInacPeriodType(String cInacPeriodType) {
        this.cInacPeriodType = cInacPeriodType;
    }

    public Boolean getBChangeToHimiNopa() {
        return bChangeToHimiNopa;
    }

    public void setBChangeToHimiNopa(Boolean bChangeToHimiNopa) {
        this.bChangeToHimiNopa = bChangeToHimiNopa;
    }

    public Integer getNHimiPeriod() {
        return nHimiPeriod;
    }

    public void setNHimiPeriod(Integer nHimiPeriod) {
        this.nHimiPeriod = nHimiPeriod;
    }

    public String getNHimiPeriodType() {
        return nHimiPeriodType;
    }

    public void setNHimiPeriodType(String nHimiPeriodType) {
        this.nHimiPeriodType = nHimiPeriodType;
    }

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public boolean getBActive() {
        return bActive;
    }

    public void setBActive(boolean bActive) {
        this.bActive = bActive;
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

    public Short getBConfirmed() {
        return bConfirmed;
    }

    public void setBConfirmed(Short bConfirmed) {
        this.bConfirmed = bConfirmed;
    }

    public String getCConfirmedBy() {
        return cConfirmedBy;
    }

    public void setCConfirmedBy(String cConfirmedBy) {
        this.cConfirmedBy = cConfirmedBy;
    }

    public Date getDConfirmedDate() {
        return dConfirmedDate;
    }

    public void setDConfirmedDate(Date dConfirmedDate) {
        this.dConfirmedDate = dConfirmedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepTypeID != null ? nDepTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositTypes)) {
            return false;
        }
        BnkDepDepositTypes other = (BnkDepDepositTypes) object;
        if ((this.nDepTypeID == null && other.nDepTypeID != null) || (this.nDepTypeID != null && !this.nDepTypeID.equals(other.nDepTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkDepDepositTypes[ nDepTypeID=" + nDepTypeID + " ]";
    }
    
}
