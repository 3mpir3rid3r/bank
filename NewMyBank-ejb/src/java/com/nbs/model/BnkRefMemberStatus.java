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
@Table(name = "bnk_RefMemberStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkRefMemberStatus.findAll", query = "SELECT b FROM BnkRefMemberStatus b"),
    @NamedQuery(name = "BnkRefMemberStatus.findByNMemStatusID", query = "SELECT b FROM BnkRefMemberStatus b WHERE b.nMemStatusID = :nMemStatusID"),
    @NamedQuery(name = "BnkRefMemberStatus.findByCMemStatus", query = "SELECT b FROM BnkRefMemberStatus b WHERE b.cMemStatus = :cMemStatus"),
    @NamedQuery(name = "BnkRefMemberStatus.findByCMemStatusCode", query = "SELECT b FROM BnkRefMemberStatus b WHERE b.cMemStatusCode = :cMemStatusCode")})
public class BnkRefMemberStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nMemStatusID")
    private Short nMemStatusID;
    @Size(max = 50)
    @Column(name = "cMemStatus")
    private String cMemStatus;
    @Size(max = 5)
    @Column(name = "cMemStatusCode")
    private String cMemStatusCode;

    public BnkRefMemberStatus() {
    }

    public BnkRefMemberStatus(Short nMemStatusID) {
        this.nMemStatusID = nMemStatusID;
    }

    public Short getNMemStatusID() {
        return nMemStatusID;
    }

    public void setNMemStatusID(Short nMemStatusID) {
        this.nMemStatusID = nMemStatusID;
    }

    public String getCMemStatus() {
        return cMemStatus;
    }

    public void setCMemStatus(String cMemStatus) {
        this.cMemStatus = cMemStatus;
    }

    public String getCMemStatusCode() {
        return cMemStatusCode;
    }

    public void setCMemStatusCode(String cMemStatusCode) {
        this.cMemStatusCode = cMemStatusCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMemStatusID != null ? nMemStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkRefMemberStatus)) {
            return false;
        }
        BnkRefMemberStatus other = (BnkRefMemberStatus) object;
        if ((this.nMemStatusID == null && other.nMemStatusID != null) || (this.nMemStatusID != null && !this.nMemStatusID.equals(other.nMemStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkRefMemberStatus[ nMemStatusID=" + nMemStatusID + " ]";
    }
    
}
