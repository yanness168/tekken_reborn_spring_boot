package com.cpan228.tekkenrebirn.controllers;

import org.springframework.ui.Model;
import com.cpan228.tekkenrebirn.model.Fighter;
import com.cpan228.tekkenrebirn.model.HeroPool;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DesignController {
    private final HeroPool hp;

    public DesignController(HeroPool hp) {
        this.hp = hp;
    }

    @GetMapping("/add_fighter")
    public String showFighterForm(Model model) {
        model.addAttribute("fighter", new Fighter());
        return "add_fighter";
    }

    @PostMapping("/add_fighter")
    public String processFighterForm(@Valid @ModelAttribute("fighter") Fighter fighter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_fighter";
        }

        // Perform additional validations
        if (fighter.getHealth() <= 1000) {
            bindingResult.rejectValue("health", "error.fighter", "Health must be more than 1000");
            return "add_fighter";
        }

        if (fighter.getDamage() >= 100) {
            bindingResult.rejectValue("damage", "error.fighter", "Damage must be less than 100");
            return "add_fighter";
        }

        if (fighter.getResistance() < 0 || fighter.getResistance() > 10) {
            bindingResult.rejectValue("resistance", "error.fighter", "Resistance must be between 0 and 10");
            return "add_fighter";
        }

        // Add the fighter to the hero pool
        hp.addFighter(fighter);

        return "redirect:/hero_pool";
    }

    @GetMapping("/hero_pool")
    public String showHeroPool(Model model) {
        List<Fighter> fighters = hp.getFighters();
        model.addAttribute("fighters", fighters);
        return "hero_pool";
    }
}
