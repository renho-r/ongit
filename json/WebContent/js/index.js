$(function() {
	
	function User() {
		this.userId = "undefined"==typeof(arguments[0])?"":arguments[0];
		this.userName = "undefined"==typeof(arguments[1])?"":arguments[1];
		this.time = "undefined"==typeof(arguments[2])?"":arguments[2];
		if(typeof User._initialized == "undefined"){
			User.prototype.showInfo = function() {
				console.info("----->以下信息<-----");
				for(var i in this) {
					if("function" != typeof(this[i])) {
						console.info(i + ":" + this[i]);
					}
				}
				console.info("----->以上信息<-----");
			}
		}; 
		User._initialized = true;
	}
		
	var jsonObject = {
			userId: 1,
			userName: "renho",
			method: "object"
	};
	var jsonList = {
		list:[]
	};
	jsonList.list[0] = new User(1, "renho1", "2015-04-01");
	jsonList.list[1] = new User(2, "renho2", "2015-04-02");
	jsonList.list[2] = new User(3, "renho3", "2015-04-03");
	jsonList.list[3] = new User(4);
	
	function show() {
		console.info(this.userId + ":" + this.userName + ":" + this.time);
		console.info(arguments[0]);
	}
	
	function info() {
		console.info(this.userId + ":" + this.userName + ":" + this.time);
		console.info(arguments[0]);
	}
	
	//show.call(jsonList.list[0], 11)
	//info.apply(jsonList.list[0], [22]);
	jsonList.list[0].showInfo();
	
	$("#submitJsonObject").click(function() {
		$.ajax({
			type: "POST",
			url: "userServlet",
			data: jsonObject,
			dataType:'json',
			success: function(msg){
				
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				this;
			}
		});
	})
	$("#submitJsonList").click(function() {
		$.ajax({
			type: "POST",
			url: "userServlet",
			data: {"method": "list", "json": JSON.stringify(jsonList)},
			dataType:'json',
			success: function(msg){
				
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				this;
			}
		});
	})
	$("#submitJsonMap").click(function() {
		$.ajax({
			type: "POST",
			url: "userServlet",
			data: jsonMap,
			dataType:'json',
			success: function(msg){
				
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				this;
			}
		});
	})
	
	$("#submitGetUser").click(function() {
		$.ajax({
			type: "POST",
			url: "userServlet",
			data: {method: "get"},
			dataType:'json',
			success: function(msg){
				
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				this;
			}
		});
	})
})