package com.zhiyou.mall.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
@Table(name = "b_role")
public class BRole {
    /**
     * 后台角色
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    /**
     * （0、可用	1、不能用）
     */
    private Integer state;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "user_id")
    private Integer userId;
    @Transient
    private BResource BResource;

    public com.zhiyou.mall.entity.BResource getBResource() {
        return BResource;
    }

    public void setBResource(com.zhiyou.mall.entity.BResource BResource) {
        this.BResource = BResource;
    }

    /**
     * 获取后台角色
     *
     * @return id - 后台角色
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置后台角色
     *
     * @param id 后台角色
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取（0、可用	1、不能用）
     *
     * @return state - （0、可用	1、不能用）
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置（0、可用	1、不能用）
     *
     * @param state （0、可用	1、不能用）
     */
    public void setState(Integer state) {
        this.state = state;
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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}