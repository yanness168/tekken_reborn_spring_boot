package com.cpan228.tekkenrebirn.model;

import com.cpan228.tekkenrebirn.repository.FighterRepository;
import org.springframework.stereotype.Service;

@Service
public class HeroPool {
    private final FighterRepository fighterRepository;

    public HeroPool(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public Iterable<Fighter> getFighters() {
        return fighterRepository.findAll();
    }

    public Fighter getFighter(Integer id) {
        return fighterRepository.findById(id).orElse(null);
    }

    public Fighter saveFighter(Fighter f) {
        fighterRepository.save(f);
        return f;
    }
}
