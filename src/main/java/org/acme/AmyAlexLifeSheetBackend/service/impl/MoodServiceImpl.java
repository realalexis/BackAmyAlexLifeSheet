package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.acme.AmyAlexLifeSheetBackend.exception.ResourceNotFound;
import org.acme.AmyAlexLifeSheetBackend.mapper.MoodMapper;
import org.acme.AmyAlexLifeSheetBackend.repository.MoodRepository;
import org.acme.AmyAlexLifeSheetBackend.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MoodServiceImpl implements MoodService {
    private MoodRepository moodRepository;
    @Override
    public List<MoodDto> getMoodsByParams(Integer year, Integer month, Integer week, Integer day) {
        List<Mood> moods;
        //request built around provided params
        if (year != null && month != null && week != null && day != null) {
            // all values provided, filter by day
            moods = moodRepository.findByYearAndMonthAndWeekAndDay(year, month, week, day);
        } else if (year != null && month != null && week != null) {
            // filter by week
            moods = moodRepository.findByYearAndMonthAndWeek(year, month, week);
        } else if (year != null && month != null) {
            // filter by month
            moods = moodRepository.findByYearAndMonth(year, month);
        } else if (year != null) {
            // filter by year
            moods = moodRepository.findByYear(year);
        } else {
            // no params = return all values
            moods = moodRepository.findAll();
        }
        return moods.stream()
                .map(MoodMapper::mapToMoodDto)
                .collect(Collectors.toList());
    }
}
