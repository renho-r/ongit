$(function() {
	var index = 1;
	$(document).pjax('a', '#txt');
	$(document).on('pjax:complete', function() {
		$('#next').click(bindNext)
	})
	function bindNext() {
		$.ajax({
			url: "/pjax/php/showTxt.php",
			data: {index: index++},
			dataType: "html",
			type: "POST",
			error: function(XMLHttpRequest, textStatus, errorThrown) {
			},
			success: function(data, textStatus, jqXHR) {
				$("#txt").empty();
//				$("#txt").append(data);
				console.info(data);
				$('#next').click(bindNext);
			}
		});
	}
})