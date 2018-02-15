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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gen_User_Pages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUserPages.findAll", query = "SELECT g FROM GenUserPages g"),
    @NamedQuery(name = "GenUserPages.findByNGenUserPagesID", query = "SELECT g FROM GenUserPages g WHERE g.nGenUserPagesID = :nGenUserPagesID"),
    @NamedQuery(name = "GenUserPages.findByCPageName", query = "SELECT g FROM GenUserPages g WHERE g.cPageName = :cPageName")})
public class GenUserPages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nGenUserPagesID")
    private Integer nGenUserPagesID;
    @Size(max = 45)
    @Column(name = "cPageName")
    private String cPageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nGenUserPagesID")
    private Collection<GenUserPermission> genUserPermissionCollection;
    @JoinColumn(name = "nGenUserModuleTypeID", referencedColumnName = "nGenUserModuleTypeID")
    @ManyToOne(optional = false)
    private GenUserModuleType nGenUserModuleTypeID;

    public GenUserPages() {
    }

    public GenUserPages(Integer nGenUserPagesID) {
        this.nGenUserPagesID = nGenUserPagesID;
    }

    public Integer getNGenUserPagesID() {
        return nGenUserPagesID;
    }

    public void setNGenUserPagesID(Integer nGenUserPagesID) {
        this.nGenUserPagesID = nGenUserPagesID;
    }

    public String getCPageName() {
        return cPageName;
    }

    public void setCPageName(String cPageName) {
        this.cPageName = cPageName;
    }

    @XmlTransient
    public Collection<GenUserPermission> getGenUserPermissionCollection() {
        return genUserPermissionCollection;
    }

    public void setGenUserPermissionCollection(Collection<GenUserPermission> genUserPermissionCollection) {
        this.genUserPermissionCollection = genUserPermissionCollection;
    }

    public GenUserModuleType getNGenUserModuleTypeID() {
        return nGenUserModuleTypeID;
    }

    public void setNGenUserModuleTypeID(GenUserModuleType nGenUserModuleTypeID) {
        this.nGenUserModuleTypeID = nGenUserModuleTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nGenUserPagesID != null ? nGenUserPagesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUserPages)) {
            return false;
        }
        GenUserPages other = (GenUserPages) object;
        if ((this.nGenUserPagesID == null && other.nGenUserPagesID != null) || (this.nGenUserPagesID != null && !this.nGenUserPagesID.equals(other.nGenUserPagesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUserPages[ nGenUserPagesID=" + nGenUserPagesID + " ]";
    }
    
}
