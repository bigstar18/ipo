var needRefresh = false;

$ (document).ready (function ()
{
	load ();
	if (needRefresh)
	{
		setTimeout (function ()
		{
			reload ()
		}, 3000);
	}
});

function load ()
{
	$ ('#tt').datagrid (
	{
	    url : getRootPath () + "/sysController/getClearRecords?_=" + Math.random (),
	    method : "get",
	    // loadMsg : '数据加载中......',
	    nowrap : true,
	    singleSelect : true,
	    striped : true,
	    collapsible : false,
	    fitColumns : true,// 允许表格自动缩放,以适应父容器
	    remoteSort : false,
	    pagination : false,
	    rownumbers : false,
	    columns : [
		    [
		            {
		                field : 'actionid',
		                width : 200,
		                align : "center",
		                title : '序号'
		            },
		            {
		                field : 'actionnote',
		                width : 200,
		                align : "center",
		                title : '步骤名称说明'
		            },
		            {
		                field : 'status',
		                width : 200,
		                align : "center",
		                title : '状态'
		            },
		            {
		                field : 'finishtime',
		                width : 200,
		                align : "center",
		                title : '完成时间'
		            }
		    ]
	    ]
	});
}

function reload ()
{
	// 只有ie有效？
	// $ ('#tt').datagrid ('reload');
	$ ('#tt').html ();
	load ();
	if (needRefresh)
	{
		setTimeout (function ()
		{
			reload ()
		}, 3000);
	}
}
