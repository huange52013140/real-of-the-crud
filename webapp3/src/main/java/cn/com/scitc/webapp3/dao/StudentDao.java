package cn.com.scitc.webapp3.dao;

import cn.com.scitc.webapp3.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student,Integer> {
}
