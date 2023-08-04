<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>ArrayList 이용합니다.</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        .container {
            width: 500px;
            margin-top: 3em;
        }

        table,
        h4 {
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="container">
       <c:if test="${!empty list}">
        <table class="table">
            <thead>
                <tr>
                    <th>DEPTNO</th>
                    <th>DNAME</th>
                    <th>LOC</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="dept" items="${list}">
                <tr>
                    <td>${dept.deptno}</td>
                    <td>${dept.dname}</td>
                    <td>${dept.loc}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
       </c:if>
       
       <c:if test="${empty list}"> 
        	<h4>조회된 데이터가 없습니다.</h4>
        </c:if>	
    </div>
</body>
</html>
