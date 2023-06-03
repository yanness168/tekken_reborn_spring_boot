package com.cpan228.tekkenrebirn.controllers;

import com.cpan228.tekkenrebirn.model.Fighter;
import com.cpan228.tekkenrebirn.model.HeroPool;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.logging.Logger;


@Controller
public class DesignController {
    private final HeroPool hp;

    @Autowired
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
//        if (bindingResult.hasErrors()) {
//            return "add_fighter";
//        }

        // Perform additional validations
        if (fighter.getHealth() <= 1000) {
            bindingResult.rejectValue("health", "error.fighter", "Health must be more than 1000");
            return "add_fighter";
        }

        if (fighter.getDamage() >= 100) {
            bindingResult.rejectValue("damage", "error.fighter", "Damage must be less than 100");
            return "add_fighter";
        }

        if (fighter.getResistance().compareTo(BigDecimal.ZERO) < 0 || fighter.getResistance().compareTo(BigDecimal.TEN) > 0) {
            bindingResult.rejectValue("resistance", "error.fighter", "Resistance must be between 0 and 10");
            return "add_fighter";
        }


        System.out.println("Submitted fighter: " + fighter);
        // Add the fighter to the hero pool
        var id = hp.saveFighter(fighter);
        System.out.println("Saved fighter: " + id);
        return "redirect:/hero_pool";
    }

    @GetMapping("/hero_pool")
    public String showHeroPool(Model model) {
        Iterable<Fighter> fighters = hp.getFighters();
        model.addAttribute("fighters", fighters);
        return "hero_pool";
    }
}
