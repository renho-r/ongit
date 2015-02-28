var wrap_width=null;
var warap_right_width=null;
var mapinf_width=null;
var map_width=null;
var loadinginf_width=null;
var flag=true;
function openfullScreen(){
		wrap_width=$("#wrap").width();
		warap_right_width=$("#warap_right").width();
    	$("#warap_left").hide();
    	$("#wrap").width("100%");
    	$("#warap_right").css("z-index","99999");
    	$("#warap_right").width("100%");
    	
}
function closeFullScreen(){
	$("#warap_left").show();
	$("#warap_right").width(warap_right_width);
	$("#wrap").width(wrap_width);
	$("#warap_right").css("z-index","1");
}

function fullScreen(rwidth,screenflag){
	
	if(screenflag){
		openfullScreen();
		mapinf_width=$(frame_content.document).find("#mapinf").width();
		map_width=$(frame_content.document).find("#map").width();
		loadinginf_width=$(frame_content.document).find("#loadinginf").width();
		$(frame_content.document).find("#mapinf").width($("#warap_right").width()-rwidth);
    	$(frame_content.document).find("#map").width($("#warap_right").width()-rwidth);
    	$(frame_content.document).find("#loadinginf").width($("#warap_right").width()-rwidth);
	}else{
		$(frame_content.document).find("#mapinf").width(mapinf_width);
    	$(frame_content.document).find("#map").width(map_width);
    	$(frame_content.document).find("#loadinginf").width(loadinginf_width);
		closeFullScreen();
	}
}

function setfullScreen(rwidth){
	if(!flag){
	    $("#fullscreen").removeClass("roadvideo_bg2").addClass("roadvideo_bg");
	}else{
		 $("#fullscreen").removeClass("roadvideo_bg").addClass("roadvideo_bg2");
	}
	parent.fullScreen(rwidth,flag);
	flag=!flag;
}


function checkPlugins(pluginsName, activexObjectName) {
     // ͨ��ActiveXObject�Ķ��������������������Ƶ�����
     if (activexObjectName == '') activexObjectName = pluginsName + "." + pluginsName;
     
     var np = navigator.plugins;
     if (np && np.length) {
         for(var i = 0; i < np.length; i ++) {
             if(np[i].name.indexOf(pluginsName) != -1) return true;
         }
         return false;
     }
     // ������IE
     else if (window.ActiveXObject) {
         try {
             var axobj =eval("new ActiveXObject(activexObjectName);");
             // ������ת��Ϊ��������
             return axobj ? true : false;
         } catch (e) {
             return false;
         }
     } else {
         // �����������ų��򷵻�false
         return false;
     }
 }

function hasQuickTime() { 
	var result = hasPlugin("QuickTime"); 
	if (!result) { 
	result = hasIEPlugin("QuickTime.QuickTime"); 
	} 
	return result; 
} 

function hasPlugin(name) { 
	name = name.toLowerCase(); 
	for (var i=0 ; i < navigator.plugins.length ; i++ ) { 
	if (navigator.plugins[i].name.toLowerCase().indexOf(name) >-1) { 
	return true; 
	} 
	} 
	return false; 
} 
function hasIEPlugin(name) { 
	try { 
	new ActiveXObject(name); 
	return true; 
	} 
	catch (ex) { 
	return false; 
	} 
} 

function SetWinHeight() 
{ 
	var ifm= document.getElementById("frame_content"); 
	var subWeb = document.frames ? document.frames["frame_content"].document : ifm.contentDocument; 
	if(ifm != null && subWeb != null) { 
		ifm.height = subWeb.body.scrollHeight; 
	} 
} 
