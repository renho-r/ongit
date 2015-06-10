(function($) {
	var flag = true;
	var i = 0;
	new WOW().init();
	console.info($(window).height());
	$(window).scroll(function() {
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		if(scrollTop + windowHeight == scrollHeight && flag){
			$.ajax({
				url: "/testPlugin/php/renho.php",
				data: {},
				dataType: "json",
				type: "POST",
				error: function(XMLHttpRequest, textStatus, errorThrown) {
				},
				success: function(data, textStatus, jqXHR) {
					if(null != data) {
						$("#show").append("<div style='float: left; height: 200px; width: 100%'><div style='float: left; width: 50%; height: 200px;'><div class='wow bounceInLeft' style='float: right; width: 50%; height: 200px;' id='id" + i + "'>" + data.now + "</div></div><div style='float: right; width: 50%'><div style='float: left; width: 50%' class='wow bounceInRight'>" + data.now + "</div></div></div><div style='clear: both;'></div>");
						$("#html, body").scrollTo(scrollTop + 199, 1000);
					}
				}
			});
		}
	});
})(jQuery)