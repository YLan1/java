package com.lhzs.springbootdemo.service;

import com.lhzs.springbootdemo.dao.UserDao;
import com.lhzs.springbootdemo.model.HelloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<HelloModel> getUsers(String userName){
       List<HelloModel> list ;
       if (userName != null){
           list = userDao.selectUser(userName);
       }else {
           list = new ArrayList<>();
       }
       return list;
    }

    public int updataUser(String oldName, String newName){
        if (oldName != null && newName !=null){
            return userDao.updataUser(oldName,newName);
        }
        return 0;
    }

    public List<HelloModel> getUsers(){
        List<HelloModel> list ;
        list = userDao.selectUser();
        return list;
    }
}
