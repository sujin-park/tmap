<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<input type="hidden" id="reviewseq" name="reviewseq" value="">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Review Detail</h4>
			</div>
			<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="inputName">매장명</label> <input type="text"
												class="form-control" name="subject" id="modalshop"
												value="" readonly="readonly">
										</div>
										<label for="inputStore">작성자</label>
											<div class="input-group">
												<input type="text" class="form-control" id="modalemail"
													name="store" value="" readonly="readonly">
											</div>
										<div class="form-group">
												<label for="inputName">신뢰점수</label> <input type="text"
													class="form-control" name="subject" id="modalscore"
													value="" readonly="readonly">
										</div>
									</div>
									<div class="col-md-6">
										<img id="reimg" src="" width="200" style="margin-top:20px"/>
									</div>
								</div>
									<div class="form-group">
										<label for="inputContent">작성 내용</label>
										<textarea class="form-control" id="modalcontent" name="content"
											rows="15" cols="15" readonly="readonly">
</textarea>
									</div>
							</div>
						</div>
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