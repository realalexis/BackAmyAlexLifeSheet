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
    public MoodDto createMood(MoodDto moodDto) {
        Mood mood = MoodMapper.mapToMood(moodDto);
        Mood savedMood = moodRepository.save(mood);
        return MoodMapper.mapToMoodDto(savedMood);
    }

    @Override
    public MoodDto getMoodById(Long moodId) {
        Mood mood = moodRepository.findById(moodId)
                .orElseThrow(() -> new ResourceNotFound("Mood does not exist with given id : " + moodId));
        return MoodMapper.mapToMoodDto(mood);
    }

    @Override
    public List<MoodDto> getMoodAll() {
        List<Mood> mood =  moodRepository.findAll();
        return mood.stream().map(MoodMapper::mapToMoodDto)
                .collect(Collectors.toList());
    }

    @Override
    public MoodDto updateMood(long moodId, MoodDto updateMood) {
        return null;
    }

    @Override
    public List<MoodDto> getMoodByYear(int moodYear) {
        List<Mood> year = moodRepository.findByYear(moodYear);
        return year.stream().map(MoodMapper::mapToMoodDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMood(Long moodId) {
            Mood mood = moodRepository.findById(moodId).orElseThrow(
                    () -> new ResourceNotFound("Mood does not exists with given id: " + moodId)
            );

            moodRepository.deleteById(moodId);
        }
    }
