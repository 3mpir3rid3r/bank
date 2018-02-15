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
@Table(name = "bnk_RefMemberAreas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkRefMemberAreas.findAll", query = "SELECT b FROM BnkRefMemberAreas b"),
    @NamedQuery(name = "BnkRefMemberAreas.findByNMemAreaID", query = "SELECT b FROM BnkRefMemberAreas b WHERE b.nMemAreaID = :nMemAreaID"),
    @NamedQuery(name = "BnkRefMemberAreas.findByCMemAreaName", query = "SELECT b FROM BnkRefMemberAreas b WHERE b.cMemAreaName = :cMemAreaName"),
    @NamedQuery(name = "BnkRefMemberAreas.findByCAreaCode", query = "SELECT b FROM BnkRefMemberAreas b WHERE b.cAreaCode = :cAreaCode"),
    @NamedQuery(name = "BnkRefMemberAreas.findByDStartDate", query = "SELECT b FROM BnkRefMemberAreas b WHERE b.dStartDate = :dStartDate")})
public class BnkRefMemberAreas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nMemAreaID")
    private Short nMemAreaID;
    @Size(max = 50)
    @Column(name = "cMemAreaName")
    private String cMemAreaName;
    @Size(max = 5)
    @Column(name = "cAreaCode")
    private String cAreaCode;
    @Column(name = "dStartDate")
    @Temporal(TemporalType.DATE)
    private Date dStartDate;

    public BnkRefMemberAreas() {
    }

    public BnkRefMemberAreas(Short nMemAreaID) {
        this.nMemAreaID = nMemAreaID;
    }

    public Short getNMemAreaID() {
        return nMemAreaID;
    }

    public void setNMemAreaID(Short nMemAreaID) {
        this.nMemAreaID = nMemAreaID;
    }

    public String getCMemAreaName() {
        return cMemAreaName;
    }

    public void setCMemAreaName(String cMemAreaName) {
        this.cMemAreaName = cMemAreaName;
    }

    public String getCAreaCode() {
        return cAreaCode;
    }

    public void setCAreaCode(String cAreaCode) {
        this.cAreaCode = cAreaCode;
    }

    public Date getDStartDate() {
        return dStartDate;
    }

    public void setDStartDate(Date dStartDate) {
        this.dStartDate = dStartDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMemAreaID != null ? nMemAreaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkRefMemberAreas)) {
            return false;
        }
        BnkRefMemberAreas other = (BnkRefMemberAreas) object;
        if ((this.nMemAreaID == null && other.nMemAreaID != null) || (this.nMemAreaID != null && !this.nMemAreaID.equals(other.nMemAreaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkRefMemberAreas[ nMemAreaID=" + nMemAreaID + " ]";
    }
    
}
