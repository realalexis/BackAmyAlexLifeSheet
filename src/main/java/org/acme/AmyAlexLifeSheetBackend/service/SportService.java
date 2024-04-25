package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;

import java.util.List;

public interface SportService {
    SportDto createSport(SportDto sportDto);
    SportDto getSportById(Long sportId);
    List<SportDto>  getSportAll();
    SportDto updateSport(long sportId, SportDto updateSport);
    List<SportDto> getSportByYear(int sportYear);
    void deleteSport(Long sportId);
}
