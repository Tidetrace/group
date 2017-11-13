package com.zhiyou.mall.entity;

import java.util.Date;
import javax.persistence.*;
@Table(name = "first_advert")
public class FirstAdvert {
    /**
     * 首页广告
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fadvert_head")
    private String fadvertHead;

    @Column(name = "fadvert_img")
    private String fadvertImg;

    private Integer sort;
    private Integer orders;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "over_time")
    private Date overTime;

    private Integer state;

    /**
     * 获取首页广告
     *
     * @return id - 首页广告
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置首页广告
     *
     * @param id 首页广告
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return fadvert_head
     */
    public String getFadvertHead() {
        return fadvertHead;
    }

    /**
     * @param fadvertHead
     */
    public void setFadvertHead(String fadvertHead) {
        this.fadvertHead = fadvertHead;
    }

    /**
     * @return fadvert_img
     */
    public String getFadvertImg() {
        return fadvertImg;
    }

    /**
     * @param fadvertImg
     */
    public void setFadvertImg(String fadvertImg) {
        this.fadvertImg = fadvertImg;
    }

    /**
     * @return order
     */
  

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return over_time
     */
    public Date getOverTime() {
        return overTime;
    }

    /**
     * @param overTime
     */
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
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