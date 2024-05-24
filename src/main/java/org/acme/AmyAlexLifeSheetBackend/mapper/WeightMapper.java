package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Weight;

public class WeightMapper {

    public static WeightDto mapToWeightDto(Weight weight){
        return new WeightDto(
                weight.getId(),
                weight.getYear(),
                weight.getQuarter(),
                weight.getMonth(),
                weight.getWeek(),
                weight.getDay(),
                weight.getHour(),
                weight.getMinute(),
                weight.getWeight()
        );
    }

    public static Weight mapToWeight(WeightDto weightDto){
        return new Weight(
                weightDto.getId(),
                weightDto.getYear(),
                weightDto.getQuarter(),
                weightDto.getMonth(),
                weightDto.getWeek(),
                weightDto.getDay(),
                weightDto.getHour(),
                weightDto.getMinute(),
                weightDto.getWeight()
        );
    }
}
