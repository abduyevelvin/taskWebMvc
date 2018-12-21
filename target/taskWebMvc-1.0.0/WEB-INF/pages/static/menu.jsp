<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/13/2018
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="sidebar-menu" data-widget="tree">
    <li class="header">Main Menu</li>

    <c:choose>
        <c:when test="${user.role_name eq 'admin'}">
            <li class="treeview">
                <a href="#"><i class="fa fa-suitcase"></i> <span>Employees</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/employeeList">List of Employees</a></li>
                    <li><a href="${pageContext.request.contextPath}/newEmployee">Add New Employee</a></li>
                </ul>
            </li>
        </c:when>
        <c:when test="${user.role_name eq 'user'}">
            <li class="treeview">
                <a href="#"><i class="fa fa-suitcase"></i> <span>Employees</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/employeeList">List of Employees</a></li>
                </ul>
            </li>
        </c:when>
    </c:choose>
</ul>
