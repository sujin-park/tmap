<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<div id="modal_addshopForm" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
      
		<div class="add-form-container">
			<div class="row">
				<div class="col-xs-12">
				
					<div class="form-group">
						<label for="title">매장명</label>
						<input type="text" class="form-control" id="title" placeholder="매장명을 입력해주세요">
					</div>
					
					<div class="form-group map2-container">
						<div id="addShopMap"></div>
						<div class="map-search">
							<div class="input-group">
								<input type="text" id="addShopSearchAddress" class="form-control" placeholder="주소를 입력해주세요">
								<span class="input-group-btn">
									<button id="addShopSearchSubmit" class="btn btn-default" type="button">검색</button>
								</span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="address2">주소</label>
						<input type="text" id="address1" class="form-control" name="address1" disabled>
						<input type="text" id="address2" class="form-control" name="address2" />
					</div>
					
					<div class="form-group">
						<label for="detail">메모</label>
						<textarea class="form-control" rows="3" id="detail"></textarea>
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->