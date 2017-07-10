<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- Modal -->
<div class="modal fade" id="shopModal" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<input type="hidden" id="reviewseq" name="reviewseq" value="">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Shop Detail</h4>
			</div>
			<div class="row">
					<div class="col-md-12" id="shopInfoOne">
					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning"
					onclick="javascript:modifyShop();">매장정보 수정</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function modifyShop() {
	var shopseq = document.getElementById("shopinform").value;
	var cate = document.getElementById("shop_title").value;
	var shopname = document.getElementById("shop_name").value;
	var shopnum = document.getElementById("shop_tel").value;
	var shopadd = document.getElementById("shop_add").value;
	   $.post("/secondproject/adminshop",
			    {
			        act: "modify",
			        seq: shopseq,
			        cate: cate,
			        shopname: shopname,
			        shopnum: shopnum,
			        shopadd:shopadd
			    },
			    function(data, status){
			        var tt = document.getElementById("shopNew");
			        tt.innerHTML=data;
			        $('#shopModal').modal('hide');
			    });
	  
}
</script>
