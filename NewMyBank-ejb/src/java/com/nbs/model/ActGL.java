/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Act_GL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActGL.findAll", query = "SELECT a FROM ActGL a"),
    @NamedQuery(name = "ActGL.findByNGLID", query = "SELECT a FROM ActGL a WHERE a.nGLID = :nGLID"),
    @NamedQuery(name = "ActGL.findByNGLTrnID", query = "SELECT a FROM ActGL a WHERE a.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "ActGL.findByNSubSectionIDTrn", query = "SELECT a FROM ActGL a WHERE a.nSubSectionIDTrn = :nSubSectionIDTrn"),
    @NamedQuery(name = "ActGL.findByDTrnDate", query = "SELECT a FROM ActGL a WHERE a.dTrnDate = :dTrnDate"),
    @NamedQuery(name = "ActGL.findByNJournalHDID", query = "SELECT a FROM ActGL a WHERE a.nJournalHDID = :nJournalHDID"),
    @NamedQuery(name = "ActGL.findByCJournalHDID", query = "SELECT a FROM ActGL a WHERE a.cJournalHDID = :cJournalHDID"),
    @NamedQuery(name = "ActGL.findByNJournalDTID", query = "SELECT a FROM ActGL a WHERE a.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "ActGL.findByNCashBookDr", query = "SELECT a FROM ActGL a WHERE a.nCashBookDr = :nCashBookDr"),
    @NamedQuery(name = "ActGL.findByNCashBookCr", query = "SELECT a FROM ActGL a WHERE a.nCashBookCr = :nCashBookCr"),
    @NamedQuery(name = "ActGL.findByNJournalDr", query = "SELECT a FROM ActGL a WHERE a.nJournalDr = :nJournalDr"),
    @NamedQuery(name = "ActGL.findByNJournalCr", query = "SELECT a FROM ActGL a WHERE a.nJournalCr = :nJournalCr"),
    @NamedQuery(name = "ActGL.findByCType", query = "SELECT a FROM ActGL a WHERE a.cType = :cType"),
    @NamedQuery(name = "ActGL.findByBInAudit", query = "SELECT a FROM ActGL a WHERE a.bInAudit = :bInAudit"),
    @NamedQuery(name = "ActGL.findByBOutAudit", query = "SELECT a FROM ActGL a WHERE a.bOutAudit = :bOutAudit"),
    @NamedQuery(name = "ActGL.findByDInAuditDate", query = "SELECT a FROM ActGL a WHERE a.dInAuditDate = :dInAuditDate"),
    @NamedQuery(name = "ActGL.findByDOutAuditDate", query = "SELECT a FROM ActGL a WHERE a.dOutAuditDate = :dOutAuditDate"),
    @NamedQuery(name = "ActGL.findByCInAuditBy", query = "SELECT a FROM ActGL a WHERE a.cInAuditBy = :cInAuditBy"),
    @NamedQuery(name = "ActGL.findByCOutAuditBy", query = "SELECT a FROM ActGL a WHERE a.cOutAuditBy = :cOutAuditBy")})
public class ActGL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nGLID")
    private Long nGLID;
    @Column(name = "nGLTrnID")
    private Integer nGLTrnID;
    @Column(name = "nSubSectionID_Trn")
    private Integer nSubSectionIDTrn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dTrnDate")
    @Temporal(TemporalType.DATE)
    private Date dTrnDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalHDID")
    private long nJournalHDID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cJournalHDID")
    private String cJournalHDID;
    @Column(name = "nJournalDTID")
    private BigInteger nJournalDTID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCashBookDr")
    private BigDecimal nCashBookDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCashBookCr")
    private BigDecimal nCashBookCr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalDr")
    private BigDecimal nJournalDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalCr")
    private BigDecimal nJournalCr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cType")
    private String cType;
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
    @JoinColumn(name = "nAcctLevelID4", referencedColumnName = "nAcctLevelID4")
    @ManyToOne(optional = false)
    private ActChartOfAcctL4 nAcctLevelID4;
    @JoinColumn(name = "nSubSectionID", referencedColumnName = "nSubSectionID")
    @ManyToOne
    private ActSectionsSub nSubSectionID;

    public ActGL() {
    }

    public ActGL(Long nGLID) {
        this.nGLID = nGLID;
    }

    public ActGL(Long nGLID, Date dTrnDate, long nJournalHDID, String cJournalHDID, BigDecimal nCashBookDr, BigDecimal nCashBookCr, BigDecimal nJournalDr, BigDecimal nJournalCr, String cType) {
        this.nGLID = nGLID;
        this.dTrnDate = dTrnDate;
        this.nJournalHDID = nJournalHDID;
        this.cJournalHDID = cJournalHDID;
        this.nCashBookDr = nCashBookDr;
        this.nCashBookCr = nCashBookCr;
        this.nJournalDr = nJournalDr;
        this.nJournalCr = nJournalCr;
        this.cType = cType;
    }

    public Long getNGLID() {
        return nGLID;
    }

    public void setNGLID(Long nGLID) {
        this.nGLID = nGLID;
    }

    public Integer getNGLTrnID() {
        return nGLTrnID;
    }

    public void setNGLTrnID(Integer nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
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

    public long getNJournalHDID() {
        return nJournalHDID;
    }

    public void setNJournalHDID(long nJournalHDID) {
        this.nJournalHDID = nJournalHDID;
    }

    public String getCJournalHDID() {
        return cJournalHDID;
    }

    public void setCJournalHDID(String cJournalHDID) {
        this.cJournalHDID = cJournalHDID;
    }

    public BigInteger getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(BigInteger nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
    }

    public BigDecimal getNCashBookDr() {
        return nCashBookDr;
    }

    public void setNCashBookDr(BigDecimal nCashBookDr) {
        this.nCashBookDr = nCashBookDr;
    }

    public BigDecimal getNCashBookCr() {
        return nCashBookCr;
    }

    public void setNCashBookCr(BigDecimal nCashBookCr) {
        this.nCashBookCr = nCashBookCr;
    }

    public BigDecimal getNJournalDr() {
        return nJournalDr;
    }

    public void setNJournalDr(BigDecimal nJournalDr) {
        this.nJournalDr = nJournalDr;
    }

    public BigDecimal getNJournalCr() {
        return nJournalCr;
    }

    public void setNJournalCr(BigDecimal nJournalCr) {
        this.nJournalCr = nJournalCr;
    }

    public String getCType() {
        return cType;
    }

    public void setCType(String cType) {
        this.cType = cType;
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

    public ActChartOfAcctL4 getNAcctLevelID4() {
        return nAcctLevelID4;
    }

    public void setNAcctLevelID4(ActChartOfAcctL4 nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public ActSectionsSub getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(ActSectionsSub nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nGLID != null ? nGLID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActGL)) {
            return false;
        }
        ActGL other = (ActGL) object;
        if ((this.nGLID == null && other.nGLID != null) || (this.nGLID != null && !this.nGLID.equals(other.nGLID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActGL[ nGLID=" + nGLID + " ]";
    }
    
}
