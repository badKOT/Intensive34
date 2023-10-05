package ru.aston.osipov_vv.task10;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.aston.osipov_vv.task10.interfaces.Knight;
import ru.aston.osipov_vv.task10.interfaces.Quest;

@Log4j2
public class CharmingKnight implements Knight {

    @Autowired
    @Qualifier("dragonQuestQualifier")
    private Quest quest;

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void startQuest() {
        LogManager.getLogger().info("The Charming Knight is ready to start a quest!");
        quest.start();
    }

    public void init() {
        log.info("Init method for Charming Prince started!");
    }

    public void destroy() {
        log.info("Destroy method for Charming Prince started!");
    }
}
