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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_UserType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUserType.findAll", query = "SELECT g FROM GenUserType g"),
    @NamedQuery(name = "GenUserType.findByNUserTypeID", query = "SELECT g FROM GenUserType g WHERE g.nUserTypeID = :nUserTypeID"),
    @NamedQuery(name = "GenUserType.findByCUserType", query = "SELECT g FROM GenUserType g WHERE g.cUserType = :cUserType")})
public class GenUserType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nUserTypeID")
    private Short nUserTypeID;
    @Size(max = 10)
    @Column(name = "cUserType")
    private String cUserType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nUserTypeID")
    private Collection<GenUserPermission> genUserPermissionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nUserTypeID")
    private Collection<GenUser> genUserCollection;

    public GenUserType() {
    }

    public GenUserType(Short nUserTypeID) {
        this.nUserTypeID = nUserTypeID;
    }

    public Short getNUserTypeID() {
        return nUserTypeID;
    }

    public void setNUserTypeID(Short nUserTypeID) {
        this.nUserTypeID = nUserTypeID;
    }

    public String getCUserType() {
        return cUserType;
    }

    public void setCUserType(String cUserType) {
        this.cUserType = cUserType;
    }

    @XmlTransient
    public Collection<GenUserPermission> getGenUserPermissionCollection() {
        return genUserPermissionCollection;
    }

    public void setGenUserPermissionCollection(Collection<GenUserPermission> genUserPermissionCollection) {
        this.genUserPermissionCollection = genUserPermissionCollection;
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
        hash += (nUserTypeID != null ? nUserTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUserType)) {
            return false;
        }
        GenUserType other = (GenUserType) object;
        if ((this.nUserTypeID == null && other.nUserTypeID != null) || (this.nUserTypeID != null && !this.nUserTypeID.equals(other.nUserTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUserType[ nUserTypeID=" + nUserTypeID + " ]";
    }
    
}
