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
@Table(name = "Act_ChartOfAcctL1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActChartOfAcctL1.findAll", query = "SELECT a FROM ActChartOfAcctL1 a"),
    @NamedQuery(name = "ActChartOfAcctL1.findByNAcctLevelID1", query = "SELECT a FROM ActChartOfAcctL1 a WHERE a.nAcctLevelID1 = :nAcctLevelID1"),
    @NamedQuery(name = "ActChartOfAcctL1.findByCCAAcctNoL1", query = "SELECT a FROM ActChartOfAcctL1 a WHERE a.cCAAcctNoL1 = :cCAAcctNoL1"),
    @NamedQuery(name = "ActChartOfAcctL1.findByCDescriptionSinL1", query = "SELECT a FROM ActChartOfAcctL1 a WHERE a.cDescriptionSinL1 = :cDescriptionSinL1"),
    @NamedQuery(name = "ActChartOfAcctL1.findByCDescriptionUniL1", query = "SELECT a FROM ActChartOfAcctL1 a WHERE a.cDescriptionUniL1 = :cDescriptionUniL1"),
    @NamedQuery(name = "ActChartOfAcctL1.findByCCategory", query = "SELECT a FROM ActChartOfAcctL1 a WHERE a.cCategory = :cCategory"),
    @NamedQuery(name = "ActChartOfAcctL1.findByCPlusSide", query = "SELECT a FROM ActChartOfAcctL1 a WHERE a.cPlusSide = :cPlusSide")})
public class ActChartOfAcctL1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nAcctLevelID1")
    private Short nAcctLevelID1;
    @Size(max = 13)
    @Column(name = "cCAAcctNo_L1")
    private String cCAAcctNoL1;
    @Size(max = 50)
    @Column(name = "cDescriptionSin_L1")
    private String cDescriptionSinL1;
    @Size(max = 50)
    @Column(name = "cDescriptionUni_L1")
    private String cDescriptionUniL1;
    @Size(max = 3)
    @Column(name = "cCategory")
    private String cCategory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cPlusSide")
    private String cPlusSide;

    public ActChartOfAcctL1() {
    }

    public ActChartOfAcctL1(Short nAcctLevelID1) {
        this.nAcctLevelID1 = nAcctLevelID1;
    }

    public ActChartOfAcctL1(Short nAcctLevelID1, String cPlusSide) {
        this.nAcctLevelID1 = nAcctLevelID1;
        this.cPlusSide = cPlusSide;
    }

    public Short getNAcctLevelID1() {
        return nAcctLevelID1;
    }

    public void setNAcctLevelID1(Short nAcctLevelID1) {
        this.nAcctLevelID1 = nAcctLevelID1;
    }

    public String getCCAAcctNoL1() {
        return cCAAcctNoL1;
    }

    public void setCCAAcctNoL1(String cCAAcctNoL1) {
        this.cCAAcctNoL1 = cCAAcctNoL1;
    }

    public String getCDescriptionSinL1() {
        return cDescriptionSinL1;
    }

    public void setCDescriptionSinL1(String cDescriptionSinL1) {
        this.cDescriptionSinL1 = cDescriptionSinL1;
    }

    public String getCDescriptionUniL1() {
        return cDescriptionUniL1;
    }

    public void setCDescriptionUniL1(String cDescriptionUniL1) {
        this.cDescriptionUniL1 = cDescriptionUniL1;
    }

    public String getCCategory() {
        return cCategory;
    }

    public void setCCategory(String cCategory) {
        this.cCategory = cCategory;
    }

    public String getCPlusSide() {
        return cPlusSide;
    }

    public void setCPlusSide(String cPlusSide) {
        this.cPlusSide = cPlusSide;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nAcctLevelID1 != null ? nAcctLevelID1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActChartOfAcctL1)) {
            return false;
        }
        ActChartOfAcctL1 other = (ActChartOfAcctL1) object;
        if ((this.nAcctLevelID1 == null && other.nAcctLevelID1 != null) || (this.nAcctLevelID1 != null && !this.nAcctLevelID1.equals(other.nAcctLevelID1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActChartOfAcctL1[ nAcctLevelID1=" + nAcctLevelID1 + " ]";
    }
    
}
