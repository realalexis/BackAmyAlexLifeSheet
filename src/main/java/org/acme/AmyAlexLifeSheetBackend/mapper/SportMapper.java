package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Sport;

public class SportMapper {

    public static SportDto mapToSportDto(Sport sport){
        return new SportDto(
                sport.getId(),
                sport.getYear(),
                sport.getQuarter(),
                sport.getMonth(),
                sport.getWeek(),
                sport.getDay(),
                sport.getHour(),
                sport.getMinute(),
                sport.getSession()
        );
    }

    public static Sport mapToSport(SportDto sportDto){
        return new Sport(
                sportDto.getId(),
                sportDto.getYear(),
                sportDto.getQuarter(),
                sportDto.getMonth(),
                sportDto.getWeek(),
                sportDto.getDay(),
                sportDto.getHour(),
                sportDto.getMinute(),
                sportDto.getSession()
        );
    }
}
