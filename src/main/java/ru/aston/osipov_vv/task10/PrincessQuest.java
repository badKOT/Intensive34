package ru.aston.osipov_vv.task10;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.aston.osipov_vv.task10.interfaces.Quest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log4j2
public class PrincessQuest implements Quest {

    @Override
    public void start() {
        log.info("Starting a princess quest...");
    }

    @PostConstruct
    public void init() {
        log.info("Init method for Princess Quest has started!");
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroy method for Princess Quest has started!");
    }
}
