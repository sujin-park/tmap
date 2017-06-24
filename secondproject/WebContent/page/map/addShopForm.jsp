<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<div id="modal_addshopForm" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">매장등록</h4>
      </div>
      <div class="modal-body">
      
		<div class="add-form-container">
			<div class="row">
				<div class="col-xs-12">
					<form id="addShopForm">
						<input type="hidden" name="act" value="addShopAjax" />
						<div class="form-group">
							<label for="addShopCategory">카테고리</label>
							<select name="addShopCategory" id="addShopCategory" class="form-control">
								<option value="">메뉴를 선택해주세요</option>
								<option value="1">한식</option>
								<option value="2">치킨</option>
								<option value="3">중식</option>
								<option value="4">미식</option>
							</select>
						</div>
						
						<div class="form-group">
							<label for="addShopTitle">매장명</label>
							<input type="text" class="form-control" id="addShopTitle" name="addShopTitle" placeholder="매장명을 입력해주세요">
						</div>
						
						<div class="form-group">
							<label for="addShopAddress">주소</label>
							<div class="form-group map2-container">
								<div id="addShopMap"></div>
								<div class="map-search">
									<div class="input-group">
										<input type="text" id="addShopAddress" class="form-control" placeholder="검색할 주소를 입력하세요">
										<span class="input-group-btn">
											<button id="addShopSearchSubmit" class="btn btn-default" type="button">검색</button>
										</span>
									</div>
								</div>
							</div>
							<input type="hidden" id="addShopLat" name="addShopLat" />
							<input type="hidden" id="addShopLng" name="addShopLng" />
							<input type="text" id="addShopAddress1" class="form-control" name="addShopAddress1" placeholder="검색을 이용하여 입력해주세요" readonly>
							<input type="text" id="addShopAddress2" class="form-control" name="addShopAddress2" placeholder="상세주소"/>
						</div>
						
						<div class="form-group">
							<label for="addShopTel">전화번호</label>
							<input type="text" class="form-control" id="addShopTel" name="addShopTel" placeholder="전화번호">
						</div>
						
						<div class="form-group">
							<label for="addShopDetail">메모</label>
							<textarea class="form-control" rows="3" id="addShopDetail" name="addShopDetail" placeholder="휴무일이라던가 메뉴라던가 적고싶은거 적어요"></textarea>
						</div>
	
					</form>
				</div>
			</div>
		</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="addShopSubmit">등록</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->