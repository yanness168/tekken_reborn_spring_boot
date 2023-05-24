package com.cpan228.tekkenrebirn.model;
import java.util.List;

public class HeroPool {
    private List<Fighter> fighters;

    public HeroPool(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public void addFighter(Fighter fighter) {
        this.fighters.add(fighter);
    }
}
