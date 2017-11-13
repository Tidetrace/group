<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
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
            商品分类
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">商品分类</a></li>
            <li class="am-active">分类管理</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code">商品分类参数模板</span>
                </div>
            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-2">
                        <div  id="tree" class="ztree"></div>
                    </div>
                    <div class="am-u-sm-10">
                        <div  id="part_data"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<div class="tpl-alert">
    <%--模态窗口--%>
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="your-modal">
        <div class="am-modal-dialog">
            <div class="am-modal-hd"><label style="color: red;font-weight: bold">分类模板查看</label>
                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <div class="am-modal-bd am-alert-warning" style="font-size: 18px"  id="showPartContent">
            </div>
        </div>
    </div>

    <div class="am-modal am-modal-alert" tabindex="-1" id="my-modal">
        <div class="am-modal-dialog">
            <div class="am-modal-hd"><label style="color: red;font-weight: bold">分类模板查看</label>
            </div>
            <input type="hidden" id="classId">
            <form class="am-form tpl-form-line-form" id="editPartForm">
                <input type="hidden" id="editId" name="editPartId">
                <div id="contentNow" style="font-size: 20px;color: #010407"></div>
                <div class="am-modal-bd" style="font-size: 20px;color: #010407"  id="PartContent">
                </div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn" id="sp1">确定</span>
                    <span class="am-modal-btn" id="sp2">取消</span>
                </div>
            </form>
        </div>
    </div>

    <div class="am-modal am-modal-alert" tabindex="-1" id="add-modal">
        <div class="am-modal-dialog">
            <div class="am-modal-hd"><label style="color: red;font-weight: bold">分类模板添加</label>
            </div>
            <div class="am-modal-bd">
                <div class="tpl-form-body tpl-form-line">
                    <form class="am-form tpl-form-line-form" id="addPartForm">
                        <input type="hidden" id="goodscatId" name="partid">
                        <div class="am-form-group">
                            <label class="am-u-sm-3 am-form-label">模板描述</label>
                            <div class="am-u-sm-9">
                                <input type="text"  name="gcpartExplain" placeholder="输入模板的简单描述">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label class="am-u-sm-3 am-form-label">模板分类</label>
                            <div class="am-u-sm-9">
                                <small id="catModalTitle" class="am-text-danger am-text-lg"></small>
                                <button type="button" class="am-btn am-btn-primary" id="addPartParam">添加参数</button>
                                <button type="button" class="am-btn am-btn-warning" id="submitPartParam">保存模板</button>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <div class="am-u-sm-12" id="inputDiv">

                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/include/script.jsp"/>
<%--amazeui的脚本--%>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="static/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="static/ztree/js/jquery.ztree.excheck.js"></script>

<script>
    var zTree;
    var setting = {
        check: {
            enable: false
        },
        view: {
            dbClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pid",
                rootPid: ""
            }
        },
        callback: {
            beforeClick: function (treeId, treeNode) {
                console.log("点击事件，当前选中" + treeNode.name + ":" + treeNode.id)
                var zTree=$.fn.zTree.getZTreeObj("tree");
                leafId=treeNode.id
                $('#part_data').load('goodClassesPart/showClassesPart.do',{classId:treeNode.id})
            }
        }
    };
    $(function () {
        loadTree();
        partShow();
        function loadTree() {
            $.post('goodClassesPart/showTree.do', function (result) {
                zNodes = result;
                $.fn.zTree.init($("#tree"), setting, zNodes);
                zTree = $.fn.zTree.getZTreeObj("tree");
            }, "json")
        }
//        一进入页面显示其中一个的内容，使得内容表不空旷
        function partShow() {
            $('#part_data').load('goodClassesPart/showdata.do')
        }
    })
</script>
<script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
<script>
    <%--查看模板--%>
    function showPart(id){
        $.post('goodClassesPart/showPartContent.do',{id:id},function (result) {
            if(result.success){
                var data=result.data;
                var content= data.gcpartContent;
                //数据库中取出来的数据是字符串，需要转换成json数据
                var contentJson=$.parseJSON(content);
                var str='';
                var root=contentJson.root;
//                console.log(root)
                for(var i=0;i<root.length;i++){
                    str+="<hr>"+root[i]+"<br/>";
                }
                $('#showPartContent').html(str)
                $('#your-modal').modal('open')
            }
        },'json')
    };
    //    添加模板
    function addPart() {
        var node=zTree.getNodeByParam('id',leafId);
//        console.log(node)
        $('#catModalTitle').html(node.name)
        $('#add-modal').modal('open')
    }
    //删除模板
    function deletePart(id) {
        $.get('goodClassesPart/deletePartContent.do',{id:id},function (result) {
            if(result.success){
                $('#part_data').load('goodClassesPart/showClassesPart.do',{classId:result.id})
            }else{
                alert(result.message);
            }
        },'json')

    }
    //    编辑模板显示
    function editPart(id) {
//        var node =zTree.getNodeByParam('id',leafId);
//        console.log(node)

        $('#editId').val(id)
        $.get('goodClassesPart/showPartContent.do',{id:id},function (result) {
            $('#PartContent').modal('open')
            if(result.success){
                var data=result.data;
                var content= data.gcpartContent;
                //数据库中取出来的数据是字符串，需要转换成json数据
                var contentJson=$.parseJSON(content);
                var str='';
                var strName="<input type='text' name='content' value='"+result.data.gcpartExplain+"'>"+"<br/>";
                var root=contentJson.root;
                console.log(root)
                for(var i=0;i<root.length;i++){
                    str+="<input type='text' name='contentName' value='"+root[i]+"'>"+"<br/>";
                }
                $('#contentNow').html(strName);
                $('#PartContent').html(str)
                $('#my-modal').modal('open')
            }
        },'json')
    }
    $(function () {
        //追加参数
        $('#addPartParam').click(function () {
            $('#inputDiv').append('<input type="text" name="parameter" placeholder="添加模板参数，例如保质期、厂商等">')
        })
        //保存添加的模板
        $('#submitPartParam').click(function () {
            $('#goodscatId').val(leafId)
            $.post('goodClassesPart/addPartContent.do',$('#addPartForm').serialize(),function (result) {
                if(result.success){
                    $('#part_data').load('goodClassesPart/showClassesPart.do',{classId:leafId})
                    $('#add-modal').modal('close');
                }else{
                    alert(result.message);
                }
            },'json')
        })
        //编辑模板
        $('#sp1').click(function () {
            $.post('goodClassesPart/editPartContent.do',$('#editPartForm').serialize(),function (result) {
                var id=result.id;
                if(result.success){
                    $('#part_data').load('goodClassesPart/showClassesPart.do',{classId:id})
                    $('#my-modal').modal('close');
            }else{
                    alert(result.message);
                }
            },'json')
        });
        $('#sp2').click(function () {
            $('#PartContent').modal('close')
        })

    })
</script>
</body>
</html>