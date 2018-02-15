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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "Act_Financial_Quarter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActFinancialQuarter.findAll", query = "SELECT a FROM ActFinancialQuarter a"),
    @NamedQuery(name = "ActFinancialQuarter.findByNQuarterID", query = "SELECT a FROM ActFinancialQuarter a WHERE a.nQuarterID = :nQuarterID"),
    @NamedQuery(name = "ActFinancialQuarter.findByNFinYearID", query = "SELECT a FROM ActFinancialQuarter a WHERE a.nFinYearID = :nFinYearID"),
    @NamedQuery(name = "ActFinancialQuarter.findByNQuarterNo", query = "SELECT a FROM ActFinancialQuarter a WHERE a.nQuarterNo = :nQuarterNo"),
    @NamedQuery(name = "ActFinancialQuarter.findByDStartDate", query = "SELECT a FROM ActFinancialQuarter a WHERE a.dStartDate = :dStartDate"),
    @NamedQuery(name = "ActFinancialQuarter.findByDEndDate", query = "SELECT a FROM ActFinancialQuarter a WHERE a.dEndDate = :dEndDate"),
    @NamedQuery(name = "ActFinancialQuarter.findByBActive", query = "SELECT a FROM ActFinancialQuarter a WHERE a.bActive = :bActive")})
public class ActFinancialQuarter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nQuarterID")
    private Integer nQuarterID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nFinYearID")
    private int nFinYearID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nQuarterNo")
    private short nQuarterNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dStartDate")
    @Temporal(TemporalType.DATE)
    private Date dStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dEndDate")
    @Temporal(TemporalType.DATE)
    private Date dEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bActive")
    private boolean bActive;

    public ActFinancialQuarter() {
    }

    public ActFinancialQuarter(Integer nQuarterID) {
        this.nQuarterID = nQuarterID;
    }

    public ActFinancialQuarter(Integer nQuarterID, int nFinYearID, short nQuarterNo, Date dStartDate, Date dEndDate, boolean bActive) {
        this.nQuarterID = nQuarterID;
        this.nFinYearID = nFinYearID;
        this.nQuarterNo = nQuarterNo;
        this.dStartDate = dStartDate;
        this.dEndDate = dEndDate;
        this.bActive = bActive;
    }

    public Integer getNQuarterID() {
        return nQuarterID;
    }

    public void setNQuarterID(Integer nQuarterID) {
        this.nQuarterID = nQuarterID;
    }

    public int getNFinYearID() {
        return nFinYearID;
    }

    public void setNFinYearID(int nFinYearID) {
        this.nFinYearID = nFinYearID;
    }

    public short getNQuarterNo() {
        return nQuarterNo;
    }

    public void setNQuarterNo(short nQuarterNo) {
        this.nQuarterNo = nQuarterNo;
    }

    public Date getDStartDate() {
        return dStartDate;
    }

    public void setDStartDate(Date dStartDate) {
        this.dStartDate = dStartDate;
    }

    public Date getDEndDate() {
        return dEndDate;
    }

    public void setDEndDate(Date dEndDate) {
        this.dEndDate = dEndDate;
    }

    public boolean getBActive() {
        return bActive;
    }

    public void setBActive(boolean bActive) {
        this.bActive = bActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nQuarterID != null ? nQuarterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActFinancialQuarter)) {
            return false;
        }
        ActFinancialQuarter other = (ActFinancialQuarter) object;
        if ((this.nQuarterID == null && other.nQuarterID != null) || (this.nQuarterID != null && !this.nQuarterID.equals(other.nQuarterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActFinancialQuarter[ nQuarterID=" + nQuarterID + " ]";
    }
    
}
