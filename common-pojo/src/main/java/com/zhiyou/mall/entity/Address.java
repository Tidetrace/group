package com.zhiyou.mall.entity;

import java.util.Date;
import javax.persistence.*;
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uuid")
    private String userUuid;

    private String province;

    private String city;

    private String country;

    @Column(name = "detail_address")
    private String detailAddress;

    /**
     * 邮编
     */
    @Column(name = "postal_code")
    private String postalCode;

    /**
     * 0，否，1，是
     */
    @Column(name = "default_address")
    private Integer defaultAddress;

    @Column(name = "create_time")
    private Date createTime;

    private Integer state;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
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
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return detail_address
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * @param detailAddress
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    /**
     * 获取邮编
     *
     * @return postal_code - 邮编
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 设置邮编
     *
     * @param postalCode 邮编
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 获取0，否，1，是
     *
     * @return default_address - 0，否，1，是
     */
    public Integer getDefaultAddress() {
        return defaultAddress;
    }

    /**
     * 设置0，否，1，是
     *
     * @param defaultAddress 0，否，1，是
     */
    public void setDefaultAddress(Integer defaultAddress) {
        this.defaultAddress = defaultAddress;
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