package com.projects.basicspringmongo.controller;

import com.projects.basicspringmongo.entity.Tutorial;
import com.projects.basicspringmongo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tutorial")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping
    public ResponseEntity getAllTutorial(){
        List <Tutorial> data = tutorialService.getAllTutorials();

        if(data.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createTutorial(@RequestBody Tutorial tutorial){
        try{
            Tutorial data = tutorialService.createTutorial(tutorial);

            return new ResponseEntity(data, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTutorial(@PathVariable String id, @RequestBody Tutorial tutorial){
        try{
            Tutorial data = tutorialService.updateTutorial(id, tutorial);

            return new ResponseEntity(data, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTutorial(@PathVariable String id){
        try{
            tutorialService.deleteTutorial(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
