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
@Table(name = "v_bnk_Dep_FundsTransfer_FindAcctCode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VbnkDepFundsTransferFindAcctCode.findAll", query = "SELECT v FROM VbnkDepFundsTransferFindAcctCode v"),
    @NamedQuery(name = "VbnkDepFundsTransferFindAcctCode.findByNDepMFID", query = "SELECT v FROM VbnkDepFundsTransferFindAcctCode v WHERE v.nDepMFID = :nDepMFID"),
    @NamedQuery(name = "VbnkDepFundsTransferFindAcctCode.findByNBankBranchID", query = "SELECT v FROM VbnkDepFundsTransferFindAcctCode v WHERE v.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "VbnkDepFundsTransferFindAcctCode.findByCOurAccountNo", query = "SELECT v FROM VbnkDepFundsTransferFindAcctCode v WHERE v.cOurAccountNo = :cOurAccountNo"),
    @NamedQuery(name = "VbnkDepFundsTransferFindAcctCode.findByNDepAcctLevelID3", query = "SELECT v FROM VbnkDepFundsTransferFindAcctCode v WHERE v.nDepAcctLevelID3 = :nDepAcctLevelID3"),
    @NamedQuery(name = "VbnkDepFundsTransferFindAcctCode.findByNSubSectionID", query = "SELECT v FROM VbnkDepFundsTransferFindAcctCode v WHERE v.nSubSectionID = :nSubSectionID")})
public class VbnkDepFundsTransferFindAcctCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDepMFID")
    @Id
    private long nDepMFID;
    @Column(name = "nBankBranchID")
    private Integer nBankBranchID;
    @Size(max = 13)
    @Column(name = "cOurAccountNo")
    private String cOurAccountNo;
    @Column(name = "nDepAcctLevelID3")
    private Integer nDepAcctLevelID3;
    @Column(name = "nSubSectionID")
    private Integer nSubSectionID;

    public VbnkDepFundsTransferFindAcctCode() {
    }

    public long getNDepMFID() {
        return nDepMFID;
    }

    public void setNDepMFID(long nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    public Integer getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(Integer nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public String getCOurAccountNo() {
        return cOurAccountNo;
    }

    public void setCOurAccountNo(String cOurAccountNo) {
        this.cOurAccountNo = cOurAccountNo;
    }

    public Integer getNDepAcctLevelID3() {
        return nDepAcctLevelID3;
    }

    public void setNDepAcctLevelID3(Integer nDepAcctLevelID3) {
        this.nDepAcctLevelID3 = nDepAcctLevelID3;
    }

    public Integer getNSubSectionID() {
        return nSubSectionID;
    }

    public void setNSubSectionID(Integer nSubSectionID) {
        this.nSubSectionID = nSubSectionID;
    }
    
}
