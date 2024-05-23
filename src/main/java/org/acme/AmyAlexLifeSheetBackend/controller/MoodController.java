package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.acme.AmyAlexLifeSheetBackend.repository.MoodRepository;
import org.acme.AmyAlexLifeSheetBackend.service.MoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mood")
public class MoodController extends BaseController<Mood, Long> {
    private final MoodService moodService;
    public MoodController(MoodRepository repository, MoodService moodService) {
        super(repository);
        this.moodService = moodService;
    }
    @GetMapping("/tempdata")
    public ResponseEntity<List<MoodDto>> getMood(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer week,
            @RequestParam(required = false) Integer day
    ) {
        List<MoodDto> moods = moodService.getMoodsByParams(year, month, week, day);
        return ResponseEntity.ok(moods);
    }

}