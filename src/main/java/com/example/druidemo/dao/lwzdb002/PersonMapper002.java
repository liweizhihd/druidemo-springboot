package com.example.druidemo.dao.lwzdb002;

import com.example.druidemo.bean.PO.PersonPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: liweizhi
 * @Date: 2018/10/22 09:55
 * @Description:
 */
@Mapper
@Repository
public interface PersonMapper002 {

    List<PersonPO> getAll();

}
