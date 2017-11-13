<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
    <title>编辑商品参数</title>
    <jsp:include page="../include/style.jsp"></jsp:include>
    <link rel="stylesheet" href="static/simditor/styles/simditor.css" type="text/css">

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
                    当前商品：${goods.title}
                </div>

            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12">

                        <div class="tpl-block">

                            <div class="am-g">
                                <div class="am-u-sm-12">
                                    <form action="goods/${goods.id}/updatedetail.do" method="post">
                                        <textarea id="editor" name="detail" placeholder="" autofocus>${detail.detail}</textarea>
                                        <button class="am-btn am-btn-primary" >更新商品详情</button>
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
<script src="static/simditor/module.js"></script>
<script src="static/simditor/uploader.js"></script>
<script src="static/simditor/hotkeys.js"></script>
<script src="static/simditor/simditor.js"></script>
<script>
    $(function () {
        /*

                var editor = new Simditor({
                    textarea: $('#editor'),
                    upload:true,
                    defaultImage: 'static/images/default.jpg'
                });
        */

        var editor = new Simditor({
            textarea: $('#editor'),
            defaultImage: 'static/images/default.jpg',
            upload:{
                url:'goods/upload.do',
                fileKey:'file',
                connectionCount:1,
                leaveConfirm:'确认关闭？'
            }
        });

    });

</script>

</body>
</html>
