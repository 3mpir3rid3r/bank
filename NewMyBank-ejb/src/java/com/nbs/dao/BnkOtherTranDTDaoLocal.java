/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkOtherTranDT;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkOtherTranDTDaoLocal {

    void saveBnkOtherTranTD(List<BnkOtherTranDT> list, Long NOthTrnDTID);

}
