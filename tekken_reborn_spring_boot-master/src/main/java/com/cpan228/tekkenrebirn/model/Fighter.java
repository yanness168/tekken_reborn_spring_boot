package com.cpan228.tekkenrebirn.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;

@Table("FIGHTERS")
@Data
public class Fighter {
    @Id
    private Integer id;

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
    private BigDecimal resistance;

    private Anime animeFrom;

    @CreatedDate
    private Date createdAt = new Date();

    public Fighter(String name, Integer health, Integer damage, BigDecimal resistance, Anime animeFrom) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.resistance = resistance;
        this.animeFrom = animeFrom;
    }

    public Fighter() {
    }

    public Integer getId() {
        return id;
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

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public BigDecimal getResistance() {
        return resistance;
    }

    public void setResistance(BigDecimal resistance) {
        this.resistance = resistance;
    }
    public enum Anime {
        NARUTO("Naruto"),
        BLEACH("Bleach"),
        ONE_PIECE("One Piece"),
        TEKKEN("Tekken");

        private String title;

        private Anime(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public Anime getAnimeFrom() {
        return animeFrom;
    }

    public void setAnimeFrom(Anime animeFrom) {
        this.animeFrom = animeFrom;
    }

}


