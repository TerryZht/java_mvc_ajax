<%@ page import="com.mooc.Utils.CaptcahCode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录页面</title>
    <script type="text/javascript" src="<%=basePath%>resources/js/jquery-1.4.2.js"></script>
    <style type="text/css">
        .code
        {
            /*background:url(code_bg.jpg);*/
            font-family:Arial;
            font-style:italic;
            color:blue;
            font-size:20px;
            border:0;
            padding:2px 3px;
            letter-spacing:3px;
            font-weight:bolder;
            float:left;
            cursor:pointer;
            width:40px;
            height:20px;
            line-height:20px;
            text-align:center;
            vertical-align:middle;
            padding-right: 20px;
        }
        a
        {
            text-decoration:none;
            font-size:12px;
            color:#288bc4;
        }
        a:hover
        {
            text-decoration:underline;
        }
    </style>

</head>
<body onload="getCode()">
<center>
    <h1>用户登录</h1>
    <form action="<%=basePath%>/server.do" method="post" onsubmit="return validateCode()">
        <table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
            <tr>
                <td>用户名</td>
                <td colspan="2"><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合"></td>
            </tr>
            <tr>
                <td>密&nbsp;码</td>
                <td  colspan="2"><input type="password" name="password" placeholder="长度为5-12位字母数字或下划线组合" ></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td style="border-right-style:none;">
                    <input type="text" name="checkCode" placeholder="请输入验证码" id="inputCode" onchange="chkCode()" >
                </td>
                <%--<td style="border-left-style:none;"><div class="code" id="checkCode" ><img src="" alt="" id="codejpg" onclick="changeCode()"></div></td>--%>
                <td style="border-left-style:none;"><div class="code" id="checkCode" onclick="getCode()"></div></td>
            </tr>
            <tr>
                <td colspan="3" style="text-align:center">
                    <input type="submit" value="登录">
                    <input type="reset" value="取消">
                </td>
            </tr>
        </table>
    </form>


</center>

<script>
    function getCode() {

        $.ajax({
            type: "post",
            dataType: "json",
            url: "<%=basePath%>code",
            success: function (json) {
                $("#checkCode").empty();
                var data = eval(json);
                for (var i =0;i<data.length;i++) {
                    console.log(data[i]);
                    var html =data[i].code;
                    $("#checkCode").html(html);
                    window.checkCode = data[i].code;
                }
            }
        });

    };

    function chkCode() {
        var inputCode = document.getElementById("inputCode").value;
        if(inputCode.toLowerCase() != window.checkCode.toLowerCase()){
            document.getElementById("inputCode").value="";
            alert("验证码有错误请重新输入！！");
            getCode();
        }
    }
</script>
</body>
</html>