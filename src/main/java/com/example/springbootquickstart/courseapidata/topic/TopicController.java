package com.example.springbootquickstart.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id.toLowerCase());
    }

//    @PreAuthorize("hasRole"("ROLE_ADMIN"))
    @PostMapping("/topics")
    public Topic addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    @PostMapping("/test")
    public String testTopic(@RequestBody String test) {
        return "SUCCESS";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id.toLowerCase(), topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.deleteTopic(id.toLowerCase(), topic);
    }
}
