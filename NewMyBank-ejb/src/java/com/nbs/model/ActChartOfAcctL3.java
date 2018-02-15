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
@Table(name = "Act_ChartOfAcctL3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActChartOfAcctL3.findAll", query = "SELECT a FROM ActChartOfAcctL3 a"),
    @NamedQuery(name = "ActChartOfAcctL3.findByNAcctLevelID3", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.nAcctLevelID3 = :nAcctLevelID3"),
    @NamedQuery(name = "ActChartOfAcctL3.findByNAcctLevelID2", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.nAcctLevelID2 = :nAcctLevelID2"),
    @NamedQuery(name = "ActChartOfAcctL3.findByCCAAcctNoL3", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.cCAAcctNoL3 = :cCAAcctNoL3"),
    @NamedQuery(name = "ActChartOfAcctL3.findByCDescriptionSinL3", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.cDescriptionSinL3 = :cDescriptionSinL3"),
    @NamedQuery(name = "ActChartOfAcctL3.findByCDescriptionUniL3", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.cDescriptionUniL3 = :cDescriptionUniL3"),
    @NamedQuery(name = "ActChartOfAcctL3.findByNTBLORderL3", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.nTBLORderL3 = :nTBLORderL3"),
    @NamedQuery(name = "ActChartOfAcctL3.findByNPNLOrderL3", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.nPNLOrderL3 = :nPNLOrderL3"),
    @NamedQuery(name = "ActChartOfAcctL3.findByNNoteNoL3", query = "SELECT a FROM ActChartOfAcctL3 a WHERE a.nNoteNoL3 = :nNoteNoL3")})
public class ActChartOfAcctL3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nAcctLevelID3")
    private Integer nAcctLevelID3;
    @Column(name = "nAcctLevelID2")
    private Integer nAcctLevelID2;
    @Size(max = 13)
    @Column(name = "cCAAcctNo_L3")
    private String cCAAcctNoL3;
    @Size(max = 100)
    @Column(name = "cDescriptionSin_L3")
    private String cDescriptionSinL3;
    @Size(max = 100)
    @Column(name = "cDescriptionUni_L3")
    private String cDescriptionUniL3;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nTBLORder_L3")
    private BigDecimal nTBLORderL3;
    @Column(name = "nPNLOrder_L3")
    private BigDecimal nPNLOrderL3;
    @Column(name = "nNoteNo_L3")
    private BigDecimal nNoteNoL3;

    public ActChartOfAcctL3() {
    }

    public ActChartOfAcctL3(Integer nAcctLevelID3) {
        this.nAcctLevelID3 = nAcctLevelID3;
    }

    public Integer getNAcctLevelID3() {
        return nAcctLevelID3;
    }

    public void setNAcctLevelID3(Integer nAcctLevelID3) {
        this.nAcctLevelID3 = nAcctLevelID3;
    }

    public Integer getNAcctLevelID2() {
        return nAcctLevelID2;
    }

    public void setNAcctLevelID2(Integer nAcctLevelID2) {
        this.nAcctLevelID2 = nAcctLevelID2;
    }

    public String getCCAAcctNoL3() {
        return cCAAcctNoL3;
    }

    public void setCCAAcctNoL3(String cCAAcctNoL3) {
        this.cCAAcctNoL3 = cCAAcctNoL3;
    }

    public String getCDescriptionSinL3() {
        return cDescriptionSinL3;
    }

    public void setCDescriptionSinL3(String cDescriptionSinL3) {
        this.cDescriptionSinL3 = cDescriptionSinL3;
    }

    public String getCDescriptionUniL3() {
        return cDescriptionUniL3;
    }

    public void setCDescriptionUniL3(String cDescriptionUniL3) {
        this.cDescriptionUniL3 = cDescriptionUniL3;
    }

    public BigDecimal getNTBLORderL3() {
        return nTBLORderL3;
    }

    public void setNTBLORderL3(BigDecimal nTBLORderL3) {
        this.nTBLORderL3 = nTBLORderL3;
    }

    public BigDecimal getNPNLOrderL3() {
        return nPNLOrderL3;
    }

    public void setNPNLOrderL3(BigDecimal nPNLOrderL3) {
        this.nPNLOrderL3 = nPNLOrderL3;
    }

    public BigDecimal getNNoteNoL3() {
        return nNoteNoL3;
    }

    public void setNNoteNoL3(BigDecimal nNoteNoL3) {
        this.nNoteNoL3 = nNoteNoL3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nAcctLevelID3 != null ? nAcctLevelID3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActChartOfAcctL3)) {
            return false;
        }
        ActChartOfAcctL3 other = (ActChartOfAcctL3) object;
        if ((this.nAcctLevelID3 == null && other.nAcctLevelID3 != null) || (this.nAcctLevelID3 != null && !this.nAcctLevelID3.equals(other.nAcctLevelID3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActChartOfAcctL3[ nAcctLevelID3=" + nAcctLevelID3 + " ]";
    }
    
}
