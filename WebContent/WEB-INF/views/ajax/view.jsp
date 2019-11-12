<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
		<h3>게시물정보</h3>
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td></td>
			</tr>
			<tr>
				<th>제목</th>
				<td></td>
			</tr>
			<tr>
				<th>내용</th>
				<td></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td></td>
			</tr>
			<tr>
				<th>작성시간</th>
				<td></td>
			</tr>
			<tr>
				<th colspan="2"><button>저장</button></th>
			</tr>
		</table>
	</div>
	<script>
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax/board/view?biNum=${param.biNum}');
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.onreadystatechange = function(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			document.write();
		}
	}
	</script>
</body>
</html>