package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Weight;
import org.acme.AmyAlexLifeSheetBackend.repository.WeightRepository;
import org.acme.AmyAlexLifeSheetBackend.service.WeightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weight")
public class WeightController extends BaseController<Weight, Long> {
    private final WeightService weightService;
    public WeightController(WeightRepository repository, WeightService weightService) {
        super(repository);
        this.weightService = weightService;
    }
    @GetMapping("/tempdata")
    public ResponseEntity<List<WeightDto>> getWeight(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer week,
            @RequestParam(required = false) Integer day
    ) {
        List<WeightDto> weight = weightService.getWeightByParams(year, month, week, day);
        return ResponseEntity.ok(weight);
    }

}