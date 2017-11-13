package com.zhiyou.mall.entity;
import javax.persistence.*;
import java.util.Date;

public class News {
    /**
     * 新闻/公告
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类(特惠、公告)(1、特惠  2、公告)
     */
    @Column(name = "news_classes")
    private Integer newsClasses;

    @Column(name = "news_head")
    private String newsHead;

    @Column(name = "news_author")
    private String newsAuthor;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "news_content")
    private String newsContent;

    private Integer state;

    /**
     * 获取新闻/公告
     *
     * @return id - 新闻/公告
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置新闻/公告
     *
     * @param id 新闻/公告
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分类(特惠、公告)(1、特惠  2、公告)
     *
     * @return news_classes - 分类(特惠、公告)(1、特惠  2、公告)
     */
    public Integer getNewsClasses() {
        return newsClasses;
    }

    /**
     * 设置分类(特惠、公告)(1、特惠  2、公告)
     *
     * @param newsClasses 分类(特惠、公告)(1、特惠  2、公告)
     */
    public void setNewsClasses(Integer newsClasses) {
        this.newsClasses = newsClasses;
    }

    /**
     * @return news_head
     */
    public String getNewsHead() {
        return newsHead;
    }

    /**
     * @param newsHead
     */
    public void setNewsHead(String newsHead) {
        this.newsHead = newsHead;
    }

    /**
     * @return news_author
     */
    public String getNewsAuthor() {
        return newsAuthor;
    }

    /**
     * @param newsAuthor
     */
    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
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
     * @return news_content
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * @param newsContent
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
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