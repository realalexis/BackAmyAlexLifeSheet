package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.DailyMealsDto;

import java.util.List;

public interface DailyMealsService {
    List<DailyMealsDto> getDailyMealsByParams(Integer year, Integer month, Integer week, Integer day);
}
