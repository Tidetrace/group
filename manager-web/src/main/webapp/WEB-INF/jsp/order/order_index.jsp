<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017.11.02
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>订单管理</title>
    <base href="${BaseContext}">
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <%--引用页面样式--%>
    <jsp:include page="/WEB-INF/jsp/include/style.jsp"/>
</head>


<body data-type="generalComponents">

<jsp:include page="/WEB-INF/jsp/include/header.jsp"/>


<div class="tpl-page-container tpl-page-header-fixed">
    <jsp:include page="/WEB-INF/jsp/include/menu.jsp"/>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            订单列表
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li class="am-active">订单列表</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 列表
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                            <i class="am-icon-search"></i>
                            <input type="text" class="form-control form-control-solid" placeholder="搜索..."></div>
                    </div>
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form" method="post" action="order/index.do">
                            <div class="am-g">
                                <div class="am-u-sm-12 am-u-md-6">
                                    <div class="am-btn-toolbar">
                                        <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
                                            <div class="am-modal-dialog">
                                                <div class="am-modal-hd">商品信息修改</div>
                                                <div class="am-modal-bd">
                                                    买家留言：
                                                    <input type="text" class="am-modal-prompt-input">
                                                </div>
                                                <div class="am-modal-footer">
                                                    <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                                                    <span class="am-modal-btn" data-am-modal-confirm>提交</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-input-group am-input-group-sm">
                                    <input type="text" class="am-form-field" placeholder="用户uuid或订单编号" id="seek"
                                           name="seek">
                                    <span class="am-input-group-btn">
                                     <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                             type="submit" id="button_order"></button>
                                </span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-check"><input type="checkbox" id="num" class="tpl-table-fz-check"></th>
                            <th class="table-id">ID</th>
                            <th class="table-title">订单编号</th>
                            <th class="table-type">用户uuid</th>
                            <th class="table-author am-hide-sm-only">支付金额</th>
                            <th class="table-date am-hide-sm-only">付款时间</th>
                            <th class="table-author am-hide-sm-only">失效时间</th>
                            <th class="table-date am-hide-sm-only">买家留言</th>
                            <th class="table-date am-hide-sm-only">状态</th>
                            <th class="table-set">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orders}" var="orders">
                            <tr>
                                <td><input type="checkbox" name="nums" value="${orders.orderNum}"></td>
                                <td>${orders.id}</td>
                                <td><span id="sp1">${orders.orderNum}</span></td>
                                <td>${orders.userUuid}</td>
                                <td class="am-hide-sm-only">￥${orders.payPrice}</td>
                                <td class="am-hide-sm-only"><fmt:formatDate value="${orders.payTime}"
                                                                            pattern="yyyy-MM-dd"/></td>
                                <td class="am-hide-sm-only"><fmt:formatDate value="${orders.overTime}"
                                                                            pattern="yyyy-MM-dd"/></td>
                                <td class="am-hide-sm-only">${orders.leaveWord}</td>
                                <td class="am-hide-sm-only"><c:choose><c:when
                                        test="${orders.state==1}">待支付</c:when><c:when
                                        test="${orders.state==2}">已支付</c:when><c:when
                                        test="${orders.state==3}">已发货</c:when><c:otherwise>订单取消</c:otherwise></c:choose></td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary" id="chage"
                                                    value="${orders.orderNum}"><span
                                                    class="am-icon-pencil-square-o"></span> 编辑
                                            </button>
                                            <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span
                                                    class="am-icon-copy"></span> 复制
                                            </button>
                                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                    id="delete" value="${orders.orderNum}">
                                                <span class="am-icon-trash-o"></span> 删除
                                            </button>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                        </tbody>
                    </table>

                    <%--<div class="am-cf">--%>
                    <div style="margin-left: 5%">
                        <label style="margin-right:10%;">共${pageNum.total}条数据，当前页${pageNum.pageNum}/${pageNum.pages}
                            <button id="delAll" type="button" style="margin-left:15px;height: 35px;border-radius: 8px"
                                    class="am-btn am-btn-default am-btn-danger"><span
                                    class="am-icon-trash-o"></span> 删除
                            </button>
                        </label>

                    </div>
                    <div class="am-fr">
                        <ul class="am-pagination tpl-pagination">
                            <c:if test="${pageNum.hasPreviousPage==true}">
                                <li class="am"><a href="order/index.do?pageNum=${pageNum.prePage}">«</a></li>
                            </c:if>
                            <%--<c:if test="${pageNum.total}">--%>
                            <li class="am-active"><a href="order/index.do?pageNum=${pageNum.pageNum}">${pageNum.pageNum}</a></li>
                            <%--</c:if>--%>
                            <c:if test="${pageNum.hasNextPage==true}">
                                <li><a href="order/index.do?pageNum=${pageNum.nextPage}">»</a></li>
                            </c:if>
                        </ul>
                    </div>
                    <%--</div>--%>
                    <hr>

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
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/include/script.jsp"/>
<%--amazeui的脚本--%>
<script>
    $(function () {
        $('td>span').each(function (i) {
            $(this).click(function () {
                $.post('order/selectOrderByOrderNum.do', {orderNum: $(this).text()}, function (result) {
                    $('.am-modal-bd').html("<h5>" + result.mess + "</h5><h5>" + result.mess1 + "</h5><h5>" + result.mess2 + "</h5><h5>" + result.mess3 + "</h3>")
                    $('#your-modal').modal('open');
                }, 'json');
            });
        });

    });
    $(function () {
        $('td #chage').each(function (i) {
            $(this).click(function () {
                alert("HH" + $(this).val())
                var orderNum = $(this).val();
                $('#my-prompt').modal({
                    relatedTarget: this,
                    onConfirm: function (e) {
                        alert('你输入的是：' + e.data + orderNum)
                        $.post('order/updateOrderByOrderNum.do', {
                            leaveWord: e.data,
                            orderNum: orderNum
                        }, function (result) {
                            location.reload();
                        }, 'html');
                    },
                    onCancel: function (e) {
                        alert('修改失败!');
                    }
                });
            });
        });
    });
    $(function () {
        $('td #delete').each(function (i) {
            $(this).click(function () {
                alert("订单编号" + $(this).val())
                $.post('order/deleteOrderByOrderNum.do', {orderNum: $(this).val()}, function (result) {
                    if (result.ok) {
                        location.reload();
                    } else {
                        alert(result.err)
                    }
                }, 'json');
            });
        });
    })

</script>
<script>
    $(function () {
        oinput = $("#num").get(0);
        oinput.onclick = function () {
            if (this.checked) {
                $("input[name='nums']").attr("checked", "checked")
                var place = document.getElementsByName("nums");
                for (i = 0; i < place.length; i++) {
                    place[i].checked = true;
                }
            } else {
                $("input[name='nums']").removeAttr("checked")
            }
        }
    });
    $(function () {
        $('#delAll').click(function () {
            if (confirm('确定要删除所选吗?')) {
                var checks = $("input[name='nums']:checked");
                if (checks.length == 0) {
                    alert('未选中任何项！');
                    return false;
                }
                //将获取的值存入数组
                var checkData = new Array();
                checks.each(function () {
                    checkData.push($(this).val());
                });
                console.log($.param({
                    orderNums : checkData
                }, true));
               // alert(checkData.toString())
                alert(checkData+"啊哈哈")
                $.post("order/delAllOrderByOM.do", $.param({order_num: checkData},true), function (result) {
                    if (result.success) {
                        location.reload();
                    }else{
                        alert(result.mess)
                    }
                },'json');
            }
        });
    })
    ;
</script>
</body>
</html>