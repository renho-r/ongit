var array0 = [0, 1, 2, 3, 4];
var array1 = [5, 6, 7, 8, 9];
$(function() {
	$("#concat").click(function() {
		//arrayObject.concat(arrayX,arrayX,......,arrayX)
		p(array0.concat(array1));
		pAfter();
	})
	
	$("#join").click(function() {
		p(array0.join(";"));
	})
	
	$("#pop").click(function() {
		pBefore();
		p(array0.pop());
		pAfter();
	})
	
	$("#push").click(function() {
		pBefore();
		p(array0.push(5));
		pAfter();
	})
	
	$("#reverse").click(function() {
		pBefore();
		p(array0.reverse());
		pAfter();
	})
	
	$("#shift").click(function() {
		pBefore();
		p(array0.shift());
		pAfter();
	})
	
	$("#slice").click(function() {
		pBefore();
		p(array0.slice(0, 2));
		pAfter();
		
		pBefore();
		p(array0.slice(-3, -1));
		pAfter();
	})
	
	$("#sort").click(function() {
		pBefore();
		array0.sort(function(a, b) {
			if(a > b) {
				return -1;
			}else if(a == b) {
				return 0;
			}else if(a < b) {
				return 1;
			}
		});
		pAfter();
	})
	
	$("#splice").click(function() {
		pBefore();
		array0.splice(0, 2);
		pAfter();
		array0.splice(0, 2, 11, 12, 13);
		pAfter();
	})
	
	$("#unshift").click(function() {
		pBefore();
		array0.unshift(11, 12, 13, 14);
		pAfter();
	})
	
	$("#array0Reset").click(function() {
		array0 = [0, 1, 2, 3, 4];
		pAfter();
	})
	
	$("#array1Reset").click(function() {
		array1 = [5, 6, 7, 8, 9];
		pAfter();
	})
})

function p(s) {
	console.info(s);
}

function pBefore() {
	p("------->before start<-------");
	p(array0);
	p("array0 length:" + array0.length);
	p("------->before end<-------");
}

function pAfter() {
	p("------->after start<-------");
	p(array0);
	p("array0 length:" + array0.length);
	p("------->after end<-------");
}