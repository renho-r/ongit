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
})