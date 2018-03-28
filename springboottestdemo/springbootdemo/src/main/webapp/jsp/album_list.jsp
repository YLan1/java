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
//坑：引入顺序
    <script src="/assets/uploadFile/jquery.ui.widget.js"></script>
    <script src="/assets/uploadFile/jquery.iframe-transport.js"></script>
    <script src="/assets/uploadFile/jquery.fileupload.js"></script>
    <script src="/assets/uploadFile/jquery.uploadify.js"></script>
    <script>
        function delAlbum(albumId) {
            window.location.href = "/user/delete?deleteId=" + albumId;
        }
        //通过点击按钮上传
        $(function () {
            $('#fileupload').fileupload({
                dataType: 'json',
                url:"/user/upload",
                add: function (e, data) {
                    data.context = $('<button/>').text('上传')
                        .appendTo(document.body)
                        .click(function () {
                            $(this).replaceWith($('<p/>').text('上传成功'));

                            data.submit();
                        });

                },
                done: function (e, data) {
                    data.context.text('Upload finished.');
                    $("#img1").attr("src", data.result.data);
                }
            });
        });
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
            <a href="javascript:changeView('/user/userList')">图库</a>
        </li>
    </ul><!-- .breadcrumb -->
</div>
<div class="page-content">
    <div class="page-header">
        <h1>
            图库
        </h1>
    </div>
    <%--<c:if test="${albumPathModels.size() != 0}">--%>
        <%--<dic>--%>
            <%--<table class="table table-striped table-bordered table-hover">--%>
                <%--<thead>--%>
                <%--<tr>--%>
                    <%--<th class="center">编号</th>--%>
                    <%--<th class="center">图片</th>--%>
                    <%--<th class="center">操作</th>--%>
                <%--</tr>--%>
                <%--</thead>--%>
                <%--<tbody>--%>
                <%--&lt;%&ndash;<c:forEach items="${albumPathModels}" var="albumModle">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<td class="center">${albumModle.id}</td>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<td class="center"><img src="${albumModle.path}"/></td>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<td class="center">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<button class="btn btn-xs btn-danger" data-id="delUserId"&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;onclick="delAlbum(${albumModle.id})">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<i class="icon-trash bigger-120"></i>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</&ndash;%&gt;--%>
                <%--&lt;%&ndash;>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</dic>--%>
    <%--</c:if>--%>
    <%--<form action="/user/upload" enctype="multipart/form-data" method="post">--%>
        <%--选择一张图片:--%>
        <%--<input type="file" name="uploadFile"/>--%>
        <%--<br/><br/>--%>
        <%--<input type="submit" value="上传"/>--%>
    <%--</form>--%>

    <!-- 异步上传图片 -->
    <b>背景图片（建议图片大小750&Chi;400，允许误差100已内）</b>
    <br>
    <img id="img1" alt="上传成功后显示图片" src="">
    <br>
    <input id="fileupload" type="file" name="fileImg" size="80" />
</div>
</body>
</html>

