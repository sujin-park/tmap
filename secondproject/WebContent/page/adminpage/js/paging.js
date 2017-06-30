function firstArticle(){
	document.commonForm.act.value = act;
	document.commonForm.board.value = board;
	document.commonForm.pg.value = "1";
	document.commonForm.key.value = "";
	document.commonForm.word.value = "";
	
	document.commonForm.action = root +"/admin";
	document.commonForm.submit();
}

function listArticle(mpg){
	document.commonForm.act.value = act;
	document.commonForm.board.value = board;
	document.commonForm.pg.value = mpg;
	document.commonForm.key.value = key;
	document.commonForm.word.value = word;
	
	document.commonForm.action = root +"/admin";
	document.commonForm.submit();
}