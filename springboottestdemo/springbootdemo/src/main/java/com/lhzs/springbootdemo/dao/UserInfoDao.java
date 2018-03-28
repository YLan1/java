package com.lhzs.springbootdemo.dao;

import com.lhzs.springbootdemo.model.PublicUsersInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserInfoDao extends JpaRepository<PublicUsersInfoModel, Integer>{

    //列表（取可用公众号）
    @Query(value = "select * from public_users_info WHERE del_flg = 0" , nativeQuery = true)
    public List<PublicUsersInfoModel> getUserList();

    //假删除
    @Transactional
    @Modifying
    @Query(value = "UPDATE public_users_info SET del_flg = 1 WHERE id = ?1" , nativeQuery = true)
    public int delUser(Integer userId);


    //一条信息
    @Query(value = "select * from public_users_info WHERE id = ?1" , nativeQuery = true)
    public PublicUsersInfoModel getUserInfo(Integer userId);


    //搜索
    @Query(value = "SELECT * FROM public_users_info a WHERE (a.id LIKE ?1 OR  a.name LIKE ?1 OR a.app_id LIKE ?1 OR app_secret LIKE ?1) ORDER BY a.id" , nativeQuery = true)
    public List<PublicUsersInfoModel> searchUserInfo(String searchStr);

}
