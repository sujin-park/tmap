<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.review.model.AdminReviewDto"%>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
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
									<div class="form-group">
										<label for="inputName">작성자</label> <input type="text"
											class="form-control" name="subject" id="modalsubject"
											value="">
									</div>
									<label for="inputStore"></label>
									<div class="input-group">
										<input type="text" class="form-control" id="store"
											name="store" value="">
										<span class="input-group-btn">
											<button class="btn btn-warning" type="button"
												onclick="">매장
												추가</button>
										</span>
									</div>
									<div class="form-group">
										<label for="inputContent">기획전 설명</label>
										<textarea class="form-control" id="content" name="content"
											rows="15" cols="15">
</textarea>
									</div>
							</div>
						</div>
					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning"
					onclick="javascript:blindReview();">Blind</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>