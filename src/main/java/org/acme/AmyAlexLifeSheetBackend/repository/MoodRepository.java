package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<Mood, Long> {
}
