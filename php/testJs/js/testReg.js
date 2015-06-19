;
$(function() {
	var str = "{0}-{1}条, 当前第{2}页, 共{3}页";
	var pageObj = {
		"{0}": 100,
		"{1}": 120,
		"{2}": 6,
		"{3}": 10
	}
	$("#testButton").click(function() {
		console.info(str);
		var reg = /\{\d{1}\}/g;
		var temp = str.replace(reg, function(a, b, c) {
			return pageObj[a];
		});
		console.info(temp);
		$("#result").empty();
		$("#result").append(temp);
		console.info(str);
	})
})