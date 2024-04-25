package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Sport;

public class SportMapper {

    public static SportDto mapToSportDto(Sport sport){
        return new SportDto(
                sport.getId(),
                sport.getMinute(),
                sport.getHour(),
                sport.getWeek(),
                sport.getDay(),
                sport.getMonth(),
                sport.getQuarter(),
                sport.getYear_week(),
                sport.getYear_month(),
                sport.getYear(),
                sport.getCommand(),
                sport.getReason()

        );
    }

    public static Sport mapToSport(SportDto sportDto){
        return new Sport(
                sportDto.getId(),
                sportDto.getMinute(),
                sportDto.getHour(),
                sportDto.getWeek(),
                sportDto.getDay(),
                sportDto.getMonth(),
                sportDto.getQuarter(),
                sportDto.getYear_week(),
                sportDto.getYear_month(),
                sportDto.getYear(),
                sportDto.getCommand(),
                sportDto.getReason()

        );
    }


}