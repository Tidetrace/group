package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "b_resource")
public class BResource {
    /**
     * 后台权限表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_url")
    private String resourceUrl;

    /**
     * 0、无效	1、有效）
     */
    private Integer enable;

    @Column(name = "creater")
    private String creater;
    @Column(name = "updater")
    private String updater;
    @Column(name="create_time")
    private Timestamp createTime;
    @Column(name="update_time")
    private Timestamp updateTime;
    /**
     * 获取后台权限表
     *
     * @return id - 后台权限表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置后台权限表
     *
     * @param id 后台权限表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return resource_name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return resource_url
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * @param resourceUrl
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * 获取0、无效	1、有效）
     *
     * @return enable - 0、无效	1、有效）
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * 设置0、无效	1、有效）
     *
     * @param enable 0、无效	1、有效）
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}