package org.acme.AmyAlexLifeSheetBackend.repository;


import org.acme.AmyAlexLifeSheetBackend.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
