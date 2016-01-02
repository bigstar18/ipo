var clearStatus;
$ (document).ready (function ()
{
	$ ('#add').attr ('disabled', "true");
	$ ('#add').css ('color', "white");
	getStatus ();
});

function getStatus ()
{// 要防缓存？
	$.ajax (
	{
	    type : 'GET', //
	    url : getRootPath () + "/sysController/getSettleStatus",
	    // async : false,
	    cache : false,
	    dataType : 'json',
	    success : function (data)
	    {
		    showStatus (data);
	    }
	});
	// 结算成功了就不做
	if (clearStatus != 3 && clearStatus != 10)
	{
		setTimeout ("getStatus()", 5000);
	}
}

function showStatus (result)
{
	clearStatus = result;
	var statusStr = "";
	if (result == 2)
	{
		statusStr = "结算状态：执行中";
	}
	else if (result == 3 || result == 10)
	{
		statusStr = "结算状态：结算完成";
	}
	else
	{
		statusStr = "结算状态：未执行";
	}
	if (result == 1)
	{// 只有闭市状态可以做交易结算
		$ ('#add').removeAttr ("disabled");
		$ ('#add').css ('color', "black");
	}
	else
	{
		$ ('#add').attr ('disabled', "true");
		$ ('#add').css ('color', "white");
	}
	$ ('#balanceStatus').html (statusStr);
}

// 添加信息跳转 //可以加进度条
function addF ()
{
	if (confirm ("您确定要操作吗？"))
	{
		$ ('#add').attr ('disabled', "true");// 立刻禁止
		$ ('#add').css ('color', "white");
		parent.document.frames['mainFrame'].needRefresh = true;
		parent.document.frames['mainFrame'].reload ();
		
		$.ajax (
		{
		    type : 'POST', //
		    url : getRootPath () + "/sysController/settle",
		    cache : false,
		    dataType : 'json',
		    success : function (data)
		    {
			    if (data.result == 'success')
			    {
				    alert ("执行成功");
			    }
			    else
			    {
				    alert (data.msg);
			    }
			    parent.document.frames['mainFrame'].needRefresh = false;
		    }
		});
	}
}
