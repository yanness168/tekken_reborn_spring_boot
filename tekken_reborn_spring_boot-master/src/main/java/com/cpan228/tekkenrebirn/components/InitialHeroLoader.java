package com.cpan228.tekkenrebirn.components;

import com.cpan228.tekkenrebirn.model.Fighter;
import com.cpan228.tekkenrebirn.services.HeroPool;
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
                new Fighter("Mike B", 1221, 23, new BigDecimal("3.2"), Anime.NARUTO),
                new Fighter("Petro A", 1500, 39, new BigDecimal("5.5"), Anime.BLEACH),
                new Fighter("Ellie Car", 6660, 20, new BigDecimal("2.7"), Anime.ONE_PIECE),
                new Fighter("Jeffrey Sun", 6320, 30, new BigDecimal("3.27"), Anime.BLEACH),
                new Fighter("Mario Haha", 2360, 21, new BigDecimal("1.44"), Anime.ONE_PIECE),
                new Fighter("Luigi Green", 4312, 33, new BigDecimal("6.7"), Anime.NARUTO),
                new Fighter("Peach Pink", 3350, 20, new BigDecimal("1.21"), Anime.ONE_PIECE),
                new Fighter("Kwan Lam", 8941, 20, new BigDecimal("6.7"), Anime.NARUTO),
                new Fighter("Eric Chou", 9999, 20, new BigDecimal("2.7"), Anime.ONE_PIECE),
                new Fighter("Gem Tang", 7673, 32, new BigDecimal("8.37"), Anime.ONE_PIECE),
                new Fighter("Jiwon Jeong", 6160, 20, new BigDecimal("5.27"), Anime.BLEACH)
        );

        initialFighters.forEach(hp::saveFighter);
    }
}

