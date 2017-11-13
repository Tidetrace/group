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
                    当前商品：${title}
                </div>

            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12">

                        <div class="tpl-block">

                            <div class="am-g">
                                <div class="am-u-sm-12">
                                    <button type="button" class="am-btn am-btn-default am-btn-success" onclick="alert('弹窗显示当前商品分类下的所有模板，然后选择一个');"><span class="am-icon-plus"></span>选择模板</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-success" onclick="showTmpl(3);"><span class="am-icon-plus"></span>简化操作加载模板</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-primary" onclick="saveParam(${id});">保存参数</button>
                                    <div id="tmplDescr">模板介绍信息，选择后更新</div>
                                    <form class="am-form" id="tmplForm">


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

    var tmplId = 0;
    function showTmpl(id) {
        console.log('showtmpl')
        $.get('goodscat/tmpl/'+id+'/info.do',function (result) {
            if(result.success){
                //获取到了，展示
                var tmpl = result.data;
                tmplId = tmpl.id;
                var tmplParam = tmpl.tmplParam;
                //数据库取出来的模板是字符串，需要转json
                console.log(tmplParam);
                $('#tmplDescr').html(tmpl.tmplDescr);
                var root = $.parseJSON(tmplParam);
                console.log(root);
                var parameters = root.root;
                var str = '';
                for(var i=0;i<parameters.length;i++){
                    var s = parameters[i];
                    str+="<div class=\"am-form-group\">\n" +
                        "<label class=\"am-u-sm-3 am-form-label\">"+s+"</label>\n" +
                        "<div class=\"am-u-sm-9\">\n" +
                        "<input type=\"text\" name=\""+s+"\" placeholder=\""+s+"\">\n" +
                        "</div>\n" +
                        "</div>";
                }
                $('#tmplForm').html(str);
            }
        },'json');
    }

    function saveParam(gid) {
        alert('保存商品的模板参数');
        //将参数从form中取出
        var result =new Object();
        var arr = new Array();

        $('#tmplForm :input').each(function (i) {
            console.log($(this));
            var o = {k:$(this).attr('name'),v:$(this).val()};
            arr.push(o);
        });
        result.root=arr;
        console.log(result);
        var str = JSON.stringify(result);
        //ajax提交
        $.post('goods/uparam.do',{id:gid,tmplid:tmplId,params:str},function (result) {
            console.log(result);
        },'json');
    }
</script>

</body>
</html>
