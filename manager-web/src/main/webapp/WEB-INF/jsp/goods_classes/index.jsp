<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/3
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${BaseContext}">
    <title>商品分类树状图</title>
    <jsp:include page="../include/script.jsp"></jsp:include>
    <jsp:include page="../include/style.jsp"></jsp:include>
</head>
<body>
<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree">
            <a href="goodClasses/show.do">商品分类树状图</a>
        </ul>
    </div>
    <div class="zTreeDemoBackground right" id="rightShow">

    </div>


</div>
</body>
</html>
