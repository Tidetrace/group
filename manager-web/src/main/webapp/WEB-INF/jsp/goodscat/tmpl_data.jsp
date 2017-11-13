<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  User: zhouyanchao
  Date: 2017/11/3
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

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
                        <th class="table-title">标题</th>
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
                                <td><a href="javascript:void(0);" onclick="showTmpl(${s.id});" title="点击查看模板详情">${s.tmplDescr}</a></td>
                                <td><fmt:formatDate value="${s.updateTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                <td>${s.updateUser}</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="editTmpl(${s.id});"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                            <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick="copyTmpl(${s.id});"><span class="am-icon-copy"></span> 复制</button>
                                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="deleteTmpl(${s.id});"><span class="am-icon-trash-o"></span> 删除</button>
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
