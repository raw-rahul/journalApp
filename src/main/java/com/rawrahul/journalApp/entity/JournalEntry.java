package com.rawrahul.journalApp.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries") // mapped it with the collection of database
//@Getter
//@Setter  // both can be done by with help of Lombok
@Data  // by this annotation only, we can use getter, setter, etc
@NoArgsConstructor  // used for deserialization means converting json to pojo
public class JournalEntry {

    @Id //for unique id
    private ObjectId id;
    @NotNull
    private String title;
    private String content;
    private LocalDateTime date;


//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getDate(){
//        return date;
//    }
//
//    public void setDate(LocalDateTime date){
//        this.date = date;
//    }

}
