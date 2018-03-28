package com.lhzs.springbootdemo.dao;

import com.lhzs.springbootdemo.model.AlbumPathModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumDao extends JpaRepository<AlbumPathModel, Integer> {

}
