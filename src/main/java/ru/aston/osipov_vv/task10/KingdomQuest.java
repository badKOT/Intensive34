package ru.aston.osipov_vv.task10;

import lombok.extern.log4j.Log4j2;
import ru.aston.osipov_vv.task10.interfaces.Quest;

@Log4j2
public class KingdomQuest implements Quest {
    @Override
    public void start() {
        log.info("The quest to invade another kingdom is starting...");
    }
}
