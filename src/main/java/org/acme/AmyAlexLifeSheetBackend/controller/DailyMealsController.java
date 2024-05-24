package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.DailyMealsDto;
import org.acme.AmyAlexLifeSheetBackend.entity.DailyMeals;
import org.acme.AmyAlexLifeSheetBackend.repository.DailyMealsRepository;
import org.acme.AmyAlexLifeSheetBackend.service.DailyMealsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dailymeals")
public class DailyMealsController extends BaseController<DailyMeals, Long> {
    private final DailyMealsService dailyMealsService;
    public DailyMealsController(DailyMealsRepository repository, DailyMealsService dailyMealsService) {
        super(repository);
        this.dailyMealsService = dailyMealsService;
    }
    @GetMapping("/tempdata")
    public ResponseEntity<List<DailyMealsDto>> getDailyMeals(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer week,
            @RequestParam(required = false) Integer day
    ) {
        List<DailyMealsDto> dailyMeals = dailyMealsService.getDailyMealsByParams(year, month, week, day);
        return ResponseEntity.ok(dailyMeals);
    }

}