package com.lhzs.springbootdemo.service;

import com.lhzs.springbootdemo.dao.DicDao;
import com.lhzs.springbootdemo.model.DicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DicService {

    @Autowired
    private DicDao dicDao;

    //保存字典
    public boolean saveManagerInfo(DicModel dicModel){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dicModel.setCreateTime(df.format(System.currentTimeMillis()));
        DicModel save = dicDao.save(dicModel);
        if (save != null){
            return true;
        }
        return false;
    }

    //字典列表
    public List<DicModel> getManagerList(){
        List<DicModel> list;
        list = dicDao.findAll();
        return list;
    }

    //一条信息
    public DicModel getManager(Integer managerId){
        DicModel model = dicDao.getManager(managerId);
        return model;
    }

    //更新字典
    public boolean upDataManager(DicModel dicModel){
        DicModel model = dicDao.saveAndFlush(dicModel);
        if (model != null){
            return true;
        }else {
            return false;
        }
    }

    //删除
    public boolean deleManager(String managerId){
        int i = dicDao.delManager(managerId);
        return i>0;
    }

    //分页查询
    public Page<DicModel> getManagerListByPage(Pageable page){
        Page<DicModel> all = dicDao.findAll(page);
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
        return dicDao.findAll(page);
    }
}
