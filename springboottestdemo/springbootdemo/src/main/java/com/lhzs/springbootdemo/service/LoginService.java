package com.lhzs.springbootdemo.service;

import com.lhzs.springbootdemo.dao.LoginDao;
import com.lhzs.springbootdemo.model.PublicUsersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public boolean login(String name, String paw) {
        PublicUsersModel publicUsersModel = loginDao.login(name, paw);
        if (publicUsersModel == null){
            return false;
        }
        return true;
    }

    public boolean checkName(String name) {
        PublicUsersModel publicUsersModel = loginDao.checkName(name);
        if (publicUsersModel == null){
            return false;
        }
        return true;
    }

    public boolean checkNameWithType(String name, String type){
        PublicUsersModel publicUsersModel = loginDao.checkNameWithType(name, type);
        if (publicUsersModel == null){
            return false;
        }
        return true;
    }

    public boolean register(String name, String paw){
        PublicUsersModel publicUsersModel = new PublicUsersModel();
        publicUsersModel.setName(name);
        publicUsersModel.setPaw(paw);
        publicUsersModel.setDelFlg(0);
        publicUsersModel.setType(0);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        publicUsersModel.setCreateTime(df.format(System.currentTimeMillis()));
        PublicUsersModel save = loginDao.save(publicUsersModel);
        if (save != null){
            return true;
        }
        return false;
    }

    public boolean upData(String oldName, String newName, String paw){
        return loginDao.updata(newName, paw, oldName) > 0;
    }

}
