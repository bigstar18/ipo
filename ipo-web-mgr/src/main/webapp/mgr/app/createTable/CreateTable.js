/**
 * 动态生成table
 * li
 */
function createTable(obj,titles,info){
	var tableStyle='border-collapse:collapse;border-spacing:0;border-left:1px solid #000;border-top:1px solid #000;';
	var tdStyle="border-right:1px solid #000;border-bottom:1px solid #000;padding:5px 15px;";	
	var table=$("<table style='"+tableStyle+"'>");
	table.appendTo($(obj));
	var trTitle=$("<tr></tr>");
	trTitle.appendTo(table);
	for(var title in titles){
		var td = $("<td style='"+tdStyle+"'>"+titles[title]+"</td>");
		td.appendTo(trTitle);
	}
	for(var i in info){
		var tr=$("<tr></tr>");
		tr.appendTo(table);
		for(var j in info[i]){
			var td = $("<td style='"+tdStyle+"'>"+info[i][j]+"</td>");
			td.appendTo(tr);
		}
	}
	$(obj).append("</table>");
}