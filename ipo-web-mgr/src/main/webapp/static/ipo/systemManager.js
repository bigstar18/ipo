$ (document).ready (function ()
{
	$.ajax (
	{
	    type : 'GET', //
	    url : getRootPath () + "/sysController/getSysStatus",
	    dataType : 'json',
	    success : function (data)
	    {
		    showTime (data.sysTime);
		    showMarket (data);
		    buttonStatus (data.status);
	    }
	});
});
// {"sysTime":null,"status":1,"sectionid":1,"tradedate":"2015-11-28 19:23:26","recovertime":null,"note":"aa"}
function showTime (sysTime)
{
	$ ('#systime').text (sysTime);
}

function showMarket (data)
{
	$ ('#tradeDate').text (data.tradedate);
	$ ('#marketStatus').text (data.statusStr);
	if (data.note != null)
		$ ('#remark').text (data.note);
	if (data.sectionid != null)
		$ ('#session').text (data.sectionid);
	if (data.status != '0')
	{
		$ ('#tradeColor').css ("color", "gray");
	}
}

function buttonStatus (result)
{
	if (result == "3")
	{ // 资金结算完成
		$ ('#ok2').attr ('disabled', "true");
		$ ('#ok3').attr ('disabled', "true");
		$ ('#ok4').removeAttr ("disabled");
		$ ('#ok1').attr ('disabled', "true");
		$ ('#ok11').attr ('disabled', "true");
	}
	if (result == "5" || result == "8")
	{// 交易中、集合竞价交易中
	
		$ ('#ok2').removeAttr ("disabled");
		$ ('#ok3').removeAttr ("disabled");
		$ ('#ok4').attr ('disabled', "true");
		$ ('#ok1').attr ('disabled', "true");
		$ ('#ok11').attr ('disabled', "true");
	}
	if (result == "4")
	{ // 暂停交易
		$ ('#ok2').attr ('disabled', "true");
		$ ('#ok3').attr ('disabled', "true");
		$ ('#ok4').attr ('disabled', "true");
		$ ('#ok1').removeAttr ("disabled");
		$ ('#ok11').attr ('disabled', "true");
	}
	if (result == "6")
	{// 节间休息
		$ ('#ok2').removeAttr ("disabled");
		$ ('#ok3').removeAttr ("disabled");
		$ ('#ok4').attr ('disabled', "true");
		$ ('#ok1').attr ('disabled', "true");
		$ ('#ok11').attr ('disabled', "true");
	}
	if (result == "9")
	{// 集合竞价交易结束
		$ ('#ok2').removeAttr ("disabled");
		$ ('#ok3').attr ('disabled', "true");
		$ ('#ok4').attr ('disabled', "true");
		$ ('#ok1').attr ('disabled', "true");
		$ ('#ok11').attr ('disabled', "true");
	}
	if (result == "7")
	{ // 交易结束
		$ ('#ok2').attr ('disabled', "true");
		$ ('#ok3').attr ('disabled', "true");
		$ ('#ok4').attr ('disabled', "true");
		$ ('#ok1').attr ('disabled', "true");
		$ ('#ok11').removeAttr ("disabled");
	}
	// if (result == "初始化失败") {
	// $ ('#ok2').attr('disabled',"true");
	// $ ('#ok3').attr('disabled',"true");
	// $ ('#ok4').removeAttr("disabled");
	// $ ('#ok1').attr('disabled',"true");
	// $ ('#ok11').removeAttr("disabled");
	// }
	if (result == "0" || result == "1" || result == "2" || result == "10")
	{// 初始化完成、闭市状态、结算中、交易结算完成
		$ ('#ok2').attr ('disabled', "true");
		$ ('#ok3').attr ('disabled', "true");
		$ ('#ok4').attr ('disabled', "true");
		$ ('#ok1').attr ('disabled', "true");
		$ ('#ok11').attr ('disabled', "true");
	}
}
function balanceChk_onclick (id)
{
	var name;
	
	if (id == '06')
	{
		name = "恢复交易";
	}
	if (id == '09')
	{
		name = "交易结束";
	}
	if (id == '05')
	{
		name = "暂停交易";
	}
	if (id == '08')
	{
		name = "开市准备";
	}
	if (id == '07')
	{
		name = "闭市操作";
	}
	if (id == "99")
	{
		name = "设定恢复时间"
	}
	if (confirm ("您确定要" + name + "吗？"))
	{
		$.ajax (
		{
		    type : 'POST', //
		    url : getRootPath () + "/sysController/sysOperate",
		    data :
		    {
			    "code" : id
		    },
		    dataType : 'json',
		    success : function (data)
		    {
			    if (data.result == 'success')
			    {
				    alert ("执行成功");
				    // alert (data.business.status);
				    buttonStatus (data.business.status);
				    $ ('#tradeDate').text (data.business.tradeDate);
			    }
			    else
			    {
				    alert (data.msg);
			    }
		    }
		});
	}
}
