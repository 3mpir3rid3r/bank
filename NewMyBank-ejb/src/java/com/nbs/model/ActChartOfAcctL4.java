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
@Table(name = "Act_ChartOfAcctL4")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActChartOfAcctL4.findAll", query = "SELECT a FROM ActChartOfAcctL4 a"),
    @NamedQuery(name = "ActChartOfAcctL4.findByNAcctLevelID4", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.nAcctLevelID4 = :nAcctLevelID4"),
    @NamedQuery(name = "ActChartOfAcctL4.findByNAcctLevelID3", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.nAcctLevelID3 = :nAcctLevelID3"),
    @NamedQuery(name = "ActChartOfAcctL4.findByCCAAcctNoL4", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.cCAAcctNoL4 = :cCAAcctNoL4"),
    @NamedQuery(name = "ActChartOfAcctL4.findByCDescriptionSinL4", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.cDescriptionSinL4 = :cDescriptionSinL4"),
    @NamedQuery(name = "ActChartOfAcctL4.findByCDescriptionUniL4", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.cDescriptionUniL4 = :cDescriptionUniL4"),
    @NamedQuery(name = "ActChartOfAcctL4.findByNTBLORderL4", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.nTBLORderL4 = :nTBLORderL4"),
    @NamedQuery(name = "ActChartOfAcctL4.findByNPNLOrderL4", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.nPNLOrderL4 = :nPNLOrderL4"),
    @NamedQuery(name = "ActChartOfAcctL4.findByNNoteNoL4", query = "SELECT a FROM ActChartOfAcctL4 a WHERE a.nNoteNoL4 = :nNoteNoL4")})
public class ActChartOfAcctL4 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nAcctLevelID4")
    private Integer nAcctLevelID4;
    @Column(name = "nAcctLevelID3")
    private Integer nAcctLevelID3;
    @Size(max = 13)
    @Column(name = "cCAAcctNo_L4")
    private String cCAAcctNoL4;
    @Size(max = 100)
    @Column(name = "cDescriptionSin_L4")
    private String cDescriptionSinL4;
    @Size(max = 100)
    @Column(name = "cDescriptionUni_L4")
    private String cDescriptionUniL4;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nTBLORder_L4")
    private BigDecimal nTBLORderL4;
    @Column(name = "nPNLOrder_L4")
    private BigDecimal nPNLOrderL4;
    @Column(name = "nNoteNo_L4")
    private BigDecimal nNoteNoL4;

    public ActChartOfAcctL4() {
    }

    public ActChartOfAcctL4(Integer nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public Integer getNAcctLevelID4() {
        return nAcctLevelID4;
    }

    public void setNAcctLevelID4(Integer nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public Integer getNAcctLevelID3() {
        return nAcctLevelID3;
    }

    public void setNAcctLevelID3(Integer nAcctLevelID3) {
        this.nAcctLevelID3 = nAcctLevelID3;
    }

    public String getCCAAcctNoL4() {
        return cCAAcctNoL4;
    }

    public void setCCAAcctNoL4(String cCAAcctNoL4) {
        this.cCAAcctNoL4 = cCAAcctNoL4;
    }

    public String getCDescriptionSinL4() {
        return cDescriptionSinL4;
    }

    public void setCDescriptionSinL4(String cDescriptionSinL4) {
        this.cDescriptionSinL4 = cDescriptionSinL4;
    }

    public String getCDescriptionUniL4() {
        return cDescriptionUniL4;
    }

    public void setCDescriptionUniL4(String cDescriptionUniL4) {
        this.cDescriptionUniL4 = cDescriptionUniL4;
    }

    public BigDecimal getNTBLORderL4() {
        return nTBLORderL4;
    }

    public void setNTBLORderL4(BigDecimal nTBLORderL4) {
        this.nTBLORderL4 = nTBLORderL4;
    }

    public BigDecimal getNPNLOrderL4() {
        return nPNLOrderL4;
    }

    public void setNPNLOrderL4(BigDecimal nPNLOrderL4) {
        this.nPNLOrderL4 = nPNLOrderL4;
    }

    public BigDecimal getNNoteNoL4() {
        return nNoteNoL4;
    }

    public void setNNoteNoL4(BigDecimal nNoteNoL4) {
        this.nNoteNoL4 = nNoteNoL4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nAcctLevelID4 != null ? nAcctLevelID4.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActChartOfAcctL4)) {
            return false;
        }
        ActChartOfAcctL4 other = (ActChartOfAcctL4) object;
        if ((this.nAcctLevelID4 == null && other.nAcctLevelID4 != null) || (this.nAcctLevelID4 != null && !this.nAcctLevelID4.equals(other.nAcctLevelID4))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActChartOfAcctL4[ nAcctLevelID4=" + nAcctLevelID4 + " ]";
    }
    
}
