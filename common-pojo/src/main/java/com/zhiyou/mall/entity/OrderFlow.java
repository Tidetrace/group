package com.zhiyou.mall.entity;
import javax.persistence.*;
@Table(name = "order_flow")
public class OrderFlow {
    /**
     * 订单物流
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_num")
    private String orderNum;

    private String company;

    /**
     * 物流单号
     */
    @Column(name = "flow_num")
    private Integer flowNum;

    @Column(name = "con_name")
    private String conName;

    @Column(name = "con_address")
    private String conAddress;

    /**
     * 邮编
     */
    @Column(name = "con_code")
    private Integer conCode;

    /**
     * 获取订单物流
     *
     * @return id - 订单物流
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单物流
     *
     * @param id 订单物流
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
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取物流单号
     *
     * @return flow_num - 物流单号
     */
    public Integer getFlowNum() {
        return flowNum;
    }

    /**
     * 设置物流单号
     *
     * @param flowNum 物流单号
     */
    public void setFlowNum(Integer flowNum) {
        this.flowNum = flowNum;
    }

    /**
     * @return con_name
     */
    public String getConName() {
        return conName;
    }

    /**
     * @param conName
     */
    public void setConName(String conName) {
        this.conName = conName;
    }

    /**
     * @return con_address
     */
    public String getConAddress() {
        return conAddress;
    }

    /**
     * @param conAddress
     */
    public void setConAddress(String conAddress) {
        this.conAddress = conAddress;
    }

    /**
     * 获取邮编
     *
     * @return con_code - 邮编
     */
    public Integer getConCode() {
        return conCode;
    }

    /**
     * 设置邮编
     *
     * @param conCode 邮编
     */
    public void setConCode(Integer conCode) {
        this.conCode = conCode;
    }
}