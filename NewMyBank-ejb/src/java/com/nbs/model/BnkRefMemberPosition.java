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
@Table(name = "bnk_RefMemberPosition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkRefMemberPosition.findAll", query = "SELECT b FROM BnkRefMemberPosition b"),
    @NamedQuery(name = "BnkRefMemberPosition.findByNMemPositionID", query = "SELECT b FROM BnkRefMemberPosition b WHERE b.nMemPositionID = :nMemPositionID"),
    @NamedQuery(name = "BnkRefMemberPosition.findByCMemPosition", query = "SELECT b FROM BnkRefMemberPosition b WHERE b.cMemPosition = :cMemPosition")})
public class BnkRefMemberPosition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nMemPositionID")
    private Short nMemPositionID;
    @Size(max = 50)
    @Column(name = "cMemPosition")
    private String cMemPosition;

    public BnkRefMemberPosition() {
    }

    public BnkRefMemberPosition(Short nMemPositionID) {
        this.nMemPositionID = nMemPositionID;
    }

    public Short getNMemPositionID() {
        return nMemPositionID;
    }

    public void setNMemPositionID(Short nMemPositionID) {
        this.nMemPositionID = nMemPositionID;
    }

    public String getCMemPosition() {
        return cMemPosition;
    }

    public void setCMemPosition(String cMemPosition) {
        this.cMemPosition = cMemPosition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMemPositionID != null ? nMemPositionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkRefMemberPosition)) {
            return false;
        }
        BnkRefMemberPosition other = (BnkRefMemberPosition) object;
        if ((this.nMemPositionID == null && other.nMemPositionID != null) || (this.nMemPositionID != null && !this.nMemPositionID.equals(other.nMemPositionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkRefMemberPosition[ nMemPositionID=" + nMemPositionID + " ]";
    }
    
}
