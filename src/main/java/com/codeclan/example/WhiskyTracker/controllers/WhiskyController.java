package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController{
    @Autowired
    private WhiskyRepository whiskyRepository;

    @GetMapping(value="/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/whiskies/year/{year}")
    public ResponseEntity getWhiskiesByYear(@PathVariable int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value= "/whiskies/Distillery")
    public ResponseEntity getWhiskiesByDistilleryandAge(@RequestParam(name="distid") Long id,
                                                        @RequestParam(name="aged") int age ){
        List<Whisky> whiskies = whiskyRepository.findByDistilleryIdAndAge(id, age);
        return new ResponseEntity<>(whiskies,HttpStatus.OK );
    }

    @GetMapping(value= "/whiskies/Distilleries")
    public ResponseEntity getWhiskiesByDistilleryRegion(@RequestParam(name="regioned") String region){

        List<Whisky> whiskies = whiskyRepository.findByDistilleryRegion(region);
        return new ResponseEntity<>(whiskies,HttpStatus.OK );
    }


}
