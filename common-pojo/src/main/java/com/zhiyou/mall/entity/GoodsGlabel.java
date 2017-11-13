package com.zhiyou.mall.entity;
import javax.persistence.*;
@Table(name = "goods_glabel")
public class GoodsGlabel {
    /**
     * 商品标签关联
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标签id
     */
    @Column(name = "glabel_id")
    private Integer glabelId;

    /**
     * 获取商品标签关联
     *
     * @return id - 商品标签关联
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品标签关联
     *
     * @param id 商品标签关联
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标签id
     *
     * @return glabel_id - 标签id
     */
    public Integer getGlabelId() {
        return glabelId;
    }

    /**
     * 设置标签id
     *
     * @param glabelId 标签id
     */
    public void setGlabelId(Integer glabelId) {
        this.glabelId = glabelId;
    }
}