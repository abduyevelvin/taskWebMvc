<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/14/2018
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">

    $(function () {
        $('#cityCmbId').val('${employee.city_id}');
        $('#experienceCmbId').val('${employee.experience_id}');
    });
    
</script>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">View Employee</h4>
</div>
<div class="modal-body">
    <div class="form-group">
        <label>Name</label>
        <input type="text" class="form-control" value="${employee.name}" disabled="disabled" />
    </div>
    <div class="form-group">
        <label>Surname</label>
        <input type="text" class="form-control" disabled="disabled" value="${employee.surname}" />
    </div>
    <div class="form-group">
        <label>Age</label>
        <input type="number" class="form-control" disabled="disabled" value="${employee.age}" />
    </div>
    <div class="form-group">
        <label>Job Title</label>
        <input type="text" class="form-control" disabled="disabled" value="${employee.job_title}" />
    </div>
    <div class="form-group">
        <label>City</label>
        <select class="form-control" id="cityCmbId" disabled="disabled">
            <option value="0">Choose City</option>
            <c:forEach items="${cityList}" var="cl">
                <option value="${cl.id_city}">${cl.city}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Experience</label>
        <select class="form-control" id="experienceCmbId" disabled="disabled">
            <option value="0">Choose Experience</option>
            <c:forEach items="${experienceList}" var="exl">
                <option value="${exl.id_experience}">${exl.experience}</option>
            </c:forEach>
        </select>
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-outline btn-primary pull-right" data-dismiss="modal">Close</button>
</div>