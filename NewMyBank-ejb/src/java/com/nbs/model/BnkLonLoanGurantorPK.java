/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mmh
 */
@Embeddable
public class BnkLonLoanGurantorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonMFID")
    private long nLonMFID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCustomerID")
    private long nCustomerID;

    public BnkLonLoanGurantorPK() {
    }

    public BnkLonLoanGurantorPK(long nLonMFID, long nCustomerID) {
        this.nLonMFID = nLonMFID;
        this.nCustomerID = nCustomerID;
    }

    public long getNLonMFID() {
        return nLonMFID;
    }

    public void setNLonMFID(long nLonMFID) {
        this.nLonMFID = nLonMFID;
    }

    public long getNCustomerID() {
        return nCustomerID;
    }

    public void setNCustomerID(long nCustomerID) {
        this.nCustomerID = nCustomerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nLonMFID;
        hash += (int) nCustomerID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanGurantorPK)) {
            return false;
        }
        BnkLonLoanGurantorPK other = (BnkLonLoanGurantorPK) object;
        if (this.nLonMFID != other.nLonMFID) {
            return false;
        }
        if (this.nCustomerID != other.nCustomerID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanGurantorPK[ nLonMFID=" + nLonMFID + ", nCustomerID=" + nCustomerID + " ]";
    }
    
}
