package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.HungryDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Hungry;

public class HungryMapper {

    public static HungryDto mapToHungryDto(Hungry hungry){
        return new HungryDto(
                hungry.getId(),
                hungry.getDay(),
                hungry.getMonth(),
                hungry.getKey()
        );
    }

    public static Hungry mapToHungry(HungryDto hungryDto){
        return new Hungry(
                hungryDto.getId(),
                hungryDto.getDay(),
                hungryDto.getMonth(),
                hungryDto.getKey()
        );
    }
}
