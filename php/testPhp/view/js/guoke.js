$(function() {
	$.ajax({
		url: "/testPhp/php/guoke.php",
		data: {url: "http://www.guokr.com/apis/minisite/article.json?retrieve_type=by_subject&limit=20&offset=39&_=1433906390606"},
		dataType: "json",
		type: "POST",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
		},
		success: function(data, textStatus, jqXHR) {
			console.info(data);
		}
	});
})