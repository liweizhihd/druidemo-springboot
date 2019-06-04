package com.example.druidemo.bean.PO;

import lombok.Data;

/**
 * @Auther: liweizhi
 * @Date: 2018/10/22 09:56
 * @Description:
 */
@Data
public class PersonPO {

    private String id;
    private String name;
    private int age;

    public PersonPO() {
        super();
    }

    public PersonPO(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}
