/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Act_ChartOfAcctL2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActChartOfAcctL2.findAll", query = "SELECT a FROM ActChartOfAcctL2 a"),
    @NamedQuery(name = "ActChartOfAcctL2.findByNAcctLevelID2", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.nAcctLevelID2 = :nAcctLevelID2"),
    @NamedQuery(name = "ActChartOfAcctL2.findByNAcctLevelID1", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.nAcctLevelID1 = :nAcctLevelID1"),
    @NamedQuery(name = "ActChartOfAcctL2.findByCCAAcctNoL2", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.cCAAcctNoL2 = :cCAAcctNoL2"),
    @NamedQuery(name = "ActChartOfAcctL2.findByCDescriptionSinL2", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.cDescriptionSinL2 = :cDescriptionSinL2"),
    @NamedQuery(name = "ActChartOfAcctL2.findByCDescriptionUniL2", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.cDescriptionUniL2 = :cDescriptionUniL2"),
    @NamedQuery(name = "ActChartOfAcctL2.findByNTBLORderL2", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.nTBLORderL2 = :nTBLORderL2"),
    @NamedQuery(name = "ActChartOfAcctL2.findByNPNLOrderL2", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.nPNLOrderL2 = :nPNLOrderL2"),
    @NamedQuery(name = "ActChartOfAcctL2.findByNNoteNoL2", query = "SELECT a FROM ActChartOfAcctL2 a WHERE a.nNoteNoL2 = :nNoteNoL2")})
public class ActChartOfAcctL2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nAcctLevelID2")
    private Integer nAcctLevelID2;
    @Column(name = "nAcctLevelID1")
    private Integer nAcctLevelID1;
    @Size(max = 13)
    @Column(name = "cCAAcctNo_L2")
    private String cCAAcctNoL2;
    @Size(max = 100)
    @Column(name = "cDescriptionSin_L2")
    private String cDescriptionSinL2;
    @Size(max = 100)
    @Column(name = "cDescriptionUni_L2")
    private String cDescriptionUniL2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nTBLORder_L2")
    private BigDecimal nTBLORderL2;
    @Column(name = "nPNLOrder_L2")
    private BigDecimal nPNLOrderL2;
    @Column(name = "nNoteNo_L2")
    private BigDecimal nNoteNoL2;

    public ActChartOfAcctL2() {
    }

    public ActChartOfAcctL2(Integer nAcctLevelID2) {
        this.nAcctLevelID2 = nAcctLevelID2;
    }

    public Integer getNAcctLevelID2() {
        return nAcctLevelID2;
    }

    public void setNAcctLevelID2(Integer nAcctLevelID2) {
        this.nAcctLevelID2 = nAcctLevelID2;
    }

    public Integer getNAcctLevelID1() {
        return nAcctLevelID1;
    }

    public void setNAcctLevelID1(Integer nAcctLevelID1) {
        this.nAcctLevelID1 = nAcctLevelID1;
    }

    public String getCCAAcctNoL2() {
        return cCAAcctNoL2;
    }

    public void setCCAAcctNoL2(String cCAAcctNoL2) {
        this.cCAAcctNoL2 = cCAAcctNoL2;
    }

    public String getCDescriptionSinL2() {
        return cDescriptionSinL2;
    }

    public void setCDescriptionSinL2(String cDescriptionSinL2) {
        this.cDescriptionSinL2 = cDescriptionSinL2;
    }

    public String getCDescriptionUniL2() {
        return cDescriptionUniL2;
    }

    public void setCDescriptionUniL2(String cDescriptionUniL2) {
        this.cDescriptionUniL2 = cDescriptionUniL2;
    }

    public BigDecimal getNTBLORderL2() {
        return nTBLORderL2;
    }

    public void setNTBLORderL2(BigDecimal nTBLORderL2) {
        this.nTBLORderL2 = nTBLORderL2;
    }

    public BigDecimal getNPNLOrderL2() {
        return nPNLOrderL2;
    }

    public void setNPNLOrderL2(BigDecimal nPNLOrderL2) {
        this.nPNLOrderL2 = nPNLOrderL2;
    }

    public BigDecimal getNNoteNoL2() {
        return nNoteNoL2;
    }

    public void setNNoteNoL2(BigDecimal nNoteNoL2) {
        this.nNoteNoL2 = nNoteNoL2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nAcctLevelID2 != null ? nAcctLevelID2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActChartOfAcctL2)) {
            return false;
        }
        ActChartOfAcctL2 other = (ActChartOfAcctL2) object;
        if ((this.nAcctLevelID2 == null && other.nAcctLevelID2 != null) || (this.nAcctLevelID2 != null && !this.nAcctLevelID2.equals(other.nAcctLevelID2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActChartOfAcctL2[ nAcctLevelID2=" + nAcctLevelID2 + " ]";
    }
    
}
