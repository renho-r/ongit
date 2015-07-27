/*! CHANGYAN2.5 2015-07-15 */
!function(){"use strict";function isFunction(a){return"[object Function]"===Object.prototype.toString.call(a)}function define(a,b,c){if(modules[a])throw new Error("Module "+a+" has been defined already.");isFunction(b)&&(c=b),modules[a]={factory:c,inited:!1,exports:null}}function run(a){var module,exports,b,c;if(module=modules[a],exports={},b={},!isFunction(module.factory))throw new Error("Module "+a+" has no factory.");c=module.factory.call(void 0,require,exports,b),void 0!==c?module.exports=c:b.hasOwnProperty("exports")?module.exports=b.exports:module.exports=exports,module.inited=!0}function require(a){var module;if(module=modules[a],!module)throw new Error("Module "+a+" is not defined.");return module.inited===!1&&run(a),module.exports}var modules={};define("/opt/jenkins/workspace/changyan-fe-prod-cyf-v25-deploy/v2.5/tmp-build/lib/json2.js",function(require,exports,module){var JSON;JSON||(JSON={}),function(){function f(a){return 10>a?"0"+a:a}function quote(a){return escapable.lastIndex=0,escapable.test(a)?'"'+a.replace(escapable,function(a){var b=meta[a];return"string"==typeof b?b:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+a+'"'}function str(a,b){var c,d,e,f,g,h=gap,i=b[a];switch(i&&"object"==typeof i&&"function"==typeof i.toJSON&&(i=i.toJSON(a)),"function"==typeof rep&&(i=rep.call(b,a,i)),typeof i){case"string":return quote(i);case"number":return isFinite(i)?String(i):"null";case"boolean":case"null":return String(i);case"object":if(!i)return"null";if(gap+=indent,g=[],"[object Array]"===Object.prototype.toString.apply(i)){for(f=i.length,c=0;f>c;c+=1)g[c]=str(c,i)||"null";return e=0===g.length?"[]":gap?"[\n"+gap+g.join(",\n"+gap)+"\n"+h+"]":"["+g.join(",")+"]",gap=h,e}if(rep&&"object"==typeof rep)for(f=rep.length,c=0;f>c;c+=1)"string"==typeof rep[c]&&(d=rep[c],e=str(d,i),e&&g.push(quote(d)+(gap?": ":":")+e));else for(d in i)Object.prototype.hasOwnProperty.call(i,d)&&(e=str(d,i),e&&g.push(quote(d)+(gap?": ":":")+e));return e=0===g.length?"{}":gap?"{\n"+gap+g.join(",\n"+gap)+"\n"+h+"}":"{"+g.join(",")+"}",gap=h,e}}"function"!=typeof Date.prototype.toJSON&&(Date.prototype.toJSON=function(a){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z":null},String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(a){return this.valueOf()});var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,indent,meta={"\b":"\\b","	":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},rep;"function"!=typeof JSON.stringify&&(JSON.stringify=function(a,b,c){var d;if(gap="",indent="","number"==typeof c)for(d=0;c>d;d+=1)indent+=" ";else"string"==typeof c&&(indent=c);if(rep=b,b&&"function"!=typeof b&&("object"!=typeof b||"number"!=typeof b.length))throw new Error("JSON.stringify");return str("",{"":a})}),"function"!=typeof JSON.parse&&(JSON.parse=function(text,reviver){function walk(a,b){var c,d,e=a[b];if(e&&"object"==typeof e)for(c in e)Object.prototype.hasOwnProperty.call(e,c)&&(d=walk(e,c),void 0!==d?e[c]=d:delete e[c]);return reviver.call(a,b,e)}var j;if(text=String(text),cx.lastIndex=0,cx.test(text)&&(text=text.replace(cx,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})),/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,"")))return j=eval("("+text+")"),"function"==typeof reviver?walk({"":j},""):j;throw new SyntaxError("JSON.parse")})}(),module.exports=JSON}),define("/opt/jenkins/workspace/changyan-fe-prod-cyf-v25-deploy/v2.5/tmp-build/lib/messager.js",function(require,exports,module){module.exports=function(){function a(a,b,d){this.listenFunc=[],this.target=b,this.name=d,c=a||c,"string"!=typeof c&&(c=c.toString()),this.init()}var b=require("/opt/jenkins/workspace/changyan-fe-prod-cyf-v25-deploy/v2.5/tmp-build/lib/json2.js"),c="[PROJECT_NAME]",d="postMessage"in window,e=window.console||{log:function(a){window.alert(a)}};return d||window.navigator.listenFunc||(window.navigator.listenFunc={},window.navigator.userListen={}),a.prototype.init=function(){var a=this,e=function(e){var f,g="";if("object"==typeof e&&(e=e.data.toString()),c+a.name===e.substring(0,e.indexOf("|cy|")))if(e=e.slice((c+a.name).length+4),e.indexOf("CY_TYPE_OBJECT")>=0&&(g="object",e=e.replace("CY_TYPE_OBJECT",""),e=b.parse(e)),d)for(f=0;f<a.listenFunc.length;f++)a.listenFunc[f](e);else window.navigator.userListen[c+a.name+"|cy|"](e)};d?"addEventListener"in document?window.addEventListener("message",e,!1):"attachEvent"in document&&window.attachEvent("onmessage",e):window.navigator.listenFunc[c+this.name+"|cy|"]=e},a.prototype.post=function(a,f){var g="";if("string"!=typeof a&&"object"!=typeof a)return void e.log("请输入正确的数据类型;");if("object"==typeof a&&(g="CY_TYPE_OBJECT",a=b.stringify(a)),a=g+a,a.length>=1e4)return void e.log("数据长度超过限制");if(d)this.target.postMessage(c+f+"|cy|"+a,"*");else{var h=window.navigator.listenFunc[c+f+"|cy|"];"function"==typeof h&&h(c+f+"|cy|"+a)}},a.prototype.listen=function(a){d?this.listenFunc.push(a):window.navigator.userListen[c+this.name+"|cy|"]=a},a.prototype.destrory=function(){d?this.listenFunc.pop():window.navigator.userListen[c+this.name+"|cy|"]=null},a}()}),define("/opt/jenkins/workspace/changyan-fe-prod-cyf-v25-deploy/v2.5/tmp-build/iframe-app.js",function(require,exports,module){var a=require("/opt/jenkins/workspace/changyan-fe-prod-cyf-v25-deploy/v2.5/tmp-build/lib/messager.js"),b=require("/opt/jenkins/workspace/changyan-fe-prod-cyf-v25-deploy/v2.5/tmp-build/lib/json2.js"),c={create:function(a){var b,SOHUCS,c=document.createElement("iframe"),a=a;c.src=a,SOHUCS=document.getElementById("SOHUCS"),b=SOHUCS.getAttribute("sid");var d=this.messager(c,b);return"addEventListener"in document?c.onload=d:"attachEvent"in document&&c.attachEvent("onload",d),c},messager:function(c,d){var e=function(){var e=new a("changyan",c.contentWindow,"parent"),f=new a("changyan",c.contentWindow,"scrollParent"),g=new a("changyan",c.contentWindow,"reloadParent");e.listen(function(a){"connect"==a?(window.changyan.api.tmpIsvConfig.sid=d,e.post(b.stringify(window.changyan.api),"frame")):c.style.height=a+"px"}),f.listen(function(a){var b={scrollTop:window.pageYOffset||document.documentElement.scrollTop||document.body.scrollTop,scrollLeft:window.pageXOffset||document.documentElement.scrollLeft||document.body.scrollLeft,clientHeight:window.innerHeight||document.documentElement.clientHeight||800,clientWidth:window.offsetWidth||document.documentElement.offsetWidth||document.body.offsetWidth,frameOffsetHeight:document.getElementById("SOHUCS").offsetTop};f.post(b,"scrollFrame")}),g.listen(function(a){location.reload()})};return e},render:function(a){var b,c={width:"100%",height:"",border:0};for(b in c)a.style[b]=c[b];a.setAttribute("frameBorder","no");var d=document.getElementById("SOHUCS");d.appendChild(a)},init:function(a){var b=a.src,c=this.create(b);this.render(c)}};c.init({src:window.changyan.api.tmpIsvConfig.uri.res+"src/innerpage.html?baseUri="+window.changyan.api.tmpIsvConfig.uri.res+"&version="+window.changyan.api.tmpIsvConfig.v})}),run("/opt/jenkins/workspace/changyan-fe-prod-cyf-v25-deploy/v2.5/tmp-build/iframe-app.js")}();