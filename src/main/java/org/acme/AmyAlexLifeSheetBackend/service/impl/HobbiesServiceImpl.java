package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.HobbiesDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Hobbies;
import org.acme.AmyAlexLifeSheetBackend.mapper.HobbiesMapper;
import org.acme.AmyAlexLifeSheetBackend.repository.HobbiesRepository;
import org.acme.AmyAlexLifeSheetBackend.service.HobbiesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HobbiesServiceImpl implements HobbiesService {
    private HobbiesRepository hobbiesRepository;
    @Override
    public List<HobbiesDto> getHobbiesByParams(Integer year, Integer month, Integer week, Integer day) {
        List<Hobbies> hobbies;
        //Construire la requête en fonction des paramètres fournis
        if (year != null && month != null && week != null && day != null) {
            // Si toutes les valeurs sont fournies, recherche par jour
            hobbies = hobbiesRepository.findByYearAndMonthAndWeekAndDay(year, month, week, day);
        } else if (year != null && month != null && week != null) {
            // Si year, month et week sont fournis, recherche par semaine
            hobbies = hobbiesRepository.findByYearAndMonthAndWeek(year, month, week);
        } else if (year != null && month != null) {
            // Si year et month sont fournis, recherche par mois
            hobbies = hobbiesRepository.findByYearAndMonth(year, month);
        } else if (year != null) {
            // Si year est fourni, recherche par année
            hobbies = hobbiesRepository.findByYear(year);
        } else {
            // Si aucun paramètre n'est fourni, retourner toutes les données (non filtrées)
            hobbies = hobbiesRepository.findAll();
        }
        return hobbies.stream()
                .map(HobbiesMapper::mapToHobbiesDto)
                .collect(Collectors.toList());
    }
}
