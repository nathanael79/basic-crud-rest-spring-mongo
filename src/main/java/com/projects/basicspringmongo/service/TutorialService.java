package com.projects.basicspringmongo.service;

import com.projects.basicspringmongo.entity.Tutorial;
import com.projects.basicspringmongo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public Tutorial createTutorial(Tutorial tutorial){
        return tutorialRepository.save(tutorial);
    }

    public List<Tutorial> getAllTutorials(){
        return tutorialRepository.findAll();
    }

    public Optional<Tutorial> getTutorialById(String id){
        return tutorialRepository.findById(id);
    }

    public Tutorial updateTutorial(String id, Tutorial tutorial){
        Optional<Tutorial> data = getTutorialById(id);

        if (data.isPresent()){
            Tutorial _tutorial = data.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return tutorialRepository.save(_tutorial);
        }

        Tutorial _tutorial = new Tutorial();
        return _tutorial;
    }

    public void deleteTutorial(String id){
        tutorialRepository.deleteById(id);
    }


}
