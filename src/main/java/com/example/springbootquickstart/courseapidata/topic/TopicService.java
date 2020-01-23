package com.example.springbootquickstart.courseapidata.topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring Description", "spring", "Spring Framework"),
            new Topic("Java Description", "java", "Core Java"),
            new Topic("Javascript Description", "javascript", "Javascript Framework")
    ));
    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }
    public Topic getTopic(String id) {
//        topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public Topic addTopic(Topic topic) {
        topicRepository.save(topic);
        return topic;
//        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topic t = topics.get(i);   //get the topics at their index
//            if (t.getId().equals(id)) {  // check the id of the gotten topic
//                topics.set(i, topic);    //use set method to change  the value of the object at the position
//                return;
//            }
//        }
        topicRepository.save(topic);
    }
    public void deleteTopic(String id, Topic topic) {
//        topics.removeIf(topic1 -> topic1.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
