package com.rawrahul.journalApp.service;

import com.rawrahul.journalApp.entity.JournalEntry;
import com.rawrahul.journalApp.entity.User;
import com.rawrahul.journalApp.repository.JounralEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JounralEntryRepository jounralEntryRepository;

    @Autowired UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username){

        try {
            User user = userService.findByusername(username);
            JournalEntry saved = jounralEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        }
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry", e);
        }

    }

    public  void saveEntry(JournalEntry journalEntry){
        jounralEntryRepository.save(journalEntry);
    }


    public List<JournalEntry> getAll(){
        return jounralEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return jounralEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String username){

        boolean removed = false;
        try {
            User user = userService.findByusername(username);
            removed = user.getJournalEntries().removeIf(x-> x.getId().equals(id));
            if(removed){
                userService.saveEntry(user);
                jounralEntryRepository.deleteById(id);
            }
        }
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry!!", e);
        }

        return removed;
    }
}
