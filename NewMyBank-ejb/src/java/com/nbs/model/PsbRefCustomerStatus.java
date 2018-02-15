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
@Table(name = "psb_RefCustomerStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsbRefCustomerStatus.findAll", query = "SELECT p FROM PsbRefCustomerStatus p"),
    @NamedQuery(name = "PsbRefCustomerStatus.findByNPsbCustomerStatusID", query = "SELECT p FROM PsbRefCustomerStatus p WHERE p.nPsbCustomerStatusID = :nPsbCustomerStatusID"),
    @NamedQuery(name = "PsbRefCustomerStatus.findByCPsbCustomerStatus", query = "SELECT p FROM PsbRefCustomerStatus p WHERE p.cPsbCustomerStatus = :cPsbCustomerStatus")})
public class PsbRefCustomerStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPsb_CustomerStatusID")
    private Integer nPsbCustomerStatusID;
    @Size(max = 45)
    @Column(name = "cPsb_CustomerStatus")
    private String cPsbCustomerStatus;

    public PsbRefCustomerStatus() {
    }

    public PsbRefCustomerStatus(Integer nPsbCustomerStatusID) {
        this.nPsbCustomerStatusID = nPsbCustomerStatusID;
    }

    public Integer getNPsbCustomerStatusID() {
        return nPsbCustomerStatusID;
    }

    public void setNPsbCustomerStatusID(Integer nPsbCustomerStatusID) {
        this.nPsbCustomerStatusID = nPsbCustomerStatusID;
    }

    public String getCPsbCustomerStatus() {
        return cPsbCustomerStatus;
    }

    public void setCPsbCustomerStatus(String cPsbCustomerStatus) {
        this.cPsbCustomerStatus = cPsbCustomerStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPsbCustomerStatusID != null ? nPsbCustomerStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsbRefCustomerStatus)) {
            return false;
        }
        PsbRefCustomerStatus other = (PsbRefCustomerStatus) object;
        if ((this.nPsbCustomerStatusID == null && other.nPsbCustomerStatusID != null) || (this.nPsbCustomerStatusID != null && !this.nPsbCustomerStatusID.equals(other.nPsbCustomerStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.PsbRefCustomerStatus[ nPsbCustomerStatusID=" + nPsbCustomerStatusID + " ]";
    }
    
}
