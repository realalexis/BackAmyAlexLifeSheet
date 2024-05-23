package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Sport;
import org.acme.AmyAlexLifeSheetBackend.exception.ResourceNotFound;
import org.acme.AmyAlexLifeSheetBackend.mapper.SportMapper;
import org.acme.AmyAlexLifeSheetBackend.repository.SportRepository;
import org.acme.AmyAlexLifeSheetBackend.service.SportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SportServiceImpl implements SportService {
    private SportRepository sportRepository;
    @Override
    public SportDto createSport(SportDto sportDto) {
        Sport sport = SportMapper.mapToSport(sportDto);
        Sport savedSport = sportRepository.save(sport);
        return SportMapper.mapToSportDto(savedSport);
    }

    @Override
    public SportDto getSportById(Long sportId) {
        Sport sport = sportRepository.findById(sportId)
                .orElseThrow(() -> new ResourceNotFound("Sport does not exist with given id : " + sportId));
        return SportMapper.mapToSportDto(sport);
    }

    @Override
    public List<SportDto> getSportAll() {
        List<Sport> sport =  sportRepository.findAll();
        return sport.stream().map(SportMapper::mapToSportDto)
                .collect(Collectors.toList());
    }

    @Override
    public SportDto updateSport(long sportId, SportDto updateSport) {
        return null;
    }

    @Override
    public void deleteSport(Long sportId) {
            Sport sport = sportRepository.findById(sportId).orElseThrow(
                    () -> new ResourceNotFound("Sport does not exists with given id: " + sportId)
            );

            sportRepository.deleteById(sportId);
        }

    @Override
    public List<SportDto> getSportsByParams(Integer year, Integer month, Integer week, Integer day) {
        List<Sport> sports;
        //Construire la requête en fonction des paramètres fournis
        if (year != null && month != null && week != null && day != null) {
            // Si toutes les valeurs sont fournies, recherche par jour
            sports = sportRepository.findByYearAndMonthAndWeekAndDay(year, month, week, day);
        } else if (year != null && month != null && week != null) {
            // Si year, month et week sont fournis, recherche par semaine
            sports = sportRepository.findByYearAndMonthAndWeek(year, month, week);
        } else if (year != null && month != null) {
            // Si year et month sont fournis, recherche par mois
            sports = sportRepository.findByYearAndMonth(year, month);
        } else if (year != null) {
            // Si year est fourni, recherche par année
            sports = sportRepository.findByYear(year);
        } else {
            // Si aucun paramètre n'est fourni, retourner toutes les données (non filtrées)
            sports = sportRepository.findAll();
        }
        return sports.stream()
                .map(SportMapper::mapToSportDto)
                .collect(Collectors.toList());
    }
}
