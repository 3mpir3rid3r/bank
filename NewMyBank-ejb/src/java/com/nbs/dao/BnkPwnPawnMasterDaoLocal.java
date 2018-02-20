/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkPwnPawnReason;
import com.nbs.model.BnkPwnPawnTypes;
import com.nbs.model.BnkPwnRefArticls;
import com.nbs.model.BnkPwnRefCarateValues;
import com.nbs.model.BnkRefBankBranch;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.NoResultException;

/**
 *
 * @author lasa
 */
@Local
public interface BnkPwnPawnMasterDaoLocal {

    List<BnkPwnPawnTypes> getBnkPwnPawnTypes();

    List<BnkRefBankBranch> getBnkBranch();

    List<BnkPwnRefCarateValues> getBnkPwnRefCarateValues();

    List<BnkPwnRefArticls> getBnkPwnRefArticls();

    void saveBnkPwnPawnMaster(BnkPwnPawnMaster bnkPwnPawnMaster);

    boolean saveBankPwnRefArticls(BnkPwnRefArticls bnkPwnRefArticls);

    void updateBnkPwnPawnMaster(BnkPwnPawnMaster bnkPwnPawnMaster);

    BnkPwnPawnMaster getBnkPwnPawnMasterByNic(String cNicNo);

    int saveBnkPwnPawnMasterSP(BnkPwnPawnMaster bnkPwnPawnMaster);

    BnkPwnPawnMaster getBnkPwnPawnMasterBycReceiptNo(String cReceiptNo);

    List<BnkPwnPawnMaster> getBnkPwnPawnMasterList(String key, int branchId, int status);

    List<BnkPwnPawnMaster> getBnkPwnPawnMasterList(int branchId, int status, int typeId, String fromDate, String toDate);

    List<BnkPwnPawnMaster> getPwnDataUsingName(String fullName);

    List<BnkPwnPawnMaster> getPwnDataUsingNic(String nicNo);

    List<BnkPwnPawnReason> getallPwnReasons();

    boolean savePwnReason(BnkPwnPawnReason reason);

    boolean saveRePwn(BnkPwnPawnMaster bppm, double paymentValue) throws SQLException, NullPointerException, NoResultException;

    public int getId(String typeId);

}
