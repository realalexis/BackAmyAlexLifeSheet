package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;

import java.util.List;

public interface MoodService  {
    MoodDto createMood(MoodDto moodDto);
    MoodDto getMoodById(Long moodId);
    List<MoodDto>  getMoodAll();
    MoodDto updateMood(long moodId, MoodDto updateMood);
    void deleteMood(Long moodId);
    List<MoodDto> getMoodsByParams(Integer year, Integer month, Integer week, Integer day);
}
