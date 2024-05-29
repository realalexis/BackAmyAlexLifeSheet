package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Mood;
import org.acme.AmyAlexLifeSheetBackend.repository.MoodRepository;
import org.acme.AmyAlexLifeSheetBackend.service.MoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController//returns a domain object instead of a view
@RequestMapping("/mood") //maps HTTP requests
public class MoodController extends BaseController<Mood, Long> {
//entity's type / entity's identifier
    private final MoodService moodService;
    public MoodController(MoodRepository repository, MoodService moodService) {
        super(repository);
        this.moodService = moodService;
    }
    @GetMapping("/tempdata")
    public ResponseEntity<List<MoodDto>> getMood(
            //parameters are optional
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer week,
            @RequestParam(required = false) Integer day
    ) {
        //calls getMoods from Service with provided params
        List<MoodDto> moods = moodService.getMoodsByParams(year, month, week, day);
        //response body will be a list of HobbiesDto objects
        return ResponseEntity.ok(moods);
    }

}