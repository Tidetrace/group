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
                    <span class="am-icon-code">列表</span>
                </div>
            </div>

            <div class="tpl-block">
                <div class="tpl-portlet-input tpl-fz-ml" style="float: left;margin-left: 8%;" >
                    <div class="input-icon left">
                        <button class="am-btn am-btn-primary" id="addBtn1">添加一级分类</button>
                        <button class="am-btn am-btn-primary" id="addBtn2">添加二级分类</button>
                        <button class="am-btn am-btn-primary" id="editBtn">编辑分类</button>
                        <button class="am-btn am-btn-primary" id="delBtn">删除分类</button>
                    </div>
                    <div class="am-g left">
                        <div class="am-sm-6">
                            <div id="tree" class="ztree" style="width:260px; overflow:auto;"></div>
                        </div>
                    </div>
                    <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
                        <div class="am-modal-dialog">编辑商品分类内容
                            <div class="am-modal-bd" id="modal">
                                一级分类：<input type="text" id="text">
                            </div>
                            <div class="am-modal-bd" id="modal2">
                                <table>
                                    <tr>
                                        <td>一级分类：
                                            <select id="selectName">
                                                <c:forEach var="gc" items="${goodsClass}">
                                                    <option value="${gc.id}">${gc.classesName}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td>二级分类：<input type="text" id="text2"></td>
                                    </tr>
                                </table>
                            </div>
                            <div class="am-modal-footer">
                                <span class="am-modal-btn" id="sp1">确定</span>
                                <span class="am-modal-btn" id="sp2">取消</span>
                            </div>
                        </div>
                    </div>
                    <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert-edit">
                        <div class="am-modal-dialog">编辑商品分类内容
                            <div class="am-modal-bd" id="modal3">
                                重命名：<input type="text" id="text3">
                            </div>
                            <div class="am-modal-footer" id="modal4">
                                <span class="am-modal-btn" id="sp11">确定</span>
                                <span class="am-modal-btn" id="sp22">取消</span>
                            </div>
                        </div>
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
            <div class="am-modal-hd"><label style="color: red;font-weight: bold">商品信息简介</label>
                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <div class="am-modal-bd">
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
            enable: true,
            chkboxType: {"Y": "s", "N": "ps"}
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
            beforeCheck: function (treeId, treeNode) {
//                console.log("当前选中"+treeNode.name+":"+treeNode.id)
            },
            beforeClick: function (treeId, treeNode) {
                console.log("点击事件，当前选中" + treeNode.name + ":" + treeNode.id)
                $('#editBtn').click(function () {
                    $('#my-alert-edit').modal('open');
                    $('#sp11').click(function () {
                        var text3 = $('#text3').val();
                        $.post('goodClasses/editClasses.do', {className: text3, id: treeNode.id}, function (result) {
                            location.reload();
                        })
                    })
                });

            },
            onCheck: function (treeId, treeNode) {
                var nodes = zTree.getCheckedNodes(true);
                var idData = new Array();
                for (var i = 0; i < nodes.length; i++) {
                    console.log(nodes[i].id + ":" + nodes[i].name)
                    idData.push(nodes[i].id)
                }
                $('#delBtn').click(function () {
                    $('#modal').hide();
                    $('#modal2').hide();
                    $('#my-alert').modal('open');
                    $('#sp1').click(function () {
                        $.post('goodClasses/deleteClasses.do', $.param({idData: idData}, true), function (json) {
                            location.reload();
                        })
                    })
                })
            }
        }
    };
    $(function () {
        loadTree();

        function loadTree() {
            $.post('goodClasses/showTree.do', function (result) {
                zNodes = result;
                $.fn.zTree.init($("#tree"), setting, zNodes);
                zTree = $.fn.zTree.getZTreeObj("tree")
            }, "json")
        }
    })
</script>
<script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
<script>
    //添加一级分类
    $(function () {
        $('#addBtn1').click(function () {
            $('#modal').show();
            $('#modal2').hide();
            $('#my-alert').modal('open');
            $('#sp1').click(function () {
                var text = $('#text').val();
                $.post('goodClasses/addClasses.do', {text: text}, function (result) {
                    location.reload();
                })
            })
        })
        //添加二级分类
        $('#addBtn2').click(function () {
            $('#modal').hide();
            $('#modal2').show();
            //显示所有的一级商品分类
            $('#my-alert').modal('open');
            $('#sp1').click(function () {
                var text = $('#text2').val();
                var id = $('#selectName').val();
                $.post('goodClasses/addSecondClasses.do', {text: text, id: id}, function (result) {
                    location.reload();
                })
            })
        })
        $('#sp2').click(function () {
            $('#my-alert').modal('close');
        })
        $('#sp22').click(function () {
            $('#my-alert-edit').modal('close');
        })

    })
</script>
</body>
</html>