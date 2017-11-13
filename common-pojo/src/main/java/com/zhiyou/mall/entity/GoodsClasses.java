package com.zhiyou.mall.entity;
import javax.persistence.*;
@Table(name = "goods_classes")
public class GoodsClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rank;

    @Column(name = "classes_name")
    private String classesName;

    private String introduction;

    /**
     *
     */
    private Integer orders;
    private Integer sort;

    /**
     * 父级id和主id关联，主要是显示级别,0，一级，2，二级
     */
    @Column(name = "parent_id")
    private Integer parentId;

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
     * @return rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @param rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * @return classes_name
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * @param classesName
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取1，时间，2距离，3性价比等
     *
     * @return order - 1，时间，2距离，3性价比等
     */
    public Integer getSort() {
        return sort;}
    public Integer getOrders() {
        return orders;}

    /**
     *
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;}

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * 获取父级id和主id关联，主要是显示级别,0，一级，2，二级
     *
     * @return parent_id - 父级id和主id关联，主要是显示级别,0，一级，2，二级
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父级id和主id关联，主要是显示级别,0，一级，2，二级
     *
     * @param parentId 父级id和主id关联，主要是显示级别,0，一级，2，二级
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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