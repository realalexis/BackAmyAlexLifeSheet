package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Sport;
import org.acme.AmyAlexLifeSheetBackend.repository.SportRepository;
import org.acme.AmyAlexLifeSheetBackend.service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sport")
public class SportController extends BaseController<Sport, Long> {
    private final SportService sportService;
    public SportController(SportRepository repository, SportService sportService) {
        super(repository);
        this.sportService = sportService;
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<SportDto>> getSportByYear(@PathVariable("year") int year){
        List<SportDto> sport = sportService.getSportByYear(year);
        return ResponseEntity.ok(sport);
    }
}