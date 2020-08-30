package com.projects.basicspringmongo.repository;

import com.projects.basicspringmongo.entity.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial,String> {
    List<Tutorial>findByTitleContaining(String title);
    List<Tutorial>findByPublished(boolean published);
}
