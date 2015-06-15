// 创建一个闭包  
(function($) {
	// 插件的定义  
	$.fn.hilight = function(options) {
		debug(this);
		// build main options before element iteration  
		var opts = $.extend({}, $.fn.hilight.defaults, options);
		return this;
	};
	// 私有函数：debugging  
	function debug($obj) {
		if (window.console && window.console.log)
			window.console.log('hilight selection count: ' + $obj.size());
	};
	// 定义暴露format函数  
	$.fn.hilight.format = function(txt) {
		return '<strong>' + txt + '</strong>';
	};
	// 插件的defaults  
	$.fn.hilight.defaults = {
		foreground : 'red',
		background : 'yellow'
	};
	// 闭包结束  
})(jQuery);

/**
 * 面向对象
 */
;
(function($, window, document, undefined) {
	//定义Beautifier的构造函数
	var Beautifier = function(ele, opt) {
		this.$element = ele, this.defaults = {
			'color' : 'red',
			'fontSize' : '12px',
			'textDecoration' : 'none'
		}, this.options = $.extend({}, this.defaults, opt)
	}
	//定义Beautifier的方法
	Beautifier.prototype = {
		beautify : function() {
			return this.$element.css({
				'color' : this.options.color,
				'fontSize' : this.options.fontSize,
				'textDecoration' : this.options.textDecoration
			});
		}
	}
	//在插件中使用Beautifier对象
	$.fn.myPlugin = function(options) {
		//创建Beautifier的实体
		var beautifier = new Beautifier(this, options);
		//调用其方法
		return beautifier.beautify();
	}
})(jQuery, window, document);