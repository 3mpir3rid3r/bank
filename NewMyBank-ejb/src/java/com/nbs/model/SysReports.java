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
@Table(name = "sys_Reports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysReports.findAll", query = "SELECT s FROM SysReports s"),
    @NamedQuery(name = "SysReports.findByNReportID", query = "SELECT s FROM SysReports s WHERE s.nReportID = :nReportID"),
    @NamedQuery(name = "SysReports.findByCMainSystemCode", query = "SELECT s FROM SysReports s WHERE s.cMainSystemCode = :cMainSystemCode"),
    @NamedQuery(name = "SysReports.findByCSystemCode", query = "SELECT s FROM SysReports s WHERE s.cSystemCode = :cSystemCode"),
    @NamedQuery(name = "SysReports.findByCCriteriaCode", query = "SELECT s FROM SysReports s WHERE s.cCriteriaCode = :cCriteriaCode"),
    @NamedQuery(name = "SysReports.findByNScreenTypeID", query = "SELECT s FROM SysReports s WHERE s.nScreenTypeID = :nScreenTypeID"),
    @NamedQuery(name = "SysReports.findByCRportNameSin", query = "SELECT s FROM SysReports s WHERE s.cRportNameSin = :cRportNameSin"),
    @NamedQuery(name = "SysReports.findByCRportName", query = "SELECT s FROM SysReports s WHERE s.cRportName = :cRportName"),
    @NamedQuery(name = "SysReports.findByCRportFileName", query = "SELECT s FROM SysReports s WHERE s.cRportFileName = :cRportFileName"),
    @NamedQuery(name = "SysReports.findByCRportFileNameSumm", query = "SELECT s FROM SysReports s WHERE s.cRportFileNameSumm = :cRportFileNameSumm"),
    @NamedQuery(name = "SysReports.findByBGrp1", query = "SELECT s FROM SysReports s WHERE s.bGrp1 = :bGrp1"),
    @NamedQuery(name = "SysReports.findByBGrp2", query = "SELECT s FROM SysReports s WHERE s.bGrp2 = :bGrp2"),
    @NamedQuery(name = "SysReports.findByBGrp3", query = "SELECT s FROM SysReports s WHERE s.bGrp3 = :bGrp3"),
    @NamedQuery(name = "SysReports.findByBGrp4", query = "SELECT s FROM SysReports s WHERE s.bGrp4 = :bGrp4"),
    @NamedQuery(name = "SysReports.findByBGrp5", query = "SELECT s FROM SysReports s WHERE s.bGrp5 = :bGrp5"),
    @NamedQuery(name = "SysReports.findByCGrp2", query = "SELECT s FROM SysReports s WHERE s.cGrp2 = :cGrp2"),
    @NamedQuery(name = "SysReports.findByBRepWindow", query = "SELECT s FROM SysReports s WHERE s.bRepWindow = :bRepWindow"),
    @NamedQuery(name = "SysReports.findByCRepWinPara", query = "SELECT s FROM SysReports s WHERE s.cRepWinPara = :cRepWinPara"),
    @NamedQuery(name = "SysReports.findByBActive", query = "SELECT s FROM SysReports s WHERE s.bActive = :bActive")})
public class SysReports implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nReportID")
    private Integer nReportID;
    @Size(max = 5)
    @Column(name = "cMainSystemCode")
    private String cMainSystemCode;
    @Size(max = 10)
    @Column(name = "cSystemCode")
    private String cSystemCode;
    @Size(max = 3)
    @Column(name = "cCriteriaCode")
    private String cCriteriaCode;
    @Column(name = "nScreenTypeID")
    private Short nScreenTypeID;
    @Size(max = 200)
    @Column(name = "cRportNameSin")
    private String cRportNameSin;
    @Size(max = 200)
    @Column(name = "cRportName")
    private String cRportName;
    @Size(max = 200)
    @Column(name = "cRportFileName")
    private String cRportFileName;
    @Size(max = 200)
    @Column(name = "cRportFileNameSumm")
    private String cRportFileNameSumm;
    @Column(name = "bGrp1")
    private Boolean bGrp1;
    @Column(name = "bGrp2")
    private Boolean bGrp2;
    @Column(name = "bGrp3")
    private Boolean bGrp3;
    @Column(name = "bGrp4")
    private Boolean bGrp4;
    @Column(name = "bGrp5")
    private Boolean bGrp5;
    @Size(max = 3)
    @Column(name = "cGrp2")
    private String cGrp2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bRepWindow")
    private boolean bRepWindow;
    @Size(max = 3)
    @Column(name = "cRepWinPara")
    private String cRepWinPara;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bActive")
    private boolean bActive;

    public SysReports() {
    }

    public SysReports(Integer nReportID) {
        this.nReportID = nReportID;
    }

    public SysReports(Integer nReportID, boolean bRepWindow, boolean bActive) {
        this.nReportID = nReportID;
        this.bRepWindow = bRepWindow;
        this.bActive = bActive;
    }

    public Integer getNReportID() {
        return nReportID;
    }

    public void setNReportID(Integer nReportID) {
        this.nReportID = nReportID;
    }

    public String getCMainSystemCode() {
        return cMainSystemCode;
    }

    public void setCMainSystemCode(String cMainSystemCode) {
        this.cMainSystemCode = cMainSystemCode;
    }

    public String getCSystemCode() {
        return cSystemCode;
    }

    public void setCSystemCode(String cSystemCode) {
        this.cSystemCode = cSystemCode;
    }

    public String getCCriteriaCode() {
        return cCriteriaCode;
    }

    public void setCCriteriaCode(String cCriteriaCode) {
        this.cCriteriaCode = cCriteriaCode;
    }

    public Short getNScreenTypeID() {
        return nScreenTypeID;
    }

    public void setNScreenTypeID(Short nScreenTypeID) {
        this.nScreenTypeID = nScreenTypeID;
    }

    public String getCRportNameSin() {
        return cRportNameSin;
    }

    public void setCRportNameSin(String cRportNameSin) {
        this.cRportNameSin = cRportNameSin;
    }

    public String getCRportName() {
        return cRportName;
    }

    public void setCRportName(String cRportName) {
        this.cRportName = cRportName;
    }

    public String getCRportFileName() {
        return cRportFileName;
    }

    public void setCRportFileName(String cRportFileName) {
        this.cRportFileName = cRportFileName;
    }

    public String getCRportFileNameSumm() {
        return cRportFileNameSumm;
    }

    public void setCRportFileNameSumm(String cRportFileNameSumm) {
        this.cRportFileNameSumm = cRportFileNameSumm;
    }

    public Boolean getBGrp1() {
        return bGrp1;
    }

    public void setBGrp1(Boolean bGrp1) {
        this.bGrp1 = bGrp1;
    }

    public Boolean getBGrp2() {
        return bGrp2;
    }

    public void setBGrp2(Boolean bGrp2) {
        this.bGrp2 = bGrp2;
    }

    public Boolean getBGrp3() {
        return bGrp3;
    }

    public void setBGrp3(Boolean bGrp3) {
        this.bGrp3 = bGrp3;
    }

    public Boolean getBGrp4() {
        return bGrp4;
    }

    public void setBGrp4(Boolean bGrp4) {
        this.bGrp4 = bGrp4;
    }

    public Boolean getBGrp5() {
        return bGrp5;
    }

    public void setBGrp5(Boolean bGrp5) {
        this.bGrp5 = bGrp5;
    }

    public String getCGrp2() {
        return cGrp2;
    }

    public void setCGrp2(String cGrp2) {
        this.cGrp2 = cGrp2;
    }

    public boolean getBRepWindow() {
        return bRepWindow;
    }

    public void setBRepWindow(boolean bRepWindow) {
        this.bRepWindow = bRepWindow;
    }

    public String getCRepWinPara() {
        return cRepWinPara;
    }

    public void setCRepWinPara(String cRepWinPara) {
        this.cRepWinPara = cRepWinPara;
    }

    public boolean getBActive() {
        return bActive;
    }

    public void setBActive(boolean bActive) {
        this.bActive = bActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nReportID != null ? nReportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysReports)) {
            return false;
        }
        SysReports other = (SysReports) object;
        if ((this.nReportID == null && other.nReportID != null) || (this.nReportID != null && !this.nReportID.equals(other.nReportID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.SysReports[ nReportID=" + nReportID + " ]";
    }
    
}
