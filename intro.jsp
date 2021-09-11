<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>충전소 소개 | 전기차충전소</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/sub.css">
	<link rel="stylesheet" href="/resources/css/intro/intro.css">
	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<body>
	<!-- header-->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- intro -->
	<div id="subTitle">
	    <h3>충전소 역할</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getIntro.do">전기차충전소 소개</a></li>
	        <li><a href="getIntro.do">충전소 역할</a></li>
	    </ul>
	</div> 
	<div id="subContents">
		<div class="introWrap">
			<ul>
				<li class="introContent">
					<p>
						&nbsp;&nbsp;서울 전기차충전소는 서울시에 설치한 전기차 충전기에 대하여
						전기차 사용자에게 <span>충전기의 위치 및 상태를 안내</span>합니다.
						<br/><br/>
						전기차 사용자가 충전 시에 겪는 어려움에 대하여
						<span>전화, 홈페이지, 앱</span>을 통하여 안내합니다.<br/>
						사용자의 의견을 수렴하고 적절히 반영하여 더 나은 전기차 사용환경을
						만들기 위해 노력합니다.
					</p><br/>
					<p>
						충전기에 대하여 IoT통신으로 충전기 상태를 확인하고
						충전기가 고장이 없도록 관리합니다.
					</p><br/>
					<p>
						전기차와 관련한 서울시의 보급정책 등에 대한 정보를 제공합니다.
					</p>
				</li>
				<li class="introImg">
					<img src="/resources/images/intro/intro.jpg" alt="충전소 역할" />
				</li>
			</ul>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>