<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhzs
  Date: 2018/3/13
  Time: 下午3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="background: #FFFFFF">
<head>
    <jsp:include page="head.jsp"/>
    <script>
        function subClick(managerId) {
            if(!managerId){
                managerId = "0";
            }
            var issubmit=true;
            var inptobj=$("#managerForm input");
                $.each(inptobj,function(i,obj){

                    if(!$(obj).val()){
                        issubmit=false;
                    }
                })
            if(!issubmit){
                alert("请完善信息");
                return false;
            }
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/user/saveManager?managerId="+managerId,
                data: $('#managerForm').serialize(),
                success: function (data) {
                    if(data.code == 0){
                        alert(data.message)
                        window.location.href = "/user/managerList";
                    }else{
                        alert(data.message);
                    }
                },
                error: function (e) {
                    alert("异常！" + JSON.stringify(e));
                }
            });
        }

        function changeView(string) {
            window.parent.changeView(string);
        }
    </script>
</head>

<body>

<div class="breadcrumbs" id="breadcrumbs">
    <ul class="breadcrumb">
        <li>
            <i class="icon-home home-icon"></i>
            <a href="javascript:changeView('/user/userList')">主页</a>
        </li>

        <li>
            <a href="javascript:changeView('/user/managerList')">字典列表</a>
        </li>
        <li class="active">编辑字典信息</li>
    </ul><!-- .breadcrumb -->

    <div class="nav-search" id="nav-search">
        <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off"/>
									<i class="icon-search nav-search-icon"></i>
								</span>
        </form>
    </div><!-- #nav-search -->
</div>

<div class="page-content">
    <div class="page-header">
        <h1>
            字典列表
            <small>
                <i class="icon-double-angle-right"></i>
                编辑字典信息
            </small>
        </h1>
    </div><!-- /.page-header -->
    <form class="form-horizontal" role="form" id="managerForm">
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> 名称 </label>

            <div class="col-sm-9">
                <input placeholder="字典名称" class="col-xs-10 col-sm-5" type="text" name="name" value="${manager.name}" required>
            </div>
        </div>
        <div class="space-4"></div>
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> 类型 </label>

            <div class="col-sm-9">
                <input placeholder="类型" class="col-xs-10 col-sm-5" type="text" name="type" value="${manager.type}" required>
            </div>
        </div>
        <div class="space-4"></div>
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> 编码 </label>

            <div class="col-sm-9">
                <input placeholder="编码" class="col-xs-10 col-sm-5" type="text" name="code" value="${manager.code}" required>
            </div>
        </div>
        <div class="space-4"></div>
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> 说明 </label>

            <div class="col-sm-9">
                <input placeholder="说明" class="col-xs-10 col-sm-5" type="text" name="comment" value="${manager.comment}" required>
            </div>
        </div>

        <div class="space-4"></div>

        <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
                <button class="btn btn-info" type="button" data-id="managerId" onclick="subClick(${manager.id})">
                    <i class="icon-ok bigger-110"></i>
                    提交
                </button>

                &nbsp; &nbsp; &nbsp;
                <button class="btn" type="reset">
                    <i class="icon-undo bigger-110"></i>
                    重填
                </button>
            </div>
        </div>
    </form>

</div><!-- /.page-content -->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="icon-double-angle-up icon-only bigger-110"></i>
</a>

</body>
</html>

