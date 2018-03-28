package com.lhzs.springbootdemo.service;

import com.lhzs.springbootdemo.dao.ScoreDao;
import com.lhzs.springbootdemo.model.ScoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreDao scoreDao;

    public List<ScoreModel> getAllScore(){
        List<ScoreModel> all = scoreDao.findAll();
        return all;
    }

    public List<ScoreModel> getScore(){

        return scoreDao.all();
    }

    public ScoreModel save(ScoreModel scoreModel){
        ScoreModel scoreModel1 = scoreDao.saveAndFlush(scoreModel);
        return scoreModel;
    }
}
