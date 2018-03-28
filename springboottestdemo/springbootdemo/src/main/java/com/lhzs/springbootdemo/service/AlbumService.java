package com.lhzs.springbootdemo.service;

import com.lhzs.springbootdemo.dao.AlbumDao;
import com.lhzs.springbootdemo.model.AlbumPathModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumDao albumDao;


    public boolean saveAlbum(AlbumPathModel model){
        AlbumPathModel save = albumDao.save(model);
        if (save != null){
            return true;
        }else {
            return false;
        }
    }

    public List<AlbumPathModel> albumList(){
        List<AlbumPathModel> all = albumDao.findAll();
        return all;
    }

    public void deleteAlbum(Integer albumId){
        albumDao.deleteById(albumId);
    }
}
