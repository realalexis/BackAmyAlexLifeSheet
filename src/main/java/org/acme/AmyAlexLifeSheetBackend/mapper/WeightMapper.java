package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Weight;

public class WeightMapper {

    public static WeightDto mapToWeightDto(Weight weight){
        return new WeightDto(
                weight.getId(),
                weight.getDay(),
                weight.getMonth(),
                weight.getYear(),
                weight.getWeight()
        );
    }

    public static Weight mapToWeight(WeightDto weightDto){
        return new Weight(
                weightDto.getId(),
                weightDto.getDay(),
                weightDto.getMonth(),
                weightDto.getYear(),
                weightDto.getWeight()
        );
    }
}
