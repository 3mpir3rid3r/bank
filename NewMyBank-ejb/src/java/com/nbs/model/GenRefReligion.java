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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_RefReligion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenRefReligion.findAll", query = "SELECT g FROM GenRefReligion g"),
    @NamedQuery(name = "GenRefReligion.findByNReligionID", query = "SELECT g FROM GenRefReligion g WHERE g.nReligionID = :nReligionID"),
    @NamedQuery(name = "GenRefReligion.findByCReligionName", query = "SELECT g FROM GenRefReligion g WHERE g.cReligionName = :cReligionName")})
public class GenRefReligion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nReligionID")
    private Short nReligionID;
    @Size(max = 45)
    @Column(name = "cReligionName")
    private String cReligionName;

    public GenRefReligion() {
    }

    public GenRefReligion(Short nReligionID) {
        this.nReligionID = nReligionID;
    }

    public Short getNReligionID() {
        return nReligionID;
    }

    public void setNReligionID(Short nReligionID) {
        this.nReligionID = nReligionID;
    }

    public String getCReligionName() {
        return cReligionName;
    }

    public void setCReligionName(String cReligionName) {
        this.cReligionName = cReligionName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nReligionID != null ? nReligionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenRefReligion)) {
            return false;
        }
        GenRefReligion other = (GenRefReligion) object;
        if ((this.nReligionID == null && other.nReligionID != null) || (this.nReligionID != null && !this.nReligionID.equals(other.nReligionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenRefReligion[ nReligionID=" + nReligionID + " ]";
    }
    
}
