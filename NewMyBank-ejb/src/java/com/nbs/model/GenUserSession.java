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
@Table(name = "gen_User_Session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUserSession.findAll", query = "SELECT g FROM GenUserSession g"),
    @NamedQuery(name = "GenUserSession.findByGenUserSessionID", query = "SELECT g FROM GenUserSession g WHERE g.genUserSessionID = :genUserSessionID"),
    @NamedQuery(name = "GenUserSession.findByNSessionID", query = "SELECT g FROM GenUserSession g WHERE g.nSessionID = :nSessionID"),
    @NamedQuery(name = "GenUserSession.findByDLogedTime", query = "SELECT g FROM GenUserSession g WHERE g.dLogedTime = :dLogedTime"),
    @NamedQuery(name = "GenUserSession.findByDLogOutTime", query = "SELECT g FROM GenUserSession g WHERE g.dLogOutTime = :dLogOutTime")})
public class GenUserSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GenUserSessionID")
    private Integer genUserSessionID;
    @Size(max = 100)
    @Column(name = "nSessionID")
    private String nSessionID;
    @Column(name = "dLogedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dLogedTime;
    @Column(name = "dLogOutTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dLogOutTime;
    @JoinColumn(name = "nUserID", referencedColumnName = "nUserID")
    @ManyToOne(optional = false)
    private GenUser nUserID;

    public GenUserSession() {
    }

    public GenUserSession(Integer genUserSessionID) {
        this.genUserSessionID = genUserSessionID;
    }

    public Integer getGenUserSessionID() {
        return genUserSessionID;
    }

    public void setGenUserSessionID(Integer genUserSessionID) {
        this.genUserSessionID = genUserSessionID;
    }

    public String getNSessionID() {
        return nSessionID;
    }

    public void setNSessionID(String nSessionID) {
        this.nSessionID = nSessionID;
    }

    public Date getDLogedTime() {
        return dLogedTime;
    }

    public void setDLogedTime(Date dLogedTime) {
        this.dLogedTime = dLogedTime;
    }

    public Date getDLogOutTime() {
        return dLogOutTime;
    }

    public void setDLogOutTime(Date dLogOutTime) {
        this.dLogOutTime = dLogOutTime;
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
        hash += (genUserSessionID != null ? genUserSessionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUserSession)) {
            return false;
        }
        GenUserSession other = (GenUserSession) object;
        if ((this.genUserSessionID == null && other.genUserSessionID != null) || (this.genUserSessionID != null && !this.genUserSessionID.equals(other.genUserSessionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUserSession[ genUserSessionID=" + genUserSessionID + " ]";
    }
    
}
