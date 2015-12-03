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

// 添加信息跳转 //可以加进度条
function addF ()
{
	if (confirm ("您确定要操作吗？"))
	{
		alert ("没有需要结算的订单。");
		return;
		setTimeout ("getStatus()", 3000);
		$ ('#add').css ('disabled', "true");// 立刻禁止
		
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
