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
@Table(name = "bnk_Pwn_PawnReason")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnPawnReason.findAll", query = "SELECT b FROM BnkPwnPawnReason b"),
    @NamedQuery(name = "BnkPwnPawnReason.findByNPwnReasonID", query = "SELECT b FROM BnkPwnPawnReason b WHERE b.nPwnReasonID = :nPwnReasonID"),
    @NamedQuery(name = "BnkPwnPawnReason.findByCPwnReason", query = "SELECT b FROM BnkPwnPawnReason b WHERE b.cPwnReason = :cPwnReason"),
    @NamedQuery(name = "BnkPwnPawnReason.findByCPwnReasonEng", query = "SELECT b FROM BnkPwnPawnReason b WHERE b.cPwnReasonEng = :cPwnReasonEng")})
public class BnkPwnPawnReason implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnReasonID")
    private Integer nPwnReasonID;
    @Size(max = 150)
    @Column(name = "cPwnReason")
    private String cPwnReason;
    @Size(max = 200)
    @Column(name = "cPwnReason_Eng")
    private String cPwnReasonEng;

    public BnkPwnPawnReason() {
    }

    public BnkPwnPawnReason(Integer nPwnReasonID) {
        this.nPwnReasonID = nPwnReasonID;
    }

    public Integer getNPwnReasonID() {
        return nPwnReasonID;
    }

    public void setNPwnReasonID(Integer nPwnReasonID) {
        this.nPwnReasonID = nPwnReasonID;
    }

    public String getCPwnReason() {
        return cPwnReason;
    }

    public void setCPwnReason(String cPwnReason) {
        this.cPwnReason = cPwnReason;
    }

    public String getCPwnReasonEng() {
        return cPwnReasonEng;
    }

    public void setCPwnReasonEng(String cPwnReasonEng) {
        this.cPwnReasonEng = cPwnReasonEng;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnReasonID != null ? nPwnReasonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnPawnReason)) {
            return false;
        }
        BnkPwnPawnReason other = (BnkPwnPawnReason) object;
        if ((this.nPwnReasonID == null && other.nPwnReasonID != null) || (this.nPwnReasonID != null && !this.nPwnReasonID.equals(other.nPwnReasonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkPwnPawnReason[ nPwnReasonID=" + nPwnReasonID + " ]";
    }
    
}
