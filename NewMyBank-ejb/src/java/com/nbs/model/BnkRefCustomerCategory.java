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
@Table(name = "bnk_RefCustomerCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkRefCustomerCategory.findAll", query = "SELECT b FROM BnkRefCustomerCategory b"),
    @NamedQuery(name = "BnkRefCustomerCategory.findByNCustomerCategoryID", query = "SELECT b FROM BnkRefCustomerCategory b WHERE b.nCustomerCategoryID = :nCustomerCategoryID"),
    @NamedQuery(name = "BnkRefCustomerCategory.findByCCustomerCategory", query = "SELECT b FROM BnkRefCustomerCategory b WHERE b.cCustomerCategory = :cCustomerCategory"),
    @NamedQuery(name = "BnkRefCustomerCategory.findByCCode", query = "SELECT b FROM BnkRefCustomerCategory b WHERE b.cCode = :cCode")})
public class BnkRefCustomerCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nCustomerCategoryID")
    private Short nCustomerCategoryID;
    @Size(max = 50)
    @Column(name = "cCustomerCategory")
    private String cCustomerCategory;
    @Size(max = 2)
    @Column(name = "cCode")
    private String cCode;

    public BnkRefCustomerCategory() {
    }

    public BnkRefCustomerCategory(Short nCustomerCategoryID) {
        this.nCustomerCategoryID = nCustomerCategoryID;
    }

    public Short getNCustomerCategoryID() {
        return nCustomerCategoryID;
    }

    public void setNCustomerCategoryID(Short nCustomerCategoryID) {
        this.nCustomerCategoryID = nCustomerCategoryID;
    }

    public String getCCustomerCategory() {
        return cCustomerCategory;
    }

    public void setCCustomerCategory(String cCustomerCategory) {
        this.cCustomerCategory = cCustomerCategory;
    }

    public String getCCode() {
        return cCode;
    }

    public void setCCode(String cCode) {
        this.cCode = cCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nCustomerCategoryID != null ? nCustomerCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkRefCustomerCategory)) {
            return false;
        }
        BnkRefCustomerCategory other = (BnkRefCustomerCategory) object;
        if ((this.nCustomerCategoryID == null && other.nCustomerCategoryID != null) || (this.nCustomerCategoryID != null && !this.nCustomerCategoryID.equals(other.nCustomerCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkRefCustomerCategory[ nCustomerCategoryID=" + nCustomerCategoryID + " ]";
    }
    
}
