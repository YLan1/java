<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhzs
  Date: 2018/3/13
  Time: 下午2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="background: #FFFFFF">
<head>
    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="/assets/pagination/jquery.pagination.css"/>
    <script src="/assets/pagination/jquery.pagination.min.js"></script>
    <script>
        function addManager() {
            window.location.href = "/user/addManager";
        }

        function updata(managerId) {
            window.location.href = "/user/addManager?managerId="+managerId;
        }

        function changeView(string) {
            window.parent.changeView(string);
        }

        function deleManager(delManagerId) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/user/deleManager",
                data: {'delManagerId':delManagerId},
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
        window.onload = getManagerListByPage(1,2);
        function getManagerListByPage(page, size) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/user/managerListByPage",
                data:{page:page, size:size},
                success: function (data) {
                    if(data.code == 0){
                        var tbodyabc = $("#tbodyabc");
                        var trhtmll;
                        for(var i = 0; i < data.data.length; i++){
                            trhtmll+="<tr>" +
                                "<td class=\"center\">"+data.data[i].id+"</td>" +
                                "<td class=\"center\">"+data.data[i].name+"</td>" +
                                "<td class=\"center\">"+data.data[i].code+"</td>" +
                                "<td class=\"center\">"+data.data[i].type+"</td>" +
                                "<td class=\"center\">"+data.data[i].comment+"</td>" +
                                "<td class=\"center\">"+data.data[i].createTime+"</td>" +
                                "<td class=\"center\">" +
                                "<div>" +
                                "<button class=\"btn btn-xs btn-info\" data-id=\"managerId\" onclick=\"updata("+data.data[i].id+")\">" +
                                "<i class=\"icon-edit bigger-120\"></i>" +
                                "</button>" +
                                "<button class=\"btn btn-xs btn-danger\" data-id=\"delManagerId\" onclick=\"deleManager("+data.data[i].id+")\">" +
                                "<i class=\"icon-trash bigger-120\"></i>" +
                                "</button>" +
                                "</div>" +
                                "</td>" +
                                "</tr>";
                        }
                        tbodyabc.empty();
                        tbodyabc.append(trhtmll);

                        createPageInfo(page , data.dataInfoModel.totalPages);
                    }
                }
            });
        }

        function createPageInfo(currentPage , totalPage){
            $("#pagination1").pagination({
                currentPage: currentPage,
                totalPage: totalPage,
                callback: function(current) {
                    getManagerListByPage(current,2);
                }
            });
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
        <li class="active">字典信息</li>
    </ul><!-- .breadcrumb -->

    <div class="nav-search" id="nav-search">
        <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off">
									<i class="icon-search nav-search-icon"></i>
								</span>
        </form>
    </div>
</div>
<div class="page-content">
    <div class="page-header">
        <h1>
            字典列表
            <small>
                <i class="icon-double-angle-right"></i>
                字典信息
            </small>
        </h1>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <div style="text-align: right">
                            <button class="btn btn-info" onclick="addManager()">新增字典</button>
                        </div>
                        <div class="space-4"></div>
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">编号</th>
                                <th class="center">名称</th>
                                <th class="center">类型</th>
                                <th class="center">编码</th>
                                <th class="center">说明</th>
                                <th class="center">创建时间</th>
                                <th class="center">操作</th>
                            </tr>
                            </thead>
                            <tbody id="tbodyabc">


                            </tbody>
                        </table>
                    </div><!-- /.table-responsive -->
                </div>

            </div>
        </div>
    </div>
</div>
<div class="box" style="float: right;margin-right: 1.2em">
    <div id="pagination1" class="fl"></div>
</div>
</body>
</html>

