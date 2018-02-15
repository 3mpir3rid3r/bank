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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "Act_Sections_Sub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActSectionsSub.findAll", query = "SELECT a FROM ActSectionsSub a")
    , @NamedQuery(name = "ActSectionsSub.findByNSubSectionID", query = "SELECT a FROM ActSectionsSub a WHERE a.nSubSectionID = :nSubSectionID")
    , @NamedQuery(name = "ActSectionsSub.findByNMainSectionID", query = "SELECT a FROM ActSectionsSub a WHERE a.nMainSectionID = :nMainSectionID")
    , @NamedQuery(name = "ActSectionsSub.findByNAppSectionID", query = "SELECT a FROM ActSectionsSub a WHERE a.nAppSectionID = :nAppSectionID")
    , @NamedQuery(name = "ActSectionsSub.findByCSubSectionNo", query = "SELECT a FROM ActSectionsSub a WHERE a.cSubSectionNo = :cSubSectionNo")
    , @NamedQuery(name = "ActSectionsSub.findByCSubSectionNameSin", query = "SELECT a FROM ActSectionsSub a WHERE a.cSubSectionNameSin = :cSubSectionNameSin")
    , @NamedQuery(name = "ActSectionsSub.findByCSubSectionNameUni", query = "SELECT a FROM ActSectionsSub a WHERE a.cSubSectionNameUni = :cSubSectionNameUni")
    , @NamedQuery(name = "ActSectionsSub.findByCSubSectionCode", query = "SELECT a FROM ActSectionsSub a WHERE a.cSubSectionCode = :cSubSectionCode")
    , @NamedQuery(name = "ActSectionsSub.findByNCurrentAcctID", query = "SELECT a FROM ActSectionsSub a WHERE a.nCurrentAcctID = :nCurrentAcctID")
    , @NamedQuery(name = "ActSectionsSub.findByCAddress1", query = "SELECT a FROM ActSectionsSub a WHERE a.cAddress1 = :cAddress1")
    , @NamedQuery(name = "ActSectionsSub.findByCAddress2", query = "SELECT a FROM ActSectionsSub a WHERE a.cAddress2 = :cAddress2")
    , @NamedQuery(name = "ActSectionsSub.findByCAddress3", query = "SELECT a FROM ActSectionsSub a WHERE a.cAddress3 = :cAddress3")
    , @NamedQuery(name = "ActSectionsSub.findByCAddress4", query = "SELECT a FROM ActSectionsSub a WHERE a.cAddress4 = :cAddress4")
    , @NamedQuery(name = "ActSectionsSub.findByCTelNo1", query = "SELECT a FROM ActSectionsSub a WHERE a.cTelNo1 = :cTelNo1")
    , @NamedQuery(name = "ActSectionsSub.findByCTelNo2", query = "SELECT a FROM ActSectionsSub a WHERE a.cTelNo2 = :cTelNo2")
    , @NamedQuery(name = "ActSectionsSub.findByCEmail", query = "SELECT a FROM ActSectionsSub a WHERE a.cEmail = :cEmail")
    , @NamedQuery(name = "ActSectionsSub.findByNCashPurchaseLimit", query = "SELECT a FROM ActSectionsSub a WHERE a.nCashPurchaseLimit = :nCashPurchaseLimit")
    , @NamedQuery(name = "ActSectionsSub.findByBF7Group", query = "SELECT a FROM ActSectionsSub a WHERE a.bF7Group = :bF7Group")
    , @NamedQuery(name = "ActSectionsSub.findByBF10Locked", query = "SELECT a FROM ActSectionsSub a WHERE a.bF10Locked = :bF10Locked")
    , @NamedQuery(name = "ActSectionsSub.findByNOutsiderMFID", query = "SELECT a FROM ActSectionsSub a WHERE a.nOutsiderMFID = :nOutsiderMFID")
    , @NamedQuery(name = "ActSectionsSub.findByBF10CurActLocked", query = "SELECT a FROM ActSectionsSub a WHERE a.bF10CurActLocked = :bF10CurActLocked")
    , @NamedQuery(name = "ActSectionsSub.findByBIncludeCommanExp", query = "SELECT a FROM ActSectionsSub a WHERE a.bIncludeCommanExp = :bIncludeCommanExp")
    , @NamedQuery(name = "ActSectionsSub.findByBPosSysActive", query = "SELECT a FROM ActSectionsSub a WHERE a.bPosSysActive = :bPosSysActive")
    , @NamedQuery(name = "ActSectionsSub.findByBStockAutoTranser", query = "SELECT a FROM ActSectionsSub a WHERE a.bStockAutoTranser = :bStockAutoTranser")})
public class ActSectionsSub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nSubSectionID")
    private Integer nSubSectionID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nMainSectionID")
    private int nMainSectionID;
    @Column(name = "nAppSectionID")
    private Integer nAppSectionID;
    @Size(max = 5)
    @Column(name = "cSubSectionNo")
    private String cSubSectionNo;
    @Size(max = 50)
    @Column(name = "cSubSectionNameSin")
    private String cSubSectionNameSin;
    @Size(max = 50)
    @Column(name = "cSubSectionNameUni")
    private String cSubSectionNameUni;
    @Size(max = 3)
    @Column(name = "cSubSectionCode")
    private String cSubSectionCode;
    @Column(name = "nCurrentAcctID")
    private Integer nCurrentAcctID;
    @Size(max = 50)
    @Column(name = "cAddress1")
    private String cAddress1;
    @Size(max = 50)
    @Column(name = "cAddress2")
    private String cAddress2;
    @Size(max = 50)
    @Column(name = "cAddress3")
    private String cAddress3;
    @Size(max = 50)
    @Column(name = "cAddress4")
    private String cAddress4;
    @Size(max = 50)
    @Column(name = "cTelNo1")
    private String cTelNo1;
    @Size(max = 50)
    @Column(name = "cTelNo2")
    private String cTelNo2;
    @Size(max = 50)
    @Column(name = "cEmail")
    private String cEmail;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nCashPurchaseLimit")
    private BigDecimal nCashPurchaseLimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bF7_Group")
    private boolean bF7Group;
    @Column(name = "bF10_Locked")
    private Boolean bF10Locked;
    @Column(name = "nOutsiderMFID")
    private Integer nOutsiderMFID;
    @Column(name = "bF10_CurActLocked")
    private Boolean bF10CurActLocked;
    @Column(name = "bIncludeCommanExp")
    private Boolean bIncludeCommanExp;
    @Column(name = "bPosSysActive")
    private Boolean bPosSysActive;
    @Column(name = "bStockAutoTranser")
    private Boolean bStockAutoTranser;

    public ActSectionsSub() {
    }

    public ActSectionsSub(Integer nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    public ActSectionsSub(Integer nSubSectionID, int nMainSectionID, boolean bF7Group) {
        this.nSubSectionID = nSubSectionID;
        this.nMainSectionID = nMainSectionID;
        this.bF7Group = bF7Group;
    }

    public Integer getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(Integer nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }

    public int getNMainSectionID() {
        return nMainSectionID;
    }

    public void setNMainSectionID(int nMainSectionID) {
        this.nMainSectionID = nMainSectionID;
    }

    public Integer getNAppSectionID() {
        return nAppSectionID;
    }

    public void setNAppSectionID(Integer nAppSectionID) {
        this.nAppSectionID = nAppSectionID;
    }

    public String getCSubSectionNo() {
        return cSubSectionNo;
    }

    public void setCSubSectionNo(String cSubSectionNo) {
        this.cSubSectionNo = cSubSectionNo;
    }

    public String getCSubSectionNameSin() {
        return cSubSectionNameSin;
    }

    public void setCSubSectionNameSin(String cSubSectionNameSin) {
        this.cSubSectionNameSin = cSubSectionNameSin;
    }

    public String getCSubSectionNameUni() {
        return cSubSectionNameUni;
    }

    public void setCSubSectionNameUni(String cSubSectionNameUni) {
        this.cSubSectionNameUni = cSubSectionNameUni;
    }

    public String getCSubSectionCode() {
        return cSubSectionCode;
    }

    public void setCSubSectionCode(String cSubSectionCode) {
        this.cSubSectionCode = cSubSectionCode;
    }

    public Integer getNCurrentAcctID() {
        return nCurrentAcctID;
    }

    public void setNCurrentAcctID(Integer nCurrentAcctID) {
        this.nCurrentAcctID = nCurrentAcctID;
    }

    public String getCAddress1() {
        return cAddress1;
    }

    public void setCAddress1(String cAddress1) {
        this.cAddress1 = cAddress1;
    }

    public String getCAddress2() {
        return cAddress2;
    }

    public void setCAddress2(String cAddress2) {
        this.cAddress2 = cAddress2;
    }

    public String getCAddress3() {
        return cAddress3;
    }

    public void setCAddress3(String cAddress3) {
        this.cAddress3 = cAddress3;
    }

    public String getCAddress4() {
        return cAddress4;
    }

    public void setCAddress4(String cAddress4) {
        this.cAddress4 = cAddress4;
    }

    public String getCTelNo1() {
        return cTelNo1;
    }

    public void setCTelNo1(String cTelNo1) {
        this.cTelNo1 = cTelNo1;
    }

    public String getCTelNo2() {
        return cTelNo2;
    }

    public void setCTelNo2(String cTelNo2) {
        this.cTelNo2 = cTelNo2;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public BigDecimal getNCashPurchaseLimit() {
        return nCashPurchaseLimit;
    }

    public void setNCashPurchaseLimit(BigDecimal nCashPurchaseLimit) {
        this.nCashPurchaseLimit = nCashPurchaseLimit;
    }

    public boolean getBF7Group() {
        return bF7Group;
    }

    public void setBF7Group(boolean bF7Group) {
        this.bF7Group = bF7Group;
    }

    public Boolean getBF10Locked() {
        return bF10Locked;
    }

    public void setBF10Locked(Boolean bF10Locked) {
        this.bF10Locked = bF10Locked;
    }

    public Integer getNOutsiderMFID() {
        return nOutsiderMFID;
    }

    public void setNOutsiderMFID(Integer nOutsiderMFID) {
        this.nOutsiderMFID = nOutsiderMFID;
    }

    public Boolean getBF10CurActLocked() {
        return bF10CurActLocked;
    }

    public void setBF10CurActLocked(Boolean bF10CurActLocked) {
        this.bF10CurActLocked = bF10CurActLocked;
    }

    public Boolean getBIncludeCommanExp() {
        return bIncludeCommanExp;
    }

    public void setBIncludeCommanExp(Boolean bIncludeCommanExp) {
        this.bIncludeCommanExp = bIncludeCommanExp;
    }

    public Boolean getBPosSysActive() {
        return bPosSysActive;
    }

    public void setBPosSysActive(Boolean bPosSysActive) {
        this.bPosSysActive = bPosSysActive;
    }

    public Boolean getBStockAutoTranser() {
        return bStockAutoTranser;
    }

    public void setBStockAutoTranser(Boolean bStockAutoTranser) {
        this.bStockAutoTranser = bStockAutoTranser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nSubSectionID != null ? nSubSectionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActSectionsSub)) {
            return false;
        }
        ActSectionsSub other = (ActSectionsSub) object;
        if ((this.nSubSectionID == null && other.nSubSectionID != null) || (this.nSubSectionID != null && !this.nSubSectionID.equals(other.nSubSectionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActSectionsSub[ nSubSectionID=" + nSubSectionID + " ]";
    }
    
}
