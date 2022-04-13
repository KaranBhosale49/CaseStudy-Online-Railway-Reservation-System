package com.CaseStudy.com.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.CaseStudy.com.Model.Train;

@Repository
public interface TrainRepository extends MongoRepository<Train,Integer> {

}
