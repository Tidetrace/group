package com.zhiyou.mall.entity;

import java.util.Date;
import javax.persistence.*;
@Table(name = "goods_classes_part")
public class GoodsClassesPart {
    /**
     * 商品分类参数模板
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类id(最后一级分类)
     */
    @Column(name = "gclasses_id")
    private Integer gclassesId;

    /**
     * 模板内容(json格式)
     */
    @Column(name = "gcpart_content")
    private String gcpartContent;

    /**
     * 模板说明
     */
    @Column(name = "gcpart_explain")
    private String gcpartExplain;

    @Column(name = "create_time")
    private Date createTime;

    private Integer state;

    /**
     * 获取商品分类参数模板
     *
     * @return id - 商品分类参数模板
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品分类参数模板
     *
     * @param id 商品分类参数模板
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分类id(最后一级分类)
     *
     * @return gclasses_id - 分类id(最后一级分类)
     */
    public Integer getGclassesId() {
        return gclassesId;
    }

    /**
     * 设置分类id(最后一级分类)
     *
     * @param gclassesId 分类id(最后一级分类)
     */
    public void setGclassesId(Integer gclassesId) {
        this.gclassesId = gclassesId;
    }

    /**
     * 获取模板内容(json格式)
     *
     * @return gcpart_content - 模板内容(json格式)
     */
    public String getGcpartContent() {
        return gcpartContent;
    }

    /**
     * 设置模板内容(json格式)
     *
     * @param gcpartContent 模板内容(json格式)
     */
    public void setGcpartContent(String gcpartContent) {
        this.gcpartContent = gcpartContent;
    }

    /**
     * 获取模板说明
     *
     * @return gcpart_explain - 模板说明
     */
    public String getGcpartExplain() {
        return gcpartExplain;
    }

    /**
     * 设置模板说明
     *
     * @param gcpartExplain 模板说明
     */
    public void setGcpartExplain(String gcpartExplain) {
        this.gcpartExplain = gcpartExplain;
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