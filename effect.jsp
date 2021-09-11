<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>기대효과 | 전기차충전소</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/sub.css">
	<link rel="stylesheet" href="/resources/css/intro/intro.css">
	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<body>
	<!-- header-->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- effect -->
	<div id="subTitle">
	    <h3>기대효과</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getEffect.do">소개</a></li>
	        <li><a href="getEffect.do">기대효과</a></li>
	    </ul>
	</div> 
	<div id="subContents">
		<div class="effectWrap">
			<img src="/resources/images/intro/effect_1.png" alt="기대효과" />
			<img src="/resources/images/intro/effect_2.png" alt="기대효과" />
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>