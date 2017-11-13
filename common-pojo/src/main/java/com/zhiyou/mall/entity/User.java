package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_telephone")
    private String userTelephone;

    private String email;

    private Integer sex;

    private Date birthday;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "user_image_url")
    private String userImageUrl;
    @Column(name = "user_rolename")
    private String userRolename;

    private Integer state;

    private String captcha;

    public String getUserRolename() {
        return userRolename;
    }

    public void setUserRolename(String userRolename) {
        this.userRolename = userRolename;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

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
     * @return user_nickname
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * @param userNickname
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * @return user_telephone
     */
    public String getUserTelephone() {
        return userTelephone;
    }

    /**
     * @param userTelephone
     */
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
     * @return user_image_url
     */
    public String getUserImageUrl() {
        return userImageUrl;
    }

    /**
     * @param userImageUrl
     */
    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
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