package com.zhiyou.mall.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "b_user")
public class BUser {
    /**
     * 后台用户表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "true_name")
    private String trueName;
    @Transient
    private BRole role;
    /**
     * 0、可用	1、不能用）
     */
    private Integer state;

    @Transient
    public BRole BRole;

    public com.zhiyou.mall.entity.BRole getBRole() {
        return BRole;
    }

    public void setBRole(com.zhiyou.mall.entity.BRole BRole) {
        this.BRole = BRole;
    }

    /**
     * 获取后台用户表
     *
     * @return id - 后台用户表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置后台用户表
     *
     * @param id 后台用户表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return true_name
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * @param trueName
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * 获取0、可用	1、不能用）
     *
     * @return state - 0、可用	1、不能用）
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0、可用	1、不能用）
     *
     * @param state 0、可用	1、不能用）
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public BRole getRole() {
        return role;
    }

    public void setRole(BRole role) {
        this.role = role;
    }
}