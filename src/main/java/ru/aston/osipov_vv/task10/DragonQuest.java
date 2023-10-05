package ru.aston.osipov_vv.task10;

import ru.aston.osipov_vv.task10.interfaces.Quest;

public class DragonQuest implements Quest {
    @Override
    public void start() {
        System.out.println("Starting a dragon quest...");
    }

    public void init() {
        System.out.println("Init method for Dragon Quest started!");
    }

//    public void destroy() {
//        System.out.println("Destroy method for Dragon Quest started!");
//    } -- is never used
}
