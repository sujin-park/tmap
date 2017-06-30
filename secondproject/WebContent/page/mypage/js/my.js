function moveWrite() {
   
   document.commonForm.act.value="mvwrite";
   document.commonForm.bcode.value=bcode;
   document.commonForm.pg.value="1";
   document.commonForm.key.value="";
   document.commonForm.word.value="";
   document.commonForm.action=root+control;
   document.commonForm.submit();
   
}
function firstArticle() {
   
   document.commonForm.act.value="list";
   document.commonForm.bcode.value=bcode;
   document.commonForm.pg.value="1";
   document.commonForm.key.value="";
   document.commonForm.word.value="";
   document.commonForm.action=root+control;
   document.commonForm.submit();
   
}

function listArticle(mvpg) {
   
   document.commonForm.act.value="list";
   document.commonForm.bcode.value=bcode;
   document.commonForm.pg.value=mvpg;
   document.commonForm.key.value=key;
   document.commonForm.word.value=word;
   document.commonForm.action=root+control;
   document.commonForm.submit();
   
}

function viewArticle(seq) {
   
   document.commonForm.act.value="view";
   document.commonForm.bcode.value=bcode;
   document.commonForm.pg.value=pg;
   document.commonForm.key.value=key;
   document.commonForm.word.value=word;
   document.commonForm.seq.value=seq;
   document.commonForm.action=root+control;
   document.commonForm.submit();
   
}