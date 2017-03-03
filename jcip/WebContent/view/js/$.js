(function() {
	var xmlHttpRequest;
	try {
		xmlHttpRequest = new XMLHttpRequest();
	}catch (e) {
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
	
	Renho = function() {
		if(windows == this) {
			return new Renho();
		}
	}
	
	Renho.fn = Renho.prototype;
	Renho.ajax = function(ajaxObj) {
		xmlHttpRequest.onreadystatechange = function() {
			if(4 == xmlHttpRequest.readyState) {
				ajaxObj.success(xmlHttpRequest.response, xmlHttpRequest.responseText, xmlHttpRequest);
			}
		}
		xmlHttpRequest.open(ajaxObj.type, ajaxObj.url, true);
		xmlHttpRequest.send(null);
	}
	window.$ = Renho;
})(window)