package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Sport;
import org.acme.AmyAlexLifeSheetBackend.repository.SportRepository;
import org.acme.AmyAlexLifeSheetBackend.service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController extends BaseController<Sport, Long> {
    private final SportService sportService;
    public SportController(SportRepository repository, SportService sportService) {
        super(repository);
        this.sportService = sportService;
    }
    @GetMapping("/tempdata")
    public ResponseEntity<List<SportDto>> getSport(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer week,
            @RequestParam(required = false) Integer day
    ) {
        List<SportDto> sports = sportService.getSportByParams(year, month, week, day);
        return ResponseEntity.ok(sports);
    }

}