$(function() {

	$("#extend").click(function() {
		var target = {
			"targetInt" : 0,
			"targetString" : "targetString",
			"targetObject" : {
				"targetObjectInt" : 0,
				"targetObjectFunction" : function() {
					return "targetObjectFunction";
				},
			},
			"targetFunction" : function() {
				return "targetFunction";
			},
			"ajax" : {
				"url" : "xxxx"
			}
		};
		var obj = {
			"objInt" : 1,
			"objString" : "objString",
			"objFunction" : function() {
				return "objFunction";
			},
			"targetObject" : {
				"fromObj" : "fromObj"
			},
			"ajax" : {
				"data" : function() {
					return "ajax.data";
				}
			}
		};
		var empty0 = {};
		var empty1 = {};
		var extendDefault = $.extend(empty0, target, obj);// 非递归,覆盖原结构
		var extendTrue = $.extend(true, empty1, target, obj);// 递归,补充原结构
	})

	$("#type").click(function() {
		var r = new R();
		alert("typeof r:" + $.type(r));
		alert("typeof []:" + typeof []);
		alert("$.type([]):" + $.type([]));
	})

	function R() {
		this.id = "1", this.show = function() {
			alert("show");
		}
	}

	$("#isPlainObject").click(function() {
		alert($.isPlainObject(renhoObject));
	})

	$("#isFunction").click(function() {
		alert($.isFunction(renhoFunction));
	})

	var renhoObject = {
		id : "1",
		name : "renho"
	};

	function renhoFunction() {
		console.info("renhoFunction");
	}

	$("#ajaxXml").click(function() {
		$.ajax({
			url : "/testPhp/php/jqueryPhp.php",
			data : {
				method : "getXml",
				"renho" : "vaue-renho"
			},
			dataType : "xml",
			type : "POST",
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			},
			success : function(data, textStatus, jqXHR) {
				console.info(data);
				console.info($(data).text());
				console.info($(data).find("book title").text());
				console.info($(data).find("book bookName").text());
			}
		});
	})

	$("#div-data-0").data("renho", 100);

	var array = [ 1, 2, 3, 4, 5 ];
	$.each(array, function(i, n) {
		console.info(i + ":" + n);
	});

	var callbacks = $.Callbacks();
	callbacks.add(fn0);
	callbacks.add(fn1);

	$("#click-test-0").click(function() {
		callbacks.fire($(this));
		console.info($("#div-data-0").data("renho"));
	})

	$("#callback-test-0").click(function() {

		var callbacks = $.Callbacks();
		callbacks.add(fn0);
		callbacks.fire("foo!");

		callbacks.add(fn1);
		callbacks.fire("bar!");
	})

	function fn0(param) {
		console.info("fn0:" + param);
	}
	function fn1(param) {
		console.info("fn1:" + param);
	}

	$.ajax({
		url : "/testPhp/php/jqueryPhp.php",
		data : {
			method : "getJson",
			"renho" : "vaue-renho"
		},
		dataType : "json",
		error : function(XMLHttpRequest, textStatus, errorThrown) {
		},
		success : function(data, textStatus, jqXHR) {
		}
	});
})