package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.DailyMealsDto;
import org.acme.AmyAlexLifeSheetBackend.entity.DailyMeals;

public class DailyMealsMapper {

    public static DailyMealsDto mapToDailyMealsDto(DailyMeals dailyMeals){
        return new DailyMealsDto(
                dailyMeals.getId(),
                dailyMeals.getYear(),
                dailyMeals.getQuarter(),
                dailyMeals.getMonth(),
                dailyMeals.getWeek(),
                dailyMeals.getDay(),
                dailyMeals.getHour(),
                dailyMeals.getMinute(),
                dailyMeals.getData()
        );
    }

    public static DailyMeals mapToDailyMeals(DailyMealsDto dailyMealsDto){
        return new DailyMeals(
                dailyMealsDto.getId(),
                dailyMealsDto.getYear(),
                dailyMealsDto.getQuarter(),
                dailyMealsDto.getMonth(),
                dailyMealsDto.getWeek(),
                dailyMealsDto.getDay(),
                dailyMealsDto.getHour(),
                dailyMealsDto.getMinute(),
                dailyMealsDto.getData()
        );
    }
}
