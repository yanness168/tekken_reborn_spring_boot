package com.cpan228.tekkenrebirn.repository;

import com.cpan228.tekkenrebirn.model.Fighter;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface FighterPagRepository extends PagingAndSortingRepository<Fighter, Integer> {
}
