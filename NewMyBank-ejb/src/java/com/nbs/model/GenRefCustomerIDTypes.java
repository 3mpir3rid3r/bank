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
@Table(name = "gen_RefCustomerIDTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenRefCustomerIDTypes.findAll", query = "SELECT g FROM GenRefCustomerIDTypes g"),
    @NamedQuery(name = "GenRefCustomerIDTypes.findByNIDTypeID", query = "SELECT g FROM GenRefCustomerIDTypes g WHERE g.nIDTypeID = :nIDTypeID"),
    @NamedQuery(name = "GenRefCustomerIDTypes.findByCIDType", query = "SELECT g FROM GenRefCustomerIDTypes g WHERE g.cIDType = :cIDType")})
public class GenRefCustomerIDTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nIDTypeID")
    private Short nIDTypeID;
    @Size(max = 50)
    @Column(name = "cIDType")
    private String cIDType;

    public GenRefCustomerIDTypes() {
    }

    public GenRefCustomerIDTypes(Short nIDTypeID) {
        this.nIDTypeID = nIDTypeID;
    }

    public Short getNIDTypeID() {
        return nIDTypeID;
    }

    public void setNIDTypeID(Short nIDTypeID) {
        this.nIDTypeID = nIDTypeID;
    }

    public String getCIDType() {
        return cIDType;
    }

    public void setCIDType(String cIDType) {
        this.cIDType = cIDType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIDTypeID != null ? nIDTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenRefCustomerIDTypes)) {
            return false;
        }
        GenRefCustomerIDTypes other = (GenRefCustomerIDTypes) object;
        if ((this.nIDTypeID == null && other.nIDTypeID != null) || (this.nIDTypeID != null && !this.nIDTypeID.equals(other.nIDTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenRefCustomerIDTypes[ nIDTypeID=" + nIDTypeID + " ]";
    }
    
}
