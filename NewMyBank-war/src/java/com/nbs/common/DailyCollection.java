/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.common;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author mmh
 */
public class DailyCollection {
    private Long nDepMFID;
    private String accNumber;
    private String accName;
    private BigDecimal nCr;
    private String cReceiptNo;
    private Date dTrnDate;
    private String addBy;
    private Long nTempId;

    public Long getnDepMFID() {
        return nDepMFID;
    }

    public void setnDepMFID(Long nDepMFID) {
        this.nDepMFID = nDepMFID;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public BigDecimal getnCr() {
        return nCr;
    }

    public void setnCr(BigDecimal nCr) {
        this.nCr = nCr;
    }

    public String getcReceiptNo() {
        return cReceiptNo;
    }

    public void setcReceiptNo(String cReceiptNo) {
        this.cReceiptNo = cReceiptNo;
    }

    public Date getdTrnDate() {
        return dTrnDate;
    }

    public void setdTrnDate(Date dTrnDate) {
        this.dTrnDate = dTrnDate;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }

    public Long getnTempId() {
        return nTempId;
    }

    public void setnTempId(Long nTempId) {
        this.nTempId = nTempId;
    }

  

}
