package ru.aston.osipov_vv.task10;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.aston.osipov_vv.task10.interfaces.Knight;
import ru.aston.osipov_vv.task10.interfaces.Quest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log4j2
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight() {
    }

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void startQuest() {
        log.info("Brave knight is ready for a quest!");
        quest.start();
    }

    @PostConstruct
    public void init() {
        log.info("Init method for Brave Knight is started!");
    }

//    @PreDestroy
//    public void destroy() {
//        log.info("Destroy method for Brave Knight is started!");
//    } -- is never used
}
