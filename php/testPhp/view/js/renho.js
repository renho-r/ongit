$(function() {
	
    $('#table_id').DataTable({
    	ajax: {
    		url: "/testPhp/php/renho.php?method=queryAllAsArray",
    		data: function(d) {
    			d.renho = (new Date()).getTime();
    			return d;
    		}
    	},
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
    });
	
	$("#renho").click(function() {
		var table = $('#table_id_renho').DataTable({
			
			"scrollY": "300px",
			"scrollX": "100%",
			"scrollCollapse": true,
			order: [[1, 'asc']],
			columns: [{data: "USERID", render: function() {
						return "<input type='checkbox'>";
					  }, orderable: false},
			          {data: 'USERID', name: 'USERID', "title": "renho"},
			          {data: 'LOGINNAME', "title": "LOGINNAME"},
			          {data: 'LOGINPWD', "title": "LOGINPWD"},
			          {data: 'USERNAME', "title": "USERNAME"},
			          {data: 'LOGINNAME', "title": "LOGINNAME"},
			          {data: 'LOGINPWD', "title": "LOGINPWD"},
			          {data: 'LOGINNAME', "title": "LOGINNAME"},
			          {data: 'LOGINPWD', "title": "LOGINPWD"},
			          {data: 'LOGINNAME', "title": "LOGINNAME"},
			          {data: 'LOGINPWD', "title": "LOGINPWD"},
			          {data: 'LOGINNAME', "title": "LOGINNAME"},
			          {data: 'LOGINPWD', "title": "LOGINPWD"},
			          {data: 'LOGINNAME', "title": "LOGINNAME"},
			          {data: 'LOGINPWD', "title": "LOGINPWD"}
			],
	    	ajax: {
	    		url: "/testPhp/php/renho.php?method=queryAllAsJson",
	    		data: function(d) {
	    			d.renho = (new Date()).getTime();
	    			for(var i in d.order) {
	    				d.order[i].fieldName = d.columns[i].data;
	    			}
	    			var req = {};
	    			req.jsonStr = JSON.stringify(d);
	    			return d;
	    		}
	    	},
	    	lengthMenu: [ 2, 10, 25, 50, 75, 100 ],
	    	serverSide: true,
	    	pageLength: 2,
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
	    });
		new $.fn.dataTable.FixedColumns(table, {
		    "leftColumns": 2
		});
		$('#table_id_renho').on('draw.dt', function () {
			$(".DTFC_RightBodyWrapper .DTFC_RightBodyLiner").css("overflow-y", "auto");
		});
	})
})