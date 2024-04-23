package org.acme.AmyAlexLifeSheetBackend.controller;


import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;
import org.acme.AmyAlexLifeSheetBackend.service.MoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mood")
public class MoodController {
    private MoodService moodService;

    //Build Add Mood REST API
    @PostMapping
    public ResponseEntity<MoodDto> createMood(@RequestBody MoodDto moodDto){
        MoodDto savedMood = moodService.createMood(moodDto);
        return new ResponseEntity<>(savedMood, HttpStatus.CREATED);
    }

    //Build Get Mood REST API
    @GetMapping("{id}")
    public ResponseEntity<MoodDto> getMoodById(@PathVariable("id") Long moodId){
        MoodDto moodDto = moodService.getMoodById(moodId);
        return ResponseEntity.ok(moodDto);
    }

    //Build Get All mood REST API
    @GetMapping
    public ResponseEntity<List<MoodDto>> getMoodAll(){
        List<MoodDto> mood = moodService.getMoodAll();
        return ResponseEntity.ok(mood);
    }

    @PutMapping("{id}")
    public ResponseEntity<MoodDto> updateMood(@PathVariable("id") long moodId,
                                                  @RequestBody MoodDto updatedMood){
         MoodDto mood =  moodService.updateMood(moodId, updatedMood);

         return ResponseEntity.ok(mood);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMood(@PathVariable("id") Long moodId){
        moodService.deleteMood(moodId);
        return ResponseEntity.ok("Mood entry deleted successfully !");

    }


}
