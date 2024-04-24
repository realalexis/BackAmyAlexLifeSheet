package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.acme.AmyAlexLifeSheetBackend.repository.MoodRepository;
import org.acme.AmyAlexLifeSheetBackend.service.MoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mood")
public class MoodController extends BaseController<Mood, Long> {
    private final MoodService moodService;
    public MoodController(MoodRepository repository, MoodService moodService) {
        super(repository);
        this.moodService = moodService;
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<MoodDto> getMoodByMonth(@PathVariable("month") int month){
            List<MoodDto> mood = moodService.getMoodByMonth(month);
            return ResponseEntity.ok((MoodDto) mood);
    }
}