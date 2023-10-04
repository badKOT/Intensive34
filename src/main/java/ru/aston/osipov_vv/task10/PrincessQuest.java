package ru.aston.osipov_vv.task10;

import org.apache.logging.log4j.LogManager;
import ru.aston.osipov_vv.task10.interfaces.Quest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrincessQuest implements Quest {
    @Override
    public void start() {
        System.out.println("Starting a princess quest...");
    }

    @PostConstruct
    public void init() {
        LogManager.getLogger().info("Init method for Princess Quest has started!");
    }

    @PreDestroy
    public void destroy() {
        LogManager.getLogger().info("Destroy method for Princess Quest has started!");
    }
}
