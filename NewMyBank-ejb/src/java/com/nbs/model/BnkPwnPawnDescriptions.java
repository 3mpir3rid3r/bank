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
@Table(name = "bnk_Pwn_PawnDescriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnPawnDescriptions.findAll", query = "SELECT b FROM BnkPwnPawnDescriptions b"),
    @NamedQuery(name = "BnkPwnPawnDescriptions.findByNPwnDescriptionID", query = "SELECT b FROM BnkPwnPawnDescriptions b WHERE b.nPwnDescriptionID = :nPwnDescriptionID"),
    @NamedQuery(name = "BnkPwnPawnDescriptions.findByCPwnDescription", query = "SELECT b FROM BnkPwnPawnDescriptions b WHERE b.cPwnDescription = :cPwnDescription"),
    @NamedQuery(name = "BnkPwnPawnDescriptions.findByBActive", query = "SELECT b FROM BnkPwnPawnDescriptions b WHERE b.bActive = :bActive")})
public class BnkPwnPawnDescriptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnDescriptionID")
    private Integer nPwnDescriptionID;
    @Size(max = 50)
    @Column(name = "cPwnDescription")
    private String cPwnDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bActive")
    private boolean bActive;

    public BnkPwnPawnDescriptions() {
    }

    public BnkPwnPawnDescriptions(Integer nPwnDescriptionID) {
        this.nPwnDescriptionID = nPwnDescriptionID;
    }

    public BnkPwnPawnDescriptions(Integer nPwnDescriptionID, boolean bActive) {
        this.nPwnDescriptionID = nPwnDescriptionID;
        this.bActive = bActive;
    }

    public Integer getNPwnDescriptionID() {
        return nPwnDescriptionID;
    }

    public void setNPwnDescriptionID(Integer nPwnDescriptionID) {
        this.nPwnDescriptionID = nPwnDescriptionID;
    }

    public String getCPwnDescription() {
        return cPwnDescription;
    }

    public void setCPwnDescription(String cPwnDescription) {
        this.cPwnDescription = cPwnDescription;
    }

    public boolean getBActive() {
        return bActive;
    }

    public void setBActive(boolean bActive) {
        this.bActive = bActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnDescriptionID != null ? nPwnDescriptionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnPawnDescriptions)) {
            return false;
        }
        BnkPwnPawnDescriptions other = (BnkPwnPawnDescriptions) object;
        if ((this.nPwnDescriptionID == null && other.nPwnDescriptionID != null) || (this.nPwnDescriptionID != null && !this.nPwnDescriptionID.equals(other.nPwnDescriptionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkPwnPawnDescriptions[ nPwnDescriptionID=" + nPwnDescriptionID + " ]";
    }
    
}
