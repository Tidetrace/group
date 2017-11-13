<%--
  User: zhouyanchao
  Date: 2017/11/2
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${BaseContext}">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品分类浏览维护</title>
    <jsp:include page="../include/style.jsp"></jsp:include>
</head>
<body>

<jsp:include page="../include/header.jsp"></jsp:include>

<div class="tpl-page-container tpl-page-header-fixed">
    <jsp:include page="../include/menu.jsp"></jsp:include>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            商品分类信息查看
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">分类</a></li>
            <li class="am-active">内容</li>
        </ol>

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    ztree展示
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="input-icon right">
                        <button class="am-btn am-btn-primary" id="addBtn1">添加分类</button>
                        <button class="am-btn am-btn-primary" id="addBtn2">添加二级分类</button>
                        <button class="am-btn am-btn-primary" id="editBtn">编辑分类</button>
                        <button class="am-btn am-btn-primary" id="delBtn">删除分类</button>
                    </div>
                </div>
            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-sm-6">
                        <div  id="tree" class="ztree" style="width:260px; overflow:auto;"></div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>


<jsp:include page="../include/script.jsp"></jsp:include>
<script>

    var zTree;
    var setting = {
        check: {
            enable: true
        },
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pid",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode);
                    return false;
                }
            },
            beforeCheck:function (treeId,treeNode) {
                console.log("当前选中的："+treeNode.name+">>>>>"+treeNode.id);

            },
            onCheck:function (treeId,treeNode) {
                //节点遍历，将所有已选中的节点id打印
                var nodes = zTree.getCheckedNodes(true);
                console.log(nodes);
                for(var i=0;i<nodes.length;i++){
                    console.log(nodes[i].id+"....."+nodes[i].name);
                }

            }
        }
    };

    var zNodes;//存储ajax返回的数据

    $(function () {

        loadTree();


    });

    function loadTree() {
        $.get('goodscat/ajaxdata.do',function (result) {

            console.log(result);
            zNodes = result;

            $.fn.zTree.init($("#tree"), setting, zNodes);
            zTree = $.fn.zTree.getZTreeObj("tree");
        },'json');
    }


</script>



</body>
</html>
