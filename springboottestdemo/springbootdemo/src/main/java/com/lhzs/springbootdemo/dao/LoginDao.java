package com.lhzs.springbootdemo.dao;

import com.lhzs.springbootdemo.model.PublicUsersModel;
import com.lhzs.springbootdemo.model.ScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LoginDao extends JpaRepository<PublicUsersModel,Integer> {

    @Query(value = "select * from public_users  where name= ?1 and paw = ?2" , nativeQuery = true)
    public PublicUsersModel login(String name , String paw);

    @Query(value = "select * from public_users  where name= ?1" , nativeQuery = true)
    public PublicUsersModel checkName(String name);

    @Query(value = "select * from public_users  where name= ?1 AND type =?2" , nativeQuery = true)
    public PublicUsersModel checkNameWithType(String name, String type);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public_users SET name = ?1, paw = ?2 WHERE name = ?3", nativeQuery = true)
    public int updata(String newName, String paw, String oldName);

    //为查询所有public_user_id对应的name
    @Query(value = "select *from public_users WHERE del_flg = 0" , nativeQuery = true)
    public List<PublicUsersModel> getUsersNamesModel();
}
