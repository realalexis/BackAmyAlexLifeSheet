package org.acme.AmyAlexLifeSheetBackend.contoller;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;
import org.acme.AmyAlexLifeSheetBackend.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sport")
public class SportController {
    private SportService sportService;

    //Build Add Sport REST API
    @PostMapping
    public ResponseEntity<SportDto> createSport(@RequestBody SportDto SportDto){
        SportDto savedSport = sportService.createSport(SportDto);
        return new ResponseEntity<>(savedSport, HttpStatus.CREATED);
    }

    //Build Get Sport REST API
    @GetMapping("{id}")
    public ResponseEntity<SportDto> getSportById(@PathVariable("id") Long sportId){
        SportDto sportDto = sportService.getSportById(sportId);
        return ResponseEntity.ok(sportDto);
    }

    //Build Get All Sport REST API
    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping
    public ResponseEntity<List<SportDto>> getSportAll(){
        List<SportDto> sport = sportService.getSportAll();
        return ResponseEntity.ok(sport);
    }

    @PutMapping("{id}")
    public ResponseEntity<SportDto> updateSport(@PathVariable("id") long sportId,
                                                  @RequestBody SportDto updatedSport){
        SportDto sport =  sportService.updateSport(sportId, updatedSport);

        return ResponseEntity.ok(sport);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSport(@PathVariable("id") Long sportId){
        sportService.deleteSport(sportId);
        return ResponseEntity.ok("Sport entry deleted successfully !");

    }


}
