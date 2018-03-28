package com.lhzs.springbootdemo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "public_users_info", schema = "test", catalog = "")
public class PublicUsersInfoModel {
    private int id;
    private String appId;
    private String appSecret;
    private String token;
    private String encodingAesKey;
    private Integer type;
    private String createTime;
    private String originalId;
    private Integer publicUserId;
    private Integer delFlg;
    private String name;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "app_id")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "app_secret")
    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "encoding_aes_key")
    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
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
    @Column(name = "original_id")
    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    @Basic
    @Column(name = "public_user_id")
    public Integer getPublicUserId() {
        return publicUserId;
    }

    public void setPublicUserId(Integer publicUserId) {
        this.publicUserId = publicUserId;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicUsersInfoModel that = (PublicUsersInfoModel) o;
        return id == that.id &&
                Objects.equals(appId, that.appId) &&
                Objects.equals(appSecret, that.appSecret) &&
                Objects.equals(token, that.token) &&
                Objects.equals(encodingAesKey, that.encodingAesKey) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(originalId, that.originalId) &&
                Objects.equals(publicUserId, that.publicUserId) &&
                Objects.equals(delFlg, that.delFlg) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, appId, appSecret, token, encodingAesKey, type, createTime, originalId, publicUserId, delFlg, name);
    }
}
