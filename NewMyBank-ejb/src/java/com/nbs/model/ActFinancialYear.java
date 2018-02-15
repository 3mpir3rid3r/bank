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
@Table(name = "Act_Financial_Year")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActFinancialYear.findAll", query = "SELECT a FROM ActFinancialYear a"),
    @NamedQuery(name = "ActFinancialYear.findByNFinYearID", query = "SELECT a FROM ActFinancialYear a WHERE a.nFinYearID = :nFinYearID"),
    @NamedQuery(name = "ActFinancialYear.findByCYearName", query = "SELECT a FROM ActFinancialYear a WHERE a.cYearName = :cYearName"),
    @NamedQuery(name = "ActFinancialYear.findByDStartDate", query = "SELECT a FROM ActFinancialYear a WHERE a.dStartDate = :dStartDate"),
    @NamedQuery(name = "ActFinancialYear.findByDEndDate", query = "SELECT a FROM ActFinancialYear a WHERE a.dEndDate = :dEndDate"),
    @NamedQuery(name = "ActFinancialYear.findByBActive", query = "SELECT a FROM ActFinancialYear a WHERE a.bActive = :bActive"),
    @NamedQuery(name = "ActFinancialYear.findByCJournalAbb", query = "SELECT a FROM ActFinancialYear a WHERE a.cJournalAbb = :cJournalAbb"),
    @NamedQuery(name = "ActFinancialYear.findByCAddBy", query = "SELECT a FROM ActFinancialYear a WHERE a.cAddBy = :cAddBy"),
    @NamedQuery(name = "ActFinancialYear.findByDAddDate", query = "SELECT a FROM ActFinancialYear a WHERE a.dAddDate = :dAddDate")})
public class ActFinancialYear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nFinYearID")
    private Integer nFinYearID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cYearName")
    private String cYearName;
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
    @Size(max = 2)
    @Column(name = "cJournalAbb")
    private String cJournalAbb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dAddDate;

    public ActFinancialYear() {
    }

    public ActFinancialYear(Integer nFinYearID) {
        this.nFinYearID = nFinYearID;
    }

    public ActFinancialYear(Integer nFinYearID, String cYearName, Date dStartDate, Date dEndDate, boolean bActive, String cAddBy, Date dAddDate) {
        this.nFinYearID = nFinYearID;
        this.cYearName = cYearName;
        this.dStartDate = dStartDate;
        this.dEndDate = dEndDate;
        this.bActive = bActive;
        this.cAddBy = cAddBy;
        this.dAddDate = dAddDate;
    }

    public Integer getNFinYearID() {
        return nFinYearID;
    }

    public void setNFinYearID(Integer nFinYearID) {
        this.nFinYearID = nFinYearID;
    }

    public String getCYearName() {
        return cYearName;
    }

    public void setCYearName(String cYearName) {
        this.cYearName = cYearName;
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

    public String getCJournalAbb() {
        return cJournalAbb;
    }

    public void setCJournalAbb(String cJournalAbb) {
        this.cJournalAbb = cJournalAbb;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nFinYearID != null ? nFinYearID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActFinancialYear)) {
            return false;
        }
        ActFinancialYear other = (ActFinancialYear) object;
        if ((this.nFinYearID == null && other.nFinYearID != null) || (this.nFinYearID != null && !this.nFinYearID.equals(other.nFinYearID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActFinancialYear[ nFinYearID=" + nFinYearID + " ]";
    }
    
}
