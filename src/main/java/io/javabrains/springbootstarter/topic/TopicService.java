package io.javabrains.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "React Redux", "React Redux Description")
    ));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        try {
            return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        } catch (NoSuchElementException e) {
            return new Topic(id, "NoSuchElementException", e.toString());
        }
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}
