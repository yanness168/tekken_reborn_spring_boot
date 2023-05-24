package com.cpan228.tekkenrebirn.config;

import com.cpan228.tekkenrebirn.model.Fighter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cpan228.tekkenrebirn.model.HeroPool;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public HeroPool heroPool() {
        List<Fighter> fighters = new ArrayList<>();
        fighters.add(new Fighter("Fighter1", 1250, 50, 5.0));
        fighters.add(new Fighter("Fighter2", 1002, 60, 6.5));

        return new HeroPool(fighters);
    }
}
