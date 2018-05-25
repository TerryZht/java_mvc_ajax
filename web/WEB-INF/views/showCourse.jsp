
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>课程查询</title>
    <!-- 分页查看 -->
    <%--<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/js/dataTable/jquery.dataTables.min.css">--%>
    <style type="text/css">
       #searchValue{
           float: right;
       }
        #svl{
            margin-left: 78%;
        }
        #page1{
            float: left;
        }
       #page2{
           float: right;
       }
    </style>
    <script type="text/javascript"
            src="<%=basePath%>resources/js/jquery-1.4.2.js"></script>
    <%--<script type="text/javascript" src="<%=basePath%>resources/js/dataTable/jquery.js"></script>--%>
    <%--<script type="text/javascript" src="<%=basePath%>resources/js/dataTable/jquery.dataTables.min.js"></script>--%>
</head>
<body onload="JavaScript:pagePartition('first')">
<center><h1>课程查询</h1></center>
    <hr>
    <p>
        显示： <select name="ItemCount" id="ItemId" onchange="JavaScript:pagePartition('first')">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="ALL">全部</option>
        </select>
        条
    <span id="svl">搜索：</span><input type="text" name="searchValue" id="searchValue" onchange="search()">
    </p>

    <center>
    <table cellspacing="0px" cellpadding="0px" border="1px" width="100%" class="tablelist" id="example">
        <thead>
        <tr>
            <th>课程ID</th>
            <th>课程名</th>
            <th>方向</th>
            <th>描述</th>
            <th>时长(小时)</th>
            <th>操作人</th>
        </tr>
        </thead>
        <tbody id="tby">
        <c:forEach var="course" items="${courses}" >
            <tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.courseType}</td>
                <td>${course.description}</td>
                <td>${course.courseTime}</td>
                <td>${course.operator}</td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</center>
<p id="page1">
</p>
<p id="page2">
    <input class="page" type="submit" value="第一页" id="first" onclick="JavaScript:pagePartition('first')">
    <input class="page" type="submit" value="上一页" id="pre" onclick="JavaScript:pagePartition('pre')">
    <input type="submit" value="1" id="curr">
    <input class="page" type="submit" value="下一页" id="nxt" onclick="JavaScript:pagePartition('nxt')">
    <input class="page" type="submit" value="最后一页" id="lst" onclick="JavaScript:pagePartition('lst')">
</p>
<script>
function pagePartition(cType){
    $.ajax({
        type: "post",
        dataType: "json",
        url: "<%=basePath%>PagePartionServlet",
        data: {
            cType:cType,
            curr: $("#curr").val(),
            itemCnt: $("#ItemId").val()
        },
        success: function (json) {
            $("#tby").empty();
            $("#page1").empty();
            var data = eval(json);
            var html=null;
            var html1=null;
            if(data.length>1){
            for (var i =0;i<data.length-1;i++) {
                var html = html +"<tr><td>" + data[i].courseId + "</td><td>" + data[i].courseName + "</td><td>" +
                    data[i].courseType + "</td><td>" + data[i].description + "</td><td>" + data[i].courseTime +
                    "</td><td>" + data[i].operator +
                    "</td></tr>";
                $("#tby").html(html);

            }}else {
                $("#tby").empty();
//                var html = html +"<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
                var html="";
                $("#tby").html(html);
            }
            var html1="从"+data[data.length-1].start+"条到"+data[data.length-1].end+"条记录 总记录为"+data[data.length-1].cnt+"条";
            $("#page1").html(html1);
            document.getElementById("curr").value=data[data.length-1].currPage;
        }
    });
}
function search() {
$.ajax({
    type: "post",
    dataType: "json",
    url: "<%=basePath%>/searchCourse",
    data: {
        searchValue: $("input[name=searchValue]").val(),
    },
    success: function (json) {
    $("#tby").empty();
    var data = eval(json);
    var html=null;
    for (var i =0;i<data.length;i++) {
    console.log(data[i]);
    var html = html +"<tr><td>" + data[i].courseId + "</td><td>" + data[i].courseName + "</td><td>" +
        data[i].courseType + "</td><td>" + data[i].description + "</td><td>" + data[i].courseTime +
        "</td><td>" + data[i].operator +
        "</td></tr>";
    $("#tby").html(html);
}
}
});
}
</script>
</body>
</html>