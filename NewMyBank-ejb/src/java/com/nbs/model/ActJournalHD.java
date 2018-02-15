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
@Table(name = "Act_Journal_HD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActJournalHD.findAll", query = "SELECT a FROM ActJournalHD a"),
    @NamedQuery(name = "ActJournalHD.findByNJournalHDID", query = "SELECT a FROM ActJournalHD a WHERE a.nJournalHDID = :nJournalHDID"),
    @NamedQuery(name = "ActJournalHD.findByCJournalHDID", query = "SELECT a FROM ActJournalHD a WHERE a.cJournalHDID = :cJournalHDID"),
    @NamedQuery(name = "ActJournalHD.findByNSubSectionID", query = "SELECT a FROM ActJournalHD a WHERE a.nSubSectionID = :nSubSectionID"),
    @NamedQuery(name = "ActJournalHD.findByNSubSectionIDTrn", query = "SELECT a FROM ActJournalHD a WHERE a.nSubSectionIDTrn = :nSubSectionIDTrn"),
    @NamedQuery(name = "ActJournalHD.findByDTrnDate", query = "SELECT a FROM ActJournalHD a WHERE a.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "ActJournalHD.findByCYearCode", query = "SELECT a FROM ActJournalHD a WHERE a.cYearCode = :cYearCode"),
    @NamedQuery(name = "ActJournalHD.findByNGLTrnID", query = "SELECT a FROM ActJournalHD a WHERE a.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "ActJournalHD.findByNGLTrnEffectID", query = "SELECT a FROM ActJournalHD a WHERE a.nGLTrnEffectID = :nGLTrnEffectID"),
    @NamedQuery(name = "ActJournalHD.findByNJournalStatusID", query = "SELECT a FROM ActJournalHD a WHERE a.nJournalStatusID = :nJournalStatusID"),
    @NamedQuery(name = "ActJournalHD.findByCDescription", query = "SELECT a FROM ActJournalHD a WHERE a.cDescription = :cDescription"),
    @NamedQuery(name = "ActJournalHD.findByCTrnRefNo", query = "SELECT a FROM ActJournalHD a WHERE a.cTrnRefNo = :cTrnRefNo"),
    @NamedQuery(name = "ActJournalHD.findByNAmount", query = "SELECT a FROM ActJournalHD a WHERE a.nAmount = :nAmount"),
    @NamedQuery(name = "ActJournalHD.findByBPosted", query = "SELECT a FROM ActJournalHD a WHERE a.bPosted = :bPosted"),
    @NamedQuery(name = "ActJournalHD.findByCAddBy", query = "SELECT a FROM ActJournalHD a WHERE a.cAddBy = :cAddBy"),
    @NamedQuery(name = "ActJournalHD.findByCAddDate", query = "SELECT a FROM ActJournalHD a WHERE a.cAddDate = :cAddDate")})
public class ActJournalHD implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nJournalHDID")
    private Long nJournalHDID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cJournalHDID")
    private String cJournalHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nSubSectionID")
    private int nSubSectionID;
    @Column(name = "nSubSectionID_Trn")
    private Integer nSubSectionIDTrn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.DATE)
    private Date dTrnDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cYearCode")
    private String cYearCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nGLTrnID")
    private int nGLTrnID;
    @Column(name = "nGLTrnEffectID")
    private Short nGLTrnEffectID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalStatusID")
    private int nJournalStatusID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "cDescription")
    private String cDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cTrnRefNo")
    private String cTrnRefNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAmount")
    private BigDecimal nAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bPosted")
    private boolean bPosted;
    @Size(max = 15)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "cAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cAddDate;

    public ActJournalHD() {
    }

    public ActJournalHD(Long nJournalHDID) {
        this.nJournalHDID = nJournalHDID;
    }

    public ActJournalHD(Long nJournalHDID, String cJournalHDID, int nSubSectionID, Date dTrnDate, String cYearCode, int nGLTrnID, int nJournalStatusID, String cDescription, String cTrnRefNo, BigDecimal nAmount, boolean bPosted) {
        this.nJournalHDID = nJournalHDID;
        this.cJournalHDID = cJournalHDID;
        this.nSubSectionID = nSubSectionID;
        this.dTrnDate = dTrnDate;
        this.cYearCode = cYearCode;
        this.nGLTrnID = nGLTrnID;
        this.nJournalStatusID = nJournalStatusID;
        this.cDescription = cDescription;
        this.cTrnRefNo = cTrnRefNo;
        this.nAmount = nAmount;
        this.bPosted = bPosted;
    }

    public Long getNJournalHDID() {
        return nJournalHDID;
    }

    public void setNJournalHDID(Long nJournalHDID) {
        this.nJournalHDID = nJournalHDID;
    }

    public String getCJournalHDID() {
        return cJournalHDID;
    }

    public void setCJournalHDID(String cJournalHDID) {
        this.cJournalHDID = cJournalHDID;
    }

    public int getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(int nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    public Integer getNSubSectionIDTrn() {
        return nSubSectionIDTrn;
    }

    public void setNSubSectionIDTrn(Integer nSubSectionIDTrn) {
        this.nSubSectionIDTrn = nSubSectionIDTrn;
    }

    public Date getDTrnDate() {
        return dTrnDate;
    }

    public void setDTrnDate(Date dTrnDate) {
        this.dTrnDate = dTrnDate;
    }

    public String getCYearCode() {
        return cYearCode;
    }

    public void setCYearCode(String cYearCode) {
        this.cYearCode = cYearCode;
    }

    public int getNGLTrnID() {
        return nGLTrnID;
    }

    public void setNGLTrnID(int nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
    }

    public Short getNGLTrnEffectID() {
        return nGLTrnEffectID;
    }

    public void setNGLTrnEffectID(Short nGLTrnEffectID) {
        this.nGLTrnEffectID = nGLTrnEffectID;
    }

    public int getNJournalStatusID() {
        return nJournalStatusID;
    }

    public void setNJournalStatusID(int nJournalStatusID) {
        this.nJournalStatusID = nJournalStatusID;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getCTrnRefNo() {
        return cTrnRefNo;
    }

    public void setCTrnRefNo(String cTrnRefNo) {
        this.cTrnRefNo = cTrnRefNo;
    }

    public BigDecimal getNAmount() {
        return nAmount;
    }

    public void setNAmount(BigDecimal nAmount) {
        this.nAmount = nAmount;
    }

    public boolean getBPosted() {
        return bPosted;
    }

    public void setBPosted(boolean bPosted) {
        this.bPosted = bPosted;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public Date getCAddDate() {
        return cAddDate;
    }

    public void setCAddDate(Date cAddDate) {
        this.cAddDate = cAddDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nJournalHDID != null ? nJournalHDID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActJournalHD)) {
            return false;
        }
        ActJournalHD other = (ActJournalHD) object;
        if ((this.nJournalHDID == null && other.nJournalHDID != null) || (this.nJournalHDID != null && !this.nJournalHDID.equals(other.nJournalHDID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActJournalHD[ nJournalHDID=" + nJournalHDID + " ]";
    }
    
}
