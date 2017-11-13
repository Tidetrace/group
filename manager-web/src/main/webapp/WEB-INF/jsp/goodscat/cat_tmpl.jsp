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
    <title>商品参数模板管理</title>
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
                    商品参数模板
                </div>

            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-2">
                        <div  id="tree" class="ztree"></div>
                    </div>
                    <div class="am-u-sm-10">
                        <div  id="table"></div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>


<div class="am-modal am-modal-no-btn" tabindex="-1" id="addModal">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">分类模板添加
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <div class="tpl-form-body tpl-form-line">
                <form class="am-form tpl-form-line-form" id="addTmplForm">
                    <input type="hidden" id="goodscatId" name="catid">

                    <div class="am-form-group">
                        <label class="am-u-sm-3 am-form-label">模板描述</label>
                        <div class="am-u-sm-9">
                            <input type="text"  name="tmpldescr" placeholder="输入模板的简单描述">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label class="am-u-sm-3 am-form-label">模板分类</label>
                        <div class="am-u-sm-9">
                            <small id="catModalTitle"></small>
                            <button type="button" class="am-btn am-btn-primary" id="addTmplParam">添加参数</button>
                            <button type="button" class="am-btn am-btn-warning" id="submitTmplParam">保存模板</button>
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


<div class="am-modal am-modal-no-btn" tabindex="-1" id="showModal">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">分类模板查看
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <div class="tpl-form-body tpl-form-line" id="showTmplDiv">

            </div>

        </div>
    </div>
</div>


<jsp:include page="../include/script.jsp"></jsp:include>
<script>

    var zTreeObj;
    var leafId;
    var setting = {
        check: {
            enable: false
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
                leafId = treeNode.id;//点击选择的tree id
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode);
                    return false;
                }else{
                    //点击tree节点，加载此商品分类下的模板信息到右侧页面
                    $('#table').load('goodscat/tmpldata.do',{catid:treeNode.id});
                }
            }
        }
    };

    var zNodes;//存储ajax返回的数据

    $(function () {

        loadTree();

        $('#addTmplParam').click(function () {
            $('#inputDiv').append('<input type="text" name="parameter" placeholder="添加模板参数，例如保质期、厂商等">')
        });
        $('#submitTmplParam').click(function () {
            $('#goodscatId').val(leafId);
            $.post('goodscat/tmpl/add.do',$('#addTmplForm').serialize(),function (result) {
                if(result.success){
                    //成功
                    $('#table').load('goodscat/tmpldata.do',{catid:leafId});
                    $('#addModal').modal('close');
                }else{
                    alert(result.msg);
                }
            },'json');
        });

    });

    function loadTree() {
        $.get('goodscat/ajaxdata.do',function (result) {

            console.log(result);
            zNodes = result;

            $.fn.zTree.init($("#tree"), setting, zNodes);
            zTreeObj = $.fn.zTree.getZTreeObj("tree");
        },'json');
    }

    //添加模板
    function addTmpl() {
        //获取已点击节点的名字
        var node = zTreeObj.getNodeByParam('id',leafId);
        $('#catModalTitle').html(node.name);

        $('#addModal').modal('open');
    }
    //查看模板
    function showTmpl(id) {
        $.get('goodscat/tmpl/'+id+'/info.do',function (result) {
            if(result.success){
                //获取到了，展示
                var tmpl = result.data;
                var tmplParam = tmpl.tmplParam;
                //数据库取出来的模板是字符串，需要转json
                console.log(tmplParam);
                var root = $.parseJSON(tmplParam);
                console.log(root);
                var parameters = root.root;
                var str = '';
                for(var i=0;i<parameters.length;i++){
                    str+=parameters[i]+"<br/>";
                }
                $('#showTmplDiv').html(str);
                $('#showModal').modal('open');
            }
        },'json');
    }


</script>


</body>
</html>
