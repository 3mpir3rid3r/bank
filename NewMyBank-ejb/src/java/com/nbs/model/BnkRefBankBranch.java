/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.model;

import java.io.Serializable;
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
@Table(name = "bnk_RefBankBranch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkRefBankBranch.findAll", query = "SELECT b FROM BnkRefBankBranch b"),
    @NamedQuery(name = "BnkRefBankBranch.findByNBankBranchID", query = "SELECT b FROM BnkRefBankBranch b WHERE b.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "BnkRefBankBranch.findByNSubSectionID", query = "SELECT b FROM BnkRefBankBranch b WHERE b.nSubSectionID = :nSubSectionID"),
    @NamedQuery(name = "BnkRefBankBranch.findByCBankBranchCode", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cBankBranchCode = :cBankBranchCode"),
    @NamedQuery(name = "BnkRefBankBranch.findByCBankName", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cBankName = :cBankName"),
    @NamedQuery(name = "BnkRefBankBranch.findByCBankNameSin", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cBankNameSin = :cBankNameSin"),
    @NamedQuery(name = "BnkRefBankBranch.findByCShortName", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cShortName = :cShortName"),
    @NamedQuery(name = "BnkRefBankBranch.findByCRegNo", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cRegNo = :cRegNo"),
    @NamedQuery(name = "BnkRefBankBranch.findByDStartDate", query = "SELECT b FROM BnkRefBankBranch b WHERE b.dStartDate = :dStartDate"),
    @NamedQuery(name = "BnkRefBankBranch.findByDRegDate", query = "SELECT b FROM BnkRefBankBranch b WHERE b.dRegDate = :dRegDate"),
    @NamedQuery(name = "BnkRefBankBranch.findByCDistrict", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cDistrict = :cDistrict"),
    @NamedQuery(name = "BnkRefBankBranch.findByCElectrorate", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cElectrorate = :cElectrorate"),
    @NamedQuery(name = "BnkRefBankBranch.findByCProvins", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cProvins = :cProvins"),
    @NamedQuery(name = "BnkRefBankBranch.findByCPoliceDevi", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cPoliceDevi = :cPoliceDevi"),
    @NamedQuery(name = "BnkRefBankBranch.findByCAdrs1", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cAdrs1 = :cAdrs1"),
    @NamedQuery(name = "BnkRefBankBranch.findByCAdrs2", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cAdrs2 = :cAdrs2"),
    @NamedQuery(name = "BnkRefBankBranch.findByCAdrs3", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cAdrs3 = :cAdrs3"),
    @NamedQuery(name = "BnkRefBankBranch.findByCAdrs4", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cAdrs4 = :cAdrs4"),
    @NamedQuery(name = "BnkRefBankBranch.findByCTel1", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cTel1 = :cTel1"),
    @NamedQuery(name = "BnkRefBankBranch.findByCTel2", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cTel2 = :cTel2"),
    @NamedQuery(name = "BnkRefBankBranch.findByCEmail", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cEmail = :cEmail"),
    @NamedQuery(name = "BnkRefBankBranch.findByCOurVision", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cOurVision = :cOurVision"),
    @NamedQuery(name = "BnkRefBankBranch.findByCOurMision", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cOurMision = :cOurMision"),
    @NamedQuery(name = "BnkRefBankBranch.findByNAcctCahInHandID", query = "SELECT b FROM BnkRefBankBranch b WHERE b.nAcctCahInHandID = :nAcctCahInHandID"),
    @NamedQuery(name = "BnkRefBankBranch.findByCLoanLettHD1", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cLoanLettHD1 = :cLoanLettHD1"),
    @NamedQuery(name = "BnkRefBankBranch.findByCLoanLettHD2", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cLoanLettHD2 = :cLoanLettHD2"),
    @NamedQuery(name = "BnkRefBankBranch.findByCLoanLettHD3", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cLoanLettHD3 = :cLoanLettHD3"),
    @NamedQuery(name = "BnkRefBankBranch.findByCPBCoverPageName", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cPBCoverPageName = :cPBCoverPageName"),
    @NamedQuery(name = "BnkRefBankBranch.findByCMPCSLable", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cMPCSLable = :cMPCSLable"),
    @NamedQuery(name = "BnkRefBankBranch.findByCBankLable", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cBankLable = :cBankLable"),
    @NamedQuery(name = "BnkRefBankBranch.findByCBranchLable", query = "SELECT b FROM BnkRefBankBranch b WHERE b.cBranchLable = :cBranchLable"),
    @NamedQuery(name = "BnkRefBankBranch.findByDDepositStartDate", query = "SELECT b FROM BnkRefBankBranch b WHERE b.dDepositStartDate = :dDepositStartDate")})
public class BnkRefBankBranch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nBankBranchID")
    private Integer nBankBranchID;
    @Column(name = "nSubSectionID")
    private Integer nSubSectionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cBankBranchCode")
    private String cBankBranchCode;
    @Size(max = 150)
    @Column(name = "cBankName")
    private String cBankName;
    @Size(max = 50)
    @Column(name = "cBankName_Sin")
    private String cBankNameSin;
    @Size(max = 50)
    @Column(name = "cShortName")
    private String cShortName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cRegNo")
    private String cRegNo;
    @Column(name = "dStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dStartDate;
    @Column(name = "dRegDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dRegDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cDistrict")
    private String cDistrict;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cElectrorate")
    private String cElectrorate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cProvins")
    private String cProvins;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cPoliceDevi")
    private String cPoliceDevi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cAdrs1")
    private String cAdrs1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cAdrs2")
    private String cAdrs2;
    @Size(max = 50)
    @Column(name = "cAdrs3")
    private String cAdrs3;
    @Size(max = 50)
    @Column(name = "cAdrs4")
    private String cAdrs4;
    @Size(max = 15)
    @Column(name = "cTel1")
    private String cTel1;
    @Size(max = 15)
    @Column(name = "cTel2")
    private String cTel2;
    @Size(max = 50)
    @Column(name = "cEmail")
    private String cEmail;
    @Size(max = 255)
    @Column(name = "cOurVision")
    private String cOurVision;
    @Size(max = 255)
    @Column(name = "cOurMision")
    private String cOurMision;
    @Column(name = "nAcctCahInHandID")
    private Integer nAcctCahInHandID;
    @Size(max = 100)
    @Column(name = "cLoan_Lett_HD_1")
    private String cLoanLettHD1;
    @Size(max = 100)
    @Column(name = "cLoan_Lett_HD_2")
    private String cLoanLettHD2;
    @Size(max = 100)
    @Column(name = "cLoan_Lett_HD_3")
    private String cLoanLettHD3;
    @Size(max = 100)
    @Column(name = "cPBCoverPageName")
    private String cPBCoverPageName;
    @Size(max = 50)
    @Column(name = "cMPCSLable")
    private String cMPCSLable;
    @Size(max = 50)
    @Column(name = "cBankLable")
    private String cBankLable;
    @Size(max = 50)
    @Column(name = "cBranchLable")
    private String cBranchLable;
    @Column(name = "dDepositStartDate")
    @Temporal(TemporalType.DATE)
    private Date dDepositStartDate;

    public BnkRefBankBranch() {
    }

    public BnkRefBankBranch(Integer nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public BnkRefBankBranch(Integer nBankBranchID, String cBankBranchCode, String cRegNo, String cDistrict, String cElectrorate, String cProvins, String cPoliceDevi, String cAdrs1, String cAdrs2) {
        this.nBankBranchID = nBankBranchID;
        this.cBankBranchCode = cBankBranchCode;
        this.cRegNo = cRegNo;
        this.cDistrict = cDistrict;
        this.cElectrorate = cElectrorate;
        this.cProvins = cProvins;
        this.cPoliceDevi = cPoliceDevi;
        this.cAdrs1 = cAdrs1;
        this.cAdrs2 = cAdrs2;
    }

    public Integer getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(Integer nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public Integer getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(Integer nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    public String getCBankBranchCode() {
        return cBankBranchCode;
    }

    public void setCBankBranchCode(String cBankBranchCode) {
        this.cBankBranchCode = cBankBranchCode;
    }

    public String getCBankName() {
        return cBankName;
    }

    public void setCBankName(String cBankName) {
        this.cBankName = cBankName;
    }

    public String getCBankNameSin() {
        return cBankNameSin;
    }

    public void setCBankNameSin(String cBankNameSin) {
        this.cBankNameSin = cBankNameSin;
    }

    public String getCShortName() {
        return cShortName;
    }

    public void setCShortName(String cShortName) {
        this.cShortName = cShortName;
    }

    public String getCRegNo() {
        return cRegNo;
    }

    public void setCRegNo(String cRegNo) {
        this.cRegNo = cRegNo;
    }

    public Date getDStartDate() {
        return dStartDate;
    }

    public void setDStartDate(Date dStartDate) {
        this.dStartDate = dStartDate;
    }

    public Date getDRegDate() {
        return dRegDate;
    }

    public void setDRegDate(Date dRegDate) {
        this.dRegDate = dRegDate;
    }

    public String getCDistrict() {
        return cDistrict;
    }

    public void setCDistrict(String cDistrict) {
        this.cDistrict = cDistrict;
    }

    public String getCElectrorate() {
        return cElectrorate;
    }

    public void setCElectrorate(String cElectrorate) {
        this.cElectrorate = cElectrorate;
    }

    public String getCProvins() {
        return cProvins;
    }

    public void setCProvins(String cProvins) {
        this.cProvins = cProvins;
    }

    public String getCPoliceDevi() {
        return cPoliceDevi;
    }

    public void setCPoliceDevi(String cPoliceDevi) {
        this.cPoliceDevi = cPoliceDevi;
    }

    public String getCAdrs1() {
        return cAdrs1;
    }

    public void setCAdrs1(String cAdrs1) {
        this.cAdrs1 = cAdrs1;
    }

    public String getCAdrs2() {
        return cAdrs2;
    }

    public void setCAdrs2(String cAdrs2) {
        this.cAdrs2 = cAdrs2;
    }

    public String getCAdrs3() {
        return cAdrs3;
    }

    public void setCAdrs3(String cAdrs3) {
        this.cAdrs3 = cAdrs3;
    }

    public String getCAdrs4() {
        return cAdrs4;
    }

    public void setCAdrs4(String cAdrs4) {
        this.cAdrs4 = cAdrs4;
    }

    public String getCTel1() {
        return cTel1;
    }

    public void setCTel1(String cTel1) {
        this.cTel1 = cTel1;
    }

    public String getCTel2() {
        return cTel2;
    }

    public void setCTel2(String cTel2) {
        this.cTel2 = cTel2;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCOurVision() {
        return cOurVision;
    }

    public void setCOurVision(String cOurVision) {
        this.cOurVision = cOurVision;
    }

    public String getCOurMision() {
        return cOurMision;
    }

    public void setCOurMision(String cOurMision) {
        this.cOurMision = cOurMision;
    }

    public Integer getNAcctCahInHandID() {
        return nAcctCahInHandID;
    }

    public void setNAcctCahInHandID(Integer nAcctCahInHandID) {
        this.nAcctCahInHandID = nAcctCahInHandID;
    }

    public String getCLoanLettHD1() {
        return cLoanLettHD1;
    }

    public void setCLoanLettHD1(String cLoanLettHD1) {
        this.cLoanLettHD1 = cLoanLettHD1;
    }

    public String getCLoanLettHD2() {
        return cLoanLettHD2;
    }

    public void setCLoanLettHD2(String cLoanLettHD2) {
        this.cLoanLettHD2 = cLoanLettHD2;
    }

    public String getCLoanLettHD3() {
        return cLoanLettHD3;
    }

    public void setCLoanLettHD3(String cLoanLettHD3) {
        this.cLoanLettHD3 = cLoanLettHD3;
    }

    public String getCPBCoverPageName() {
        return cPBCoverPageName;
    }

    public void setCPBCoverPageName(String cPBCoverPageName) {
        this.cPBCoverPageName = cPBCoverPageName;
    }

    public String getCMPCSLable() {
        return cMPCSLable;
    }

    public void setCMPCSLable(String cMPCSLable) {
        this.cMPCSLable = cMPCSLable;
    }

    public String getCBankLable() {
        return cBankLable;
    }

    public void setCBankLable(String cBankLable) {
        this.cBankLable = cBankLable;
    }

    public String getCBranchLable() {
        return cBranchLable;
    }

    public void setCBranchLable(String cBranchLable) {
        this.cBranchLable = cBranchLable;
    }

    public Date getDDepositStartDate() {
        return dDepositStartDate;
    }

    public void setDDepositStartDate(Date dDepositStartDate) {
        this.dDepositStartDate = dDepositStartDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nBankBranchID != null ? nBankBranchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkRefBankBranch)) {
            return false;
        }
        BnkRefBankBranch other = (BnkRefBankBranch) object;
        if ((this.nBankBranchID == null && other.nBankBranchID != null) || (this.nBankBranchID != null && !this.nBankBranchID.equals(other.nBankBranchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkRefBankBranch[ nBankBranchID=" + nBankBranchID + " ]";
    }

}
