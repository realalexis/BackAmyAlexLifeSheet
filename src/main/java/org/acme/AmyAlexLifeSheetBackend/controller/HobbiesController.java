package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.HobbiesDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Hobbies;
import org.acme.AmyAlexLifeSheetBackend.repository.HobbiesRepository;
import org.acme.AmyAlexLifeSheetBackend.service.HobbiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hobbies")
public class HobbiesController extends BaseController<Hobbies, Long> {
    private final HobbiesService hobbiesService;
    public HobbiesController(HobbiesRepository repository, HobbiesService hobbiesService) {
        super(repository);
        this.hobbiesService = hobbiesService;
    }
    @GetMapping("/tempdata")
    public ResponseEntity<List<HobbiesDto>> getHobbies(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer week,
            @RequestParam(required = false) Integer day
    ) {
        List<HobbiesDto> hobbies = hobbiesService.getHobbiesByParams(year, month, week, day);
        return ResponseEntity.ok(hobbies);
    }

}