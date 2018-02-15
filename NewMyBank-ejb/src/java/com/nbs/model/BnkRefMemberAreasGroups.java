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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "bnk_RefMemberAreas_Groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkRefMemberAreasGroups.findAll", query = "SELECT b FROM BnkRefMemberAreasGroups b"),
    @NamedQuery(name = "BnkRefMemberAreasGroups.findByNMemAreaGroupID", query = "SELECT b FROM BnkRefMemberAreasGroups b WHERE b.nMemAreaGroupID = :nMemAreaGroupID"),
    @NamedQuery(name = "BnkRefMemberAreasGroups.findByNMemAreaID", query = "SELECT b FROM BnkRefMemberAreasGroups b WHERE b.nMemAreaID = :nMemAreaID"),
    @NamedQuery(name = "BnkRefMemberAreasGroups.findByCGroupName", query = "SELECT b FROM BnkRefMemberAreasGroups b WHERE b.cGroupName = :cGroupName"),
    @NamedQuery(name = "BnkRefMemberAreasGroups.findByDDrStartDate", query = "SELECT b FROM BnkRefMemberAreasGroups b WHERE b.dDrStartDate = :dDrStartDate")})
public class BnkRefMemberAreasGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nMemAreaGroupID")
    private Integer nMemAreaGroupID;
    @Column(name = "nMemAreaID")
    private Short nMemAreaID;
    @Size(max = 100)
    @Column(name = "cGroupName")
    private String cGroupName;
    @Column(name = "dDrStartDate")
    @Temporal(TemporalType.DATE)
    private Date dDrStartDate;

    public BnkRefMemberAreasGroups() {
    }

    public BnkRefMemberAreasGroups(Integer nMemAreaGroupID) {
        this.nMemAreaGroupID = nMemAreaGroupID;
    }

    public Integer getNMemAreaGroupID() {
        return nMemAreaGroupID;
    }

    public void setNMemAreaGroupID(Integer nMemAreaGroupID) {
        this.nMemAreaGroupID = nMemAreaGroupID;
    }

    public Short getNMemAreaID() {
        return nMemAreaID;
    }

    public void setNMemAreaID(Short nMemAreaID) {
        this.nMemAreaID = nMemAreaID;
    }

    public String getCGroupName() {
        return cGroupName;
    }

    public void setCGroupName(String cGroupName) {
        this.cGroupName = cGroupName;
    }

    public Date getDDrStartDate() {
        return dDrStartDate;
    }

    public void setDDrStartDate(Date dDrStartDate) {
        this.dDrStartDate = dDrStartDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMemAreaGroupID != null ? nMemAreaGroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkRefMemberAreasGroups)) {
            return false;
        }
        BnkRefMemberAreasGroups other = (BnkRefMemberAreasGroups) object;
        if ((this.nMemAreaGroupID == null && other.nMemAreaGroupID != null) || (this.nMemAreaGroupID != null && !this.nMemAreaGroupID.equals(other.nMemAreaGroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkRefMemberAreasGroups[ nMemAreaGroupID=" + nMemAreaGroupID + " ]";
    }
    
}
