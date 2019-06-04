package com.example.druidemo.service.impl;

import com.example.druidemo.bean.PO.PersonPO;
import com.example.druidemo.dao.lwzdb001.PersonMapper;
import com.example.druidemo.dao.lwzdb002.PersonMapper002;
import com.example.druidemo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: liweizhi
 * @Date: 2018/10/22 09:59
 * @Description:
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper001;
    @Autowired
    private PersonMapper002 personMapper002;

    @Override
    public List<PersonPO> getAll001() {
        return personMapper001.getAll();
    }

    @Override
    public List<PersonPO> getByName001(String name) {
        Map<String, Object> param = new HashMap<>(2);
        param.put("name", name);
        return personMapper001.getAllByCond(param);
    }

    @Override
    public List<PersonPO> getAll002() {
        return personMapper002.getAll();
    }
}
