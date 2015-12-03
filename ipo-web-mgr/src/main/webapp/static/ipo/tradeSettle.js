function getStatus ()
{// 要防缓存？
	$.ajax (
	{
	    type : 'GET', //
	    url : getRootPath () + "/sysController/getSettleStatus",
	    async : false,
	    cache : false,
	    dataType : 'json',
	    success : function (data)
	    {
		    showStatus (data);
	    }
	});
}

function showStatus (result)
{
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
		$ ('#add').css ("disabled", "false");
	}
	else
	{
		$ ('#add').css ('disabled', "true");
	}
	$ ('#balanceStatus').html (statusStr);
}

// 添加信息跳转
function addF ()
{
	if (confirm ("您确定要操作吗？"))
	{
		$ ('#add').css ('disabled', "true");// 立刻禁止
		
		$.ajax (
		{
		    type : 'POST', //
		    url : getRootPath () + "/sysController/settle",
		    cache : false,
		    dataType : 'json',
		    success : function (data)
		    {
			    setTimeout ("getStatus()", 2000);
			    updateList (data);
		    }
		});
	}
}

function updateList (data)
{
	// id,status,time
}

function ecReloadF ()
{
	if (document.readyState == "complete") // 当页面加载状态为完全结束时进入
	{
		ECSideUtil.reload ('ec');
	}
	setTimeout ("ecReloadF()", 1000);
}
