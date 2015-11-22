<%@ page contentType="text/html;charset=UTF-8"%>
<script>
function showKeyPress(evt) {
	evt = (evt) ? evt : window.event
	return checkSpecific(String.fromCharCode(evt.keyCode));
}
function checkSpecific(realkey){
	var specialKey = "!<>#$()?%\&\^*\'\"\+\|";//特殊字符列表
	var flg = false;
	flg = (specialKey.indexOf(realkey) >= 0);
	if (flg) {
		return false;
	}
	return true;
}
document.onkeypress=showKeyPress;
</script>