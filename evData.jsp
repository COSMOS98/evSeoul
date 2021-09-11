<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>충전기 정보 | 전기차충전소</title>
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/sub.css">
	<link rel="stylesheet" href="/resources/css/intro/intro.css">
	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<body>
	<!-- header-->
	<jsp:include page="../includes/header.jsp" />
	
	<!-- evData -->
	<div id="subTitle">
	    <h3>충전기 정보</h3>
	    <ul class="indicator">
	        <li><a href="getIndex.do">HOME</a></li>
	        <li><a href="getEvData.do">소개</a></li>
	        <li><a href="getEvData.do">충전기 정보</a></li>
	    </ul>
	</div> 
	<div class="evDataContents">
		<h3>급속 충전기</h3>
		<table class="boardList">
			<caption>충전기정보 목록</caption>
			<tr>
			    <th>모델번호</th>
			    <td>FC50K-CCA-TR Series</td>
			    <td rowspan="8"><img src="/resources/images/intro/qSignet.PNG" alt="충전기정보" /></td>
			</tr>
			<tr>
				<th>입력전압</th>
			    <td>AC380V</td>
			</tr>
			<tr>
				<th>출력전압</th>
			    <td>DC 400V(차데모,콤보) /AC380V (AC급속)</td>
			</tr>
			<tr>
				<th>정격용량</th>
			    <td>50kW(90A)</td>
			</tr>
			<tr>
				<th>커넥터</th>
			    <td>DC차데모+AC3상+DC콤보</td>
			</tr>
			<tr>
				<th>충전시간</th>
			    <td>약 30분(28kW 기준)</td>
			</tr>
			<tr>
				<th>제조사</th>
			    <td>(주)시그넷시스템</td>
			</tr>
		</table>	
		<table class="boardList">
			<tr>
			    <th>모델번호</th>
			    <td>SOF101BDC1A021</td>
			    <td rowspan="8"><img src="/resources/images/intro/qSpeel.PNG" alt="충전기정보" /></td>
			</tr>
			<tr>
				<th>입력전압</th>
			    <td>AC380V</td>
			</tr>
			<tr>
				<th>출력전압</th>
			    <td>DC 500V</td>
			</tr>
			<tr>
				<th>정격용량</th>
			    <td>107kW</td>
			</tr>
			<tr>
				<th>커넥터</th>
			    <td>DC차데모+AC3상+DC콤보</td>
			</tr>
			<tr>
				<th>충전시간</th>
			    <td>약30분(27kWh 기준)</td>
			</tr>
			<tr>
				<th>제조사</th>
			    <td>(주)스필 </td>
			</tr>
		</table>
		<table class="boardList">
			<tr>
			    <th>모델번호</th>
			    <td>DM-3FT50</td>
			    <td rowspan="8"><img src="/resources/images/intro/qChrevi.PNG" alt="충전기정보" /></td>
			</tr>
			<tr>
				<th>입력전압</th>
			    <td>AC 380V</td>
			</tr>
			<tr>
				<th>출력전압</th>
			    <td>DC 450V</td>
			</tr>
			<tr>
				<th>정격용량</th>
			    <td>50kW</td>
			</tr>
			<tr>
				<th>커넥터</th>
			    <td>DC차데모+AC3상+DC콤보</td>
			</tr>
			<tr>
				<th>충전시간</th>
			    <td>약 30분(28kW 기준)</td>
			</tr>
			<tr>
				<th>제조사</th>
			    <td>대영채비(주)</td>
			</tr>
		</table>
		
		<h3>완속 충전기</h3>
		<table class="boardList">
			<caption>충전기정보 목록</caption>
			<tr>
			    <th>모델번호</th>
			    <td>7K-EV-C1C2 Series</td>
			    <td rowspan="8"><img src="/resources/images/intro/sSignet1.PNG" alt="충전기정보" /></td>
			</tr>
			<tr>
				<th>입력전압</th>
			    <td>AC220V</td>
			</tr>
			<tr>
				<th>출력전압</th>
			    <td>AC220V</td>
			</tr>
			<tr>
				<th>정격용량</th>
			    <td>7kW(32A)</td>
			</tr>
			<tr>
				<th>커넥터</th>
			    <td>승용차 AC완속</td>
			</tr>
			<tr>
				<th>충전시간</th>
			    <td>약 4~6시간(28kW 가준)</td>
			</tr>
			<tr>
				<th>제조사</th>
			    <td>(주)시그넷시스템</td>
			</tr>
		</table>
		<table class="boardList">
			<caption>충전기정보 목록</caption>
			<tr>
			    <th>모델번호</th>
			    <td>7K-EV-B1-POLE Series</td>
			    <td rowspan="8"><img src="/resources/images/intro/sSignet2.PNG" alt="충전기정보" /></td>
			</tr>
			<tr>
				<th>입력전압</th>
			    <td>AC220V</td>
			</tr>
			<tr>
				<th>출력전압</th>
			    <td>AC220V</td>
			</tr>
			<tr>
				<th>정격용량</th>
			    <td>7kW(32A)</td>
			</tr>
			<tr>
				<th>커넥터</th>
			    <td>승용차 AC완속</td>
			</tr>
			<tr>
				<th>충전시간</th>
			    <td>약 4~6시간(28kW 가준)</td>
			</tr>
			<tr>
				<th>제조사</th>
			    <td>(주)시그넷시스템</td>
			</tr>
		</table>			
		<table class="boardList">
			<tr>
			    <th>모델번호</th>
			    <td>DM-3SC14</td>
			    <td rowspan="8"><img src="/resources/images/intro/sChrevi.PNG" alt="충전기정보" /></td>
			</tr>
			<tr>
				<th>입력전압</th>
			    <td>220V</td>
			</tr>
			<tr>
				<th>출력전압</th>
			    <td>220V</td>
			</tr>
			<tr>
				<th>정격용량</th>
			    <td>7kW</td>
			</tr>
			<tr>
				<th>커넥터</th>
			    <td>승용차 AC완속</td>
			</tr>
			<tr>
				<th>충전시간</th>
			    <td>약 4-6시간(28kW 기준)</td>
			</tr>
			<tr>
				<th>제조사</th>
			    <td>대영채비(주) </td>
			</tr>
		</table>
	</div>
	
	<!-- footer -->
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>