package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

@Table(name = "order_state_record")
public class OrderStateRecord {
    /**
     * 订单状态更新记录
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_num")
    private String orderNum;

    /**
     * 最新状态
     */
    @Column(name = "new_state")
    private Integer newState;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 说明信息
     */
    @Column(name = "explain_info")
    private String explainInfo;

    /**
     * 获取订单状态更新记录
     *
     * @return id - 订单状态更新记录
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单状态更新记录
     *
     * @param id 订单状态更新记录
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
     * 获取最新状态
     *
     * @return new_state - 最新状态
     */
    public Integer getNewState() {
        return newState;
    }

    /**
     * 设置最新状态
     *
     * @param newState 最新状态
     */
    public void setNewState(Integer newState) {
        this.newState = newState;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取说明信息
     *
     * @return explain_info - 说明信息
     */
    public String getExplainInfo() {
        return explainInfo;
    }

    /**
     * 设置说明信息
     *
     * @param explainInfo 说明信息
     */
    public void setExplainInfo(String explainInfo) {
        this.explainInfo = explainInfo;
    }
}