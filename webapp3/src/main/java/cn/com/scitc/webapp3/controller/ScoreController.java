package cn.com.scitc.webapp3.controller;
import cn.com.scitc.webapp3.dao.ScoreDao;
import cn.com.scitc.webapp3.model.Score;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.Date;
import java.util.Optional;

@RequestMapping("/Score")
@Controller
public class ScoreController {
    Log log = LogFactory.getLog("xxxxx");
    private
    @Autowired
    ScoreDao scoreDao;

    @RequestMapping("/ScoreEdit")
    private String ScoreEditPage(Integer id, Model model) {
        Optional<Score> optional = scoreDao.findById(id);
        Score score = optional.get();
        model.addAttribute("scores", score);
        log.info("id" + id);
        return "/Score/ScoreEdit";
    }

    @RequestMapping("/score")
    private String scorePage(Model model) {
        Iterable<Score> iterable = scoreDao.findAll();
        model.addAttribute("scores", iterable);
        return "Score/score";
    }

    @RequestMapping("/update")
    private String updatePage(Integer id, Character studentId, Integer courseId, Date dt) {
        Optional<Score> optional = scoreDao.findById(id);
        Score score = optional.get();
        scoreDao.save(score);
        log.info("save sucessful!");
        return "redirect:/Score/score";
    }

    @RequestMapping("/delete")
    private String delete(Integer id) {
        scoreDao.deleteById(id);
        log.info("delete sucessful!");
        return "redirect:/Score/score";
    }

    @RequestMapping("/newCourse")
    private String newww(String id) {
        return "Score/newScore";
    }

    @RequestMapping("/create")
    private String create(Character studentId, Integer courseId, Date dt) {
        Score score = new Score();
        score.setCourseId(courseId);
        score.setDt(dt);
        score.setStudentId(studentId);
        scoreDao.save(score);
        return "redirect:/Score/score";
    }
}