package ru.aston.osipov_vv.task10;

import org.apache.logging.log4j.LogManager;
import ru.aston.osipov_vv.task10.interfaces.Knight;
import ru.aston.osipov_vv.task10.interfaces.Quest;

public class CharmingKnight implements Knight {

    private int age;
    private Quest quest;

    public CharmingKnight() {
    }

    public CharmingKnight(int age) {
        this.age = age;
    }

    public CharmingKnight(Quest quest) {
        this.quest = quest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
        LogManager.getLogger().info("Init method for Charming Prince started!");
    }

    public void destroy() {
        LogManager.getLogger().info("Destroy method for Charming Prince started!");
    }
}
