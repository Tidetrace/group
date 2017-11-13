<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="tpl-block">
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button type="button" class="am-btn am-btn-default am-btn-success" onclick="addPart();"><span class="am-icon-plus"></span> 新增</button>
                    <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                    <button type="button" class="am-btn am-btn-default am-btn-danger" onclick="deleteData(${gclassesId})"><span class="am-icon-trash-o"></span> 删除</button>
                </div>
            </div>
        </div>

    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <form class="am-form">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th class="table-check"><input type="checkbox" class="tpl-table-fz-check" id="checkBoxAll"></th>
                        <th class="table-id">序号</th>
                        <th class="table-title">标题</th>
                        <th class="table-cell">更新时间</th>
                        <th class="table-set">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty results}">
                        <c:forEach items="${results}" varStatus="i" var="s">
                            <tr>
                                <td><input type="checkbox" name="check" value="${s.id}"></td>
                                <td>${i.count}</td>
                                <td><a href="javascript:void(0);" onclick="showPart(${s.id});" title="点击查看模板说明">${s.gcpartExplain}</a></td>
                                <td><fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="editPart(${s.id});"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                            <button type="button" class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick="copyPart(${s.id});"><span class="am-icon-copy"></span> 复制</button>
                                            <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="deletePart(${s.id});"><span class="am-icon-trash-o"></span> 删除</button>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>

                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<script>
    //批量删除
        $('#checkBoxAll').click(function () {
            var status=$(this).prop('checked')
            var checkData=$(':checkbox[name="check"]')
            if(status){
                checkData.each(function (i) {
                    $(this).prop('checked',true);
                })
            }else{
                checkData.each(function (i) {
                    $(this).prop('checked',false);
                })
            }
        });
        var idData=new Array();
        function deleteData(id) {
            var lenth=$(':checkbox[name="check"]:checked').length
            if(lenth>0){
                $(':checkbox[name="check"]:checked').each(function (i) {
                    idData.push($(this).val())
                })
                $.post('goodClassesPart/deleteClassesPartData.do',$.param({idData:idData,gclassesId:id},true),function (result) {
                    if(result.success){
                        $('#part_data').load('goodClassesPart/showClassesPart.do',{classId:result.id})
                    }else{
                        alert(result.message);
                    }
                },'json')
            }
        }
</script>
