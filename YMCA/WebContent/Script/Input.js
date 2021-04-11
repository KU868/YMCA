/**
 * 
 */

/*保存時の確認メッセージ*/
document.getElementById('button_Save').onclick = function(){
	window.confirm("保存しますか？");
}

/*保存時の入力チェック 桁数*/
document.getElementById('button_Save').onclick = function(){
	var AA01GAIYOU = document.getElementById('id_AA01GAIYOU').value;
	
	var AA01SYOUSAI = document.getElementById('id_AA01SYOUSAI').value;
	
	var len1 =  AA01GAIYOU.length;
	
	var len2 =  AA01SYOUSAI.length;
	
	if(len1 >= 100){
		window.alert("概要は100文字以内で入力してください");
		return false;
	}
	
	if(len2 >= 1000){
		window.alert("詳細は1000文字以内で入力してください");
		return false;
	}
	
	
}