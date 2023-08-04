<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%-- https://www.w3schools.com/bootstrap4/tryit.asp?filename=trybs_filters_table&stacked=h --%>
</head>
<div class="container mt-3">
	<h2>인기 목록 Table</h2>
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
	 		<td>참치</td>
	 		<td>1000</td>
	 		<td>동원</td>
	 	</tr>
	 	<tr>
	 		<td>비타민</td>
	 		<td>100</td>
	 		<td>건강한 나라</td>
	 	</tr>
	 	<tr>
	 		<td>오징어</td>
	 		<td>700</td>
	 		<td>바다</td>
	 	</tr>
	 	<tr>
	 		<td>에어컨</td>
	 		<td>300</td>
	 		<td>시원한나라</td>
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