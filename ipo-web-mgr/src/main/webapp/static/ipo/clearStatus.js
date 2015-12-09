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
	
}
