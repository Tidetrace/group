package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

public class Order {
    /**
     * 订单
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_num")
    private String orderNum;

    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 商品总数量
     */
    @Column(name = "good_count")
    private Integer goodCount;

    /**
     * 总价格
     */
    @Column(name = "all_price")
    private Double allPrice;

    @Column(name = "pay_price")
    private Double payPrice;

    private Integer state;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 付款时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 发货时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 交易完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 交易关闭时间
     */
    @Column(name = "over_time")
    private Date overTime;

    /**
     * 买家留言
     */
    @Column(name = "leave_word")
    private String leaveWord;

    /**
     * 获取订单
     *
     * @return id - 订单
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单
     *
     * @param id 订单
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
     * 获取商品总数量
     *
     * @return good_count - 商品总数量
     */
    public Integer getGoodCount() {
        return goodCount;
    }

    /**
     * 设置商品总数量
     *
     * @param goodCount 商品总数量
     */
    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    /**
     * 获取总价格
     *
     * @return all_price - 总价格
     */
    public Double getAllPrice() {
        return allPrice;
    }

    /**
     * 设置总价格
     *
     * @param allPrice 总价格
     */
    public void setAllPrice(Double allPrice) {
        this.allPrice = allPrice;
    }

    /**
     * @return pay_price
     */
    public Double getPayPrice() {
        return payPrice;
    }

    /**
     * @param payPrice
     */
    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
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

    /**
     * 获取付款时间
     *
     * @return pay_time - 付款时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置付款时间
     *
     * @param payTime 付款时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间
     *
     * @return send_time - 发货时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发货时间
     *
     * @param sendTime 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取交易完成时间
     *
     * @return finish_time - 交易完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置交易完成时间
     *
     * @param finishTime 交易完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取交易关闭时间
     *
     * @return over_time - 交易关闭时间
     */
    public Date getOverTime() {
        return overTime;
    }

    /**
     * 设置交易关闭时间
     *
     * @param overTime 交易关闭时间
     */
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    /**
     * 获取买家留言
     *
     * @return leave_word - 买家留言
     */
    public String getLeaveWord() {
        return leaveWord;
    }

    /**
     * 设置买家留言
     *
     * @param leaveWord 买家留言
     */
    public void setLeaveWord(String leaveWord) {
        this.leaveWord = leaveWord;
    }
}