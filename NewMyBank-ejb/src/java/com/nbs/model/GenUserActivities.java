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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gen_User_Activities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUserActivities.findAll", query = "SELECT g FROM GenUserActivities g"),
    @NamedQuery(name = "GenUserActivities.findByNGenUserActivitiesID", query = "SELECT g FROM GenUserActivities g WHERE g.nGenUserActivitiesID = :nGenUserActivitiesID"),
    @NamedQuery(name = "GenUserActivities.findByDDate", query = "SELECT g FROM GenUserActivities g WHERE g.dDate = :dDate"),
    @NamedQuery(name = "GenUserActivities.findByCDescriptiom", query = "SELECT g FROM GenUserActivities g WHERE g.cDescriptiom = :cDescriptiom")})
public class GenUserActivities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nGenUserActivitiesID")
    private Integer nGenUserActivitiesID;
    @Column(name = "dDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dDate;
    @Size(max = 255)
    @Column(name = "cDescriptiom")
    private String cDescriptiom;
    @JoinColumn(name = "nUserID", referencedColumnName = "nUserID")
    @ManyToOne(optional = false)
    private GenUser nUserID;

    public GenUserActivities() {
    }

    public GenUserActivities(Integer nGenUserActivitiesID) {
        this.nGenUserActivitiesID = nGenUserActivitiesID;
    }

    public Integer getNGenUserActivitiesID() {
        return nGenUserActivitiesID;
    }

    public void setNGenUserActivitiesID(Integer nGenUserActivitiesID) {
        this.nGenUserActivitiesID = nGenUserActivitiesID;
    }

    public Date getDDate() {
        return dDate;
    }

    public void setDDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getCDescriptiom() {
        return cDescriptiom;
    }

    public void setCDescriptiom(String cDescriptiom) {
        this.cDescriptiom = cDescriptiom;
    }

    public GenUser getNUserID() {
        return nUserID;
    }

    public void setNUserID(GenUser nUserID) {
        this.nUserID = nUserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nGenUserActivitiesID != null ? nGenUserActivitiesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUserActivities)) {
            return false;
        }
        GenUserActivities other = (GenUserActivities) object;
        if ((this.nGenUserActivitiesID == null && other.nGenUserActivitiesID != null) || (this.nGenUserActivitiesID != null && !this.nGenUserActivitiesID.equals(other.nGenUserActivitiesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUserActivities[ nGenUserActivitiesID=" + nGenUserActivitiesID + " ]";
    }
    
}
