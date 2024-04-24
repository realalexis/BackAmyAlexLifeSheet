package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.springframework.data.repository.core.CrudMethods;

import java.util.List;

public interface MoodService  {
    MoodDto createMood(MoodDto moodDto);
    MoodDto getMoodById(Long moodId);
    List<MoodDto>  getMoodAll();

    MoodDto updateMood(long moodId, MoodDto updateMood);

    List<MoodDto> getMoodByMonth(int moodMonth);


    void deleteMood(Long moodId);
}
