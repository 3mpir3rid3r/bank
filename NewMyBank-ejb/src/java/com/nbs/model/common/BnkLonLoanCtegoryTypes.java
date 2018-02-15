/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lasa
 */
@Entity
public class BnkLonLoanCtegoryTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long nLonTypeID;
    @Column
    private String cSysCode;
    @Column
    private String cLonName;
    @Column
    private String cLonNameSin;
    @Column
    private String cLonCategory;
    @Column
    private BigDecimal nCurrentInt;
    
    public Long getnLonTypeID() {
        return nLonTypeID;
    }

    public void setnLonTypeID(Long id) {
        this.nLonTypeID = id;
    }
    
    
    public String getcSysCode() {
        return cSysCode;
    }

    public void setcSysCode(String cSysCode) {
        this.cSysCode = cSysCode;
    }

    public String getcLonName() {
        return cLonName;
    }

    public void setcLonName(String cLonName) {
        this.cLonName = cLonName;
    }

    public String getcLonNameSin() {
        return cLonNameSin;
    }

    public void setcLonNameSin(String cLonNameSin) {
        this.cLonNameSin = cLonNameSin;
    }

    public String getcLonCategory() {
        return cLonCategory;
    }

    public void setcLonCategory(String cLonCategory) {
        this.cLonCategory = cLonCategory;
    }

    public BigDecimal getnCurrentInt() {
        return nCurrentInt;
    }

    public void setnCurrentInt(BigDecimal nCurrentInt) {
        this.nCurrentInt = nCurrentInt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonTypeID != null ? nLonTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanCtegoryTypes)) {
            return false;
        }
        BnkLonLoanCtegoryTypes other = (BnkLonLoanCtegoryTypes) object;
        if ((this.nLonTypeID == null && other.nLonTypeID != null) || (this.nLonTypeID != null && !this.nLonTypeID.equals(other.nLonTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.sp.BnkLonLoanCtegoryTypes[ nLonTypeID=" + nLonTypeID + " ]";
    }

    
}
