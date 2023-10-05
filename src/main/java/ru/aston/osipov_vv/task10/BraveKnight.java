package ru.aston.osipov_vv.task10;

import org.apache.logging.log4j.LogManager;
import ru.aston.osipov_vv.task10.interfaces.Knight;
import ru.aston.osipov_vv.task10.interfaces.Quest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight() {
    }

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void startQuest() {
        LogManager.getLogger().info("Brave knight is ready for a quest!");
        quest.start();
    }

    @PostConstruct
    public void init() {
        LogManager.getLogger().info("Init method for Brave Knight is started!");
    }

//    @PreDestroy
//    public void destroy() {
//        LogManager.getLogger().info("Destroy method for Brave Knight is started!");
//    } -- is never used
}
