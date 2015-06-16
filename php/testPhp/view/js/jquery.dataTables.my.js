(function($) {
	var defaultOptions = {
		serverSide: true,
    	pageLength: 10,
    	pages: 2,
    	info: true,
    	language: {
    		"lengthMenu": "每页显示 _MENU_条",
    		"zeroRecords": "没有找到符合条件的数据",
    		"processing": "&lt;img src=’./loading.gif’ /&gt;",
    		"info": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",
    		"infoEmpty": "木有记录",
    		"infoFiltered": "(从 _MAX_ 条记录中过滤)",
    		"search": "搜索：",
    		"paginate": {
    		"first": "首页",
    		"previous": "前一页",
    		"next": "后一页",
    		"last": "尾页"
    		}
    	}
	}
	var methods = {
		init: function(options) {
//			var needBack = $.extend({}, true, this.DataTable($.extend({}, defaultOptions, options)), {
//				saveUrl: "/what/save"
//			})
			var needBack = this.DataTable($.extend({}, defaultOptions, options));
			return needBack;
		},
		changeColor: function() {
			$(this).find("tr").eq(0).css("color", "red");		
		}
	}
	$.fn.myTable = function() {
		var method = arguments[0];
        if(methods[method]) {
            method = methods[method];
            arguments = Array.prototype.slice.call(arguments, 1);
        } else if( typeof(method) == 'object' || !method ) {
            method = methods.init;
        } else {
            $.error( 'Method ' +  method + ' does not exist on jQuery.myTable' );
            return this;
        }
        return method.apply(this, arguments);
	}
	/**
	 * 为datatable注册方法
	 */
	$.fn.DataTable.Api.register("renho()", function() {
		console.info("renho");		
	});
	
	$.fn.DataTable.Api.register("save()", function(x) {
		var temp = this.settings();
		console.info("save:" + this.saveUrl);
	});
	
	$.fn.DataTableExt.aoFeatures.push({
		"fnInit": function( oDTSettings ) {
			oDTSettings.saveUrl = "/what/save";
		},
		"saveUrl": "/what/save"
	});
})(jQuery);