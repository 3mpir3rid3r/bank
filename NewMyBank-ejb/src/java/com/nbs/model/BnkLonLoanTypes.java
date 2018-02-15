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
@Table(name = "bnk_Lon_LoanTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanTypes.findAll", query = "SELECT b FROM BnkLonLoanTypes b")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNLonTypeID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nLonTypeID = :nLonTypeID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNLonCatID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nLonCatID = :nLonCatID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByCLonName", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.cLonName = :cLonName")
    , @NamedQuery(name = "BnkLonLoanTypes.findByCLonNameSin", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.cLonNameSin = :cLonNameSin")
    , @NamedQuery(name = "BnkLonLoanTypes.findByCLonNameTamil", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.cLonNameTamil = :cLonNameTamil")
    , @NamedQuery(name = "BnkLonLoanTypes.findByCSysCode", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.cSysCode = :cSysCode")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMinParticipant", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMinParticipant = :nMinParticipant")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMaxParticipant", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMaxParticipant = :nMaxParticipant")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMinAge", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMinAge = :nMinAge")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMaxAge", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMaxAge = :nMaxAge")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMinLonAmt", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMinLonAmt = :nMinLonAmt")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMaxLonAmt", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMaxLonAmt = :nMaxLonAmt")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMinMonths", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMinMonths = :nMinMonths")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNMaxMonths", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nMaxMonths = :nMaxMonths")
    , @NamedQuery(name = "BnkLonLoanTypes.findByBMultipleAcct", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.bMultipleAcct = :bMultipleAcct")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNCurrentInt", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nCurrentInt = :nCurrentInt")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNLonInterestMethodID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nLonInterestMethodID = :nLonInterestMethodID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNIntCalMethodID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nIntCalMethodID = :nIntCalMethodID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNLoanIntRoundID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nLoanIntRoundID = :nLoanIntRoundID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPenaltyIntRate", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPenaltyIntRate = :nPenaltyIntRate")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPenaltyIntRateForID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPenaltyIntRateForID = :nPenaltyIntRateForID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPenaltyIntCalAfter", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPenaltyIntCalAfter = :nPenaltyIntCalAfter")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPenaltyIntCalAfterID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPenaltyIntCalAfterID = :nPenaltyIntCalAfterID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPenaltyIntOP1", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPenaltyIntOP1 = :nPenaltyIntOP1")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPenaltyIntOP2", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPenaltyIntOP2 = :nPenaltyIntOP2")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4LoanCapital", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4LoanCapital = :nAcctLevelID4LoanCapital")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4Interest", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4Interest = :nAcctLevelID4Interest")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4PenaltyInterest", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4PenaltyInterest = :nAcctLevelID4PenaltyInterest")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4FreeInterest", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4FreeInterest = :nAcctLevelID4FreeInterest")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4Postage", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4Postage = :nAcctLevelID4Postage")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4Stationary", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4Stationary = :nAcctLevelID4Stationary")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4ArbitrationFees", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4ArbitrationFees = :nAcctLevelID4ArbitrationFees")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNAcctLevelID4LawFees", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nAcctLevelID4LawFees = :nAcctLevelID4LawFees")
    , @NamedQuery(name = "BnkLonLoanTypes.findByCAddBy", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.cAddBy = :cAddBy")
    , @NamedQuery(name = "BnkLonLoanTypes.findByDAddDate", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.dAddDate = :dAddDate")
    , @NamedQuery(name = "BnkLonLoanTypes.findByCEditBy", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.cEditBy = :cEditBy")
    , @NamedQuery(name = "BnkLonLoanTypes.findByDEditDate", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.dEditDate = :dEditDate")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNType", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nType = :nType")
    , @NamedQuery(name = "BnkLonLoanTypes.findByCType", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.cType = :cType")
    , @NamedQuery(name = "BnkLonLoanTypes.findByBActive", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.bActive = :bActive")
    , @NamedQuery(name = "BnkLonLoanTypes.findByBLetGen", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.bLetGen = :bLetGen")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPIntRateForID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPIntRateForID = :nPIntRateForID")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPenaltyIntCal", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPenaltyIntCal = :nPenaltyIntCal")
    , @NamedQuery(name = "BnkLonLoanTypes.findByNPIntCalForID", query = "SELECT b FROM BnkLonLoanTypes b WHERE b.nPIntCalForID = :nPIntCalForID")})
public class BnkLonLoanTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonTypeID")
    private Integer nLonTypeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonCatID")
    private int nLonCatID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cLonName")
    private String cLonName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cLonNameSin")
    private String cLonNameSin;
    @Size(max = 50)
    @Column(name = "cLonNameTamil")
    private String cLonNameTamil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cSysCode")
    private String cSysCode;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMinLonAmt")
    private BigDecimal nMinLonAmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMaxLonAmt")
    private BigDecimal nMaxLonAmt;
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
    @Column(name = "bMultipleAcct")
    private boolean bMultipleAcct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCurrentInt")
    private BigDecimal nCurrentInt;
    @Column(name = "nLonInterestMethodID")
    private Short nLonInterestMethodID;
    @Column(name = "nIntCalMethodID")
    private Short nIntCalMethodID;
    @Column(name = "nLoanIntRoundID")
    private Integer nLoanIntRoundID;
    @Column(name = "nPenaltyIntRate")
    private BigDecimal nPenaltyIntRate;
    @Column(name = "nPenaltyIntRateForID")
    private Short nPenaltyIntRateForID;
    @Column(name = "nPenaltyIntCalAfter")
    private Short nPenaltyIntCalAfter;
    @Column(name = "nPenaltyIntCalAfterID")
    private Short nPenaltyIntCalAfterID;
    @Column(name = "nPenaltyIntOP1")
    private Short nPenaltyIntOP1;
    @Column(name = "nPenaltyIntOP2")
    private Short nPenaltyIntOP2;
    @Column(name = "nAcctLevelID4_LoanCapital")
    private Integer nAcctLevelID4LoanCapital;
    @Column(name = "nAcctLevelID4_Interest")
    private Integer nAcctLevelID4Interest;
    @Column(name = "nAcctLevelID4_PenaltyInterest")
    private Integer nAcctLevelID4PenaltyInterest;
    @Column(name = "nAcctLevelID4_FreeInterest")
    private Integer nAcctLevelID4FreeInterest;
    @Column(name = "nAcctLevelID4_Postage")
    private Integer nAcctLevelID4Postage;
    @Column(name = "nAcctLevelID4_Stationary")
    private Integer nAcctLevelID4Stationary;
    @Column(name = "nAcctLevelID4_ArbitrationFees")
    private Integer nAcctLevelID4ArbitrationFees;
    @Column(name = "nAcctLevelID4_LawFees")
    private Integer nAcctLevelID4LawFees;
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
    @Column(name = "nType")
    private Integer nType;
    @Size(max = 100)
    @Column(name = "cType")
    private String cType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bActive")
    private short bActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bLetGen")
    private short bLetGen;
    @Column(name = "nPIntRateForID")
    private Integer nPIntRateForID;
    @Column(name = "nPenaltyIntCal")
    private Integer nPenaltyIntCal;
    @Column(name = "nPIntCalForID")
    private Integer nPIntCalForID;

    public BnkLonLoanTypes() {
    }

    public BnkLonLoanTypes(Integer nLonTypeID) {
        this.nLonTypeID = nLonTypeID;
    }

    public BnkLonLoanTypes(Integer nLonTypeID, int nLonCatID, String cLonName, String cLonNameSin, String cSysCode, int nMinParticipant, int nMaxParticipant, int nMinAge, int nMaxAge, BigDecimal nMinLonAmt, BigDecimal nMaxLonAmt, int nMinMonths, int nMaxMonths, boolean bMultipleAcct, BigDecimal nCurrentInt, short bActive, short bLetGen) {
        this.nLonTypeID = nLonTypeID;
        this.nLonCatID = nLonCatID;
        this.cLonName = cLonName;
        this.cLonNameSin = cLonNameSin;
        this.cSysCode = cSysCode;
        this.nMinParticipant = nMinParticipant;
        this.nMaxParticipant = nMaxParticipant;
        this.nMinAge = nMinAge;
        this.nMaxAge = nMaxAge;
        this.nMinLonAmt = nMinLonAmt;
        this.nMaxLonAmt = nMaxLonAmt;
        this.nMinMonths = nMinMonths;
        this.nMaxMonths = nMaxMonths;
        this.bMultipleAcct = bMultipleAcct;
        this.nCurrentInt = nCurrentInt;
        this.bActive = bActive;
        this.bLetGen = bLetGen;
    }

    public Integer getNLonTypeID() {
        return nLonTypeID;
    }

    public void setNLonTypeID(Integer nLonTypeID) {
        this.nLonTypeID = nLonTypeID;
    }

    public int getNLonCatID() {
        return nLonCatID;
    }

    public void setNLonCatID(int nLonCatID) {
        this.nLonCatID = nLonCatID;
    }

    public String getCLonName() {
        return cLonName;
    }

    public void setCLonName(String cLonName) {
        this.cLonName = cLonName;
    }

    public String getCLonNameSin() {
        return cLonNameSin;
    }

    public void setCLonNameSin(String cLonNameSin) {
        this.cLonNameSin = cLonNameSin;
    }

    public String getCLonNameTamil() {
        return cLonNameTamil;
    }

    public void setCLonNameTamil(String cLonNameTamil) {
        this.cLonNameTamil = cLonNameTamil;
    }

    public String getCSysCode() {
        return cSysCode;
    }

    public void setCSysCode(String cSysCode) {
        this.cSysCode = cSysCode;
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

    public BigDecimal getNMinLonAmt() {
        return nMinLonAmt;
    }

    public void setNMinLonAmt(BigDecimal nMinLonAmt) {
        this.nMinLonAmt = nMinLonAmt;
    }

    public BigDecimal getNMaxLonAmt() {
        return nMaxLonAmt;
    }

    public void setNMaxLonAmt(BigDecimal nMaxLonAmt) {
        this.nMaxLonAmt = nMaxLonAmt;
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

    public boolean getBMultipleAcct() {
        return bMultipleAcct;
    }

    public void setBMultipleAcct(boolean bMultipleAcct) {
        this.bMultipleAcct = bMultipleAcct;
    }

    public BigDecimal getNCurrentInt() {
        return nCurrentInt;
    }

    public void setNCurrentInt(BigDecimal nCurrentInt) {
        this.nCurrentInt = nCurrentInt;
    }

    public Short getNLonInterestMethodID() {
        return nLonInterestMethodID;
    }

    public void setNLonInterestMethodID(Short nLonInterestMethodID) {
        this.nLonInterestMethodID = nLonInterestMethodID;
    }

    public Short getNIntCalMethodID() {
        return nIntCalMethodID;
    }

    public void setNIntCalMethodID(Short nIntCalMethodID) {
        this.nIntCalMethodID = nIntCalMethodID;
    }

    public Integer getNLoanIntRoundID() {
        return nLoanIntRoundID;
    }

    public void setNLoanIntRoundID(Integer nLoanIntRoundID) {
        this.nLoanIntRoundID = nLoanIntRoundID;
    }

    public BigDecimal getNPenaltyIntRate() {
        return nPenaltyIntRate;
    }

    public void setNPenaltyIntRate(BigDecimal nPenaltyIntRate) {
        this.nPenaltyIntRate = nPenaltyIntRate;
    }

    public Short getNPenaltyIntRateForID() {
        return nPenaltyIntRateForID;
    }

    public void setNPenaltyIntRateForID(Short nPenaltyIntRateForID) {
        this.nPenaltyIntRateForID = nPenaltyIntRateForID;
    }

    public Short getNPenaltyIntCalAfter() {
        return nPenaltyIntCalAfter;
    }

    public void setNPenaltyIntCalAfter(Short nPenaltyIntCalAfter) {
        this.nPenaltyIntCalAfter = nPenaltyIntCalAfter;
    }

    public Short getNPenaltyIntCalAfterID() {
        return nPenaltyIntCalAfterID;
    }

    public void setNPenaltyIntCalAfterID(Short nPenaltyIntCalAfterID) {
        this.nPenaltyIntCalAfterID = nPenaltyIntCalAfterID;
    }

    public Short getNPenaltyIntOP1() {
        return nPenaltyIntOP1;
    }

    public void setNPenaltyIntOP1(Short nPenaltyIntOP1) {
        this.nPenaltyIntOP1 = nPenaltyIntOP1;
    }

    public Short getNPenaltyIntOP2() {
        return nPenaltyIntOP2;
    }

    public void setNPenaltyIntOP2(Short nPenaltyIntOP2) {
        this.nPenaltyIntOP2 = nPenaltyIntOP2;
    }

    public Integer getNAcctLevelID4LoanCapital() {
        return nAcctLevelID4LoanCapital;
    }

    public void setNAcctLevelID4LoanCapital(Integer nAcctLevelID4LoanCapital) {
        this.nAcctLevelID4LoanCapital = nAcctLevelID4LoanCapital;
    }

    public Integer getNAcctLevelID4Interest() {
        return nAcctLevelID4Interest;
    }

    public void setNAcctLevelID4Interest(Integer nAcctLevelID4Interest) {
        this.nAcctLevelID4Interest = nAcctLevelID4Interest;
    }

    public Integer getNAcctLevelID4PenaltyInterest() {
        return nAcctLevelID4PenaltyInterest;
    }

    public void setNAcctLevelID4PenaltyInterest(Integer nAcctLevelID4PenaltyInterest) {
        this.nAcctLevelID4PenaltyInterest = nAcctLevelID4PenaltyInterest;
    }

    public Integer getNAcctLevelID4FreeInterest() {
        return nAcctLevelID4FreeInterest;
    }

    public void setNAcctLevelID4FreeInterest(Integer nAcctLevelID4FreeInterest) {
        this.nAcctLevelID4FreeInterest = nAcctLevelID4FreeInterest;
    }

    public Integer getNAcctLevelID4Postage() {
        return nAcctLevelID4Postage;
    }

    public void setNAcctLevelID4Postage(Integer nAcctLevelID4Postage) {
        this.nAcctLevelID4Postage = nAcctLevelID4Postage;
    }

    public Integer getNAcctLevelID4Stationary() {
        return nAcctLevelID4Stationary;
    }

    public void setNAcctLevelID4Stationary(Integer nAcctLevelID4Stationary) {
        this.nAcctLevelID4Stationary = nAcctLevelID4Stationary;
    }

    public Integer getNAcctLevelID4ArbitrationFees() {
        return nAcctLevelID4ArbitrationFees;
    }

    public void setNAcctLevelID4ArbitrationFees(Integer nAcctLevelID4ArbitrationFees) {
        this.nAcctLevelID4ArbitrationFees = nAcctLevelID4ArbitrationFees;
    }

    public Integer getNAcctLevelID4LawFees() {
        return nAcctLevelID4LawFees;
    }

    public void setNAcctLevelID4LawFees(Integer nAcctLevelID4LawFees) {
        this.nAcctLevelID4LawFees = nAcctLevelID4LawFees;
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

    public Integer getNType() {
        return nType;
    }

    public void setNType(Integer nType) {
        this.nType = nType;
    }

    public String getCType() {
        return cType;
    }

    public void setCType(String cType) {
        this.cType = cType;
    }

    public short getBActive() {
        return bActive;
    }

    public void setBActive(short bActive) {
        this.bActive = bActive;
    }

    public short getBLetGen() {
        return bLetGen;
    }

    public void setBLetGen(short bLetGen) {
        this.bLetGen = bLetGen;
    }

    public Integer getNPIntRateForID() {
        return nPIntRateForID;
    }

    public void setNPIntRateForID(Integer nPIntRateForID) {
        this.nPIntRateForID = nPIntRateForID;
    }

    public Integer getNPenaltyIntCal() {
        return nPenaltyIntCal;
    }

    public void setNPenaltyIntCal(Integer nPenaltyIntCal) {
        this.nPenaltyIntCal = nPenaltyIntCal;
    }

    public Integer getNPIntCalForID() {
        return nPIntCalForID;
    }

    public void setNPIntCalForID(Integer nPIntCalForID) {
        this.nPIntCalForID = nPIntCalForID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonTypeID != null ? nLonTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanTypes)) {
            return false;
        }
        BnkLonLoanTypes other = (BnkLonLoanTypes) object;
        if ((this.nLonTypeID == null && other.nLonTypeID != null) || (this.nLonTypeID != null && !this.nLonTypeID.equals(other.nLonTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanTypes[ nLonTypeID=" + nLonTypeID + " ]";
    }

    public Object getNAcctLevelID5PenaltyInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
