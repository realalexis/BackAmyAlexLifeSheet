package org.acme.AmyAlexLifeSheetBackend.mapper;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Mood;

public class MoodMapper {

    public static MoodDto mapToMoodDto(Mood mood){
        return new MoodDto(
                mood.getId(),
                mood.getYear(),
                mood.getQuarter(),
                mood.getMonth(),
                mood.getWeek(),
                mood.getDay(),
                mood.getHour(),
                mood.getMinute(),
                mood.getData()
        );
    }

    public static Mood mapToMood(MoodDto moodDto){
        return new Mood(
                moodDto.getId(),
                moodDto.getYear(),
                moodDto.getQuarter(),
                moodDto.getMonth(),
                moodDto.getWeek(),
                moodDto.getDay(),
                moodDto.getHour(),
                moodDto.getMinute(),
                moodDto.getData()
        );
    }
}
