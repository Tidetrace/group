package com.zhiyou.mall.entity;
import javax.persistence.*;
@Table(name = "order_info")
public class OrderInfo {
    /**
     * 订单详情
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_num")
    private String orderNum;

    @Column(name = "good_uuid")
    private String goodUuid;

    @Column(name = "good_head")
    private String goodHead;

    /**
     * 商品主图
     */
    @Column(name = "good_img")
    private String goodImg;

    @Column(name = "good_price")
    private Double goodPrice;

    /**
     * 购买数量
     */
    private Integer count;

    /**
     * 总金额
     */
    @Column(name = "all_price")
    private Double allPrice;

    /**
     * 获取订单详情
     *
     * @return id - 订单详情
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单详情
     *
     * @param id 订单详情
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return order_num
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * @param orderNum
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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
     * 获取商品主图
     *
     * @return good_img - 商品主图
     */
    public String getGoodImg() {
        return goodImg;
    }

    /**
     * 设置商品主图
     *
     * @param goodImg 商品主图
     */
    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
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
     * 获取购买数量
     *
     * @return count - 购买数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置购买数量
     *
     * @param count 购买数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取总金额
     *
     * @return all_price - 总金额
     */
    public Double getAllPrice() {
        return allPrice;
    }

    /**
     * 设置总金额
     *
     * @param allPrice 总金额
     */
    public void setAllPrice(Double allPrice) {
        this.allPrice = allPrice;
    }
}