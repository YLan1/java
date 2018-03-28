<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2018/3/12
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="background: #FFFFFF">
<head>
    <jsp:include page="head.jsp"/>
    <script>
        function addUser() {
            window.location.href = "/user/addUser";
        }

        function delUser(delUserId) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/user/delUser",
                data: {'delUserId': delUserId},
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

        function updataUser(userId) {
            window.location.href = "/user/addUser?userId=" + userId;
        }

        // window.document.onkeydown = search;
        function search() {
            window.location.href = "/user/userList";//searchUserInfoList
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
        <li class="active">公众号信息</li>
    </ul><!-- .breadcrumb -->

    <div class="nav-search" id="nav-search">
        <form class="form-search" id="searchForm">
								<span class="input-icon">
									<input type="text" placeholder="搜索 ..." class="nav-search-input"
                                           onkeydown="javascript:if(event.keyCode==13)search()"
                                           name="nav-search-input" autocomplete="off" size="5">
									<i class="icon-search nav-search-icon"></i>
								</span>
        </form>
    </div>
</div>
<div class="page-content">
    <div class="page-header">
        <h1>
            公众号信息列表
            <small>
                <i class="icon-double-angle-right"></i>
                公众号信息
            </small>
        </h1>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <div style="text-align: right">
                            <button class="btn btn-info" onclick="addUser()">新增公众号信息</button>
                        </div>
                        <div class="space-4"></div>
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">编号</th>
                                <th class="center">登录用户名</th>
                                <th class="center">APP ID</th>
                                <th class="center">APP SECRET</th>
                                <th class="center">TOKEN</th>
                                <th class="center">AES KEY</th>
                                <th class="center">原始ID</th>
                                <th class="center">类型</th>
                                <th class="center">公司名称</th>
                                <th class="center">创建时间</th>
                                <th class="center">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${getUserInfoList}" var="userInfo">
                            <c:forEach items="${userListModel}" var="usermodel">
                            <c:forEach items="${typeDicModelList}" var="dicModel">
                            <tr>
                                <c:if test="${usermodel.id == userInfo.publicUserId && userInfo.type == dicModel.code}">
                                    <td class="center">${userInfo.id}</td>
                                    <td class="center">${usermodel.name}</td>
                                    <td class="center">${userInfo.appId}</td>
                                    <td class="center">${userInfo.appSecret}</td>
                                    <td class="center">${userInfo.token}</td>
                                    <td class="center">${userInfo.encodingAesKey}</td>
                                    <td class="center">${userInfo.originalId}</td>
                                    <td class="center">${dicModel.name}</td>
                                    <td class="center">${userInfo.name}</td>
                                    <td class="center">${userInfo.createTime}</td>
                                    <td class="center">
                                        <div>
                                            <button class="btn btn-xs btn-info" data-id="updataUserId"
                                                    onclick="updataUser(${userInfo.id})">
                                                <i class="icon-edit bigger-120"></i>
                                            </button>
                                            <button class="btn btn-xs btn-danger" data-id="delUserId"
                                                    onclick="delUser(${userInfo.id})">
                                                <i class="icon-trash bigger-120"></i>
                                            </button>
                                        </div>
                                    </td>
                                </c:if>
                            </tr>
                            </
                            >
                            </c:forEach>
                            </c:forEach>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div><!-- /.table-responsive -->
                </div>
                <div class="row" style="float: right; margin-right: 0.8em">
                    <!--分页-->
                    <div class="m-style M-box2"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

