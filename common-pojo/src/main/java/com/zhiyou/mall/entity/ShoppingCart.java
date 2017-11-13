package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "shopping_cart")
public class ShoppingCart {
    /**
     * 购物车
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "good_uuid")
    private String goodUuid;

    @Column(name = "good_price")
    private Double goodPrice;

    @Column(name = "create_time")
    private Date createTime;

    private Integer number;

    //与商品的对应关系(1对多)
    @Transient
    private List<Good> good;
    //与商品的对应关系
    public List<Good> getGood() {
        return good;
    }
    public void setGood(List<Good> good) {
        this.good = good;
    }

    /**
     * 获取购物车
     *
     * @return id - 购物车
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置购物车
     *
     * @param id 购物车
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
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}