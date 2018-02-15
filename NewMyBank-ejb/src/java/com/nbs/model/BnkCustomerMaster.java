/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "bnk_CustomerMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkCustomerMaster.findAll", query = "SELECT b FROM BnkCustomerMaster b")
    , @NamedQuery(name = "BnkCustomerMaster.findByNCustomerID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nCustomerID = :nCustomerID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNSubSectionID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nSubSectionID = :nSubSectionID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNCustomerCategoryID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nCustomerCategoryID = :nCustomerCategoryID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNCustomerStatusID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nCustomerStatusID = :nCustomerStatusID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNTitleID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nTitleID = :nTitleID")
    , @NamedQuery(name = "BnkCustomerMaster.findByCCIFNo", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cCIFNo = :cCIFNo")
    , @NamedQuery(name = "BnkCustomerMaster.findByCCIFNoOld", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cCIFNoOld = :cCIFNoOld")
    , @NamedQuery(name = "BnkCustomerMaster.findByCInitials", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cInitials = :cInitials")
    , @NamedQuery(name = "BnkCustomerMaster.findByCFullName", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cFullName = :cFullName")
    , @NamedQuery(name = "BnkCustomerMaster.findByCFullNameAma", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cFullNameAma = :cFullNameAma")
    , @NamedQuery(name = "BnkCustomerMaster.findByCLastName", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cLastName = :cLastName")
    , @NamedQuery(name = "BnkCustomerMaster.findByCUseName", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cUseName = :cUseName")
    , @NamedQuery(name = "BnkCustomerMaster.findByBFeMale", query = "SELECT b FROM BnkCustomerMaster b WHERE b.bFeMale = :bFeMale")
    , @NamedQuery(name = "BnkCustomerMaster.findByNIDTypeID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nIDTypeID = :nIDTypeID")
    , @NamedQuery(name = "BnkCustomerMaster.findByCNICNo", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cNICNo = :cNICNo")
    , @NamedQuery(name = "BnkCustomerMaster.findByDNICIssuedDate", query = "SELECT b FROM BnkCustomerMaster b WHERE b.dNICIssuedDate = :dNICIssuedDate")
    , @NamedQuery(name = "BnkCustomerMaster.findByDDateOfBirth", query = "SELECT b FROM BnkCustomerMaster b WHERE b.dDateOfBirth = :dDateOfBirth")
    , @NamedQuery(name = "BnkCustomerMaster.findByDJoineDate", query = "SELECT b FROM BnkCustomerMaster b WHERE b.dJoineDate = :dJoineDate")
    , @NamedQuery(name = "BnkCustomerMaster.findByCMotherMadName", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cMotherMadName = :cMotherMadName")
    , @NamedQuery(name = "BnkCustomerMaster.findByNNationalityID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nNationalityID = :nNationalityID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNReligionID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nReligionID = :nReligionID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNCivilStatusID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nCivilStatusID = :nCivilStatusID")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPAddLine1", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPAddLine1 = :cPAddLine1")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPAddLine2", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPAddLine2 = :cPAddLine2")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPAddLine3", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPAddLine3 = :cPAddLine3")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPAddLine4", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPAddLine4 = :cPAddLine4")
    , @NamedQuery(name = "BnkCustomerMaster.findByCBAddLine1", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cBAddLine1 = :cBAddLine1")
    , @NamedQuery(name = "BnkCustomerMaster.findByCBAddLine2", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cBAddLine2 = :cBAddLine2")
    , @NamedQuery(name = "BnkCustomerMaster.findByCBAddLine3", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cBAddLine3 = :cBAddLine3")
    , @NamedQuery(name = "BnkCustomerMaster.findByCBAddLine4", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cBAddLine4 = :cBAddLine4")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPTelNo1", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPTelNo1 = :cPTelNo1")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPTelNo2", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPTelNo2 = :cPTelNo2")
    , @NamedQuery(name = "BnkCustomerMaster.findByCBTelNo1", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cBTelNo1 = :cBTelNo1")
    , @NamedQuery(name = "BnkCustomerMaster.findByCBTelNo2", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cBTelNo2 = :cBTelNo2")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPEmail", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPEmail = :cPEmail")
    , @NamedQuery(name = "BnkCustomerMaster.findByCBEmail", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cBEmail = :cBEmail")
    , @NamedQuery(name = "BnkCustomerMaster.findByCMemberShipNo", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cMemberShipNo = :cMemberShipNo")
    , @NamedQuery(name = "BnkCustomerMaster.findByDMemberShipDate", query = "SELECT b FROM BnkCustomerMaster b WHERE b.dMemberShipDate = :dMemberShipDate")
    , @NamedQuery(name = "BnkCustomerMaster.findByNMemAreaID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nMemAreaID = :nMemAreaID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNMemAreaGroupID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nMemAreaGroupID = :nMemAreaGroupID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNMemStatusID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nMemStatusID = :nMemStatusID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNMemPositionID", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nMemPositionID = :nMemPositionID")
    , @NamedQuery(name = "BnkCustomerMaster.findByNMemberShipFee", query = "SELECT b FROM BnkCustomerMaster b WHERE b.nMemberShipFee = :nMemberShipFee")
    , @NamedQuery(name = "BnkCustomerMaster.findByCPictureFileName", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cPictureFileName = :cPictureFileName")
    , @NamedQuery(name = "BnkCustomerMaster.findByCSignatureFileName", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cSignatureFileName = :cSignatureFileName")
    , @NamedQuery(name = "BnkCustomerMaster.findByCSigPath2", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cSigPath2 = :cSigPath2")
    , @NamedQuery(name = "BnkCustomerMaster.findByCSigPath3", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cSigPath3 = :cSigPath3")
    , @NamedQuery(name = "BnkCustomerMaster.findByCAddBy", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cAddBy = :cAddBy")
    , @NamedQuery(name = "BnkCustomerMaster.findByDAddDate", query = "SELECT b FROM BnkCustomerMaster b WHERE b.dAddDate = :dAddDate")
    , @NamedQuery(name = "BnkCustomerMaster.findByCEditBy", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cEditBy = :cEditBy")
    , @NamedQuery(name = "BnkCustomerMaster.findByDEditDate", query = "SELECT b FROM BnkCustomerMaster b WHERE b.dEditDate = :dEditDate")
    , @NamedQuery(name = "BnkCustomerMaster.findByBEditConfirm", query = "SELECT b FROM BnkCustomerMaster b WHERE b.bEditConfirm = :bEditConfirm")
    , @NamedQuery(name = "BnkCustomerMaster.findByDConfirmDate", query = "SELECT b FROM BnkCustomerMaster b WHERE b.dConfirmDate = :dConfirmDate")
    , @NamedQuery(name = "BnkCustomerMaster.findByCConfirmBy", query = "SELECT b FROM BnkCustomerMaster b WHERE b.cConfirmBy = :cConfirmBy")})
public class BnkCustomerMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nCustomerID")
    private Long nCustomerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nSubSectionID")
    private int nSubSectionID;
    @Column(name = "nCustomerCategoryID")
    private Short nCustomerCategoryID;
    @Column(name = "nCustomerStatusID")
    private Short nCustomerStatusID;
    @Column(name = "nTitleID")
    private Short nTitleID;
    @Size(max = 8)
    @Column(name = "cCIFNo")
    private String cCIFNo;
    @Size(max = 8)
    @Column(name = "cCIFNo_Old")
    private String cCIFNoOld;
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
    @OneToMany(mappedBy = "nCustomerID")
    private Collection<BnkDepDepositMaster> bnkDepDepositMasterCollection;

    public BnkCustomerMaster() {
    }

    public BnkCustomerMaster(Long nCustomerID) {
        this.nCustomerID = nCustomerID;
    }

    public BnkCustomerMaster(Long nCustomerID, int nSubSectionID, boolean bFeMale, short nMemAreaID, int nMemAreaGroupID, short nMemStatusID, short nMemPositionID) {
        this.nCustomerID = nCustomerID;
        this.nSubSectionID = nSubSectionID;
        this.bFeMale = bFeMale;
        this.nMemAreaID = nMemAreaID;
        this.nMemAreaGroupID = nMemAreaGroupID;
        this.nMemStatusID = nMemStatusID;
        this.nMemPositionID = nMemPositionID;
    }

    public Long getNCustomerID() {
        return nCustomerID;
    }

    public void setNCustomerID(Long nCustomerID) {
        this.nCustomerID = nCustomerID;
    }

    public int getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(int nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    public Short getNCustomerCategoryID() {
        return nCustomerCategoryID;
    }

    public void setNCustomerCategoryID(Short nCustomerCategoryID) {
        this.nCustomerCategoryID = nCustomerCategoryID;
    }

    public Short getNCustomerStatusID() {
        return nCustomerStatusID;
    }

    public void setNCustomerStatusID(Short nCustomerStatusID) {
        this.nCustomerStatusID = nCustomerStatusID;
    }

    public Short getNTitleID() {
        return nTitleID;
    }

    public void setNTitleID(Short nTitleID) {
        this.nTitleID = nTitleID;
    }

    public String getCCIFNo() {
        return cCIFNo;
    }

    public void setCCIFNo(String cCIFNo) {
        this.cCIFNo = cCIFNo;
    }

    public String getCCIFNoOld() {
        return cCIFNoOld;
    }

    public void setCCIFNoOld(String cCIFNoOld) {
        this.cCIFNoOld = cCIFNoOld;
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

    @XmlTransient
    public Collection<BnkDepDepositMaster> getBnkDepDepositMasterCollection() {
        return bnkDepDepositMasterCollection;
    }

    public void setBnkDepDepositMasterCollection(Collection<BnkDepDepositMaster> bnkDepDepositMasterCollection) {
        this.bnkDepDepositMasterCollection = bnkDepDepositMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nCustomerID != null ? nCustomerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkCustomerMaster)) {
            return false;
        }
        BnkCustomerMaster other = (BnkCustomerMaster) object;
        if ((this.nCustomerID == null && other.nCustomerID != null) || (this.nCustomerID != null && !this.nCustomerID.equals(other.nCustomerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.dao.hiuiuhiujk.BnkCustomerMaster[ nCustomerID=" + nCustomerID + " ]";
    }
    
}
