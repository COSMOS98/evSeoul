<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>보도자료 | 전기차충전소</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/sub.css">
	<link rel="stylesheet" href="/resources/css/info/news.css">
	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<body>
	<!-- header-->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- newsUpdate -->
	<div id="subTitle">
	    <h3>보도자료</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getNews.do">정보마당</a></li>
	        <li><a href="getNews.do">보도자료</a></li>
	    </ul>
	</div> 
	<div id="subContents">   
		<form action="updateNews.do" method="post" name="board_form" id="boardWrite">
		<input type="hidden" name="SEQ" value="${news.SEQ}" />
			<table class="boardWrite">
			    <caption>글쓰기</caption>
			    <tr>
			        <th><label for="boardTitle">제목</label></th>
			        <td><input type="text" name="TITLE" id="boardTitle" required value="${news.TITLE}" /></td>
			        <th>작성자</th>
			        <td>${news.WRITER}</td>
			    </tr>
			    <tr>
			        <th><label for="boardContent">내용</label></th>
			        <td colspan="3">
			            <textarea name="CONTENT" id="boardContent" rows="15" required>${news.CONTENT}</textarea>
			        </td>
			    </tr>
			</table>
			<div class="pageBtn">
			    <div class="btnWrap">
			         <input type="submit" value="수정" class="submitBtn" />
			        <a href="getNews.do" class="listBtn">취소</a>
			    </div>
			</div>
		</form>
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>