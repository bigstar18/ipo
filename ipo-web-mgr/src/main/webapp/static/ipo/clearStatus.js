$ (document).ready (function ()
{
	getClearRecords ();
});

function getClearRecords ()
{// 要防缓存
	$.ajax (
	{
	    type : 'GET', //
	    url : getRootPath () + "/sysController/getClearRecords",
	    // async : false,
	    cache : false,
	    dataType : 'json',
	    success : function (data)
	    {
		    showRecord (data);
	    }
	});
	
	setTimeout ("getClearRecords()", 2000);
}

function showRecord (result)
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
