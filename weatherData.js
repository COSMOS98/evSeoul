$(document).ready(function() {
	var lat = document.getElementById("LAT").value;	
	var lon = document.getElementById("LON").value;		
	var ret = dfs_xy_conv("toXY", lat, lon);
	var request = $.ajax({
		url: "getPublicData.do",	
		method: "post",			
		dataType: "json",			
		contentType: 'application/x-www-form-urlencoded; charset=utf-8',
		data: {
			base_url: "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst",
			ServiceKey: "Y9PMfd8KSkg7kx%2Brjh5m2lhijapwU3WId1GMoJGVQ5kWBBs1OQ%2FfpBgLISYBLsgKwAKy1QHs3FvKXo5Tl6xXEg%3D%3D",
			pageNo: "1",
			numOfRows: "44400",
			dataType: "JSON",
			base_date: getBaseDate(),
			base_time: getBaseTime(),
			nx: ret.x,		
			ny: ret.y		
		}
	});		
	
	request.done(function(data) {
		sky_chart(data.response.body.items.item);		
		var swiper = new Swiper('#weatherWrap .swiper-container', {
	        pagination: {
	            el: '#weatherWrap .swiper-pagination',
	        },
	        navigation: {  
	            nextEl: '#weatherWrap .swiper-button-next',
	            prevEl: '#weatherWrap .swiper-button-prev',
	        },	   
	        slidesPerView: 12,
	        spaceBetween: 0,
	        centeredSlides: false,
	    });	
	});
	
	request.fail(function(jqXHR, textStatus) {
		alert(textStatus);
	});	 
});	 


function sky_chart(data) {
	var arr_date = new Array();
	var arr_time = new Array();			
	var arr_time_label = new Array(); 
	var arr_sky = new Array();
	var arr_pty = new Array();
	var arr_tmp = new Array();
	var arr_pop = new Array();
	var arr_wth = new Array();	
	var arr_chg = new Array();	
	
	for(var i in data) {
		if(data[i].category == "SKY") {   
			arr_sky.push(data[i].fcstValue);
			arr_date.push(data[i].fcstDate);
			arr_time.push(data[i].fcstTime.substring(0,2));			
			var date = data[i].fcstDate;
			var time = data[i].fcstTime.substring(0,2);
			
			if(arr_time.length == 1) {
				arr_time_label.push(getDifferentDate(date));
			} else if(time == "00") {
				arr_time_label.push(getDifferentDate(date));
			} else {
				arr_time_label.push(Number(time)+" 시");
			}
		}
		if(data[i].category == "PTY") {   //강수상태
			arr_pty.push(data[i].fcstValue);
		}
		if(data[i].category == "TMP") {   //기온
			arr_tmp.push(data[i].fcstValue);
		}
		if(data[i].category == "POP") {   //강수확률
			arr_pop.push(data[i].fcstValue);
		}
	}
	
	for(var i in arr_time) {  
		if(arr_pty[i] == "0") {
			if(parseInt(arr_time[i]) > 18 || parseInt(arr_time[i]) <= 4) {  
				arr_wth[i] = "2";
			} else {
				arr_wth[i] = arr_sky[i];	
			}
		} else {
			arr_wth[i] = (parseInt(arr_pty[i])+4);
		}
	}
	
	for(var i in arr_time) { 
		var score = 100;				
		if(arr_tmp[i] < -10) {     
			score -= 20;
		} else if(arr_tmp[i] < 0) { 
			score -= 10;
		} else if(arr_tmp[i] > 34) {
			score -= 60;
		} else if(arr_tmp[i] > 32) {
			score -= 40;
		} else if(arr_tmp[i] > 29) {
			score -= 30;
		}
		
		if(arr_pty[i] == "4") { 		 
			score -= 80;
		} else if(arr_pty[i] != "0") { 
			score -= 40;
		} 
		arr_chg.push(score);  
	}
	
    for(var i in arr_wth) {
		var wdiv = document.createElement('div');
		wdiv.setAttribute("class", "swiper-slide");		
		var tmpWarp = document.createElement('div');
		tmpWarp.style = "height:60px;position:relative;";
		
		// 온도
		var tmp = document.createElement('h3');
		tmp.innerHTML = arr_tmp[i]+"º<br/>";
		var min = Math.min.apply(null, arr_tmp);
		var max = Math.max.apply(null, arr_tmp);
		tmp.style = "width:100%;margin-bottom:"+((arr_tmp[i]-min)*(35/(max-min))-10)+"px;position:absolute;bottom:10px;left:10px;"
		tmpWarp.appendChild(tmp);
		var tmpimg = document.createElement('img');
		if(arr_tmp[i] >= 30) {
			tmpimg.src = "/resources/images/evSearch/tmp1.png";	
		} else if(arr_tmp[i] > 0) {
			tmpimg.src = "/resources/images/evSearch/tmp2.png";
		} else {
			tmpimg.src = "/resources/images/evSearch/tmp3.png";
		}
		tmpWarp.appendChild(tmpimg);		
		wdiv.appendChild(tmpWarp);
		
		// 하늘
		var img = document.createElement('img');
		img.src = "/resources/images/evSearch/sky_"+arr_wth[i]+".gif";
		img.alt = "sky_"+i;
		wdiv.appendChild(img);		
		// 시간
		var time = document.createElement('h3');
		time.innerHTML = arr_time_label[i];
		
		if(getDifferentDate(arr_date[i])=="내일") {
			time.style = "color:#8f73f3 !important;"
		} else if(getDifferentDate(arr_date[i])=="모레") {
			time.style = "color:#53c6e2 !important;"
		} else if(getDifferentDate(arr_date[i])=="글피") {
			time.style = "color:#53c6e2 !important;"
		} else if(getDifferentDate(arr_date[i])=="그글피") {
			time.style = "color:#53c6e2 !important;"
		}
		wdiv.appendChild(time);
		
		// 충전
		var chgimg = document.createElement('img');
		if(arr_chg[i] >= 90) {		   
			chgimg.src = "/resources/images/evSearch/chg1.png";	
		} else if(arr_chg[i] >= 70) { 
			chgimg.src = "/resources/images/evSearch/chg2.png";
		} else if(arr_chg[i] >= 50) { 
			chgimg.src = "/resources/images/evSearch/chg3.png";
		} else if(arr_chg[i] >= 30) { 
			chgimg.src = "/resources/images/evSearch/chg4.png";
		} else if(arr_chg[i] >= 20) { 
			chgimg.src = "/resources/images/evSearch/chg5.png";
		} else {
			chgimg.src = "/resources/images/evSearch/chg5.png";
		}
		chgimg.style = "width:40px;height:40px;margin-top:10px;margin-left:15px;"
		wdiv.appendChild(chgimg);		
		document.getElementById("sky").appendChild(wdiv);
	}
}	

function getCurrentDate() {
    var date = new Date(); 
    var year = date.getFullYear().toString();
    var month = date.getMonth() + 1;
    month = month < 10 ? '0' + month.toString() : month.toString();
    var day = date.getDate();
    day = day < 10 ? '0' + day.toString() : day.toString();
    return year + month + day ;
}

function getYesterDate() {
	var date = new Date();
	var yesterday = new Date(date.setDate(date.getDate() - 1));
	
    var year = yesterday.getFullYear().toString();
    var month = yesterday.getMonth() + 1;
    month = month < 10 ? '0' + month.toString() : month.toString();
    var day = yesterday.getDate();
    day = day < 10 ? '0' + day.toString() : day.toString();
    return year + month + day ;
}

function getDifferentDate(date) {
	var sdt = new Date();
	var edt = new Date(date.substring(0,4),date.substring(4,6)-1,date.substring(6,8));
	var dateDiff = Math.ceil((edt.getTime()-sdt.getTime())/(1000*3600*24));
	
	if(dateDiff == 0) {
		return "오늘";
	} else if(dateDiff == 1) {
		return "내일";		
	} else if(dateDiff == 2) {
		return "모레";		
	} else if(dateDiff == 3) {
		return "글피";		
	} else {  
		return "그글피";		
	}
}

function getCurrentTime() {
	var date = new Date(); 		 		
	var hours = date.getHours().toString();	
	
	if(hours.length == 1) {
		return hours = "0"+hours;
	}
	return hours+"00";	
}

function getBaseDate() {
	var date = new Date(); 		 	  	
	var hours = date.getHours().toString();	 	   
	var minutes = date.getMinutes().toString();   
	minutes = minutes < 10 ? '0' + minutes.toString() : minutes.toString();
	var hm = hours+minutes;						
	
	if(hm < 206) {
		return getYesterDate();
	} else if(hm < 506) {
		return getCurrentDate();
	} else if(hm < 806) {
		return getCurrentDate();
	} else if(hm < 1106) {
		return getCurrentDate();
	} else if(hm < 1406) {
		return getCurrentDate();
	} else if(hm < 1706) {
		return getCurrentDate();
	} else if(hm < 2006) {
		return getCurrentDate();
	} else if(hm < 2306) {
		return getCurrentDate();
	} else {
		return getCurrentDate();
	}
}

function getBaseTime() {
	var date = new Date(); 		 	  	
	var hours = date.getHours().toString();	 	   	
	var minutes = date.getMinutes().toString();    
	minutes = minutes < 10 ? '0' + minutes.toString() : minutes.toString();
	var hm = hours+minutes;						
	
	if(hm < 206) {  	
		return "2300";   
	} else if(hm < 506) {
		return "0200";
	} else if(hm < 806) {
		return "0500";
	} else if(hm < 1106) {
		return "0800";
	} else if(hm < 1406) {
		return "1100";
	} else if(hm < 1706) {
		return "1400";
	} else if(hm < 2006) {
		return "1700";
	} else if(hm < 2306) {
		return "2000";
	} else {
		return "2300";
	}
}

 // 좌표변환
 var RE = 6371.00877; // 지구 반경(km)
 var GRID = 5.0; 	  // 격자 간격(km)
 var SLAT1 = 30.0;    // 투영 위도1(degree)
 var SLAT2 = 60.0;    // 투영 위도2(degree)
 var OLON = 126.0;    // 기준점 경도(degree)
 var OLAT = 38.0;     // 기준점 위도(degree)
 var XO = 43; 		  // 기준점 X좌표(GRID)
 var YO = 136; 		  // 기1준점 Y좌표(GRID)
 
 function dfs_xy_conv(code, v1, v2) {
     var DEGRAD = Math.PI / 180.0;
     var RADDEG = 180.0 / Math.PI;
     var re = RE / GRID;
     var slat1 = SLAT1 * DEGRAD;
     var slat2 = SLAT2 * DEGRAD;
     var olon = OLON * DEGRAD;
     var olat = OLAT * DEGRAD;
     var sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5);
     sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
     var sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
     sf = Math.pow(sf, sn) * Math.cos(slat1) / sn;
     var ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
     ro = re * sf / Math.pow(ro, sn);
     var rs = {};
     
     if (code == "toXY") {
         rs['lat'] = v1;
         rs['lon'] = v2;
         var ra = Math.tan(Math.PI * 0.25 + (v1) * DEGRAD * 0.5);
         ra = re * sf / Math.pow(ra, sn);
         var theta = v2 * DEGRAD - olon;
         if (theta > Math.PI) theta -= 2.0 * Math.PI;
         if (theta < -Math.PI) theta += 2.0 * Math.PI;
         theta *= sn;
         rs['x'] = Math.floor(ra * Math.sin(theta) + XO + 0.5);
         rs['y'] = Math.floor(ro - ra * Math.cos(theta) + YO + 0.5);
     }
     else {
         rs['x'] = v1;
         rs['y'] = v2;
         var xn = v1 - XO;
         var yn = ro - v2 + YO;
         ra = Math.sqrt(xn * xn + yn * yn);
         if (sn < 0.0) - ra;
         var alat = Math.pow((re * sf / ra), (1.0 / sn));
         alat = 2.0 * Math.atan(alat) - Math.PI * 0.5;

         if (Math.abs(xn) <= 0.0) {
             theta = 0.0;
         }
         else {
             if (Math.abs(yn) <= 0.0) {
                 theta = Math.PI * 0.5;
                 if (xn < 0.0) - theta;
             }
             else theta = Math.atan2(xn, yn);
         }
         var alon = theta / sn + olon;
         rs['lat'] = alat * RADDEG;
         rs['lon'] = alon * RADDEG;
     }
     return rs;
 }