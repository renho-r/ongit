$(function() {
	$("#exe").click(function() {
		var t = $("#jsTextarea").val();
		eval(t);
	});
	$("#htmlTextarea").change(function() {
		var html = $("#htmlTextarea").val();
		$("#htmlShow").empty();
		$("#htmlShow").append(html);
	})
})