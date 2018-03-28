<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhzs
  Date: 2018/3/13
  Time: 下午2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="background: #FFFFFF">
<head>
    <jsp:include page="head.jsp"/>
    <script>
        function submitClick(userId) {
            if (!userId) {
                userId = "0";
            }

            var issubmit=true;
            var inptobj=$("#userInfoForm input");
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
                url: "/user/saveUser?userId=" + userId,
                data: $('#userInfoForm').serialize(),
                success: function (data) {
                    if (data.code == 0) {
                        alert(data.message)
                        window.location.href = "/user/userList";
                    } else {
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
            <a href="javascript:changeView('/user/userList')">公众号信息列表</a>
        </li>
        <li class="active">新增公众号信息</li>
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
            公众号信息列表
            <small>
                <i class="icon-double-angle-right"></i>
                新增公众号信息
            </small>
        </h1>
    </div><!-- /.page-header -->
    <form class="form-horizontal" role="form" id="userInfoForm">
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right">用户名</label>
            <div class="col-sm-9">
                <select class="col-xs-10 col-sm-5" id="form-field-select-1" name="publicUserId">
                    <c:forEach items="${userListModel}" var="user">
                        <c:choose>
                            <c:when test="${userInfo.publicUserId == user.id}">
                                <option selected="selected" value="${user.id}">${user.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${user.id}">${user.name}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> APP ID </label>

            <div class="col-sm-9">
                <input placeholder="APP ID" class="col-xs-10 col-sm-5" type="text" name="appId"
                       value="${userInfo.appId}">
            </div>
        </div>
        <div class="space-4"></div>
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> APP SECRET </label>

            <div class="col-sm-9">
                <input placeholder="APP SECRET" class="col-xs-10 col-sm-5" type="text" name="appSecret"
                       value="${userInfo.appSecret}">
            </div>
        </div>
        <div class="space-4"></div>
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> TOKEN </label>

            <div class="col-sm-9">
                <input placeholder="TOKEN" class="col-xs-10 col-sm-5" type="text" name="token"
                       value="${userInfo.token}">
            </div>
        </div>
        <div class="space-4"></div>
        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> AES KEY </label>

            <div class="col-sm-9">
                <input placeholder="AES KEY" class="col-xs-10 col-sm-5" type="text" name="encodingAesKey"
                       value="${userInfo.encodingAesKey}">
            </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> 原始ID </label>

            <div class="col-sm-9">
                <input placeholder="原始ID" class="col-xs-10 col-sm-5" type="text" name="originalId"
                       value="${userInfo.originalId}">
            </div>
        </div>
        <div class="space-4"></div>

        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right"> 公司名称 </label>

            <div class="col-sm-9">
                <input placeholder="公司名称" class="col-xs-10 col-sm-5" type="text" name="name" value="${userInfo.name}">
            </div>
        </div>
        <div class="space-4"></div>

        <c:if test="${userInfo != null}">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right">类型</label>
                <div class="col-sm-9">
                    <select class="col-xs-10 col-sm-5" id="form-field-select-2" name="type">
                        <c:forEach items="${typeDicModelList}" var="dicModel">
                            <c:choose>
                                <c:when test="${dicModel.code == userInfo.type}">
                                    <option selected="selected" value="${userInfo.type}">${dicModel.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${dicModel.code}">${dicModel.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right"> 创建时间 </label>

                <div class="col-sm-9">
                    <input readonly class="col-xs-10 col-sm-5" type="text" name="createTime"
                           value="${userInfo.createTime}">
                </div>
            </div>
            <div class="space-4"></div>
        </c:if>


        <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
                <button class="btn btn-info" type="button" data-id="userId" onclick="submitClick(${userInfo.id})">
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

