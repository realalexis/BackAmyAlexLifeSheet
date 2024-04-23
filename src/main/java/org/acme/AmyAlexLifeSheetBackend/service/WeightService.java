package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;

import java.util.List;

public interface WeightService {
    WeightDto createWeight(WeightDto weightDto);
    WeightDto getWeightById(Long weightId);
    List<WeightDto>  getWeightAll();

    WeightDto updateWeight(long weightId, WeightDto updateWeight);

    void deleteWeight(Long weightId);
}
