/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "bnk_Lon_LoanTransactions_DT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findAll", query = "SELECT b FROM BnkLonLoanTransactionsDT b"),
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findByNLonTrnDTID", query = "SELECT b FROM BnkLonLoanTransactionsDT b WHERE b.nLonTrnDTID = :nLonTrnDTID"),
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findByNLonTrnID", query = "SELECT b FROM BnkLonLoanTransactionsDT b WHERE b.nLonTrnID = :nLonTrnID"),
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findByNAcctLevelID4", query = "SELECT b FROM BnkLonLoanTransactionsDT b WHERE b.nAcctLevelID4 = :nAcctLevelID4"),
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findByNDR", query = "SELECT b FROM BnkLonLoanTransactionsDT b WHERE b.nDR = :nDR"),
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findByNCR", query = "SELECT b FROM BnkLonLoanTransactionsDT b WHERE b.nCR = :nCR"),
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findByNJournalDTID", query = "SELECT b FROM BnkLonLoanTransactionsDT b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkLonLoanTransactionsDT.findByNJournalHDID", query = "SELECT b FROM BnkLonLoanTransactionsDT b WHERE b.nJournalHDID = :nJournalHDID")})
public class BnkLonLoanTransactionsDT implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonTrnDTID")
    private Long nLonTrnDTID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonTrnID")
    private long nLonTrnID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID4")
    private int nAcctLevelID4;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDR")
    private BigDecimal nDR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCR")
    private BigDecimal nCR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nJournalDTID")
    private long nJournalDTID;
    @Column(name = "nJournalHDID")
    private BigInteger nJournalHDID;

    public BnkLonLoanTransactionsDT() {
    }

    public BnkLonLoanTransactionsDT(Long nLonTrnDTID) {
        this.nLonTrnDTID = nLonTrnDTID;
    }

    public BnkLonLoanTransactionsDT(Long nLonTrnDTID, long nLonTrnID, int nAcctLevelID4, BigDecimal nDR, BigDecimal nCR, long nJournalDTID) {
        this.nLonTrnDTID = nLonTrnDTID;
        this.nLonTrnID = nLonTrnID;
        this.nAcctLevelID4 = nAcctLevelID4;
        this.nDR = nDR;
        this.nCR = nCR;
        this.nJournalDTID = nJournalDTID;
    }

    public Long getNLonTrnDTID() {
        return nLonTrnDTID;
    }

    public void setNLonTrnDTID(Long nLonTrnDTID) {
        this.nLonTrnDTID = nLonTrnDTID;
    }

    public long getNLonTrnID() {
        return nLonTrnID;
    }

    public void setNLonTrnID(long nLonTrnID) {
        this.nLonTrnID = nLonTrnID;
    }

    public int getNAcctLevelID4() {
        return nAcctLevelID4;
    }

    public void setNAcctLevelID4(int nAcctLevelID4) {
        this.nAcctLevelID4 = nAcctLevelID4;
    }

    public BigDecimal getNDR() {
        return nDR;
    }

    public void setNDR(BigDecimal nDR) {
        this.nDR = nDR;
    }

    public BigDecimal getNCR() {
        return nCR;
    }

    public void setNCR(BigDecimal nCR) {
        this.nCR = nCR;
    }

    public long getNJournalDTID() {
        return nJournalDTID;
    }

    public void setNJournalDTID(long nJournalDTID) {
        this.nJournalDTID = nJournalDTID;
    }

    public BigInteger getNJournalHDID() {
        return nJournalHDID;
    }

    public void setNJournalHDID(BigInteger nJournalHDID) {
        this.nJournalHDID = nJournalHDID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonTrnDTID != null ? nLonTrnDTID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanTransactionsDT)) {
            return false;
        }
        BnkLonLoanTransactionsDT other = (BnkLonLoanTransactionsDT) object;
        if ((this.nLonTrnDTID == null && other.nLonTrnDTID != null) || (this.nLonTrnDTID != null && !this.nLonTrnDTID.equals(other.nLonTrnDTID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanTransactionsDT[ nLonTrnDTID=" + nLonTrnDTID + " ]";
    }
    
}
