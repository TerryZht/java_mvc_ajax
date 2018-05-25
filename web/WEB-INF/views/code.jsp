<%@ page import="com.mooc.Utils.CaptcahCode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("---------------------------------------------");
    response.setHeader("pragma","no-cache");
    response.setHeader("cache-control","no-cache");
    response.setHeader("expires","0");
    String code = CaptcahCode.drawImag(response);
    session.setAttribute("codejpg",code);
    request.getServletContext().setAttribute("codereq",code);
    System.out.println(session.getAttribute("codejpg"));
    out.clear();
    out=pageContext.pushBody();

%>

