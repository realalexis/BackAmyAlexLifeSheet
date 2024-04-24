package org.acme.AmyAlexLifeSheetBackend.controller;

import org.acme.AmyAlexLifeSheetBackend.controller.BaseController;
import org.acme.AmyAlexLifeSheetBackend.entity.Sport;
import org.acme.AmyAlexLifeSheetBackend.repository.SportRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sport")
public class SportController extends BaseController<Sport, Long> {
    public SportController(SportRepository repository) {
        super(repository);
    }
}