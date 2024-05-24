package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.acme.AmyAlexLifeSheetBackend.exception.ResourceNotFound;
import org.acme.AmyAlexLifeSheetBackend.mapper.MoodMapper;
import org.acme.AmyAlexLifeSheetBackend.repository.MoodRepository;
import org.acme.AmyAlexLifeSheetBackend.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MoodServiceImpl implements MoodService {
    private MoodRepository moodRepository;
    @Override
    public List<MoodDto> getMoodsByParams(Integer year, Integer month, Integer week, Integer day) {
        List<Mood> moods;
        //Construire la requête en fonction des paramètres fournis
        if (year != null && month != null && week != null && day != null) {
            // Si toutes les valeurs sont fournies, recherche par jour
            moods = moodRepository.findByYearAndMonthAndWeekAndDay(year, month, week, day);
        } else if (year != null && month != null && week != null) {
            // Si year, month et week sont fournis, recherche par semaine
            moods = moodRepository.findByYearAndMonthAndWeek(year, month, week);
        } else if (year != null && month != null) {
            // Si year et month sont fournis, recherche par mois
            moods = moodRepository.findByYearAndMonth(year, month);
        } else if (year != null) {
            // Si year est fourni, recherche par année
            moods = moodRepository.findByYear(year);
        } else {
            // Si aucun paramètre n'est fourni, retourner toutes les données (non filtrées)
            moods = moodRepository.findAll();
        }
        return moods.stream()
                .map(MoodMapper::mapToMoodDto)
                .collect(Collectors.toList());
    }
}
