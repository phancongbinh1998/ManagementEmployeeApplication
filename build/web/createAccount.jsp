<%-- 
    Document   : createAccount
    Created on : Jul 9, 2018, 7:53:44 AM
    Author     : Mochi
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Create Account Page</h1>
        <s:form action="createAccount"> 
            <s:textfield name="username" value=""/></br>
            <s:password name="password" value=""/></br>
            <s:textfield name="lastname" value=""/></br>
            <s:checkbox name="chkAdmin" value=""/></br>
            <s:submit name="Create new account"/>
            <s:reset name="Reset"/>
        </s:form>
        <s:if test="%{exception.message.contain('duplicate')}">
            <font color="red">
            <s:property value="username"/>Is existed!!!
            </font>    
        </s:if>
    </body>
</html>
