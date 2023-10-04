package ru.aston.osipov_vv.task10;

import ru.aston.osipov_vv.task10.interfaces.Quest;

public class KingdomQuest implements Quest {
    @Override
    public void start() {
        System.out.println("The quest to invade another kingdom is starting...");
    }
}
