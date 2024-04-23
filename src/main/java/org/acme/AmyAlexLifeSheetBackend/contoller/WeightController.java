package org.acme.AmyAlexLifeSheetBackend.contoller;


import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;
import org.acme.AmyAlexLifeSheetBackend.service.WeightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/weight")
public class WeightController {
    private WeightService weightService;

    //Build Add Weight REST API
    @PostMapping
    public ResponseEntity<WeightDto> createWeight(@RequestBody WeightDto weightDto){
        WeightDto savedWeight = weightService.createWeight(weightDto);
        return new ResponseEntity<>(savedWeight, HttpStatus.CREATED);
    }

    //Build Get Weight REST API
    @GetMapping("{id}")
    public ResponseEntity<WeightDto> getWeightById(@PathVariable("id") Long weightId){
        WeightDto weightDto = weightService.getWeightById(weightId);
        return ResponseEntity.ok(weightDto);
    }

    //Build Get All weight REST API
    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping
    public ResponseEntity<List<WeightDto>> getWeightAll(){
        List<WeightDto> weight = weightService.getWeightAll();
        return ResponseEntity.ok(weight);
    }

    @PutMapping("{id}")
    public ResponseEntity<WeightDto> updateWeight(@PathVariable("id") long weightId,
                                                  @RequestBody WeightDto updatedWeight){
         WeightDto weight =  weightService.updateWeight(weightId, updatedWeight);

         return ResponseEntity.ok(weight);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWeight(@PathVariable("id") Long weightId){
        weightService.deleteWeight(weightId);
        return ResponseEntity.ok("Weight entry deleted successfully !");

    }


}
