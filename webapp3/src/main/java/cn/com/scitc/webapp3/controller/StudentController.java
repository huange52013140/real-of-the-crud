package cn.com.scitc.webapp3.controller;

import cn.com.scitc.webapp3.dao.StudentDao;
import cn.com.scitc.webapp3.model.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    private Log log = LogFactory.getLog("xxxxx");
    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/edit")
    private String edit(Integer id , Model model) {
        Optional<Student> optional=studentDao.findById(id);
        Student student = optional.get();
        model.addAttribute("students",student);
        log.info("id"+id);
        return "Student/edit";
    }

    @RequestMapping("/update")
//    private String update(Integer id,String name) {
//        Optional<Student> optional=studentDao.findById(id);
//        Student student = optional.get();
//        student.setName(name);
//        studentDao.save(student);
//        log.info("sucessful");
//        return "redirect:/";
    private String update(Student inputStu) {
        log.info("inputStu is"+inputStu ==null?"null":"nut null");
        log.info("id is"+inputStu.getId());
        Optional<Student> optional=studentDao.findById(inputStu.getId());
        Student student=optional.get();
        student.setName(inputStu.getName());
        student.setStudentId(inputStu.getStudentId());
        student.setAddress(inputStu.getAddress());
        student.setClassName(inputStu.getClassName());
        student.setMobile(inputStu.getMobile());
        studentDao.save(student);
        log.info("save sucscfull");
        return "redirect:/";
}
    @RequestMapping("/delete")
    private String delete(Integer id) {
        studentDao.deleteById(id);
        log.info("delete sucessful!");
        return "redirect:/";
    }
    @RequestMapping("/new")
    private String newww(String id,String name) {
        return "Student/new";
    }
    @RequestMapping("/create")
    private String create(String id,String name) {
        Student student = new Student();
        student.setStudentId(id);
        student.setName(name);
        studentDao.save(student);
        return "redirect:/";


    }
}
