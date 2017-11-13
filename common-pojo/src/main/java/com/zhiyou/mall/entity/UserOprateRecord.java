package com.zhiyou.mall.entity;
import javax.persistence.*;
@Table(name = "user_oprate_record")
public class UserOprateRecord {
    /**
     * 用户操作记录
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 用户日志记录
     */
    @Column(name = "oprate_record")
    private String oprateRecord;

    /**
     * 获取用户操作记录
     *
     * @return id - 用户操作记录
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户操作记录
     *
     * @param id 用户操作记录
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
     * 获取用户日志记录
     *
     * @return oprate_record - 用户日志记录
     */
    public String getOprateRecord() {
        return oprateRecord;
    }

    /**
     * 设置用户日志记录
     *
     * @param oprateRecord 用户日志记录
     */
    public void setOprateRecord(String oprateRecord) {
        this.oprateRecord = oprateRecord;
    }
}