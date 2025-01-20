package com.rawrahul.journalApp.repository;

import com.rawrahul.journalApp.entity.ConfigJournalAppEntity;
import com.rawrahul.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}

