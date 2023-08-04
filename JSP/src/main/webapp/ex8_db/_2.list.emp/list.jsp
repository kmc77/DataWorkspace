<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<%@ page import="java.util.*, ex8_emp.Emp" %>
<!DOCTYPE html>
<html>
<head>
    <title>ArrayList 이용합니다.</title>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <style>
        .container {
            /*width: 500px;*/
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
    <p>검색어를 입력하세요</p>
    	<input class="form-control" id="myInput" type="text" placeholder="Search..">
        <%
        ArrayList<Emp> list = (ArrayList<Emp>) request.getAttribute("list");
    
        if (!list.isEmpty()) {
        %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>사원번호</th>
                    <th>사원이름</th>
                    <th>직급</th>
                    <th>매니저</th>
                    <th>입사일자</th>
                    <th>급여</th>
                    <th>커미션</th>
                    <th>부서번호</th>
                </tr>
            </thead>
            <tbody id="myTable">
                <%
                for (Emp e : list) {
                %>
                <tr>
                    <td><%= e.getEmpno() %></td>
                    <td><%= e.getEname() %></td>
                    <td><%= e.getJob() %></td>
                    <td><%= e.getMgr() %></td>
                    <td><%= e.getHiredate() %></td>
                    <td><%= e.getSal() %></td>
                    <td><%= e.getComm() %></td>
                    <td><%= e.getDeptno() %></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
     <%
    } else {
        out.print("<h4>조회된 데이터가 없습니다.</h4>");
    }
	%>
    </div>
   <script>
    $("#myInput").on('keyup', function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function(){
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
</script> 
</body>
</html>
