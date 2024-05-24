package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.entity.DailyMeals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyMealsRepository extends JpaRepository<DailyMeals, Long> {
    List<DailyMeals> findByYear(int year);
    List<DailyMeals> findByYearAndMonth(Integer year, Integer month);
    List<DailyMeals> findByYearAndMonthAndWeek(Integer year, Integer month, Integer week);
    List<DailyMeals> findByYearAndMonthAndWeekAndDay(Integer year, Integer month, Integer week, Integer day);
}
