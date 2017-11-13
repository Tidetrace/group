package com.zhiyou.mall.entity;
import javax.persistence.*;
@Table(name = "goods_label")
public class GoodsLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类id(最后一层分类)
     */
    @Column(name = "gclasses_id")
    private Integer gclassesId;

    private Integer state;

    private String labelDesc;

    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc;
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
     * 获取分类id(最后一层分类)
     *
     * @return gclasses_id - 分类id(最后一层分类)
     */
    public Integer getGclassesId() {
        return gclassesId;
    }

    /**
     * 设置分类id(最后一层分类)
     *
     * @param gclassesId 分类id(最后一层分类)
     */
    public void setGclassesId(Integer gclassesId) {
        this.gclassesId = gclassesId;
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