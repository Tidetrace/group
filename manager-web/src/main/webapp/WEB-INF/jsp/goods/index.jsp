<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  User: zhouyanchao
  Date: 2017/11/4
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${BaseContext}">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品信息示例</title>
    <jsp:include page="../include/style.jsp"></jsp:include>

</head>
<body>

<jsp:include page="../include/header.jsp"></jsp:include>

<div class="tpl-page-container tpl-page-header-fixed">
    <jsp:include page="../include/menu.jsp"></jsp:include>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            商品信息查看
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">分类</a></li>
            <li class="am-active">内容</li>
        </ol>

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    商品信息规格参数
                </div>

            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12">

                        <div class="tpl-block">
                            <div class="am-g">
                                <div class="am-u-sm-12 am-u-md-6">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success" onclick="addTmpl();"><span class="am-icon-plus"></span> 新增</button>
                                            <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                            <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="am-g">
                                <div class="am-u-sm-12">
                                    <form class="am-form">
                                        <table class="am-table am-table-striped am-table-hover table-main">
                                            <thead>
                                            <tr>
                                                <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                                <th class="table-id">序号</th>
                                                <th class="table-title">名称</th>
                                                <th class="table-cell">价格</th>
                                                <th class="table-cell">更新时间</th>
                                                <th class="table-cell">更新人</th>
                                                <th class="table-set">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty results}">
                                                <c:forEach items="${results}" varStatus="i" var="s">
                                                    <tr>
                                                        <td><input type="checkbox"></td>
                                                        <td>${i.count}</td>
                                                        <td><a href="javascript:void(0);" title="点击查看商品详情">${s.title}</a></td>
                                                        <td>${s.price}</td>
                                                        <td><fmt:formatDate value="${s.updateTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                                        <td>${s.updateUser}</td>
                                                        <td>
                                                            <div class="am-btn-toolbar">
                                                                <div class="am-btn-group am-btn-group-xs">
                                                                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick=""><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                                                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="editTmpl(${s.id});"><span class="am-icon-pencil-square-o"></span> 编辑参数</button>
                                                                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="showDetail(${s.id});"><span class="am-icon-pencil-square-o"></span> 编辑详情</button>
                                                                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="deleteTmpl(${s.id});"><span class="am-icon-trash-o"></span> 删除</button>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>

                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>


    </div>
</div>



<jsp:include page="../include/script.jsp"></jsp:include>
<script>
    $(function () {

    });
    function editTmpl(gid) {
        window.location.href='goods/editparam.do?id='+gid;
    }

    function showDetail(gid) {
        window.location.href="goods/"+gid+"/detail.do";
    }
</script>
</body>
</html>
