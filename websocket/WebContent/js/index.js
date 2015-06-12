$(function() {
	
	$("#echoNoAnnotationConnect").click(function() {
		var echoNoAnnotationConnect0 = {};
		var target = "ws://localhost:8080/websocket/websocket/echoProgrammatic";
		if ('WebSocket' in window) {
			echoNoAnnotationConnect0.socket = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			echoNoAnnotationConnect0.socket = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		echoNoAnnotationConnect0.socket.onopen = function () {
			console.info('Info: WebSocket connection opened.');
		};
		echoNoAnnotationConnect0.socket.onmessage = function (message) {
			console.info("receive msg:" + message.data);
		};
		echoNoAnnotationConnect0.socket.onclose = function (event) {
			console.info('Info: WebSocket connection closed, Code: ' + event.code + (event.reason == "" ? "" : ", Reason: " + event.reason));
		};
		$("#echoNoAnnotationSend").click(function() {
			echoNoAnnotationConnect0.socket.send("no annotation");
		})
	})
	
	$("#goServlet").click(function() {
		$.ajax({
			url: "/websocket/renho",
			data: {},
			dataType: "json",
			type: "POST",
			error: function(XMLHttpRequest, textStatus, errorThrown) {
			},
			success: function(data, textStatus, jqXHR) {
			}
		});
	})
	
	var chatRenho0 = {};
	var chatRenho1 = {};
	var chatRenho2 = {};
	
	$("#renho0Send").click(function() {
		var msg = $("#renho0SendStr").val();
		$("#renho0SendStr").empty();
		chatRenho0.socket.send(msg);
	})
	
	$("#renho1Send").click(function() {
		var msg = $("#renho1SendStr").val();
		$("#renho1SendStr").empty();
		chatRenho1.socket.send(msg);
	})
	
	$("#renho2Send").click(function() {
		var msg = $("#renho2SendStr").val();
		$("#renho2SendStr").empty();
		chatRenho2.socket.send(msg);
	})
	
	
	
	
	
	
	
	
	$("#renho0Connect").click(function() {
		var target = "ws://localhost:8080/websocket/websocket/myChat";
		if ('WebSocket' in window) {
			chatRenho0.socket = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			chatRenho0.socket = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		chatRenho0.socket.onopen = function () {
			console.info('Info: WebSocket connection opened.');
		};
		chatRenho0.socket.onmessage = function (message) {
			$("#renho0Receive").append(message.data + "<br>");
		};
		chatRenho0.socket.onclose = function (event) {
			console.info('Info: WebSocket connection closed, Code: ' + event.code + (event.reason == "" ? "" : ", Reason: " + event.reason));
		};
	})
	$("#renho1Connect").click(function() {
		var target = "ws://localhost:8080/websocket/websocket/myChat";
		if ('WebSocket' in window) {
			chatRenho1.socket = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			chatRenho1.socket = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		chatRenho1.socket.onopen = function () {
			console.info('Info: WebSocket connection opened.');
		};
		chatRenho1.socket.onmessage = function (message) {
			$("#renho1Receive").append(message.data + "<br>");
		};
		chatRenho1.socket.onclose = function (event) {
			console.info('Info: WebSocket connection closed, Code: ' + event.code + (event.reason == "" ? "" : ", Reason: " + event.reason));
		};
	})
	$("#renho2Connect").click(function() {
		var target = "ws://localhost:8080/websocket/websocket/myChat";
		if ('WebSocket' in window) {
			chatRenho2.socket = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			chatRenho2.socket = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		chatRenho2.socket.onopen = function () {
			console.info('Info: WebSocket connection opened.');
		};
		chatRenho2.socket.onmessage = function (message) {
			$("#renho2Receive").append(message.data + "<br>");
		};
		chatRenho2.socket.onclose = function (event) {
			console.info('Info: WebSocket connection closed, Code: ' + event.code + (event.reason == "" ? "" : ", Reason: " + event.reason));
		};
	})
	
	
	
	
	
	
	
	
	
	
	
	
	var echoAnnotationWs = null;
	$("#echoAnnotationConnect").click(function() {
		var target = "ws://localhost:8080/websocket/websocket/echoAnnotation";
		if ('WebSocket' in window) {
			echoAnnotationWs = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			echoAnnotationWs = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		echoAnnotationWs.onopen = function () {
			console.info('Info: WebSocket connection opened.');
		};
		echoAnnotationWs.onmessage = function (event) {
			console.info('Received: ' + event.data);
		};
		echoAnnotationWs.onclose = function (event) {
			console.info('Info: WebSocket connection closed, Code: ' + event.code + (event.reason == "" ? "" : ", Reason: " + event.reason));
		};		
	})
	
	$("#echoAnnotationSend").click(function() {
		echoAnnotationWs.send("renho");
	})
	
	$("#echoAnnotationClose").click(function() {
		echoAnnotationWs.close();
	})
	
	var chat = null;
	$("#chatConnect").click(function() {
		var target = "ws://localhost:8080/websocket/websocket/chat";
		if ('WebSocket' in window) {
			chat = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			chat = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		chat.onopen = function () {
			console.info('Info: WebSocket connection opened.');
		};
		chat.onmessage = function (message) {
			$("#rece").append(message.data + "<br>");
		};
		chat.onclose = function (event) {
			console.info('Info: WebSocket connection closed, Code: ' + event.code + (event.reason == "" ? "" : ", Reason: " + event.reason));
		};
	})
	$("#chatSend").click(function() {
		var msg = $("#send").val();
		$("#send").empty();
		chat.send(msg);
	})
})