package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoodRepository extends JpaRepository<Mood, Long> {
    List<Mood> findByYear(int year);
    List<Mood> findByYearAndMonth(Integer year, Integer month);
    List<Mood> findByYearAndMonthAndWeek(Integer year, Integer month, Integer week);
    List<Mood> findByYearAndMonthAndWeekAndDay(Integer year, Integer month, Integer week, Integer day);
}
