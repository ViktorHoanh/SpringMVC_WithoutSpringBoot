<%--
  Created by IntelliJ IDEA.
  User: 63200346
  Date: 6/25/2024
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management</title>
    <link rel="stylesheet" type="text/css" href="/Mini-project-springmvc/getResource/css/emp.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" crossorigin="anonymous">
</head>
<body>
<fieldset>
    <legend>Employee Management</legend>
    <div class="filter">
        <label for="team">Team</label>
        <select name="team" id="team">
            <option value="All">--All--</option>
            <c:forEach items="#{teamList}" var="t">
                <option value="${t.teamID}">${t.teamName}</option>
            </c:forEach>
        </select>
        <label for="project">Project</label>
        <select name="project" id="project">
            <option value="All">--All--</option>
            <c:forEach items="#{projectList}" var="p">
                <option value="${p.projectName}">${p.projectName}</option>
            </c:forEach>
        </select>
        <label for="status">Status</label>
        <select name="status" id="status">
            <option value="All">--All--</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select>
        <label for="fromdate">Start date</label>
        <input type="date" id="fromdate" name="fromdate" required>
        <input type="date" id="todate" name="todate" required>
    </div>
    <div class="search">
        <input type="search" id="searchBar" name="searchBar" required>
        <button>Search</button>
    </div>
</fieldset>
<div>
    <label>Total: ${fn:length(listEmployee)}</label>
    <div class="crudButtons">
        <button onclick="showPopup()">New</button>
        <button onclick="deleteSelectedEmployees()">Delete</button>
    </div>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th></th>
            <th>STT</th>
            <th>EmpID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Birthday</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Team</th>
            <th>Project</th>
            <th>Project Leader</th>
            <th>Start date</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="#{listEmployee}" var="e" varStatus="status">
            <tbody>
            <tr>
                <th><input type="checkbox" id="${e.empID}" name="checkbox" value="${e.empID}"></th>
                <th>${status.count}</th>
                <th>${e.empID}</th>
                <th>${e.empName}</th>
                <th>
                    <c:if test="${e.empGender}">Male</c:if>
                    <c:if test="${!e.empGender}">Female</c:if>
                </th>
                <th><fmt:formatDate value="${e.empBirthday}" pattern="yyyy-MM-dd" /></th>
                <th>${e.empPhone}</th>
                <th>${e.empEmail}</th>
                <th>${e.empAddress}</th>
                <th>${e.teamName}</th>
                <th>${e.projectName}</th>
                <th>${e.leaderName}</th>
                <th><fmt:formatDate value="${e.empStartDate}" pattern="yyyy-MM-dd" /></th>
                <th>
                    <c:if test="${e.empStatus}">Active</c:if>
                    <c:if test="${!e.empStatus}">Inactive</c:if>
                </th>
                <th onclick="getEmployeeByID('${e.empID}')">
                    <i class="fa-regular fa-pen-to-square"></i>
                </th>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
<div class="popup-overlay"></div>
<div class="popup">
    <p>Employee Information</p>
    <input type="hidden" id="empID" name="empID" value="${empID}">
    <c:url var="insertLink" value="/addNewEmployee">
        <c:param name="username" value="${username}"/>
    </c:url>
    <c:url var="updateLink" value="/updateEmployee">
        <c:param name="username" value="${username}"/>
        <c:param name="empID" value="${empID}"/>
    </c:url>
    <form
            <c:choose>
                <c:when test="${not empty empID}">
                    action="${updateLink}"
                </c:when>
                <c:otherwise>
                    action="${insertLink}"
                </c:otherwise>
            </c:choose>
            method="post" modelAttribute="employeeModel">
        <div class="empInformation">
            <label for="empName">Name</label>
            <input type="text" id="empName" name="empName" required>
            <label for="empGender">Gender</label>
            <select name="empGender" id="empGender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            <label for="empPhone">Phone</label>
            <input type="text" id="empPhone" name="empPhone" required>
            <label for="empAddress">Address</label>
            <input type="text" id="empAddress" name="empAddress" required>
            <label for="empBirthday">Birthday</label>
            <input type="date" id="empBirthday" name="empBirthday" required>
            <label for="empStartDate">Start date</label>
            <input type="date" id="empStartDate" name="empStartDate" required>
            <label for="teamID">Team</label>
            <select name="teamID" id="teamID">
                <c:forEach items="#{teamList}" var="e">
                    <option value="${e.teamID}">${e.teamName}</option>
                </c:forEach>
            </select>
            <label for="projectID">Project</label>
            <select name="projectID" id="projectID">
                <c:forEach items="#{projectList}" var="e">
                    <option value="${e.projectID}">${e.projectName}</option>
                </c:forEach>
            </select>
            <label>Status(active/inactive)</label>
            <label class="toggle">
                <input type="checkbox" name="empStatus" value="true">
                <span class="slider"></span>
                <span class="labels" data-on="Active" data-off="Inactive"></span>
            </label>
            <label for="empEmail">Email</label>
            <input type="email" id="empEmail" name="empEmail" required>
        </div>
        <button onclick="closePopup()">Cancel</button>
        <button type="submit" onclick="resetEmpID()">Save</button>
    </form>
</div>
<script src="//code.jquery.com/jquery-3.5.1.min.js" ></script>
<script type="text/javascript" src="/Mini-project-springmvc/getResource/js/listEmployee.js" ></script>
<script>
    function deleteSelectedEmployees() {
        const checkedCheckboxes = document.querySelectorAll('input[name="checkbox"]:checked');

        if (checkedCheckboxes.length === 0) {
            alert('Choose employees to delete.');
            return;
        }

        const confirmDelete = confirm('Are you sure to delete those employees');
        if (confirmDelete) {
            const employeeIDs = Array.from(checkedCheckboxes).map(checkbox => checkbox.id);

            $.ajax({
                type: "POST",
                url: "<c:url value='/deleteEmployees'/>",
                data: {
                    employeeIDs: employeeIDs,
                    username: "${username}"
                },
                success: function(response) {
                    console.log(response);
                    location.reload();
                },
                error: function(xhr, status, error) {
                    console.error(error);
                    alert("Cannot delete.");
                }
            });
        }
    }
    function getEmployeeByID(empID) {
        return $.ajax({
            url: "<c:url value='/getEmployeeByID'/>",
            type: "GET",
            data: {
                empID: empID
            },
            success: function(employee) {
                console.log(employee);
                document.getElementById('empID').value = empID;
                showPopupWithData(employee);
            },
            error: function(xhr, status, error) {
                console.error(error);
                console.error(`Cannot get emp: ${empID}`);
            }
        });
    }
    <%--function getEmployeeByID(employeeID) {--%>
    <%--    console.log(`EMPID: ${employeeID}`);--%>
    <%--    fetch(`/Mini-project-springmvc/getEmployeeByID?empID=${employeeID}`)--%>
    <%--        .then(response => {--%>
    <%--            if (!response.ok) {--%>
    <%--                throw new Error(`Error retrieving employee with ID ${employeeID}`);--%>
    <%--            }--%>
    <%--            return response.json();--%>
    <%--        })--%>
    <%--        .then(employee => {--%>
    <%--            console.log(employee);--%>
    <%--            document.getElementById('empID').value = employeeID;--%>
    <%--            showPopupWithData(employee);--%>
    <%--        })--%>
    <%--        .catch(error => {--%>
    <%--            console.error(`Cannot get emp: ${employeeID}`, error);--%>
    <%--        });--%>
    <%--}--%>


    function showPopupWithData(employee) {
        console.log(employee);
        showPopup();

        document.getElementById('empName').value = employee.empName;
        document.getElementById('empGender').value = employee.empGender ? 'Male' : 'Female';
        document.getElementById('empPhone').value = employee.empPhone;
        document.getElementById('empAddress').value = employee.empAddress;
        document.getElementById('empBirthday').value = employee.empBirthday;
        document.getElementById('empStartDate').value = employee.empStartDate;
        document.getElementById('teamID').value = employee.teamID;
        document.getElementById('projectID').value = employee.projectID;
        document.getElementById('empStatus').checked = employee.empStatus;
        document.getElementById('empEmail').value = employee.empEmail;
    }

</script>
</body>
</html>