package com.lhzs.springbootdemo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "public_users", schema = "test", catalog = "")
public class PublicUsersModel {
    private int id;
    private String name;
    private String paw;
    private Integer type;
    private String createTime;
    private Integer delFlg;
    private String salt;

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
    @Column(name = "paw")
    public String getPaw() {
        return paw;
    }

    public void setPaw(String paw) {
        this.paw = paw;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "del_flg")
    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicUsersModel that = (PublicUsersModel) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(paw, that.paw) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(delFlg, that.delFlg) &&
                Objects.equals(salt, that.salt);
    }

    @Override
    public String toString() {
        return "PublicUsersModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paw='" + paw + '\'' +
                ", type=" + type +
                ", createTime='" + createTime + '\'' +
                ", delFlg=" + delFlg +
                ", salt='" + salt + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, paw, type, createTime, delFlg, salt);
    }
}
