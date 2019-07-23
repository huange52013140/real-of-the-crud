package cn.com.scitc.webapp3.dao;

import cn.com.scitc.webapp3.model.Course;
import org.springframework.data.repository.CrudRepository;
public interface CourseDao extends CrudRepository<Course ,Integer> {
}
