package org.acme.AmyAlexLifeSheetBackend.contoller;


import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.HungryDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Hungry;
import org.acme.AmyAlexLifeSheetBackend.service.HungryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hungry")
public class HungryController {
    private HungryService hungryService;

    //Build Add Hungry REST API
    @PostMapping
    public ResponseEntity<HungryDto> createHungry(@RequestBody HungryDto hungryDto){
        HungryDto savedHungry = hungryService.createHungry(hungryDto);
        return new ResponseEntity<>(savedHungry, HttpStatus.CREATED);
    }

    //Build Get Hungry REST API
    @GetMapping("{id}")
    public ResponseEntity<HungryDto> getHungryById(@PathVariable("id") Long hungryId){
        HungryDto hungryDto = hungryService.getHungryById(hungryId);
        return ResponseEntity.ok(hungryDto);
    }

    //Build Get All hungry REST API
    @GetMapping
    public ResponseEntity<List<HungryDto>> getHungryAll(){
        List<HungryDto> hungry = hungryService.getHungryAll();
        return ResponseEntity.ok(hungry);
    }

    @PutMapping("{id}")
    public ResponseEntity<HungryDto> updateHungry(@PathVariable("id") long hungryId,
                                                  @RequestBody HungryDto updatedHungry){
         HungryDto hungry =  hungryService.updateHungry(hungryId, updatedHungry);

         return ResponseEntity.ok(hungry);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHungry(@PathVariable("id") Long hungryId){
        hungryService.deleteHungry(hungryId);
        return ResponseEntity.ok("Hunger entry deleted successfully !");

    }


}
