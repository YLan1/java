package com.lhzs.springbootdemo.dao;

import com.lhzs.springbootdemo.model.DicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DicDao extends JpaRepository<DicModel,Integer> {

    //一条信息
    @Query(value = "select * from dic WHERE id = ?1" , nativeQuery = true)
    public DicModel getManager(Integer managerId);

    //删除
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM dic WHERE id = ?1" , nativeQuery = true)
    public int delManager(String userId);

    //根据code（0或1）和type（类似weixin_type、qq_type、login_type）查询所有的 name
    @Query(value = "select * from dic WHERE code = ?1 AND type = ?2" , nativeQuery = true)
    public DicModel getManagerModelList(Integer code, String type);

    @Query(value = "select * from dic WHERE type = ?1" , nativeQuery = true)
    public List<DicModel> getTypeManagerModelList(String type);

}
