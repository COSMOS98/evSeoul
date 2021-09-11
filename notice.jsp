<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<!-- notice -->
	<div id="subTitle">
	    <h3>공지사항</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getNotice.do">고객센터</a></li>
	        <li><a href="getNotice.do">공지사항</a></li>
	    </ul>
	</div> 
	<div id="subContents">
		<table class="boardList">
			<caption>공지사항 목록</caption>
			<tr>
			    <th>번호</th>
			    <th>제목</th>
			    <th>작성자</th>
			    <th>작성일</th>
			    <th>조회</th>
			</tr>
			<c:forEach items="${noticeList}" var="notice">
			<tr>
			    <td>${notice.SEQ}</td>
			    <td>
			   		<a href="getNoticeDetail.do?SEQ=${notice.SEQ}">${notice.TITLE}</a>
			    </td>
			    <td>${notice.WRITER}</td>
			    <td>${notice.getREG_DT()}</td>
			    <td>${notice.CNT}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="pageBtn">
	        <div class="pageNum">
	        	<ul>
	        		<c:if test="${pageMaker.prev}">
	        			<li>
							<a class="numList" href="${pageMaker.startPage-1}">
		                        <img src="/resources/images/common/prev.png" />
		                    </a>
	                    </li>
	        		</c:if>
	        		<c:if test="${!pageMaker.prev}">
	        			<li>
							<a><img src="/resources/images/common/prev_disabled.png" /></a>
						</li>
	        		</c:if>      		
	        		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
	        			<li>
		        			<c:choose>
		        				<c:when test="${pageMaker.cri.pageNum == num}">
		        					<a class="numList" href="${num}"><span>${num}</span></a>
		        				</c:when>
		        				<c:otherwise>
		        					<a class="numList" href="${num}">${num}</a>
		        				</c:otherwise>
		        			</c:choose>
	       				</li>
	        		</c:forEach>
	        		<c:if test="${pageMaker.next}">
	        			<li>		       
		        			<a class="numList" href="${pageMaker.endPage+1}">
		                        <img src="/resources/images/common/next.png" />
		                    </a>
		            	</li>
	        		</c:if>
	        		<c:if test="${!pageMaker.next}">
	        			<li>
							<a><img src="/resources/images/common/next_disabled.png" /></a>
						</li>
	        		</c:if>
        		</ul>
	        </div>
	        <div class="btnWrap">
	            <a href="getNoticeInsertForm.do" class="writeBtn">글쓰기</a>
	        </div>
        </div> 
        <form id="actionForm" action="getNotice.do" method="get">
			<input type="hidden" name="pageNum" value='${pageMaker.cri.pageNum}' />
			<input type="hidden" name="amount" value='${pageMaker.cri.amount}' />
		</form>  
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />	
	<script src="/resources/js/paging.js"></script>
</body>
</html>