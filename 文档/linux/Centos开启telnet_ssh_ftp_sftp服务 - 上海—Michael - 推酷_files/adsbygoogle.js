(function(){var n=this,aa=function(a){var b=typeof a;return"object"==b&&null!=a||"function"==b},ba=function(a,b,c){return a.call.apply(a.bind,arguments)},ca=function(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var c=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(c,d);return a.apply(b,c)}}return function(){return a.apply(b,arguments)}},q=function(a,b,c){q=Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?
ba:ca;return q.apply(null,arguments)},t=function(a,b){var c=Array.prototype.slice.call(arguments,1);return function(){var b=c.slice();b.push.apply(b,arguments);return a.apply(this,b)}},v=Date.now||function(){return+new Date},da=function(a,b){function c(){}c.prototype=b.prototype;a.Ua=b.prototype;a.prototype=new c;a.Sa=function(a,c,g){for(var f=Array(arguments.length-2),h=2;h<arguments.length;h++)f[h-2]=arguments[h];return b.prototype[c].apply(a,f)}};var ea=(new Date).getTime();var w=function(a){a=parseFloat(a);return isNaN(a)||1<a||0>a?0:a},fa=function(a,b){var c=parseInt(a,10);return isNaN(c)?b:c},ga=function(a,b){return/^true$/.test(a)?!0:/^false$/.test(a)?!1:b},ha=/^([\w-]+\.)*([\w-]{2,})(\:[0-9]+)?$/,ia=function(a,b){if(!a)return b;var c=a.match(ha);return c?c[0]:b};var ka=fa("101",-1),la=fa("100",0),ma=w("0.05"),na=w("0.001"),oa=w("0.0"),pa=w(""),qa=w("0.001"),ra=ga("true",!0),sa=w(""),ta=w("0.001"),ua=w("0.001"),
va=w(""),xa=w("0.1");var ya=ga("true",!1),za=ga("false",!1),Aa=za||!ya;var Ba=function(){return ia("","pagead2.googlesyndication.com")};var Ca=String.prototype.trim?function(a){return a.trim()}:function(a){return a.replace(/^[\s\xa0]+|[\s\xa0]+$/g,"")},Da=/&/g,Ea=/</g,Fa=/>/g,Ga=/"/g,Ha=/'/g,Ia=/\x00/g,Ja={"\x00":"\\0","\b":"\\b","\f":"\\f","\n":"\\n","\r":"\\r","\t":"\\t","\x0B":"\\x0B",'"':'\\"',"\\":"\\\\","<":"<"},Ka={"'":"\\'"},La=function(a,b){return a<b?-1:a>b?1:0};var Ma=function(a,b){this.start=a<b?a:b;this.end=a<b?b:a};var Na=function(a,b){this.width=a;this.height=b};Na.prototype.floor=function(){this.width=Math.floor(this.width);this.height=Math.floor(this.height);return this};Na.prototype.round=function(){this.width=Math.round(this.width);this.height=Math.round(this.height);return this};var Oa=function(a){Oa[" "](a);return a};Oa[" "]=function(){};var Pa=function(a){try{var b;if(b=!!a&&null!=a.location.href)a:{try{Oa(a.foo);b=!0;break a}catch(c){}b=!1}return b}catch(c){return!1}},Qa=function(a){return Pa(a.top)?a.top:null},Ra=function(a,b){var c=a.createElement("script");c.src=b;var d=a.getElementsByTagName("script")[0];return d&&d.parentNode?(d.parentNode.insertBefore(c,d),c):null},Sa=function(a,b){return b.getComputedStyle?b.getComputedStyle(a,null):a.currentStyle},y=function(a,b){if(!(1E-4>Math.random())){var c=Math.random();if(c<b)return c=
Ta(window),a[Math.floor(c*a.length)]}return null},Ta=function(a){try{var b=new Uint32Array(1);a.crypto.getRandomValues(b);return b[0]/65536/65536}catch(c){return Math.random()}},Ua=function(a,b){for(var c in a)Object.prototype.hasOwnProperty.call(a,c)&&b.call(void 0,a[c],c,a)},Va=function(a){var b=a.length;if(0==b)return 0;for(var c=305419896,d=0;d<b;d++)c^=(c<<5)+(c>>2)+a.charCodeAt(d)&4294967295;return 0<c?c:4294967296+c},Wa=/^([0-9.]+)px$/,Xa=/^(-?[0-9.]{1,30})$/,Ya=function(a){return Xa.test(a)&&
(a=Number(a),!isNaN(a))?a:null},Za=function(a){return(a=Wa.exec(a))?+a[1]:null};var $a=function(a){var b;try{b=parseInt(a.localStorage.getItem("google_experiment_mod"),10)}catch(c){return null}if(0<=b&&1E3>b)return b;b=Math.floor(1E3*Ta(a));try{return a.localStorage.setItem("google_experiment_mod",""+b),b}catch(c){return null}};var ab=function(a,b,c,d){a.addEventListener?a.addEventListener(b,c,d||!1):a.attachEvent&&a.attachEvent("on"+b,c)};var db=function(a,b,c,d,e,g){try{if((d?a.da:Math.random())<(e||a.V)){var f=a.T+b+bb(c),f=f.substring(0,2E3);"undefined"===typeof g?cb(f):cb(f,g)}}catch(h){}},bb=function(a){var b="";Ua(a,function(a,d){if(0===a||a)b+="&"+d+"="+encodeURIComponent(String(a))});return b},cb=function(a,b){n.google_image_requests||(n.google_image_requests=[]);var c=n.document.createElement("img");if(b){var d=function(a){b(a);a=d;c.removeEventListener?c.removeEventListener("load",a,!1):c.detachEvent&&c.detachEvent("onload",
a);a=d;c.removeEventListener?c.removeEventListener("error",a,!1):c.detachEvent&&c.detachEvent("onerror",a)};ab(c,"load",d);ab(c,"error",d)}c.src=a;n.google_image_requests.push(c)};var eb=function(a,b,c){this.aa=a;this.X=b;this.P=c;this.J=null;this.W=this.u;this.ja=!1},fb=function(a,b,c){this.message=a;this.fileName=b||"";this.lineNumber=c||-1},hb=function(a,b,c,d,e,g){var f;try{f=c()}catch(k){var h=a.P;try{var l=gb(k),h=(g||a.W).call(a,b,l,void 0,d)}catch(m){a.u("pAR",m)}if(!h)throw k;}finally{if(e)try{e()}catch(k){}}return f},C=function(a,b,c){var d=z;return function(){var e=arguments;return hb(d,a,function(){return b.apply(void 0,e)},void 0,c)}};
eb.prototype.u=function(a,b,c,d,e){var g={};g.context=a;b instanceof fb||(b=gb(b));g.msg=b.message.substring(0,512);b.fileName&&(g.file=b.fileName);0<b.lineNumber&&(g.line=b.lineNumber.toString());a=n.document;g.url=a.URL.substring(0,512);g.ref=a.referrer.substring(0,512);ib(this,g,d);db(this.aa,e||this.X,g,this.ja,c);return this.P};
var ib=function(a,b,c){if(a.J)try{a.J(b)}catch(d){}if(c)try{c(b)}catch(d){}},gb=function(a){var b=a.toString();a.name&&-1==b.indexOf(a.name)&&(b+=": "+a.name);a.message&&-1==b.indexOf(a.message)&&(b+=": "+a.message);if(a.stack){var c=a.stack,d=b;try{-1==c.indexOf(d)&&(c=d+"\n"+c);for(var e;c!=e;)e=c,c=c.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/,"$1");b=c.replace(/\n */g,"\n")}catch(g){b=d}}return new fb(b,a.fileName,a.lineNumber)};var D;a:{var jb=n.navigator;if(jb){var kb=jb.userAgent;if(kb){D=kb;break a}}D=""}var E=function(a){return-1!=D.indexOf(a)};var lb=E("Opera")||E("OPR"),G=E("Trident")||E("MSIE"),mb=E("Edge"),nb=E("Gecko")&&!(-1!=D.toLowerCase().indexOf("webkit")&&!E("Edge"))&&!(E("Trident")||E("MSIE"))&&!E("Edge"),ob=-1!=D.toLowerCase().indexOf("webkit")&&!E("Edge"),pb=function(){var a=D;if(nb)return/rv\:([^\);]+)(\)|;)/.exec(a);if(mb)return/Edge\/([\d\.]+)/.exec(a);if(G)return/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/.exec(a);if(ob)return/WebKit\/(\S+)/.exec(a)},qb=function(){var a=n.document;return a?a.documentMode:void 0},rb=function(){if(lb&&
n.opera){var a;var b=n.opera.version;try{a=b()}catch(c){a=b}return a}a="";(b=pb())&&(a=b?b[1]:"");return G&&(b=qb(),b>parseFloat(a))?String(b):a}(),sb={},tb=function(a){if(!sb[a]){for(var b=0,c=Ca(String(rb)).split("."),d=Ca(String(a)).split("."),e=Math.max(c.length,d.length),g=0;0==b&&g<e;g++){var f=c[g]||"",h=d[g]||"",l=RegExp("(\\d*)(\\D*)","g"),k=RegExp("(\\d*)(\\D*)","g");do{var m=l.exec(f)||["","",""],p=k.exec(h)||["","",""];if(0==m[0].length&&0==p[0].length)break;b=La(0==m[1].length?0:parseInt(m[1],
10),0==p[1].length?0:parseInt(p[1],10))||La(0==m[2].length,0==p[2].length)||La(m[2],p[2])}while(0==b)}sb[a]=0<=b}},ub=n.document,vb=ub&&G?qb()||("CSS1Compat"==ub.compatMode?parseInt(rb,10):5):void 0;var wb;if(!(wb=!nb&&!G)){var xb;if(xb=G)xb=9<=vb;wb=xb}wb||nb&&tb("1.9.1");G&&tb("9");var yb=document,I=window;var zb=function(a,b){for(var c in a)Object.prototype.hasOwnProperty.call(a,c)&&b.call(null,a[c],c,a)},J=function(a){return!!a&&"function"==typeof a&&!!a.call},Ab=function(a,b){if(!(2>arguments.length))for(var c=1,d=arguments.length;c<d;++c)a.push(arguments[c])},K=function(a,b){if(a.indexOf){var c=a.indexOf(b);return 0<c||0===c}for(c=0;c<a.length;c++)if(a[c]===b)return!0;return!1},Bb=function(a){a.google_unique_id?++a.google_unique_id:a.google_unique_id=1},Cb=function(a){a=a.google_unique_id;return"number"==
typeof a?a:0},Db=!!window.google_async_iframe_id,Eb=/(^| )adsbygoogle($| )/,Fb={"http://googleads.g.doubleclick.net":!0,"http://pagead2.googlesyndication.com":!0,"https://googleads.g.doubleclick.net":!0,"https://pagead2.googlesyndication.com":!0};var Gb,z;Gb=new function(){this.T="http"+("http:"==I.location.protocol?"":"s")+"://pagead2.googlesyndication.com/pagead/gen_204?id=";this.V=.01;this.da=Math.random()};z=new eb(Gb,"jserror",!0);var Hb=function(a,b,c,d){hb(z,a,c,d,void 0,b)},Ib=z.u,Jb=function(a,b,c){db(Gb,a,b,"jserror"!=a,c,void 0)},Kb=function(a){return C("aa:reactiveTag",a,void 0)};var Lb=null,Mb=function(){if(!Lb){for(var a=window,b=a,c=0;a&&a!=a.parent;)if(a=a.parent,c++,Pa(a))b=a;else break;Lb=b}return Lb};var N={Pa:{j:"453848100",i:"453848101"},Ba:{j:"828064124",ra:"828064125",sa:"828064172",ta:"828064173"},Aa:{j:"828064127",i:"828064128"},Ca:{j:"828064170",i:"828064171"},Fa:{j:"24819308",i:"24819309",ma:"24819320",qa:"24819321"},Ea:{j:"24819330",i:"24819331"},Ha:{j:"828064162",i:"828064163"},Ga:{j:"828064164",i:"828064165",ua:"828064166"},ya:{j:"86724438",i:"86724439"},za:{j:"828064190",i:"828064191"},La:{j:"10573505",i:"10573506"},D:{j:"10573595",i:"10573596"},Oa:{j:"10573511",i:"10573512"},F:{j:"10573581",
i:"10573582"},Ma:{j:"10573531",i:"10573532"},v:{j:"10573561",i:"10573562"},Na:{j:"10573551",i:"10573552"},Ka:{j:"312815004",i:"312815005"},C:{j:"312815104",i:"312815105"},pa:{j:"26835105",i:"26835106"},wa:{j:"35923720",i:"35923721"},G:{j:"35923760",i:"35923761"},Qa:{j:"27415001",i:"27415002"},H:{j:"20040000",i:"20040001"},na:{j:"20040016",i:"20040017"},va:{j:"828064202",i:"828064203"},xa:{j:"314159284",Ra:"314159285"},Ia:{j:"19188000",i:"19188001"},Ja:{j:"20040026",i:"20040027"},oa:{la:"314159230",
Da:"314159231"}};var Ob=function(){},Qb=function(a,b,c){switch(typeof b){case "string":Pb(b,c);break;case "number":c.push(isFinite(b)&&!isNaN(b)?b:"null");break;case "boolean":c.push(b);break;case "undefined":c.push("null");break;case "object":if(null==b){c.push("null");break}if(b instanceof Array||void 0!=b.length&&b.splice){var d=b.length;c.push("[");for(var e="",g=0;g<d;g++)c.push(e),Qb(a,b[g],c),e=",";c.push("]");break}c.push("{");d="";for(e in b)b.hasOwnProperty(e)&&(g=b[e],"function"!=typeof g&&(c.push(d),Pb(e,
c),c.push(":"),Qb(a,g,c),d=","));c.push("}");break;case "function":break;default:throw Error("Unknown type: "+typeof b);}},Rb={'"':'\\"',"\\":"\\\\","/":"\\/","\b":"\\b","\f":"\\f","\n":"\\n","\r":"\\r","\t":"\\t","\x0B":"\\u000b"},Sb=/\uffff/.test("\uffff")?/[\\\"\x00-\x1f\x7f-\uffff]/g:/[\\\"\x00-\x1f\x7f-\xff]/g,Pb=function(a,b){b.push('"');b.push(a.replace(Sb,function(a){if(a in Rb)return Rb[a];var b=a.charCodeAt(0),e="\\u";16>b?e+="000":256>b?e+="00":4096>b&&(e+="0");return Rb[a]=e+b.toString(16)}));
b.push('"')};var Tb=null,Ub=nb||ob||lb||"function"==typeof n.atob;var Vb={google_ad_modifications:!0,google_analytics_domain_name:!0,google_analytics_uacct:!0},Wb=function(a){a.google_page_url&&(a.google_page_url=String(a.google_page_url));var b=[];zb(a,function(a,d){if(null!=a){var e;try{var g=[];Qb(new Ob,a,g);e=g.join("")}catch(f){}e&&(e=e.replace(/\//g,"\\$&"),Ab(b,d,"=",e,";"))}});return b.join("")};var Xb=function(a,b,c){Hb("files::getSrc",Ib,function(){if("https:"==I.location.protocol&&"http"==c)throw c="https",Error("Requested url "+a+b);});return[c,"://",a,b].join("")},Yb=function(a,b,c){c||(c=Aa?"https":"http");return Xb(a,b,c)};var Zb=function(a){var b=$a(n);a=a.mods;if(isNaN(b)||!a)return!1;for(var c=0;c<a.length;c++){var d=a[c],e=d.max;if(b>=d.min&&b<=e)return!0}return!1},$b=function(a,b){a.location.href&&a.location.href.substring&&(b.url=a.location.href.substring(0,200));Jb("ama",b,.01)};var ac={overlays:1,interstitials:2,vignettes:2,inserts:3,immersives:4};var O=function(a){a=a.document;return("CSS1Compat"==a.compatMode?a.documentElement:a.body)||{}};var bc=new function(){this.ba=new Ma(100,199)};var P=function(a){return(a=a.google_ad_modifications)?a.loeids||[]:[]},cc=function(a,b,c){if(!a)return null;for(var d=0;d<a.length;++d)if((a[d].ad_slot||b)==b&&(a[d].ad_tag_origin||c)==c)return a[d];return null};var dc=function(a,b,c){return I.location&&I.location.hash=="#google_plle_"+c?c:y([b,c],a)},ec=function(a,b,c,d){a=a.google_active_plles=a.google_active_plles||[];return K(P(b),c)?(a.push(c),c):K(P(b),d)?(a.push(d),d):null};var fc=null;var gc=function(a){this.s=a;a.google_iframe_oncopy||(a.google_iframe_oncopy={handlers:{},upd:q(this.ia,this)});this.fa=a.google_iframe_oncopy},hc;var R="var i=this.id,s=window.google_iframe_oncopy,H=s&&s.handlers,h=H&&H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&&d&&(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}";
/[\x00&<>"']/.test(R)&&(-1!=R.indexOf("&")&&(R=R.replace(Da,"&amp;")),-1!=R.indexOf("<")&&(R=R.replace(Ea,"&lt;")),-1!=R.indexOf(">")&&(R=R.replace(Fa,"&gt;")),-1!=R.indexOf('"')&&(R=R.replace(Ga,"&quot;")),-1!=R.indexOf("'")&&(R=R.replace(Ha,"&#39;")),-1!=R.indexOf("\x00")&&(R=R.replace(Ia,"&#0;")));hc=R;gc.prototype.set=function(a,b){this.fa.handlers[a]=b;this.s.addEventListener&&this.s.addEventListener("load",q(this.Y,this,a),!1)};
gc.prototype.Y=function(a){a=this.s.document.getElementById(a);try{var b=a.contentWindow.document;if(a.onload&&b&&(!b.body||!b.body.firstChild))a.onload()}catch(c){}};gc.prototype.ia=function(a,b){var c=ic("rx",a),d;a:{if(a&&(d=a.match("dt=([^&]+)"))&&2==d.length){d=d[1];break a}d=""}d=(new Date).getTime()-d;c=c.replace(/&dtd=(\d+|-?M)/,"&dtd="+(1E5<=d?"M":0<=d?d:"-M"));this.set(b,c);return c};
var ic=function(a,b){var c=new RegExp("\\b"+a+"=(\\d+)"),d=c.exec(b);d&&(b=b.replace(c,a+"="+(+d[1]+1||1)));return b};var jc=!1,kc=function(a,b,c){var d=["<iframe"],e;for(e in a)a.hasOwnProperty(e)&&Ab(d,e+"="+a[e]);e="left:0;position:absolute;top:0;";jc&&(e=e+"width:"+b+"px;height:"+c+"px;");d.push('style="'+e+'"');d.push("></iframe>");a=a.id;b="border:none;height:"+c+"px;margin:0;padding:0;position:relative;visibility:visible;width:"+b+"px;background-color:transparent";return['<ins id="',a+"_expand",'" style="display:inline-table;',b,'"><ins id="',a+"_anchor",'" style="display:block;',b,'">',d.join(" "),"</ins></ins>"].join("")};var lc=function(a){if(!a)return"";(a=a.toLowerCase())&&"ca-"!=a.substring(0,3)&&(a="ca-"+a);return a};var mc={"120x90":!0,"160x90":!0,"180x90":!0,"200x90":!0,"468x15":!0,"728x15":!0};var nc="google_ad_client google_ad_format google_ad_height google_ad_width google_city google_country google_encoding google_language google_page_url".split(" "),oc=function(a){try{var b=a.top.google_ads_params_store;if(b)return b;b=a.top.google_ads_params_store={};if(b===a.top.google_ads_params_store)return b}catch(c){}return null};var pc,S=function(a){this.B=[];this.s=a||window;this.o=0;this.A=null;this.S=0},qc=function(a,b){this.Z=a;this.ka=b};S.prototype.enqueue=function(a,b){0!=this.o||0!=this.B.length||b&&b!=window?this.K(a,b):(this.o=2,this.O(new qc(a,window)))};S.prototype.K=function(a,b){this.B.push(new qc(a,b||this.s));rc(this)};S.prototype.$=function(a){this.o=1;if(a){var b=q(this.N,this,!0);this.A=this.s.setTimeout(C("sjr::timeout",b,void 0),a)}};
S.prototype.N=function(a){a&&++this.S;1==this.o&&(null!=this.A&&(this.s.clearTimeout(this.A),this.A=null),this.o=0);rc(this)};S.prototype.ea=function(){return!(!window||!Array)};S.prototype.ga=function(){return this.S};S.prototype.nq=S.prototype.enqueue;S.prototype.nqa=S.prototype.K;S.prototype.al=S.prototype.$;S.prototype.rl=S.prototype.N;S.prototype.sz=S.prototype.ea;S.prototype.tc=S.prototype.ga;var rc=function(a){var b=q(a.ha,a);a.s.setTimeout(C("sjr::tryrun",b,void 0),0)};
S.prototype.ha=function(){if(0==this.o&&this.B.length){var a=this.B.shift();this.o=2;var b=q(this.O,this,a);a.ka.setTimeout(C("sjr::run",b,void 0),0);rc(this)}};S.prototype.O=function(a){this.o=0;a.Z()};
var sc=function(a){try{return a.sz()}catch(b){return!1}},tc=function(a){return!!a&&("object"==typeof a||"function"==typeof a)&&sc(a)&&J(a.nq)&&J(a.nqa)&&J(a.al)&&J(a.rl)},uc=function(){if(pc&&sc(pc))return pc;var a=Mb(),b=a.google_jobrunner;return tc(b)?pc=b:a.google_jobrunner=pc=new S(a)},vc=function(a,b){uc().nq(a,b)},wc=function(a,b){uc().nqa(a,b)};var U=function(a){this.name="TagError";this.message=a||"";Error.captureStackTrace?Error.captureStackTrace(this,U):this.stack=Error().stack||""};da(U,Error);
var xc=Db?1==Cb(I):!Cb(I),yc=function(){var a=za?"https":"http",b=Oa("script");return["<",b,' src="',Yb(Ba(),"/pagead/js/r20151117/r20151006/show_ads_impl.js",a),'"></',b,">"].join("")},zc=function(a,b,c,d){return function(){var e=!1;d&&uc().al(3E4);try{var g=a.document.getElementById(b).contentWindow;if(Pa(g)){var f=a.document.getElementById(b).contentWindow,
h=f.document;h.body&&h.body.firstChild||(h.open(),f.google_async_iframe_close=!0,h.write(c))}else{for(var l=a.document.getElementById(b).contentWindow,g=c,g=String(g),f=['"'],h=0;h<g.length;h++){var k=g.charAt(h),m=k.charCodeAt(0),p=h+1,F;if(!(F=Ja[k])){var H;if(31<m&&127>m)H=k;else{var x=k;if(x in Ka)H=Ka[x];else if(x in Ja)H=Ka[x]=Ja[x];else{var u=x,r=x.charCodeAt(0);if(31<r&&127>r)u=x;else{if(256>r){if(u="\\x",16>r||256<r)u+="0"}else u="\\u",4096>r&&(u+="0");u+=r.toString(16).toUpperCase()}H=Ka[x]=
u}}F=H}f[p]=F}f.push('"');l.location.replace("javascript:"+f.join(""))}e=!0}catch(A){l=Mb().google_jobrunner,tc(l)&&l.rl()}e&&(e=ic("google_async_rrc",c),(new gc(a)).set(b,zc(a,b,e,!1)))}},Ac=function(a){var b=["<iframe"];zb(a,function(a,d){null!=a&&b.push(" "+d+'="'+a+'"')});b.push("></iframe>");return b.join("")},Cc=function(a,b,c){Bc(a,b,c,function(a,b,g){for(var f=a.document,h=b.id,l=0;!h||f.getElementById(h);)h="aswift_"+l++;b.id=h;b.name=h;var h=Number(g.google_ad_width),l=Number(g.google_ad_height),
k=N.G;ec(g,a,k.j,k.i);jc=K(P(a),k.i);16==g.google_reactive_ad_format?(a=f.createElement("div"),a.innerHTML=kc(b,h,l),c.appendChild(a.firstChild)):c.innerHTML=kc(b,h,l);return b.id})},Bc=function(a,b,c,d){var e=Oa("script"),g,f;a:{try{var h=a.top.google_pubvars_reuse_experiment;if("undefined"!==typeof h){f=h;break a}h=y(["C","E"],sa)||null;a.top.google_pubvars_reuse_experiment=h;if(a.top.google_pubvars_reuse_experiment===h){f=h;break a}}catch(ja){}f=null}if("E"===f){g=null!=b.google_ad_client;f=null!=
b.google_ad_width;var h=null!=b.google_ad_height,l=oc(a);if(l){for(var k=0;k<nc.length;k++){var m=nc[k];null!=b[m]&&(l[m]=b[m])}if(l=oc(a)){var k=l.google_ad_width,m=l.google_ad_height,p=l.google_ad_format;k&&m&&p&&(p=(p=p&&p.match(/(\d+)x(\d+)/))?{width:p[1],height:p[2]}:null,!p||p.width==k&&p.height==m||delete l.google_ad_format)}}if(l=oc(a))for(k=0;k<nc.length;k++)m=nc[k],null==b[m]&&null!=l[m]&&(b[m]=l[m]);l=null!=b.google_ad_client;k=null!=b.google_ad_width;m=null!=b.google_ad_height;g=[g?"c2":
l?"c1":"c0",f?"w2":k?"w1":"w0",h?"h2":m?"h1":"h0"].join()}f={};h=b.google_ad_height;f.width='"'+b.google_ad_width+'"';f.height='"'+h+'"';f.frameborder='"0"';f.marginwidth='"0"';f.marginheight='"0"';f.vspace='"0"';f.hspace='"0"';f.allowtransparency='"true"';f.scrolling='"no"';f.allowfullscreen='"true"';f.onload='"'+hc+'"';d=d(a,f,b);h=b.google_ad_output;f=b.google_ad_format;f||"html"!=h&&null!=h||(f=b.google_ad_width+"x"+b.google_ad_height,b.google_ad_format_suffix&&(f+=b.google_ad_format_suffix));
h=!b.google_ad_slot||b.google_override_format||!mc[b.google_ad_width+"x"+b.google_ad_height]&&"aa"==b.google_loader_used;f=f&&h?f.toLowerCase():"";b.google_ad_format=f;f=[b.google_ad_slot,b.google_ad_format,b.google_ad_type,b.google_ad_width,b.google_ad_height];h=[];l=0;for(k=c;k&&25>l;k=k.parentNode,++l)h.push(9!=k.nodeType&&k.id||"");(h=h.join())&&f.push(h);b.google_ad_unit_key=Va(f.join(":")).toString();f=a.google_adk2_experiment=a.google_adk2_experiment||y(["C","E"],qa)||"N";if("E"==f){f=[];for(h=
0;c&&25>h;++h){l="";l=(l=9!=c.nodeType&&c.id)?"/"+l:"";a:{if(c&&c.nodeName&&c.parentElement)for(var k=c.nodeName.toString().toLowerCase(),m=c.parentElement.childNodes,F=p=0;F<m.length;++F){var H=m[F];if(H.nodeName&&H.nodeName.toString().toLowerCase()==k){if(c==H){k="."+p;break a}++p}}k=""}f.push((c.nodeName&&c.nodeName.toString().toLowerCase())+l+k);c=c.parentElement}c=f.join()+":";f=a;h=[];if(f)try{for(var x=f.parent,l=0;x&&x!=f&&25>l;++l){for(var u=x.frames,k=0;k<u.length;++k)if(f==u[k]){h.push(k);
break}f=x;x=f.parent}}catch(ja){}b.google_ad_unit_key_2=Va(c+h.join()).toString()}else"C"==f&&(b.google_ad_unit_key_2="ctrl");x=Wb(b);u=null;c=y(["C","E"],ta);if("E"==c){a:{try{if(window.JSON&&window.JSON.stringify&&window.encodeURIComponent){var r=encodeURIComponent(window.JSON.stringify(b)),A;if(Ub)A=n.btoa(r);else{f=[];for(l=h=0;l<r.length;l++){for(var Q=r.charCodeAt(l);255<Q;)f[h++]=Q&255,Q>>=8;f[h++]=Q}if(!Tb)for(Tb={},r=0;65>r;r++)Tb[r]="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(r);
r=Tb;Q=[];for(h=0;h<f.length;h+=3){var L=f[h],wa=h+1<f.length,T=wa?f[h+1]:0,Z=h+2<f.length,Nb=Z?f[h+2]:0,l=L>>2,k=(L&3)<<4|T>>4,m=(T&15)<<2|Nb>>6,p=Nb&63;Z||(p=64,wa||(m=64));Q.push(r[l],r[k],r[m],r[p])}A=Q.join("")}u=A;break a}Jb("sblob",{json:window.JSON?1:0,eURI:window.encodeURIComponent?1:0})}catch(ja){z.u("sblob",ja,void 0,void 0)}u=""}u||(u="{X}")}else"C"==c&&(u="{C}");var B;b=b.google_ad_client;if(A=xc){if(!fc)b:{L=[n.top];A=[];for(wa=0;T=L[wa++];){A.push(T);try{if(T.frames)for(var M=T.frames.length,
Z=0;Z<M&&1024>L.length;++Z)L.push(T.frames[Z])}catch(ja){}}for(M=0;M<A.length;M++)try{if(B=A[M].frames.google_esf){fc=B;break b}}catch(ja){}fc=null}A=!fc}A?(B={style:"display:none"},B["data-ad-client"]=lc(b),B.id="google_esf",B.name="google_esf",B.src=Yb(ia("","googleads.g.doubleclick.net"),"/pagead/html/r20151117/r20151006/zrt_lookup.html"),B=Ac(B)):B="";M=ea;b=(new Date).getTime();if(A=a.google_async_for_oa_experiment)a.google_async_for_oa_experiment=
void 0;L=a.google_always_use_delayed_impressions_experiment;B=["<!doctype html><html><body>",B,"<",e,">",x,"google_show_ads_impl=true;google_unique_id=",Cb(a),';google_async_iframe_id="',d,'";google_start_time=',M,";",c?'google_pub_vars = "'+u+'";':"",g?'google_pubvars_reuse_experiment_result = "'+g+'";':"",A?'google_async_for_oa_experiment="'+A+'";':"",L?'google_always_use_delayed_impressions_experiment="'+L+'";':"","google_bpp=",b>M?b-M:1,";google_async_rrc=0;google_iframe_start_time=new Date().getTime();</",
e,">",yc(),"</body></html>"].join("");(a.document.getElementById(d)?vc:wc)(zc(a,d,B,!0))},Dc=function(a,b){var c=navigator;if(ra&&a&&b&&c){var c=a.document,d=Yb("pagead2.googlesyndication.com","/pub-config/"+lc(b)+".js");Ra(c,d)}};var V=function(a,b){this.M=a;this.L=b};V.prototype.minWidth=function(){return this.M};V.prototype.height=function(){return this.L};V.prototype.w=function(a){return 300<a&&300<this.L?this.M:1200<a?1200:Math.round(a)};var Ec={rectangle:1,horizontal:2,vertical:4,autorelaxed:1},W=function(a,b,c){V.call(this,a,b);this.ca=c};da(W,V);var Fc=function(a){return function(b){return!!(b.ca&a)}},Gc=[new W(970,90,2),new W(728,90,2),new W(468,60,2),new W(336,280,1),new W(320,100,2),new W(320,50,2),new W(300,600,4),new W(300,250,1),new W(250,250,1),new W(234,60,2),new W(200,200,1),new W(180,150,1),new W(160,600,4),new W(125,125,1),new W(120,600,4),new W(120,240,4)];var Hc=function(a,b){for(var c=["width","height"],d=0;d<c.length;d++){var e="google_ad_"+c[d];if(!b.hasOwnProperty(e)){var g;g=Za(a[c[d]]);g=null===g?null:Math.round(g);null!=g&&(b[e]=g)}}},Ic=function(a,b){try{var c=b.document.documentElement.getBoundingClientRect(),d=a.getBoundingClientRect();return{x:d.left-c.left,y:d.top-c.top}}catch(e){return null}},Jc=function(a){var b=0,c;for(c in Ec)-1!=a.indexOf(c)&&(b|=Ec[c]);return b};var Kc=function(a){return function(b){return b.minWidth()<=a}},Mc=function(a,b,c){var d=a&&Lc(c,b);return function(a){return!(d&&250<=a.height())}},Lc=function(a,b){var c=Math.min(O(b).clientHeight,16*O(b).clientWidth/9),d=Ic(a,b);return(d?d.y:0)<c-100},Oc=function(a,b){var c=b,d=Infinity;do{var e=Nc(c,a,"height");e&&(d=Math.min(d,e));(e=Nc(c,a,"maxHeight"))&&(d=Math.min(d,e))}while((c=c.parentElement)&&"HTML"!=c.tagName);return d},Nc=function(a,b,c){if(a.style){var d=Za(a.style[c]);if(d)return d}if(a=
Sa(a,b))if(d=Za(a[c]))return d;return null};var Pc=function(a){return function(b){for(var c=a.length-1;0<=c;--c)if(!a[c](b))return!1;return!0}},Qc=function(a,b,c){for(var d=a.length,e=null,g=0;g<d;++g){var f=a[g];if(b(f)){if(!c||c(f))return f;null===e&&(e=f)}}return e};var Sc=function(a,b,c,d){var e=Gc.slice(0);if(K(P(c),N.F.i))for(var g=Math.random,f=e.length-1;0<f;f--){var h=Math.floor(g()*(f+1)),l=e[f];e[f]=e[h];e[h]=l}g=488>O(c).clientWidth;b=[Kc(a),Rc(g),Mc(g,c,d),Fc(b)];e=Qc(e,Pc(b));if(!e)throw new U("adsbygoogle.push() error: No slot size for availableWidth="+a);return e},Rc=function(a){return function(b){return!(320==b.minWidth()&&(a&&50==b.height()||!a&&100==b.height()))}};var X=function(a,b){V.call(this,a,b)};da(X,V);X.prototype.w=function(a){return Math.min(1200,Math.round(a))};var Tc=[new X(468,300),new X(414,828),new X(384,768),new X(375,750),new X(360,720),new X(320,640),new X(120,600)],Uc=[new X(468,350),new X(414,828),new X(384,768),new X(375,750),new X(360,720),new X(320,640),new X(120,600)],Vc=function(a,b){var c=Qc(a,Kc(b));if(!c)throw new U("adsbygoogle.push() error: No autorelaxed size for width="+b+"px");return c};var Xc=function(){return!Wc()&&(E("iPod")||E("iPhone")||E("Android")||E("IEMobile"))},Wc=function(){return E("iPad")||E("Android")&&!E("Mobile")||E("Silk")};var Yc=[{l:[3,0,0],m:[6,12,14,0,1,3,2,4,13,5,7,8,9,10,11,15]},{l:[3,0,1],m:[6,15,0,1,2,3,4,13,5,7,8,9,10,11,12,14]},{l:[3,0,2],m:[6,15,0,1,2,3,4,7,8,9,10,13,5,11,12,14]},{l:[3,1,0],m:[6,12,15,0,1,3,4,13,2,5,7,8,9,10,11,14]},{l:[3,1,1],m:[6,15,0,1,7,8,11,2,3,4,5,9,10,12,13,14]},{l:[3,1,2],m:[6,15,0,1,2,3,4,7,9,11,5,8,10,12,13,14]},{l:[3,2,0],m:[0,6,12,15,1,2,3,4,13,5,7,8,9,10,11,14]},{l:[3,2,1],m:[0,6,12,14,1,2,3,4,13,5,7,8,9,10,11,15]},{l:[3,2,2],m:[0,15,1,2,3,4,13,9,5,6,7,8,10,11,12,14]},{l:[2,0,
0],m:[6,15,0,1,3,2,7,8,10,13,9,4,5,11,12,14]},{l:[2,0,1],m:[6,15,0,1,2,3,7,8,4,10,9,13,5,11,12,14]},{l:[2,0,2],m:[0,15,1,2,3,4,7,8,13,5,6,9,10,11,12,14]},{l:[4,0,0],m:[6,12,14,15,0,1,7,2,8,11,9,3,4,5,10,13]},{l:[4,0,1],m:[6,12,14,0,1,2,3,4,7,8,11,13,5,9,10,15]},{l:[4,0,2],m:[6,15,0,1,2,3,5,7,8,13,9,4,10,11,12,14]}],Zc=function(a,b,c){return"auto"==c?(b/=Math.min(1200,O(a).clientWidth),.6<b&&!(488>O(a).clientWidth)?2:.25>=b?4:3):Jc(c)},$c=function(a,b){var c=Oc(a,b);return function(a){return a.height()<=
c}},bd=function(a,b,c,d,e){var g;a:{var f;f=Xc()?2:Wc()?4:3;g=Ic(d,c);f=[f,g&&3==f?83>g.x?0:265>g.x?1:2:0,ad(f,g)];for(g=0;g<Yc.length;++g){var h=Yc[g],l;b:if(l=h.l,f&&"number"==typeof f.length&&l&&"number"==typeof l.length&&f.length==l.length){for(var k=f.length,m=0;m<k;m++)if(f[m]!==l[m]){l=!1;break b}l=!0}else l=!1;if(l){g=h.m;break a}}throw Error("No format for "+f);}f=[];for(h=0;h<g.length;++h)f.push(Gc[g[h]]);g=488>O(c).clientWidth;a=[$c(c,d),Kc(a),Mc(g,c,d)];c=[];(e?c:a).push(Fc(b));return Qc(f,
Pc(a),Pc(c))},ad=function(a,b){if(!b)return 0;var c=b.y;switch(a){case 2:return 285>c?0:1396>c?1:2;case 4:return 275>c?0:1057>c?1:2;default:return 216>c?0:838>c?1:2}};var Y=function(a,b){V.call(this,a,b)};da(Y,V);Y.prototype.w=function(){return this.minWidth()};var cd=[new Y(728,15),new Y(468,15),new Y(200,90),new Y(180,90),new Y(160,90),new Y(120,90)];var gd=function(){var a=window;if(void 0===a.google_dre){var b="";a.postMessage&&Qa(a)&&Xc()&&(b=y(["20050000","20050001"],ua))&&(a.google_ad_modifications=a.google_ad_modifications||{},a.google_ad_modifications.eids=a.google_ad_modifications.eids||[],a.google_ad_modifications.eids.push(b));a.google_dre=b;"20050001"==a.google_dre&&(ab(a.top,"message",C("dr::mh",t(dd,a),t(ed,a)),void 0),a.setTimeout(C("dr::to",t(fd,a,!0),t(ed,a)),2E3),a.google_drc=0,a.google_q=a.google_q||{},a.google_q.tags=a.google_q.tags||
[])}},hd=function(a){"20050001"==n.google_dre&&(a.params=a.params||{},a.params.google_delay_requests_delay=0,a.params.google_delay_requests_count=n.google_drc++,a.U=v())},id=function(a){if("20050001"==n.google_dre){var b=v()-a.U;a.params.google_delay_requests_delay=b}},dd=function(a,b){b&&"afb"==b.data&&Fb[b.origin]&&fd(a,!1)},fd=function(a,b){if(a.google_q&&a.google_q.tags){var c=a.google_q.tags;ed(a);c.length&&(b&&Jb("drt",{Ta:c.length,duration:2E3},1),jd(c))}};var kd=function(a){return Eb.test(a.className)&&"done"!=a.getAttribute("data-adsbygoogle-status")},md=function(a,b){var c=window;a.setAttribute("data-adsbygoogle-status","done");ld(a,b,c)},ld=function(a,b,c){nd(a,b,c);if(!od(a,b,c)){if(b.google_reactive_ads_config){if(pd)throw new U("adsbygoogle.push() error: Only one 'enable_page_level_ads' allowed per page.");pd=!0}else Bb(c);qd||(qd=!0,Dc(c,b.google_ad_client));zb(Vb,function(a,d){b[d]=b[d]||c[d]});b.google_loader_used="aa";var d=b.google_ad_output;
if(d&&"html"!=d)throw new U("adsbygoogle.push() error: No support for google_ad_output="+d);Hb("aa::load",Ib,function(){Cc(c,b,a)})}},od=function(a,b,c){var d=b.google_reactive_ads_config;if(d)var e=d.page_level_pubvars,g=(aa(e)?e:{}).google_tag_origin;var f=b.google_ad_slot,e=c.google_ad_modifications;!e||cc(e.ad_whitelist,f,g||b.google_tag_origin)?e=null:(g=e.space_collapsing||"none",e=(f=cc(e.ad_blacklist,f))?{I:!0,R:f.space_collapsing||g}:e.remove_ads_by_default?{I:!0,R:g}:null);return e&&e.I&&
"on"!=b.google_adtest?("slot"==e.R&&(null!==Ya(a.getAttribute("width"))&&a.setAttribute("width",0),null!==Ya(a.getAttribute("height"))&&a.setAttribute("height",0),a.style.width="0px",a.style.height="0px"),!0):!(e=Sa(a,c))||"none"!=e.display||"on"==b.google_adtest||0<b.google_reactive_ad_format||d?!1:(c.document.createComment&&a.appendChild(c.document.createComment("No ad requested because of display:none on the adsbygoogle tag")),!0)},rd=function(a,b){var c;try{c=a.getBoundingClientRect()}catch(e){}if(!c||
0==c.left&&0==c.right&&0==c.width&&0==c.height)return!1;var d=Sa(a,b);if(!d)return!1;c=Za(d.width);d=Za(d.height);return null==c||null==d||mc[c+"x"+d]?!1:!0},nd=function(a,b,c){for(var d=a.attributes,e=d.length,g=0;g<e;g++){var f=d[g];if(/data-/.test(f.name)){var h=f.name.replace("data","google").replace(/-/g,"_");if(!b.hasOwnProperty(h)){var f=f.value,l={google_reactive_ad_format:fa,google_allow_expandable_ads:ga},f=l.hasOwnProperty(h)?l[h](f,null):f;null===f||(b[h]=f)}}}if(b.google_enable_content_recommendations&&
1==b.google_reactive_ad_format)b.google_ad_width=O(c).clientWidth,b.google_ad_height=50,a.style.display="none";else if(1==b.google_reactive_ad_format)b.google_ad_width=320,b.google_ad_height=50,a.style.display="none";else if(8==b.google_reactive_ad_format)b.google_ad_width=O(c).clientWidth||0,b.google_ad_height=O(c).clientHeight||0,a.style.display="none";else if(9==b.google_reactive_ad_format)b.google_ad_width=O(c).clientWidth||0,b.google_ad_height=O(c).clientHeight||0,a.style.display="none";else{d=
b.google_ad_format;"autorelaxed"==d?(d=N.C,ec(b,c,d.j,d.i),d=K(P(c),N.C.i)?3:2):"auto"==d||/^((^|,) *(horizontal|vertical|rectangle) *)+$/.test(d)?(d=N.D,ec(b,c,d.j,d.i),d=K(P(c),N.D.i)||K(P(c),N.v.i)?5:1):d="link"==d?4:void 0;if(e=!d)rd(a,c)?(e=N.v,ec(b,c,e.j,e.i)!==e.i?e=!1:(b.google_ad_format="auto",e=!0)):e=!1;e&&(d=5);if(d){var k=a.offsetWidth;a:{var m=b.google_ad_format;switch(d){default:case 1:var p="auto"==m?.25>=k/Math.min(1200,O(c).clientWidth)?4:3:Jc(m);b&&(b.google_responsive_formats=
p,m=N.F,ec(b,c,m.j,m.i));c=Sc(k,p,c,a);break a;case 2:c=Vc(Tc,k);break a;case 3:c=Vc(Uc,k);break a;case 5:m=Zc(c,k,m);b.google_responsive_formats=m;var F=K(P(c),N.v.i);b:{d=a;do if((e=Sa(d,c))&&"fixed"==e.position){d=!1;break b}while(d=d.parentElement);d=!0}d&&(p=bd(k,m,c,a,F));c=p||Sc(k,m,c,a);break a;case 4:c=Qc(cd,Kc(k));if(!c)throw new U("adsbygoogle.push() error: No link unit size for width="+k+"px");b.google_ad_format_suffix="_0ads_al";b.google_override_format=1}}b.google_ad_width=c.w(k);b.google_ad_height=
c.height();a.style.height=c.height()+"px";b.google_ad_resizable=!0;delete b.google_ad_format;b.google_loader_features_used=128}else{p=rd(a,c)?(p=y(["LC","LE"],pa))?"LE"==(b.google_responsive_override_logs_experiment=p):!1:!1;if(p)try{m=a.offsetWidth,F=bd(m,Zc(c,m,"auto"),c,a,!0),k=new Na(F.w(m),F.height()),b.google_ember_w=k.width,b.google_ember_h=k.height}catch(H){b.google_ember_w=b.google_ember_h="e"}!Xa.test(b.google_ad_width)&&!Wa.test(a.style.width)||!Xa.test(b.google_ad_height)&&!Wa.test(a.style.height)?
(c=Sa(a,c),a.style.width=c.width,a.style.height=c.height,Hc(c,b),b.google_ad_width||(b.google_ad_width=a.offsetWidth),b.google_ad_height||(b.google_ad_height=a.offsetHeight),b.google_loader_features_used=256):(Hc(a.style,b),b.google_ad_output&&"html"!=b.google_ad_output||300!=b.google_ad_width||250!=b.google_ad_height||(c=a.style.width,a.style.width="100%",p=a.offsetWidth,a.style.width=c,b.google_available_width=p))}}},sd=function(a){for(var b=document.getElementsByTagName("ins"),c=0,d=b[c];c<b.length;d=
b[++c]){var e=d;if(kd(e)&&"reserved"!=e.getAttribute("data-adsbygoogle-status")&&(!a||d.id==a))return d}return null},pd=!1,qd=!1,vd=function(a){if(Xc()&&!n.google_q){n.google_q={};var b;a:{try{b=n.JSON.parse(n.localStorage.getItem("google_ama_config")||"");break a}catch(e){}b=null}if(b)if(b.exp>v()&&Zb(b)){n.google_q.tags=[];var c=v();b=Yb(Ba(),b.lib);b=Ra(n.document,b);b.onload=C("aa::amarn",t(td,n,c,a),t(ed,n));var d=C("aa::amaabt",t(ud,n,b,c),t(ed,n));n.setTimeout(function(){n.setTimeout(d,100)},
0)}else try{n.localStorage.removeItem("google_ama_config")}catch(e){$b(n,{lserr:1})}}},td=function(a,b,c){a.google_q.tags&&($b(a,{stg:1,t:v()-b}),(b=a.google_amar)&&J(b)&&Hb("aa::amar",Ib,t(b,a,c)),wd(a))},ud=function(a,b,c){a.google_q.tags&&(b.onload=function(){$b(a,{stg:0,t:v()-c})},wd(a))},wd=function(a){var b=a.google_q.tags;a.google_q.tags=void 0;jd(b)},ed=function(a){a.google_q.tags=void 0},jd=function(a){if(a&&a.shift)try{for(var b,c=20;0<a.length&&(b=a.shift())&&0<c;)xd(b),--c}catch(d){throw window.setTimeout(yd,
0),d;}},zd=function(a,b){var c={};zb(ac,function(b,d){a.hasOwnProperty(d)&&(c[d]=a[d])});aa(a.enable_page_level_ads)&&(c.page_level_pubvars=a.enable_page_level_ads);var d=document.createElement("ins");d.className="adsbygoogle";d.style.display="none";b?yb.body.appendChild(d):yb.documentElement.appendChild(d);md(d,{google_reactive_ads_config:c,google_ad_client:a.google_ad_client})},Ad=function(a){if(!Qa(window))throw new U("adsbygoogle.push() error: Page-level tag does not work inside iframes.");var b=
K(P(I),N.H.i),c=!b;yb.body||b?zd(a,c):ab(yb,"DOMContentLoaded",Kb(function(){zd(a,c)}))},Bd=function(a,b,c,d){if(0==b.message.indexOf("TagError")){var e={};ib(z,e,d);e.context=a;e.msg=b.message.substring(0,512);a=n.document;e.url=a.URL.substring(0,512);e.ref=a.referrer.substring(0,512);db(Gb,"puberror",e,!0,c||.01);return!1}return z.u(a,b,c,d)},Cd=function(a,b,c,d){return 0==b.message.indexOf("TagError")?!1:z.u(a,b,c,d)},xd=function(a){var b={};Hb("aa::hqe",Bd,function(){Dd(a,b)},function(c){c.client=
c.client||b.google_ad_client||a.google_ad_client;c.slotname=c.slotname||b.google_ad_slot;c.tag_origin=c.tag_origin||b.google_tag_origin})},Dd=function(a,b){ea=(new Date).getTime();if(n.google_q&&n.google_q.tags)hd(a),n.google_q.tags.push(a);else{var c;a:{if(a.enable_page_level_ads){if("string"==typeof a.google_ad_client){c=!0;break a}throw new U("adsbygoogle.push() error: 'google_ad_client' is missing from the tag config.");}c=!1}if(c)vd(a.google_ad_client),Ad(a);else{n.google_q?id(a):(gd(),hd(a));
c=a.element;var d=a.params;d&&zb(d,function(a,c){b[c]=a});if(c){if(!kd(c)&&(c=c.id?sd(c.id):null,!c))throw new U("adsbygoogle.push() error: 'element' has already been filled.");if(!("innerHTML"in c))throw new U("adsbygoogle.push() error: 'element' is not a good DOM element.");}else if(c=sd(),!c)throw new U("adsbygoogle.push() error: All ins elements in the DOM with class=adsbygoogle already have ads in them.");md(c,b)}}},yd=function(){Hb("aa::main",Cd,Ed)},Ed=function(){var a=I.google_ad_modifications=
I.google_ad_modifications||{};if(!a.plle){a.plle=!0;var a=a.loeids=a.loeids||[],b=N.D,c=b.i;if(I.location&&I.location.hash=="#google_plle_"+c)b=c;else{var b=[b.j,c],c=new Ma(ka,ka+la-1),d;(d=0>=la||la%b.length)||(d=bc.ba,d=!(d.start<=c.start&&d.end>=c.end));d?b=null:(d=$a(I),b=null!==d&&c.start<=d&&c.end>=d?b[(d-ka)%b.length]:null)}b&&a.push(b);b=N.C;(b=dc(ma,b.j,b.i))&&a.push(b);b=N.F;(b=dc(na,b.j,b.i))&&a.push(b);b=N.v;(b=dc(oa,b.j,b.i))&&a.push(b);b=N.G;(b=dc(va,b.j,b.i))&&a.push(b);yb.body||(b=
N.H,(b=dc(xa,b.j,b.i))&&a.push(b))}a=window.adsbygoogle;jd(a);if(!a||!a.loaded){window.adsbygoogle={push:xd,loaded:!0};a&&Fd(a.onload);try{Object.defineProperty(window.adsbygoogle,"onload",{set:Fd})}catch(e){}}},Fd=function(a){J(a)&&window.setTimeout(a,0)};yd();}).call(this);
