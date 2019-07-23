package cn.com.scitc.webapp3.dao;

import cn.com.scitc.webapp3.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreDao extends CrudRepository<Score,Integer > {
}
