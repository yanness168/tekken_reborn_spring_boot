package com.cpan228.tekkenrebirn.model;

import jakarta.validation.constraints.*;

public class Fighter {
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Health is required")
    @Min(value = 1001, message = "Health must be more than 1000")
    private Integer health;

    @NotNull(message = "Damage is required")
    @Max(value = 99, message = "Damage must be less than 100")
    private Integer damage;

    @NotNull(message = "Resistance is required")
    @DecimalMin(value = "0", message = "Resistance must be at least 0")
    @DecimalMax(value = "10", message = "Resistance must be at most 10")
    private Double resistance;

    public Fighter(String name, Integer health, Integer damage, Double resistance) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.resistance = resistance;
    }

    public Fighter (){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }
}

