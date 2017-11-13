package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

@Table(name = "goods_param")
public class GoodsParam {
    /**
     * 商品参数表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "good_uuid")
    private String goodUuid;

    /**
     * 参数模板id
     */
    @Column(name = "gcpart_id")
    private Integer gcpartId;

    /**
     * 参数内容(json)
     */
    @Column(name = "gparam_content")
    private String gparamContent;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取商品参数表
     *
     * @return id - 商品参数表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品参数表
     *
     * @param id 商品参数表
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
     * 获取参数模板id
     *
     * @return gcpart_id - 参数模板id
     */
    public Integer getGcpartId() {
        return gcpartId;
    }

    /**
     * 设置参数模板id
     *
     * @param gcpartId 参数模板id
     */
    public void setGcpartId(Integer gcpartId) {
        this.gcpartId = gcpartId;
    }

    /**
     * 获取参数内容(json)
     *
     * @return gparam_content - 参数内容(json)
     */
    public String getGparamContent() {
        return gparamContent;
    }

    /**
     * 设置参数内容(json)
     *
     * @param gparamContent 参数内容(json)
     */
    public void setGparamContent(String gparamContent) {
        this.gparamContent = gparamContent;
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