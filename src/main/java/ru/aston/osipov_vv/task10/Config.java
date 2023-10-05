package ru.aston.osipov_vv.task10;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.aston.osipov_vv.task10.interfaces.Knight;
import ru.aston.osipov_vv.task10.interfaces.Quest;

@Configuration
public class Config {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Knight getKnight() {
        return new BraveKnight(getPrincessQuest());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Quest getPrincessQuest() {
        return new PrincessQuest();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Quest getKingdomQuest() {
        return new KingdomQuest();
    }

//    @Bean
//    public Quest getPrincessQuest() {
//        return new PrincessQuest();
//    }
}
