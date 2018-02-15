/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "Act_Journal_DT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActJournalDT.findAll", query = "SELECT a FROM ActJournalDT a"),
    @NamedQuery(name = "ActJournalDT.findByNJournalDTID", query = "SELECT a FROM ActJournalDT a WHERE a.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "ActJournalDT.findByNJournalHDID", query = "SELECT a FROM ActJournalDT a WHERE a.nJournalHDID = :nJournalHDID"),
    @NamedQuery(name = "ActJournalDT.findByCJournalHDID", query = "SELECT a FROM ActJournalDT a WHERE a.cJournalHDID = :cJournalHDID"),
    @NamedQuery(name = "ActJournalDT.findByNAcctLevelID4", query = "SELECT a FROM ActJournalDT a WHERE a.nAcctLevelID4 = :nAcctLevelID4"),
    @NamedQuery(name = "ActJournalDT.findByNDrAmount", query = "SELECT a FROM ActJournalDT a WHERE a.nDrAmount = :nDrAmount"),
    @NamedQuery(name = "ActJournalDT.findByNCrAmount", query = "SELECT a FROM ActJournalDT a WHERE a.nCrAmount = :nCrAmount"),
    @NamedQuery(name = "ActJournalDT.findByNGLTrnID", query = "SELECT a FROM ActJournalDT a WHERE a.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "ActJournalDT.findByNOutsiderMFID", query = "SELECT a FROM ActJournalDT a WHERE a.nOutsiderMFID = :nOutsiderMFID"),
    @NamedQuery(name = "ActJournalDT.findByNSubSectionID", query = "SELECT a FROM ActJournalDT a WHERE a.nSubSectionID = :nSubSectionID"),
    @NamedQuery(name = "ActJournalDT.findByNSubSectionIDTrn", query = "SELECT a FROM ActJournalDT a WHERE a.nSubSectionIDTrn = :nSubSectionIDTrn")})
public class ActJournalDT implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nJournalDTID")
    private Long nJournalDTID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalHDID")
    private long nJournalHDID;
    @Size(max = 10)
    @Column(name = "cJournalHDID")
    private String cJournalHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID4")
    private int nAcctLevelID4;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDrAmount")
    private BigDecimal nDrAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCrAmount")
    private BigDecimal nCrAmount;
    @Column(name = "nGLTrnID")
    private Integer nGLTrnID;
    @Column(name = "nOutsiderMFID")
    private Integer nOutsiderMFID;
    @Column(name = "nSubSectionID")
    private Integer nSubSectionID;
    @Column(name = "nSubSectionID_Trn")
    private Integer nSubSectionIDTrn;

    public ActJournalDT() {
    }

    public ActJournalDT(Long nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
    }

    public ActJournalDT(Long nJournalDTID, long nJournalHDID, int nAcctLevelID4, BigDecimal nDrAmount, BigDecimal nCrAmount) {
        this.nJournalDTID = nJournalDTID;
        this.nJournalHDID = nJournalHDID;
        this.nAcctLevelID4 = nAcctLevelID4;
        this.nDrAmount = nDrAmount;
        this.nCrAmount = nCrAmount;
    }

    public Long getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(Long nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
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

    public int getNAcctLevelID4() {
        return nAcctLevelID4;
    }

    public void setNAcctLevelID4(int nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public BigDecimal getNDrAmount() {
        return nDrAmount;
    }

    public void setNDrAmount(BigDecimal nDrAmount) {
        this.nDrAmount = nDrAmount;
    }

    public BigDecimal getNCrAmount() {
        return nCrAmount;
    }

    public void setNCrAmount(BigDecimal nCrAmount) {
        this.nCrAmount = nCrAmount;
    }

    public Integer getNGLTrnID() {
        return nGLTrnID;
    }

    public void setNGLTrnID(Integer nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
    }

    public Integer getNOutsiderMFID() {
        return nOutsiderMFID;
    }

    public void setNOutsiderMFID(Integer nOutsiderMFID) {
        this.nOutsiderMFID = nOutsiderMFID;
    }

    public Integer getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(Integer nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    public Integer getNSubSectionIDTrn() {
        return nSubSectionIDTrn;
    }

    public void setNSubSectionIDTrn(Integer nSubSectionIDTrn) {
        this.nSubSectionIDTrn = nSubSectionIDTrn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nJournalDTID != null ? nJournalDTID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActJournalDT)) {
            return false;
        }
        ActJournalDT other = (ActJournalDT) object;
        if ((this.nJournalDTID == null && other.nJournalDTID != null) || (this.nJournalDTID != null && !this.nJournalDTID.equals(other.nJournalDTID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActJournalDT[ nJournalDTID=" + nJournalDTID + " ]";
    }
    
}
