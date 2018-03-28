package com.lhzs.springbootdemo.dao;


import com.lhzs.springbootdemo.model.ScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//继承自JpaRepository泛型第2个参数是主键类型
public interface ScoreDao extends JpaRepository<ScoreModel,Integer>{


    /**
     * 原生sql（from 表名）
     * */
    @Query(value = "select * from score  where id > 0 and id < 2" , nativeQuery = true)
    public List<ScoreModel> all();


    /**
     * hql语句（from 映射表的实体类 ，返回所有字段：实体类的变量名）
     * */
    @Query(value = "select stu from ScoreModel stu where stu.id > 0 and stu.id < 3")
    public List<ScoreModel> all2();



    /**
     * hql语句（from 映射表的实体类 ，返回指定字段：实体类需要提供相应的构造方法）
     * */
    @Query(value = "select new ScoreModel (stu.id , stu.mathe , stu.english) from ScoreModel stu where stu.id > 0 and stu.id < 3")
    public List<ScoreModel> all3();


    /**
     * 原生sql带参数
     * */
    @Query(value = "select * from score  where id > ?1 and id < ?2" , nativeQuery = true)
    public List<ScoreModel> all4(int id1 , int id2);


    /**
     * hql带参数
     * */
    @Query("select new ScoreModel (stu.id , stu.mathe , stu.english) from ScoreModel stu where stu.id > :id1 and stu.id < :id2")
    public List<ScoreModel> all5(@Param("id1") int id1 ,@Param("id2") int id2);


}
