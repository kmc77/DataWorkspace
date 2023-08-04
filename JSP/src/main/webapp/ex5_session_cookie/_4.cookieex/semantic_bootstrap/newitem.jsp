<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%-- https://www.w3schools.com/bootstrap4/tryit.asp?filename=trybs_filters_table&stacked=h --%>

<div class="container mt-3">
	<h2>신상품 목록 Table</h2>
	<p>상품입력하세요.</p>
	<input class="form-control" id="myInput" ytpe="search" placeholder="Search..">
	<br>
	<table class="table table-bordered">
	 <thead>
	 	<tr>
	 		<th>상품이름</th>
	 		<th>가격</th>
	 		<th>제조사</th>
	 	</tr>
	 </thead>
	 <tbody id="myTable">
	 	<tr>
	 		<td>갤럭시 s21 울트라</td>
	 		<td>8000</td>
	 		<td>삼성</td>
	 	</tr>
	 	<tr>
	 		<td>홍삼</td>
	 		<td>4200</td>
	 		<td>종근당</td>
	 	</tr>
	 	<tr>
	 		<td>커피</td>
	 		<td>700</td>
	 		<td>메가</td>
	 	</tr>
	 </tbody>		
	</table>
</div>
<script>
	$("#myInput").on("keyup", function() {
		const value = $(this).val().toLowerCase();
		$("#myTable tr").each(function() {
			console.log($(this).text().toLowerCase().indexOf(value) > -1)
			
			//toggle(true)는 선택한 요소를 보이도록 설정하는 메소드입니다.
			//tohhle(false)는 선택한 요소에 style="display: none;" 속성이 추가되어 보이지 않도록 합니다.
			$(this).toggle($(this).text().toLowerCase().indexOf(value) >-1)
			
		}):
	});

</script>
</html>