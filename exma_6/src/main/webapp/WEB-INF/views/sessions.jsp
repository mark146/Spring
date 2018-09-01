<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%!
    private static String toString(long timeInterval)
    {
        if(timeInterval < 1_000)
            return "less than one second";
        if(timeInterval < 60_000)
            return (timeInterval / 1_000) + " seconds";
        return "about " + (timeInterval / 60_000) + " minutes";
    }
%>
<%
    @SuppressWarnings("unchecked")
    List<HttpSession> sessions =
            (List<HttpSession>)request.getAttribute("sessionList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <head>
        <title>Customer Support</title>
    </head>
    
    <body>
        <h2>Sessions</h2>
        There are a total of ${numberOfSessions} active sessions in this application.<br /><br />
        <%
            long timestamp = System.currentTimeMillis();
            for(HttpSession aSession : sessions)
            {
                out.print(aSession.getId() + " - " + aSession.getAttribute("username"));
                if(aSession.getId().equals(session.getId()))
                    out.print(" (you)");
                out.print(" - last active " + toString(timestamp - aSession.getLastAccessedTime()));
                out.println(" ago<br />");
            }
        %>
	<a href="<c:url value='/'/>">[홈으로 가기]</a>
    </body>
</html>
