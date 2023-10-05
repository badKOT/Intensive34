package ru.aston.osipov_vv.task10;

import lombok.extern.log4j.Log4j2;
import ru.aston.osipov_vv.task10.interfaces.Quest;

@Log4j2
public class DragonQuest implements Quest {
    @Override
    public void start() {
        log.info("Starting a dragon quest...");
    }

    public void init() {
        log.info("Init method for Dragon Quest started!");
    }

//    public void destroy() {
//        log.info("Destroy method for Dragon Quest started!");
//    } -- is never used
}
