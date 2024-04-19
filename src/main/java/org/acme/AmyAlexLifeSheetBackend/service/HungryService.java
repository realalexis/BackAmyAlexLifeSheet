package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.HungryDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Hungry;
import org.acme.AmyAlexLifeSheetBackend.exception.ResourceNotFound;

import java.util.List;

public interface HungryService {
    HungryDto createHungry(HungryDto hungryDto);
    HungryDto getHungryById(Long hungryId);
    List<HungryDto>  getHungryAll();

    HungryDto updateHungry(long hungryId, HungryDto updateHungry);

    void deleteHungry(Long hungryId);
}
