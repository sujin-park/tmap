<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<div class="modal fade" tabindex="-1" role="dialog" id="modal_add_shop"
	data-backdrop="static">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">매장등록</h4>
			</div>
			<form>
				<div class="modal-body">
					<div class="form-group">
						<label for="title">매장명</label>
						<input type="email" class="form-control" id="title" placeholder="Email">
					</div>
					<div class="form-group">
						<label for="address">주소</label>
						<input type="email" class="form-control" id="address">
					</div>
					<div class="form-group">
						<label for="detail">메모</label>
						<textarea class="form-control" rows="3" id="detail"></textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputFile">File input</label>
						<input type="file" id="exampleInputFile">
						<p class="help-block">Example block-level help text here.</p>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox">Check me out</label>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">등록</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>