<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%-- https://www.w3schools.com/bootstrap4/tryit.asp?filename=trybs_filters_table&stacked=h --%>

<div class="container mt-3">
	<h2>중고상품 목록 Table</h2>
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
	 		<td>노트북</td>
	 		<td>200,000</td>
	 		<td>컴나라</td>
	 	</tr>
	 	<tr>
	 		<td>벨트</td>
	 		<td>100</td>
	 		<td>르메르</td>
	 	</tr>
	 	<tr>
	 		<td>모자</td>
	 		<td>703</td>
	 		<td>폴로</td>
	 	</tr>
	 	<tr>
	 		<td>자켓</td>
	 		<td>300</td>
	 		<td>아워레가시</td>
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