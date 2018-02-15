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
@Table(name = "bnk_Lon_Loan_Groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanGroups.findAll", query = "SELECT b FROM BnkLonLoanGroups b"),
    @NamedQuery(name = "BnkLonLoanGroups.findByNLonGrpID", query = "SELECT b FROM BnkLonLoanGroups b WHERE b.nLonGrpID = :nLonGrpID"),
    @NamedQuery(name = "BnkLonLoanGroups.findByCLonGrpDescription", query = "SELECT b FROM BnkLonLoanGroups b WHERE b.cLonGrpDescription = :cLonGrpDescription")})
public class BnkLonLoanGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonGrpID")
    private Integer nLonGrpID;
    @Size(max = 150)
    @Column(name = "cLonGrpDescription")
    private String cLonGrpDescription;

    public BnkLonLoanGroups() {
    }

    public BnkLonLoanGroups(Integer nLonGrpID) {
        this.nLonGrpID = nLonGrpID;
    }

    public Integer getNLonGrpID() {
        return nLonGrpID;
    }

    public void setNLonGrpID(Integer nLonGrpID) {
        this.nLonGrpID = nLonGrpID;
    }

    public String getCLonGrpDescription() {
        return cLonGrpDescription;
    }

    public void setCLonGrpDescription(String cLonGrpDescription) {
        this.cLonGrpDescription = cLonGrpDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonGrpID != null ? nLonGrpID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanGroups)) {
            return false;
        }
        BnkLonLoanGroups other = (BnkLonLoanGroups) object;
        if ((this.nLonGrpID == null && other.nLonGrpID != null) || (this.nLonGrpID != null && !this.nLonGrpID.equals(other.nLonGrpID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanGroups[ nLonGrpID=" + nLonGrpID + " ]";
    }
    
}
