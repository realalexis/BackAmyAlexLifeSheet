package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.HobbiesDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Hobbies;

public class HobbiesMapper {

    public static HobbiesDto mapToHobbiesDto(Hobbies hobbies){
        return new HobbiesDto(
                hobbies.getId(),
                hobbies.getYear(),
                hobbies.getQuarter(),
                hobbies.getMonth(),
                hobbies.getWeek(),
                hobbies.getDay(),
                hobbies.getHour(),
                hobbies.getMinute(),
                hobbies.getHobbyType()
        );
    }

    public static Hobbies mapToHobbies(HobbiesDto hobbiesDto){
        return new Hobbies(
                hobbiesDto.getId(),
                hobbiesDto.getYear(),
                hobbiesDto.getQuarter(),
                hobbiesDto.getMonth(),
                hobbiesDto.getWeek(),
                hobbiesDto.getDay(),
                hobbiesDto.getHour(),
                hobbiesDto.getMinute(),
                hobbiesDto.getHobbyType()
        );
    }
}
