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
@Table(name = "bnk_Pwn_PawnMasterArticles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findAll", query = "SELECT b FROM BnkPwnPawnMasterArticles b"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByNPwnMasterArticleID", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.nPwnMasterArticleID = :nPwnMasterArticleID"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByNPwnMasterID", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.nPwnMasterID = :nPwnMasterID"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByNPwnRefArticlID", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.nPwnRefArticlID = :nPwnRefArticlID"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByCPwnArticlName", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.cPwnArticlName = :cPwnArticlName"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByCPwnArticlNameSin", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.cPwnArticlNameSin = :cPwnArticlNameSin"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByNPwnCaratValID", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.nPwnCaratValID = :nPwnCaratValID"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByCCaratType", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.cCaratType = :cCaratType"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByNQty", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.nQty = :nQty"),
    @NamedQuery(name = "BnkPwnPawnMasterArticles.findByCRemarks", query = "SELECT b FROM BnkPwnPawnMasterArticles b WHERE b.cRemarks = :cRemarks")})
public class BnkPwnPawnMasterArticles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnMasterArticleID")
    private Integer nPwnMasterArticleID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnMasterID")
    private long nPwnMasterID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnRefArticlID")
    private int nPwnRefArticlID;
    @Size(max = 100)
    @Column(name = "cPwnArticlName")
    private String cPwnArticlName;
    @Size(max = 100)
    @Column(name = "cPwnArticlName_Sin")
    private String cPwnArticlNameSin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnCaratValID")
    private int nPwnCaratValID;
    @Size(max = 10)
    @Column(name = "cCaratType")
    private String cCaratType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nQty")
    private int nQty;
    @Size(max = 100)
    @Column(name = "cRemarks")
    private String cRemarks;

    public BnkPwnPawnMasterArticles() {
    }

    public BnkPwnPawnMasterArticles(Integer nPwnMasterArticleID) {
        this.nPwnMasterArticleID = nPwnMasterArticleID;
    }

    public BnkPwnPawnMasterArticles(Integer nPwnMasterArticleID, long nPwnMasterID, int nPwnRefArticlID, int nPwnCaratValID, int nQty) {
        this.nPwnMasterArticleID = nPwnMasterArticleID;
        this.nPwnMasterID = nPwnMasterID;
        this.nPwnRefArticlID = nPwnRefArticlID;
        this.nPwnCaratValID = nPwnCaratValID;
        this.nQty = nQty;
    }

    public Integer getNPwnMasterArticleID() {
        return nPwnMasterArticleID;
    }

    public void setNPwnMasterArticleID(Integer nPwnMasterArticleID) {
        this.nPwnMasterArticleID = nPwnMasterArticleID;
    }

    public long getNPwnMasterID() {
        return nPwnMasterID;
    }

    public void setNPwnMasterID(long nPwnMasterID) {
        this.nPwnMasterID = nPwnMasterID;
    }

    public int getNPwnRefArticlID() {
        return nPwnRefArticlID;
    }

    public void setNPwnRefArticlID(int nPwnRefArticlID) {
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

    public int getNPwnCaratValID() {
        return nPwnCaratValID;
    }

    public void setNPwnCaratValID(int nPwnCaratValID) {
        this.nPwnCaratValID = nPwnCaratValID;
    }

    public String getCCaratType() {
        return cCaratType;
    }

    public void setCCaratType(String cCaratType) {
        this.cCaratType = cCaratType;
    }

    public int getNQty() {
        return nQty;
    }

    public void setNQty(int nQty) {
        this.nQty = nQty;
    }

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPwnMasterArticleID != null ? nPwnMasterArticleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnPawnMasterArticles)) {
            return false;
        }
        BnkPwnPawnMasterArticles other = (BnkPwnPawnMasterArticles) object;
        if ((this.nPwnMasterArticleID == null && other.nPwnMasterArticleID != null) || (this.nPwnMasterArticleID != null && !this.nPwnMasterArticleID.equals(other.nPwnMasterArticleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkPwnPawnMasterArticles[ nPwnMasterArticleID=" + nPwnMasterArticleID + " ]";
    }
    
}
