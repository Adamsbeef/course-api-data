package com.example.springbootquickstart.courseapidata.courses;

import com.example.springbootquickstart.courseapidata.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Courses {

    @Id
    private  String id;
    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Courses(String description, String id, String name, Topic topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic("topicId","","");
    }

    public Courses() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
