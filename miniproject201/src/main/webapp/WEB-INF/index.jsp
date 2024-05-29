<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Spring MVC 게시판</title>
	<title>스프링 게시판</title>	
	<link href="resources/bootstrap/bootstrap.min.css" rel="stylesheet" >
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<script src="resources/js/formcheck.js"></script>
	<script src="resources/js/skill.js"></script>
	<script src="resources/js/member.js"></script>
	<script src="resources/js/change.js"></script>
	
	<!-- <script src="resources/js/member.js"></script> -->
</head>
<body>
	<div class="container">
		<%@ include file="template/header.jsp" %>
		<jsp:include page="${ param.body }" />
	</div>
	
	<!-- 로그인 모달 -->
	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="loginModalLabel" aria-hidden="true"
		data-bs-backdrop="static" data-bs-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="text-center p-2">
					<div class="row">
						<div class="col text-end">
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close" style="width: 5px; height: 5px;"></button>
						</div>
					</div>
					<div class="row">
						<div class="col">
								<h1 class="modal-title fs-5" id="modalLabel">First Served
								로그인</h1>
						</div>
					</div>
				</div>
				<form action="login" method="post">
					<div class="modal-body">
						<div class="mb-3">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="아이디">
						</div>
						<div class="mb-3">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="비밀번호">
						</div>
						<div class="row">
							<div class="col">

								<div class="row">
									<div class="col">
										<input class="form-check-radio-border-radius" type="checkbox"
											value="" id="flexCheckDefault"> <label
											class="form-check-label" for="flexCheckDefault"> 로그인
											상태 유지</label>
									</div>
									<div class="col">
										<div class="form-check form-switch form-check-reverse">
											<input class="form-check-input" type="checkbox"
												id="flexSwitchCheckReverse"> <label
												class="form-check-label" for="flexSwitchCheckReverse">IP
												보안</label>
										</div>
									</div>
								</div>


							</div>
						</div>
					</div>
					<div class="row">
						<div class="col m-2">
							<button type="submit" class="btn btn-outline-primary h-100 w-100">로그인</button>
						</div>
					</div>
					
					<div class = "row">
			<div class = "col d-flex justify-content-center m-3">
			<a class="nav-link " href="#" style="font-size: 10px;">아이디 찾기 |</a> &nbsp;&nbsp;
			<a class="nav-link " href="#" style="font-size: 10px;">비밀번호 찾기 |</a>&nbsp;&nbsp;
			<a class="nav-link " href="joinForm" style="font-size: 10px;">회원가입</a>
			</div>
			</div>

				</form>
			</div>
		</div>
	</div>
    <script src="resources/bootstrap/bootstrap.bundle.min.js"></script>	

</body>
</html>