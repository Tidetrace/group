package com.zhiyou.mall.entity;

import javax.persistence.*;
import java.util.Date;

public class Good {
    /**
     * 商品基本信息表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "good_uuid")
    private String goodUuid;

    @Column(name = "good_head")
    private String goodHead;

    @Column(name = "good_desc")
    private String goodDesc;

    /**
     * 库存量
     */
    @Column(name = "good_number")
    private Integer goodNumber;

    @Column(name = "good_price")
    private Double goodPrice;
    private Integer state;
    @Column(name = "create_time")
    private Date createTime;

    //新添加的字段
    private String goodImg;
    @Column(name = "g_class_id")
    private Integer gClassId;
    @Column(name = "good_mid_img")
    private String goodMidImg; //商品小图
    @Column(name = "good_big_img")
    private String goodBigImg; //商品大图
    @Column(name = "express_fee")
    private Double expressFee;//快递费用
    @Column(name = "good_detail_img")
    private String goodDetailImg; //商品信息详情图
    //与商品分类多对一
    @Transient
    private GoodsClasses goodsClasses;

    public GoodsClasses getGoodsClasses() {
        return goodsClasses;
    }

    public void setGoodsClasses(GoodsClasses goodsClasses) {
        this.goodsClasses = goodsClasses;
    }

    public Double getGoodSales() {
        return goodSales;
    }

    public Integer getgClassId() {
        return gClassId;
    }

    public void setgClassId(Integer gClassId) {
        this.gClassId = gClassId;
    }

    public String getGoodMidImg() {
        return goodMidImg;
    }

    public void setGoodMidImg(String goodMidImg) {
        this.goodMidImg = goodMidImg;
    }

    public String getGoodBigImg() {
        return goodBigImg;
    }

    public void setGoodBigImg(String goodBigImg) {
        this.goodBigImg = goodBigImg;
    }

    public double getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(double expressFee) {
        this.expressFee = expressFee;
    }

    public String getGoodDetailImg() {
        return goodDetailImg;
    }

    public void setGoodDetailImg(String goodDetailImg) {
        this.goodDetailImg = goodDetailImg;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    @Column(name = "good_sales")
    private Double goodSales;

    //集合属性
    @Transient
    private GoodsClassesPart goodsClassesPart;//和参数模板是一对一的关系

    public GoodsClassesPart getGoodsClassesPart() {
        return goodsClassesPart;
    }

    public void setGoodsClassesPart(GoodsClassesPart goodsClassesPart) {
        this.goodsClassesPart = goodsClassesPart;
    }

    public void setExpressFee(Double expressFee) {
        this.expressFee = expressFee;
    }

    public void setGoodSales(Double goodSales) {
        this.goodSales = goodSales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
     * @return good_head
     */
    public String getGoodHead() {
        return goodHead;
    }

    /**
     * @param goodHead
     */
    public void setGoodHead(String goodHead) {
        this.goodHead = goodHead;
    }

    /**
     * @return good_desc
     */
    public String getGoodDesc() {
        return goodDesc;
    }

    /**
     * @param goodDesc
     */
    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc;
    }

    /**
     * 获取库存量
     *
     * @return good_number - 库存量
     */
    public Integer getGoodNumber() {
        return goodNumber;
    }

    /**
     * 设置库存量
     *
     * @param goodNumber 库存量
     */
    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    /**
     * @return good_price
     */
    public Double getGoodPrice() {
        return goodPrice;
    }

    /**
     * @param goodPrice
     */
    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
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


}