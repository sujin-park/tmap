<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<div class="page-container">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>리뷰작성</h3>
				<form action="<%=ContextPath.root%>/review" method="post">
					<input type="hidden" name="act" value="write" />
					<input type="hidden" name="shopId" value="1"/>
					
					<div class="form-group">
						<label for="score">점수</label>
						<select name="score" class="form-control" id="score">
							<option>10</option>
							<option>9</option>
							<option>8</option>
							<option>7</option>
							<option>6</option>
							<option>5</option>
							<option>4</option>
							<option>3</option>
							<option>2</option>
							<option>1</option>
							<option>0</option>
						</select>
					</div>
					
					<div class="form-group">
						<label for="title">제목</label>
						<input type="text" name="title" class="form-control" id="title">
					</div>
					
					<div class="form-group">
						<label for="content">내용</label>
						<textarea name="content" id="content" class="form-control"></textarea>
					</div>
					
					<div class="form-group">
						<label for="exampleInputFile">사진</label>
						<input type="file" id="exampleInputFile">
						<p class="help-block">Example block-level help text here.</p>
					</div>
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
</div>