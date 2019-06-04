package com.example.druidemo.service;

import com.example.druidemo.bean.PO.PersonPO;

import java.util.List;

/**
 * @Auther: liweizhi
 * @Date: 2018/10/22 09:59
 * @Description:
 */
public interface IPersonService {

    List<PersonPO> getAll001();
    List<PersonPO> getByName001(String name);
    List<PersonPO> getAll002();

}
