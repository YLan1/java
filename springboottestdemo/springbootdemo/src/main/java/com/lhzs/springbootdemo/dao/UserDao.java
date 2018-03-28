package com.lhzs.springbootdemo.dao;

import com.lhzs.springbootdemo.model.HelloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository提供数据
@Repository
public class UserDao {
    //实例化注解
   @Autowired
   private JdbcTemplate jdbcTemplate;
   public List<HelloModel> selectUser(String userName){
       String sql = "select *from student WHERE name = ?";
       List<HelloModel> list = jdbcTemplate.query(sql, new Object[]{userName}, new BeanPropertyRowMapper<>(HelloModel.class));
       return list;
   }

   public int updataUser(String oldName, String newName){
       String sql = "UPDATE student SET name = ? WHERE name = ?";
       int isUpData = 1;
       isUpData = jdbcTemplate.update(sql, new Object[]{newName, oldName});
       return isUpData;
   }

    public List<HelloModel> selectUser(){
        String sql = "select *from student";
        List<HelloModel> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HelloModel.class));
        return list;
    }

}
