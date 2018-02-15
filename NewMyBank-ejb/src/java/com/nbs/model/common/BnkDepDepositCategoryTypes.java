/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model.common;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
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
public class BnkDepDepositCategoryTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_NCURRENTINTRATE = "PROP_NCURRENTINTRATE";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long nDepTypeID;
    @Column
    private String cSysCode;
    @Column
    private String cDepName;
    @Column
    private String cDepNameSin;
    @Column
    private String cDepCategory;
    @Column
    private BigDecimal nCurrentIntRate;
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private final transient VetoableChangeSupport vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);

    public Long getNDepTypeID() {
        return nDepTypeID;
    }

    public void setNDepTypeID(Long nDepTypeID) {
        this.nDepTypeID = nDepTypeID;
    }

    public Long getnDepTypeID() {
        return nDepTypeID;
    }

    public void setnDepTypeID(Long nDepTypeID) {
        this.nDepTypeID = nDepTypeID;
    }

    public String getcSysCode() {
        return cSysCode;
    }

    public void setcSysCode(String cSysCode) {
        this.cSysCode = cSysCode;
    }

    public String getcDepName() {
        return cDepName;
    }

    public void setcDepName(String cDepName) {
        this.cDepName = cDepName;
    }

    public String getcDepNameSin() {
        return cDepNameSin;
    }

    public void setcDepNameSin(String cDepNameSin) {
        this.cDepNameSin = cDepNameSin;
    }

    public String getcDepCategory() {
        return cDepCategory;
    }

    public void setcDepCategory(String cDepCategory) {
        this.cDepCategory = cDepCategory;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDepTypeID != null ? nDepTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkDepDepositCategoryTypes)) {
            return false;
        }
        BnkDepDepositCategoryTypes other = (BnkDepDepositCategoryTypes) object;
        return (this.nDepTypeID != null || other.nDepTypeID == null) && (this.nDepTypeID == null || this.nDepTypeID.equals(other.nDepTypeID));
    }

    @Override
    public String toString() {
        return "com.nbs.model.sp.BnkDepDepositCategoryTypes[ nDepTypeID=" + nDepTypeID + " ]";
    }

    /**
     * @return the nCurrentIntRate
     */
    public BigDecimal getnCurrentIntRate() {
        return nCurrentIntRate;
    }

    /**
     * @param nCurrentIntRate the nCurrentIntRate to set
     */
    public void setnCurrentIntRate(BigDecimal nCurrentIntRate) throws PropertyVetoException {
        java.math.BigDecimal oldnCurrentIntRate = this.nCurrentIntRate;
        vetoableChangeSupport.fireVetoableChange(PROP_NCURRENTINTRATE, oldnCurrentIntRate, nCurrentIntRate);
        this.nCurrentIntRate = nCurrentIntRate;
        propertyChangeSupport.firePropertyChange(PROP_NCURRENTINTRATE, oldnCurrentIntRate, nCurrentIntRate);
    }
    
}
