<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.*"%>


		<div class="col-xs-9 col-md-9 col-xs-offset-1">


			<h2 class="sub-header">팔로우 관리</h2>

			<div class="form-group form-inline">
				<div class="row">
					<div class="col-xs-6">
						<select
							name="" onchange="" class="form-control">
							<option value="">전체</option>
							<option value="">키트리</option>
							<option value="">한식</option>
							<option value="">내맘대로</option>
						</select>
					</div>
					<div class="col-xs-6">
						<div class="pull-right">
						  <a class="btn btn-default" href="<%=ContextPath.root %>/mypage?act=followCategoryListView" role="button">그룹관리</a>
						  <a class="btn btn-default" href="#" role="button">그룹이동</a>
						  <a class="btn btn-default" href="#" role="button">삭제</a>
						</div>
					</div>
					
				</div>
				<div class="row table-responsive">
				
					<table class="table table-bordered">
				    <thead>
				      <tr>
				        <th><input type="checkbox" name=""></th>
				        <th>카테고리</th>
				        <th>id  |  상태메세지</th>
				        <th>최근후기등록일</th>
				        <th>팔로우한날짜</th>
				        <th>별칭 </th>
				      </tr>
				    </thead>
				    <tbody>
				      <tr>
				        <td><input type="checkbox" name=""></td>
				        <td>키트리</td>
				        <td>did | 졸리다</td>
				        <td>2017-06-16</td>
				        <td>2017-06-15</td>
				        <td>호미니  c</td>
				      </tr>
				      
				    </tbody>
				  </table>
				</div>
				
			</div>
			<div>
				
			</div>
		</div>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="../../assets/js/vendor/holder.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
