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
@Table(name = "psb_CustomerMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsbCustomerMaster.findAll", query = "SELECT p FROM PsbCustomerMaster p"),
    @NamedQuery(name = "PsbCustomerMaster.findByNPsbCustomerID", query = "SELECT p FROM PsbCustomerMaster p WHERE p.nPsbCustomerID = :nPsbCustomerID"),
    @NamedQuery(name = "PsbCustomerMaster.findByCPsbCIFNo", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cPsbCIFNo = :cPsbCIFNo"),
    @NamedQuery(name = "PsbCustomerMaster.findByCTaxNo", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cTaxNo = :cTaxNo"),
    @NamedQuery(name = "PsbCustomerMaster.findByCFullName", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cFullName = :cFullName"),
    @NamedQuery(name = "PsbCustomerMaster.findByCInitials", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cInitials = :cInitials"),
    @NamedQuery(name = "PsbCustomerMaster.findByCSurName", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cSurName = :cSurName"),
    @NamedQuery(name = "PsbCustomerMaster.findByCAddressLine1", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cAddressLine1 = :cAddressLine1"),
    @NamedQuery(name = "PsbCustomerMaster.findByCAddressLine2", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cAddressLine2 = :cAddressLine2"),
    @NamedQuery(name = "PsbCustomerMaster.findByCAddressLine3", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cAddressLine3 = :cAddressLine3"),
    @NamedQuery(name = "PsbCustomerMaster.findByCAddressLine4", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cAddressLine4 = :cAddressLine4"),
    @NamedQuery(name = "PsbCustomerMaster.findByCTelNo1", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cTelNo1 = :cTelNo1"),
    @NamedQuery(name = "PsbCustomerMaster.findByCTelNo2", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cTelNo2 = :cTelNo2"),
    @NamedQuery(name = "PsbCustomerMaster.findByCFaxNo", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cFaxNo = :cFaxNo"),
    @NamedQuery(name = "PsbCustomerMaster.findByCEmail", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cEmail = :cEmail"),
    @NamedQuery(name = "PsbCustomerMaster.findByCDrivingLicenNo", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cDrivingLicenNo = :cDrivingLicenNo"),
    @NamedQuery(name = "PsbCustomerMaster.findByCNicNo", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cNicNo = :cNicNo"),
    @NamedQuery(name = "PsbCustomerMaster.findByCPassportNo", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cPassportNo = :cPassportNo"),
    @NamedQuery(name = "PsbCustomerMaster.findByDDataOfBirth", query = "SELECT p FROM PsbCustomerMaster p WHERE p.dDataOfBirth = :dDataOfBirth"),
    @NamedQuery(name = "PsbCustomerMaster.findByDDateOfJoined", query = "SELECT p FROM PsbCustomerMaster p WHERE p.dDateOfJoined = :dDateOfJoined"),
    @NamedQuery(name = "PsbCustomerMaster.findByNNationalityID", query = "SELECT p FROM PsbCustomerMaster p WHERE p.nNationalityID = :nNationalityID"),
    @NamedQuery(name = "PsbCustomerMaster.findByCAddBy", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cAddBy = :cAddBy"),
    @NamedQuery(name = "PsbCustomerMaster.findByDAddDate", query = "SELECT p FROM PsbCustomerMaster p WHERE p.dAddDate = :dAddDate"),
    @NamedQuery(name = "PsbCustomerMaster.findByCEditBy", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cEditBy = :cEditBy"),
    @NamedQuery(name = "PsbCustomerMaster.findByDEditDate", query = "SELECT p FROM PsbCustomerMaster p WHERE p.dEditDate = :dEditDate"),
    @NamedQuery(name = "PsbCustomerMaster.findByCCompanyName", query = "SELECT p FROM PsbCustomerMaster p WHERE p.cCompanyName = :cCompanyName")})
public class PsbCustomerMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPsb_CustomerID")
    private Integer nPsbCustomerID;
    @Size(max = 6)
    @Column(name = "cPsb_CIFNo")
    private String cPsbCIFNo;
    @Size(max = 45)
    @Column(name = "cTaxNo")
    private String cTaxNo;
    @Size(max = 255)
    @Column(name = "cFullName")
    private String cFullName;
    @Size(max = 45)
    @Column(name = "cInitials")
    private String cInitials;
    @Size(max = 255)
    @Column(name = "cSurName")
    private String cSurName;
    @Size(max = 255)
    @Column(name = "cAddressLine1")
    private String cAddressLine1;
    @Size(max = 255)
    @Column(name = "cAddressLine2")
    private String cAddressLine2;
    @Size(max = 255)
    @Column(name = "cAddressLine3")
    private String cAddressLine3;
    @Size(max = 255)
    @Column(name = "cAddressLine4")
    private String cAddressLine4;
    @Size(max = 45)
    @Column(name = "cTelNo1")
    private String cTelNo1;
    @Size(max = 45)
    @Column(name = "cTelNo2")
    private String cTelNo2;
    @Size(max = 45)
    @Column(name = "cFaxNo")
    private String cFaxNo;
    @Size(max = 45)
    @Column(name = "cEmail")
    private String cEmail;
    @Size(max = 45)
    @Column(name = "cDrivingLicenNo")
    private String cDrivingLicenNo;
    @Size(max = 45)
    @Column(name = "cNicNo")
    private String cNicNo;
    @Size(max = 45)
    @Column(name = "cPassportNo")
    private String cPassportNo;
    @Column(name = "dDataOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dDataOfBirth;
    @Column(name = "dDateOfJoined")
    @Temporal(TemporalType.DATE)
    private Date dDateOfJoined;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nNationalityID")
    private int nNationalityID;
    @Size(max = 20)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "dAddDate")
    @Temporal(TemporalType.DATE)
    private Date dAddDate;
    @Size(max = 20)
    @Column(name = "cEditBy")
    private String cEditBy;
    @Column(name = "dEditDate")
    @Temporal(TemporalType.DATE)
    private Date dEditDate;
    @Size(max = 45)
    @Column(name = "cCompanyName")
    private String cCompanyName;

    public PsbCustomerMaster() {
    }

    public PsbCustomerMaster(Integer nPsbCustomerID) {
        this.nPsbCustomerID = nPsbCustomerID;
    }

    public PsbCustomerMaster(Integer nPsbCustomerID, int nNationalityID) {
        this.nPsbCustomerID = nPsbCustomerID;
        this.nNationalityID = nNationalityID;
    }

    public Integer getNPsbCustomerID() {
        return nPsbCustomerID;
    }

    public void setNPsbCustomerID(Integer nPsbCustomerID) {
        this.nPsbCustomerID = nPsbCustomerID;
    }

    public String getCPsbCIFNo() {
        return cPsbCIFNo;
    }

    public void setCPsbCIFNo(String cPsbCIFNo) {
        this.cPsbCIFNo = cPsbCIFNo;
    }

    public String getCTaxNo() {
        return cTaxNo;
    }

    public void setCTaxNo(String cTaxNo) {
        this.cTaxNo = cTaxNo;
    }

    public String getCFullName() {
        return cFullName;
    }

    public void setCFullName(String cFullName) {
        this.cFullName = cFullName;
    }

    public String getCInitials() {
        return cInitials;
    }

    public void setCInitials(String cInitials) {
        this.cInitials = cInitials;
    }

    public String getCSurName() {
        return cSurName;
    }

    public void setCSurName(String cSurName) {
        this.cSurName = cSurName;
    }

    public String getCAddressLine1() {
        return cAddressLine1;
    }

    public void setCAddressLine1(String cAddressLine1) {
        this.cAddressLine1 = cAddressLine1;
    }

    public String getCAddressLine2() {
        return cAddressLine2;
    }

    public void setCAddressLine2(String cAddressLine2) {
        this.cAddressLine2 = cAddressLine2;
    }

    public String getCAddressLine3() {
        return cAddressLine3;
    }

    public void setCAddressLine3(String cAddressLine3) {
        this.cAddressLine3 = cAddressLine3;
    }

    public String getCAddressLine4() {
        return cAddressLine4;
    }

    public void setCAddressLine4(String cAddressLine4) {
        this.cAddressLine4 = cAddressLine4;
    }

    public String getCTelNo1() {
        return cTelNo1;
    }

    public void setCTelNo1(String cTelNo1) {
        this.cTelNo1 = cTelNo1;
    }

    public String getCTelNo2() {
        return cTelNo2;
    }

    public void setCTelNo2(String cTelNo2) {
        this.cTelNo2 = cTelNo2;
    }

    public String getCFaxNo() {
        return cFaxNo;
    }

    public void setCFaxNo(String cFaxNo) {
        this.cFaxNo = cFaxNo;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCDrivingLicenNo() {
        return cDrivingLicenNo;
    }

    public void setCDrivingLicenNo(String cDrivingLicenNo) {
        this.cDrivingLicenNo = cDrivingLicenNo;
    }

    public String getCNicNo() {
        return cNicNo;
    }

    public void setCNicNo(String cNicNo) {
        this.cNicNo = cNicNo;
    }

    public String getCPassportNo() {
        return cPassportNo;
    }

    public void setCPassportNo(String cPassportNo) {
        this.cPassportNo = cPassportNo;
    }

    public Date getDDataOfBirth() {
        return dDataOfBirth;
    }

    public void setDDataOfBirth(Date dDataOfBirth) {
        this.dDataOfBirth = dDataOfBirth;
    }

    public Date getDDateOfJoined() {
        return dDateOfJoined;
    }

    public void setDDateOfJoined(Date dDateOfJoined) {
        this.dDateOfJoined = dDateOfJoined;
    }

    public int getNNationalityID() {
        return nNationalityID;
    }

    public void setNNationalityID(int nNationalityID) {
        this.nNationalityID = nNationalityID;
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

    public String getCCompanyName() {
        return cCompanyName;
    }

    public void setCCompanyName(String cCompanyName) {
        this.cCompanyName = cCompanyName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPsbCustomerID != null ? nPsbCustomerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsbCustomerMaster)) {
            return false;
        }
        PsbCustomerMaster other = (PsbCustomerMaster) object;
        if ((this.nPsbCustomerID == null && other.nPsbCustomerID != null) || (this.nPsbCustomerID != null && !this.nPsbCustomerID.equals(other.nPsbCustomerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.PsbCustomerMaster[ nPsbCustomerID=" + nPsbCustomerID + " ]";
    }
    
}
