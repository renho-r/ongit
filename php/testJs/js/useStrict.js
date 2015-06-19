;
$(function() {
	"use strict"
	var renho = 100;
	
	function f1() {
//		f1.caller; // 报错
//		f1.arguments; // 报错		
	}
	f1();
	
	var x;
//	delete x; // 语法错误
	var o = Object.create(null, {'x': {
		value: 1,
		configurable: true
	}});
	delete o.x; // 删除成功
	var renho = {
		name: "renho"
	}
	delete renho.name;
})