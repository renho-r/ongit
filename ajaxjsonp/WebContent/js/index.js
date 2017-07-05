$(function() {
	$("#send").click(function() {
		$.ajax({
			url : "http://localhost:8080/jsonpserver/userServletJsonp",
			type: "GET",
			dataType: "jsonp",
			data : {},
			jsonp: "jsonpCallback",
			jsonpCallback: "jsFunc",
			error: function(err){
			},  
			success: function(data){
				console.info("success");
				console.info(data);
			}
		});
	});
	
	$("#getJson").click(function() {
		$.getJSON("http://localhost:8080/jsonpserver/userServletJsonp?jsonpCallback=?", function(data){
			console.info(data);
	    }); 
	});
});

function jsFunc(data) {
	console.info("jsFunc");
	console.info(data);
	return data;
}