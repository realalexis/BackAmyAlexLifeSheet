package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;

import java.util.List;

public interface SportService {
    List<SportDto> getSportByParams(Integer year, Integer month, Integer week, Integer day);
}
