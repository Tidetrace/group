package com.zhiyou.mall.entity;

import java.util.Date;
import javax.persistence.*;
public class Captcha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 验证码类别(短信/邮件)(1、短信2、邮件)
     */
    @Column(name = "captcha_class")
    private Integer captchaClass;

    /**
     * 验证码功能(注册、修改密码等)
     */
    @Column(name = "captcha_function")
    private Integer captchaFunction;

    private String captcha;

    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 失效时间
     */
    @Column(name = "over_time")
    private Date overTime;

    /**
     * 1,2,3
     */
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
     * 获取验证码类别(短信/邮件)(1、短信2、邮件)
     *
     * @return captcha_class - 验证码类别(短信/邮件)(1、短信2、邮件)
     */
    public Integer getCaptchaClass() {
        return captchaClass;
    }

    /**
     * 设置验证码类别(短信/邮件)(1、短信2、邮件)
     *
     * @param captchaClass 验证码类别(短信/邮件)(1、短信2、邮件)
     */
    public void setCaptchaClass(Integer captchaClass) {
        this.captchaClass = captchaClass;
    }

    /**
     * 获取验证码功能(注册、修改密码等)
     *
     * @return captcha_function - 验证码功能(注册、修改密码等)
     */
    public Integer getCaptchaFunction() {
        return captchaFunction;
    }

    /**
     * 设置验证码功能(注册、修改密码等)
     *
     * @param captchaFunction 验证码功能(注册、修改密码等)
     */
    public void setCaptchaFunction(Integer captchaFunction) {
        this.captchaFunction = captchaFunction;
    }

    /**
     * @return captcha
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * @param captcha
     */
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    /**
     * @return send_time
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取失效时间
     *
     * @return over_time - 失效时间
     */
    public Date getOverTime() {
        return overTime;
    }

    /**
     * 设置失效时间
     *
     * @param overTime 失效时间
     */
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    /**
     * 获取1,2,3
     *
     * @return state - 1,2,3
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1,2,3
     *
     * @param state 1,2,3
     */
    public void setState(Integer state) {
        this.state = state;
    }
}