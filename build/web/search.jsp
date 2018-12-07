<%-- 
    Document   : search
    Created on : Jun 29, 2018, 7:58:04 AM
    Author     : Mochi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, <s:property value="username"/>
            <s:property value="%{#session.USERNAME}"/>
        </font></br>
        <h1>Search Page</h1>
        <form action="searchLastName">
            Search <input type="text" name="searchLastName" value="" /></br>
            <input type="submit" value="Search" />
        </form>
        
        <s:if test="%{!searchLastName.isEmpty()}">
            <s:if test="%{listAccount != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>LastName</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listAccount" status="counter">
                            <s:form action="updatePassRole" theme="simple">  
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="username"/>
                                    <s:hidden name="username" value="%{username}"/>
                                </td>
                                <td>
                                    <s:textfield name="password" value="%{password}"/>
                                </td>
                                <td>
                                    <s:property value="lastname"/>
                                </td>
                                <td>
                                    <s:checkbox name="chkAmin" value="%{role}"/>
                                </td>
                                <td>
                                    <s:url id="delLink" action="deleteAction">
                                        <s:param name="username" value="username"/>
                                        <s:param name="searchLastName" value="searchLastName"/>
                                    </s:url>
                                    <s:a href="%{delLink}">Delete</s:a>
                                </td>
                                <td>
                                    <s:submit name="Update"/>
                                    <s:hidden name="searchLastName" value="searchLastName"/>
                                </td>
                            </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else>
                <h2>
                    <font color="red">No record is matched!!!</font>
                </h2>
            </s:else>
        </s:if>
            <s:a href="createAccount.html">Create new account</s:a>
            
    </body>
</html>
