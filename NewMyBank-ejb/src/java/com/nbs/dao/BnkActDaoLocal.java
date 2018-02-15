/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.ActChartOfAcctL1;
import com.nbs.model.ActChartOfAcctL2;
import com.nbs.model.ActChartOfAcctL3;
import com.nbs.model.ActChartOfAcctL4;
import com.nbs.model.ActChartOfAcctL5;
import com.nbs.model.BnkPwnPawnTypes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkActDaoLocal {

    List<ActChartOfAcctL1> getAct1();

    List<ActChartOfAcctL2> getAct2();

    List<ActChartOfAcctL3> getAct3();

    List<ActChartOfAcctL4> getAct4();

    List<ActChartOfAcctL5> getAct5();

    List<ActChartOfAcctL5> getAct5SearchingData(String searchTip);

    ActChartOfAcctL5 getAct5Data(int id);

    List<ActChartOfAcctL4> getAct4View(String key);

    void saveACT2(ActChartOfAcctL2 act2);

    void saveACT3(ActChartOfAcctL3 act3);

    void saveACT4(ActChartOfAcctL4 act4);

    void saveACT5(ActChartOfAcctL5 act5);

    void updateACT2(ActChartOfAcctL2 act2);

    void updateACT3(ActChartOfAcctL3 act3);

    void updateACT4(ActChartOfAcctL4 act4);

    void updateACT5(ActChartOfAcctL5 act5);

    boolean savePawnType(BnkPwnPawnTypes bnkPwnPawnTypes);

}
