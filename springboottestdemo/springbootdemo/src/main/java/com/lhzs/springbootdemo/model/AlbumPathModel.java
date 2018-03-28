package com.lhzs.springbootdemo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "album", schema = "test", catalog = "")
public class AlbumPathModel {
    private int id;
    private String name;
    private String path;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumPathModel that = (AlbumPathModel) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, path);
    }
}
