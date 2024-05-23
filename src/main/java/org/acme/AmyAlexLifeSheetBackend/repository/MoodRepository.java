package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoodRepository extends JpaRepository<Mood, Long> {
    List<Mood> findByYear(int year);
    List<Mood> findByYearMonth(int moodYearMonth);
}
