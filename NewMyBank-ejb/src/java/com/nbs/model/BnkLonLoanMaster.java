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
@Table(name = "bnk_Lon_Loan_Master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BnkLonLoanMaster.findAll", query = "SELECT b FROM BnkLonLoanMaster b"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonMFID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonMFID = :nLonMFID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNBankBranchID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nBankBranchID = :nBankBranchID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonTypeID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonTypeID = :nLonTypeID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNCustomerID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nCustomerID = :nCustomerID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonDescriptionID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonDescriptionID = :nLonDescriptionID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonFundSourceID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonFundSourceID = :nLonFundSourceID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBJoint", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bJoint = :bJoint"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonStatusID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonStatusID = :nLonStatusID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCLonAccountNo", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cLonAccountNo = :cLonAccountNo"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCOldLonAccountNo", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cOldLonAccountNo = :cOldLonAccountNo"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLedgerBookNo", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLedgerBookNo = :nLedgerBookNo"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCSerialNo", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cSerialNo = :cSerialNo"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDLoanDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dLoanDate = :dLoanDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDApplyedDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dApplyedDate = :dApplyedDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDApprovedDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dApprovedDate = :dApprovedDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNApplyedAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nApplyedAmount = :nApplyedAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNApprovedAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nApprovedAmount = :nApprovedAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNInsuredAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nInsuredAmount = :nInsuredAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNReservedAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nReservedAmount = :nReservedAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNEffectiveInt", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nEffectiveInt = :nEffectiveInt"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNPanaltyInt", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nPanaltyInt = :nPanaltyInt"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCBoardApprovalNo", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cBoardApprovalNo = :cBoardApprovalNo"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDBoardApprovalDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dBoardApprovalDate = :dBoardApprovalDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonPeriodTypeID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonPeriodTypeID = :nLonPeriodTypeID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonPeriod", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonPeriod = :nLonPeriod"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonPaymentFreeTypeID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonPaymentFreeTypeID = :nLonPaymentFreeTypeID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonPaymentFreeTime", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonPaymentFreeTime = :nLonPaymentFreeTime"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDFirstInstallmentDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dFirstInstallmentDate = :dFirstInstallmentDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDMaturityDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dMaturityDate = :dMaturityDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonDeductTypeID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonDeductTypeID = :nLonDeductTypeID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonGrpID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonGrpID = :nLonGrpID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNFixedInterestValue", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nFixedInterestValue = :nFixedInterestValue"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonInstallmentPayTypeID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonInstallmentPayTypeID = :nLonInstallmentPayTypeID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonInstallmentPayTime", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonInstallmentPayTime = :nLonInstallmentPayTime"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNInstallmentAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nInstallmentAmount = :nInstallmentAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNInstallmentAmountAdj", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nInstallmentAmountAdj = :nInstallmentAmountAdj"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNInstallmentAmountLast", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nInstallmentAmountLast = :nInstallmentAmountLast"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNDueDaysAfter", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nDueDaysAfter = :nDueDaysAfter"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNDeductDay", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nDeductDay = :nDeductDay"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNIssuedAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nIssuedAmount = :nIssuedAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNBalanceToIssue", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nBalanceToIssue = :nBalanceToIssue"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNOpeningBalance", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nOpeningBalance = :nOpeningBalance"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDSysOpenDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dSysOpenDate = :dSysOpenDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNSysOpenBalance", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nSysOpenBalance = :nSysOpenBalance"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNSysOpenPaidInt", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nSysOpenPaidInt = :nSysOpenPaidInt"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDLastCapitalPayDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dLastCapitalPayDate = :dLastCapitalPayDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDLastIntPayDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dLastIntPayDate = :dLastIntPayDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDLastPenaltyIntPayDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dLastPenaltyIntPayDate = :dLastPenaltyIntPayDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDNextRecoveryDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dNextRecoveryDate = :dNextRecoveryDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonBalanceAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonBalanceAmount = :nLonBalanceAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNLonBalanceInstallment", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nLonBalanceInstallment = :nLonBalanceInstallment"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvCapital", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvCapital = :nTotRecvCapital"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvInstallment", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvInstallment = :nTotRecvInstallment"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvInterest", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvInterest = :nTotRecvInterest"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNShouldRecvCapital", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nShouldRecvCapital = :nShouldRecvCapital"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNShouldRecvInstallment", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nShouldRecvInstallment = :nShouldRecvInstallment"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNShouldRecvInterest", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nShouldRecvInterest = :nShouldRecvInterest"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvPenaltyInterest", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvPenaltyInterest = :nTotRecvPenaltyInterest"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvOtherCharges", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvOtherCharges = :nTotRecvOtherCharges"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvPostage", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvPostage = :nTotRecvPostage"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvStationary", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvStationary = :nTotRecvStationary"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvArbitrationFees", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvArbitrationFees = :nTotRecvArbitrationFees"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNTotRecvCaurtFees", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nTotRecvCaurtFees = :nTotRecvCaurtFees"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateDueDays", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateDueDays = :nToDateDueDays"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateDueCapital", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateDueCapital = :nToDateDueCapital"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateDueInstallment", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateDueInstallment = :nToDateDueInstallment"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDToDateIntCalDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dToDateIntCalDate = :dToDateIntCalDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateIntRate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateIntRate = :nToDateIntRate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateIntSubjectAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateIntSubjectAmount = :nToDateIntSubjectAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateIntValue", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateIntValue = :nToDateIntValue"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateIntValueRound", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateIntValueRound = :nToDateIntValueRound"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDatePanaltyIntDays", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDatePanaltyIntDays = :nToDatePanaltyIntDays"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDatePanaltyIntSubjectAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDatePanaltyIntSubjectAmount = :nToDatePanaltyIntSubjectAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDatePanaltyIntRate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDatePanaltyIntRate = :nToDatePanaltyIntRate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDatePanaltyIntValue", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDatePanaltyIntValue = :nToDatePanaltyIntValue"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDatePanaltyIntValueRound", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDatePanaltyIntValueRound = :nToDatePanaltyIntValueRound"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateTotIntersest", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateTotIntersest = :nToDateTotIntersest"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateTotIntersestRound", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateTotIntersestRound = :nToDateTotIntersestRound"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDatePostage", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDatePostage = :nToDatePostage"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateStationary", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateStationary = :nToDateStationary"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateOherCharges", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateOherCharges = :nToDateOherCharges"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateArbitrationFees", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateArbitrationFees = :nToDateArbitrationFees"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNToDateCaurtFees", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nToDateCaurtFees = :nToDateCaurtFees"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNIssueToDepMFID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nIssueToDepMFID = :nIssueToDepMFID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBIssueByCash", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bIssueByCash = :bIssueByCash"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBIssueToSav", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bIssueToSav = :bIssueToSav"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBRecoverByCash", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bRecoverByCash = :bRecoverByCash"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBRecoverBySav", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bRecoverBySav = :bRecoverBySav"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNRecoverByDepMFID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nRecoverByDepMFID = :nRecoverByDepMFID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCRemarks", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cRemarks = :cRemarks"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBComplete", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bComplete = :bComplete"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDCompleteDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dCompleteDate = :dCompleteDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCArbitrationNo", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cArbitrationNo = :cArbitrationNo"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDArbitrationTransferDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dArbitrationTransferDate = :dArbitrationTransferDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDArbitrationDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dArbitrationDate = :dArbitrationDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDActualCompleteDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dActualCompleteDate = :dActualCompleteDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNArbitrationAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nArbitrationAmount = :nArbitrationAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNArbitrationInterst", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nArbitrationInterst = :nArbitrationInterst"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNArbitrationLawFees", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nArbitrationLawFees = :nArbitrationLawFees"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNArbitrationPostage", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nArbitrationPostage = :nArbitrationPostage"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDCourtTransferDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dCourtTransferDate = :dCourtTransferDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNCourtAmount", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nCourtAmount = :nCourtAmount"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNCourtInt", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nCourtInt = :nCourtInt"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCAddBy", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cAddBy = :cAddBy"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDAddDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dAddDate = :dAddDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCEditBy", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cEditBy = :cEditBy"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDEditDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dEditDate = :dEditDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBEditConfirm", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bEditConfirm = :bEditConfirm"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDConfirmDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dConfirmDate = :dConfirmDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCConfirmBy", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cConfirmBy = :cConfirmBy"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBInAudit", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bInAudit = :bInAudit"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBOutAudit", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bOutAudit = :bOutAudit"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDInAuditDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dInAuditDate = :dInAuditDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDOutAuditDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dOutAuditDate = :dOutAuditDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCInAuditBy", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cInAuditBy = :cInAuditBy"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCOutAuditBy", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cOutAuditBy = :cOutAuditBy"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNGurantorDepMFID", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nGurantorDepMFID = :nGurantorDepMFID"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCPropertyNo", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cPropertyNo = :cPropertyNo"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCPropertyName", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cPropertyName = :cPropertyName"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDRegDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dRegDate = :dRegDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByNPropertyValue", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.nPropertyValue = :nPropertyValue"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDPropertyReleaseDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dPropertyReleaseDate = :dPropertyReleaseDate"),
    @NamedQuery(name = "BnkLonLoanMaster.findByBGarbage", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.bGarbage = :bGarbage"),
    @NamedQuery(name = "BnkLonLoanMaster.findByCGarbageBy", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.cGarbageBy = :cGarbageBy"),
    @NamedQuery(name = "BnkLonLoanMaster.findByDGarbageDate", query = "SELECT b FROM BnkLonLoanMaster b WHERE b.dGarbageDate = :dGarbageDate")})
public class BnkLonLoanMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nLonMFID")
    private Long nLonMFID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nBankBranchID")
    private int nBankBranchID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonTypeID")
    private int nLonTypeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCustomerID")
    private long nCustomerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonDescriptionID")
    private int nLonDescriptionID;
    @Column(name = "nLonFundSourceID")
    private Integer nLonFundSourceID;
    @Column(name = "bJoint")
    private Boolean bJoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonStatusID")
    private int nLonStatusID;
    @Size(max = 13)
    @Column(name = "cLonAccountNo")
    private String cLonAccountNo;
    @Size(max = 13)
    @Column(name = "cOldLonAccountNo")
    private String cOldLonAccountNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nLedgerBookNo")
    private String nLedgerBookNo;
    @Size(max = 3)
    @Column(name = "cSerialNo")
    private String cSerialNo;
    @Column(name = "dLoanDate")
    @Temporal(TemporalType.DATE)
    private Date dLoanDate;
    @Column(name = "dApplyedDate")
    @Temporal(TemporalType.DATE)
    private Date dApplyedDate;
    @Column(name = "dApprovedDate")
    @Temporal(TemporalType.DATE)
    private Date dApprovedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nApplyedAmount")
    private BigDecimal nApplyedAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nApprovedAmount")
    private BigDecimal nApprovedAmount;
    @Column(name = "nInsuredAmount")
    private BigDecimal nInsuredAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nReservedAmount")
    private BigDecimal nReservedAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nEffectiveInt")
    private BigDecimal nEffectiveInt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nPanaltyInt")
    private BigDecimal nPanaltyInt;
    @Size(max = 50)
    @Column(name = "cBoardApprovalNo")
    private String cBoardApprovalNo;
    @Column(name = "dBoardApprovalDate")
    @Temporal(TemporalType.DATE)
    private Date dBoardApprovalDate;
    @Column(name = "nLonPeriodTypeID")
    private Short nLonPeriodTypeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonPeriod")
    private int nLonPeriod;
    @Column(name = "nLonPaymentFreeTypeID")
    private Short nLonPaymentFreeTypeID;
    @Column(name = "nLonPaymentFreeTime")
    private Integer nLonPaymentFreeTime;
    @Column(name = "dFirstInstallmentDate")
    @Temporal(TemporalType.DATE)
    private Date dFirstInstallmentDate;
    @Column(name = "dMaturityDate")
    @Temporal(TemporalType.DATE)
    private Date dMaturityDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonDeductTypeID")
    private short nLonDeductTypeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nLonGrpID")
    private int nLonGrpID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nFixedInterest_Value")
    private BigDecimal nFixedInterestValue;
    @Column(name = "nLonInstallmentPayTypeID")
    private Short nLonInstallmentPayTypeID;
    @Column(name = "nLonInstallmentPayTime")
    private Integer nLonInstallmentPayTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nInstallmentAmount")
    private BigDecimal nInstallmentAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nInstallmentAmount_Adj")
    private BigDecimal nInstallmentAmountAdj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nInstallmentAmount_Last")
    private BigDecimal nInstallmentAmountLast;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDueDaysAfter")
    private int nDueDaysAfter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nDeductDay")
    private short nDeductDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIssuedAmount")
    private BigDecimal nIssuedAmount;
    @Column(name = "nBalanceToIssue")
    private BigDecimal nBalanceToIssue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nOpeningBalance")
    private BigDecimal nOpeningBalance;
    @Column(name = "dSysOpenDate")
    @Temporal(TemporalType.DATE)
    private Date dSysOpenDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nSysOpenBalance")
    private BigDecimal nSysOpenBalance;
    @Column(name = "nSysOpenPaidInt")
    private BigDecimal nSysOpenPaidInt;
    @Column(name = "dLastCapitalPayDate")
    @Temporal(TemporalType.DATE)
    private Date dLastCapitalPayDate;
    @Column(name = "dLastIntPayDate")
    @Temporal(TemporalType.DATE)
    private Date dLastIntPayDate;
    @Column(name = "dLastPenaltyIntPayDate")
    @Temporal(TemporalType.DATE)
    private Date dLastPenaltyIntPayDate;
    @Column(name = "dNextRecoveryDate")
    @Temporal(TemporalType.DATE)
    private Date dNextRecoveryDate;
    @Column(name = "nLonBalance_Amount")
    private BigDecimal nLonBalanceAmount;
    @Column(name = "nLonBalance_Installment")
    private BigDecimal nLonBalanceInstallment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Capital")
    private BigDecimal nTotRecvCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Installment")
    private BigDecimal nTotRecvInstallment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Interest")
    private BigDecimal nTotRecvInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nShouldRecv_Capital")
    private BigDecimal nShouldRecvCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nShouldRecv_Installment")
    private BigDecimal nShouldRecvInstallment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nShouldRecv_Interest")
    private BigDecimal nShouldRecvInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_PenaltyInterest")
    private BigDecimal nTotRecvPenaltyInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_OtherCharges")
    private BigDecimal nTotRecvOtherCharges;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Postage")
    private BigDecimal nTotRecvPostage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_Stationary")
    private BigDecimal nTotRecvStationary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_ArbitrationFees")
    private BigDecimal nTotRecvArbitrationFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nTotRecv_CaurtFees")
    private BigDecimal nTotRecvCaurtFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateDue_Days")
    private int nToDateDueDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateDue_Capital")
    private BigDecimal nToDateDueCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateDue_Installment")
    private BigDecimal nToDateDueInstallment;
    @Column(name = "dToDateInt_CalDate")
    @Temporal(TemporalType.DATE)
    private Date dToDateIntCalDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateInt_Rate")
    private BigDecimal nToDateIntRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateInt_SubjectAmount")
    private BigDecimal nToDateIntSubjectAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateInt_Value")
    private BigDecimal nToDateIntValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateInt_ValueRound")
    private BigDecimal nToDateIntValueRound;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDatePanaltyInt_Days")
    private int nToDatePanaltyIntDays;
    @Column(name = "nToDatePanaltyInt_SubjectAmount")
    private BigDecimal nToDatePanaltyIntSubjectAmount;
    @Column(name = "nToDatePanaltyInt_Rate")
    private BigDecimal nToDatePanaltyIntRate;
    @Column(name = "nToDatePanaltyInt_Value")
    private BigDecimal nToDatePanaltyIntValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDatePanaltyInt_ValueRound")
    private BigDecimal nToDatePanaltyIntValueRound;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateTot_Intersest")
    private BigDecimal nToDateTotIntersest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nToDateTot_IntersestRound")
    private BigDecimal nToDateTotIntersestRound;
    @Column(name = "nToDate_Postage")
    private BigDecimal nToDatePostage;
    @Column(name = "nToDate_Stationary")
    private BigDecimal nToDateStationary;
    @Column(name = "nToDate_OherCharges")
    private BigDecimal nToDateOherCharges;
    @Column(name = "nToDate_ArbitrationFees")
    private BigDecimal nToDateArbitrationFees;
    @Column(name = "nToDate_CaurtFees")
    private BigDecimal nToDateCaurtFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIssueTo_DepMFID")
    private long nIssueToDepMFID;
    @Column(name = "bIssueBy_Cash")
    private Short bIssueByCash;
    @Column(name = "bIssueTo_Sav")
    private Short bIssueToSav;
    @Column(name = "bRecoverBy_Cash")
    private Short bRecoverByCash;
    @Column(name = "bRecoverBy_Sav")
    private Short bRecoverBySav;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nRecoverBy_DepMFID")
    private long nRecoverByDepMFID;
    @Size(max = 20)
    @Column(name = "cRemarks")
    private String cRemarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bComplete")
    private boolean bComplete;
    @Column(name = "dCompleteDate")
    @Temporal(TemporalType.DATE)
    private Date dCompleteDate;
    @Size(max = 6)
    @Column(name = "cArbitration_No")
    private String cArbitrationNo;
    @Column(name = "dArbitration_TransferDate")
    @Temporal(TemporalType.DATE)
    private Date dArbitrationTransferDate;
    @Column(name = "dArbitration_Date")
    @Temporal(TemporalType.DATE)
    private Date dArbitrationDate;
    @Column(name = "dActualCompleteDate")
    @Temporal(TemporalType.DATE)
    private Date dActualCompleteDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nArbitration_Amount")
    private BigDecimal nArbitrationAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nArbitration_Interst")
    private BigDecimal nArbitrationInterst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nArbitration_LawFees")
    private BigDecimal nArbitrationLawFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nArbitration_Postage")
    private BigDecimal nArbitrationPostage;
    @Column(name = "dCourt_TransferDate")
    @Temporal(TemporalType.DATE)
    private Date dCourtTransferDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCourt_Amount")
    private BigDecimal nCourtAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nCourt_Int")
    private BigDecimal nCourtInt;
    @Size(max = 20)
    @Column(name = "cAddBy")
    private String cAddBy;
    @Column(name = "dAddDate")
    @Temporal(TemporalType.DATE)
    private Date dAddDate;
    @Size(max = 20)
    @Column(name = "cEditBy")
    private String cEditBy;
    @Column(name = "dEditDate")
    @Temporal(TemporalType.DATE)
    private Date dEditDate;
    @Column(name = "bEditConfirm")
    private Boolean bEditConfirm;
    @Column(name = "dConfirmDate")
    @Temporal(TemporalType.DATE)
    private Date dConfirmDate;
    @Size(max = 30)
    @Column(name = "cConfirmBy")
    private String cConfirmBy;
    @Column(name = "bInAudit")
    private Boolean bInAudit;
    @Column(name = "bOutAudit")
    private Boolean bOutAudit;
    @Column(name = "dInAuditDate")
    @Temporal(TemporalType.DATE)
    private Date dInAuditDate;
    @Column(name = "dOutAuditDate")
    @Temporal(TemporalType.DATE)
    private Date dOutAuditDate;
    @Size(max = 30)
    @Column(name = "cInAuditBy")
    private String cInAuditBy;
    @Size(max = 30)
    @Column(name = "cOutAuditBy")
    private String cOutAuditBy;
    @Column(name = "nGurantor_DepMFID")
    private Integer nGurantorDepMFID;
    @Size(max = 70)
    @Column(name = "cPropertyNo")
    private String cPropertyNo;
    @Size(max = 200)
    @Column(name = "cPropertyName")
    private String cPropertyName;
    @Column(name = "dRegDate")
    @Temporal(TemporalType.DATE)
    private Date dRegDate;
    @Column(name = "nPropertyValue")
    private BigDecimal nPropertyValue;
    @Column(name = "dPropertyReleaseDate")
    @Temporal(TemporalType.DATE)
    private Date dPropertyReleaseDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bGarbage")
    private short bGarbage;
    @Size(max = 30)
    @Column(name = "cGarbageBy")
    private String cGarbageBy;
    @Column(name = "dGarbageDate")
    @Temporal(TemporalType.DATE)
    private Date dGarbageDate;

    public BnkLonLoanMaster() {
    }

    public BnkLonLoanMaster(Long nLonMFID) {
        this.nLonMFID = nLonMFID;
    }

    public BnkLonLoanMaster(Long nLonMFID, int nBankBranchID, int nLonTypeID, long nCustomerID, int nLonDescriptionID, int nLonStatusID, String nLedgerBookNo, BigDecimal nApplyedAmount, BigDecimal nApprovedAmount, BigDecimal nReservedAmount, BigDecimal nEffectiveInt, BigDecimal nPanaltyInt, int nLonPeriod, short nLonDeductTypeID, int nLonGrpID, BigDecimal nFixedInterestValue, BigDecimal nInstallmentAmount, BigDecimal nInstallmentAmountAdj, BigDecimal nInstallmentAmountLast, int nDueDaysAfter, short nDeductDay, BigDecimal nIssuedAmount, BigDecimal nOpeningBalance, BigDecimal nSysOpenBalance, BigDecimal nTotRecvCapital, BigDecimal nTotRecvInstallment, BigDecimal nTotRecvInterest, BigDecimal nShouldRecvCapital, BigDecimal nShouldRecvInstallment, BigDecimal nShouldRecvInterest, BigDecimal nTotRecvPenaltyInterest, BigDecimal nTotRecvOtherCharges, BigDecimal nTotRecvPostage, BigDecimal nTotRecvStationary, BigDecimal nTotRecvArbitrationFees, BigDecimal nTotRecvCaurtFees, int nToDateDueDays, BigDecimal nToDateDueCapital, BigDecimal nToDateDueInstallment, BigDecimal nToDateIntRate, BigDecimal nToDateIntSubjectAmount, BigDecimal nToDateIntValue, BigDecimal nToDateIntValueRound, int nToDatePanaltyIntDays, BigDecimal nToDatePanaltyIntValueRound, BigDecimal nToDateTotIntersest, BigDecimal nToDateTotIntersestRound, long nIssueToDepMFID, long nRecoverByDepMFID, boolean bComplete, BigDecimal nArbitrationAmount, BigDecimal nArbitrationInterst, BigDecimal nArbitrationLawFees, BigDecimal nArbitrationPostage, BigDecimal nCourtAmount, BigDecimal nCourtInt, short bGarbage) {
        this.nLonMFID = nLonMFID;
        this.nBankBranchID = nBankBranchID;
        this.nLonTypeID = nLonTypeID;
        this.nCustomerID = nCustomerID;
        this.nLonDescriptionID = nLonDescriptionID;
        this.nLonStatusID = nLonStatusID;
        this.nLedgerBookNo = nLedgerBookNo;
        this.nApplyedAmount = nApplyedAmount;
        this.nApprovedAmount = nApprovedAmount;
        this.nReservedAmount = nReservedAmount;
        this.nEffectiveInt = nEffectiveInt;
        this.nPanaltyInt = nPanaltyInt;
        this.nLonPeriod = nLonPeriod;
        this.nLonDeductTypeID = nLonDeductTypeID;
        this.nLonGrpID = nLonGrpID;
        this.nFixedInterestValue = nFixedInterestValue;
        this.nInstallmentAmount = nInstallmentAmount;
        this.nInstallmentAmountAdj = nInstallmentAmountAdj;
        this.nInstallmentAmountLast = nInstallmentAmountLast;
        this.nDueDaysAfter = nDueDaysAfter;
        this.nDeductDay = nDeductDay;
        this.nIssuedAmount = nIssuedAmount;
        this.nOpeningBalance = nOpeningBalance;
        this.nSysOpenBalance = nSysOpenBalance;
        this.nTotRecvCapital = nTotRecvCapital;
        this.nTotRecvInstallment = nTotRecvInstallment;
        this.nTotRecvInterest = nTotRecvInterest;
        this.nShouldRecvCapital = nShouldRecvCapital;
        this.nShouldRecvInstallment = nShouldRecvInstallment;
        this.nShouldRecvInterest = nShouldRecvInterest;
        this.nTotRecvPenaltyInterest = nTotRecvPenaltyInterest;
        this.nTotRecvOtherCharges = nTotRecvOtherCharges;
        this.nTotRecvPostage = nTotRecvPostage;
        this.nTotRecvStationary = nTotRecvStationary;
        this.nTotRecvArbitrationFees = nTotRecvArbitrationFees;
        this.nTotRecvCaurtFees = nTotRecvCaurtFees;
        this.nToDateDueDays = nToDateDueDays;
        this.nToDateDueCapital = nToDateDueCapital;
        this.nToDateDueInstallment = nToDateDueInstallment;
        this.nToDateIntRate = nToDateIntRate;
        this.nToDateIntSubjectAmount = nToDateIntSubjectAmount;
        this.nToDateIntValue = nToDateIntValue;
        this.nToDateIntValueRound = nToDateIntValueRound;
        this.nToDatePanaltyIntDays = nToDatePanaltyIntDays;
        this.nToDatePanaltyIntValueRound = nToDatePanaltyIntValueRound;
        this.nToDateTotIntersest = nToDateTotIntersest;
        this.nToDateTotIntersestRound = nToDateTotIntersestRound;
        this.nIssueToDepMFID = nIssueToDepMFID;
        this.nRecoverByDepMFID = nRecoverByDepMFID;
        this.bComplete = bComplete;
        this.nArbitrationAmount = nArbitrationAmount;
        this.nArbitrationInterst = nArbitrationInterst;
        this.nArbitrationLawFees = nArbitrationLawFees;
        this.nArbitrationPostage = nArbitrationPostage;
        this.nCourtAmount = nCourtAmount;
        this.nCourtInt = nCourtInt;
        this.bGarbage = bGarbage;
    }

    public Long getNLonMFID() {
        return nLonMFID;
    }

    public void setNLonMFID(Long nLonMFID) {
        this.nLonMFID = nLonMFID;
    }

    public int getNBankBranchID() {
        return nBankBranchID;
    }

    public void setNBankBranchID(int nBankBranchID) {
        this.nBankBranchID = nBankBranchID;
    }

    public int getNLonTypeID() {
        return nLonTypeID;
    }

    public void setNLonTypeID(int nLonTypeID) {
        this.nLonTypeID = nLonTypeID;
    }

    public long getNCustomerID() {
        return nCustomerID;
    }

    public void setNCustomerID(long nCustomerID) {
        this.nCustomerID = nCustomerID;
    }

    public int getNLonDescriptionID() {
        return nLonDescriptionID;
    }

    public void setNLonDescriptionID(int nLonDescriptionID) {
        this.nLonDescriptionID = nLonDescriptionID;
    }

    public Integer getNLonFundSourceID() {
        return nLonFundSourceID;
    }

    public void setNLonFundSourceID(Integer nLonFundSourceID) {
        this.nLonFundSourceID = nLonFundSourceID;
    }

    public Boolean getBJoint() {
        return bJoint;
    }

    public void setBJoint(Boolean bJoint) {
        this.bJoint = bJoint;
    }

    public int getNLonStatusID() {
        return nLonStatusID;
    }

    public void setNLonStatusID(int nLonStatusID) {
        this.nLonStatusID = nLonStatusID;
    }

    public String getCLonAccountNo() {
        return cLonAccountNo;
    }

    public void setCLonAccountNo(String cLonAccountNo) {
        this.cLonAccountNo = cLonAccountNo;
    }

    public String getCOldLonAccountNo() {
        return cOldLonAccountNo;
    }

    public void setCOldLonAccountNo(String cOldLonAccountNo) {
        this.cOldLonAccountNo = cOldLonAccountNo;
    }

    public String getNLedgerBookNo() {
        return nLedgerBookNo;
    }

    public void setNLedgerBookNo(String nLedgerBookNo) {
        this.nLedgerBookNo = nLedgerBookNo;
    }

    public String getCSerialNo() {
        return cSerialNo;
    }

    public void setCSerialNo(String cSerialNo) {
        this.cSerialNo = cSerialNo;
    }

    public Date getDLoanDate() {
        return dLoanDate;
    }

    public void setDLoanDate(Date dLoanDate) {
        this.dLoanDate = dLoanDate;
    }

    public Date getDApplyedDate() {
        return dApplyedDate;
    }

    public void setDApplyedDate(Date dApplyedDate) {
        this.dApplyedDate = dApplyedDate;
    }

    public Date getDApprovedDate() {
        return dApprovedDate;
    }

    public void setDApprovedDate(Date dApprovedDate) {
        this.dApprovedDate = dApprovedDate;
    }

    public BigDecimal getNApplyedAmount() {
        return nApplyedAmount;
    }

    public void setNApplyedAmount(BigDecimal nApplyedAmount) {
        this.nApplyedAmount = nApplyedAmount;
    }

    public BigDecimal getNApprovedAmount() {
        return nApprovedAmount;
    }

    public void setNApprovedAmount(BigDecimal nApprovedAmount) {
        this.nApprovedAmount = nApprovedAmount;
    }

    public BigDecimal getNInsuredAmount() {
        return nInsuredAmount;
    }

    public void setNInsuredAmount(BigDecimal nInsuredAmount) {
        this.nInsuredAmount = nInsuredAmount;
    }

    public BigDecimal getNReservedAmount() {
        return nReservedAmount;
    }

    public void setNReservedAmount(BigDecimal nReservedAmount) {
        this.nReservedAmount = nReservedAmount;
    }

    public BigDecimal getNEffectiveInt() {
        return nEffectiveInt;
    }

    public void setNEffectiveInt(BigDecimal nEffectiveInt) {
        this.nEffectiveInt = nEffectiveInt;
    }

    public BigDecimal getNPanaltyInt() {
        return nPanaltyInt;
    }

    public void setNPanaltyInt(BigDecimal nPanaltyInt) {
        this.nPanaltyInt = nPanaltyInt;
    }

    public String getCBoardApprovalNo() {
        return cBoardApprovalNo;
    }

    public void setCBoardApprovalNo(String cBoardApprovalNo) {
        this.cBoardApprovalNo = cBoardApprovalNo;
    }

    public Date getDBoardApprovalDate() {
        return dBoardApprovalDate;
    }

    public void setDBoardApprovalDate(Date dBoardApprovalDate) {
        this.dBoardApprovalDate = dBoardApprovalDate;
    }

    public Short getNLonPeriodTypeID() {
        return nLonPeriodTypeID;
    }

    public void setNLonPeriodTypeID(Short nLonPeriodTypeID) {
        this.nLonPeriodTypeID = nLonPeriodTypeID;
    }

    public int getNLonPeriod() {
        return nLonPeriod;
    }

    public void setNLonPeriod(int nLonPeriod) {
        this.nLonPeriod = nLonPeriod;
    }

    public Short getNLonPaymentFreeTypeID() {
        return nLonPaymentFreeTypeID;
    }

    public void setNLonPaymentFreeTypeID(Short nLonPaymentFreeTypeID) {
        this.nLonPaymentFreeTypeID = nLonPaymentFreeTypeID;
    }

    public Integer getNLonPaymentFreeTime() {
        return nLonPaymentFreeTime;
    }

    public void setNLonPaymentFreeTime(Integer nLonPaymentFreeTime) {
        this.nLonPaymentFreeTime = nLonPaymentFreeTime;
    }

    public Date getDFirstInstallmentDate() {
        return dFirstInstallmentDate;
    }

    public void setDFirstInstallmentDate(Date dFirstInstallmentDate) {
        this.dFirstInstallmentDate = dFirstInstallmentDate;
    }

    public Date getDMaturityDate() {
        return dMaturityDate;
    }

    public void setDMaturityDate(Date dMaturityDate) {
        this.dMaturityDate = dMaturityDate;
    }

    public short getNLonDeductTypeID() {
        return nLonDeductTypeID;
    }

    public void setNLonDeductTypeID(short nLonDeductTypeID) {
        this.nLonDeductTypeID = nLonDeductTypeID;
    }

    public int getNLonGrpID() {
        return nLonGrpID;
    }

    public void setNLonGrpID(int nLonGrpID) {
        this.nLonGrpID = nLonGrpID;
    }

    public BigDecimal getNFixedInterestValue() {
        return nFixedInterestValue;
    }

    public void setNFixedInterestValue(BigDecimal nFixedInterestValue) {
        this.nFixedInterestValue = nFixedInterestValue;
    }

    public Short getNLonInstallmentPayTypeID() {
        return nLonInstallmentPayTypeID;
    }

    public void setNLonInstallmentPayTypeID(Short nLonInstallmentPayTypeID) {
        this.nLonInstallmentPayTypeID = nLonInstallmentPayTypeID;
    }

    public Integer getNLonInstallmentPayTime() {
        return nLonInstallmentPayTime;
    }

    public void setNLonInstallmentPayTime(Integer nLonInstallmentPayTime) {
        this.nLonInstallmentPayTime = nLonInstallmentPayTime;
    }

    public BigDecimal getNInstallmentAmount() {
        return nInstallmentAmount;
    }

    public void setNInstallmentAmount(BigDecimal nInstallmentAmount) {
        this.nInstallmentAmount = nInstallmentAmount;
    }

    public BigDecimal getNInstallmentAmountAdj() {
        return nInstallmentAmountAdj;
    }

    public void setNInstallmentAmountAdj(BigDecimal nInstallmentAmountAdj) {
        this.nInstallmentAmountAdj = nInstallmentAmountAdj;
    }

    public BigDecimal getNInstallmentAmountLast() {
        return nInstallmentAmountLast;
    }

    public void setNInstallmentAmountLast(BigDecimal nInstallmentAmountLast) {
        this.nInstallmentAmountLast = nInstallmentAmountLast;
    }

    public int getNDueDaysAfter() {
        return nDueDaysAfter;
    }

    public void setNDueDaysAfter(int nDueDaysAfter) {
        this.nDueDaysAfter = nDueDaysAfter;
    }

    public short getNDeductDay() {
        return nDeductDay;
    }

    public void setNDeductDay(short nDeductDay) {
        this.nDeductDay = nDeductDay;
    }

    public BigDecimal getNIssuedAmount() {
        return nIssuedAmount;
    }

    public void setNIssuedAmount(BigDecimal nIssuedAmount) {
        this.nIssuedAmount = nIssuedAmount;
    }

    public BigDecimal getNBalanceToIssue() {
        return nBalanceToIssue;
    }

    public void setNBalanceToIssue(BigDecimal nBalanceToIssue) {
        this.nBalanceToIssue = nBalanceToIssue;
    }

    public BigDecimal getNOpeningBalance() {
        return nOpeningBalance;
    }

    public void setNOpeningBalance(BigDecimal nOpeningBalance) {
        this.nOpeningBalance = nOpeningBalance;
    }

    public Date getDSysOpenDate() {
        return dSysOpenDate;
    }

    public void setDSysOpenDate(Date dSysOpenDate) {
        this.dSysOpenDate = dSysOpenDate;
    }

    public BigDecimal getNSysOpenBalance() {
        return nSysOpenBalance;
    }

    public void setNSysOpenBalance(BigDecimal nSysOpenBalance) {
        this.nSysOpenBalance = nSysOpenBalance;
    }

    public BigDecimal getNSysOpenPaidInt() {
        return nSysOpenPaidInt;
    }

    public void setNSysOpenPaidInt(BigDecimal nSysOpenPaidInt) {
        this.nSysOpenPaidInt = nSysOpenPaidInt;
    }

    public Date getDLastCapitalPayDate() {
        return dLastCapitalPayDate;
    }

    public void setDLastCapitalPayDate(Date dLastCapitalPayDate) {
        this.dLastCapitalPayDate = dLastCapitalPayDate;
    }

    public Date getDLastIntPayDate() {
        return dLastIntPayDate;
    }

    public void setDLastIntPayDate(Date dLastIntPayDate) {
        this.dLastIntPayDate = dLastIntPayDate;
    }

    public Date getDLastPenaltyIntPayDate() {
        return dLastPenaltyIntPayDate;
    }

    public void setDLastPenaltyIntPayDate(Date dLastPenaltyIntPayDate) {
        this.dLastPenaltyIntPayDate = dLastPenaltyIntPayDate;
    }

    public Date getDNextRecoveryDate() {
        return dNextRecoveryDate;
    }

    public void setDNextRecoveryDate(Date dNextRecoveryDate) {
        this.dNextRecoveryDate = dNextRecoveryDate;
    }

    public BigDecimal getNLonBalanceAmount() {
        return nLonBalanceAmount;
    }

    public void setNLonBalanceAmount(BigDecimal nLonBalanceAmount) {
        this.nLonBalanceAmount = nLonBalanceAmount;
    }

    public BigDecimal getNLonBalanceInstallment() {
        return nLonBalanceInstallment;
    }

    public void setNLonBalanceInstallment(BigDecimal nLonBalanceInstallment) {
        this.nLonBalanceInstallment = nLonBalanceInstallment;
    }

    public BigDecimal getNTotRecvCapital() {
        return nTotRecvCapital;
    }

    public void setNTotRecvCapital(BigDecimal nTotRecvCapital) {
        this.nTotRecvCapital = nTotRecvCapital;
    }

    public BigDecimal getNTotRecvInstallment() {
        return nTotRecvInstallment;
    }

    public void setNTotRecvInstallment(BigDecimal nTotRecvInstallment) {
        this.nTotRecvInstallment = nTotRecvInstallment;
    }

    public BigDecimal getNTotRecvInterest() {
        return nTotRecvInterest;
    }

    public void setNTotRecvInterest(BigDecimal nTotRecvInterest) {
        this.nTotRecvInterest = nTotRecvInterest;
    }

    public BigDecimal getNShouldRecvCapital() {
        return nShouldRecvCapital;
    }

    public void setNShouldRecvCapital(BigDecimal nShouldRecvCapital) {
        this.nShouldRecvCapital = nShouldRecvCapital;
    }

    public BigDecimal getNShouldRecvInstallment() {
        return nShouldRecvInstallment;
    }

    public void setNShouldRecvInstallment(BigDecimal nShouldRecvInstallment) {
        this.nShouldRecvInstallment = nShouldRecvInstallment;
    }

    public BigDecimal getNShouldRecvInterest() {
        return nShouldRecvInterest;
    }

    public void setNShouldRecvInterest(BigDecimal nShouldRecvInterest) {
        this.nShouldRecvInterest = nShouldRecvInterest;
    }

    public BigDecimal getNTotRecvPenaltyInterest() {
        return nTotRecvPenaltyInterest;
    }

    public void setNTotRecvPenaltyInterest(BigDecimal nTotRecvPenaltyInterest) {
        this.nTotRecvPenaltyInterest = nTotRecvPenaltyInterest;
    }

    public BigDecimal getNTotRecvOtherCharges() {
        return nTotRecvOtherCharges;
    }

    public void setNTotRecvOtherCharges(BigDecimal nTotRecvOtherCharges) {
        this.nTotRecvOtherCharges = nTotRecvOtherCharges;
    }

    public BigDecimal getNTotRecvPostage() {
        return nTotRecvPostage;
    }

    public void setNTotRecvPostage(BigDecimal nTotRecvPostage) {
        this.nTotRecvPostage = nTotRecvPostage;
    }

    public BigDecimal getNTotRecvStationary() {
        return nTotRecvStationary;
    }

    public void setNTotRecvStationary(BigDecimal nTotRecvStationary) {
        this.nTotRecvStationary = nTotRecvStationary;
    }

    public BigDecimal getNTotRecvArbitrationFees() {
        return nTotRecvArbitrationFees;
    }

    public void setNTotRecvArbitrationFees(BigDecimal nTotRecvArbitrationFees) {
        this.nTotRecvArbitrationFees = nTotRecvArbitrationFees;
    }

    public BigDecimal getNTotRecvCaurtFees() {
        return nTotRecvCaurtFees;
    }

    public void setNTotRecvCaurtFees(BigDecimal nTotRecvCaurtFees) {
        this.nTotRecvCaurtFees = nTotRecvCaurtFees;
    }

    public int getNToDateDueDays() {
        return nToDateDueDays;
    }

    public void setNToDateDueDays(int nToDateDueDays) {
        this.nToDateDueDays = nToDateDueDays;
    }

    public BigDecimal getNToDateDueCapital() {
        return nToDateDueCapital;
    }

    public void setNToDateDueCapital(BigDecimal nToDateDueCapital) {
        this.nToDateDueCapital = nToDateDueCapital;
    }

    public BigDecimal getNToDateDueInstallment() {
        return nToDateDueInstallment;
    }

    public void setNToDateDueInstallment(BigDecimal nToDateDueInstallment) {
        this.nToDateDueInstallment = nToDateDueInstallment;
    }

    public Date getDToDateIntCalDate() {
        return dToDateIntCalDate;
    }

    public void setDToDateIntCalDate(Date dToDateIntCalDate) {
        this.dToDateIntCalDate = dToDateIntCalDate;
    }

    public BigDecimal getNToDateIntRate() {
        return nToDateIntRate;
    }

    public void setNToDateIntRate(BigDecimal nToDateIntRate) {
        this.nToDateIntRate = nToDateIntRate;
    }

    public BigDecimal getNToDateIntSubjectAmount() {
        return nToDateIntSubjectAmount;
    }

    public void setNToDateIntSubjectAmount(BigDecimal nToDateIntSubjectAmount) {
        this.nToDateIntSubjectAmount = nToDateIntSubjectAmount;
    }

    public BigDecimal getNToDateIntValue() {
        return nToDateIntValue;
    }

    public void setNToDateIntValue(BigDecimal nToDateIntValue) {
        this.nToDateIntValue = nToDateIntValue;
    }

    public BigDecimal getNToDateIntValueRound() {
        return nToDateIntValueRound;
    }

    public void setNToDateIntValueRound(BigDecimal nToDateIntValueRound) {
        this.nToDateIntValueRound = nToDateIntValueRound;
    }

    public int getNToDatePanaltyIntDays() {
        return nToDatePanaltyIntDays;
    }

    public void setNToDatePanaltyIntDays(int nToDatePanaltyIntDays) {
        this.nToDatePanaltyIntDays = nToDatePanaltyIntDays;
    }

    public BigDecimal getNToDatePanaltyIntSubjectAmount() {
        return nToDatePanaltyIntSubjectAmount;
    }

    public void setNToDatePanaltyIntSubjectAmount(BigDecimal nToDatePanaltyIntSubjectAmount) {
        this.nToDatePanaltyIntSubjectAmount = nToDatePanaltyIntSubjectAmount;
    }

    public BigDecimal getNToDatePanaltyIntRate() {
        return nToDatePanaltyIntRate;
    }

    public void setNToDatePanaltyIntRate(BigDecimal nToDatePanaltyIntRate) {
        this.nToDatePanaltyIntRate = nToDatePanaltyIntRate;
    }

    public BigDecimal getNToDatePanaltyIntValue() {
        return nToDatePanaltyIntValue;
    }

    public void setNToDatePanaltyIntValue(BigDecimal nToDatePanaltyIntValue) {
        this.nToDatePanaltyIntValue = nToDatePanaltyIntValue;
    }

    public BigDecimal getNToDatePanaltyIntValueRound() {
        return nToDatePanaltyIntValueRound;
    }

    public void setNToDatePanaltyIntValueRound(BigDecimal nToDatePanaltyIntValueRound) {
        this.nToDatePanaltyIntValueRound = nToDatePanaltyIntValueRound;
    }

    public BigDecimal getNToDateTotIntersest() {
        return nToDateTotIntersest;
    }

    public void setNToDateTotIntersest(BigDecimal nToDateTotIntersest) {
        this.nToDateTotIntersest = nToDateTotIntersest;
    }

    public BigDecimal getNToDateTotIntersestRound() {
        return nToDateTotIntersestRound;
    }

    public void setNToDateTotIntersestRound(BigDecimal nToDateTotIntersestRound) {
        this.nToDateTotIntersestRound = nToDateTotIntersestRound;
    }

    public BigDecimal getNToDatePostage() {
        return nToDatePostage;
    }

    public void setNToDatePostage(BigDecimal nToDatePostage) {
        this.nToDatePostage = nToDatePostage;
    }

    public BigDecimal getNToDateStationary() {
        return nToDateStationary;
    }

    public void setNToDateStationary(BigDecimal nToDateStationary) {
        this.nToDateStationary = nToDateStationary;
    }

    public BigDecimal getNToDateOherCharges() {
        return nToDateOherCharges;
    }

    public void setNToDateOherCharges(BigDecimal nToDateOherCharges) {
        this.nToDateOherCharges = nToDateOherCharges;
    }

    public BigDecimal getNToDateArbitrationFees() {
        return nToDateArbitrationFees;
    }

    public void setNToDateArbitrationFees(BigDecimal nToDateArbitrationFees) {
        this.nToDateArbitrationFees = nToDateArbitrationFees;
    }

    public BigDecimal getNToDateCaurtFees() {
        return nToDateCaurtFees;
    }

    public void setNToDateCaurtFees(BigDecimal nToDateCaurtFees) {
        this.nToDateCaurtFees = nToDateCaurtFees;
    }

    public long getNIssueToDepMFID() {
        return nIssueToDepMFID;
    }

    public void setNIssueToDepMFID(long nIssueToDepMFID) {
        this.nIssueToDepMFID = nIssueToDepMFID;
    }

    public Short getBIssueByCash() {
        return bIssueByCash;
    }

    public void setBIssueByCash(Short bIssueByCash) {
        this.bIssueByCash = bIssueByCash;
    }

    public Short getBIssueToSav() {
        return bIssueToSav;
    }

    public void setBIssueToSav(Short bIssueToSav) {
        this.bIssueToSav = bIssueToSav;
    }

    public Short getBRecoverByCash() {
        return bRecoverByCash;
    }

    public void setBRecoverByCash(Short bRecoverByCash) {
        this.bRecoverByCash = bRecoverByCash;
    }

    public Short getBRecoverBySav() {
        return bRecoverBySav;
    }

    public void setBRecoverBySav(Short bRecoverBySav) {
        this.bRecoverBySav = bRecoverBySav;
    }

    public long getNRecoverByDepMFID() {
        return nRecoverByDepMFID;
    }

    public void setNRecoverByDepMFID(long nRecoverByDepMFID) {
        this.nRecoverByDepMFID = nRecoverByDepMFID;
    }

    public String getCRemarks() {
        return cRemarks;
    }

    public void setCRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public boolean getBComplete() {
        return bComplete;
    }

    public void setBComplete(boolean bComplete) {
        this.bComplete = bComplete;
    }

    public Date getDCompleteDate() {
        return dCompleteDate;
    }

    public void setDCompleteDate(Date dCompleteDate) {
        this.dCompleteDate = dCompleteDate;
    }

    public String getCArbitrationNo() {
        return cArbitrationNo;
    }

    public void setCArbitrationNo(String cArbitrationNo) {
        this.cArbitrationNo = cArbitrationNo;
    }

    public Date getDArbitrationTransferDate() {
        return dArbitrationTransferDate;
    }

    public void setDArbitrationTransferDate(Date dArbitrationTransferDate) {
        this.dArbitrationTransferDate = dArbitrationTransferDate;
    }

    public Date getDArbitrationDate() {
        return dArbitrationDate;
    }

    public void setDArbitrationDate(Date dArbitrationDate) {
        this.dArbitrationDate = dArbitrationDate;
    }

    public Date getDActualCompleteDate() {
        return dActualCompleteDate;
    }

    public void setDActualCompleteDate(Date dActualCompleteDate) {
        this.dActualCompleteDate = dActualCompleteDate;
    }

    public BigDecimal getNArbitrationAmount() {
        return nArbitrationAmount;
    }

    public void setNArbitrationAmount(BigDecimal nArbitrationAmount) {
        this.nArbitrationAmount = nArbitrationAmount;
    }

    public BigDecimal getNArbitrationInterst() {
        return nArbitrationInterst;
    }

    public void setNArbitrationInterst(BigDecimal nArbitrationInterst) {
        this.nArbitrationInterst = nArbitrationInterst;
    }

    public BigDecimal getNArbitrationLawFees() {
        return nArbitrationLawFees;
    }

    public void setNArbitrationLawFees(BigDecimal nArbitrationLawFees) {
        this.nArbitrationLawFees = nArbitrationLawFees;
    }

    public BigDecimal getNArbitrationPostage() {
        return nArbitrationPostage;
    }

    public void setNArbitrationPostage(BigDecimal nArbitrationPostage) {
        this.nArbitrationPostage = nArbitrationPostage;
    }

    public Date getDCourtTransferDate() {
        return dCourtTransferDate;
    }

    public void setDCourtTransferDate(Date dCourtTransferDate) {
        this.dCourtTransferDate = dCourtTransferDate;
    }

    public BigDecimal getNCourtAmount() {
        return nCourtAmount;
    }

    public void setNCourtAmount(BigDecimal nCourtAmount) {
        this.nCourtAmount = nCourtAmount;
    }

    public BigDecimal getNCourtInt() {
        return nCourtInt;
    }

    public void setNCourtInt(BigDecimal nCourtInt) {
        this.nCourtInt = nCourtInt;
    }

    public String getCAddBy() {
        return cAddBy;
    }

    public void setCAddBy(String cAddBy) {
        this.cAddBy = cAddBy;
    }

    public Date getDAddDate() {
        return dAddDate;
    }

    public void setDAddDate(Date dAddDate) {
        this.dAddDate = dAddDate;
    }

    public String getCEditBy() {
        return cEditBy;
    }

    public void setCEditBy(String cEditBy) {
        this.cEditBy = cEditBy;
    }

    public Date getDEditDate() {
        return dEditDate;
    }

    public void setDEditDate(Date dEditDate) {
        this.dEditDate = dEditDate;
    }

    public Boolean getBEditConfirm() {
        return bEditConfirm;
    }

    public void setBEditConfirm(Boolean bEditConfirm) {
        this.bEditConfirm = bEditConfirm;
    }

    public Date getDConfirmDate() {
        return dConfirmDate;
    }

    public void setDConfirmDate(Date dConfirmDate) {
        this.dConfirmDate = dConfirmDate;
    }

    public String getCConfirmBy() {
        return cConfirmBy;
    }

    public void setCConfirmBy(String cConfirmBy) {
        this.cConfirmBy = cConfirmBy;
    }

    public Boolean getBInAudit() {
        return bInAudit;
    }

    public void setBInAudit(Boolean bInAudit) {
        this.bInAudit = bInAudit;
    }

    public Boolean getBOutAudit() {
        return bOutAudit;
    }

    public void setBOutAudit(Boolean bOutAudit) {
        this.bOutAudit = bOutAudit;
    }

    public Date getDInAuditDate() {
        return dInAuditDate;
    }

    public void setDInAuditDate(Date dInAuditDate) {
        this.dInAuditDate = dInAuditDate;
    }

    public Date getDOutAuditDate() {
        return dOutAuditDate;
    }

    public void setDOutAuditDate(Date dOutAuditDate) {
        this.dOutAuditDate = dOutAuditDate;
    }

    public String getCInAuditBy() {
        return cInAuditBy;
    }

    public void setCInAuditBy(String cInAuditBy) {
        this.cInAuditBy = cInAuditBy;
    }

    public String getCOutAuditBy() {
        return cOutAuditBy;
    }

    public void setCOutAuditBy(String cOutAuditBy) {
        this.cOutAuditBy = cOutAuditBy;
    }

    public Integer getNGurantorDepMFID() {
        return nGurantorDepMFID;
    }

    public void setNGurantorDepMFID(Integer nGurantorDepMFID) {
        this.nGurantorDepMFID = nGurantorDepMFID;
    }

    public String getCPropertyNo() {
        return cPropertyNo;
    }

    public void setCPropertyNo(String cPropertyNo) {
        this.cPropertyNo = cPropertyNo;
    }

    public String getCPropertyName() {
        return cPropertyName;
    }

    public void setCPropertyName(String cPropertyName) {
        this.cPropertyName = cPropertyName;
    }

    public Date getDRegDate() {
        return dRegDate;
    }

    public void setDRegDate(Date dRegDate) {
        this.dRegDate = dRegDate;
    }

    public BigDecimal getNPropertyValue() {
        return nPropertyValue;
    }

    public void setNPropertyValue(BigDecimal nPropertyValue) {
        this.nPropertyValue = nPropertyValue;
    }

    public Date getDPropertyReleaseDate() {
        return dPropertyReleaseDate;
    }

    public void setDPropertyReleaseDate(Date dPropertyReleaseDate) {
        this.dPropertyReleaseDate = dPropertyReleaseDate;
    }

    public short getBGarbage() {
        return bGarbage;
    }

    public void setBGarbage(short bGarbage) {
        this.bGarbage = bGarbage;
    }

    public String getCGarbageBy() {
        return cGarbageBy;
    }

    public void setCGarbageBy(String cGarbageBy) {
        this.cGarbageBy = cGarbageBy;
    }

    public Date getDGarbageDate() {
        return dGarbageDate;
    }

    public void setDGarbageDate(Date dGarbageDate) {
        this.dGarbageDate = dGarbageDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nLonMFID != null ? nLonMFID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BnkLonLoanMaster)) {
            return false;
        }
        BnkLonLoanMaster other = (BnkLonLoanMaster) object;
        if ((this.nLonMFID == null && other.nLonMFID != null) || (this.nLonMFID != null && !this.nLonMFID.equals(other.nLonMFID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.BnkLonLoanMaster[ nLonMFID=" + nLonMFID + " ]";
    }
    
}
