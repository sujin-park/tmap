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
					onclick="javascript:blindReviewOne();">Blind</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>