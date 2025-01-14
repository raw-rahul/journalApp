package com.rawrahul.journalApp.repository;

import com.rawrahul.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JounralEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}

