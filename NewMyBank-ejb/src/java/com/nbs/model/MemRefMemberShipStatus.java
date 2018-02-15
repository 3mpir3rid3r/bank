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
@Table(name = "mem_RefMemberShipStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemRefMemberShipStatus.findAll", query = "SELECT m FROM MemRefMemberShipStatus m"),
    @NamedQuery(name = "MemRefMemberShipStatus.findByNMemberShipSatusID", query = "SELECT m FROM MemRefMemberShipStatus m WHERE m.nMemberShipSatusID = :nMemberShipSatusID"),
    @NamedQuery(name = "MemRefMemberShipStatus.findByCMemberShipSatus", query = "SELECT m FROM MemRefMemberShipStatus m WHERE m.cMemberShipSatus = :cMemberShipSatus")})
public class MemRefMemberShipStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nMemberShipSatusID")
    private Integer nMemberShipSatusID;
    @Size(max = 45)
    @Column(name = "cMemberShipSatus")
    private String cMemberShipSatus;

    public MemRefMemberShipStatus() {
    }

    public MemRefMemberShipStatus(Integer nMemberShipSatusID) {
        this.nMemberShipSatusID = nMemberShipSatusID;
    }

    public Integer getNMemberShipSatusID() {
        return nMemberShipSatusID;
    }

    public void setNMemberShipSatusID(Integer nMemberShipSatusID) {
        this.nMemberShipSatusID = nMemberShipSatusID;
    }

    public String getCMemberShipSatus() {
        return cMemberShipSatus;
    }

    public void setCMemberShipSatus(String cMemberShipSatus) {
        this.cMemberShipSatus = cMemberShipSatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMemberShipSatusID != null ? nMemberShipSatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemRefMemberShipStatus)) {
            return false;
        }
        MemRefMemberShipStatus other = (MemRefMemberShipStatus) object;
        if ((this.nMemberShipSatusID == null && other.nMemberShipSatusID != null) || (this.nMemberShipSatusID != null && !this.nMemberShipSatusID.equals(other.nMemberShipSatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.MemRefMemberShipStatus[ nMemberShipSatusID=" + nMemberShipSatusID + " ]";
    }
    
}
