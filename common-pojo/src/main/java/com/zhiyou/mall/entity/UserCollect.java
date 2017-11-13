package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

@Table(name = "user_collect")
public class UserCollect {
    /**
     * 用户收藏
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "good_uuid")
    private Integer goodUuid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "goods_price")
    private Double goodsPrice;

    private Integer state;

    /**
     * 获取用户收藏
     *
     * @return id - 用户收藏
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户收藏
     *
     * @param id 用户收藏
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
    public Integer getGoodUuid() {
        return goodUuid;
    }

    /**
     * @param goodUuid
     */
    public void setGoodUuid(Integer goodUuid) {
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
     * @return goods_price
     */
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * @param goodsPrice
     */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
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