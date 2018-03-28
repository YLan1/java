package com.lhzs.springbootdemo.service;

import com.lhzs.springbootdemo.dao.DicDao;
import com.lhzs.springbootdemo.dao.LoginDao;
import com.lhzs.springbootdemo.dao.UserInfoDao;
import com.lhzs.springbootdemo.model.DicModel;
import com.lhzs.springbootdemo.model.HelloModel;
import com.lhzs.springbootdemo.model.PublicUsersInfoModel;
import com.lhzs.springbootdemo.model.PublicUsersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private DicDao dicDao;

    //新增
    public boolean saveUserInfo(PublicUsersInfoModel publicUsersInfoModel){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        publicUsersInfoModel.setCreateTime(df.format(new Date()));
        publicUsersInfoModel.setType(0);//默认是0
        publicUsersInfoModel.setDelFlg(0);//0是可用用户
        PublicUsersInfoModel save = userInfoDao.save(publicUsersInfoModel);
        if (save != null){
            return true;
        }
        return false;
    }

    //公众号信息列表
    public List<PublicUsersInfoModel> getUserList(){
        List<PublicUsersInfoModel> list ;
        list = userInfoDao.getUserList();
        return list;
    }

    //删除（假删除）
    public boolean delUser(Integer userId){
        int delUser = userInfoDao.delUser(userId);
        return delUser>0;
    }

    //一条信息
    public PublicUsersInfoModel getUserInfo(Integer userId){
        PublicUsersInfoModel publicUsersInfoModel = userInfoDao.getUserInfo(userId);
        return publicUsersInfoModel;
    }

    //更新
    public boolean upDataUserInfo(PublicUsersInfoModel model){
        model.setDelFlg(0);
        PublicUsersInfoModel publicUsersInfoModel = userInfoDao.saveAndFlush(model);
        if (publicUsersInfoModel != null){
            return true;
        }else {
            return false;

        }
    }

    //查询所有public_user_id
    public List<PublicUsersModel> getUsersNamesModel(){
        List<PublicUsersModel> usersNames = loginDao.getUsersNamesModel();
        return usersNames;
    }

    //根据code（0或1）和type（类似weixin_type、qq_type、login_type）查询 name
    public DicModel getManagerModel(Integer code, String type){
        DicModel dicModel = dicDao.getManagerModelList(code, type);
        return dicModel;
    }

    //根据type查询dic
    public List<DicModel> getTypeManagerModelList(String type){
        List<DicModel> typeManagerModelList = dicDao.getTypeManagerModelList(type);
        return typeManagerModelList;
    }

    //搜索
    public List<PublicUsersInfoModel> searchUserInfoList(String searchStr){
        List<PublicUsersInfoModel> publicUsersInfoModelList = userInfoDao.searchUserInfo(searchStr);
        return publicUsersInfoModelList;
    }
}
