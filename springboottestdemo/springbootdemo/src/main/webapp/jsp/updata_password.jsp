<%--
  Created by IntelliJ IDEA.
  User: lhzs
  Date: 2018/3/16
  Time: 上午9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <jsp:include page="head.jsp"/>
    <script>
        function upDataClick() {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/upData",
                data: $('#upData').serialize(),
                success: function (data) {
                    if(data.code == 0){
                        alert(data.message)
                        window.location.href = "login";
                    }else{
                        alert(data.message);
                    }
                },
                error: function (e) {
                    alert("异常！" + JSON.stringify(e));
                }
            });
        }
    </script>
</head>
<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">Ace</span>
                            <span class="white">Application</span>
                        </h1>
                        <h4 class="blue">&copy; 联合众生</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="forgot-box" class="forgot-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="icon-key"></i>
                                        重置用户密码
                                    </h4>
                                    <div class="space-6"></div>
                                    <form id="upData">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="旧用户名"
                                                                   name="oldname">
															<i class="icon-envelope"></i>
														</span>
                                            </label>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="新用户名"
                                                                   name="newname">
															<i class="icon-envelope"></i>
														</span>
                                            </label>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码"
                                                                   name="paw">
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <div class="clearfix">
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-danger"
                                                        onclick="upDataClick()">
                                                    <i class="icon-lightbulb"></i>
                                                    重置
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->
                                <div class="toolbar center">
                                    <a href="/index"
                                       class="back-to-login-link">
                                        返回
                                        <i class="icon-arrow-right"></i>
                                    </a>
                                </div>

                            </div><!-- /widget-body -->
                        </div>

                    </div><!-- /position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div>
</div><!-- /.main-container -->


</body>
</html>
