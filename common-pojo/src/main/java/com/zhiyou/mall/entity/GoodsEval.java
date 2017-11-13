package com.zhiyou.mall.entity;
import javax.persistence.*;
@Table(name = "goods_eval")
public class GoodsEval {
    /**
     * 商品评价
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_num")
    private String orderNum;

    @Column(name = "goods_num")
    private String goodsNum;

    /**
     * 评分
     */
    private Double grade;

    /**
     * 评价内容
     */
    @Column(name = "geval_content")
    private String gevalContent;

    @Column(name = "geval_img")
    private String gevalImg;

    private String state;

    /**
     * 评价人昵称
     */
    @Column(name = "geval_nickname")
    private String gevalNickname;

    /**
     * 评价人uuid
     */
    @Column(name = "geval_uuid")
    private String gevalUuid;

    /**
     * 获取商品评价
     *
     * @return id - 商品评价
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品评价
     *
     * @param id 商品评价
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
     * @return goods_num
     */
    public String getGoodsNum() {
        return goodsNum;
    }

    /**
     * @param goodsNum
     */
    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 获取评分
     *
     * @return grade - 评分
     */
    public Double getGrade() {
        return grade;
    }

    /**
     * 设置评分
     *
     * @param grade 评分
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    /**
     * 获取评价内容
     *
     * @return geval_content - 评价内容
     */
    public String getGevalContent() {
        return gevalContent;
    }

    /**
     * 设置评价内容
     *
     * @param gevalContent 评价内容
     */
    public void setGevalContent(String gevalContent) {
        this.gevalContent = gevalContent;
    }

    /**
     * @return geval_img
     */
    public String getGevalImg() {
        return gevalImg;
    }

    /**
     * @param gevalImg
     */
    public void setGevalImg(String gevalImg) {
        this.gevalImg = gevalImg;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取评价人昵称
     *
     * @return geval_nickname - 评价人昵称
     */
    public String getGevalNickname() {
        return gevalNickname;
    }

    /**
     * 设置评价人昵称
     *
     * @param gevalNickname 评价人昵称
     */
    public void setGevalNickname(String gevalNickname) {
        this.gevalNickname = gevalNickname;
    }

    /**
     * 获取评价人uuid
     *
     * @return geval_uuid - 评价人uuid
     */
    public String getGevalUuid() {
        return gevalUuid;
    }

    /**
     * 设置评价人uuid
     *
     * @param gevalUuid 评价人uuid
     */
    public void setGevalUuid(String gevalUuid) {
        this.gevalUuid = gevalUuid;
    }
}