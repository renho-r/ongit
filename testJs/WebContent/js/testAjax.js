var xmlHttp;
function initXmlHttp() {
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("您的浏览器不支持AJAX！");
				return false;
			}
		}
	}
}

initXmlHttp();

var sendGetButton = document.getElementById("sendAjaxGet");
sendGetButton.onclick = function() {
	xmlHttp.onreadystatechange = function() {
		if (0 == xmlHttp.readyState) {
			console.info("请求未初始化（在调用 open() 之前） ");
		} else if (1 == xmlHttp.readyState) {
			console.info("请求已提出（调用 send() 之前）");
		} else if (2 == xmlHttp.readyState) {
			console.info("请求已发送（这里通常可以从响应得到内容头部）");
		} else if (3 == xmlHttp.readyState) {
			console.info("请求处理中（响应中通常有部分数据可用，但是服务器还没有完成响应）");
		} else if (4 == xmlHttp.readyState) {
			console.info("请求已完成（可以访问服务器响应并使用它）");
			document.myForm.time.value = xmlHttp.responseText;
		}
	}
	xmlHttp.open("GET", "/testJs/ajax", true);
	xmlHttp.send(null);
}

var sendPostButton = document.getElementById("sendAjaxPost");
sendPostButton.onclick = function() {
	xmlHttp.onreadystatechange = function() {
		if (0 == xmlHttp.readyState) {
			console.info("请求未初始化（在调用 open() 之前） ");
		} else if (1 == xmlHttp.readyState) {
			console.info("请求已提出（调用 send() 之前）");
		} else if (2 == xmlHttp.readyState) {
			console.info("请求已发送（这里通常可以从响应得到内容头部）");
		} else if (3 == xmlHttp.readyState) {
			console.info("请求处理中（响应中通常有部分数据可用，但是服务器还没有完成响应）");
		} else if (4 == xmlHttp.readyState) {
			console.info("请求已完成（可以访问服务器响应并使用它）");
			document.myForm.time.value = xmlHttp.responseText;
		}
	}
	xmlHttp.open("POST", "/testJs/ajax", true);
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("start=" + 0 + "&limit=" + 30 );
}