package com.exp.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exp.user.model.ARImageMetadata;


@Repository
public interface ARImageMetadataRepository extends MongoRepository<ARImageMetadata, String> {

}
