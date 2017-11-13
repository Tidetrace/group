package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

@Table(name = "goods_info")
public class GoodsInfo {
    /**
     * 商品详情信息
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "good_uuid")
    private String goodUuid;

    /**
     * 商品详情(text)
     */
    @Column(name = "ginfo_detail")
    private String ginfoDetail;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取商品详情信息
     *
     * @return id - 商品详情信息
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品详情信息
     *
     * @param id 商品详情信息
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取商品详情(text)
     *
     * @return ginfo_detail - 商品详情(text)
     */
    public String getGinfoDetail() {
        return ginfoDetail;
    }

    /**
     * 设置商品详情(text)
     *
     * @param ginfoDetail 商品详情(text)
     */
    public void setGinfoDetail(String ginfoDetail) {
        this.ginfoDetail = ginfoDetail;
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
}