<%--
  Creator by Tidetrace on 2017/11/9 11:13
  Description：
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>权限管理</title>
    <base href="${BaseContext}">
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <%--引用页面样式--%>
    <link rel="stylesheet" href="static/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css"/>
    <jsp:include page="/WEB-INF/jsp/include/style.jsp"/>
</head>


<body data-type="generalComponents">

<jsp:include page="/WEB-INF/jsp/include/header.jsp"/>
<div class="tpl-page-container tpl-page-header-fixed">
    <jsp:include page="/WEB-INF/jsp/include/menu.jsp"/>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            权限管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">基本信息管理</a></li>
            <li class="am-active">权限管理</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 列表
                </div>
            </div>


            <div class="tpl-block">

                <div class="am-g">
                    <div class="tpl-form-body tpl-form-line">
                        <form class="am-form tpl-form-line-form" id="u_form">
                            <input type="hidden" value="${bResource.id}" name="id">
                            <input type="hidden" value="${bResource.enable}" name="enable" id="enable">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">上次修改人 <span
                                        class="tpl-form-line-small-title">creater</span></label>
                                <div class="am-u-sm-9">
                                    <input type="text" disabled class="tpl-form-input" id="user-name" name="creater"
                                           value="${bResource.creater}" placeholder="请输入标题文字">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">创建时间 <span
                                        class="tpl-form-line-small-title">Time</span></label>
                                <div class="am-u-sm-9">
                                    <input type="text" disabled class="tpl-form-input" placeholder="创建时间"
                                           data-am-datepicker=""
                                           value="<fmt:formatDate value="${bResource.createTime}" pattern="yyyy-MM-dd HH:ss:dd"/>"
                                           readonly/>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">权限名称 <span class="tpl-form-line-small-title">authority</span></label>
                                <div class="am-u-sm-9">
                                    <input type="text" name="resourceName" value="${bResource.resourceName}"
                                           placeholder="input authority">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">权限URL <span
                                        class="tpl-form-line-small-title">url</span></label>
                                <div class="am-u-sm-9">
                                    <input type="text" name="resourceUrl" value="${bResource.resourceUrl}"
                                           placeholder="input authority_url">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">状态</label>
                                <div class="am-u-sm-9">
                                    <div class="tpl-switch">
                                        <input type="checkbox" value="0" name="state" id="state"
                                               class="ios-switch bigswitch tpl-switch-btn"/>
                                        <div class="tpl-switch-btn-view">
                                            <div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="button" onclick="check()"
                                            class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/include/script.jsp"/>
</body>
<script>
    $(function () {
        if (${bResource.enable==1}) {
            $("#state").attr("checked", true);
        }
    });

    function check() {
        if ($("#state").is(':checked')) {
            $('#enable').val("1");
        } else {
            $('#enable').val("0");
        }
        $.post('bResource/updateById.do', $('#u_form').serialize(), function (result) {
            if (result>0) {
                alert("修改成功")
                window.location.href="bResource/index.do"
            } else {
                alert("修改失败")
            }
        },'json');
    }
</script>
</html>