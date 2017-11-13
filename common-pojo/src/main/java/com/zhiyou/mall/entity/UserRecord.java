package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

@Table(name = "user_record")
public class UserRecord {
    /**
     * 用户浏览记录
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "good_uuid")
    private String goodUuid;

    @Column(name = "create_time")
    private Date createTime;

    private Integer state;

    /**
     * 获取用户浏览记录
     *
     * @return id - 用户浏览记录
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户浏览记录
     *
     * @param id 用户浏览记录
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_uuid
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * @param userUuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * @return good_uuid
     */
    public String getGoodUuid() {
        return goodUuid;
    }

    /**
     * @param goodUuid
     */
    public void setGoodUuid(String goodUuid) {
        this.goodUuid = goodUuid;
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
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }
}