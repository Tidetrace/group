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
                <ul class="am-list am-list-border">
                    <c:forEach items="${bResources}" var="bResources">

                        <li><a href="bResource/selectById/${bResources.id}.do"><i class="am-icon-pencil am-icon-fw"
                                                                                  style="padding-left:5%;padding-right: 3%"></i><span>权限名称：</span><span>${bResources.resourceName}</span></a>
                            <button type="button" class="am-btn am-btn-warning am-round"
                                    style="float: right;margin-top: -45px;margin-right: 50px;" onclick="dele(${bResources.id})">删除
                            </button>
                            <button type="button" class="am-btn am-btn-secondary am-round"
                                    data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 800, height:380}"
                                    style="float: right;margin-top: -45px;margin-right: 120px;">新增
                            </button>
                        </li>
                    </c:forEach>
                </ul>
                <%--分页显示--%>
                <ul class="am-pagination tpl-pagination">
                    <c:if test="${pageNum.hasPreviousPage}">
                        <li><a href="bResource/index.do?pageNum=${pageNum.firstPage}">first</a></li>
                        <li><a href="bResource/index.do?pageNum=${pageNum.prePage}">«</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${pageNum.pages}" step="1" var="num">
                        <c:if test="${pageNum.pageNum == num }">${num}</c:if>
                        <c:if test="${pageNum.pageNum != num }">
                            <li><a href="bResource/index.do?pageNum=${num }">${num }</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageNum.hasNextPage}">
                        <li><a href="bResource/index.do?pageNum=${pageNum.nextPage}">»</a></li>
                        <li><a href="bResource/index.do?pageNum=${pageNum.lastPage}">end</a></li>

                    </c:if>
                    &nbsp;&nbsp;&nbsp;&nbsp;总${pageNum.total}条&nbsp;&nbsp;${pageNum.pageNum}/${pageNum.pages}页
                </ul>

            </div>
        </div>
    </div>
</div>
<%--模态窗口--%>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
    <div class="am-modal-dialog">
        <form action="" class="am-form">
            <fieldset>
                <legend>权限更新</legend>
                <div class="am-form-group">
                    <label style="float: left;margin-left: 2%">权限名称：</label>
                    <input type="text" id="resourceName" name="resourceName" minlength="3" placeholder="输入权限名称"
                           class="am-form-field" required/>
                    <label style="float: left;margin-left: 2%">权限URL：</label>
                    <input type="text" id="resourceUrl" name="resourceUrl" minlength="3" placeholder="输入权限的URl"
                           class="am-form-field" required/>
                    <label style="float: left;margin-left: 2%">状态：</label>
                        <div class="am-u-sm-9">
                            <div class="tpl-switch">
                                <input type="hidden" name="enable" id="enable" value="">
                                <input type="checkbox" value="0" name="state" id="state"
                                       class="ios-switch bigswitch tpl-switch-btn"/>
                                <div class="tpl-switch-btn-view">
                                    <div>
                                    </div>
                                </div>
                            </div>
                            <button type="button" class="am-btn am-btn-success" id="insert">添加</button>
                            <button type="button" class="am-btn am-btn-success" id="closeModel2">返回</button>
                        </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/include/script.jsp"/>
<%--amazeui的脚本--%>
<script>
    $('#closeModel2').click(function () {
        $('#doc-modal-1').modal('close');
    })
    $('#insert').click(function () {
        if ($("#state").is(':checked')) {
            $('#enable').val("1");
        } else {
            $('#enable').val("0");
        }
        $.post('bResource/insertBR.do', {
            resourceName: $('#resourceName').val(),
            resourceUrl: $('#resourceUrl').val(),
            enable:$('#enable').val()
        }, function (result) {
               if(result>0){
                   location.href="bResource/index.do";
                   $('#doc-modal-1').modal('close');
               }else{
                   alert("修改失败！")
               }
        }, 'json');
    });
    function dele(id) {
        $.get('bResource/deletBR.do',{id:id},function (result) {
           if(result>0){
               alert("删除成功")
               location.href="bResource/index.do";
           }else{
               alert("修改失败！")
           }
        }, 'json');
    }
</script>
</body>
</html>