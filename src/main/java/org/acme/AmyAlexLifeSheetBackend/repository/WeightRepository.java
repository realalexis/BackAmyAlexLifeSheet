package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.entity.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightRepository extends JpaRepository<Weight, Long> {
    List<Weight> findByYear(int year);
    List<Weight> findByYearAndMonth(Integer year, Integer month);
    List<Weight> findByYearAndMonthAndWeek(Integer year, Integer month, Integer week);
    List<Weight> findByYearAndMonthAndWeekAndDay(Integer year, Integer month, Integer week, Integer day);
}
