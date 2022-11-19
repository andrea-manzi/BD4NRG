package io.swagger.api;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import io.swagger.model.IngestionSpecification;

public interface IngestionSpecificationRepository  extends MongoRepository<IngestionSpecification,String>{

    
     @Query("{druidIngestionSpecID:'?0'}")
    IngestionSpecification findItemByName(String specId);
        
    public long count();
    
}
