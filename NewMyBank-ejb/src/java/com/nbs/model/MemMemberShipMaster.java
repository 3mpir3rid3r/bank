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
@Table(name = "mem_MemberShipMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemMemberShipMaster.findAll", query = "SELECT m FROM MemMemberShipMaster m"),
    @NamedQuery(name = "MemMemberShipMaster.findByNMemberID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nMemberID = :nMemberID"),
    @NamedQuery(name = "MemMemberShipMaster.findByNTitleID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nTitleID = :nTitleID"),
    @NamedQuery(name = "MemMemberShipMaster.findByCInitials", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cInitials = :cInitials"),
    @NamedQuery(name = "MemMemberShipMaster.findByCFullName", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cFullName = :cFullName"),
    @NamedQuery(name = "MemMemberShipMaster.findByCFullNameAma", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cFullNameAma = :cFullNameAma"),
    @NamedQuery(name = "MemMemberShipMaster.findByCLastName", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cLastName = :cLastName"),
    @NamedQuery(name = "MemMemberShipMaster.findByCUseName", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cUseName = :cUseName"),
    @NamedQuery(name = "MemMemberShipMaster.findByBFeMale", query = "SELECT m FROM MemMemberShipMaster m WHERE m.bFeMale = :bFeMale"),
    @NamedQuery(name = "MemMemberShipMaster.findByNIDTypeID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nIDTypeID = :nIDTypeID"),
    @NamedQuery(name = "MemMemberShipMaster.findByCNICNo", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cNICNo = :cNICNo"),
    @NamedQuery(name = "MemMemberShipMaster.findByDNICIssuedDate", query = "SELECT m FROM MemMemberShipMaster m WHERE m.dNICIssuedDate = :dNICIssuedDate"),
    @NamedQuery(name = "MemMemberShipMaster.findByDDateOfBirth", query = "SELECT m FROM MemMemberShipMaster m WHERE m.dDateOfBirth = :dDateOfBirth"),
    @NamedQuery(name = "MemMemberShipMaster.findByDJoineDate", query = "SELECT m FROM MemMemberShipMaster m WHERE m.dJoineDate = :dJoineDate"),
    @NamedQuery(name = "MemMemberShipMaster.findByCMotherMadName", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cMotherMadName = :cMotherMadName"),
    @NamedQuery(name = "MemMemberShipMaster.findByNNationalityID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nNationalityID = :nNationalityID"),
    @NamedQuery(name = "MemMemberShipMaster.findByNReligionID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nReligionID = :nReligionID"),
    @NamedQuery(name = "MemMemberShipMaster.findByNCivilStatusID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nCivilStatusID = :nCivilStatusID"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPAddLine1", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPAddLine1 = :cPAddLine1"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPAddLine2", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPAddLine2 = :cPAddLine2"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPAddLine3", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPAddLine3 = :cPAddLine3"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPAddLine4", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPAddLine4 = :cPAddLine4"),
    @NamedQuery(name = "MemMemberShipMaster.findByCBAddLine1", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cBAddLine1 = :cBAddLine1"),
    @NamedQuery(name = "MemMemberShipMaster.findByCBAddLine2", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cBAddLine2 = :cBAddLine2"),
    @NamedQuery(name = "MemMemberShipMaster.findByCBAddLine3", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cBAddLine3 = :cBAddLine3"),
    @NamedQuery(name = "MemMemberShipMaster.findByCBAddLine4", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cBAddLine4 = :cBAddLine4"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPTelNo1", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPTelNo1 = :cPTelNo1"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPTelNo2", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPTelNo2 = :cPTelNo2"),
    @NamedQuery(name = "MemMemberShipMaster.findByCBTelNo1", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cBTelNo1 = :cBTelNo1"),
    @NamedQuery(name = "MemMemberShipMaster.findByCBTelNo2", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cBTelNo2 = :cBTelNo2"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPEmail", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPEmail = :cPEmail"),
    @NamedQuery(name = "MemMemberShipMaster.findByCBEmail", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cBEmail = :cBEmail"),
    @NamedQuery(name = "MemMemberShipMaster.findByCMemberShipNo", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cMemberShipNo = :cMemberShipNo"),
    @NamedQuery(name = "MemMemberShipMaster.findByDMemberShipDate", query = "SELECT m FROM MemMemberShipMaster m WHERE m.dMemberShipDate = :dMemberShipDate"),
    @NamedQuery(name = "MemMemberShipMaster.findByNMemAreaID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nMemAreaID = :nMemAreaID"),
    @NamedQuery(name = "MemMemberShipMaster.findByNMemAreaGroupID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nMemAreaGroupID = :nMemAreaGroupID"),
    @NamedQuery(name = "MemMemberShipMaster.findByNMemStatusID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nMemStatusID = :nMemStatusID"),
    @NamedQuery(name = "MemMemberShipMaster.findByNMemPositionID", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nMemPositionID = :nMemPositionID"),
    @NamedQuery(name = "MemMemberShipMaster.findByNMemberShipFee", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nMemberShipFee = :nMemberShipFee"),
    @NamedQuery(name = "MemMemberShipMaster.findByCPictureFileName", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cPictureFileName = :cPictureFileName"),
    @NamedQuery(name = "MemMemberShipMaster.findByCSignatureFileName", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cSignatureFileName = :cSignatureFileName"),
    @NamedQuery(name = "MemMemberShipMaster.findByCSigPath2", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cSigPath2 = :cSigPath2"),
    @NamedQuery(name = "MemMemberShipMaster.findByCSigPath3", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cSigPath3 = :cSigPath3"),
    @NamedQuery(name = "MemMemberShipMaster.findByCAddBy", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cAddBy = :cAddBy"),
    @NamedQuery(name = "MemMemberShipMaster.findByDAddDate", query = "SELECT m FROM MemMemberShipMaster m WHERE m.dAddDate = :dAddDate"),
    @NamedQuery(name = "MemMemberShipMaster.findByCEditBy", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cEditBy = :cEditBy"),
    @NamedQuery(name = "MemMemberShipMaster.findByDEditDate", query = "SELECT m FROM MemMemberShipMaster m WHERE m.dEditDate = :dEditDate"),
    @NamedQuery(name = "MemMemberShipMaster.findByBEditConfirm", query = "SELECT m FROM MemMemberShipMaster m WHERE m.bEditConfirm = :bEditConfirm"),
    @NamedQuery(name = "MemMemberShipMaster.findByDConfirmDate", query = "SELECT m FROM MemMemberShipMaster m WHERE m.dConfirmDate = :dConfirmDate"),
    @NamedQuery(name = "MemMemberShipMaster.findByCConfirmBy", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cConfirmBy = :cConfirmBy"),
    @NamedQuery(name = "MemMemberShipMaster.findByCOcupation", query = "SELECT m FROM MemMemberShipMaster m WHERE m.cOcupation = :cOcupation"),
    @NamedQuery(name = "MemMemberShipMaster.findByNNoOfShares", query = "SELECT m FROM MemMemberShipMaster m WHERE m.nNoOfShares = :nNoOfShares")})
public class MemMemberShipMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nMemberID")
    private Long nMemberID;
    @Column(name = "nTitleID")
    private Short nTitleID;
    @Size(max = 50)
    @Column(name = "cInitials")
    private String cInitials;
    @Size(max = 200)
    @Column(name = "cFullName")
    private String cFullName;
    @Size(max = 200)
    @Column(name = "cFullName_Ama")
    private String cFullNameAma;
    @Size(max = 150)
    @Column(name = "cLastName")
    private String cLastName;
    @Size(max = 50)
    @Column(name = "cUseName")
    private String cUseName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bFeMale")
    private boolean bFeMale;
    @Column(name = "nIDTypeID")
    private Short nIDTypeID;
    @Size(max = 20)
    @Column(name = "cNICNo")
    private String cNICNo;
    @Column(name = "dNICIssuedDate")
    @Temporal(TemporalType.DATE)
    private Date dNICIssuedDate;
    @Column(name = "dDateOfBirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dDateOfBirth;
    @Column(name = "dJoineDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dJoineDate;
    @Size(max = 50)
    @Column(name = "cMotherMadName")
    private String cMotherMadName;
    @Column(name = "nNationalityID")
    private Short nNationalityID;
    @Column(name = "nReligionID")
    private Short nReligionID;
    @Column(name = "nCivilStatusID")
    private Short nCivilStatusID;
    @Size(max = 75)
    @Column(name = "cPAddLine1")
    private String cPAddLine1;
    @Size(max = 75)
    @Column(name = "cPAddLine2")
    private String cPAddLine2;
    @Size(max = 75)
    @Column(name = "cPAddLine3")
    private String cPAddLine3;
    @Size(max = 75)
    @Column(name = "cPAddLine4")
    private String cPAddLine4;
    @Size(max = 75)
    @Column(name = "cBAddLine1")
    private String cBAddLine1;
    @Size(max = 75)
    @Column(name = "cBAddLine2")
    private String cBAddLine2;
    @Size(max = 75)
    @Column(name = "cBAddLine3")
    private String cBAddLine3;
    @Size(max = 75)
    @Column(name = "cBAddLine4")
    private String cBAddLine4;
    @Size(max = 50)
    @Column(name = "cPTelNo1")
    private String cPTelNo1;
    @Size(max = 50)
    @Column(name = "cPTelNo2")
    private String cPTelNo2;
    @Size(max = 50)
    @Column(name = "cBTelNo1")
    private String cBTelNo1;
    @Size(max = 50)
    @Column(name = "cBTelNo2")
    private String cBTelNo2;
    @Size(max = 50)
    @Column(name = "cPEmail")
    private String cPEmail;
    @Size(max = 50)
    @Column(name = "cBEmail")
    private String cBEmail;
    @Size(max = 10)
    @Column(name = "cMemberShipNo")
    private String cMemberShipNo;
    @Column(name = "dMemberShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dMemberShipDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMemAreaID")
    private short nMemAreaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMemAreaGroupID")
    private int nMemAreaGroupID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMemStatusID")
    private short nMemStatusID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMemPositionID")
    private short nMemPositionID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nMemberShipFee")
    private BigDecimal nMemberShipFee;
    @Size(max = 50)
    @Column(name = "cPictureFileName")
    private String cPictureFileName;
    @Size(max = 50)
    @Column(name = "cSignatureFileName")
    private String cSignatureFileName;
    @Size(max = 50)
    @Column(name = "cSigPath2")
    private String cSigPath2;
    @Size(max = 50)
    @Column(name = "cSigPath3")
    private String cSigPath3;
    @Size(max = 25)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "dAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dAddDate;
    @Size(max = 25)
    @Column(name = "cEditBy")
    private String cEditBy;
    @Column(name = "dEditDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dEditDate;
    @Column(name = "bEditConfirm")
    private Boolean bEditConfirm;
    @Column(name = "dConfirmDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dConfirmDate;
    @Size(max = 30)
    @Column(name = "cConfirmBy")
    private String cConfirmBy;
    @Size(max = 100)
    @Column(name = "cOcupation")
    private String cOcupation;
    @Column(name = "nNoOfShares")
    private Integer nNoOfShares;

    public MemMemberShipMaster() {
    }

    public MemMemberShipMaster(Long nMemberID) {
        this.nMemberID = nMemberID;
    }

    public MemMemberShipMaster(Long nMemberID, boolean bFeMale, short nMemAreaID, int nMemAreaGroupID, short nMemStatusID, short nMemPositionID) {
        this.nMemberID = nMemberID;
        this.bFeMale = bFeMale;
        this.nMemAreaID = nMemAreaID;
        this.nMemAreaGroupID = nMemAreaGroupID;
        this.nMemStatusID = nMemStatusID;
        this.nMemPositionID = nMemPositionID;
    }

    public Long getNMemberID() {
        return nMemberID;
    }

    public void setNMemberID(Long nMemberID) {
        this.nMemberID = nMemberID;
    }

    public Short getNTitleID() {
        return nTitleID;
    }

    public void setNTitleID(Short nTitleID) {
        this.nTitleID = nTitleID;
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

    public String getCFullNameAma() {
        return cFullNameAma;
    }

    public void setCFullNameAma(String cFullNameAma) {
        this.cFullNameAma = cFullNameAma;
    }

    public String getCLastName() {
        return cLastName;
    }

    public void setCLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getCUseName() {
        return cUseName;
    }

    public void setCUseName(String cUseName) {
        this.cUseName = cUseName;
    }

    public boolean getBFeMale() {
        return bFeMale;
    }

    public void setBFeMale(boolean bFeMale) {
        this.bFeMale = bFeMale;
    }

    public Short getNIDTypeID() {
        return nIDTypeID;
    }

    public void setNIDTypeID(Short nIDTypeID) {
        this.nIDTypeID = nIDTypeID;
    }

    public String getCNICNo() {
        return cNICNo;
    }

    public void setCNICNo(String cNICNo) {
        this.cNICNo = cNICNo;
    }

    public Date getDNICIssuedDate() {
        return dNICIssuedDate;
    }

    public void setDNICIssuedDate(Date dNICIssuedDate) {
        this.dNICIssuedDate = dNICIssuedDate;
    }

    public Date getDDateOfBirth() {
        return dDateOfBirth;
    }

    public void setDDateOfBirth(Date dDateOfBirth) {
        this.dDateOfBirth = dDateOfBirth;
    }

    public Date getDJoineDate() {
        return dJoineDate;
    }

    public void setDJoineDate(Date dJoineDate) {
        this.dJoineDate = dJoineDate;
    }

    public String getCMotherMadName() {
        return cMotherMadName;
    }

    public void setCMotherMadName(String cMotherMadName) {
        this.cMotherMadName = cMotherMadName;
    }

    public Short getNNationalityID() {
        return nNationalityID;
    }

    public void setNNationalityID(Short nNationalityID) {
        this.nNationalityID = nNationalityID;
    }

    public Short getNReligionID() {
        return nReligionID;
    }

    public void setNReligionID(Short nReligionID) {
        this.nReligionID = nReligionID;
    }

    public Short getNCivilStatusID() {
        return nCivilStatusID;
    }

    public void setNCivilStatusID(Short nCivilStatusID) {
        this.nCivilStatusID = nCivilStatusID;
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

    public String getCBAddLine1() {
        return cBAddLine1;
    }

    public void setCBAddLine1(String cBAddLine1) {
        this.cBAddLine1 = cBAddLine1;
    }

    public String getCBAddLine2() {
        return cBAddLine2;
    }

    public void setCBAddLine2(String cBAddLine2) {
        this.cBAddLine2 = cBAddLine2;
    }

    public String getCBAddLine3() {
        return cBAddLine3;
    }

    public void setCBAddLine3(String cBAddLine3) {
        this.cBAddLine3 = cBAddLine3;
    }

    public String getCBAddLine4() {
        return cBAddLine4;
    }

    public void setCBAddLine4(String cBAddLine4) {
        this.cBAddLine4 = cBAddLine4;
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

    public String getCBTelNo1() {
        return cBTelNo1;
    }

    public void setCBTelNo1(String cBTelNo1) {
        this.cBTelNo1 = cBTelNo1;
    }

    public String getCBTelNo2() {
        return cBTelNo2;
    }

    public void setCBTelNo2(String cBTelNo2) {
        this.cBTelNo2 = cBTelNo2;
    }

    public String getCPEmail() {
        return cPEmail;
    }

    public void setCPEmail(String cPEmail) {
        this.cPEmail = cPEmail;
    }

    public String getCBEmail() {
        return cBEmail;
    }

    public void setCBEmail(String cBEmail) {
        this.cBEmail = cBEmail;
    }

    public String getCMemberShipNo() {
        return cMemberShipNo;
    }

    public void setCMemberShipNo(String cMemberShipNo) {
        this.cMemberShipNo = cMemberShipNo;
    }

    public Date getDMemberShipDate() {
        return dMemberShipDate;
    }

    public void setDMemberShipDate(Date dMemberShipDate) {
        this.dMemberShipDate = dMemberShipDate;
    }

    public short getNMemAreaID() {
        return nMemAreaID;
    }

    public void setNMemAreaID(short nMemAreaID) {
        this.nMemAreaID = nMemAreaID;
    }

    public int getNMemAreaGroupID() {
        return nMemAreaGroupID;
    }

    public void setNMemAreaGroupID(int nMemAreaGroupID) {
        this.nMemAreaGroupID = nMemAreaGroupID;
    }

    public short getNMemStatusID() {
        return nMemStatusID;
    }

    public void setNMemStatusID(short nMemStatusID) {
        this.nMemStatusID = nMemStatusID;
    }

    public short getNMemPositionID() {
        return nMemPositionID;
    }

    public void setNMemPositionID(short nMemPositionID) {
        this.nMemPositionID = nMemPositionID;
    }

    public BigDecimal getNMemberShipFee() {
        return nMemberShipFee;
    }

    public void setNMemberShipFee(BigDecimal nMemberShipFee) {
        this.nMemberShipFee = nMemberShipFee;
    }

    public String getCPictureFileName() {
        return cPictureFileName;
    }

    public void setCPictureFileName(String cPictureFileName) {
        this.cPictureFileName = cPictureFileName;
    }

    public String getCSignatureFileName() {
        return cSignatureFileName;
    }

    public void setCSignatureFileName(String cSignatureFileName) {
        this.cSignatureFileName = cSignatureFileName;
    }

    public String getCSigPath2() {
        return cSigPath2;
    }

    public void setCSigPath2(String cSigPath2) {
        this.cSigPath2 = cSigPath2;
    }

    public String getCSigPath3() {
        return cSigPath3;
    }

    public void setCSigPath3(String cSigPath3) {
        this.cSigPath3 = cSigPath3;
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

    public String getCOcupation() {
        return cOcupation;
    }

    public void setCOcupation(String cOcupation) {
        this.cOcupation = cOcupation;
    }

    public Integer getNNoOfShares() {
        return nNoOfShares;
    }

    public void setNNoOfShares(Integer nNoOfShares) {
        this.nNoOfShares = nNoOfShares;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMemberID != null ? nMemberID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemMemberShipMaster)) {
            return false;
        }
        MemMemberShipMaster other = (MemMemberShipMaster) object;
        if ((this.nMemberID == null && other.nMemberID != null) || (this.nMemberID != null && !this.nMemberID.equals(other.nMemberID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.MemMemberShipMaster[ nMemberID=" + nMemberID + " ]";
    }
    
}
