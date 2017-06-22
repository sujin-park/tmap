<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/projecttemp/css/navmenu.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<section class="content">
			<h1>Review</h1>
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">
					<div class="row">
						<div class="pull-left">
							<div class="btn-group">
								<button type="button" class="btn btn-default btn-filter" data-target="pagado">All</button>
								<button type="button" class="btn btn-warning btn-filter" data-target="cancelado">DELETE</button>
							</div>
						</div>
						<div class="pull-right col-md-5">
						
							   <div class="input-group">
      							<input type="text" class="form-control" placeholder="검색어 입력">
      							<span class="input-group-btn">
       							<button class="btn btn-warning" type="button">Search</button>
      							</span>
    					</div>
						</div>
						</div>
						<div class="table-container">
							<table class="table table-filter">
								<tbody>
									<tr class="warning">
										<td>
										Check
										</td>
										<td>
										Email-Id
										</td>
										<td>
										가입일
										</td>
										<td>
										신뢰점수
										</td>
									</tr>
									<tr data-status="pagado">
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox1">
												<label for="checkbox1"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										<td>
											<div class="media">
												<div class="media-body">
													<p class="summary"> 내용 : 정말 너무너무 맛있었습니당 다시 가고싶어요</p>
												</div>
											</div>
										</td>
										<td>
											<span class="media-meta pull-right">Jun 11, 2017</span>
										</td>
									</tr>
									
									
									
									
									
									
									<tr data-status="pendiente">
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox3">
												<label for="checkbox3"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="/projecttemp/doc/bakery.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<span class="media-meta pull-right">Jun 11, 2017</span>
													<h4 class="title">
														매장명 : 폴앤폴리나
														<span class="pull-right pendiente"></span>
													</h4>
													<h4 class="idname">
														회원ID : tnwls0625
													</h4>
													<p class="summary">진짜 추천합니다ㅠㅠㅠㅠㅠㅠㅠ</p>
												</div>
											</div>
										</td>
									</tr>
									<tr data-status="cancelado">
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox2">
												<label for="checkbox2"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="/projecttemp/doc/hyung.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<span class="media-meta pull-right">Jun 12, 2017</span>
													<h4 class="title">
														매장명 : 욘트빌
														<span class="pull-right cancelado"></span>
													</h4>
													<h4 class="idname">
														회원ID : nimrh1k
													</h4>
													<p class="summary">진짜 별로예요 8ㅅ8</p>
												</div>
											</div>
										</td>
									</tr>
									<tr data-status="pagado" class="selected">
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox4" checked>
												<label for="checkbox4"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star star-checked">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<span class="media-meta pull-right">Febrero 13, 2016</span>
													<h4 class="title">
														Lorem Impsum
														<span class="pull-right pagado">(Pagado)</span>
													</h4>
													<p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
												</div>
											</div>
										</td>
									</tr>
									<tr data-status="pendiente">
										<td>
											<div class="ckbox">
												<input type="checkbox" id="checkbox5">
												<label for="checkbox5"></label>
											</div>
										</td>
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<span class="media-meta pull-right">Febrero 13, 2016</span>
													<h4 class="title">
														Lorem Impsum
														<span class="pull-right pendiente"></span>
													</h4>
													<p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="pgnav">	
  					<ul class="pagination">
    				<li>
      					<a href="#" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
     					 </a>
	    				</li>
	    				<li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li><a href="#">6</a></li>
					    <li><a href="#">7</a></li>
					    <li><a href="#">8</a></li>
					    <li><a href="#">9</a></li>
					    <li><a href="#">10</a></li>
	    				<li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
  					</ul>
  					</div>
				<div class="content-footer">
					<p>
						Trust Map  - 2017 <br>
						Powered By <a href="http://www.kitri.re.kr/kitri/main/main.web">Kitri</a>
					</p>
				</div>
			</div>
		</section>
		
	</div>
</div>
<script src="/projecttemp/menu.js"></script>
</body>
</html>