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
@Table(name = "bnk_Pwn_RefArticls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnRefArticls.findAll", query = "SELECT b FROM BnkPwnRefArticls b"),
    @NamedQuery(name = "BnkPwnRefArticls.findByNPwnRefArticlID", query = "SELECT b FROM BnkPwnRefArticls b WHERE b.nPwnRefArticlID = :nPwnRefArticlID"),
    @NamedQuery(name = "BnkPwnRefArticls.findByCPwnArticlName", query = "SELECT b FROM BnkPwnRefArticls b WHERE b.cPwnArticlName = :cPwnArticlName"),
    @NamedQuery(name = "BnkPwnRefArticls.findByCPwnArticlNameSin", query = "SELECT b FROM BnkPwnRefArticls b WHERE b.cPwnArticlNameSin = :cPwnArticlNameSin")})
public class BnkPwnRefArticls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnRefArticlID")
    private Integer nPwnRefArticlID;
    @Size(max = 50)
    @Column(name = "cPwnArticlName")
    private String cPwnArticlName;
    @Size(max = 50)
    @Column(name = "cPwnArticlName_Sin")
    private String cPwnArticlNameSin;

    public BnkPwnRefArticls() {
    }

    public BnkPwnRefArticls(Integer nPwnRefArticlID) {
        this.nPwnRefArticlID = nPwnRefArticlID;
    }

    public Integer getNPwnRefArticlID() {
        return nPwnRefArticlID;
    }

    public void setNPwnRefArticlID(Integer nPwnRefArticlID) {
        this.nPwnRefArticlID = nPwnRefArticlID;
    }

    public String getCPwnArticlName() {
        return cPwnArticlName;
    }

    public void setCPwnArticlName(String cPwnArticlName) {
        this.cPwnArticlName = cPwnArticlName;
    }

    public String getCPwnArticlNameSin() {
        return cPwnArticlNameSin;
    }

    public void setCPwnArticlNameSin(String cPwnArticlNameSin) {
        this.cPwnArticlNameSin = cPwnArticlNameSin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnRefArticlID != null ? nPwnRefArticlID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnRefArticls)) {
            return false;
        }
        BnkPwnRefArticls other = (BnkPwnRefArticls) object;
        if ((this.nPwnRefArticlID == null && other.nPwnRefArticlID != null) || (this.nPwnRefArticlID != null && !this.nPwnRefArticlID.equals(other.nPwnRefArticlID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkPwnRefArticls[ nPwnRefArticlID=" + nPwnRefArticlID + " ]";
    }
    
}
