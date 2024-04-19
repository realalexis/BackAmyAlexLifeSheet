package org.acme.AmyAlexLifeSheetBackend.repository;

import org.acme.AmyAlexLifeSheetBackend.entity.Hungry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HungryRepository extends JpaRepository<Hungry, Long> {
}
