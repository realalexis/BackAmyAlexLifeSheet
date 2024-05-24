package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;

import java.util.List;

public interface WeightService {
    List<WeightDto> getWeightByParams(Integer year, Integer month, Integer week, Integer day);
}
