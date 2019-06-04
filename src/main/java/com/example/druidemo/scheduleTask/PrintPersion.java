package com.example.druidemo.scheduleTask;

import com.example.druidemo.bean.PO.PersonPO;
import com.example.druidemo.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/28 20:54
 * @Description:
 */
@Async
@Component
@Slf4j
public class PrintPersion {

    @Autowired
    private IPersonService personService;

    @Async
    @Scheduled(cron = "0 0/5 * * * ?")
    @Transactional()
    public void taskGetAll001() {
        List<PersonPO> all001 = personService.getAll001();
        log.info("taskGetAll001:{}", all001);
    }

    @PostConstruct
    public void init() {
        log.info("...PrintPersion task init...\n {}",personService.getAll001());
    }
}
