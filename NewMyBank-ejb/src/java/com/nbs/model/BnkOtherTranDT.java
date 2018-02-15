/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "bnk_Other_Tran_DT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkOtherTranDT.findAll", query = "SELECT b FROM BnkOtherTranDT b"),
    @NamedQuery(name = "BnkOtherTranDT.findByNOthTrnDTID", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nOthTrnDTID = :nOthTrnDTID"),
    @NamedQuery(name = "BnkOtherTranDT.findByNOthTrnHDID", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nOthTrnHDID = :nOthTrnHDID"),
    @NamedQuery(name = "BnkOtherTranDT.findByNAcctLevelID4", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nAcctLevelID4 = :nAcctLevelID4"),
    @NamedQuery(name = "BnkOtherTranDT.findByCDescription", query = "SELECT b FROM BnkOtherTranDT b WHERE b.cDescription = :cDescription"),
    @NamedQuery(name = "BnkOtherTranDT.findByNJournalDTID", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkOtherTranDT.findByBPrint", query = "SELECT b FROM BnkOtherTranDT b WHERE b.bPrint = :bPrint"),
    @NamedQuery(name = "BnkOtherTranDT.findByBPosted", query = "SELECT b FROM BnkOtherTranDT b WHERE b.bPosted = :bPosted"),
    @NamedQuery(name = "BnkOtherTranDT.findByNPaymentVal", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nPaymentVal = :nPaymentVal"),
    @NamedQuery(name = "BnkOtherTranDT.findByNDr", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nDr = :nDr"),
    @NamedQuery(name = "BnkOtherTranDT.findByNCr", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nCr = :nCr"),
    @NamedQuery(name = "BnkOtherTranDT.findByCAddBy", query = "SELECT b FROM BnkOtherTranDT b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkOtherTranDT.findByCAddDate", query = "SELECT b FROM BnkOtherTranDT b WHERE b.cAddDate = :cAddDate"),
    @NamedQuery(name = "BnkOtherTranDT.findByCAppRejBy", query = "SELECT b FROM BnkOtherTranDT b WHERE b.cAppRejBy = :cAppRejBy"),
    @NamedQuery(name = "BnkOtherTranDT.findByDAppRejDate", query = "SELECT b FROM BnkOtherTranDT b WHERE b.dAppRejDate = :dAppRejDate"),
    @NamedQuery(name = "BnkOtherTranDT.findByCPostedBy", query = "SELECT b FROM BnkOtherTranDT b WHERE b.cPostedBy = :cPostedBy"),
    @NamedQuery(name = "BnkOtherTranDT.findByDPostedDate", query = "SELECT b FROM BnkOtherTranDT b WHERE b.dPostedDate = :dPostedDate"),
    @NamedQuery(name = "BnkOtherTranDT.findByNGLTrnID", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "BnkOtherTranDT.findByNOutsiderMFID", query = "SELECT b FROM BnkOtherTranDT b WHERE b.nOutsiderMFID = :nOutsiderMFID")})
public class BnkOtherTranDT implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nOthTrnDTID")
    private Long nOthTrnDTID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nOthTrnHDID")
    private long nOthTrnHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID4")
    private int nAcctLevelID4;
    @Size(max = 150)
    @Column(name = "cDescription")
    private String cDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalDTID")
    private long nJournalDTID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bPrint")
    private boolean bPrint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bPosted")
    private boolean bPosted;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPaymentVal")
    private BigDecimal nPaymentVal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDr")
    private BigDecimal nDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCr")
    private BigDecimal nCr;
    @Size(max = 10)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "cAddDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cAddDate;
    @Size(max = 50)
    @Column(name = "cAppRejBy")
    private String cAppRejBy;
    @Column(name = "dAppRejDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dAppRejDate;
    @Size(max = 10)
    @Column(name = "cPostedBy")
    private String cPostedBy;
    @Column(name = "dPostedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dPostedDate;
    @Column(name = "nGLTrnID")
    private Integer nGLTrnID;
    @Column(name = "nOutsiderMFID")
    private Integer nOutsiderMFID;

    public BnkOtherTranDT() {
    }

    public BnkOtherTranDT(Long nOthTrnDTID) {
        this.nOthTrnDTID = nOthTrnDTID;
    }

    public BnkOtherTranDT(Long nOthTrnDTID, long nOthTrnHDID, int nAcctLevelID4, long nJournalDTID, boolean bPrint, boolean bPosted, BigDecimal nPaymentVal, BigDecimal nDr, BigDecimal nCr) {
        this.nOthTrnDTID = nOthTrnDTID;
        this.nOthTrnHDID = nOthTrnHDID;
        this.nAcctLevelID4 = nAcctLevelID4;
        this.nJournalDTID = nJournalDTID;
        this.bPrint = bPrint;
        this.bPosted = bPosted;
        this.nPaymentVal = nPaymentVal;
        this.nDr = nDr;
        this.nCr = nCr;
    }

    public Long getNOthTrnDTID() {
        return nOthTrnDTID;
    }

    public void setNOthTrnDTID(Long nOthTrnDTID) {
        this.nOthTrnDTID = nOthTrnDTID;
    }

    public long getNOthTrnHDID() {
        return nOthTrnHDID;
    }

    public void setNOthTrnHDID(long nOthTrnHDID) {
        this.nOthTrnHDID = nOthTrnHDID;
    }

    public int getNAcctLevelID4() {
        return nAcctLevelID4;
    }

    public void setNAcctLevelID4(int nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public long getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(long nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
    }

    public boolean getBPrint() {
        return bPrint;
    }

    public void setBPrint(boolean bPrint) {
        this.bPrint = bPrint;
    }

    public boolean getBPosted() {
        return bPosted;
    }

    public void setBPosted(boolean bPosted) {
        this.bPosted = bPosted;
    }

    public BigDecimal getNPaymentVal() {
        return nPaymentVal;
    }

    public void setNPaymentVal(BigDecimal nPaymentVal) {
        this.nPaymentVal = nPaymentVal;
    }

    public BigDecimal getNDr() {
        return nDr;
    }

    public void setNDr(BigDecimal nDr) {
        this.nDr = nDr;
    }

    public BigDecimal getNCr() {
        return nCr;
    }

    public void setNCr(BigDecimal nCr) {
        this.nCr = nCr;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public Date getCAddDate() {
        return cAddDate;
    }

    public void setCAddDate(Date cAddDate) {
        this.cAddDate = cAddDate;
    }

    public String getCAppRejBy() {
        return cAppRejBy;
    }

    public void setCAppRejBy(String cAppRejBy) {
        this.cAppRejBy = cAppRejBy;
    }

    public Date getDAppRejDate() {
        return dAppRejDate;
    }

    public void setDAppRejDate(Date dAppRejDate) {
        this.dAppRejDate = dAppRejDate;
    }

    public String getCPostedBy() {
        return cPostedBy;
    }

    public void setCPostedBy(String cPostedBy) {
        this.cPostedBy = cPostedBy;
    }

    public Date getDPostedDate() {
        return dPostedDate;
    }

    public void setDPostedDate(Date dPostedDate) {
        this.dPostedDate = dPostedDate;
    }

    public Integer getNGLTrnID() {
        return nGLTrnID;
    }

    public void setNGLTrnID(Integer nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
    }

    public Integer getNOutsiderMFID() {
        return nOutsiderMFID;
    }

    public void setNOutsiderMFID(Integer nOutsiderMFID) {
        this.nOutsiderMFID = nOutsiderMFID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nOthTrnDTID != null ? nOthTrnDTID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkOtherTranDT)) {
            return false;
        }
        BnkOtherTranDT other = (BnkOtherTranDT) object;
        if ((this.nOthTrnDTID == null && other.nOthTrnDTID != null) || (this.nOthTrnDTID != null && !this.nOthTrnDTID.equals(other.nOthTrnDTID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkOtherTranDT[ nOthTrnDTID=" + nOthTrnDTID + " ]";
    }
    
}
