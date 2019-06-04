package com.example.druidemo.controller;

import com.example.druidemo.bean.PO.PersonPO;
import com.example.druidemo.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/28 11:28
 * @Description:
 */
@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("getAll001")
    public List<PersonPO> getAll001() {
        List<PersonPO> all001 = personService.getAll001();
        log.info("getAll001 : {}", all001);
        return all001;
    }

    @GetMapping("getByName001/{name}")
    public List<PersonPO> getByName001(@PathVariable("name") String name) {
        List<PersonPO> all001 = personService.getByName001(name);
        log.info("getAll001 : {}", all001);
        return all001;
    }

    @GetMapping("getAll002")
    public List<PersonPO> getAll002() {
        List<PersonPO> all002 = personService.getAll002();
        log.info("getAll002 : {}", all002);
        return all002;
    }
}
