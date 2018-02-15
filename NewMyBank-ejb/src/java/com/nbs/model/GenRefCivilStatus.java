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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_RefCivilStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenRefCivilStatus.findAll", query = "SELECT g FROM GenRefCivilStatus g"),
    @NamedQuery(name = "GenRefCivilStatus.findByNCivilStatusID", query = "SELECT g FROM GenRefCivilStatus g WHERE g.nCivilStatusID = :nCivilStatusID"),
    @NamedQuery(name = "GenRefCivilStatus.findByCCivilStatus", query = "SELECT g FROM GenRefCivilStatus g WHERE g.cCivilStatus = :cCivilStatus")})
public class GenRefCivilStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nCivilStatusID")
    private Short nCivilStatusID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cCivilStatus")
    private String cCivilStatus;

    public GenRefCivilStatus() {
    }

    public GenRefCivilStatus(Short nCivilStatusID) {
        this.nCivilStatusID = nCivilStatusID;
    }

    public GenRefCivilStatus(Short nCivilStatusID, String cCivilStatus) {
        this.nCivilStatusID = nCivilStatusID;
        this.cCivilStatus = cCivilStatus;
    }

    public Short getNCivilStatusID() {
        return nCivilStatusID;
    }

    public void setNCivilStatusID(Short nCivilStatusID) {
        this.nCivilStatusID = nCivilStatusID;
    }

    public String getCCivilStatus() {
        return cCivilStatus;
    }

    public void setCCivilStatus(String cCivilStatus) {
        this.cCivilStatus = cCivilStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nCivilStatusID != null ? nCivilStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenRefCivilStatus)) {
            return false;
        }
        GenRefCivilStatus other = (GenRefCivilStatus) object;
        if ((this.nCivilStatusID == null && other.nCivilStatusID != null) || (this.nCivilStatusID != null && !this.nCivilStatusID.equals(other.nCivilStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenRefCivilStatus[ nCivilStatusID=" + nCivilStatusID + " ]";
    }
    
}
