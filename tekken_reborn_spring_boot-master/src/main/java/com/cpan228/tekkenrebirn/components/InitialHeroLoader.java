package com.cpan228.tekkenrebirn.components;

import com.cpan228.tekkenrebirn.model.Fighter;
import com.cpan228.tekkenrebirn.model.HeroPool;
import com.cpan228.tekkenrebirn.model.Fighter.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class InitialHeroLoader implements CommandLineRunner {

    private final HeroPool hp;

    @Autowired
    public InitialHeroLoader(HeroPool hp) {
        this.hp = hp;
    }

    @Override
    public void run(String... args) {
        List<Fighter> initialFighters = Arrays.asList(
                new Fighter("Fighter 1", 1221, 23, new BigDecimal("3.2"), Anime.NARUTO),
                new Fighter("Fighter 2", 1500, 39, new BigDecimal("5.5"), Anime.BLEACH),
                new Fighter("Fighter 3", 6660, 20, new BigDecimal("2.7"), Anime.ONE_PIECE)
        );

        initialFighters.forEach(hp::saveFighter);
    }
}

