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
@Table(name = "bnk_Pwn_PawnTransactions_DT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findAll", query = "SELECT b FROM BnkPwnPawnTransactionsDT b"),
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findByNPwnTrnDTID", query = "SELECT b FROM BnkPwnPawnTransactionsDT b WHERE b.nPwnTrnDTID = :nPwnTrnDTID"),
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findByNPwnTrnHDID", query = "SELECT b FROM BnkPwnPawnTransactionsDT b WHERE b.nPwnTrnHDID = :nPwnTrnHDID"),
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findByNAcctLevelID3", query = "SELECT b FROM BnkPwnPawnTransactionsDT b WHERE b.nAcctLevelID3 = :nAcctLevelID3"),
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findByNDR", query = "SELECT b FROM BnkPwnPawnTransactionsDT b WHERE b.nDR = :nDR"),
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findByNCR", query = "SELECT b FROM BnkPwnPawnTransactionsDT b WHERE b.nCR = :nCR"),
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findByNJournalDTID", query = "SELECT b FROM BnkPwnPawnTransactionsDT b WHERE b.nJournalDTID = :nJournalDTID"),
    @NamedQuery(name = "BnkPwnPawnTransactionsDT.findByNJournalHDID", query = "SELECT b FROM BnkPwnPawnTransactionsDT b WHERE b.nJournalHDID = :nJournalHDID")})
public class BnkPwnPawnTransactionsDT implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nPwnTrnDTID")
    private Long nPwnTrnDTID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPwnTrnHDID")
    private long nPwnTrnHDID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAcctLevelID3")
    private int nAcctLevelID3;
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

    public BnkPwnPawnTransactionsDT() {
    }

    public BnkPwnPawnTransactionsDT(Long nPwnTrnDTID) {
        this.nPwnTrnDTID = nPwnTrnDTID;
    }

    public BnkPwnPawnTransactionsDT(Long nPwnTrnDTID, long nPwnTrnHDID, int nAcctLevelID3, BigDecimal nDR, BigDecimal nCR, long nJournalDTID) {
        this.nPwnTrnDTID = nPwnTrnDTID;
        this.nPwnTrnHDID = nPwnTrnHDID;
        this.nAcctLevelID3 = nAcctLevelID3;
        this.nDR = nDR;
        this.nCR = nCR;
        this.nJournalDTID = nJournalDTID;
    }

    public Long getNPwnTrnDTID() {
        return nPwnTrnDTID;
    }

    public void setNPwnTrnDTID(Long nPwnTrnDTID) {
        this.nPwnTrnDTID = nPwnTrnDTID;
    }

    public long getNPwnTrnHDID() {
        return nPwnTrnHDID;
    }

    public void setNPwnTrnHDID(long nPwnTrnHDID) {
        this.nPwnTrnHDID = nPwnTrnHDID;
    }

    public int getNAcctLevelID3() {
        return nAcctLevelID3;
    }

    public void setNAcctLevelID3(int nAcctLevelID3) {
        this.nAcctLevelID3 = nAcctLevelID3;
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
        hash += (nPwnTrnDTID != null ? nPwnTrnDTID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkPwnPawnTransactionsDT)) {
            return false;
        }
        BnkPwnPawnTransactionsDT other = (BnkPwnPawnTransactionsDT) object;
        if ((this.nPwnTrnDTID == null && other.nPwnTrnDTID != null) || (this.nPwnTrnDTID != null && !this.nPwnTrnDTID.equals(other.nPwnTrnDTID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkPwnPawnTransactionsDT[ nPwnTrnDTID=" + nPwnTrnDTID + " ]";
    }
    
}
