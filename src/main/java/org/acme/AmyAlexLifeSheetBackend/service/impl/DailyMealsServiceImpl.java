package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.DailyMealsDto;
import org.acme.AmyAlexLifeSheetBackend.entity.DailyMeals;
import org.acme.AmyAlexLifeSheetBackend.mapper.DailyMealsMapper;
import org.acme.AmyAlexLifeSheetBackend.repository.DailyMealsRepository;
import org.acme.AmyAlexLifeSheetBackend.service.DailyMealsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DailyMealsServiceImpl implements DailyMealsService {
    private DailyMealsRepository dailyMealsRepository;
    @Override
    public List<DailyMealsDto> getDailyMealsByParams(Integer year, Integer month, Integer week, Integer day) {
        List<DailyMeals> dailyMeals;
        //Construire la requête en fonction des paramètres fournis
        if (year != null && month != null && week != null && day != null) {
            // Si toutes les valeurs sont fournies, recherche par jour
            dailyMeals = dailyMealsRepository.findByYearAndMonthAndWeekAndDay(year, month, week, day);
        } else if (year != null && month != null && week != null) {
            // Si year, month et week sont fournis, recherche par semaine
            dailyMeals = dailyMealsRepository.findByYearAndMonthAndWeek(year, month, week);
        } else if (year != null && month != null) {
            // Si year et month sont fournis, recherche par mois
            dailyMeals = dailyMealsRepository.findByYearAndMonth(year, month);
        } else if (year != null) {
            // Si year est fourni, recherche par année
            dailyMeals = dailyMealsRepository.findByYear(year);
        } else {
            // Si aucun paramètre n'est fourni, retourner toutes les données (non filtrées)
            dailyMeals = dailyMealsRepository.findAll();
        }
        return dailyMeals.stream()
                .map(DailyMealsMapper::mapToDailyMealsDto)
                .collect(Collectors.toList());
    }
}
