<%--
  User: zhouyanchao
  Date: 2017/11/2
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<div class="tpl-left-nav tpl-left-nav-hover">
    <div class="tpl-left-nav-title">
        功能菜单
    </div>
    <div class="tpl-left-nav-list">
        <ul class="tpl-left-nav-menu">
            <li class="tpl-left-nav-item">
                <a href="index.html" class="nav-link">
                    <i class="am-icon-home"></i>
                    <span>首页</span>
                </a>
            </li>

            <li class="tpl-left-nav-item">
                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-table"></i>
                    <span>商品信息</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu">
                    <li>
                        <a href="goodClasses/show.do">
                            <i class="am-icon-angle-right"></i>
                            <span>ztree分类管理</span>
                        </a>

                        <a href="goodscat/index.do">
                            <i class="am-icon-angle-right"></i>
                            <span>商品分类管理</span>
                        </a>

                        <a href="goodClassesPart/show.do">
                            <i class="am-icon-angle-right"></i>
                            <span>商品规格参数模板</span>
                        </a>

                        <a href="goods/index.do">
                            <i class="am-icon-angle-right"></i>
                            <span>商品信息</span>
                        </a>

                    </li>
                </ul>
            </li>
            <li class="tpl-left-nav-item">
                <a href="order/index.do" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-sticky-note"></i>
                    <span>订单管理</span>
                </a>
            </li>
            <li class="tpl-left-nav-item">
                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-wpforms"></i>
                    <span>基本信息管理</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu">
                    <li>
                        <a href="form-amazeui.html">
                            <i class="am-icon-angle-right"></i>
                            <span>用户管理</span>
                            <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                        </a>

                        <a href="form-line.html">
                            <i class="am-icon-angle-right"></i>
                            <span>角色管理</span>
                        </a>
                        <a href="bResource/index.do">
                            <i class="am-icon-angle-right"></i>
                            <span>权限管理</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="tpl-left-nav-item">
                <a href="http://192.168.13.249:8080/manager/shoppingCart/index/000000.do" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-key"></i>
                    <span>退出</span>
                </a>
            </li>
        </ul>
    </div>
</div>


