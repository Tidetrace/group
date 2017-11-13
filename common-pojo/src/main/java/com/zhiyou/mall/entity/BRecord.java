package com.zhiyou.mall.entity;


import javax.persistence.*;

@Table(name = "b_record")
public class BRecord {
    /**
     * 管理记录
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "b_user_id")
    private Integer bUserId;

    @Column(name = "b_opera_record")
    private String bOperaRecord;

    /**
     * 获取管理记录
     *
     * @return id - 管理记录
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置管理记录
     *
     * @param id 管理记录
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return b_user_id
     */
    public Integer getbUserId() {
        return bUserId;
    }

    /**
     * @param bUserId
     */
    public void setbUserId(Integer bUserId) {
        this.bUserId = bUserId;
    }

    /**
     * @return b_opera_record
     */
    public String getbOperaRecord() {
        return bOperaRecord;
    }

    /**
     * @param bOperaRecord
     */
    public void setbOperaRecord(String bOperaRecord) {
        this.bOperaRecord = bOperaRecord;
    }
}