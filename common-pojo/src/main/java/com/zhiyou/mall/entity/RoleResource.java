package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.List;

@Table(name = "role_resource")
public class RoleResource {
    /**
     * 角色权限
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "resource_id")
    private Integer resourceId;
    @Transient
    private BResource bResource;

    public BResource getbResource() {
        return bResource;
    }

    public void setbResource(BResource bResource) {
        this.bResource = bResource;
    }

    /**
     * 获取角色权限
     *
     * @return id - 角色权限
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色权限
     *
     * @param id 角色权限
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return resource_id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}