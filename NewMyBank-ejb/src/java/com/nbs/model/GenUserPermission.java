/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_User_Permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUserPermission.findAll", query = "SELECT g FROM GenUserPermission g"),
    @NamedQuery(name = "GenUserPermission.findByNPermissionID", query = "SELECT g FROM GenUserPermission g WHERE g.nPermissionID = :nPermissionID"),
    @NamedQuery(name = "GenUserPermission.findByCSave", query = "SELECT g FROM GenUserPermission g WHERE g.cSave = :cSave"),
    @NamedQuery(name = "GenUserPermission.findByCUpdate", query = "SELECT g FROM GenUserPermission g WHERE g.cUpdate = :cUpdate"),
    @NamedQuery(name = "GenUserPermission.findByCView", query = "SELECT g FROM GenUserPermission g WHERE g.cView = :cView")})
public class GenUserPermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPermissionID")
    private Integer nPermissionID;
    @Column(name = "cSave")
    private Boolean cSave;
    @Column(name = "cUpdate")
    private Boolean cUpdate;
    @Column(name = "cView")
    private Boolean cView;
    @JoinColumn(name = "nUserTypeID", referencedColumnName = "nUserTypeID")
    @ManyToOne(optional = false)
    private GenUserType nUserTypeID;
    @JoinColumn(name = "nGenUserPagesID", referencedColumnName = "nGenUserPagesID")
    @ManyToOne(optional = false)
    private GenUserPages nGenUserPagesID;

    public GenUserPermission() {
    }

    public GenUserPermission(Integer nPermissionID) {
        this.nPermissionID = nPermissionID;
    }

    public Integer getNPermissionID() {
        return nPermissionID;
    }

    public void setNPermissionID(Integer nPermissionID) {
        this.nPermissionID = nPermissionID;
    }

    public Boolean getCSave() {
        return cSave;
    }

    public void setCSave(Boolean cSave) {
        this.cSave = cSave;
    }

    public Boolean getCUpdate() {
        return cUpdate;
    }

    public void setCUpdate(Boolean cUpdate) {
        this.cUpdate = cUpdate;
    }

    public Boolean getCView() {
        return cView;
    }

    public void setCView(Boolean cView) {
        this.cView = cView;
    }

    public GenUserType getNUserTypeID() {
        return nUserTypeID;
    }

    public void setNUserTypeID(GenUserType nUserTypeID) {
        this.nUserTypeID = nUserTypeID;
    }

    public GenUserPages getNGenUserPagesID() {
        return nGenUserPagesID;
    }

    public void setNGenUserPagesID(GenUserPages nGenUserPagesID) {
        this.nGenUserPagesID = nGenUserPagesID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPermissionID != null ? nPermissionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUserPermission)) {
            return false;
        }
        GenUserPermission other = (GenUserPermission) object;
        if ((this.nPermissionID == null && other.nPermissionID != null) || (this.nPermissionID != null && !this.nPermissionID.equals(other.nPermissionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUserPermission[ nPermissionID=" + nPermissionID + " ]";
    }
    
}
