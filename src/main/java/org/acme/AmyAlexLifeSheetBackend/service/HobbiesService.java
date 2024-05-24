package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.HobbiesDto;

import java.util.List;

public interface HobbiesService {
    List<HobbiesDto> getHobbiesByParams(Integer year, Integer month, Integer week, Integer day);
}
