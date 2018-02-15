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
@Table(name = "Act_ChartOfAcctL5")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActChartOfAcctL5.findAll", query = "SELECT a FROM ActChartOfAcctL5 a")
    , @NamedQuery(name = "ActChartOfAcctL5.findByNAcctLevelID5", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.nAcctLevelID5 = :nAcctLevelID5")
    , @NamedQuery(name = "ActChartOfAcctL5.findByNAcctLevelID4", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.nAcctLevelID4 = :nAcctLevelID4")
    , @NamedQuery(name = "ActChartOfAcctL5.findByCCAAcctNoL5", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.cCAAcctNoL5 = :cCAAcctNoL5")
    , @NamedQuery(name = "ActChartOfAcctL5.findByCDescriptionSinL5", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.cDescriptionSinL5 = :cDescriptionSinL5")
    , @NamedQuery(name = "ActChartOfAcctL5.findByCDescriptionUniL5", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.cDescriptionUniL5 = :cDescriptionUniL5")
    , @NamedQuery(name = "ActChartOfAcctL5.findByNTBLORderL5", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.nTBLORderL5 = :nTBLORderL5")
    , @NamedQuery(name = "ActChartOfAcctL5.findByNPNLOrderL5", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.nPNLOrderL5 = :nPNLOrderL5")
    , @NamedQuery(name = "ActChartOfAcctL5.findByNNoteNoL5", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.nNoteNoL5 = :nNoteNoL5")
    , @NamedQuery(name = "ActChartOfAcctL5.findByB9EAccount", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.b9EAccount = :b9EAccount")
    , @NamedQuery(name = "ActChartOfAcctL5.findByNAcctLevelID3old", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.nAcctLevelID3old = :nAcctLevelID3old")
    , @NamedQuery(name = "ActChartOfAcctL5.findByBF10Active", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.bF10Active = :bF10Active")
    , @NamedQuery(name = "ActChartOfAcctL5.findByBFixed", query = "SELECT a FROM ActChartOfAcctL5 a WHERE a.bFixed = :bFixed")})
public class ActChartOfAcctL5 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nAcctLevelID5")
    private Integer nAcctLevelID5;
    @Column(name = "nAcctLevelID4")
    private Integer nAcctLevelID4;
    @Size(max = 13)
    @Column(name = "cCAAcctNo_L5")
    private String cCAAcctNoL5;
    @Size(max = 100)
    @Column(name = "cDescriptionSin_L5")
    private String cDescriptionSinL5;
    @Size(max = 350)
    @Column(name = "cDescriptionUni_L5")
    private String cDescriptionUniL5;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nTBLORder_L5")
    private BigDecimal nTBLORderL5;
    @Column(name = "nPNLOrder_L5")
    private BigDecimal nPNLOrderL5;
    @Column(name = "nNoteNo_L5")
    private BigDecimal nNoteNoL5;
    @Column(name = "b9E_Account")
    private Short b9EAccount;
    @Column(name = "nAcctLevelID3_old")
    private Integer nAcctLevelID3old;
    @Column(name = "bF10Active")
    private Short bF10Active;
    @Column(name = "bFixed")
    private Short bFixed;

    public ActChartOfAcctL5() {
    }

    public ActChartOfAcctL5(Integer nAcctLevelID5) {
        this.nAcctLevelID5 = nAcctLevelID5;
    }

    public Integer getNAcctLevelID5() {
        return nAcctLevelID5;
    }

    public void setNAcctLevelID5(Integer nAcctLevelID5) {
        this.nAcctLevelID5 = nAcctLevelID5;
    }

    public Integer getNAcctLevelID4() {
        return nAcctLevelID4;
    }

    public void setNAcctLevelID4(Integer nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public String getCCAAcctNoL5() {
        return cCAAcctNoL5;
    }

    public void setCCAAcctNoL5(String cCAAcctNoL5) {
        this.cCAAcctNoL5 = cCAAcctNoL5;
    }

    public String getCDescriptionSinL5() {
        return cDescriptionSinL5;
    }

    public void setCDescriptionSinL5(String cDescriptionSinL5) {
        this.cDescriptionSinL5 = cDescriptionSinL5;
    }

    public String getCDescriptionUniL5() {
        return cDescriptionUniL5;
    }

    public void setCDescriptionUniL5(String cDescriptionUniL5) {
        this.cDescriptionUniL5 = cDescriptionUniL5;
    }

    public BigDecimal getNTBLORderL5() {
        return nTBLORderL5;
    }

    public void setNTBLORderL5(BigDecimal nTBLORderL5) {
        this.nTBLORderL5 = nTBLORderL5;
    }

    public BigDecimal getNPNLOrderL5() {
        return nPNLOrderL5;
    }

    public void setNPNLOrderL5(BigDecimal nPNLOrderL5) {
        this.nPNLOrderL5 = nPNLOrderL5;
    }

    public BigDecimal getNNoteNoL5() {
        return nNoteNoL5;
    }

    public void setNNoteNoL5(BigDecimal nNoteNoL5) {
        this.nNoteNoL5 = nNoteNoL5;
    }

    public Short getB9EAccount() {
        return b9EAccount;
    }

    public void setB9EAccount(Short b9EAccount) {
        this.b9EAccount = b9EAccount;
    }

    public Integer getNAcctLevelID3old() {
        return nAcctLevelID3old;
    }

    public void setNAcctLevelID3old(Integer nAcctLevelID3old) {
        this.nAcctLevelID3old = nAcctLevelID3old;
    }

    public Short getBF10Active() {
        return bF10Active;
    }

    public void setBF10Active(Short bF10Active) {
        this.bF10Active = bF10Active;
    }

    public Short getBFixed() {
        return bFixed;
    }

    public void setBFixed(Short bFixed) {
        this.bFixed = bFixed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nAcctLevelID5 != null ? nAcctLevelID5.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActChartOfAcctL5)) {
            return false;
        }
        ActChartOfAcctL5 other = (ActChartOfAcctL5) object;
        if ((this.nAcctLevelID5 == null && other.nAcctLevelID5 != null) || (this.nAcctLevelID5 != null && !this.nAcctLevelID5.equals(other.nAcctLevelID5))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActChartOfAcctL5[ nAcctLevelID5=" + nAcctLevelID5 + " ]";
    }
    
}
