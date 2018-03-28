<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2018/3/12
  Time: 下午2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="head.jsp"/>

    <script type="text/javascript">
        function changeFrameHeight(obj){
            obj.height = $(window).height();
        }

        function changeView(string) {
            document.getElementById("userList").src = string;
        }

        function clearActiveClass() {
            var liList = $(".submenu").children("li");
            $.each(liList, function (index, li) {
                $(li).removeClass("active");
            })
        }

        $(function () {
            $("body").on("click", ".submenu-li", function () {
                clearActiveClass();
                $(this).addClass("active");
            })
        })
    </script>

</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    系统管理员
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo"/>
                        <span class="user-info">
                            ${nameandpaw.name}
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="upDataPassword">
                                <i class="icon-user"></i>
                                更改密码
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="/login">
                                <i class="icon-off"></i>
                                安全退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>
        <div class="sidebar" id="sidebar">
            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="icon-signal"></i>
                    </button>

                    <button class="btn btn-info">
                        <i class="icon-pencil"></i>
                    </button>

                    <button class="btn btn-warning">
                        <i class="icon-group"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="icon-cogs"></i>
                    </button>
                </div>

                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div><!-- #sidebar-shortcuts -->

            <ul class="nav nav-list">

                <li class="active open">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text"> 系统管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li class="submenu-li active">
                            <a href="javascript:changeView('/user/userList')">
                                <i class="icon-double-angle-right"></i>
                                公众号管理
                            </a>
                        </li>

                        <li class="submenu-li">
                            <a href="javascript:changeView('/user/managerList')">
                                <i class="icon-double-angle-right"></i>
                                字典管理
                            </a>
                        </li>

                        <li class="submenu-li">
                            <a href="javascript:changeView('/user/albumList')">
                                <i class="icon-double-angle-right"></i>
                                图库
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
                   data-icon2="icon-double-angle-right"></i>
            </div>
        </div>
        <div class="main-content">
            <iframe id="userList" src="/user/userList" frameborder="0" scrolling="yes" width="100%" onload="changeFrameHeight(this)"></iframe>

        </div>
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->
</body>

</html>

