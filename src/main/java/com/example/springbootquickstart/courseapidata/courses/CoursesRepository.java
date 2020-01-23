package com.example.springbootquickstart.courseapidata.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Courses, String> {

    public List<Courses> findByName(String name);
    public List<Courses> findByDescription(String description);
    public List<Courses> findByTopicId(String topicId);
}
