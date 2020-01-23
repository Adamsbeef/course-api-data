package com.example.springbootquickstart.courseapidata.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CoursesRepository coursesRepository;

//    private List<Courses> courses = new ArrayList<>(Arrays.asList(
//            new Courses("Spring Description", "spring", "Spring Framework"),
//            new Courses("Java Description", "java", "Core Java"),
//            new Courses("Javascript Description", "javascript", "Javascript Framework")
//    ));

    public List<Courses> getAllCourses(String topicId){
        List<Courses> courses = new ArrayList<>();
        coursesRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }
    public Courses getCourse(String id) {
//        topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return coursesRepository.findById(id).get();
    }

    public void addCourse(Courses courses) {
        coursesRepository.save(courses);
//        topics.add(topic);
    }

    public void updateCourse(Courses courses) {

//        for (int i = 0; i < topics.size(); i++) {
//            Topic t = topics.get(i);   //get the topics at their index
//            if (t.getId().equals(id)) {  // check the id of the gotten topic
//                topics.set(i, topic);    //use set method to change  the value of the object at the position
//                return;
//            }
//        }
        coursesRepository.save(courses);
    }
    public void deleteCourse(String id, Courses courses) {
        coursesRepository.deleteById(id);
    }
}
