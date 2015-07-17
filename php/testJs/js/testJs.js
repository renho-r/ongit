var renho = 0;
$(function() {
	$("#testLocation").click(function() {
		window.location.href = "#name";
	})
	$("#changeCss").click(changeRed);
	
	function changeBlue() {
		$("#canChangeCss").attr("href", "/testJs/css/styleblue.css");
		$("#changeCss").unbind("click");
		$("#changeCss").click(changeRed);
	}
	
	function changeRed() {
		$("#canChangeCss").attr("href", "/testJs/css/stylered.css");
		$("#changeCss").unbind("click");
		$("#changeCss").click(changeBlue);
	}
	console.info("test.js:" + renho);
	$("#jqueryLoad").load("/testJs/view/needLoad.html");
	console.info("test.js:" + renho);
	setTimeout(function() {
		console.info("test.js:" + renho);
	}, 1000);
})