package com.lhzs.springbootdemo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dic", schema = "test", catalog = "")
public class DicModel {
    private int id;
    private String type;
    private String name;
    private String code;
    private String comment;
    private String createTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DicModel dicModel = (DicModel) o;
        return id == dicModel.id &&
                Objects.equals(type, dicModel.type) &&
                Objects.equals(name, dicModel.name) &&
                Objects.equals(code, dicModel.code) &&
                Objects.equals(comment, dicModel.comment) &&
                Objects.equals(createTime, dicModel.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, name, code, comment, createTime);
    }
}
