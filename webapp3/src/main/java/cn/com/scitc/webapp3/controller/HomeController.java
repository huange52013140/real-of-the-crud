package cn.com.scitc.webapp3.controller;

import cn.com.scitc.webapp3.dao.StudentDao;
import cn.com.scitc.webapp3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired  private StudentDao studentDao;
    @GetMapping({"/","student/list"})
    private String defaultPage(Model model){
        Iterable<Student> list = studentDao.findAll();
        model.addAttribute("students",list);
        return "default";
    }
    @GetMapping("/include")
    private String inculde(){
        return "include";
    }

}
