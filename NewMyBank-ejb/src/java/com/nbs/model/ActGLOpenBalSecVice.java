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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "Act_GL_OpenBal_SecVice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActGLOpenBalSecVice.findAll", query = "SELECT a FROM ActGLOpenBalSecVice a"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNOpenBalID", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nOpenBalID = :nOpenBalID"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNFinYearID", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nFinYearID = :nFinYearID"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNAcctLevelID4", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nAcctLevelID4 = :nAcctLevelID4"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNSubSectionID", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nSubSectionID = :nSubSectionID"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNDr", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nDr = :nDr"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNCr", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nCr = :nCr"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNPeriodDr", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nPeriodDr = :nPeriodDr"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNPeriodCr", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nPeriodCr = :nPeriodCr"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNLastYearDR", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nLastYearDR = :nLastYearDR"),
    @NamedQuery(name = "ActGLOpenBalSecVice.findByNLastYearCR", query = "SELECT a FROM ActGLOpenBalSecVice a WHERE a.nLastYearCR = :nLastYearCR")})
public class ActGLOpenBalSecVice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nOpenBalID")
    private Integer nOpenBalID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nFinYearID")
    private int nFinYearID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID4")
    private int nAcctLevelID4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nSubSectionID")
    private int nSubSectionID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDr")
    private BigDecimal nDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCr")
    private BigDecimal nCr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPeriod_Dr")
    private BigDecimal nPeriodDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPeriod_Cr")
    private BigDecimal nPeriodCr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLastYear_DR")
    private BigDecimal nLastYearDR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLastYear_CR")
    private BigDecimal nLastYearCR;

    public ActGLOpenBalSecVice() {
    }

    public ActGLOpenBalSecVice(Integer nOpenBalID) {
        this.nOpenBalID = nOpenBalID;
    }

    public ActGLOpenBalSecVice(Integer nOpenBalID, int nFinYearID, int nAcctLevelID4, int nSubSectionID, BigDecimal nDr, BigDecimal nCr, BigDecimal nPeriodDr, BigDecimal nPeriodCr, BigDecimal nLastYearDR, BigDecimal nLastYearCR) {
        this.nOpenBalID = nOpenBalID;
        this.nFinYearID = nFinYearID;
        this.nAcctLevelID4 = nAcctLevelID4;
        this.nSubSectionID = nSubSectionID;
        this.nDr = nDr;
        this.nCr = nCr;
        this.nPeriodDr = nPeriodDr;
        this.nPeriodCr = nPeriodCr;
        this.nLastYearDR = nLastYearDR;
        this.nLastYearCR = nLastYearCR;
    }

    public Integer getNOpenBalID() {
        return nOpenBalID;
    }

    public void setNOpenBalID(Integer nOpenBalID) {
        this.nOpenBalID = nOpenBalID;
    }

    public int getNFinYearID() {
        return nFinYearID;
    }

    public void setNFinYearID(int nFinYearID) {
        this.nFinYearID = nFinYearID;
    }

    public int getNAcctLevelID4() {
        return nAcctLevelID4;
    }

    public void setNAcctLevelID4(int nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public int getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(int nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    public BigDecimal getNDr() {
        return nDr;
    }

    public void setNDr(BigDecimal nDr) {
        this.nDr = nDr;
    }

    public BigDecimal getNCr() {
        return nCr;
    }

    public void setNCr(BigDecimal nCr) {
        this.nCr = nCr;
    }

    public BigDecimal getNPeriodDr() {
        return nPeriodDr;
    }

    public void setNPeriodDr(BigDecimal nPeriodDr) {
        this.nPeriodDr = nPeriodDr;
    }

    public BigDecimal getNPeriodCr() {
        return nPeriodCr;
    }

    public void setNPeriodCr(BigDecimal nPeriodCr) {
        this.nPeriodCr = nPeriodCr;
    }

    public BigDecimal getNLastYearDR() {
        return nLastYearDR;
    }

    public void setNLastYearDR(BigDecimal nLastYearDR) {
        this.nLastYearDR = nLastYearDR;
    }

    public BigDecimal getNLastYearCR() {
        return nLastYearCR;
    }

    public void setNLastYearCR(BigDecimal nLastYearCR) {
        this.nLastYearCR = nLastYearCR;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nOpenBalID != null ? nOpenBalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActGLOpenBalSecVice)) {
            return false;
        }
        ActGLOpenBalSecVice other = (ActGLOpenBalSecVice) object;
        if ((this.nOpenBalID == null && other.nOpenBalID != null) || (this.nOpenBalID != null && !this.nOpenBalID.equals(other.nOpenBalID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActGLOpenBalSecVice[ nOpenBalID=" + nOpenBalID + " ]";
    }
    
}
