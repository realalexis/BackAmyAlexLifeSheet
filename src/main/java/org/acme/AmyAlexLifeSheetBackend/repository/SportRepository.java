package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Long> {
    List<Sport> findByYear(int year);
    List<Sport> findByYearAndMonth(Integer year, Integer month);
    List<Sport> findByYearAndMonthAndWeek(Integer year, Integer month, Integer week);
    List<Sport> findByYearAndMonthAndWeekAndDay(Integer year, Integer month, Integer week, Integer day);
}
