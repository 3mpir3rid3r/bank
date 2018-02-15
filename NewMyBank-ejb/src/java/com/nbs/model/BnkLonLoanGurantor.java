/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "bnk_Lon_Loan_Gurantor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanGurantor.findAll", query = "SELECT b FROM BnkLonLoanGurantor b"),
    @NamedQuery(name = "BnkLonLoanGurantor.findByNLonMFID", query = "SELECT b FROM BnkLonLoanGurantor b WHERE b.bnkLonLoanGurantorPK.nLonMFID = :nLonMFID"),
    @NamedQuery(name = "BnkLonLoanGurantor.findByNCustomerID", query = "SELECT b FROM BnkLonLoanGurantor b WHERE b.bnkLonLoanGurantorPK.nCustomerID = :nCustomerID"),
    @NamedQuery(name = "BnkLonLoanGurantor.findByNGurantorTypeID", query = "SELECT b FROM BnkLonLoanGurantor b WHERE b.nGurantorTypeID = :nGurantorTypeID"),
    @NamedQuery(name = "BnkLonLoanGurantor.findByCRemarks", query = "SELECT b FROM BnkLonLoanGurantor b WHERE b.cRemarks = :cRemarks")})
public class BnkLonLoanGurantor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BnkLonLoanGurantorPK bnkLonLoanGurantorPK;
    @Column(name = "nGurantorTypeID")
    private Integer nGurantorTypeID;
    @Size(max = 200)
    @Column(name = "cRemarks")
    private String cRemarks;

    public BnkLonLoanGurantor() {
    }

    public BnkLonLoanGurantor(BnkLonLoanGurantorPK bnkLonLoanGurantorPK) {
        this.bnkLonLoanGurantorPK = bnkLonLoanGurantorPK;
    }

    public BnkLonLoanGurantor(long nLonMFID, long nCustomerID) {
        this.bnkLonLoanGurantorPK = new BnkLonLoanGurantorPK(nLonMFID, nCustomerID);
    }

    public BnkLonLoanGurantorPK getBnkLonLoanGurantorPK() {
        return bnkLonLoanGurantorPK;
    }

    public void setBnkLonLoanGurantorPK(BnkLonLoanGurantorPK bnkLonLoanGurantorPK) {
        this.bnkLonLoanGurantorPK = bnkLonLoanGurantorPK;
    }

    public Integer getNGurantorTypeID() {
        return nGurantorTypeID;
    }

    public void setNGurantorTypeID(Integer nGurantorTypeID) {
        this.nGurantorTypeID = nGurantorTypeID;
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
        hash += (bnkLonLoanGurantorPK != null ? bnkLonLoanGurantorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanGurantor)) {
            return false;
        }
        BnkLonLoanGurantor other = (BnkLonLoanGurantor) object;
        if ((this.bnkLonLoanGurantorPK == null && other.bnkLonLoanGurantorPK != null) || (this.bnkLonLoanGurantorPK != null && !this.bnkLonLoanGurantorPK.equals(other.bnkLonLoanGurantorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanGurantor[ bnkLonLoanGurantorPK=" + bnkLonLoanGurantorPK + " ]";
    }
    
}
