package com.cpan228.tekkenrebirn.repository;

import com.cpan228.tekkenrebirn.model.Fighter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FighterRepository extends CrudRepository<Fighter, Integer> {
    List<Fighter> findByNameStartsWithAndCreatedAtBetween(String name, Date startDate, Date endDate);
}

