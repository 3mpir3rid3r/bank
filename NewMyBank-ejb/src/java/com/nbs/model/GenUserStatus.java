/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_User_Status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUserStatus.findAll", query = "SELECT g FROM GenUserStatus g"),
    @NamedQuery(name = "GenUserStatus.findByNUserStatusID", query = "SELECT g FROM GenUserStatus g WHERE g.nUserStatusID = :nUserStatusID"),
    @NamedQuery(name = "GenUserStatus.findByCUserSattus", query = "SELECT g FROM GenUserStatus g WHERE g.cUserSattus = :cUserSattus")})
public class GenUserStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nUserStatusID")
    private Short nUserStatusID;
    @Size(max = 45)
    @Column(name = "cUserSattus")
    private String cUserSattus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nUserStatusID")
    private Collection<GenUser> genUserCollection;

    public GenUserStatus() {
    }

    public GenUserStatus(Short nUserStatusID) {
        this.nUserStatusID = nUserStatusID;
    }

    public Short getNUserStatusID() {
        return nUserStatusID;
    }

    public void setNUserStatusID(Short nUserStatusID) {
        this.nUserStatusID = nUserStatusID;
    }

    public String getCUserSattus() {
        return cUserSattus;
    }

    public void setCUserSattus(String cUserSattus) {
        this.cUserSattus = cUserSattus;
    }

    @XmlTransient
    public Collection<GenUser> getGenUserCollection() {
        return genUserCollection;
    }

    public void setGenUserCollection(Collection<GenUser> genUserCollection) {
        this.genUserCollection = genUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nUserStatusID != null ? nUserStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUserStatus)) {
            return false;
        }
        GenUserStatus other = (GenUserStatus) object;
        if ((this.nUserStatusID == null && other.nUserStatusID != null) || (this.nUserStatusID != null && !this.nUserStatusID.equals(other.nUserStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUserStatus[ nUserStatusID=" + nUserStatusID + " ]";
    }
    
}
