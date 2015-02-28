/**
 * 
 */
var m = 0;
var data = "{news:[{type:'实时路况', time:'2014年8月22日', add:'地址a', msg:'施工'}, {type:'交通事故', time:'2014年8月01日', add:'地址b', msg:'限行'},{type:'3', time:'2014年8月', add:'地址a', msg:'限行'},{type:'4', time:'2014年8月', add:'地址a', msg:'限行'},{type:'5', time:'2014年8月',add:'地址a', msg:'限行'},{type:'6', time:'2014年8月', add:'地址a', msg:'限行'},{type:'7', time:'2014年8月', add:'地址', msg:'限行'}]}";
//var data = "{news:[{type:'实时', time:'2014', add:'地址', msg:'施工'}]}";
var dataObj;
function autoScroll(obj){
	$(obj).find(".list").animate({
		marginTop : "-25px"
	},500,function(){
		var mo = (1 + m)%3;
		if(0 == mo) {
			$("#i3").html(getInfo(m));
		}else if(1 == mo){
			$("#i1").html(getInfo(m));
		}else if(2 == mo){
			$("#i2").html(getInfo(m));
		}
		m++;
		$(this).css({marginTop : "0px"}).find("li:first").appendTo(this);
	})
}
function getInfo(i) {
	if(i >= dataObj.news.length) {
		if(0==i%3) {
			m = 0;
			i = 0;
			return "[" + dataObj.news[i].type + "] " + dataObj.news[i].time + "," + dataObj.news[i].add + "," + dataObj.news[i].msg;
		}else {
			return "";
		}
		//return "type:" + dataObj.news[i].type + ",time:" + dataObj.news[i].time + ",info:" + dataObj.news[i].info;
	}else {
		return "[" + dataObj.news[i].type + "] " + dataObj.news[i].time + "," + dataObj.news[i].add + ","  + dataObj.news[i].msg;
	}
}
$(function(){
	//获取json数据
	//Test start by renho

	$.ajax({
		type: "POST",
		url: "/mytest/path/student_queryAllStudent",
		data: "name=John&location=Boston",
		dataType:'json',
		success: function(msg){
			alert( "Data Saved: " + msg );
			console.info(msg);
			data = msg;
			//dataObj = eval("("+data+")");
			dataObj = data;
			alert(dataObj);
			$("#i1").html(getInfo(m));
			m++;
			$("#i2").html(getInfo(m));
			m++;
			$("#i3").html(getInfo(m));
			m++;
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			//alert("失败");
			this;//调用本次ajax请求时传递的options参数
		}

	});
	dataObj = eval("("+data+")");
	$.each(dataObj.news,function(idx,item){
	})
	$("#i1").html(getInfo(m));
	m++;
	$("#i2").html(getInfo(m));
	m++;
	$("#i3").html(getInfo(m));
	m++;
	setInterval('autoScroll(".scroll")',3000);
})