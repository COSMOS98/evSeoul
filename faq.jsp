<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FAQ | 전기차충전소</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/sub.css">
	<link rel="stylesheet" href="/resources/css/customer/faq.css">
	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<body>
	<!-- header-->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- faq -->
	<div id="subTitle">
	    <h3>FAQ</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getFaqList.do">고객센터</a></li>
	        <li><a href="getFaqList.do">FAQ</a></li>
	    </ul>
	</div> 
	<div id="subContents">
		<div class="tableTop">
		    <form action="getFaqList.do" method="get" name="board_form" id="boardForm">
		        <select name="type" id="findSelect">				
					<option value="T"
						<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
					<option value="C"
						<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
					<option value="TC"
						<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목+내용</option>
				</select>
				<input type="text" name="keyword" id="searchBox" value='<c:out value="${pageMaker.cri.keyword}"/>' />
				<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
				<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}"/>' />
				<input type="submit" name="search_btn" id="searchBtn" value="검색" />
		    </form>
		</div>
		<c:choose>
			<c:when test="${not empty faq}">
		        <div class="faqBox">
			        <dl>
		                <c:forEach items="${faq}" var="faq">
			            <dt>
			            	<a href="#" title="답변보기">${faq.TITLE}</a>
			            </dt>
			            <dd>${faq.CONTENT}</dd>
			            </c:forEach>
			        </dl>
		        </div>
	        </c:when>
	        <c:when test="${empty faq}">
	        	<div class="faqBox">			        
			        <p>검색 결과가 없습니다.</p>
		        </div>
	        </c:when>
    	</c:choose>
        <form id="actionForm" action="getFaqList.do" method="get">
			<input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type}"/>' />
			<input type='hidden' name='keyword' value='<c:out value="${ pageMaker.cri.keyword}"/>' />
		</form> 
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
	<script src="/resources/js/customer/faq.js"></script>
</body>
</html>