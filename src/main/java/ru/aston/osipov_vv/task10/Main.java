package ru.aston.osipov_vv.task10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.aston.osipov_vv.task10.interfaces.Knight;

public class Main {

//    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        FileSystemXmlApplicationContext xmlContext =
                new FileSystemXmlApplicationContext("classpath*:spring/SpringConfig.xml");
        Knight knight = context.getBean(Knight.class);
        knight.startQuest();

        CharmingKnight charmingKnight = xmlContext.getBean(CharmingKnight.class);
        charmingKnight.startQuest();

//        Quest quest = context.getBean(Quest.class);

        xmlContext.close();
        context.close();
    }
}
//logger.info("This is info log");