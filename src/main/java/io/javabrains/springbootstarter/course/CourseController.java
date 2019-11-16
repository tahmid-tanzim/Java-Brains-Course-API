package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topic_id}/courses")
    public List<Course> getAllCourses(@PathVariable("topic_id") String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topic_id}/courses/{course_id}")
    public Course getCourse(@PathVariable("course_id") String courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topic_id}/courses")
    public void addCourse(@PathVariable("topic_id") String topicId, @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topic_id}/courses")
    public void updateCourse(@PathVariable("topic_id") String topicId, @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topic_id}/courses/{course_id}")
    public void deleteCourse(@PathVariable("course_id") String courseId) {
        courseService.deleteCourse(courseId);
    }
}
