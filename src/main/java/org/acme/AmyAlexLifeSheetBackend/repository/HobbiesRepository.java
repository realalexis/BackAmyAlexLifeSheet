package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.entity.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HobbiesRepository extends JpaRepository<Hobbies, Long> {
    List<Hobbies> findByYear(int year);
    List<Hobbies> findByYearAndMonth(Integer year, Integer month);
    List<Hobbies> findByYearAndMonthAndWeek(Integer year, Integer month, Integer week);
    List<Hobbies> findByYearAndMonthAndWeekAndDay(Integer year, Integer month, Integer week, Integer day);
}
