package cn.com.scitc.webapp3.controller;

import cn.com.scitc.webapp3.dao.CourseDao;
import cn.com.scitc.webapp3.dao.StudentDao;
import cn.com.scitc.webapp3.model.Course;
import cn.com.scitc.webapp3.model.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Optional;

    @RequestMapping("/Course")
    @Controller
public class CourseController {
    Log log = LogFactory.getLog("xxxxx");
    private @Autowired
    CourseDao courseDao;

    @RequestMapping("/CoursEdit")
    private String courseEditPage(Integer id, Model model) {
        Optional<Course> optional=courseDao.findById(id);
        Course course=optional.get();
        model.addAttribute("courses",course);
        log.info("id"+id);
        return "/Course/CoursEdit";
    }

    @RequestMapping("/course")
    private String coursePage(Model model) {
        Iterable<Course> iterable=courseDao.findAll();
        model.addAttribute("courses",iterable);
        return "Course/course";
    }

    @RequestMapping("/update")
    private String updatePage(Integer id, String name,BigDecimal courseScore,Integer courseTime) {
        Optional<Course> optional=courseDao.findById(id);
        Course course=optional.get();
        course.setId(id);
        course.setName(name);
        course.setCourseScore(courseScore);
        course.setCourseTime(courseTime);
        courseDao.save(course);
        return "redirect:/Course/course";
    }

    @RequestMapping("delete")
    private String deletePage(Integer id) {
        Optional<Course> optional=courseDao.findById(id);
        courseDao.deleteById(id);
        return "redirect:/Course/course";
    }
        @RequestMapping("/NewCourse")
        private String newww() {
            return "Course/NewCourse";
        }
        @RequestMapping("/create")
        private String createPage(String name,BigDecimal courseScore,Integer courseTime) {
        Course course = new Course();
        course.setName(name);
        course.setCourseScore(courseScore);
        course.setCourseTime(courseTime);
        courseDao.save(course);
        return "redirect:/Course/course";
        }
    }

