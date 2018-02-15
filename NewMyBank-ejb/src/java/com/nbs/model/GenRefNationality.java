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
@Table(name = "gen_RefNationality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenRefNationality.findAll", query = "SELECT g FROM GenRefNationality g"),
    @NamedQuery(name = "GenRefNationality.findByNNationalityID", query = "SELECT g FROM GenRefNationality g WHERE g.nNationalityID = :nNationalityID"),
    @NamedQuery(name = "GenRefNationality.findByCNationality", query = "SELECT g FROM GenRefNationality g WHERE g.cNationality = :cNationality")})
public class GenRefNationality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nNationalityID")
    private Short nNationalityID;
    @Size(max = 50)
    @Column(name = "cNationality")
    private String cNationality;

    public GenRefNationality() {
    }

    public GenRefNationality(Short nNationalityID) {
        this.nNationalityID = nNationalityID;
    }

    public Short getNNationalityID() {
        return nNationalityID;
    }

    public void setNNationalityID(Short nNationalityID) {
        this.nNationalityID = nNationalityID;
    }

    public String getCNationality() {
        return cNationality;
    }

    public void setCNationality(String cNationality) {
        this.cNationality = cNationality;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nNationalityID != null ? nNationalityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenRefNationality)) {
            return false;
        }
        GenRefNationality other = (GenRefNationality) object;
        if ((this.nNationalityID == null && other.nNationalityID != null) || (this.nNationalityID != null && !this.nNationalityID.equals(other.nNationalityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenRefNationality[ nNationalityID=" + nNationalityID + " ]";
    }
    
}
