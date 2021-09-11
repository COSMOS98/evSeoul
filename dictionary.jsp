<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>용어사전 | 전기차충전소</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/sub.css">
	<link rel="stylesheet" href="/resources/css/info/dictionary.css">
	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<body>
	<!-- header-->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- dictionary -->
	<div id="subTitle">
	    <h3>용어사전</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getDicList.do">정보마당</a></li>
	        <li><a href="getDicList.do">용어사전</a></li>
	    </ul>
	</div> 
	<div id="subContents">
		<div class="tableTop">		    
			<form action="getDicList.do" method="get" name="board_form" id="searchForm">
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
			<c:when test="${not empty dictionary}">
		        <div class="dicBox">
			        <dl>
		                <c:forEach items="${dictionary}" var="dic">
			            <dt>
			            	<a href="#" title="답변보기">${dic.TITLE}</a>
			            </dt>
			            <dd>${dic.CONTENT}</dd>
			            </c:forEach>
			        </dl>
		        </div>
	        </c:when>
	        <c:when test="${empty dictionary}">
	        	<div class="dicBox">			        
			        <p>검색 결과가 없습니다.</p>
		        </div>
	        </c:when>
        </c:choose>       
		<div class="pageBtn">
	        <div class="pageNum">
	        	<ul>
	        		<c:if test="${not empty dictionary}">
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
	        		</c:if>
        		</ul>
	        </div>
	        <form id="actionForm" action="getDicList.do" method="get">
				<input type="hidden" name="pageNum" value='${pageMaker.cri.pageNum}' />
				<input type="hidden" name="amount" value='${pageMaker.cri.amount}' />
				<input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type}"/>' />
				<input type='hidden' name='keyword' value='<c:out value="${ pageMaker.cri.keyword}"/>' />
			</form> 
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />	
	<script src="/resources/js/paging.js"></script>
	<script src="/resources/js/info/dictionary.js"></script>
</body>
</html>