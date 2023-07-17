package com.cpan228.tekkenrebirn.model;

import com.cpan228.tekkenrebirn.repository.FighterPagRepository;
import com.cpan228.tekkenrebirn.repository.FighterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class HeroPool {
    private final FighterRepository fighterRepository;
    private final FighterPagRepository fighterPagRepository;

    public HeroPool(FighterRepository fighterRepository, FighterPagRepository fighterPagRepository) {
        this.fighterRepository = fighterRepository;
        this.fighterPagRepository = fighterPagRepository;
    }

    public Page<Fighter> getFighters(Pageable pageable) {
        return fighterPagRepository.findAll(pageable);
    }

    public Fighter saveFighter(Fighter f) {
        return fighterRepository.save(f);
    }

    public List<Fighter> getPaginatedFighters(int currentPage) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Fighter> fighterPage = fighterPagRepository.findAll(pageable);
        return fighterPage.getContent();
    }

    public  List<Fighter> getFighterByNameStartsWithAndCreatedAtBetween (String name, Date startDate, Date endDate) {
        return fighterRepository.findByNameStartsWithAndCreatedAtBetween(name, startDate, endDate);
    }
    public Page<Fighter> getFilteredFighterPage(List<Fighter> filteredFighters, int page, int pageSize) {
        var startIdx = page * pageSize;
        var endIdx = Math.min(startIdx + pageSize, filteredFighters.size());
        var subList = filteredFighters.subList(startIdx, endIdx);
        return new PageImpl<>(subList, PageRequest.of(page, pageSize), filteredFighters.size());
    }

    public void deleteFighter(Integer id) {
        fighterRepository.deleteById(id);
    }

    public Fighter getFighterById(Integer id) {
        return fighterRepository.findById(id).orElse(null);
    }
}
