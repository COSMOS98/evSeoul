<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 | 전기차충전소</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/sub.css">
	<link rel="stylesheet" href="/resources/css/customer/notice.css">
	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<body>
	<!-- header-->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- noticeDetail -->
	<div id="subTitle">
	    <h3>공지사항</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getNotice.do">고객센터</a></li>
	        <li><a href="getNotice.do">공지사항</a></li>
	    </ul>
	</div> 
	<div id="subContents">
		<table class="boardView">
		    <caption>게시글 확인</caption>
		    <tr>
		        <th>제목</th>
		        <td class="noticeTitle">${notice.TITLE}</td>
		        <th>조회수</th>
		        <td>${notice.CNT}</td>
		    </tr>
		    <tr>
		        <th>작성자</th>
		        <td class="noticeWriter">${notice.WRITER}</td>
		        <th>작성일</th>
		        <td>${notice.getREG_DT()}</td>
		    </tr>
		    <tr>
		        <th>내용</th>
		        <td colspan="3" class="substance">${notice.CONTENT}</td>
		    </tr>
		</table>
		<div class="pageBtn">
		    <div class="btnWrap">
		        <a href="getNotice.do" class="listBtn">목록</a>
		        <a href="getNoticeUpdateForm.do?SEQ=${notice.SEQ}" class="modifyBtn">수정</a>
		        <a href="deleteNotice.do?SEQ=${notice.SEQ}" class="deleteBtn">삭제</a>
		    </div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>